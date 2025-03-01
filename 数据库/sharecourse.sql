/*
 Navicat Premium Data Transfer

 Source Server         : HUNHUNBAOBAO
 Source Server Type    : MySQL
 Source Server Version : 80035
 Source Host           : localhost:3306
 Source Schema         : sharecourse

 Target Server Type    : MySQL
 Target Server Version : 80035
 File Encoding         : 65001

 Date: 08/04/2024 08:50:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `cid` int NOT NULL AUTO_INCREMENT,
  `uid` int NOT NULL,
  `coursename` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `teacher` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `ccolloge` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `area` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `pernum` int NULL DEFAULT NULL,
  `roomnum` int NULL DEFAULT NULL,
  `introduce` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `warn` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sort1` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sort2` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sort3` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `reservenum` int NULL DEFAULT NULL,
  `cumreservenum` int NULL DEFAULT NULL,
  `score` int NULL DEFAULT NULL,
  `likenum` int NULL DEFAULT NULL,
  `cpicture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `report` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 57 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (37, 12, '1ads234', 'nihdadak', '123', '1qeqaae3', 123, 131, 'asda', '121', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `course` VALUES (38, 12, '1ads234', 'nihdadak', '123', '132o13', 123, 131, 'asda', '121', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `course` VALUES (39, 2, '广告语', '衣服天', '过一遍', '玉骨遥', 14, 651, '13', '5156', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `course` VALUES (40, 2, '听听歌', '爱的速递', '阿迪王', '手打', 213, 123, '123', '132', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `course` VALUES (45, 17, '低等数学', '姜老师', '西安工程大学', 'B210', 78, 72, '很不错', '来看看', '选项2', '选项4', '选项2', NULL, NULL, NULL, NULL, 'http://localhost:8080/file/download/1711600797543何太后.jpg', NULL);
INSERT INTO `course` VALUES (46, 17, '大学语言', '季先生', '西安工程大学', 'C357', 57, 71, '你好啊', '在干嘛', '选项2', '选项4', '选项1', NULL, NULL, NULL, 1, 'http://localhost:8080/file/download/110118王异.jpg', NULL);
INSERT INTO `course` VALUES (48, 18, '高等数学', '李老师', '西安工程大学', 'D11111', 125, 150, '好好学习，天天向上', '认真听讲', '选项1', '选项3', '选项1', NULL, NULL, NULL, 9, 'http://localhost:8080/file/download/高数.jpg', NULL);
INSERT INTO `course` VALUES (49, 18, 'c语言', '刘老师', '西安工程大学', 'D345', 122, 234, '计算机的入门语言', '注意课后多练习', '选项2', '选项3', '选项2', NULL, NULL, NULL, NULL, 'http://localhost:8080/file/download/C语言.jpg', NULL);
INSERT INTO `course` VALUES (51, 17, '高等数学上', '行贿', '广西民族大学', 'H551', 76, 90, '高等数学是指相对于初等数学和中等数学而言，数学的对象及方法较为繁杂的一部分，中学的代数、几何以及简单的集合论初步、逻辑初步称为中等数学，将其作为中小学阶段的初等数学与大学阶段的高等数学的过渡。\r\n通常认为，高等数学是由微积分学，较深入的代数学、几何学以及它们之间的交叉内容所形成的一门基础学科。主要内容包括：数列、极限、微积分、空间解析几何与线性代数、级数、常微分方程。工科、理科、财经类研究生考试的基础科目。', '不花钱', '选项2', '选项2', '选项3', NULL, NULL, NULL, 24, 'http://localhost:8080/file/download/1712127700839高数.jpg', NULL);
INSERT INTO `course` VALUES (52, 17, '花卉鉴赏', '蔡老师', '姜堰美校', 'A132', 34, 50, '染纸是吸取我国民间印染工艺而形成的一种手工制作。染纸活动的目的在于使幼儿通过对染色技法、技能的学习，了解、感受由于色彩位置排列变化造成的色彩整体感的变化。考虑到纸巾是我们生活中常见的日用品，孩子们对于它是再熟悉不过了，所以我就选用了纸巾作为材料，那如何让纸巾变得更漂亮呢?为此我就设计了本次活动——彩色的纸巾，让幼儿通过探索与尝试，在实际的浸染操作中自己发现问题、解决问题，进行自由创作，从而达到掌握浸染的基本方法。', '带上课本', '选项3', '选项2', '选项3', NULL, NULL, NULL, NULL, 'http://localhost:8080/file/download/110125孙尚香.jpg', NULL);
INSERT INTO `course` VALUES (53, 17, '不知道学之道', '孔老师', '泰州四中', '110', 37, 40, '红红火火恍恍惚惚', '哈哈哈哈^_^黄花', '选项3', '选项1', '选项1', NULL, NULL, NULL, NULL, 'http://localhost:8080/file/download/5星_严颜.jpg', NULL);
INSERT INTO `course` VALUES (54, 17, '高等数学', '姜老师', '南京外国语大学', 'C184', 56, 75, '这是一门优秀的课程，老师讲的也很不错，十分值得听', '不要玩手机，不要交头接耳', '选项2', '选项3', '选项1', NULL, NULL, NULL, NULL, 'http://localhost:8080/file/download/9787030348784.jpg', NULL);
INSERT INTO `course` VALUES (55, 17, 'C语言', '李老师', '西安工程大学', 'D135', 51, 70, '很不错的课程，欢迎大家来上课', '上课不要玩手机', '选项3', '选项2', '选项1', NULL, NULL, NULL, NULL, 'http://localhost:8080/file/download/1712423225077C语言.jpg', NULL);
INSERT INTO `course` VALUES (56, 21, '软件工程', '姜老师', '西安工程大学', 'A110', 76, 90, '这是一门计算机基础课', '不要上课玩手机', '选项2', '选项4', '选项3', NULL, NULL, NULL, NULL, 'http://localhost:8080/file/download/1712471292520.jpg', NULL);

-- ----------------------------
-- Table structure for dayplan
-- ----------------------------
DROP TABLE IF EXISTS `dayplan`;
CREATE TABLE `dayplan`  (
  `did` int NOT NULL AUTO_INCREMENT,
  `uid` int NOT NULL,
  `p1` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `p2` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `p3` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `p4` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `p5` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `p6` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `p7` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `p8` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `p9` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`did`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dayplan
-- ----------------------------
INSERT INTO `dayplan` VALUES (1, 14, '', '', '', '', '', '', '', '', '');
INSERT INTO `dayplan` VALUES (2, 15, '$##$##$', '', '', '$##$##$', '$##$##$', '$##$##$', '', '', '');
INSERT INTO `dayplan` VALUES (3, 16, '', '', '', '', '', '', '', '', '');
INSERT INTO `dayplan` VALUES (4, 17, '', '', '', '', '', '', '', '', '');
INSERT INTO `dayplan` VALUES (5, 18, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `dayplan` VALUES (6, 19, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `dayplan` VALUES (7, 20, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `dayplan` VALUES (8, 21, '', '', '', '', '', '', '', '', '');

-- ----------------------------
-- Table structure for talk
-- ----------------------------
DROP TABLE IF EXISTS `talk`;
CREATE TABLE `talk`  (
  `tid` int NOT NULL AUTO_INCREMENT,
  `cid` int NOT NULL,
  `uid` int NOT NULL,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`tid`) USING BTREE,
  INDEX `CID`(`cid` ASC) USING BTREE,
  CONSTRAINT `CID` FOREIGN KEY (`cid`) REFERENCES `course` (`cid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of talk
-- ----------------------------
INSERT INTO `talk` VALUES (5, 51, 17, '不是哥们');
INSERT INTO `talk` VALUES (6, 51, 17, '4442');
INSERT INTO `talk` VALUES (7, 51, 17, '24524');
INSERT INTO `talk` VALUES (8, 51, 17, '45242');
INSERT INTO `talk` VALUES (9, 51, 17, '24524');
INSERT INTO `talk` VALUES (10, 51, 17, '这门课很不错');
INSERT INTO `talk` VALUES (11, 51, 21, '我也想上课');

-- ----------------------------
-- Table structure for time
-- ----------------------------
DROP TABLE IF EXISTS `time`;
CREATE TABLE `time`  (
  `iid` int NOT NULL AUTO_INCREMENT,
  `cid` int NOT NULL,
  `date` varchar(225) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `rank` int NULL DEFAULT NULL,
  PRIMARY KEY (`iid`) USING BTREE,
  INDEX `ic`(`cid` ASC) USING BTREE,
  CONSTRAINT `ic` FOREIGN KEY (`cid`) REFERENCES `course` (`cid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 61 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of time
-- ----------------------------
INSERT INTO `time` VALUES (19, 39, '2024-03-07', 3);
INSERT INTO `time` VALUES (20, 39, '2024-03-14', 3);
INSERT INTO `time` VALUES (21, 40, '2024-03-06', 3);
INSERT INTO `time` VALUES (22, 40, '2024-03-20', 3);
INSERT INTO `time` VALUES (33, 45, '2024-03-21', 3);
INSERT INTO `time` VALUES (34, 45, '2024-03-14', 3);
INSERT INTO `time` VALUES (35, 45, '2024-03-07', 3);
INSERT INTO `time` VALUES (36, 46, '2024-03-21', 3);
INSERT INTO `time` VALUES (37, 46, '2024-03-14', 3);
INSERT INTO `time` VALUES (41, 48, '2024-03-13', 3);
INSERT INTO `time` VALUES (42, 49, '2024-03-05', 2);
INSERT INTO `time` VALUES (43, 49, '2024-03-14', 2);
INSERT INTO `time` VALUES (44, 49, '2024-03-17', 2);
INSERT INTO `time` VALUES (46, 51, '2024-04-06', 4);
INSERT INTO `time` VALUES (49, 52, '2024-04-15', 3);
INSERT INTO `time` VALUES (50, 52, '2024-04-16', 3);
INSERT INTO `time` VALUES (51, 52, '2024-04-17', 3);
INSERT INTO `time` VALUES (52, 53, '2024-04-21', 4);
INSERT INTO `time` VALUES (53, 53, '2024-04-22', 4);
INSERT INTO `time` VALUES (54, 53, '2024-04-23', 4);
INSERT INTO `time` VALUES (55, 53, '2024-04-24', 4);
INSERT INTO `time` VALUES (56, 54, '2024-04-20', 3);
INSERT INTO `time` VALUES (57, 55, '2024-04-20', 3);
INSERT INTO `time` VALUES (58, 55, '2024-04-26', 3);
INSERT INTO `time` VALUES (59, 56, '2024-04-19', 2);
INSERT INTO `time` VALUES (60, 56, '2024-04-26', 2);

-- ----------------------------
-- Table structure for timetable
-- ----------------------------
DROP TABLE IF EXISTS `timetable`;
CREATE TABLE `timetable`  (
  `tid` int NOT NULL AUTO_INCREMENT,
  `uid` int NOT NULL,
  `course1` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `course2` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `course3` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `course4` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `course5` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `course6` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `course7` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `course8` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `course9` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `course10` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `course11` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `course12` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `course13` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `course14` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `course15` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `course16` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `course17` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `course18` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `course19` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `course20` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `course21` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `course22` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `course23` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `course24` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `course25` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `course26` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `course27` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `course28` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `course29` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `course30` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `course31` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `course32` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `course33` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `course34` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `course35` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`tid`) USING BTREE,
  INDEX `UID`(`uid` ASC) USING BTREE,
  CONSTRAINT `UID` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of timetable
-- ----------------------------
INSERT INTO `timetable` VALUES (1, 13, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `timetable` VALUES (2, 14, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `timetable` VALUES (3, 15, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `timetable` VALUES (4, 16, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `timetable` VALUES (5, 17, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'C#', NULL, NULL, '', NULL, NULL, NULL, NULL, NULL, '大学体育', '', '大学英语', NULL, '操作系统', NULL, NULL, '高等数学上', NULL, '计算机组成原理', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `timetable` VALUES (6, 18, NULL, '离散数学', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'c语言', '高等数学', NULL, '高等数学', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `timetable` VALUES (7, 19, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `timetable` VALUES (8, 20, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `timetable` VALUES (9, 21, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '高等数学上', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `uid` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `age` int NULL DEFAULT NULL,
  `grade` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `ucolloge` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `upicture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `upnum` int NULL DEFAULT NULL,
  `attnum` int NULL DEFAULT NULL,
  `power` int NULL DEFAULT NULL,
  PRIMARY KEY (`uid`, `username`) USING BTREE,
  INDEX `UID`(`uid` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'asdad', '1233', NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `user` VALUES (2, '测试', '123456', NULL, '', NULL, 'http://localhost:8080/file/download/img.png', NULL, NULL, 0);
INSERT INTO `user` VALUES (4, '赵信', '123123', NULL, '', NULL, NULL, NULL, NULL, 0);
INSERT INTO `user` VALUES (5, '李信', '123456', NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `user` VALUES (6, '黄子', '111', NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `user` VALUES (9, '姜88', '1724', NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `user` VALUES (10, '加特林', '516', NULL, NULL, NULL, 'http://localhost:8080/file/download/img.png', NULL, NULL, 0);
INSERT INTO `user` VALUES (12, '试一试', '1234', 0, '大一', NULL, 'http://localhost:8080/file/download/img.png', 0, 0, 0);
INSERT INTO `user` VALUES (13, '试一试吧', '1234', 0, '大一', NULL, 'http://localhost:8080/file/download/img.png', 0, 0, 0);
INSERT INTO `user` VALUES (14, 'liyikai', '1234', 21, '大一', '西安工程大学', 'http://localhost:8080/file/download/5星_曹仁.jpg', 0, 0, 0);
INSERT INTO `user` VALUES (15, '姜魏', '1234', 23, '大四', '西安工程大学', 'http://localhost:8080/file/download/img.png', 0, 0, 0);
INSERT INTO `user` VALUES (16, '姜地', '1234', 21, '大一', NULL, 'http://localhost:8080/file/download/img.png', 0, 0, 1);
INSERT INTO `user` VALUES (17, '姜地魏', '1234', 21, '大二', '西安工程大学', 'http://localhost:8080/file/download/img.png', 0, 0, 2);
INSERT INTO `user` VALUES (18, 'test1', '123456', 0, '大一', NULL, 'http://localhost:8080/file/download/img.png', 0, 0, 0);
INSERT INTO `user` VALUES (19, '大马哥', '1234', 0, '大一', NULL, 'http://localhost:8080/file/download/img.png', 0, 0, 1);
INSERT INTO `user` VALUES (20, '阿斗', '1234', 0, '大一', NULL, 'http://localhost:8080/file/download/img.png', 0, 0, 1);
INSERT INTO `user` VALUES (21, '测试运行', '1234', 21, '大三', '西安工程大学', 'http://localhost:8080/file/download/17124719503105星_华佗.jpg', 0, 0, 0);

-- ----------------------------
-- Table structure for weekplan
-- ----------------------------
DROP TABLE IF EXISTS `weekplan`;
CREATE TABLE `weekplan`  (
  `wid` int NOT NULL AUTO_INCREMENT,
  `uid` int NOT NULL,
  `mon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `tue` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `wed` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `thu` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `fri` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sat` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sun` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`wid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of weekplan
-- ----------------------------
INSERT INTO `weekplan` VALUES (1, 16, '', '', '', '', '', '', '');
INSERT INTO `weekplan` VALUES (2, 17, '', '', '', '', '', '', '');
INSERT INTO `weekplan` VALUES (3, 18, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `weekplan` VALUES (4, 19, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `weekplan` VALUES (5, 20, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `weekplan` VALUES (6, 21, '', '', '', '', '', '', '');

SET FOREIGN_KEY_CHECKS = 1;
