<template>
  <div>
    <el-container>

      <el-header style="height: 80px;background-color: #fff;">
        <el-row type="flex" class="nav-row" justify="space-between">
          <el-col :span="8" >
            <div class="grid-content bg-purple" >
              <img src="../assets/css/logo.png" class="logo">
            </div>
          </el-col>
          <el-col :span="16">
<!--            <div class="grid-content bg-purple">-->
<!--              <div class="nav-links">-->
<!--                  <el-link href="/person" target="_self" style="margin-right: 20px;font-weight: 1000;font-size: 15px;">-->
<!--                    个人中心-->
<!--                  </el-link>-->
<!--                  <el-link href="/login" target="_self" style="font-weight: 1000;font-size: 15px;" >登录</el-link>-->
<!--                  <button @click="logout" style=" margin-right: 20px;font-weight: 1000;font-size: 15px;" >退出登录</button>-->
<!--              </div>-->
<!--            </div>-->
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






      <el-main  class="search">
        <div style="margin-top: 50px">
          <section  class="cloud-bed">
            <div class="cloud-box">
            <span
              v-for="(item, index) in dataList"
              :key="index"
              @click="getDataInfo(item)"
              :style="{color:item.color,background:item.bgColor}"
            >
              {{ item.name }}
            </span>
            </div>
          </section>
        </div>


        <div class="search-box" >
          <el-autocomplete
              class="input-with-select"
              v-model="input"
              :fetch-suggestions="querySearch"
              placeholder="请输入内容"
              :trigger-on-focus="false"
              @select="handleSelect"
              clearable
              style="padding: 10px;font-size: 16px;margin-top: 150px;width: 600px"
              @keydown.native.enter="handleEnter"> <!-- 添加键盘事件监听器，监听 Enter 键的按下事件 -->
            <el-button
                class="search-button"
                slot="append"
                icon="el-icon-search"
                @click="search"
                style="padding: 10px 10px;border: none;cursor: pointer;width: 100px">
              搜索</el-button>
          </el-autocomplete>
        </div>
      </el-main>




      <el-footer  class="footer" >
        <el-row>
          <el-col :span="8"><div>
            <div class="upload-the-course" style="justify-content: center;align-items: center;">
              <span style="font-size: 35px;font-family: '楷体', 'KaiTi', 'STKaiti', 'SimSun', 'AR PL UKai CN', 'AR PL UKai TW', serif;" class="upload" @click="handleUpload">上传课程</span>
            </div>
          </div></el-col>
          <el-col :span="8" >
            <div class="communicate-together" style="justify-content: center;align-items: center;">
            <span style="font-size: 35px;font-family: '楷体', 'KaiTi', 'STKaiti', 'SimSun', 'AR PL UKai CN', 'AR PL UKai TW', serif;">共同交流</span>
          </div></el-col>
          <el-col :span="8">
            <div class="upload-the-course" style="display: flex; justify-content: center;align-items: center;">
              <el-popover
                  placement="top-start"
                  title="联系我们"
                  trigger="hover"
                  content="联系我们请加联系111111">
                <span style="font-size: 35px;font-family: '楷体', 'KaiTi', 'STKaiti', 'SimSun', 'AR PL UKai CN', 'AR PL UKai TW', serif;" slot="reference" class="contact" >联系我们</span>
              </el-popover>

            </div></el-col>
        </el-row>
      </el-footer>
    </el-container>
  </div>
</template>






<script>
import request from "@/utils/request";

export default {
  name: 'HomeView',
  data() {
    return {
      timer: 50, // 球体转动速率
      radius: 0, // 词云球体面积大小
      dtr: Math.PI/180, //鼠标滑过球体转动速度
      active: false, // 默认加载是否开启转动
      lasta: 0, // 上下转动
      lastb: 0.5, // 左右转动
      distr: true,
      tspeed: 0, // 鼠标移动上去时球体转动
      mouseX: 0,
      mouseY: 0,
      tagAttrList: [],
      tagContent: null,
      cloudContent: null,
      sinA: '',
      cosA: '',
      sinB: '',
      cosB: '',
      sinC: '',
      cosC: '',
      dataList: [
        {
          name: '线下课程',
          value: '1',
          bgColor:'rgb(57, 193, 207,0.12)',
          color:'#39c1cf',
        },
        {
          name: '同城共享',
          value: '8',
          bgColor:'rgb(66, 105, 245,0.12)',
          color:'#4269f5',
        },
        {
          name: '个性计划',
          value: '9',
          bgColor:'rgb(184, 107, 215,0.12)',
          color:'#b86bd7',
        },
        {
          name: '电子课表',
          value: '3',
          bgColor:'rgb(243, 84, 83,0.12)',
          color:'#f35453',
        },
        {
          name: '全民参与',
          value: '6',
          bgColor:'rgb(250, 116, 20,0.12)',
          color:'#FA7414',
        },
        {
          name: '实时互动',
          value: '10',
          bgColor:'rgb(255, 171, 30,0.12)',
          color:'#FFAB1E',
        },
        {
          name: '知识拓展',
          value: '2',
          bgColor:'rgb(136, 104, 217,0.12)',
          color:'#8868D9',
        },
        {
          name: '课程灵活',
          value: '5',
          bgColor:'rgb(42, 184, 230,0.12)',
          color:'#2AB8E6',
        },
        {
          name: '数据可靠',
          value: '7',
          bgColor:'rgb(117, 133, 162,0.12)',
          color:'#7585A2',
        },
      ],
      test: false,
      circleUrl: 'https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png',
      input: '',
      restaurants: [],
      username:'',
    }
  },
  methods: {


    // 获取点击文本信息
    getDataInfo (item) {
      console.log(item, 'item')
    },
    initWordCloud () {
      this.cloudContent = document.querySelector('.cloud-box');
      this.tagContent = this.cloudContent.getElementsByTagName('span');
      for (let i = 0; i < this.tagContent.length; i++) {
        let tagObj = {};
        tagObj.offsetWidth = this.tagContent[i].offsetWidth;
        tagObj.offsetHeight = this.tagContent[i].offsetHeight;
        this.tagAttrList.push(tagObj);
      }
      this.sineCosine(0, 0, 0);
      this.positionAll();
      // this.cloudContent.onmouseover = () => {
      //   this.active=true;
      // };
      // this.cloudContent.onmouseout = () => {
      //   this.active=false;
      // };
      this.cloudContent.onmousemove = (ev) => {
        let oEvent = window.event || ev;
        this.mouseX = oEvent.clientX - (this.cloudContent.offsetLeft + this.cloudContent.offsetWidth/2);
        this.mouseY = oEvent.clientY - (this.cloudContent.offsetTop + this.cloudContent.offsetHeight/2);
        this.mouseX/= 5;
        this.mouseY/= 5;
      };
      setInterval(this.update, this.timer);
    },
    positionAll () {
      let phi = 0;
      let theta = 0;
      let max = this.tagAttrList.length;
      let aTmp = [];
      let oFragment = document.createDocumentFragment();
      //随机排序
      for (let i=0; i < this.tagContent.length; i++) {
        aTmp.push(this.tagContent[i]);
      }
      aTmp.sort(() => {
        return Math.random() < 0.5 ? 1 : -1;
      });
      for (let i = 0; i < aTmp.length; i++) {
        oFragment.appendChild(aTmp[i]);
      }
      this.cloudContent.appendChild(oFragment);
      for(let i = 1; i < max + 1; i++){
        if (this.distr) {
          phi = Math.acos(-1 + (2 * i - 1) / max);
          theta = Math.sqrt(max * Math.PI) * phi;
        } else {
          phi = Math.random() * (Math.PI);
          theta = Math.random() * (2 * Math.PI);
        }
        //坐标变换
        this.tagAttrList[i-1].cx = this.radius * Math.cos(theta) * Math.sin(phi)*3;
        this.tagAttrList[i-1].cy = this.radius * Math.sin(theta) * Math.sin(phi)*0.6;
        this.tagAttrList[i-1].cz = this.radius * Math.cos(phi);
        this.tagContent[i-1].style.left = this.tagAttrList[i-1].cx + this.cloudContent.offsetWidth / 2 - this.tagAttrList[i-1].offsetWidth / 2 + 'px';
        this.tagContent[i-1].style.top = this.tagAttrList[i-1].cy + this.cloudContent.offsetHeight / 2 - this.tagAttrList[i-1].offsetHeight / 2 + 'px';
      }
    },
    update() {
      let angleBasicA;
      let angleBasicB;

      if (this.active) {
        angleBasicA = (-Math.min(Math.max(-this.mouseY, -200), 200) / this.radius) * this.tspeed;
        angleBasicB = (Math.min(Math.max(-this.mouseX, -200), 200) / this.radius) * this.tspeed ; // 增加水平旋转角度的变化范围
      } else {
        angleBasicA = this.lasta * 0.98;
        angleBasicB = this.lastb * 0.98*2;
      }

      // 默认转动是后是否需要停下
      // lasta=a;
      // lastb=b;

      // if(Math.abs(a)<=0.01 && Math.abs(b)<=0.01)
      // {
      // return;
      // }
      this.sineCosine(angleBasicA, angleBasicB*1.5, 0);
      for (let j = 0; j < this.tagAttrList.length; j++) {
        let rx1 = this.tagAttrList[j].cx;
        let ry1 = this.tagAttrList[j].cy * this.cosA + this.tagAttrList[j].cz * (-this.sinA);
        let rz1 = this.tagAttrList[j].cy * this.sinA + this.tagAttrList[j].cz * this.cosA;

        let rx2 = rx1 * this.cosB + rz1 * this.sinB;
        let ry2 = ry1;
        let rz2 = rx1 * (-this.sinB) + rz1 * this.cosB;

        let rx3 = rx2 * this.cosC + ry2 * (-this.sinC);
        let ry3 = rx2 * this.sinC + ry2 * this.cosC;
        let rz3 = rz2;
        this.tagAttrList[j].cx = rx3;
        this.tagAttrList[j].cy = ry3;
        this.tagAttrList[j].cz = rz3;

        let per = 350 / (350 + rz3);

        this.tagAttrList[j].x = rx3 * per - 2;
        this.tagAttrList[j].y = ry3 * per;
        this.tagAttrList[j].scale = per;
        this.tagAttrList[j].alpha = per;

        this.tagAttrList[j].alpha = (this.tagAttrList[j].alpha - 0.6) * (10 / 6);
      }
      this.doPosition();
      this.depthSort();
    },
    doPosition() {
      let len = this.cloudContent.offsetWidth/2;
      let height = this.cloudContent.offsetHeight/2;
      for (let i=0;i < this.tagAttrList.length;i++) {
        this.tagContent[i].style.left = this.tagAttrList[i].cx + len - this.tagAttrList[i].offsetWidth/2 + 'px';
        this.tagContent[i].style.top = this.tagAttrList[i].cy + height - this.tagAttrList[i].offsetHeight/2 + 'px';
        // this.tagContent[i].style.fontSize = Math.ceil(12 * this.tagAttrList[i].scale/2) + 8 + 'px';
        this.tagContent[i].style.fontSize = Math.ceil(12 * this.tagAttrList[i].scale/2) +2 + 'px';
        this.tagContent[i].style.filter = "alpha(opacity="+100 * this.tagAttrList[i].alpha+")";
        this.tagContent[i].style.opacity = this.tagAttrList[i].alpha;
      }
    },
    depthSort(){
      let aTmp = [];
      for (let i = 0; i < this.tagContent.length; i++) {
        aTmp.push(this.tagContent[i]);
      }
      aTmp.sort((item1, item2) => item2.cz - item1.cz);
      for (let i = 0; i < aTmp.length; i++) {
        aTmp[i].style.zIndex=i;
      }
    },
    sineCosine (a, b, c) {
      this.sinA = Math.sin(a * this.dtr);
      this.cosA = Math.cos(a * this.dtr);
      this.sinB = Math.sin(b * this.dtr);
      this.cosB = Math.cos(b * this.dtr);
      this.sinC = Math.sin(c * this.dtr);
      this.cosC = Math.cos(c * this.dtr);
    },






    handleEnter() {
      // 按下 Enter 键时触发的逻辑
      window.location.href = '/result';
      console.log(this.input); // 输出搜索框中的文字内容
      const encodedKeyword = encodeURIComponent(this.input); // 编码搜索内容
      // 跳转至第二个页面，并传递编码后的搜索内容作为参数
      window.location.href = '/result?keyword=' + encodedKeyword;


    },

    search() {
      window.location.href = '/result';
      console.log(this.input); // 输出搜索框中的文字内容

      const encodedKeyword = encodeURIComponent(this.input); // 编码搜索内容

      // 跳转至第二个页面，并传递编码后的搜索内容作为参数
      window.location.href = '/result?keyword=' + encodedKeyword;
    },



    handleUpload(){
      // 从 localStorage 中检索存储的用户数据
      const userData = localStorage.getItem("honey-user");

    // 如果存在存储的用户数据，则将其解析为对象
      if(userData) {
        const user = JSON.parse(userData);
        // 现在您可以使用 user 对象，包含了之前存储在 localStorage 中的用户数据
        this.$router.push('/upload')
        console.log(user);
      } else {
        // 如果未找到对应的数据，可以做相应的处理
        this.$message.warning("请登录后上传")
      }
    },
    logout(){
      // 清空特定键的存储项
      localStorage.removeItem("honey-user");
      this.$router.push('/login')
    },



    loadAll() {
      return request.get('/course/select')
          .then(res => {
            const data = res.data;
            const restaurantSet = new Set();
            const restaurants = [];
            data.forEach(item => {
              if (!restaurantSet.has(item.coursename)) {
                restaurants.push({
                  value: item.coursename
                });
                restaurantSet.add(item.coursename);
              }
            });
            this.restaurants = restaurants;
            return restaurants;
          });
    },

    createFilter(queryString) {
      return (restaurant) => {
        // 这里只需要判断选定的属性即可
        return restaurant.value.toLowerCase().indexOf(queryString.toLowerCase()) === 0;
      };
    },

    querySearch(queryString, cb) {
      let restaurants = this.restaurants;
      let results = queryString ? restaurants.filter(this.createFilter(queryString)) : restaurants;
      // 调用 callback 返回建议列表的数据
      cb(results);
    },



    handleSelect(item) {
      console.log(item);
    },
  },


  beforeDestroy () {
    clearInterval(this.timer)
  },


  mounted() {

    this.$nextTick(() => {
      this.radius = document.querySelector('.cloud-box').offsetWidth / 2
      this.initWordCloud()
    })


    this.restaurants = this.loadAll();
    const userData = localStorage.getItem("honey-user");
    if(userData){
      this.test=true;
    const user = JSON.parse(userData);
    this.circleUrl=user.upicture;
    this.username=user.username;}
  }
}



</script>


<style>

.cloud-bed {
  //z-index: 1;
  width: 450px;
  height: 210px;
  margin: auto;
  //background-color: #0f9876;
}
.cloud-box{
  //z-index: 2;
  position:relative;
  margin:20px auto 0px;
  width: 100%;
  height: 100%;
  background:	#00000000;
}
.cloud-box span{
  position: absolute;
  padding: 3px 6px;
  top: 0px;
  font-weight: bold;
  text-decoration:none;
  left:0px;
  background-image: linear-gradient(to bottom, red, #fff);
  background-clip: text;
  color: transparent;
  width: 150px;
  height: 150px;
  border-radius: 50%;
  text-align: center;

  display: flex;
  align-items: center;
  justify-content: center;

  line-height: 50px;
  overflow:hidden;
  white-space: nowrap;
  text-overflow: ellipsis;
}

.nav-links{
  float: right;
  margin-top: 20px;
}



.logo{
  //width: 50px;
  //height: 50px;
  border-radius: 50%;
  margin-top: 15px
}

.search{
  height: 550px;
  background-color: #f5f5f5;
  //background-image: url('../assets/css/树.png');
  //background-position: right; /* 背景图片位置，居中显示 */
  //background-repeat: no-repeat; /* 背景图片不重复 */
  background-size: cover;
}


.footer{
  height: 80px;
  background-color: #fff
}
.upload-the-course{
  display: flex;
  align-items: center; /*竖直居中*/
  margin-top: 30px;

}
.upload{
  font-size: 15px;
  font-weight: 500;
  cursor: pointer;
}
.communicate-together{
  display: flex;
  justify-content: center;
  align-items: center;
  margin-top: 30px;
  font-size: 15px;
  font-weight: 500;
}

.contact{
  font-size: 15px;
  font-weight: 500;
  //background-color: #e5e5ee ;
  border: none;
}

.search-box{
  position:relative;
  margin-left: 450px;
  height: 100px;
  //background-color: #333333;
}
</style>
