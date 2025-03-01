<template>
  <el-container>
    <el-header style="height: 80px;background-color: #fff;">
      <el-row type="flex" class="nav-row" justify="space-between">
        <el-col :span="8" >
          <div class="grid-content bg-purple" style="margin-top: 15px">
            <img src="../assets/css/logo.png" class="logo">
          </div>
        </el-col>
        <el-col :span="16">
          <div v-if="test">
            <el-dropdown style="margin-left: 800px;margin-top: 5px">
              <div  style="display: flex;margin-top: 10px">
                <el-avatar :size="50" :src="circleUrl"></el-avatar>
                <span style="margin-top: 10px;margin-left: 10px;font-size: 25px;font-family: '楷体', 'KaiTi', 'STKaiti', 'SimSun', 'AR PL UKai CN', 'AR PL UKai TW', serif;">{{username}}</span>
              </div>
              <el-dropdown-menu slot="dropdown">
                <el-dropdown-item icon="el-icon-s-home"><el-link href="/person" target="_self" style="margin-right: 20px;font-weight: 1000;font-size: 15px;">个人中心</el-link></el-dropdown-item>
                <el-dropdown-item icon="el-icon-caret-top"><el-link href="/login" target="_self" style="font-weight: 1000;font-size: 15px;" >登 录</el-link></el-dropdown-item>
                <el-dropdown-item icon="el-icon-caret-bottom"><el-link @click="logout" target="_self" style="font-weight: 1000;font-size: 15px;" >退出登录</el-link></el-dropdown-item>
              </el-dropdown-menu>
            </el-dropdown>
          </div>
          <div v-else>
            <el-dropdown style="margin-left: 800px;margin-top: 5px">
              <div  style="display: flex;margin-top: 10px">
                <el-avatar :size="50" :src="circleUrl"></el-avatar>
                <span style="margin-top: 10px;margin-left: 10px;font-size: 25px;font-family: '楷体', 'KaiTi', 'STKaiti', 'SimSun', 'AR PL UKai CN', 'AR PL UKai TW', serif;">{{username}}</span>
              </div>
              <el-dropdown-menu slot="dropdown">
                <el-dropdown-item icon="el-icon-circle-plus"><el-link href="/login" target="_self" style="font-weight: 1000;font-size: 15px;" >登 录</el-link></el-dropdown-item>
              </el-dropdown-menu>
            </el-dropdown>
          </div>
        </el-col>
      </el-row>
    </el-header>


    <el-container>
      <el-aside width="1100px"  style="background-color: #f5f5f5;height: 690px">
        <div style="margin-left: 50px;margin-right: 50px;margin-top: 10px; background-color: white;display: flex;">
          <div style="margin-left: 50px">
            <el-upload
                class="avatar-uploader"
                action="http://localhost:8080/file/upload"
                :show-file-list="false"
                :on-success="handleAvatarSuccess"
                :before-upload="beforeAvatarUpload">
              <img v-if="imageUrl" :src="imageUrl" class="avatar">
              <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            </el-upload>
          </div>
          <div>
            <el-form style="margin-left: 10px">
              <el-form-item style="margin-top: 10px;" prop="coursename">
                <div style="display: flex">
                  <div style="flex: 1">
                    <span>课程名称</span>
                  </div>
                  <div style="flex: 5;text-align: right;color: #0f9876;cursor: pointer">
                    <el-input prefix-icon="el-icon-reading" size="medium" placeholder="请输入课程名称" v-model="coursetime.coursename"></el-input>
                  </div>
                </div>
              </el-form-item>
              <el-form-item style="margin-top: 10px;" prop="teacher">
                <div style="display: flex">
                  <div style="flex: 1">
                    <span>任课教师</span>
                  </div>
                  <div style="flex: 5;text-align: right;color: #0f9876;cursor: pointer">
                    <el-input prefix-icon="el-icon-user" size="medium" placeholder="请输入任课教师" v-model="coursetime.teacher"></el-input>
                  </div>
                </div>
              </el-form-item>
              <el-form-item label="上课地点" style="margin-bottom: 0;">
                <el-row style="display: flex">
                  <el-col style="flex: 1;margin-left: 10px">
                    <el-form-item prop="Ccolloge">
                      <el-input prefix-icon="el-icon-position" size="medium" placeholder="请输入上课学校" v-model="coursetime.ccolloge"></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col style="flex: 1;margin-left: 30px">
                    <el-form-item prop="area">
                      <el-input prefix-icon="el-icon-position" size="medium" placeholder="请输入上课教室" v-model="coursetime.area"></el-input>
                    </el-form-item>
                  </el-col>
                </el-row>
              </el-form-item>
            </el-form>
          </div>
        </div>
        <div style="margin-left: 50px;margin-right: 50px;background-color: white;display: flex;">
          <el-form style="margin-top: 10px;margin-left: 50px;white-space: nowrap;" ref="updateRef">
            <el-form-item style="margin-top: 10px;" prop="pernum">
              <div style="display: flex">
                <div style="flex: 1">
                  <span>上课人数</span>
                </div>
                <div style="flex: 3;text-align: right;color: #0f9876;cursor: pointer;">
                  <el-input prefix-icon="el-icon-s-check" size="medium" placeholder="请输入上课人数" v-model="coursetime.pernum"></el-input>
                </div>
                <div style="flex: 1;margin-left: 100px;">
                  <span>教室容量</span>
                </div>
                <div style="flex: 3;text-align: right;color: #0f9876;cursor: pointer;margin-right: 150px">
                  <el-input prefix-icon="el-icon-s-home" size="medium" placeholder="请输入教室容量" v-model="coursetime.roomnum"></el-input>
                </div>
              </div>
            </el-form-item>
            <el-form-item>
                <div style="display: flex">
                  <div class="block" style="flex: 1;">
                    <span class="demonstration" style="margin-right: 15px">选择日期</span>
                    <el-date-picker
                        type="dates"
                        value-format="yyyy-MM-dd"
                        v-model="dayif"
                        placeholder="选择一个或多个日期">
                    </el-date-picker>
                  </div>
                  <div class="block" style="flex: 1;margin-right: 150px">
                    <span style="margin-left: 50px;margin-right: 15px">选择课时</span>
                    <el-select v-model="coursetime.rank" placeholder="请选择" >
                      <el-option
                          v-for="item in options"
                          :key="item.value"
                          :label="item.label"
                          :value="item.value">
                      </el-option>
                    </el-select>
                  </div>
                </div>
            </el-form-item>
            <el-form-item>
              <div style="display: flex">
                <div class="block" style="flex: 1;">
                  <span class="demonstration" style="margin-right: 10px">分类1</span>
                  <template>
                    <el-select v-model="coursetime.sort1" placeholder="请选择">
                      <el-option
                          v-for="item in optionsSort1"
                          :key="item.value"
                          :label="item.label"
                          :value="item.value">
                      </el-option>
                    </el-select>
                  </template>
                </div>
                <div class="block" style="flex: 1;">
                  <span class="demonstration" style="margin-right: 10px">分类2</span>
                  <template>
                    <el-select v-model="coursetime.sort2" placeholder="请选择">
                      <el-option
                          v-for="item in optionsSort2"
                          :key="item.value"
                          :label="item.label"
                          :value="item.value">
                      </el-option>
                    </el-select>
                  </template>
                </div>
                <div class="block" style="flex: 1;">
                  <span class="demonstration" style="margin-right: 10px">分类3</span>
                  <template>
                    <el-select v-model="coursetime.sort3" placeholder="请选择">
                      <el-option
                          v-for="item in optionsSort3"
                          :key="item.value"
                          :label="item.label"
                          :value="item.value">
                      </el-option>
                    </el-select>
                  </template>
                </div>
              </div>
            </el-form-item>
            <el-form-item>
              <div><span style="font-size: 20px">课程简介</span></div>
              <el-input
                  style="font-family: Arial, sans-serif; font-size: 18px;"
                  type="textarea"
                  :rows="4"
                  placeholder="请输入课程简介"
                  v-model="coursetime.introduce">
              </el-input>
            </el-form-item>
            <el-form-item>
              <div><span style="font-size: 20px">注意事项</span></div>
              <el-input
                  style="font-family: Arial, sans-serif; font-size: 18px;"
                  type="textarea"
                  :rows="3"
                  placeholder="请输入注意事项"
                  v-model="coursetime.warn">
              </el-input>
              <el-button @click="update" style="margin-left: 30px">上传<i class="el-icon-upload el-icon--right"></i></el-button>
            </el-form-item>
          </el-form>
        </div>
      </el-aside>
      <el-main style="background-color: #f5f5f5;height: 690px;padding: 0;">
        <div style="background-color: #fff;margin-top: 10px;height: 680px">
          <span style="margin-left:10px;font-size: 30px;font-family: '楷体', 'KaiTi', 'STKaiti', 'SimSun', 'AR PL UKai CN', 'AR PL UKai TW', serif;">上传课程须知：</span><br><br>
          <span style="margin-left:10px;font-size: 20px;font-family: '楷体', 'KaiTi', 'STKaiti', 'SimSun', 'AR PL UKai CN', 'AR PL UKai TW', serif;">一：好好学习</span><br>
          <span style="margin-left:10px;font-size: 20px;font-family: '楷体', 'KaiTi', 'STKaiti', 'SimSun', 'AR PL UKai CN', 'AR PL UKai TW', serif;">二：天天向上</span><br>
          <span style="margin-left:10px;font-size: 20px;font-family: '楷体', 'KaiTi', 'STKaiti', 'SimSun', 'AR PL UKai CN', 'AR PL UKai TW', serif;">三：拒绝娱乐</span><br>
          <span style="margin-left:10px;font-size: 20px;font-family: '楷体', 'KaiTi', 'STKaiti', 'SimSun', 'AR PL UKai CN', 'AR PL UKai TW', serif;">四：抛弃游戏</span><br>
        </div>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
export default {
  data() {
    return {
      test: false,
      circleUrl: 'https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png',
      input: '',
      restaurants: [],
      username:'',
      imageUrl: '',
      dayif:'',
      coursetime:{
        uid:'',
        coursename:'',
        teacher:'',
        ccolloge:'',
        area:'',
        pernum:'',
        roomnum:'',
        introduce:'',
        warn:'',
        date: '',
        rank: '',
        day:'',
        cpicture:'',
        sort1:'',
        sort2:'',
        sort3:'',
      },
      optionsSort1: [{
        value: '选项1',
        label: '公共基础课'
      }, {
        value: '选项2',
        label: '专业必修课'
      }, {
        value: '选项3',
        label: '专业选修课'
      }],
      optionsSort2: [{
        value: '选项1',
        label: '文史哲学'
      }, {
        value: '选项2',
        label: '社会科学'
      }, {
        value: '选项3',
        label: '理工类'
      }, {
        value: '选项4',
        label: '经济管理'
      }, {
        value: '选项5',
        label: '外语'
      },{
        value: '选项六',
        label: '艺术类'
      }],
      optionsSort3: [{
        value: '选项1',
        label: '讲师'
      }, {
        value: '选项2',
        label: '副教授'
      },{
        value: '选项3',
        label: '教授'
      }],
      options: [{
        value: '1',
        label: '1-2节课'
      }, {
        value: '2',
        label: '3-4节课'
      }, {
        value: '3',
        label: '5-6节课'
      }, {
        value: '4',
        label: '7-8节课'
      }, {
        value: '5',
        label: '9-10节课'
      }],
    }
  },
  methods:  {
    handleAvatarSuccess(res, file) {
      this.imageUrl = URL.createObjectURL(file.raw);
      this.coursetime.cpicture=res.data;
      console.log(this.coursetime.cpicture)
    },
    beforeAvatarUpload(file) {
      const isJPG = file.type === 'image/jpeg';
      const isLt10M = file.size / 1024 / 1024 < 10;

      if (!isJPG) {
        this.$message.error('上传头像图片只能是 JPG 格式!');
      }
      if (!isLt10M) {
        this.$message.error('上传头像图片大小不能超过 10MB!');
      }
      return isJPG && isLt10M;
    },
    update(){
      if(this.dayif.length>0){this.coursetime.date=this.dayif.join('#')}
      this.coursetime.day=this.dayif.length
      console.log(this.coursetime.date)
      console.log(this.coursetime)
      this.$request.post('/course/update',this.coursetime).then(res=>{
        if(res.code==='200'){
          this.$router.push('/')
          this.$message.success('上传成功成功')
          // localStorage.setItem("honey-user",JSON.stringify(res.data))//存用户数据
        }else {
          this.$message.error(res.msg)
        }
      })
    },
    logout(){
      // 清空特定键的存储项
      localStorage.removeItem("honey-user");
      this.$router.push('/login')
    },
  },
  mounted(){
    const userData = localStorage.getItem("honey-user");
    const user = JSON.parse(userData);
    console.log(user.uid)
    this.coursetime.uid=user.uid;
    console.log("adc");
    if(userData){
      this.test=true;
      const user = JSON.parse(userData);
      this.circleUrl=user.upicture;
      this.username=user.username;}
  }
}
</script>

<style>
.avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}
.avatar-uploader .el-upload:hover {
  border-color: #409EFF;
}
.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 178px;
  height: 178px;
  line-height: 178px;
  text-align: center;
}
.avatar {
  width: 178px;
  height: 178px;
  display: block;
}
</style>
