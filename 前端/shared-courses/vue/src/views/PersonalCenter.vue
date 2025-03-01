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
      <el-drawer
          title="修改个人信息"
          :visible.sync="drawer"
          :direction="direction"
          :before-close="handleClose">
        <el-divider></el-divider>
        <div style="margin-left: 20px;margin-right: 50px">
          <el-form>
            <el-form-item>
              <div style="display: flex">
                <el-upload
                    class="avatar-uploader"
                    action="http://localhost:8080/file/upload"
                    :show-file-list="false"
                    :on-success="handleAvatarSuccess"
                    :before-upload="beforeAvatarUpload">
                  <img v-if="imageUrl" :src="imageUrl" class="avatar">
                  <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                </el-upload>
                <el-form style="margin-left: 30px;margin-top: 5px">
                  <el-form-item prop="username">
                    <el-input prefix-icon="el-icon-user" size="medium" placeholder="请输入新的用户名" v-model="newUser.username"></el-input>
                  </el-form-item>
                  <el-form-item prop="password">
                    <el-input prefix-icon="el-icon-lock" size="medium" show-password placeholder="请输入新的密码" v-model="newUser.password"></el-input>
                  </el-form-item>
                </el-form>
              </div>
            </el-form-item>
            <el-form-item prop="age">
              <el-input prefix-icon="el-icon-ship" size="medium" placeholder="请输入修改后的年龄" v-model="newUser.age"></el-input>
            </el-form-item>
            <el-form-item prop="grade">
<!--              <el-input prefix-icon="el-icon-medal" size="medium" placeholder="请输入修改后的年级" v-model="newUser.grade"></el-input>-->
              <el-select v-model="newUser.grade" placeholder="请选择修改后的年级" size="medium" style="width: 375px" >
                <el-option
                    prefix-icon="el-icon-medal"
                    v-for="item in options"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                </el-option>
              </el-select>
            </el-form-item>
            <el-form-item prop="ucolloge">
              <el-input prefix-icon="el-icon-school" size="medium" placeholder="请输入修改后的大学名称" v-model="newUser.ucolloge"></el-input>
            </el-form-item>
            <el-form-item>
<!--              <el-button style="margin-left: 300px" type="primary" round @click="change">提 交</el-button>-->
              <el-popover
                  placement="right"
                  width="300"
                  trigger="click">
                <el-form style="display: flex;">
                  <el-form-item style="margin-right: 10px">
                    <el-input prefix-icon="el-icon-lock" size="mini" show-password placeholder="请输入密码" v-model="tempPassWord"></el-input>
                  </el-form-item>
                  <el-form-item>
                    <el-button  @click="change">确认</el-button>
                  </el-form-item>
                </el-form>
                <el-button style="margin-left: 300px" slot="reference">提 交</el-button>
              </el-popover>
            </el-form-item>
          </el-form>
        </div>
      </el-drawer>
    </el-header>
    <el-container>


      <el-aside style="background-color: greenyellow;height: 690px">
        <div>
          <template>
            <el-col :span="12">
              <div class="demo-basic--circle">
                <div class="block" style="margin-left: 35px;margin-top: 20px"><el-avatar :size="230" :src="circleUrl"></el-avatar></div>
              </div>
            </el-col>
            <el-col>
              <div style="margin-left: 70px;margin-top: 20px">
                <span style="font-size: 20px">{{ user.grade }}</span>
                <span style="font-size: 20px;font-weight: bold">·</span>
                <span style="font-size: 20px">{{ user.age }}</span>
                <span style="font-size: 20px;font-weight: bold">·</span>
                <span style="font-size: 20px">{{ user.upnum }}</span>
                <span style="font-size: 20px;font-weight: bold">·</span>
                <span style="font-size: 20px">{{ user.attnum }}</span>
              </div>
            </el-col>
          </template>
        </div>
      </el-aside>



      <el-main width="1100px" style="background-color: #f5f5f5 ;height: 690px;padding: 0;">
        <div style="height: 100%;margin: 0">
          <el-tabs type="border-card">


            <el-tab-pane>
              <span slot="label"><i class="el-icon-date"></i> 个人信息</span>
              <div style="height: 600px;background-color: #c6e1f3;border-radius: 10px; box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);">
                <div style="display: flex;">
                  <el-form>
                    <el-form-item style="margin-top: 25px;margin-left: 50px">
                      <span style="font-size: 25px;font-family: '楷体', 'KaiTi', 'STKaiti', 'SimSun', 'AR PL UKai CN', 'AR PL UKai TW', serif;">我的账号：{{user.username}}</span>
                    </el-form-item>
                    <el-form-item style="margin-left: 50px;">
                      <span style="font-size: 25px;font-family: '楷体', 'KaiTi', 'STKaiti', 'SimSun', 'AR PL UKai CN', 'AR PL UKai TW', serif;">我的大学：{{user.ucolloge}}</span>
                      <el-button @click="drawer = true" type="primary" style="margin-left: 700px;">
                        修改信息
                      </el-button>
                    </el-form-item>
                  </el-form>
                </div>
                <div>

                  <div class="scrollable-container11" style="max-height: 430px; overflow-y: auto;">
                    <el-card class="box-card" style="width: 1200px;height: 430px"> <!-- Increased width -->
                      <div v-for="(key, index) in Object.keys(course)" :key="index" class="text item" style="height: 100px">
                        <el-link @click="redirectToCoursePage(course[index].coursename,course[index].teacher,course[index].ccolloge,
        course[index].area,course[index].introduce,course[index].roomnum,course[index].warn,course[index].reservenum,
        course[index].score,course[index].likenum,course[index].cid,course[index].cpicture)" target="_self">
                          <div  style="margin: 20px;display: flex">
                            <img :src="course[index].cpicture" style="width: 80px; height: auto; box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);">
                            <span style="margin-top: 20px ;margin-left: 15px; font-size: 40px ;font-family: '楷体', 'KaiTi', 'STKaiti', 'SimSun', 'AR PL UKai CN', 'AR PL UKai TW', serif;">课程名称：{{course[index].coursename}}</span>
                            <span style="margin-top: 45px;font-family: '楷体', 'KaiTi', 'STKaiti', 'SimSun', 'AR PL UKai CN', 'AR PL UKai TW', serif;">({{course[index].ccolloge}})</span>
<!--                            <table class="course-table" data="course">-->
<!--                              <tr>-->
<!--                                <td rowspan="2" style="text-align: center; vertical-align: middle;">-->
<!--                                  <img :src="course[index].cpicture" style="max-width: 100%; height: auto; border-radius: 50%; box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);">-->
<!--                                </td>-->
<!--                                <td style="border-right: 1px solid #c9c8c8;vertical-align: bottom">课程院校：</td>-->
<!--                                <td style="border-right: 1px solid #c9c8c8;vertical-align: bottom">课程地点：</td>-->
<!--&lt;!&ndash;                                <td style="border-right: 1px solid #c9c8c8;vertical-align: bottom">上课日期：</td>&ndash;&gt;-->
<!--                                <td style="border-right: 1px solid #c9c8c8;vertical-align: bottom">任课老师：</td>-->
<!--                                <td style="vertical-align: bottom">剩余容量：</td>-->
<!--                              </tr>-->
<!--                              <tr class="dashed-row" datatype="user" data="course">-->
<!--                                <td style="border-right: 1px solid #c9c8c8;">{{course[index].ccolloge}}</td>-->
<!--                                <td style="border-right: 1px solid #c9c8c8;">{{course[index].area }}</td>-->
<!--&lt;!&ndash;                                <td style="border-right: 1px solid #c9c8c8;">11.9</td>&ndash;&gt;-->
<!--                                <td style="border-right: 1px solid #c9c8c8;">{{course[index].teacher }}</td>-->
<!--                                <td>{{ course[index].roomnum - course[index].pernum }}</td>-->
<!--                              </tr>-->
<!--                              <tr>-->
<!--                                <td rowspan="2" style="text-align: center;font-size: 20px;width: 80px">{{course[index].coursename }}</td>-->
<!--                                <td style="font-size: 15px;vertical-align: bottom">课程简介：</td>-->
<!--                              </tr>-->
<!--                              <tr>-->
<!--                                <td colspan="5">{{course[index].introduce}}</td>-->
<!--                              </tr>-->
<!--                            </table>-->
                          </div>
                        </el-link>
                      </div>
                    </el-card>
                  </div>


                </div>
              </div>
            </el-tab-pane>








            <el-tab-pane label="个人课表">

              <div style="background-color: #c6e1f3; padding: 20px; border-radius: 10px; box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);">
                <div>
                  <table style="width: 100%; text-align: center; border-collapse: collapse; border: 1px solid #ccc;">
                    <thead>
                    <tr>
                      <th style="padding: 5px; width: 8%; border: 1px solid #ccc;">时间/星期</th>
                      <th style="border: 1px solid #ccc;">星期一</th>
                      <th style="border: 1px solid #ccc;">星期二</th>
                      <th style="border: 1px solid #ccc;">星期三</th>
                      <th style="border: 1px solid #ccc;">星期四</th>
                      <th style="border: 1px solid #ccc;">星期五</th>
                      <th style="border: 1px solid #ccc;">星期六</th>
                      <th style="border: 1px solid #ccc;">星期天</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                      <td style="padding: 5px; height: 100px; border: 1px solid #ccc;">第一节课</td>
                      <td style=" border: 1px solid #ccc;">{{timetable[0].course1}}</td>
                      <td style=" border: 1px solid #ccc;">{{ timetable[0].course2 }}</td>
                      <td style=" border: 1px solid #ccc;">{{ timetable[0].course3 }}</td>
                      <td style=" border: 1px solid #ccc;">{{ timetable[0].course4 }}</td>
                      <td style=" border: 1px solid #ccc;">{{ timetable[0].course5 }}</td>
                      <td style=" border: 1px solid #ccc;">{{ timetable[0].course6 }}</td>
                      <td style="border: 1px solid #ccc;">{{ timetable[0].course7 }}</td>
                    </tr>
                    <tr>
                      <td style="padding: 5px; height: 100px; border: 1px solid #ccc;">第二节课</td>
                      <td style=" border: 1px solid #ccc;">{{ timetable[0].course8 }}</td>
                      <td style=" border: 1px solid #ccc;">{{ timetable[0].course9 }}</td>
                      <td style=" border: 1px solid #ccc;">{{ timetable[0].course10 }}</td>
                      <td style=" border: 1px solid #ccc;">{{ timetable[0].course11 }}</td>
                      <td style=" border: 1px solid #ccc;">{{ timetable[0].course12 }}</td>
                      <td style=" border: 1px solid #ccc;">{{ timetable[0].course13 }}</td>
                      <td style="border: 1px solid #ccc;">{{ timetable[0].course14 }}</td>
                    </tr>
                    <tr>
                      <td style="padding: 5px; height: 100px; border: 1px solid #ccc;">第三节课</td>
                      <td style=" border: 1px solid #ccc;">{{ timetable[0].course15 }}</td>
                      <td style=" border: 1px solid #ccc;">{{ timetable[0].course16 }}</td>
                      <td style=" border: 1px solid #ccc;">{{ timetable[0].course17 }}</td>
                      <td style=" border: 1px solid #ccc;">{{ timetable[0].course18 }}</td>
                      <td style=" border: 1px solid #ccc;">{{ timetable[0].course19 }}</td>
                      <td style=" border: 1px solid #ccc;">{{ timetable[0].course20 }}</td>
                      <td style="border: 1px solid #ccc;">{{ timetable[0].course21 }}</td>
                    </tr>
                    <tr>
                      <td style="padding: 5px; height: 100px; border: 1px solid #ccc;">第四节课</td>
                      <td style=" border: 1px solid #ccc;">{{ timetable[0].course22 }}</td>
                      <td style=" border: 1px solid #ccc;">{{ timetable[0].course23 }}</td>
                      <td style=" border: 1px solid #ccc;">{{ timetable[0].course24 }}</td>
                      <td style=" border: 1px solid #ccc;">{{ timetable[0].course25 }}</td>
                      <td style=" border: 1px solid #ccc;">{{ timetable[0].course26 }}</td>
                      <td style=" border: 1px solid #ccc;">{{ timetable[0].course27 }}</td>
                      <td style="border: 1px solid #ccc;">{{ timetable[0].course28 }}</td>
                    </tr>
                    <tr>
                      <td style="padding: 5px; height: 100px; border: 1px solid #ccc;">第五节课</td>
                      <td style=" border: 1px solid #ccc;">{{ timetable[0].course29 }}</td>
                      <td style=" border: 1px solid #ccc;">{{ timetable[0].course30 }}</td>
                      <td style=" border: 1px solid #ccc;">{{ timetable[0].course31 }}</td>
                      <td style=" border: 1px solid #ccc;">{{ timetable[0].course32 }}</td>
                      <td style=" border: 1px solid #ccc;">{{ timetable[0].course33 }}</td>
                      <td style=" border: 1px solid #ccc;">{{ timetable[0].course34 }}</td>
                      <td style="border: 1px solid #ccc;">{{ timetable[0].course35 }}</td>
                    </tr>
                    </tbody>
                  </table>
                </div>
                <el-button circle icon="el-icon-plus" @click="dialogFormVisible = true" style="margin-top: 10px"></el-button>
                <el-button circle icon="el-icon-delete" style="margin-left: 20px;margin-top: 10px" @click="showDeleteConfirmation"></el-button>
              </div>

<!--              <el-button type="text" @click="dialogFormVisible = true" style="">添加课程</el-button>-->
              <el-dialog title="添加课程" :visible.sync="dialogFormVisible" width="50%">
                <el-form :model="form" label-width="100px">

                  <el-form-item label="课程名称" style="margin-bottom: 20px;">
                    <el-input v-model="form.name" autocomplete="off" placeholder="请输入课程名称"></el-input>
                  </el-form-item>
                  <el-form-item label="选择日期" style="margin-bottom: 20px;">
                    <el-date-picker
                        style="width: 100%"
                        type="dates"
                        value-format="yyyy-MM-dd"
                        v-model="dayif"
                        placeholder="选择一个或多个日期">
                    </el-date-picker>
                  </el-form-item>
                  <el-form-item label="选择课时" style="margin-bottom: 20px;">
                    <el-select v-model="coursetime.rank" placeholder="请选择" style="width: 100%;">
                      <el-option
                          v-for="item in optionsL"
                          :key="item.value"
                          :label="item.label"
                          :value="item.value">
                      </el-option>
                    </el-select>
                  </el-form-item>
                </el-form>
                <div slot="footer" class="dialog-footer">
                  <el-button @click="dialogFormVisible = false">取消</el-button>
                  <el-button type="primary" @click="submitForm">确定</el-button>
                </div>
              </el-dialog>



<!--              <el-button type="text" style="margin-left: 20px" @click="showDeleteConfirmation">删除课程</el-button>-->
              <el-dialog
                  title="删除课程"
                  :visible.sync="dialogVisible"
                  width="30%"
              >
                <div style="text-align: center;">
                  <span >选择课程时间</span>
                  <el-select v-model="selectedDay" placeholder="请选择">
                    <el-option label="周一" value="1"></el-option>
                    <el-option label="周二" value="2"></el-option>
                    <el-option label="周三" value="3"></el-option>
                    <el-option label="周四" value="4"></el-option>
                    <el-option label="周五" value="5"></el-option>
                    <el-option label="周六" value="6"></el-option>
                    <el-option label="周日" value="7"></el-option>
                  </el-select>
                </div>

                <!-- 添加选择课时的部分 -->
                <div style="text-align: center; margin-top: 20px;">
                  <span>选择上课时间段</span>
                  <el-select v-model="selectedCourse" placeholder="请选择">
                    <el-option label="1-2节课" value="1"></el-option>
                    <el-option label="3-4节课" value="2"></el-option>
                    <el-option label="5-6节课" value="3"></el-option>
                    <el-option label="7-8节课" value="4"></el-option>
                    <el-option label="9-10节课" value="5"></el-option>
                  </el-select>
                </div>

                <span slot="footer" class="dialog-footer" style="justify-content: center;">
        <el-button @click="dialogVisible = false">取消</el-button>
        <el-button type="primary" @click="confirmDelete">确定</el-button>
    </span>
              </el-dialog>

            </el-tab-pane>








            <el-tab-pane label="学习计划">
              <div style="background-color: #c6e1f3;height: 600px;border-radius: 10px; box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);">
                <div v-if="showContent" style="display: flex;margin-right: 18px">
                  <div class="block" style="margin-top: 18px;flex: 1">
                    <el-timeline>
                      <el-timeline-item timestamp="初出茅庐" placement="top">
                        <div v-if="state.state1">
                          <el-card style="height: 133px">
                            <el-time-select
                                style="width: 120px"
                                placeholder="起始时间"
                                v-model="time.time1.startTime"
                                :picker-options="{
                            start: '06:30',
                            step: '00:15',
                            end: '22:30'
                      }">
                            </el-time-select>
                            <el-time-select
                                style="width: 120px;margin-left: 10px"
                                placeholder="结束时间"
                                v-model="time.time1.endTime"
                                :picker-options="{
                            start: '06:30',
                            step: '00:15',
                            end: '22:30',
                            minTime: time.time1.startTime
                     }">
                            </el-time-select>
                            <div style="margin-top: 10px;display: flex">
                              <el-input v-model="time.time1.content" placeholder="请输入内容"></el-input>
                              <el-tooltip content="上传计划" placement="bottom">
                                <el-button @click="updatePlan(1)" style="margin-left: 5px" icon="el-icon-s-promotion" circle></el-button>
                              </el-tooltip>
                              <el-tooltip content="计划已完成" placement="bottom">
                                <el-button @click="finish(1)" style="margin-left: 5px" icon="el-icon-check" circle></el-button>
                              </el-tooltip>
                            </div>
                          </el-card>
                        </div>
                        <div v-else>
                          <el-card style="height: 133px">
                            <img src="../assets/css/初出茅庐.png" class="logo">
                          </el-card>
                        </div>
                      </el-timeline-item>
                      <el-timeline-item timestamp="捷足先登" placement="top">
                        <div v-if="state.state2">
                          <el-card style="height: 133px">
                            <el-time-select
                                style="width: 120px"
                                placeholder="起始时间"
                                v-model="time.time2.startTime"
                                :picker-options="{
                            start: '06:30',
                            step: '00:15',
                            end: '22:30',
                            minTime: time.time1.endTime
                      }">
                            </el-time-select>
                            <el-time-select
                                style="width: 120px;margin-left: 10px"
                                placeholder="结束时间"
                                v-model="time.time2.endTime"
                                :picker-options="{
                            start: '06:30',
                            step: '00:15',
                            end: '22:30',
                            minTime: time.time2.startTime
                     }">
                            </el-time-select>
                            <div style="margin-top: 10px;display: flex">
                              <el-input v-model="time.time2.content" placeholder="请输入内容"></el-input>
                              <el-tooltip content="上传计划" placement="bottom">
                                <el-button @click="updatePlan(2)" style="margin-left: 5px" icon="el-icon-s-promotion" circle></el-button>
                              </el-tooltip>
                              <el-tooltip content="计划已完成" placement="bottom">
                                <el-button @click="finish(2)" style="margin-left: 5px" icon="el-icon-check" circle></el-button>
                              </el-tooltip>
                            </div>
                          </el-card>
                        </div>
                        <div v-else>
                          <el-card style="height: 133px">
                            <img src="../assets/css/捷足先登.png" class="logo">
                          </el-card>
                        </div>
                      </el-timeline-item>
                      <el-timeline-item timestamp="循序渐进" placement="top">
                        <div v-if="state.state3">
                          <el-card style="height: 133px">
                            <el-time-select
                                style="width: 120px"
                                placeholder="起始时间"
                                v-model="time.time3.startTime"
                                :picker-options="{
                            start: '06:30',
                            step: '00:15',
                            end: '22:30',
                            minTime: time.time2.endTime
                      }">
                            </el-time-select>
                            <el-time-select
                                style="width: 120px;margin-left: 10px"
                                placeholder="结束时间"
                                v-model="time.time3.endTime"
                                :picker-options="{
                            start: '06:30',
                            step: '00:15',
                            end: '22:30',
                            minTime: time.time3.startTime
                     }">
                            </el-time-select>
                            <div style="margin-top: 10px;display: flex">
                              <el-input v-model="time.time3.content" placeholder="请输入内容"></el-input>
                              <el-tooltip content="上传计划" placement="bottom">
                                <el-button @click="updatePlan(3)" style="margin-left: 5px" icon="el-icon-s-promotion" circle></el-button>
                              </el-tooltip>
                              <el-tooltip content="计划已完成" placement="bottom">
                                <el-button @click="finish(3)" style="margin-left: 5px" icon="el-icon-check" circle></el-button>
                              </el-tooltip>
                            </div>
                          </el-card>
                        </div>
                        <div v-else>
                          <el-card style="height: 133px">
                            <img src="../assets/css/循序渐进.png" class="logo">
                          </el-card>
                        </div>
                      </el-timeline-item>
                    </el-timeline>
                  </div>
                  <div class="block" style="margin-top: 18px;flex: 1">
                    <el-timeline>
                      <el-timeline-item timestamp="举一反三" placement="top">
                        <div v-if="state.state4">
                          <el-card style="height: 133px">
                            <el-time-select
                                style="width: 120px"
                                placeholder="起始时间"
                                v-model="time.time4.startTime"
                                :picker-options="{
                            start: '06:30',
                            step: '00:15',
                            end: '22:30',
                            minTime: time.time3.endTime
                      }">
                            </el-time-select>
                            <el-time-select
                                style="width: 120px;margin-left: 10px"
                                placeholder="结束时间"
                                v-model="time.time4.endTime"
                                :picker-options="{
                            start: '06:30',
                            step: '00:15',
                            end: '22:30',
                            minTime: time.time4.startTime
                     }">
                            </el-time-select>
                            <div style="margin-top: 10px;display: flex">
                              <el-input v-model="time.time4.content" placeholder="请输入内容"></el-input>
                              <el-tooltip content="上传计划" placement="bottom">
                                <el-button @click="updatePlan(4)" style="margin-left: 5px" icon="el-icon-s-promotion" circle></el-button>
                              </el-tooltip>
                              <el-tooltip content="计划已完成" placement="bottom">
                                <el-button @click="finish(4)" style="margin-left: 5px" icon="el-icon-check" circle></el-button>
                              </el-tooltip>
                            </div>
                          </el-card>
                        </div>
                        <div v-else>
                          <el-card style="height: 133px">
                            <img src="../assets/css/举一反三.png" class="logo">
                          </el-card>
                        </div>
                      </el-timeline-item>
                      <el-timeline-item timestamp="出类拔萃" placement="top">
                        <div v-if="state.state5">
                          <el-card style="height: 133px">
                            <el-time-select
                                style="width: 120px"
                                placeholder="起始时间"
                                v-model="time.time5.startTime"
                                :picker-options="{
                            start: '06:30',
                            step: '00:15',
                            end: '22:30',
                            minTime: time.time4.endTime
                      }">
                            </el-time-select>
                            <el-time-select
                                style="width: 120px;margin-left: 10px"
                                placeholder="结束时间"
                                v-model="time.time5.endTime"
                                :picker-options="{
                            start: '06:30',
                            step: '00:15',
                            end: '22:30',
                            minTime: time.time5.startTime
                     }">
                            </el-time-select>
                            <div style="margin-top: 10px;display: flex">
                              <el-input v-model="time.time5.content" placeholder="请输入内容"></el-input>
                              <el-tooltip content="上传计划" placement="bottom">
                                <el-button @click="updatePlan(5)" style="margin-left: 5px" icon="el-icon-s-promotion" circle></el-button>
                              </el-tooltip>
                              <el-tooltip content="计划已完成" placement="bottom">
                                <el-button @click="finish(5)" style="margin-left: 5px" icon="el-icon-check" circle></el-button>
                              </el-tooltip>
                            </div>
                          </el-card>
                        </div>
                        <div v-else>
                          <el-card style="height: 133px">
                            <img src="../assets/css/出类拔萃.png" class="logo">
                          </el-card>
                        </div>
                      </el-timeline-item>
                      <el-timeline-item timestamp="融会贯通" placement="top">
                        <div v-if="state.state6">
                          <el-card style="height: 133px">
                            <el-time-select
                                style="width: 120px"
                                placeholder="起始时间"
                                v-model="time.time6.startTime"
                                :picker-options="{
                            start: '06:30',
                            step: '00:15',
                            end: '22:30',
                            minTime: time.time5.endTime
                      }">
                            </el-time-select>
                            <el-time-select
                                style="width: 120px;margin-left: 10px"
                                placeholder="结束时间"
                                v-model="time.time6.endTime"
                                :picker-options="{
                            start: '06:30',
                            step: '00:15',
                            end: '22:30',
                            minTime: time.time6.startTime
                     }">
                            </el-time-select>
                            <div style="margin-top: 10px;display: flex">
                              <el-input v-model="time.time6.content" placeholder="请输入内容"></el-input>
                              <el-tooltip content="上传计划" placement="bottom">
                                <el-button @click="updatePlan(6)" style="margin-left: 5px" icon="el-icon-s-promotion" circle></el-button>
                              </el-tooltip>
                              <el-tooltip content="计划已完成" placement="bottom">
                                <el-button @click="finish(6)" style="margin-left: 5px" icon="el-icon-check" circle></el-button>
                              </el-tooltip>
                            </div>
                          </el-card>
                        </div>
                        <div v-else>
                          <el-card style="height: 133px">
                            <img src="../assets/css/融会贯通.png" class="logo">
                          </el-card>
                        </div>
                      </el-timeline-item>
                    </el-timeline>
                  </div>
                  <div class="block" style="margin-top: 18px;flex: 1">
                    <el-timeline>
                      <el-timeline-item timestamp="知识渊博" placement="top">
                        <div v-if="state.state7">
                          <el-card style="height: 133px">
                            <el-time-select
                                style="width: 120px"
                                placeholder="起始时间"
                                v-model="time.time7.startTime"
                                :picker-options="{
                            start: '06:30',
                            step: '00:15',
                            end: '22:30',
                            minTime: time.time6.endTime
                      }">
                            </el-time-select>
                            <el-time-select
                                style="width: 120px;margin-left: 10px"
                                placeholder="结束时间"
                                v-model="time.time7.endTime"
                                :picker-options="{
                            start: '06:30',
                            step: '00:15',
                            end: '22:30',
                            minTime: time.time7.startTime
                     }">
                            </el-time-select>
                            <div style="margin-top: 10px;display: flex">
                              <el-input v-model="time.time7.content" placeholder="请输入内容"></el-input>
                              <el-tooltip content="上传计划" placement="bottom">
                                <el-button @click="updatePlan(7)" style="margin-left: 5px" icon="el-icon-s-promotion" circle></el-button>
                              </el-tooltip>
                              <el-tooltip content="计划已完成" placement="bottom">
                                <el-button @click="finish(7)" style="margin-left: 5px" icon="el-icon-check" circle></el-button>
                              </el-tooltip>
                            </div>
                          </el-card>
                        </div>
                        <div v-else>
                          <el-card style="height: 133px">
                            <img src="../assets/css/知识渊博.png" class="logo">
                          </el-card>
                        </div>
                      </el-timeline-item>
                      <el-timeline-item timestamp="登峰造极" placement="top">
                        <div v-if="state.state8">
                          <el-card style="height: 133px">
                            <el-time-select
                                style="width: 120px"
                                placeholder="起始时间"
                                v-model="time.time8.startTime"
                                :picker-options="{
                            start: '06:30',
                            step: '00:15',
                            end: '22:30',
                            minTime: time.time7.endTime
                      }">
                            </el-time-select>
                            <el-time-select
                                style="width: 120px;margin-left: 10px"
                                placeholder="结束时间"
                                v-model="time.time8.endTime"
                                :picker-options="{
                            start: '06:30',
                            step: '00:15',
                            end: '22:30',
                            minTime: time.time8.startTime
                     }">
                            </el-time-select>
                            <div style="margin-top: 10px;display: flex">
                              <el-input v-model="time.time8.content" placeholder="请输入内容"></el-input>
                              <el-tooltip content="上传计划" placement="bottom">
                                <el-button @click="updatePlan(8)" style="margin-left: 5px" icon="el-icon-s-promotion" circle></el-button>
                              </el-tooltip>
                              <el-tooltip content="计划已完成" placement="bottom">
                                <el-button @click="finish(8)" style="margin-left: 5px" icon="el-icon-check" circle></el-button>
                              </el-tooltip>
                            </div>
                          </el-card>
                        </div>
                        <div v-else>
                          <el-card style="height: 133px">
                            <img src="../assets/css/登峰造极.png" class="logo">
                          </el-card>
                        </div>
                      </el-timeline-item>
                      <el-timeline-item timestamp="清风明月" placement="top">
                        <div v-if="state.state9">
                          <el-card style="height: 133px">
                            <el-time-select
                                style="width: 120px"
                                placeholder="起始时间"
                                v-model="time.time9.startTime"
                                :picker-options="{
                            start: '06:30',
                            step: '00:15',
                            end: '22:30',
                            minTime: time.time8.endTime
                      }">
                            </el-time-select>
                            <el-time-select
                                style="width: 120px;margin-left: 10px"
                                placeholder="结束时间"
                                v-model="time.time9.endTime"
                                :picker-options="{
                            start: '06:30',
                            step: '00:15',
                            end: '22:30',
                            minTime: time.time9.startTime
                     }">
                            </el-time-select>
                            <div style="margin-top: 10px;display: flex">
                              <el-input v-model="time.time9.content" placeholder="请输入内容"></el-input>
                              <el-tooltip content="上传计划" placement="bottom">
                                <el-button @click="updatePlan(9)" style="margin-left: 5px" icon="el-icon-s-promotion" circle></el-button>
                              </el-tooltip>
                              <el-tooltip content="计划已完成" placement="bottom">
                                <el-button @click="finish(9)" style="margin-left: 5px" icon="el-icon-check" circle></el-button>
                              </el-tooltip>
                            </div>
                          </el-card>
                        </div>
                        <div v-else>
                          <el-card style="height: 133px">
                            <img src="../assets/css/清风明月.png" class="logo">
                          </el-card>
                        </div>
                      </el-timeline-item>
                    </el-timeline>
                  </div>
                </div>
                <div v-else style="display: flex;margin-right: 18px;margin-bottom: 5px">
                  <div style="background-color: white;margin-top: 15px;margin-left: 15px;width: 1200px;height: 533px">
                    <div style="margin-top: 15px;margin-left: 15px;width: 1000px">
                      <el-collapse v-model="activeNames" @change="handleChange" accordion>
                        <el-collapse-item title="周一是新的一周的开始" name="1">
                          <div>
                            <el-input
                                @blur="updateweekplan()"
                                type="textarea"
                                :autosize="{ maxRows: 7}"
                                placeholder="请输入你一周的计划吧！"
                                v-model="weekplan.mon">
                            </el-input>
                          </div>
                        </el-collapse-item>
                        <el-collapse-item title="周二要跟上重要的第二步" name="2">
                          <div>
                            <el-input
                                type="textarea"
                                :autosize="{ maxRows: 7}"
                                placeholder="请输入你一周的计划吧！"
                                v-model="weekplan.tue">
                            </el-input>
                          </div>
                        </el-collapse-item>
                        <el-collapse-item title="周三是发力的腰部" name="3">
                          <div>
                            <el-input
                                type="textarea"
                                :autosize="{ maxRows: 7}"
                                placeholder="请输入你一周的计划吧！"
                                v-model="weekplan.wed">
                            </el-input>
                          </div>
                        </el-collapse-item>
                        <el-collapse-item title="周四拒绝疲劳继续起舞" name="4">
                          <div>
                            <el-input
                                type="textarea"
                                :autosize="{ maxRows: 7}"
                                placeholder="请输入你一周的计划吧！"
                                v-model="weekplan.thu">
                            </el-input>
                          </div>
                        </el-collapse-item>
                        <el-collapse-item title="周五的也要有好的结尾" name="5">
                          <div>
                            <el-input
                                type="textarea"
                                :autosize="{ maxRows: 7}"
                                placeholder="请输入你一周的计划吧！"
                                v-model="weekplan.fri">
                            </el-input>
                          </div>
                        </el-collapse-item>
                        <el-collapse-item title="周六老师没说弯道超车吗？" name="6">
                          <div>
                            <el-input
                                type="textarea"
                                :autosize="{ maxRows: 7}"
                                placeholder="请输入你一周的计划吧！"
                                v-model="weekplan.sat">
                            </el-input>
                          </div>
                        </el-collapse-item>
                        <el-collapse-item title="周日少放松下周少调整" name="7">
                          <div>
                            <el-input
                                type="textarea"
                                :autosize="{ maxRows: 7}"
                                placeholder="请输入你一周的计划吧！"
                                v-model="weekplan.sun">
                            </el-input>
                          </div>
                        </el-collapse-item>
                      </el-collapse>
                    </div>
                  </div>
                </div>
<!--                <el-button type="text" @click="toggleFormat" style="margin-left: 1000px;color: #1f94dc;-->
<!--              font-size: 15px">日/周</el-button>-->
                <div style="margin-left: 60px">
                  <el-tooltip content="日、周计划切换" placement="top">
                    <el-button @click="toggleFormat" icon="el-icon-refresh" circle></el-button>
                  </el-tooltip>
                  <el-tooltip content="删除本次日计划" placement="top">
                    <el-button @click="deletedayplan" icon="el-icon-delete" circle></el-button>
                  </el-tooltip>
                  <el-tooltip content="删除本次周计划" placement="top">
                    <el-button @click="deleteweekplan" icon="el-icon-delete" circle></el-button>
                  </el-tooltip>
                </div>
              </div>
            </el-tab-pane>


            <el-tab-pane v-if="power1">
              <span slot="label">举报管理</span>
              <div  style="background-color: #c6e1f3;height: 600px; overflow: auto;border-radius: 10px; box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);">
                <div style="margin-top: 10px;margin-left: 10px">
                  <div v-for="(course, index) in date" :key="index" style="margin-bottom: 10px;width: 100%">
                    <el-card style="margin-left: 5px;margin-right: 5px;" class="box-card">
                      <div slot="header" class="clearfix">
                        <span>{{ course.coursename }}({{course.cid}})</span>
                        <el-button @click="ok(course.cid)" style="float: right; padding: 3px 0;margin-left: 10px" type="text">完成反馈</el-button>
                        <el-button @click="redirectToCoursePage(course.coursename,course.teacher,course.ccolloge,
        course.area,course.introduce,course.roomnum,course.warn,course.reservenum,
        course.score,course.likenum,course.cid,course.cpicture)" style="float: right; padding: 3px 0" type="text">查看课程</el-button>
                      </div>
                      <div v-for="(item, index) in course.report" :key="index" class="text item">
                        {{ item }}
                      </div>

<!--                      <div class="text item">-->
<!--                        {{ course.report }}-->
<!--                      </div>-->
                    </el-card>
                  </div>
                </div>
              </div>
            </el-tab-pane>
            <el-tab-pane v-if="power2">
              <span slot="label">账户管理</span>
              <div  style="background-color: #c6e1f3;height: 600px; overflow: auto;border-radius: 10px; box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);">
                <div style="display: flex;margin-top: 15px">
                  <span style="flex: 1.7;font-family: '楷体';font-size: 23px;margin-left: 30px">添加管理员账户</span>
                  <el-input style="flex: 4;" v-model="usernametoup" placeholder="请输入该用户的用户名"></el-input>
                  <el-button @click="up" style="flex: 0.5;" type="primary">添加</el-button>
                  <div style="flex: 4;"></div>
                </div>
                <div style="display: flex;margin-top: 15px">
                  <span style="flex: 1.7;font-family: '楷体';font-size: 23px;margin-left: 30px">删除管理员账户</span>
                  <el-input style="flex: 4;" v-model="usernametodown" placeholder="请输入该用户的用户名"></el-input>
                  <el-button @click="down" style="flex: 0.5;" type="primary">删除</el-button>
                  <div style="flex: 4;"></div>
                </div>
                <div>
                  <div style="margin-bottom: 10px;width: 100%">
                    <el-card style="margin-left: 30px;margin-right: 5px;margin-top: 50px;margin-right: 200px" class="box-card">
                      <div slot="header" class="clearfix">
                        <span style="font-size: 25px;font-family: '楷体', 'KaiTi', 'STKaiti', 'SimSun', 'AR PL UKai CN', 'AR PL UKai TW', serif;">管理员列表</span>
                      </div>
                      <div v-for="(user, index) in power" :key="index">
                       <div style="margin-bottom: 18px">
                         <span style="font-size: 25px;font-family: '楷体', 'KaiTi', 'STKaiti', 'SimSun', 'AR PL UKai CN', 'AR PL UKai TW', serif;">{{ user.username }}({{user.uid}})</span>
                       </div>
                      </div>
                    </el-card>
                  </div>
                </div>
              </div>
            </el-tab-pane>
          </el-tabs>
        </div>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
export default{
  data(){
    return{
      test: false,
      hcircleUrl: 'https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png',
      input: '',
      restaurants: [],
      username:'',
      usernametoup:'',
      usernametodown:'',
      size: 'medium',
      power:[],
      date:[],
      simpleCourse:{
        cid:'',
        coursename:'',
        report:'',
      },
      power1:false,
      power2:false,
      dialogVisible: false,
      selectedDay: '',
      selectedCourse: [],
      cids:[],
      time1:[],
      course: [], // 从后端获取的所有课程数据
      buttonLabel: '查看我投稿的课程',
      courseNameCI:'',
      changeName:'',
      optionsL: [{
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
      dayif:'',
      dialogTableVisible: false,
      dialogFormVisible: false,
      form: {
        name: '',
        region: '',
        date1: '',
        date2: '',
        delivery: false,
        type: [],
        resource: '',
        desc: ''
      },
      formLabelWidth: '120px',

      uid:'',
      weekplan:{
        wid:'',
        uid:'',
        mon:'',
        tue:'',
        wed:'',
        thu:'',
        fri:'',
        sat:'',
        sun:'',
      },
      state:{
        state1: true,
        state2: '',
        state3: '',
        state4: '',
        state5: '',
        state6: '',
        state7: '',
        state8: '',
        state9: '',
      },
      newTime:{
        did:'',
        uid:'',
        p1:'',
        p2:'',
        p3:'',
        p4:'',
        p5:'',
        p6:'',
        p7:'',
        p8:'',
        p9:'',
      },
      time:{
        time1:{
          startTime:'',
          endTime:'',
          content:''
        },
        time2:{
          startTime:'',
          endTime:'',
          content:''
        },
        time3:{
          startTime:'',
          endTime:'',
          content:''
        },
        time4:{
          startTime:'',
          endTime:'',
          content:''
        },
        time5:{
          startTime:'',
          endTime:'',
          content:''
        },
        time6:{
          startTime:'',
          endTime:'',
          content:''
        },
        time7:{
          startTime:'',
          endTime:'',
          content:''
        },
        time8:{
          startTime:'',
          endTime:'',
          content:''
        },
        time9:{
          startTime:'',
          endTime:'',
          content:''
        }
      },
      activeNames: [''],
      showContent: true,
      imageUrl: '',
      circleUrl:'',
      options: [{
        value: '大一',
        label: '大一'
      }, {
        value: '大二',
        label: '大二'
      }, {
        value: '大三',
        label: '大三'
      }, {
        value: '大四',
        label: '大四'
      }, {
        value: '研一',
        label: '研一'
      },{
        value: '研二',
        label: '研二'
      }],
      user: {
        uid:'',
        code: '',
        username: '',
        password: '',
        age:'',
        grade:'',
        ucolloge:'',
        upicture:'',
        upnum:'',
        attnum:'',
      },
      newUser: {
        uid:'',
        code: '',
        username: '',
        password: '',
        age:'',
        grade:'',
        ucolloge:'',
        upicture:'',
        upnum:'',
        attnum:'',
        power:'',
      },
      drawer: false,
      direction: 'rtl',
      tempPassWord:'',
      timetable:[],
    }

  },

  methods: {
    down(){
      this.$request.post('/user/down',this.usernametodown).then(res=>{
        if(res.code==='200'){
          this.$message.success('删除成功')
          // localStorage.setItem("honey-user",JSON.stringify(res.data))//存用户数据
        }else {
          this.$message.error(res.msg)
        }
      })
    },

    up(){
      this.$request.post('/user/up',this.usernametoup).then(res=>{
        if(res.code==='200'){
          this.$message.success('添加成功')
          // localStorage.setItem("honey-user",JSON.stringify(res.data))//存用户数据
        }else {
          this.$message.error(res.msg)
        }
      })
    },

    ok(i){
      this.$request.post('/course/delete',i);
      this.$message.success('完成反馈成功');
      //location.reload();
      setTimeout(function() {
        location.reload();
      }, 2000); // 2000 毫秒即为两秒
    },
    showDeleteConfirmation() {
      this.dialogVisible = true;
    },
    confirmDelete() {
      // 将选择的日期和时间段转换成数字并传递到删除课程的方法中进行处理
      const dayNumber = parseInt(this.selectedDay);
      this.deleteCourse(dayNumber, this.selectedCourse);
      this.dialogVisible = false; // 关闭选择框
    },
    deleteCourse(dayOfWeek, rank) {
      // 在这里执行删除课程的逻辑，参数day为选择的日期（数字形式），courses为选择的时间段（数字形式）
      console.log("在周几：", dayOfWeek);
      console.log("哪节课：", rank);

      const dayOfWeekMapping = {
        1: { 1: 'course1', 2: 'course2', 3: 'course3', 4: 'course4', 5: 'course5', 6: 'course6', 0: 'course7' },
        2: { 1: 'course8', 2: 'course9', 3: 'course10', 4: 'course11', 5: 'course12', 6: 'course13', 0: 'course14' },
        3: { 1: 'course15', 2: 'course16', 3: 'course17', 4: 'course18', 5: 'course19', 6: 'course20', 0: 'course21' },
        4: { 1: 'course22', 2: 'course23', 3: 'course24', 4: 'course25', 5: 'course26', 6: 'course27', 0: 'course28' },
        5: { 1: 'course29', 2: 'course30', 3: 'course31', 4: 'course32', 5: 'course33', 6: 'course34', 0: 'course35' }
      };
      const mappingValue = dayOfWeekMapping[rank]?.[dayOfWeek];
      if (mappingValue !== undefined) {
        console.log("要修改的名字:", mappingValue);
        this.changeName = mappingValue;
      } else {
        console.log("条件未匹配");
        this.changeName = undefined;
      }

      console.log("删除的哪节课:",this.changeName);
      console.log("删除用户的uid:",this.uid);

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
          if (this.timetable[0][dynamicChangeName] === null ) {
            // const existingCourseMessage = "当前时间段没课程请重新选择";
            // window.alert(existingCourseMessage);

            this.$message.error('当前时间段没课程请重新选择');

          } else if (this.timetable[0][dynamicChangeName] != null) {
            this.$request.post('/TimeTable/updateByUidAndChangeName', {
              changeName: this.changeName.toString(),
              uid: this.uid
            })
                .then(res => {

                  this.$message.success('删除成功');
                  location.reload();
                })
                .catch(error => {
                  // 捕获请求错误
                  console.error('Error: ', error);
                  this.$message.error('请求发生错误，请稍后重试');
                });


          }
        }
      }).catch(error => {
        // 异步请求失败时的处理
        console.error('Error fetching data:', error);
      });



    },




    redirectToCoursePage(coursename, teacher, ccolloge, area, introduce, roomnum, warn, reservenum, score, likenum, cid,cpicture) {
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
          cpicture:cpicture,
        }
      });
    },

    fetchData(courseIndex, i,iid,rank,dayOfWeek) {



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

    toggleButton() {
      this.isVisible = !this.isVisible; // 切换 isVisible 的值
      if (this.buttonLabel === '查看我投稿的课程') {
        this.buttonLabel = '查看我的课表';
      } else {
        this.buttonLabel = '查看我投稿的课程';
      }
    },

    submitForm() {
      // 获取表单数据
      const formData = {
        name: this.form.name,
        dates: this.dayif,
        rank: this.coursetime.rank
      };

      // 单独输出表单数据的各个字段值
      console.log("提交的课程名称：", formData.name);
      console.log("提交的日期：", formData.dates);
      console.log("提交的课时选择：", formData.rank);

      // 输出整体表单数据到控制台
      console.log("提交的表单数据：", formData);
      const rank=formData.rank;
      // 循环输出每一个日期的年、月、日以及星期几
      for (const date of formData.dates) {
        const currentDate = new Date(date);
        const year = currentDate.getFullYear();
        const month = currentDate.getMonth() + 1; // 月份是从0开始的，所以要加1
        const day = currentDate.getDate();
        const dayOfWeek = currentDate.getDay(); // 获取星期几
        // 将星期几转换为对应的文字表示
        const weekdays = ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"];
        const dayOfWeekText = weekdays[dayOfWeek];
        console.log("日期：", year, "年", month, "月", day, "日", dayOfWeekText);
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
      }


      this.courseNameCI=formData.name;
      console.log(this.changeName);
      console.log(this.courseNameCI );
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
          if (this.timetable[0][dynamicChangeName] === null) {
            console.log("这个课程里面没有数据可以添加课程")
            this.$request.post('/TimeTable/update', {
              changeName: this.changeName.toString(),
              course: this.courseNameCI .toString(),
              uid: this.uid
            })
                .then(res => {

                    this.$message.success('添加成功');
                  // 刷新页面
                  location.reload();
                })
                .catch(error => {
                  // 捕获请求错误
                  console.error('Error: ', error);
                  this.$message.error('请求发生错误，请稍后重试');
                });

          } else if (this.timetable[0][dynamicChangeName] != null) {
            // 如果存在数据，给用户弹出提示框
            const existingCourseMessage = "当前时间段你有课程，请先去课表删除该时间段的原有课程再选择当前课程";
            window.alert(existingCourseMessage);
          }
        }
      }).catch(error => {
        // 异步请求失败时的处理
        console.error('Error fetching data:', error);
      });




      // 这里可以将数据提交到后端或进行其他处理
      // 关闭对话框
      this.dialogFormVisible = false;
    },


    updateweekplan(){
      this.$request.post('/weekplan/updateweekplan',this.weekplan).then(res=> {
        if (res.code === '200') {
          // this.$message.success('删除成功')
          // localStorage.setItem(this.weekplan, JSON.stringify(res.data))//存用户数据
          // console.log(this.newTime[key])
        } else {
          this.$message.error(res.msg)
        }
      })
    },
    deleteweekplan(){
      let key;
      Object.keys(this.weekplan).forEach((k) => {
        key = k;
        if (key !== 'uid') {
          this.weekplan[key] = '';
        }
      });
      this.$request.post('/weekplan/updateweekplan',this.weekplan).then(res=> {
        if (res.code === '200') {
          this.$message.success('删除成功')
          localStorage.setItem(this.weekplan, JSON.stringify(res.data))//存用户数据
        } else {
          this.$message.error(res.msg)
        }
      })
    },
    deletedayplan(){
      let key;
      Object.keys(this.time).forEach((k) => {
        key = k;
        this.time[key].startTime = '';
        this.time[key].endTime = '';
        this.time[key].content = '';
      });
      Object.keys(this.state).forEach((k) => {
        key = k;
        this.state[key] = true;
      });
      Object.keys(this.newTime).forEach((k) => {
        key = k;
        if (key !== 'uid') {
          this.newTime[key] = '';
        }
      });
      this.$request.post('/dayplan/updatedayplan',this.newTime).then(res=> {
        if (res.code === '200') {
          this.$message.success('删除成功')
          localStorage.setItem(this.newTime, JSON.stringify(res.data))//存用户数据
          console.log(this.newTime[key])
        } else {
          this.$message.error(res.msg)
        }
      })
    },
    updatePlan(i){
      this.newTime.uid=this.user.uid;
      let key = 'p' + i;
      this.newTime[key]=this.time['time'+i].startTime+'##'+this.time['time'+i].endTime+'##'+this.time['time'+i].content;
      this.$request.post('/dayplan/updatedayplan',this.newTime).then(res=> {
        if (res.code === '200') {
          // this.$router.push('/person')
          // window.location.reload();
          this.$message.success('上传成功')
          localStorage.setItem(this.newTime, JSON.stringify(res.data))//存用户数据
          console.log(this.newTime[key])
          let array = this.newTime[key].split('##');
          this.time['time'+i].startTime=array[0];
          this.time['time'+i].endTime=array[1];
          this.time['time'+i].content=array[2];
        } else {
          this.$message.error(res.msg)
        }
      })
    },
    finish(i){
      let key = 'p' + i;
      this.newTime[key]="$##$##$";
      this.$request.post('/dayplan/updatedayplan',this.newTime).then(res=> {
        if (res.code === '200') {
          // this.$router.push('/person')
          // window.location.reload();
          this.$message.success('梦想更进一步')
          localStorage.setItem(this.newTime, JSON.stringify(res.data))//存用户数据
          console.log(this.newTime[key])
          this.time['time'+i].startTime="$";
          this.time['time'+i].endTime="$";
          this.time['time'+i].content="$";
          this.state['state'+i]=false;
        } else {
          this.$message.error(res.msg)
        }
      })
    },
    handleChange(val) {
      console.log(val);
    },
    toggleFormat() {
      this.showContent = !this.showContent;
    },

    handleAvatarSuccess(res, file) {
      this.imageUrl = URL.createObjectURL(file.raw);
      this.newUser.upicture=res.data;
      console.log(this.newUser.upicture)
    },
    beforeAvatarUpload(file) {
      const isJPG = file.type === 'image/jpeg'|| file.type === 'image/png';
      const isLt10M = file.size / 1024 / 1024 < 10;

      if (!isJPG) {
        this.$message.error('上传头像图片只能是 JPG和PNG 格式!');
      }
      if (!isLt10M) {
        this.$message.error('上传头像图片大小不能超过 10MB!');
      }
      return isJPG && isLt10M;
    },
    handleClose(done) {
      this.$confirm('确认关闭？')
          .then(_ => {
            done();
          })
          .catch(_ => {});
    },
    logout(){
      // 清空特定键的存储项
      localStorage.removeItem("honey-user");
      this.$router.push('/login')
    },
    change(){
      if(this.tempPassWord!==this.user.password){
        this.$alert('密码错误！', '出错啦！', {
          confirmButtonText: '确定',
        });
      }else{
        for (let key in this.newUser) {
          if (this.newUser[key] === '') {
            this.newUser[key] = this.user[key];
          }
        }
        this.$request.post('/user/update',this.newUser).then(res=>{
          if(res.code==='200'){
            // this.$router.push('/person')
            window.location.reload();
            this.$message.success('修改成功')
            localStorage.setItem("honey-user",JSON.stringify(res.data))//存用户数据
          }else {
            this.$message.error(res.msg)
            let key;
            Object.keys(this.newUser).forEach((k) => {
              key = k;
              if (key !== 'uid') {
                this.newUser[key] = '';
              }
            })
          }
        })
      }
    }
  },



  mounted() {
    document.title = '个人中心';  // 设置页面标题
    const userData = localStorage.getItem("honey-user");
    const user = JSON.parse(userData);
    console.log(user);
    console.log("abc");
    if(user.power===1){
      this.power1=true;
    }else {
      if(user.power===2){
        this.power1=true;
        this.power2=true;
      }
    };
    if(userData){
      this.test=true;
      const user = JSON.parse(userData);
      this.circleUrl=user.upicture;
      this.username=user.username;};

    if(user.power===1||user.power===2){
      this.$request.post('/course/putreport').then(res => {
        if (res.code === '200') {
          // this.$message.success('上传成功成功')
          // localStorage.setItem("honey-user",JSON.stringify(res.data))//存用户数据
          this.date = res.data;
          this.date.forEach(function (element) {
            // 使用 split() 方法按照 "#$#$" 分割字符串成数组
            var stringArray = element.report.split("#$#$");
            stringArray.shift(); // 删除数组的第一个元素
            stringArray = stringArray.slice(); // 使用 slice() 方法复制数组
            for (var i = 0; i < stringArray.length; i++) {
              stringArray[i] = (i + 1) + "." + stringArray[i];
            }
            element.report = stringArray;
            console.log("aasda"); // 在这里执行你想要对每个元素执行的操作
            console.log(element); // 在这里执行你想要对每个元素执行的操作
          });
        } else {
          this.$message.error(res.msg)
        }
      })
    };
    this.user.uid=user.uid;
    this.newUser.uid=user.uid;
    this.weekplan.uid=user.uid;
    console.log(this.user.uid);
    this.$request.post('/user/search',this.user).then(res=>{
      this.user=res.data
      this.circleUrl=this.user.upicture
    })
    this.$request.post('/dayplan/selectdayplan',this.user.uid).then(res=>{
      this.newTime=res.data
      for (let i = 1; i <= 9; i++) {
        let key = 'p' + i;
        if (this.newTime[key]) {
          let array = this.newTime[key].split('##');
          this.time['time' + i].startTime = array[0];
          this.time['time' + i].endTime = array[1];
          this.time['time' + i].content = array[2];
        }
      }
      for (let i = 1; i <= 9; i++) {
        if (this.time['time' + i].startTime==="$" && this.time['time' + i].endTime==="$") {
          this.state['state' + i]= false;
        }
        else {
          this.state['state' + i]= true;
        }
        console.log(this.state['state'+i])
      }
    })
    this.$request.post('/weekplan/selectweekplan',this.user.uid).then(res=>{
      this.weekplan=res.data
    })
    // for (let i = 1; i <= 9; i++) {
    //   console.log(this.time.time1.startTime)
    //   console.log("abc")
    //   if (this.time['time' + i].startTime==="$" && this.time['time' + i].endTime==="$") {
    //     this.state['state' + i]= false;
    //   }
    //   else {
    //     this.state['state' + i]= true;
    //   }
    //   console.log(this.state['state'+i])
    // }

    this.uid=user.uid;
    console.log("登录用户的uid",this.uid);
    this.$request.post('/TimeTable/selectByUserUid', { uid: this.uid }).then(res => {
      this.timetable = res.data;
      console.log(this.timetable);

      // 访问 course1 元素
      if (this.timetable.length > 0) {
        console.log("course1 元素:", this.timetable[0].course1);
      } else {
        console.log("timetable 中没有数据");
      }
    })



    console.log("uid:", this.uid);
// 发起初始搜索请求
    this.$request.get('/course/selectByMoUid/' + this.uid).then(res => {
      console.log(res);
      if (res && res.data) {
        this.course = res.data;
        console.log(this.course);
      }
    });
    //显示管理员列表
    this.$request.post('/user/putpower').then(res=>{
      this.power = res.data;
    });
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
  width: 100px;
  height: 100px;
  line-height: 100px;
  text-align: center;
}
.avatar {
  width: 100px;
  height: 100px;
  display: block;
}


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
.scrollable-container11 {
  margin-top: 15px;
  margin-left: 50px;
  margin-right: 50px;
  overflow-x: auto;
  overflow-y: auto;
  scrollbar-width: none; /* 对于Firefox */
}
/* 针对WebKit浏览器隐藏滚动条 */
.scrollable-container11::-webkit-scrollbar {
  display: none;
}


/* 通用样式确保可以滚动，不显示滚动条 */
.scrollable-container11 {
  -ms-overflow-style: none; /* 对于IE和Edge */
  height: 600px;
  overflow-y: scroll;
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
