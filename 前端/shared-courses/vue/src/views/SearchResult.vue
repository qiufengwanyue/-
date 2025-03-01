<template>
  <div v-if="showContent1">
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
      <el-aside width="1100px" style="background-color: #f5f5f5" class="aside">
        <div style="margin-top: 15px;margin-left:50px;margin-top: 20px;display: flex">
          <el-input style="width: 550px"  v-model="searchKeyword" @keydown.native.enter="handleEnter">
          </el-input>
          <el-button type="primary" icon="el-icon-search"
                     style="width: 80px;height: 32px;background-color:#32cef8;border:#333333;margin-bottom: 10px;border-radius: 10px"
                       @click="search">搜索</el-button>
          <el-button icon="el-icon-refresh"  @click="toggleFormat" style="margin-left: 330px;color: #1f94dc;" circle></el-button>
        </div>
<!--        <el-button type="text" @click="toggleFormat" style="margin-left: 800px; margin-top: 10px; color: #1f94dc; font-size: 15px; border: 1px solid #1f94dc; border-radius: 20px; padding: 10px 20px; background-color: transparent; transition: background-color 0.3s, color 0.3s;">-->
<!--          点击切换课程表显示-->
<!--        </el-button>-->
        <div class="scrollable-container" style="margin-top: 15px;margin-left: 50px;margin-right: 50px;">
          <div style="height: 200px;">
            <el-card class="box-card" style="width: 1000px">
              <div v-for="(key, index) in Object.keys(course)" :key="index" class="text item" style="">
                <div v-for="(timeItem, innerIndex) in Object.keys(time)" :key="innerIndex" style="margin-left: 30px; height: 300px; margin-bottom: 70px;">
                  <el-link  @click="redirectToCoursePage(course[index].coursename,course[index].teacher,course[index].ccolloge,
              course[index].area,course[index].introduce,course[index].roomnum,course[index].warn,course[index].reservenum,
              course[index].score,course[index].likenum,course[index].cid,time[innerIndex].iid,time[innerIndex].rank,course[index].cpicture)"
                            target="_self">
                    <div style="margin: 20px;">
                      <table data="course">
                        <tr>
                          <td rowspan="2" style="text-align: center; vertical-align: middle;">
                            <img :src="course[index].cpicture" style="max-width: 100%; height: auto; box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);">
                          </td>
                          <td style="border-right: 1px solid #c9c8c8;vertical-align: bottom">课程院校：</td>
                          <td style="border-right: 1px solid #c9c8c8;vertical-align: bottom">课程地点：</td>
                          <td style="border-right: 1px solid #c9c8c8;vertical-align: bottom">上课日期：</td>
                          <td style="border-right: 1px solid #c9c8c8;vertical-align: bottom">任课老师：</td>
                          <td style="vertical-align: bottom">剩余容量：</td>
                        </tr>
                        <tr class="dashed-row" datatype="user" data="course" >
                          <td style="border-right: 1px solid #c9c8c8;">{{course[index].ccolloge}}</td>
                          <td style="border-right: 1px solid #c9c8c8;">{{course[index].area }}</td>
                          <td style="border-right: 1px solid #c9c8c8;">{{time[innerIndex].date}}</td>
                          <td style="border-right: 1px solid #c9c8c8;">{{course[index].teacher }}</td>
                          <td>{{ course[index].roomnum - course[index].pernum }}</td>
                        </tr>
                        <tr>
                          <td rowspan="2" style="text-align: center;font-size: 20px;width: 80px" >{{course[index].coursename }}</td>
                          <td style="font-size: 15px;vertical-align: bottom" >课程简介：</td>
                        </tr>
                        <tr>
                          <td colspan="5" >{{course[index].introduce}}</td>
                        </tr>
                      </table>
                    </div>
                  </el-link>
                </div>
              </div>
            </el-card>
          </div>
        </div>
      </el-aside>
      <el-main style="background-color:  #f5f5f5" class="main">
        <el-card class="box-card" style="width:300px;height: 500px;margin-top: 60px">
          <div slot="header" class="clearfix">
            <span style="font-size: 26px">相关搜索</span>
          </div>
          <div v-for="(o, index) in Object.keys(this.course).length" :key="index" class="text item" style="font-size: 16px">
            <a href="#" class="el-icon-search" @click="handleClick(course[index].coursename)" style="text-decoration: none;color: #333333">
              {{course[index].coursename }}
            </a>
          </div>


        </el-card>

      </el-main>
    </el-container>
  </el-container>
  </div>
  <div v-else>
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

      <div style="margin-top: 15px;margin-top: 20px;display: flex;background-color: #f5f5f5;padding-left: 75px;padding-top: 10px">
        <el-input style="width: 550px;"  v-model="searchKeyword" @keydown.native.enter="handleEnter">
        </el-input>
        <el-button type="primary" icon="el-icon-search"
                   style="width: 80px;height: 32px;background-color:#32cef8;border:#333333;margin-bottom: 10px;border-radius: 10px"
                   @click="search">搜索</el-button>
        <el-button icon="el-icon-refresh"  @click="toggleFormat" style="margin-left: 680px;color: #1f94dc;" circle></el-button>
      </div>




    <div class="course-table" style="display: flex; justify-content: center; align-items: center;background-color: #f5f5f5;height: 550px">
      <table style="width: 90%;background-color: #fff" data="course">
        <thead>
        <tr>
          <th style="background-color: lightgray; border: 1px solid black; padding: 5px; width: 8%;">时间/星期</th>
          <th v-for="day in days" :key="day" style="background-color: lightgray; border: 1px solid black; padding: 5px; ">{{ day }}</th>
        </tr>
        </thead>
        <tr style=" border: 1px solid black; padding: 5px; height: 100px;">
          <td style="background-color: lightgray; border: 1px solid black; padding: 5px; height: 100px;margin-left: 5px">第一节课</td>
          <td style="border: 1px solid black;" class="1">
            <el-link @click="redirectToCoursePage(coursename1, teacher1, ccolloge1, area1, introduce1, roomnum1, warn1, reservenum1, score1, likenum1, cid1,iid1,rank1,dayOfWeek1,ranking1)"
                     target="_self">
              <div v-if="coursename1 || ccolloge1">
                <div v-if="coursename1">{{ coursename1 }}</div>
                <div v-if="ccolloge1">{{ ccolloge1 }}</div>
              </div>
            </el-link>
            <el-link href="/course" target="_self">
              <div v-if="coursename11 || ccolloge11" style="display: flex;margin-top: 10px">
                <div v-if="coursename11" >{{ coursename11 }}</div>
                <div v-if="ccolloge11" style="margin-left: 10px">{{ ccolloge11}}</div>
              </div>
            </el-link>
            <el-link href="/course" target="_self">
              <div v-if="coursename12 || ccolloge12" style="display: flex;margin-top: 10px">
                <div v-if="coursename12" >{{ coursename12 }}</div>
                <div v-if="ccolloge12" style="margin-left: 10px">{{ ccolloge12}}</div>
              </div>
            </el-link>
          </td>

          <td style="border: 1px solid black;">
            <el-link @click="redirectToCoursePage(coursename2,teacher2,ccolloge2,area2,introduce2,roomnum2,warn2,reservenum2,score2,likenum2,cid2,iid2,rank2,dayOfWeek2,ranking2)"
                     target="_self" >
              <div v-if="coursename2 || ccolloge2" style="display: flex;">
                <div v-if="coursename2" >{{ coursename2 }}</div>
                <div v-if="ccolloge2" style="margin-left: 10px">{{ ccolloge2}}</div>
              </div>
            </el-link>
            <el-link href="/course" target="_self">
              <div v-if="coursename21 || ccolloge21" style="display: flex;margin-top: 10px">
                <div v-if="coursename21" >{{ coursename21 }}</div>
                <div v-if="ccolloge21" style="margin-left: 10px">{{ ccolloge21}}</div>
              </div>
            </el-link>
            <el-link href="/course" target="_self">
              <div v-if="coursename22 || ccolloge22" style="display: flex;margin-top: 10px">
                <div v-if="coursename22" >{{ coursename22 }}</div>
                <div v-if="ccolloge22" style="margin-left: 10px">{{ ccolloge22}}</div>
              </div>
            </el-link>

         </td>
          <td style="border: 1px solid black;" class="3">
            <el-link @click="redirectToCoursePage(coursename3,teacher3,ccolloge3,area3,introduce3,roomnum3,warn3,reservenum3,score3,likenum3,cid3,iid3,rank3,dayOfWeek3,ranking3)"
                      target="_self" >
              <div v-if="coursename3" >{{ coursename3 }}</div>
              <div v-if="ccolloge3">{{ ccolloge3 }}</div>
          </el-link>
          </td>
          <td style="border: 1px solid black;" class="4"> <el-link @click="redirectToCoursePage(coursename4, teacher4, ccolloge4, area4, introduce4, roomnum4, warn4, reservenum4, score4, likenum4, cid4,iid4,rank4,dayOfWeek4,ranking4)" target="_self">
            <div v-if="coursename4 || ccolloge4">
              <div v-if="coursename4">{{ coursename4 }}</div>
              <div v-if="ccolloge4">{{ ccolloge4 }}</div>
            </div>
          </el-link></td>
          <td style="border: 1px solid black;" class="5"><el-link  @click="redirectToCoursePage(coursename5, teacher5, ccolloge5, area5, introduce5, roomnum5, warn5, reservenum5, score5, likenum5, cid5,iid5,rank5,dayOfWeek5,ranking5)" target="_self">
            <div v-if="coursename5 || ccolloge5">
              <div v-if="coursename5">{{ coursename5 }}</div>
              <div v-if="ccolloge5">{{ ccolloge5}}</div>
            </div>
          </el-link></td>
          <td style="border: 1px solid black;" class="6"><el-link  @click="redirectToCoursePage(coursename6, teacher6, ccolloge6, area6, introduce6, roomnum6, warn6, reservenum6, score6, likenum6, cid6,iid6,rank6,dayOfWeek6,ranking6)" target="_self">
            <div v-if="coursename6 || ccolloge6">
              <div v-if="coursename6">{{ coursename6 }}</div>
              <div v-if="ccolloge6">{{ ccolloge6}}</div>
            </div>
          </el-link></td>
          <td style="border: 1px solid black;" class="7"><el-link @click="redirectToCoursePage(coursename7, teacher7, ccolloge7, area7, introduce7, roomnum7, warn7, reservenum7, score7, likenum7, cid7,iid7,rank7,dayOfWeek7,ranking7)" target="_self">
            <div v-if="coursename7 || ccolloge7">
              <div v-if="coursename7">{{ coursename7 }}</div>
              <div v-if="ccolloge7">{{ ccolloge7}}</div>
            </div>
          </el-link></td>
        </tr>
        <tr style=" border: 1px solid black; padding: 5px; height: 100px;">
          <td style="background-color: lightgray; border: 1px solid black; padding: 5px; height: 100px;">第二节课</td>
          <td style="border: 1px solid black;" class="8" ><el-link  @click="redirectToCoursePage(coursename8, teacher8, ccolloge8, area8, introduce8, roomnum8, warn8, reservenum8, score8, likenum8, cid8,iid8,rank8,dayOfWeek8,ranking8)" target="_self">
            <div v-if="coursename8 || ccolloge8" style="display: flex;">
              <div v-if="coursename8">{{ coursename8 }}</div>
              <div v-if="ccolloge8">{{ ccolloge8}}</div>
            </div>
          </el-link></td>
          <td style="border: 1px solid black;" class="9"><el-link @click="redirectToCoursePage(coursename9, teacher9, ccolloge9, area9, introduce9, roomnum9, warn9, reservenum9, score9, likenum9, cid9,iid9,rank9,dayOfWeek9,ranking9)" target="_self">
            <div v-if="coursename9 || ccolloge9">
              <div v-if="coursename9">{{ coursename9 }}</div>
              <div v-if="ccolloge9">{{ ccolloge9}}</div>
            </div>
          </el-link></td>
          <td style="border: 1px solid black;"class="10"><el-link @click="redirectToCoursePage(coursename10, teacher10, ccolloge10, area10, introduce10, roomnum10, warn10, reservenum10, score10, likenum10, cid10,iid10,rank10,dayOfWeek10,ranking10)" target="_self">
            <div v-if="coursename10 || ccolloge10">
              <div v-if="coursename10">{{ coursename10 }}</div>
              <div v-if="ccolloge10">{{ ccolloge10}}</div>
            </div>
          </el-link></td>
          <td style="border: 1px solid black;" class="11"><el-link @click="redirectToCoursePage(coursename11, teacher11, ccolloge11, area11, introduce11, roomnum11, warn11, reservenum11, score11, likenum11, cid11,iid11,rank11,dayOfWeek11,ranking11)" target="_self">
            <div v-if="coursename11 || ccolloge11">
              <div v-if="coursename11">{{ coursename11 }}</div>
              <div v-if="ccolloge11">{{ ccolloge11}}</div>
            </div>
          </el-link></td>
          <td style="border: 1px solid black;" class="12"><el-link  @click="redirectToCoursePage(coursename12, teacher12, ccolloge12, area12, introduce12, roomnum12, warn12, reservenum12, score12, likenum12, cid12,iid12,rank12,dayOfWeek12,ranking12)" target="_self">
            <div v-if="coursename12|| ccolloge12">
              <div v-if="coursename12">{{ coursename12}}</div>
              <div v-if="ccolloge12">{{ ccolloge12}}</div>
            </div>
          </el-link></td>
          <td style="border: 1px solid black;" class="13"><el-link @click="redirectToCoursePage(coursename13, teacher13, ccolloge13, area13, introduce13, roomnum13, warn13, reservenum13, score13, likenum13, cid13,iid13,rank13,dayOfWeek13,ranking13)" target="_self">
            <div v-if="coursename13 || ccolloge13">
              <div v-if="coursename13">{{ coursename13 }}</div>
              <div v-if="ccolloge13">{{ ccolloge13}}</div>
            </div>
          </el-link></td>
          <td style="border: 1px solid black;" class="14"><el-link @click="redirectToCoursePage(coursename14, teacher14, ccolloge14, area14, introduce14, roomnum14, warn14, reservenum14, score14, likenum14, cid14,iid14,rank14,dayOfWeek14,ranking14)" target="_self">
            <div v-if="coursename14|| ccolloge14">
              <div v-if="coursename14">{{ coursename14 }}</div>
              <div v-if="ccolloge14">{{ ccolloge14}}</div>
            </div>
          </el-link></td>
        </tr>
        <tr style=" border: 1px solid black; padding: 5px; height: 100px;">
          <td style="background-color: lightgray; border: 1px solid black; padding: 5px; height: 100px;">第三节课</td>
          <td style="border: 1px solid black;" class="15"><el-link @click="redirectToCoursePage(coursename15, teacher15, ccolloge15, area15, introduce15, roomnum15, warn15, reservenum15, score15, likenum15, cid15,iid15,rank15,dayOfWeek15,ranking15)" target="_self">
            <div v-if="coursename15|| ccolloge15">
              <div v-if="coursename15">{{ coursename15}}</div>
              <div v-if="ccolloge15">{{ ccolloge15}}</div>
            </div>
          </el-link></td>
          <td style="border: 1px solid black;" class="16"><el-link @click="redirectToCoursePage(coursename16, teacher16, ccolloge16, area16, introduce16, roomnum16, warn16, reservenum16, score16, likenum16, cid16,iid16,rank16,dayOfWeek16,ranking16)" target="_self">
            <div v-if="coursename16|| ccolloge16">
              <div v-if="coursename16">{{ coursename16 }}</div>
              <div v-if="ccolloge16">{{ ccolloge16}}</div>
            </div>
          </el-link></td>
          <td style="border: 1px solid black;" class="17"><el-link @click="redirectToCoursePage(coursename17, teacher17, ccolloge17, area17, introduce17, roomnum17, warn17, reservenum17, score17, likenum17, cid17,iid17,rank17,dayOfWeek17,ranking17)" target="_self">
            <div v-if="coursename17 || ccolloge17">
              <div v-if="coursename17">{{ coursename17 }}</div>
              <div v-if="ccolloge17">{{ ccolloge17}}</div>
            </div>
          </el-link></td>
          <td style="border: 1px solid black;" class="18"><el-link @click="redirectToCoursePage(coursename18, teacher18, ccolloge18, area18, introduce18, roomnum18, warn18, reservenum18, score18, likenum18, cid18,iid18,rank18,dayOfWeek18,ranking18)" target="_self">
            <div v-if="coursename18|| ccolloge18">
              <div v-if="coursename18">{{ coursename18}}</div>
              <div v-if="ccolloge18">{{ ccolloge18}}</div>
            </div>
          </el-link></td>
          <td style="border: 1px solid black;" class="19"><el-link @click="redirectToCoursePage(coursename19, teacher19, ccolloge19, area19, introduce19, roomnum19, warn19, reservenum19, score19, likenum19, cid19,iid19,rank19,dayOfWeek19,ranking19)" target="_self">
            <div v-if="coursename19 || ccolloge19">
              <div v-if="coursename19">{{ coursename19 }}</div>
              <div v-if="ccolloge19">{{ ccolloge19}}</div>
            </div>
          </el-link></td>
          <td style="border: 1px solid black;" class="20"><el-link @click="redirectToCoursePage(coursename20, teacher20, ccolloge20, area20, introduce20, roomnum20, warn20, reservenum20, score20, likenum20, cid20,iid20,rank20,dayOfWeek20,ranking20)" target="_self">
            <div v-if="coursename20 || ccolloge20">
              <div v-if="coursename20">{{ coursename20}}</div>
              <div v-if="ccolloge20">{{ ccolloge20}}</div>
            </div>
          </el-link></td>
          <td style="border: 1px solid black;" class="21"><el-link  @click="redirectToCoursePage(coursename21, teacher21, ccolloge21, area21, introduce21, roomnum21, warn21, reservenum21, score21, likenum21, cid21,iid21,rank21,dayOfWeek21,ranking21)" target="_self">
            <div v-if="coursename21|| ccolloge21">
              <div v-if="coursename21">{{ coursename21}}</div>
              <div v-if="ccolloge21">{{ ccolloge21}}</div>
            </div>
          </el-link></td>
        </tr>
        <tr style=" border: 1px solid black; padding: 5px; height: 100px;">
          <td style="background-color: lightgray; border: 1px solid black; padding: 5px; height: 100px;">第四节课</td>
          <td style="border: 1px solid black;" class="22"><el-link @click="redirectToCoursePage(coursename22, teacher22, ccolloge22, area22, introduce22, roomnum22, warn22, reservenum22, score22, likenum22, cid22,iid22,rank22,dayOfWeek22,ranking22)" target="_self">
            <div v-if="coursename22 || ccolloge22">
              <div v-if="coursename22">{{ coursename22 }}</div>
              <div v-if="ccolloge22">{{ ccolloge22 }}</div>
            </div>
          </el-link></td>
          <td style="border: 1px solid black;" class="23"><el-link @click="redirectToCoursePage(coursename23, teacher23, ccolloge23, area23, introduce23, roomnum23, warn23, reservenum23, score23, likenum23, cid23,iid23,rank23,dayOfWeek23,ranking23)" target="_self">
            <div v-if="coursename23 || ccolloge23">
              <div v-if="coursename23">{{ coursename23 }}</div>
              <div v-if="ccolloge23">{{ ccolloge23 }}</div>
            </div>
          </el-link></td>
          <td style="border: 1px solid black;" class="24"><el-link @click="redirectToCoursePage(coursename24, teacher24, ccolloge24, area24, introduce24, roomnum24, warn24, reservenum24, score24, likenum24, cid24,iid24,rank24,dayOfWeek24,ranking24)" target="_self">
            <div v-if="coursename24 || ccolloge24">
              <div v-if="coursename24">{{ coursename24 }}</div>
              <div v-if="ccolloge24">{{ ccolloge24 }}</div>
            </div>
          </el-link></td>
          <td style="border: 1px solid black;" class="25"><el-link @click="redirectToCoursePage(coursename25, teacher25, ccolloge25, area25, introduce25, roomnum25, warn25, reservenum25, score25, likenum25, cid25,iid25,rank25,dayOfWeek25,ranking25)" target="_self">
            <div v-if="coursename25 || ccolloge25">
              <div v-if="coursename25">{{ coursename25 }}</div>
              <div v-if="ccolloge25">{{ ccolloge25 }}</div>
            </div>
          </el-link></td>
          <td style="border: 1px solid black;" class="26"><el-link @click="redirectToCoursePage(coursename26, teacher26, ccolloge26, area26, introduce26, roomnum26, warn26, reservenum26, score26, likenum26, cid26,iid26,rank26,dayOfWeek26,ranking26)" target="_self">
            <div v-if="coursename26 || ccolloge26">
              <div v-if="coursename26">{{ coursename26 }}</div>
              <div v-if="ccolloge26">{{ ccolloge26 }}</div>
            </div>
          </el-link></td>
          <td style="border: 1px solid black;" class="27"><el-link  @click="redirectToCoursePage(coursename27, teacher27, ccolloge27, area27, introduce27, roomnum27, warn27, reservenum27, score27, likenum27, cid27,iid27,rank27,dayOfWeek27,ranking27)"target="_self">
            <div v-if="coursename27 || ccolloge27">
              <div v-if="coursename27">{{ coursename27 }}</div>
              <div v-if="ccolloge27">{{ ccolloge27 }}</div>
            </div>
          </el-link></td>
          <td style="border: 1px solid black;" class="28"><el-link @click="redirectToCoursePage(coursename28, teacher28, ccolloge28, area28, introduce28, roomnum28, warn28, reservenum28, score28, likenum28, cid28,iid28,rank28,dayOfWeek28,ranking28)" target="_self">
            <div v-if="coursename28 || ccolloge28">
              <div v-if="coursename28">{{ coursename28 }}</div>
              <div v-if="ccolloge28">{{ ccolloge28}}</div>
            </div>
          </el-link></td>
        </tr>
        <tr style="border: 1px solid black; padding: 5px; height: 100px;">
          <td style="background-color: lightgray; border: 1px solid black; padding: 5px; height: 100px;">第五节课</td>
          <td style="border: 1px solid black;" class="29"><el-link @click="redirectToCoursePage(coursename29, teacher29, ccolloge29, area29, introduce29, roomnum29, warn29, reservenum29, score29, likenum29, cid29,iid29,rank29,dayOfWeek29,ranking29)" target="_self">
            <div v-if="coursename29 || ccolloge29">
              <div v-if="coursename29">{{ coursename29 }}</div>
              <div v-if="ccolloge29">{{ ccolloge29 }}</div>
            </div>
          </el-link></td>
          <td style="border: 1px solid black;" class="30"><el-link  @click="redirectToCoursePage(coursename30, teacher30, ccolloge30, area30, introduce30, roomnum30, warn30, reservenum30, score30, likenum30, cid30,iid30,rank30,dayOfWeek30,ranking30)" target="_self">
            <div v-if="coursename30 || ccolloge30">
              <div v-if="coursename30">{{ coursename30 }}</div>
              <div v-if="ccolloge30">{{ ccolloge30 }}</div>
            </div>
          </el-link></td>
          <td style="border: 1px solid black;" class="31"><el-link @click="redirectToCoursePage(coursename31, teacher31, ccolloge31, area31, introduce31, roomnum31, warn31, reservenum31, score31, likenum31, cid31,iid31,rank31,dayOfWeek31,ranking31)" target="_self">
            <div v-if="coursename31 || ccolloge31">
              <div v-if="coursename31">{{ coursename31 }}</div>
              <div v-if="ccolloge31">{{ ccolloge31 }}</div>
            </div>
          </el-link></td>
          <td style="border: 1px solid black;" class="32"><el-link @click="redirectToCoursePage(coursename32, teacher32, ccolloge32, area32, introduce32, roomnum32, warn32, reservenum32, score32, likenum32, cid32,iid32,rank32,dayOfWeek32,ranking32)" target="_self">
            <div v-if="coursename32 || ccolloge32">
              <div v-if="coursename32">{{ coursename32 }}</div>
              <div v-if="ccolloge32">{{ ccolloge32 }}</div>
            </div>
          </el-link></td>
          <td style="border: 1px solid black;" class="33"><el-link @click="redirectToCoursePage(coursename33, teacher33, ccolloge33, area33, introduce33, roomnum33, warn33, reservenum33, score33, likenum33, cid33,iid33,rank33,dayOfWeek33,ranking33)"target="_self">
            <div v-if="coursename33 || ccolloge33">
              <div v-if="coursename33">{{ coursename33 }}</div>
              <div v-if="ccolloge33">{{ ccolloge33 }}</div>
            </div>
          </el-link></td>
          <td style="border: 1px solid black;" class="34"><el-link @click="redirectToCoursePage(coursename34, teacher34, ccolloge34, area34, introduce34, roomnum34, warn34, reservenum34, score34, likenum34, cid34,iid34,rank34,dayOfWeek34,ranking34)" target="_self">
            <div v-if="coursename34 || ccolloge34">
              <div v-if="coursename34">{{ coursename34 }}</div>
              <div v-if="ccolloge34">{{ ccolloge34 }}</div>
            </div>
          </el-link></td>
          <td style="border: 1px solid black;" class="35"><el-link @click="redirectToCoursePage(coursename35, teacher35, ccolloge35, area35, introduce35, roomnum35, warn35, reservenum35, score35, likenum35, cid35,iid35,rank35,dayOfWeek35,ranking35)" target="_self">
            <div v-if="coursename35 || ccolloge35">
              <div v-if="coursename35">{{ coursename35 }}</div>
              <div v-if="ccolloge35">{{ ccolloge35 }}</div>
            </div>
          </el-link></td>
        </tr>






      </table>
    </div>


  </div>
</template>
<script>


import axios from "axios";
import request from "@/utils/request";


export default {
  data() {
    return {
      test: false,
      circleUrl: 'https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png',
      input: '',
      restaurants: [],
      username:'',
      showContent1: true,
      searchKeyword: '',
      items: [], // 用来存储从数据库中获取的数据

      days: ['周一', '周二', '周三', '周四', '周五', '周六', '周天'],
      // schedules: [],
      times: ['8:00 - 10:00', '10:10 - 12:00', '14:00 - 16:00', '16:10 - 18:00', '19:00 - 21:00'],

      course: [], // 从后端获取的所有课程数据
      uniqueCourses: [], // 去重后的课程数据
      cids:[],
      time:[],
      coursename1: '', ccolloge1: '',
      coursename2: '', ccolloge2: '',
      coursename3: '', ccolloge3: '',
      coursename4: '', ccolloge4: '',
      coursename5: '', ccolloge5: '',
      coursename6: '', ccolloge6: '',
      coursename7: '', ccolloge7: '',
      coursename8: '', ccolloge8: '',
      coursename9: '', ccolloge9: '',
      coursename10: '', ccolloge10: '',
      coursename11: '', ccolloge11: '',
      coursename12: '', ccolloge12: '',
      coursename13: '', ccolloge13: '',
      coursename14: '', ccolloge14: '',
      coursename15: '', ccolloge15: '',
      coursename16: '', ccolloge16: '',
      coursename17: '', ccolloge17: '',
      coursename18: '', ccolloge18: '',
      coursename19: '', ccolloge19: '',
      coursename20: '', ccolloge20: '',
      coursename21: '', ccolloge21: '',
      coursename22: '', ccolloge22: '',
      coursename23: '', ccolloge23: '',
      coursename24: '', ccolloge24: '',
      coursename25: '', ccolloge25: '',
      coursename26: '', ccolloge26: '',
      coursename27: '', ccolloge27: '',
      coursename28: '', ccolloge28: '',
      coursename29: '', ccolloge29: '',
      coursename30: '', ccolloge30: '',
      coursename31: '', ccolloge31: '',
      coursename32: '', ccolloge32: '',
      coursename33: '', ccolloge33: '',
      coursename34: '', ccolloge34: '',
      coursename35: '', ccolloge35: ''
    };
  },


  mounted() {
    const userData = localStorage.getItem("honey-user");
    if(userData){
      this.test=true;
      const user = JSON.parse(userData);
      this.circleUrl=user.upicture;
      this.username=user.username;};

    const urlParams = new URLSearchParams(window.location.search);
    this.searchKeyword = urlParams.get('keyword') || '';

    // 发起初始搜索请求
    this.$request.get('/course/selectByMo/' + this.searchKeyword).then(res => {
      console.log(res);
      if (res && res.data) {
        this.course = res.data;
        console.log(this.course);
      }
      //将coursename,ccolloge,rank,dayOfWeek,根据cid存在一个数组里
      // 遍历课程数组，将 cid 存储在全局变量中
      this.course.forEach(course => {
        this.cids.push(course.cid);
      });


      // 输出全局变量 cids
      console.log(this.cids);

      if (this.cids.length > 0) {
        for (let i = 0; i < this.cids.length; i++){
        console.log("第一个课程的 CID: ", this.cids[i]);
        this.$request.get('/time/selectByCid/' + this.cids[i]).then(res => {
          console.log(res);
          if (res && res.data) {
            this.time = res.data;
            console.log("time 数组已更新:", this.time);
        // 循环遍历时间数组，处理每个日期
            const arrayLength = this.time.length;
            console.log('传来的数组长度为:', arrayLength);

            for(let i=0;i<arrayLength;i++){
              console.log(this.time[i].date);
            }

            this.time.forEach(timeItem => {

              let iid = timeItem.iid;
              console.log("time数组的iid是： ",iid)


              // 获取日期字符串
              const dateString = new Date(timeItem.date).toLocaleDateString();
              // 解析日期字符串为日期对象
              const dateObj = new Date(dateString);
              // 获取年、月、日
              const year = dateObj.getFullYear();
              const month = dateObj.getMonth() + 1; // 月份从0开始，所以要加1
              const day = dateObj.getDate();



              // 输出星期几（0 表示星期日，1 表示星期一，以此类推）
              const dayOfWeek = dateObj.getDay();
              console.log("星期几:", dayOfWeek);


              // 输出年、月、日
              console.log("年份:", year);
              console.log("月份:", month);
              console.log("日期:", day);

              // 计算日期所属的第几周
              const weekNumberInMonth = getWeekOfMonth(dateObj);
              const weekNumberInYear = getWeekOfMonthInYear(dateObj);
              console.log("当前日期在本月的第几周:", weekNumberInMonth);
              console.log("当前日期在本年的第几周:", weekNumberInYear);

              // 遍历不同的数据并分类显示
              if (timeItem.rank === 1) {
                console.log("第一节课");
              } else if (timeItem.rank === 2) {
                console.log("第二节课");
              } else if (timeItem.rank === 3) {
                console.log("第三节课");
              }else if (timeItem.rank === 4) {
                console.log("第四节课");
              }
              const rank=timeItem.rank;
              if(timeItem.rank == 1 && dayOfWeek == 1){
                console.log(1)
                console.log("当前课程的cid： ", this.cids[i]);
                // 调用封装的方法，并传入课程索引
                this.fetchData(i,1,iid,rank,dayOfWeek);
              }
              else if (timeItem.rank === 1 && dayOfWeek === 2) {
                console.log(2);
                console.log("当前课程的cid： ", this.cids[i]);
                // 调用封装的方法，并传入课程索引
                this.fetchData(i,2,iid,rank,dayOfWeek);
             }
              else if(timeItem.rank===1&&dayOfWeek===3){
                console.log(3)
                console.log("当前课程的cid： ", this.cids[i]);
                // 调用封装的方法，并传入课程索引
                this.fetchData(i,3,iid,rank,dayOfWeek);
              }
              else if(timeItem.rank===1&&dayOfWeek===4){
                console.log(4);
                console.log("当前课程的cid： ", this.cids[i]);
                // 调用封装的方法，并传入课程索引
                this.fetchData(i,4,iid,rank,dayOfWeek);
              }
              else if(timeItem.rank===1&&dayOfWeek===5){
                console.log(5);
                console.log("当前课程的cid： ", this.cids[i]);
                // 调用封装的方法，并传入课程索引
                this.fetchData(i,5,iid,rank,dayOfWeek);
              }
              else if(timeItem.rank===1&&dayOfWeek===6){
                console.log(6);
                console.log("当前课程的cid： ", this.cids[i]);
                // 调用封装的方法，并传入课程索引
                this.fetchData(i,6,iid,rank,dayOfWeek);}
              else if(timeItem.rank===1&&dayOfWeek===0){
                console.log(7);
                console.log("当前课程的cid： ", this.cids[i]);
                // 调用封装的方法，并传入课程索引
                this.fetchData(i,7,iid,rank,dayOfWeek);
              }
              else if(timeItem.rank===2&&dayOfWeek===1){console.log(8);
                console.log("当前课程的cid： ", this.cids[i]);
                // 调用封装的方法，并传入课程索引
                this.fetchData(i,8,iid,rank,dayOfWeek);}
              else if(timeItem.rank===2&&dayOfWeek===2){console.log(9);
                console.log("当前课程的cid： ", this.cids[i]);
                // 调用封装的方法，并传入课程索引
                this.fetchData(i,9,iid,rank,dayOfWeek);}
              else if(timeItem.rank===2&&dayOfWeek===3){console.log(10);
                console.log("当前课程的cid： ", this.cids[i]);
                // 调用封装的方法，并传入课程索引
                this.fetchData(i,10,iid,rank,dayOfWeek);}
              else if(timeItem.rank===2&&dayOfWeek===4){console.log(11);
                console.log("当前课程的cid： ", this.cids[i]);
                // 调用封装的方法，并传入课程索引
                this.fetchData(i,11,iid,rank,dayOfWeek);}
              else if(timeItem.rank===2&&dayOfWeek===5){console.log(12);
                console.log("当前课程的cid： ", this.cids[i]);
                // 调用封装的方法，并传入课程索引
                this.fetchData(i,12,iid,rank,dayOfWeek);}
              else if(timeItem.rank===2&&dayOfWeek===6){console.log(13);
                console.log("当前课程的cid： ", this.cids[i]);
                // 调用封装的方法，并传入课程索引
                this.fetchData(i,13,iid,rank,dayOfWeek);}
              else if(timeItem.rank===2&&dayOfWeek===0){console.log(14);
                console.log("当前课程的cid： ", this.cids[i]);
                // 调用封装的方法，并传入课程索引
                this.fetchData(i,14,iid,rank,dayOfWeek);}
              else if(timeItem.rank===3&&dayOfWeek===1){console.log(15);
                console.log("当前课程的cid： ", this.cids[i]);
                // 调用封装的方法，并传入课程索引
                this.fetchData(i,15,iid,rank,dayOfWeek);}
              else if(timeItem.rank===3&&dayOfWeek===2){console.log(16);
                console.log("当前课程的cid： ", this.cids[i]);
                // 调用封装的方法，并传入课程索引
                this.fetchData(i,16,iid,rank,dayOfWeek);}
              else if(timeItem.rank===3&&dayOfWeek===3){console.log(17);
                console.log("当前课程的cid： ", this.cids[i]);
                // 调用封装的方法，并传入课程索引
                this.fetchData(i,17,iid,rank,dayOfWeek);}
              else if(timeItem.rank===3&&dayOfWeek===4){console.log(18);
                console.log("当前课程的cid： ", this.cids[i]);
                // 调用封装的方法，并传入课程索引
                this.fetchData(i,18,iid,rank,dayOfWeek);}
              else if(timeItem.rank===3&&dayOfWeek===5){console.log(19);
                console.log("当前课程的cid： ", this.cids[i]);
                // 调用封装的方法，并传入课程索引
                this.fetchData(i,19,iid,rank,dayOfWeek);}
              else if(timeItem.rank===3&&dayOfWeek===6){console.log(20);
                console.log("当前课程的cid： ", this.cids[i]);
                // 调用封装的方法，并传入课程索引
                this.fetchData(i,20,iid,rank,dayOfWeek);}
              else if(timeItem.rank===3&&dayOfWeek===0){console.log(21);
                console.log("当前课程的cid： ", this.cids[i]);
                // 调用封装的方法，并传入课程索引
                this.fetchData(i,21,iid,rank,dayOfWeek);}
              else if(timeItem.rank===4&&dayOfWeek===1){console.log(22);
                console.log("当前课程的cid： ", this.cids[i]);
                // 调用封装的方法，并传入课程索引
                this.fetchData(i,22,iid,rank,dayOfWeek);}
              else if(timeItem.rank===4&&dayOfWeek===2){console.log(23);
                console.log("当前课程的cid： ", this.cids[i]);
                // 调用封装的方法，并传入课程索引
                this.fetchData(i,23,iid,rank,dayOfWeek);}
              else if(timeItem.rank===4&&dayOfWeek===3){console.log(24);
                console.log("当前课程的cid： ", this.cids[i]);
                // 调用封装的方法，并传入课程索引
                this.fetchData(i,24,iid,rank,dayOfWeek);}
              else if(timeItem.rank===4&&dayOfWeek===4){console.log(25);
                console.log("当前课程的cid： ", this.cids[i]);
                // 调用封装的方法，并传入课程索引
                this.fetchData(i,25,iid,rank,dayOfWeek);}
              else if(timeItem.rank===4&&dayOfWeek===5){console.log(26);
                console.log("当前课程的cid： ", this.cids[i]);
                // 调用封装的方法，并传入课程索引
                this.fetchData(i,26,iid,rank,dayOfWeek);}
              else if(timeItem.rank===4&&dayOfWeek===6){console.log(27);
                console.log("当前课程的cid： ", this.cids[i]);
                // 调用封装的方法，并传入课程索引
                this.fetchData(i,27,iid,rank,dayOfWeek);}
              else if(timeItem.rank===4&&dayOfWeek===0){console.log(28);
                console.log("当前课程的cid： ", this.cids[i]);
                // 调用封装的方法，并传入课程索引
                this.fetchData(i,28,iid,rank,dayOfWeek);}
              else if(timeItem.rank===5&&dayOfWeek===1){console.log(29);
                console.log("当前课程的cid： ", this.cids[i]);
                // 调用封装的方法，并传入课程索引
                this.fetchData(i,29,iid,rank,dayOfWeek);}
              else if(timeItem.rank===5&&dayOfWeek===2){console.log(30);
                console.log("当前课程的cid： ", this.cids[i]);
                // 调用封装的方法，并传入课程索引
                this.fetchData(i,30,iid,rank,dayOfWeek);}
              else if(timeItem.rank===5&&dayOfWeek===3){console.log(31);
                console.log("当前课程的cid： ", this.cids[i]);
                // 调用封装的方法，并传入课程索引
                this.fetchData(i,31,iid,rank,dayOfWeek);}
              else if(timeItem.rank===5&&dayOfWeek===4){console.log(32);
                console.log("当前课程的cid： ", this.cids[i]);
                // 调用封装的方法，并传入课程索引
                this.fetchData(i,32,iid,rank,dayOfWeek);}
              else if(timeItem.rank===5&&dayOfWeek===5){console.log(33);
                console.log("当前课程的cid： ", this.cids[i]);
                // 调用封装的方法，并传入课程索引
                this.fetchData(i,33,iid,rank,dayOfWeek);}
              else if(timeItem.rank===5&&dayOfWeek===6){console.log(34);
                console.log("当前课程的cid： ", this.cids[i]);
                // 调用封装的方法，并传入课程索引
                this.fetchData(i,34,iid,rank,dayOfWeek);}
              else if(timeItem.rank===5&&dayOfWeek===0){console.log(35);
                console.log("当前课程的cid： ", this.cids[i]);
                // 调用封装的方法，并传入课程索引
                this.fetchData(i,35,iid,rank,dayOfWeek);}
            });
          }
        });
      } }else {
        console.log("没有找到任何课程的 CID");
      }
    }).catch(error => {
      console.log(error);
    });
    // 计算日期在一个月中的第几周
    function getWeekOfMonth(date) {
      // 获取当前日期的年份和月份
      const year = date.getFullYear();
      const month = date.getMonth();

      // 获取当前日期的第一天
      const firstDayOfMonth = new Date(year, month, 1);
      // 计算当前日期是本月第几天
      const dayOfMonth = date.getDate();

      // 计算当前日期是第几周
      const weekOfMonth = Math.ceil((dayOfMonth + firstDayOfMonth.getDay()) / 7);

      return weekOfMonth;
    }

// 计算日期在一年中的第几周
    function getWeekOfMonthInYear(date) {
      // 获取一年中的第一天
      const firstDayOfYear = new Date(date.getFullYear(), 0, 1);

      // 计算当前日期与第一天之间的时间差（以毫秒为单位）
      const timeDiff = date - firstDayOfYear;

      // 计算天数差
      const dayDiff = Math.floor(timeDiff / (1000 * 60 * 60 * 24));

      // 计算周数
      const weekOfYear = Math.ceil((dayDiff + 1) / 7);

      return weekOfYear;
    }
    // 输出第一个课程的 CID

    //
    // for (let i = 0; i < Object.keys(this.course).length; i++) {
    //   console.log(this.course[i].cid);
    // }



    // 读取 localStorage 中的搜索关键词
    const storedKeyword = localStorage.getItem('searchKeyword');
    console.log(storedKeyword);



    const uniqueSet = new Set(); // 使用 Set 数据结构来确保数据的唯一性

    // 遍历原始课程数据，去重并存入uniqueCourses数组中
    this.course.forEach(course => {
      if (!uniqueSet.has(course.coursename)) {
        uniqueSet.add(course.coursename);
        this.uniqueCourses.push(course);
      }
    });

  },




  methods:{

    fetchData(courseIndex, i,iid,rank,dayOfWeek) {

      // this.$request.get('/time/selectByCid/' + this.cids[courseIndex])
      //     .then(res => {
      //       console.log("-----------------------------------");
      //       // 在这里处理后端返回的数据
      //       console.log("从后端获取的数据：", res);
      //       // 处理数据的逻辑
      //
      //     })
      //     .catch(error => {
      //       console.error("请求失败：", error);
      //     });
      //



      // 发送请求获取数据
      this.$request.get('/course/selectByMoCid/' + this.cids[courseIndex])
          .then(res => {
            // 在这里处理后端返回的数据
            console.log("从后端获取的数据：", res);
            // 处理数据的逻辑
            const resultData = res.data;
            console.log(resultData[0].coursename);
            console.log(resultData[0].ccolloge);
            console.log(resultData[0].teacher);
            console.log(resultData[0].area);
            console.log(resultData[0].introduce);
            console.log(resultData[0].roomnum);
            console.log(resultData[0].warn);
            console.log(resultData[0].roomnum);
            console.log(resultData[0].reservenum);
            console.log(resultData[0].score);
            console.log(resultData[0].likenum);
            console.log(resultData[0].cid);
            console.log(resultData[0].uid);
            // 根据课程索引设置对应的课程名和学院名
            this['ccolloge' + i] = resultData[0].ccolloge;
            this['coursename' + i] = resultData[0].coursename;
            this['teacher' + i] = resultData[0].teacher;
            this['area' + i] = resultData[0].area;
            this['introduce' + i] = resultData[0].introduce;
            this['roomnum' + i] = resultData[0].roomnum;
            this['warn' + i] = resultData[0].warn;
            this['reservenum' + i] = resultData[0].reservenum;
            this['score' + i] = resultData[0].score;
            this['likenum' + i] = resultData[0].likenum;
            this['cid' + i] = resultData[0].cid;
            this['uid' + i] = resultData[0].uid;
            this['iid'+i] = iid;
            this['rank'+i] = rank;
            this['dayOfWeek'+i] = dayOfWeek;
            this['ranking'+i] = i;

          })
          .catch(error => {
            console.error("请求失败：", error);
          });
    },
//course[index].cpicture
    redirectToCoursePage(coursename, teacher, ccolloge, area, introduce, roomnum, warn, reservenum, score, likenum, cid,iid,rank,dayOfWeek,ranking,cpicture) {
      // 使用编程式导航跳转到课程页面，并传递参数
      this.$router.push({
        path: '/course',
        query: {
          coursename: coursename,
          teacher: teacher,
          ccolloge: ccolloge,
          area: area,
          introduce: introduce,
          roomnum: roomnum,
          warn: warn,
          reservenum: reservenum,
          score: score,
          likenum: likenum,
          cid: cid,
          iid:iid,
          rank:rank,
          dayOfWeek:dayOfWeek,
          ranking:ranking,
          cpicture:cpicture,
        }
      });
    },


    search() {
      console.log(this.searchKeyword);

      // 重置 cids 数组为空数组
      this.cids = [];
      console.log("cids 已重置为空数组");

      // 发起请求，按照不同的搜索类型进行搜索
      Promise.all([
        this.$request.get('/course/selectByMoSchool/' + this.searchKeyword),
        this.$request.get('/course/selectByMoTeacher/' + this.searchKeyword),
        this.$request.get('/course/selectByMo/' + this.searchKeyword)
      ]).then(responses => {
        responses.forEach(response => {
          console.log(response);
          // 在这里处理每个请求的返回数据，你可以根据具体需求进行逻辑处理
          if (response && response.data) {
            // 在这里可以处理返回的课程数据
            this.course = response.data;
            console.log(this.course);

            // 将每个课程的 cid 存入 cids 数组中
            this.course.forEach(courseItem => {
              this.cids.push(courseItem.cid);
            });
            console.log("cids 数组已更新:", this.cids);
          }
        });
      }).catch(error => {
        console.log(error);
      });
      // 发起初始搜索请求
      // this.$request.get('/time/selectBycid/' + this.cids[0]).then(res => {
      //   console.log(res);
      //   if (res && res.data) {
      //     this.times = res.data;
      //     console.log("time 数组已更新:",this.times);
      //   }
      //
      // })
    },



 //切换显示方法的属性
    toggleFormat() {
      this.showContent1 = !this.showContent1;
    },

    handleClick(courseName) {
      // 处理点击事件的逻辑，比如跳转到其他页面
      console.log('文本被点击了');
      // 先清空搜索框的值
      this.searchKeyword = '';
      // 点击事件，将课程名称赋值给搜索框
      this.searchKeyword = courseName;
      // 触发重新搜索的操作，您可以根据实际情况进行搜索逻辑的处理
      this.search();
    },
    handleEnter(){
      this.search();
    },


    },


};



</script>

<style>

td {
  //border: 1px solid black;
  width: 60px;
  height: 50px;
  padding: 10px;
  text-align: left;

}
table {
  border-collapse: collapse;
  width: 800px;
  height: 280px;
}
td:last-child {
  border-right: none;
}
tr.dashed-row td {
  border-bottom: 1px dashed #c9c8c8; /* 设置虚线下边框 */
}

.text {
  font-size: 14px;
}

.item {
  padding: 18px 0;
}

.box-card {
  width: 480px;
}

.scrollable-container::-webkit-scrollbar {
  display: none;
}


/* 通用样式确保可以滚动，不显示滚动条 */
.scrollable-container {
  -ms-overflow-style: none; /* 对于IE和Edge */
  height: 580px;
  overflow-y: scroll;
}


</style>

