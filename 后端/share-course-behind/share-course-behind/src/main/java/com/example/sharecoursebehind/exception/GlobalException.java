package com.example.sharecoursebehind.exception;

import com.example.sharecoursebehind.common.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalException {         //自定义一个异常
    @ExceptionHandler(ServiceException.class)
    @ResponseBody  //把Result转化为json
    public Result serviceException(ServiceException e){
        return Result.error("500",e.getMessage());
    }
}
