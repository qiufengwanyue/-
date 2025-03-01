<template >
  <div class="login-container">
    <form class="login-form">
      <h1>登录</h1>
      <div class="form-row">
        <label for="username" class="label">用户名</label>
        <el-input placeholder="请输入账号" v-model="username" clearable></el-input>
      </div>
      <div class="form-row">
        <label for="password" class="label">密码</label>
        <el-input placeholder="请输入密码" v-model="password" show-password></el-input>
      </div>
      <button @click="login" class="login-button">登录</button>
      <h2 class="no-account">没有账号？
      <button @click="enrol" class="enrol-button">注册</button></h2>
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      username: '',
      password: ''
    };
  },
  methods: {
    login() {
      // 登录操作


    },
    enrol() {
      this.$router.push({ name: 'register' });
    }

  }
};
</script>

<style>

h1{
  font-size: 30px;
  font-weight: 500;
}

.login-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
}

.login-form {
  text-align: center;
  padding: 20px;
  border: none;
  border-radius: 5px;
}

.form-row {
  margin-bottom: 15px;
  display: flex;
  align-items: center;
}

.label {
  width: 80px;
  text-align: right;
  margin-right: 10px;
  font-family: "微软雅黑";
  font-weight: 400;
}

.login-button {
  background-color: #5c8dc2;
  color: #fff;
  padding: 8px 25px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  font-size: 16px;
}
.el-input {
  flex: 1;
}

h2 {
  font-size: 10px;
  font-weight: 300;
}
.enrol-button{
  border: none;
  color: #5c8dc2;
  font-size: 10px;
}
</style>
