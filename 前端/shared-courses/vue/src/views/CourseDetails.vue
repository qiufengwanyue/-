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



    <el-container >
      <el-aside width="1100px" style="height: 100%;background-color: #f5f5f5" >
        <el-container style="background-color: #f5f5f5">

          <el-header style="height: 210px">
            <el-container>

              <el-aside style="box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1); border-radius: 5px;width: 250px; background-color: #fff; margin-left: 50px; display: flex;
              justify-content: center; align-items: center;padding-top: 10px;margin-top: 10px">
<!--                <div style="width: 200px; height: 200px; display: flex; justify-content: center; align-items: center;-->
<!--            border-radius: 50%; background-color: white; box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.2);-->
<!--            transition: box-shadow 0.3s ease-in-out;">-->
                <div>
                  <img :src=course[0].cpicture  style="width: 150px; height: 150px; margin: 0;">
                </div>
              </el-aside>

              <el-main style="box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1); border-radius: 5px;background-color: #fff;padding-top: 10px;margin-top: 10px">
                <div style="display: flex; justify-content: space-between;">
<!--                <div style="display: flex; justify-content: space-between;">-->
<!--                  <div style="background-color: #a4c6ee; width: 200px; height: 60px; border-radius: 10px;-->
<!--                  box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.5); display: flex; justify-content: center;-->
<!--                  align-items: center; color: #2a2828; font-size: 20px; font-weight: bold;">-->
<!--                    {{ courseName }}-->
<!--                  </div>-->
                  <span style="flex: 15;font-size: 35px;font-family: '楷体'">{{courseName}}</span>
<!--                  <div style="background-color: #ffffff; width: 60px; height: 50px; border-radius: 10px;-->
<!--                  box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.5); display: flex; justify-content: center;-->
<!--                  align-items: center; color: white; font-size: 20px; font-weight: bold; margin-left: 450px">-->
<!--                    <template>-->
                  <div v-if="power1">
                    <el-button style="flex: 1;font-size: 18px;font-family: '楷体'" type="danger" @click="open" round>举报</el-button>
                    <el-button style="flex: 1;font-size: 18px;font-family: '楷体'" type="danger" @click="empty" round>删除</el-button>
                  </div>
                  <div v-else>
                    <el-button style="flex: 1;font-size: 18px;font-family: '楷体'" type="danger" @click="open" round>举报</el-button>
                  </div>
<!--                      <el-button style="flex: 1" type="text" @click="open" >举报</el-button>-->
<!--                      <el-button style="flex: 1" type="text" @click="empty" >删除</el-button>-->
<!--                    </template>-->
<!--                  </div>-->
                </div>
<!--                </div>-->
                <div style="display: flex;">
                  <div class="custom-scrollbar" style="overflow-y: auto;flex: 15 ; background-color: #fff; width: 720px; height: 120px; font-size: 20px;display: flex;margin-top: 10px">
                    <div  style="flex: 15 ;font-family: '楷体', serif;height: 90px;width: 900px">{{ introduce  }}</div>
                  </div>
                  <div style="flex:3;display: flex;padding-top: 80px;margin-left: 10px">
                    <el-button @click="confirmChooseCourse" round>
                      选课
                    </el-button>
                    <el-button @click="likePost" round>
                      点赞
                    </el-button>
                  </div>
                </div>
                </el-main>
            </el-container>
          </el-header>
          <el-main style="box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1); border-radius: 5px;background-color: #fff;width: 92%;margin-left: 70px;margin-top: 10px">
            <div style="margin-left: 10px;width: 900px; height: 440px; display: flex; flex-direction: column; justify-content: space-between;padding-left: 10px;padding-right: 10px">
              <h2 style="color: #555; font-size: 24px; margin-top: 5px; margin-bottom: 10px;">讨论区</h2>
              <div style="flex: 1; overflow-y: auto; padding: 10px; width: 100%; height: 80%; margin-bottom: 10px;" class="custom-scrollbar">
                <div>
                  <div v-for="(comment, index) in talkUser" v-if="comment.content.trim() !== ''" style="margin-bottom: 20px;">
                    <p style="font-weight: bold; margin-bottom: 5px;"> {{ comment.username }}</p>
                    <p style="color: #666; font-size: 16px; line-height: 1.5; text-indent: 2em; margin-bottom: 10px;">评论内容: {{ comment.content }}</p>
                  </div>
                </div>
              </div>

            <div style="position: relative; width: 100%; height: 80px;">
                <textarea v-model="commentText" placeholder="请输入评论内容" style="position: absolute; top: 0; left: 0; width: 90%; height: 60px; padding: 10px; border: 1px solid #a6cbe3; border-radius: 5px; font-size: 16px; margin-top:10px; background-color: #f5f5f5; color: #333;"></textarea>
                <button style="margin-bottom: 10px ;position: absolute; bottom: 0; right: 0; background-color: #3498db; color: #fff; padding: 10px 20px; border: none; border-radius: 5px; cursor: pointer; transition: background-color 0.3s;" @click="submitComment">提交</button>
              </div>
            </div>
          </el-main>

        </el-container>
      </el-aside>
      <el-main style="background-color: #f5f5f5; height: 700px; margin-right: 50px; padding: 20px;
      border-radius: 10px; display: flex; flex-direction: column; ">

        <!-- 学校信息块 -->
        <div style="background-color: #fff; border-radius: 10px; box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        padding: 20px; color: #7e7575;font-family: '楷体'">
          <span style="margin-bottom: 10px;font-size: 30px">学校信息</span>
          <el-divider></el-divider>
          <div style="font-size: 18px;">{{ccolloge}}</div>
          <div style="font-size: 18px;">教室地点：{{area}}</div>
          <div style="font-size: 18px;">老师：{{teacher }}</div>
        </div>

        <!-- 教室信息块 -->
        <div style="background-color: #fff; border-radius: 10px; box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
         padding: 20px; color:#7e7575;font-family: '楷体';margin-top: 30px">
          <span style="margin-bottom: 10px;font-size: 30px">教室信息</span>
          <el-divider></el-divider>
          <div style="font-size: 18px;">教室容量：{{  course[0].roomnum }}</div>
          <div style="font-size: 18px;">剩余容量：{{ course[0].roomnum - course[0].pernum }}</div>
          <div style="font-size: 18px;">点赞数：{{ course[0].likenum}}</div>
        </div>

        <!-- 上课须知块 -->
        <div style="background-color:#fff; margin-top: 30px; border-radius: 10px;
        box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1); padding: 20px; color: #7e7575; font-family: '楷体'">
          <span style="margin-bottom: 10px;font-size: 30px">上课须知</span>
          <el-divider></el-divider>
          <ul style="list-style-type: none; padding-left: 0;">
            <li style="font-size: 18px;">请准时到达教室</li>
            <li style="font-size: 18px;">关闭手机或调至静音</li>
            <li style="font-size: 18px;">带好所需学习材料</li>
          </ul>
        </div>

      </el-main>

    </el-container>
  </el-container>
</template>
<script>
import {watchSyncEffect} from "vue";

export default {
  data() {
    return {
      test: false,
      circleUrl: 'https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png',
      input: '',
      restaurants: [],
      power1:false,
      power2:false,
      report:'',
      talkUser:[],
      users:[],
      username: '',
      course:[],
      showInput: false,
      commentText: '',
      courseName: '', // 在这里初始化课程名称的数据属性
      talk: [],
      talkContent: '',
      talkUid:'',
      likenum:'',
      pernum:'',
      uid:'',
      cid:'',
      iid:'',
      ranking:'',
      dayOfWeek:'',
      rank:'',
      changeName:'',
      courseNameCI:'',
      TimeTable: {
        uid:'',
        course1: '',
        course2: '',
        course3: '',
        course4: '',
        course5: '',
        course6: '',
        course7: '',
        course8: '',
        course9: '',
        course10: '',
        course11: '',
        course12: '',
        course13: '',
        course14: '',
        course15: '',
        course16: '',
        course17: '',
        course18: '',
        course19: '',
        course20: '',
        course21: '',
        course22: '',
        course23: '',
        course24: '',
        course25: '',
        course26: '',
        course27: '',
        course28: '',
        course29: '',
        course30: '',
        course31: '',
        course32: '',
        course33: '',
        course34: '',
        course35: '',
      },
      user: {
        code: '',
        username: '',
        password: ''
      },
      cpicture:'',
    }
  },


  mounted() {

    console.log(this.cid)
    // 发起初始搜索请求
    this.$request.get('/talk/select/' + this.cid)
        .then(res => {
          if (res && res.data && res.data.length > 0) {
            this.talk = res.data;
            for (let i = 0; i < this.talk.length; i++) {
              let talkContent = this.talk[i].content;
              let talkUid = this.talk[i].uid;

              this.$request.get('/talk/selectByUid/' + talkUid)
                  .then(response => {
                    this.users = response.data;
                    if (this.users.length > 0) {
                      let username = this.users[0].username;
                      let comment = username + "：" + talkContent;
                      this.talkUser.push({
                        username,
                        content: talkContent
                      });
                    }
                  })
                  .catch(error => {
                    console.error('请求评论人发生错误：', error);
                  });
            }
          }
        })
        .catch(error => {
          console.error('获取评论数据发生错误', error);
        });
    // this.$request.post('/login',this.user).then(res=> {
    //   if (res.code === '200') {
    //     this.$router.push('/')
    //     this.$message.success('登录成功')
    //     localStorage.setItem(this.user, JSON.stringify(res.data))//存用户数据
    //     console.log(this.user[0].username);
    //   } else {
    //     this.$message.error(res.msg)
    //   }
    // });




    this.$request.get('/course/selectByMoCid/' + this.cid)
        .then(res => {
          // 在这里处理后端返回的数据
          console.log("从后端获取的数据：", res);
          // 处理数据的逻辑
          this.course=res.data;

        });



      const userData = localStorage.getItem("honey-user");
      const user = JSON.parse(userData);
      console.log("uid:",user.uid)
      this.uid=user.uid;
      console.log("登录用户的uid",this.uid);
      console.log("登录用户的name",user.username);
    if(userData){
      this.test=true;
      const user = JSON.parse(userData);
      this.circleUrl=user.upicture;
      this.username=user.username;};
    if(user.power===1){
      this.power1=true;
    }else {
      if(user.power===2){
        this.power1=true;
        this.power2=true;
      }
    };



    this.$request.get('/time/selectByIid/' + this.iid)
        .then(res => {
          // 确保 res 和 res.data 都存在
          if (res && res.data && res.data.length > 0) {
            // 从后端返回的数据中获取日期字段
            const dateString = res.data[0].date;

            // 确保日期字符串有效后再进行日期对象的处理
            if (dateString) {
              // 输出日期字符串
              console.log("日期字符串:", dateString);

              // 解析日期字符串为日期对象
              const dateObj = new Date(dateString);

              // 输出星期几（0 表示星期日，1 表示星期一，以此类推）
              this.dayOfWeek = dateObj.getDay();
              const dayOfWeek = this.dayOfWeek;
              console.log("星期几:", dayOfWeek);

              const rank=this.rank;
              console.log("----------------------");
              console.log(rank);
              console.log(dayOfWeek);
              console.log("----------------------");


              const dayOfWeekMapping = {
                1: { 1: 'course1', 2: 'course2', 3: 'course3', 4: 'course4', 5: 'course5', 6: 'course6', 0: 'course7' },
                2: { 1: 'course8', 2: 'course9', 3: 'course10', 4: 'course11', 5: 'course12', 6: 'course13', 0: 'course14' },
                3: { 1: 'course15', 2: 'course16', 3: 'course17', 4: 'course18', 5: 'course19', 6: 'course20', 0: 'course21' },
                4: { 1: 'course22', 2: 'course23', 3: 'course24', 4: 'course25', 5: 'course26', 6: 'course27', 0: 'course28' },
                5: { 1: 'course29', 2: 'course30', 3: 'course31', 4: 'course32', 5: 'course33', 6: 'course34', 0: 'course35' }
              };

              const mappingValue = dayOfWeekMapping[rank]?.[dayOfWeek];
              if (mappingValue !== undefined) {
                console.log(mappingValue);
              } else {
                console.log("条件未匹配");
              }
              this.changeName=mappingValue;
              console.log("要修改的名字:",this.changeName);
            } else {
              console.log("无效的日期字符串！");
            }
          } else {
            console.log("未能正确获取后端返回的数据！");
          }
        })
        .catch(error => {
          console.error("获取数据时出现错误:", error);
        });




  },

  created() {
    // 在组件创建时获取路由参数
    const coursename = this.$route.query.coursename;
    const ccolloge = this.$route.query.ccolloge;  //学校
    const area = this.$route.query.area;    //上课地点
    const teacher = this.$route.query.teacher;  //老师
    const introduce = this.$route.query.introduce;  //课程简介
    const roomnum = this.$route.query.roomnum;  //教室容量
    const warn = this.$route.query.warn;  //上课地点
    const reservenum = this.$route.query.reservenum;  //已预约数
    const score = this.$route.query.score;  //评分
    const likenum = this.$route.query.likenum;  //点赞数
    const cid = this.$route.query.cid;
    const iid = this.$route.query.iid;
    const rank= this.$route.query.rank;
    const dayOfWeek= this.$route.query.dayOfWeek;
    const ranking= this.$route.query.ranking;

    // 打印或进行其他操作
    console.log('ID:', coursename);
    console.log('College:', ccolloge);
    console.log('Area:', area);
    console.log('Teacher:', teacher);
    console.log('Introduce:', introduce);
    console.log("教室容量:", roomnum);
    console.log("上课地点:", warn);
    console.log("已预约数:", reservenum);
    console.log("评分:", score);
    console.log("点赞数:", likenum);
    console.log("c序号", cid);
    console.log("i序号", iid);
    console.log("第几节课：", rank);
    console.log("周几：", dayOfWeek);
    console.log("一周的第多少节课：",ranking);

    // 在这里可以根据获取到的参数进行其他操作
    this.courseName=coursename;
    this.ccolloge= ccolloge;
    this.area = area;
    this.teacher = teacher;
    this.introduce = introduce;
    this.roomnum = roomnum;
    this.warn = warn;
    this.reserveNum = reservenum;
    this.score = score;
    this.likeNum = likenum;
    //一些操作
    this.leftoverNum=roomnum-reservenum;
    this.cid=cid;
    this.iid=iid;
    this.rank=rank;
    this.dayOfWeek=dayOfWeek;
    this.ranking=ranking;
  },
  methods: {
    empty(){
      this.$request.post('/course/deletecourse',this.cid).then(res=>{
        if(res.code==='200'){
          this.$router.push('/')
          this.$message.success('删除成功')
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

    goToPersonalCenter() {
      // 使用 Vue Router 实现页面跳转到个人中心
      this.$router.push('/person');
    },
    open() {
      this.$prompt('请输入举报原因', '举报', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
      }).then(({ value }) => {
        if (value !== null) {
          this.report = value + "&&$$" +this.cid;
          this.$request.post('/course/upreport',this.report)
          this.$message({
            type: 'success',
            message: '您的举报信息已反馈!',
          });
        } else {
          this.$message({
            type: 'info',
            message: '取消举报'
          });
        }
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '取消举报'
        });
      });
    },

    showInputBox() {
      this.showInput = true;
    },


    submitComment() {
      // 在这里编写提交评论的逻辑，可以将评论内容保存或发送到后端
      console.log('提交评论:', this.commentText);

      const trimmedComment = this.commentText.substring(0, 100);
      console.log("--------------------------");
      console.log(trimmedComment);
      console.log("用户的uid", this.uid);
      console.log("课程的cid", this.cid);
      console.log("--------------------------");

      this.$request.post('/talk/add', {
        uid: parseInt(this.uid), // 将uid转换为整数类型
        cid: parseInt(this.cid), // 将cid转换为整数类型
        content: trimmedComment.toString(),
      })
          .then(res => {
            if (res.data && res.data.code === 200) {
              // 请求成功
              this.$message.success('评论提交成功');
              // 提交完成后隐藏输入框
            } else if (res.data && res.data.msg) {
              // 接收到错误消息，显示后端返回的错误消息
              this.$message.error(res.data.msg);
            }
            else {
            //   // 接收到无效数据，显示通用错误消息
            this.$message.success('评论提交成功');
            //   this.$message.error('请求出现错误，请稍后重试');
            }
          })
      this.showInput = false;
      this.commentText = '';
      window.location.reload();
            // .catch(error => {
            //   // 捕获请求错误
            //   console.error('Error: ', error);
            //   this.$message.error('请求发生错误，请稍后重试');
            // });
    },

    likePost() {
      if (!this.likeDisabled) {
        console.log('点赞功能已触发');
        this.likeDisabled = true; // 禁用按钮

        this.$request.get('/course/selectByMoCid/' + this.cid)
            .then(res => {
              console.log("从后端获取的数据：", res);
              this.course = res.data;
              this.likenum = this.course[0].likenum;
              console.log("原来的点赞数：", this.likenum);

              this.likenum = this.likenum + 1; // 将点赞数递增
              const count = this.likenum;
              console.log("现在的点赞数：", count);

              this.$request.post('/course/updateLikenum', {
                cid: this.cid,
                likenum: count
              })
                  .then(res => {
                    if (res.code === 200) {
                      // 请求成功
                    } else {
                      // 请求失败，显示错误消息
                    }
                  })
                  .catch(error => {
                    // 捕获请求错误
                    console.error('Error: ', error);
                    this.$message.error('请求发生错误，请稍后重试');
                  })
                  .finally(() => {
                    this.likeDisabled = false; // 请求处理完毕后启用按钮
                  });
            })
            .catch(error => {
              console.error("请求失败：", error);
              this.likeDisabled = false; // 处理失败也需要启用按钮
            });
      }
    },



    // 弹出确认框
    confirmChooseCourse() {
      // 使用浏览器自带的 confirm 方法来创建确认框
      const confirmMessage = '确定要选择该课程吗？';
      if (window.confirm(confirmMessage)) {
        // 如果用户点击了确定，则执行选择课程的函数

        this.TimeTable.uid=this.uid;

        if (this.ranking) {
          this.changeName = "course" + this.ranking;
        }

        //courseName - cid - iid
        // this.courseNameCI = `${this.courseName}-${this.cid}-${this.iid}`;

        console.log(this.changeName);
        console.log(this.courseName);
        console.log(this.uid);

        this.$request.post('/TimeTable/selectByUserUid', { uid: this.uid }).then(res => {
          // 异步请求成功的回调函数
          this.timetable = res.data;
          console.log(this.timetable);

          // 在异步请求成功后再访问 changeName
          console.log(this.changeName);

          // 确保 timetable 存在且不为空
          if (this.timetable && this.timetable.length > 0) {
            // 获取 dynamicChangeName 的值
            const dynamicChangeName = this.changeName; // 假设 dynamicChangeName 是动态变化的变量名

            // 输出 timetable 中第一个对象的 dynamicChangeName 属性值
            if (this.timetable[0][dynamicChangeName] === null && (this.course[0].roomnum - this.course[0].pernum) > 0) {
              console.log("这个课程里面没有数据可以添加课程")
              this.chooseCourse();
            } else if (this.timetable[0][dynamicChangeName] != null) {
              // 如果存在数据，给用户弹出提示框
              // const existingCourseMessage = "当前时间段你有课程，请先去课表删除该时间段的原有课程再选择当前课程";
              // window.alert(existingCourseMessage);
              this.$message.error('当前时间段你有课程，请先去课表删除该时间段的原有课程再选择当前课程');
            } else if ((this.course[0].roomnum - this.course[0].pernum) <= 0) {
              // const existingCourseMessage = "当前课程教室容量已满，请选择其他课程";
              // window.alert(existingCourseMessage);
              this.$message.error('当前课程教室容量已满，请选择其他课程');
            }
          }
        }).catch(error => {
          // 异步请求失败时的处理
          console.error('Error fetching data:', error);
        });
      } else {
        // 如果用户点击了取消，则不执行任何操作
        return;
      }
    },

    chooseCourse() {
      console.log('课程已选择');
      this.TimeTable.uid=this.uid;


      if (this.ranking) {
        this.changeName = "course" + this.ranking;
      }

      //courseName - cid - iid
      // this.courseNameCI = `${this.courseName}-${this.cid}-${this.iid}`;

      console.log(this.changeName);
      console.log(this.courseName);
      console.log(this.uid);




      this.$request.post('/TimeTable/update', {
        changeName: this.changeName.toString(),
        course: this.courseName .toString(),
        uid: this.uid
      })
          .then(res => {

              this.$message.success('选课成功');

          })
          .catch(error => {
            // 捕获请求错误
            console.error('Error: ', error);
            this.$message.error('请求发生错误，请稍后重试');
          });


      this.$request.get('/course/selectByMoCid/' + this.cid)
          .then(res => {
            console.log("从后端获取的数据：", res);
            this.course = res.data;
            this.pernum = this.course[0].pernum;
            console.log("原来的上课人数：", this.pernum );

            this.pernum = this.pernum  + 1; // 将点赞数递增
            const count = this.pernum ;
            console.log("现在的上课人数：", count);

            this.$request.post('/course/updatePernum', {
              cid: this.cid,
             pernum: count
            })
                .then(res => {
                  if (res.code === 200) {
                    // 请求成功
                  } else {
                    // 请求失败，显示错误消息

                  }
                })
                .catch(error => {
                  // 捕获请求错误
                  console.error('Error: ', error);
                  this.$message.error('请求发生错误，请稍后重试');
                });
          })
          .catch(error => {
            console.error("请求失败：", error);
          });

  },




  },



}
</script>


<style>
.custom-scrollbar {
  scrollbar-width: none;
  -ms-overflow-style: none;
}

.custom-scrollbar::-webkit-scrollbar {
  display: none;
}
.scrollable-container {
  -ms-overflow-style: none; /* 对于IE和Edge */
  //height: 580px;
  overflow-y: scroll;
}
</style>
