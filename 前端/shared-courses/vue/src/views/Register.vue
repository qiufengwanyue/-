<template>
  <div style="height: 100vh;display: flex;align-items: center;justify-content: center;background-color: #0f6d98">
    <div style="display: flex;background-color: white;width: 50%;border-radius: 6px;height: 50%">
      <div style="flex: 1;">
        <img src="@/assets/css/read.png" alt="" style="width: 100%;height: 395px">
      </div>
      <div style="flex: 1;display: flex;align-items: center;justify-content: center;">
        <el-form :model="user" style="width: 80%" :rules="rules" ref="registerRef">
          <div style="font-size: 20px;font-weight: bold;text-align: center;margin-bottom: 20px">欢迎注册课程共享平台</div>
          <el-form-item prop="username">
            <el-input prefix-icon="el-icon-user" size="medium" placeholder="请输入账号" v-model="user.username"></el-input>
          </el-form-item>
          <el-form-item prop="password">
            <el-input prefix-icon="el-icon-lock" size="medium" show-password placeholder="请输入密码" v-model="user.password"></el-input>
          </el-form-item>
          <el-form-item prop="confirmPassword">
            <el-input prefix-icon="el-icon-lock" size="medium" show-password placeholder="请确认密码" v-model="user.confirmPassword"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" style="width: 100%" @click="register">注 册</el-button>
          </el-form-item>
          <div style="display: flex">
            <div style="flex: 1">
              已有账号？ 请<span style="color: #0f9876;cursor: pointer" @click="$router.push('/login')">登录</span>
            </div>
          </div>
        </el-form>
      </div>
    </div>

  </div>
</template>

<script>

export default {
  name: "Register",
  data(){
    const validatePassword = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请确认密码'));
      } else if (value !== this.user.password) {
        callback(new Error('两次输入密码不一致!'));
      } else {
        callback();
      }
    };
    // const validatePassword = (rule, confirmPass, callback) => {
    //   if (confirmPass === '') {
    //     callback(new Error('请确认密码'))
    //   } else if(confirmPass!==this.user.password) {
    //     callback(new Error('两次输入的密码不一致'))
    //   }else {
    //     callback()
    //   }
    // }
    return {
      user: {
        username: '',
        password: '',
        confirmPassword:''
      },
      rules: {
        username: [
          { required: true, message: '请输入账号', trigger: 'blur' },
        ],
        password: [
          { required: true, message: '请输入密码', trigger: 'blur' },
        ],
        confirmPassword: [
          { validator: validatePassword, trigger: 'blur' }
        ],
      }
    }
  },
  methods:{
    register(){
      this.$refs["registerRef"].validate((valid) => {
        if(valid){
          //验证通过
          this.$request.post('/user/add',this.user).then(res=>{
            if(res.code==='200'){
              this.$router.push('/login')
              this.$message.success('注册成功')
              localStorage.setItem("honey-user",JSON.stringify(res.data))//存用户数据
            }else {
              this.$message.error(res.msg)
            }
          })
        }
          })
    },
  }
}
</script>

<style>

</style>
