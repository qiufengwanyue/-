package com.example.sharecoursebehind.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.http.server.HttpServerResponse;
import com.example.sharecoursebehind.common.Result;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/file")
public class FileController {
    @Value("${ip:localhost}")
    String ip;
    @Value("${server.port:8080}")
    String port;
//    @AuthAccess
    private  static final String ROOT_PATH = System.getProperty("user.dir")+File.separator + "files";
    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        String mainName = FileUtil.mainName(originalFilename);
        String extName = FileUtil.extName(originalFilename);
        File parentFile = new File(ROOT_PATH);
        if (!parentFile.exists()) {
            parentFile.mkdirs(); // 使用mkdirs()确保创建整个路径中的所有父文件夹
        }

        String fileName = originalFilename;//实际的文件名称
        File saveFile = new File(ROOT_PATH + File.separator + originalFilename);
        if (saveFile.exists()) {
            originalFilename = System.currentTimeMillis() + mainName + "." + extName;
            saveFile = new File(ROOT_PATH + File.separator + originalFilename);
        }

        file.transferTo(saveFile);
        String url = "http://" + ip + ":" + port + "/file/download/" + originalFilename;
        return Result.success(url);//返回文件的连接即下载地址
    }

    @GetMapping("/download/{filename}")
    public void download(@PathVariable String filename , HttpServletResponse response) throws IOException {
        String filePath = ROOT_PATH + File.separator + filename;
        if(!FileUtil.exist(filePath)){
            return;
        }
        byte[] bytes = FileUtil.readBytes(filePath);
        ServletOutputStream outputStream=response.getOutputStream();
        outputStream.write(bytes);
        outputStream.flush();
        outputStream.close();
    }
}


