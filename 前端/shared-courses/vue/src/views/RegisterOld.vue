<template>
  <div>
    <div style="margin-top: 50px;margin-left: 200px;margin-right: 300px"><h1>课程共享注册页面</h1></div>
    <div style="margin-top: 50px;margin-left: 200px;margin-right: 300px">
      <el-form ref="form" :model="form" label-width="80px">
        <el-form-item label="用户名 ">
          <el-input v-model="form.username" placeholder="必填"></el-input>
        </el-form-item>
        <el-form-item label="密    码">
          <el-input v-model="form.password" placeholder="必填"></el-input>
        </el-form-item>
        <el-form-item label="昵    称">
          <el-input v-model="form.age"></el-input>
        </el-form-item>
        <el-form-item label="手机号码">
          <el-input v-model="form.grade"></el-input>
        </el-form-item>
<!--        <el-form-item label="性   别">-->
<!--          <el-radio-group v-model="form.Gender">-->
<!--            <el-radio label="男"></el-radio>-->
<!--            <el-radio label="女"></el-radio>-->
<!--          </el-radio-group>-->
<!--        </el-form-item>-->
        <el-form-item label="收货地址">
          <el-input v-model="form.Ucolloge"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="onSubmit">立即注册</el-button>
          <el-button>取消</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
import {MessageBox} from "element-ui";
import axios from "axios";

export default {
  data() {
    return {
      form: {
        username: '',
        password: '',
        age: '',
        grade: '',
        // Gender: '',
        Ucolloge: '',
      }
    }
  },
  methods: {
    onSubmit() {
      if (this.form.username && this.form.password) {
        // 如果Username和Password不为空
        axios.post('http://localhost:8080/user/add', this.form)
        MessageBox.alert('注册成功', '提示', {
          confirmButtonText: '确定',
          callback: () => {
            // 处理确定按钮的回调逻辑
            // 例如返回主页面
            this.$router.push('/');
          }
        });
      }else {
        MessageBox.alert('用户名和密码不能为空', '提示', {
          confirmButtonText: '确定',})
      }
    }
  }
}
</script>
