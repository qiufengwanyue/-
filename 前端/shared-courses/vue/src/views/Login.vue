<template>
  <div style="height: 100vh;display: flex;align-items: center;justify-content: center;background-color: #0f9876">
    <div style="display: flex;background-color: white;width: 50%;border-radius: 6px;height: 50%">
      <div style="flex: 1;">
        <img src="@/assets/css/read.png" alt="" style="width: 100%;height: 395px">
      </div>
      <div style="flex: 1;display: flex;align-items: center;justify-content: center;">
        <el-form :model="user" style="width: 80%" :rules="rules" ref="loginRef">
          <div style="font-size: 20px;font-weight: bold;text-align: center;margin-bottom: 20px">欢迎登录课程共享平台</div>
          <el-form-item prop="username">
            <el-input prefix-icon="el-icon-user" size="medium" placeholder="请输入账号" v-model="user.username"></el-input>
          </el-form-item>
          <el-form-item prop="password">
            <el-input prefix-icon="el-icon-lock" size="medium" show-password placeholder="请输入密码" v-model="user.password"></el-input>
          </el-form-item>
          <el-form-item prop="code">
            <div style="display: flex">
              <el-input prefix-icon="el-icon-check" size="medium" style="flex: 1" placeholder="请输入验证码" v-model="user.code"></el-input>
              <div style="flex: 1;text-align: right;">
                <valid-code @update:value="getCode"></valid-code>
              </div>
            </div>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" style="width: 100%" @click="login">登 录</el-button>
          </el-form-item>
          <div style="display: flex">
            <div style="flex: 1">
              还没有账号？ 请<span style="color: #0f9876;cursor: pointer" @click="$router.push('/register')">注册</span>
            </div>
            <div style="flex: 1;text-align: right;color: #0f9876;cursor: pointer">
              忘记密码
            </div>
          </div>
        </el-form>
      </div>
    </div>

  </div>
</template>

<script>
import ValidCode from "@/components/ValidCode.vue";

export default {
  name: "Login",
  components:{
    ValidCode
  },
  data(){
    const validateCode = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入验证码'))
      } else if(value.toLowerCase()!==this.code) {
        callback(new Error('验证码错误'))
      }else {
        callback()
      }
    }

    return {
      code: '',
      user: {
        code: '',
        username: '',
        password: ''
      },
      rules: {
        username: [
          { required: true, message: '请输入账号', trigger: 'blur' },
        ],
        password: [
          { required: true, message: '请输入密码', trigger: 'blur' },
        ],
        code: [
          { validator: validateCode, trigger: 'blur' }
        ],
      }
    }
  },
  methods:{
    login(){
      this.$refs["loginRef"].validate((valid) => {
        if(valid){
          //验证通过
          this.$request.post('/login',this.user).then(res=>{
            if(res.code==='200'){
              this.$router.push('/')
              this.$message.success('登录成功')
              localStorage.setItem("honey-user",JSON.stringify(res.data))//存用户数据

            }else {
              this.$message.error(res.msg)
            }
          })
        }
          })
    },
    getCode(code){
      this.code=code.toLowerCase()
    }
  }
}
</script>

<style>

</style>
