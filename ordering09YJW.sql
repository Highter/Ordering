/*
MySQL Data Transfer
Source Host: localhost
Source Database: ordering
Target Host: localhost
Target Database: ordering
Date: 2014/3/26 19:37:02
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for custom
-- ----------------------------
CREATE TABLE `custom` (
  `custom_id` int(11) NOT NULL AUTO_INCREMENT,
  `login_name` varchar(20) DEFAULT NULL,
  `custom_password` varchar(20) DEFAULT NULL,
  `custom_Name` varchar(20) DEFAULT NULL,
  `custom_sex` int(11) DEFAULT NULL,
  `custom_age` int(11) DEFAULT NULL,
  `person_ID` varchar(17) DEFAULT NULL,
  `Address` varchar(100) DEFAULT NULL,
  `Phone` varchar(11) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `QQ` varchar(15) DEFAULT NULL,
  `Role` int(11) DEFAULT NULL,
  `Regtime` datetime DEFAULT NULL,
  `Modifedtime` datetime DEFAULT NULL,
  `Vnum` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`custom_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for dishmenu
-- ----------------------------
CREATE TABLE `dishmenu` (
  `Dish_ID` bigint(20) NOT NULL,
  `Rest_ID` int(11) DEFAULT NULL,
  `Dish_Style_ID` int(11) DEFAULT NULL,
  `Dish_Name` varchar(20) DEFAULT NULL,
  `Dish_Price` int(11) DEFAULT NULL,
  `Count_buy` int(11) DEFAULT NULL,
  `Dish_Photo` varchar(200) DEFAULT NULL,
  `Remark` varchar(200) DEFAULT NULL,
  `Regtime` varchar(50) DEFAULT NULL,
  `Modifedtime` varchar(50) DEFAULT NULL,
  `Vnum` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`Dish_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for dishstyle
-- ----------------------------
CREATE TABLE `dishstyle` (
  `Dish_Style_ID` int(11) NOT NULL,
  `Dish_Style_Name` varchar(50) DEFAULT NULL,
  `Discription` varchar(100) DEFAULT NULL,
  `Regtime` date DEFAULT NULL,
  `Modifedtime` datetime DEFAULT NULL,
  `Vnum` int(11) DEFAULT NULL,
  PRIMARY KEY (`Dish_Style_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for order_item
-- ----------------------------
CREATE TABLE `order_item` (
  `item_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `Order_ID` varchar(20) DEFAULT NULL,
  `Dish_ID` bigint(20) DEFAULT NULL,
  `Dish_number` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for order_list
-- ----------------------------
CREATE TABLE `order_list` (
  `Order_ID` bigint(20) NOT NULL,
  `custom_id` int(11) DEFAULT NULL,
  `Sum_Price` int(11) DEFAULT NULL,
  `Restaurant_ID` int(11) DEFAULT NULL,
  `Address` varchar(200) DEFAULT NULL,
  `Phone` varchar(11) DEFAULT NULL,
  `Order_Time` varchar(50) DEFAULT NULL,
  `Order_Condition` int(11) DEFAULT NULL,
  `Regtime` varchar(50) DEFAULT NULL,
  `Modifedtime` varchar(50) DEFAULT NULL,
  `Vnum` int(11) DEFAULT NULL,
  PRIMARY KEY (`Order_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for rest_message
-- ----------------------------
CREATE TABLE `rest_message` (
  `Message_ID` int(11) NOT NULL AUTO_INCREMENT,
  `custom_id` int(11) DEFAULT NULL,
  `Rest_ID` int(11) DEFAULT NULL,
  `Time` varchar(50) DEFAULT NULL,
  `Message` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`Message_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for restaurant
-- ----------------------------
CREATE TABLE `restaurant` (
  `Rest_ID` int(11) NOT NULL,
  `Dish_Style_ID` int(11) DEFAULT NULL,
  `Rest_Name` varchar(20) DEFAULT NULL,
  `Rest_CEO_ID` int(11) DEFAULT NULL,
  `Rest_phone` varchar(11) DEFAULT NULL,
  `Rest_Address` varchar(100) DEFAULT NULL,
  `Rest_Photo` varchar(200) DEFAULT NULL,
  `Remark` varchar(200) DEFAULT NULL,
  `Regtime` varchar(100) DEFAULT NULL,
  `Modifedtime` varchar(100) DEFAULT NULL,
  `Vnum` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`Rest_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for shopcar
-- ----------------------------
CREATE TABLE `shopcar` (
  `id` bigint(20) NOT NULL,
  `Custom_id` int(11) DEFAULT NULL,
  `dishId` int(11) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `restName` varchar(20) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `photo` varchar(100) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Table structure for user
-- ----------------------------
CREATE TABLE `user` (
  `name` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `custom` VALUES ('1', 'yjw', '12', '1', '2', '2', '654321', '五邑大学16-312', '13428281948', '13428281948@139.com', '961821139', '1', '2014-03-20 00:00:00', '2014-03-20 00:00:00', '1', '1');
INSERT INTO `custom` VALUES ('2', '1234', '12', '123', '0', '123', '32131', '12', '12', '12', '12', '1', '2014-03-20 00:00:00', '2014-03-20 00:00:00', '1', '1');
INSERT INTO `custom` VALUES ('3', '1234', '12', '123', '0', '123', '3211131', '12', '12', '12', '12', '0', '2014-03-20 00:00:00', '2014-03-20 00:00:00', '1', '1');
INSERT INTO `custom` VALUES ('4', 'lyj', '12', '123', '1', '123', '21333', '12', '12', '12', '12', '1', '2014-03-20 00:00:00', '2014-03-20 00:00:00', '1', '1');
INSERT INTO `custom` VALUES ('5', '123', '12', '123', '1', '123', '21333', '12', '12', '12', '12', '0', '2014-03-20 00:00:00', '2014-03-20 00:00:00', '1', '1');
INSERT INTO `custom` VALUES ('6', 'admin', '12', '123', '1', '123', '21333', '12', '12', '12', '12', '2', '2014-03-20 00:00:00', '2014-03-20 00:00:00', '1', '1');
INSERT INTO `dishmenu` VALUES ('1', '1', '1', '佛跳墙1', '100', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('2', '2', '1', '青瓜丝1', '30', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('3', '3', '1', '鸡肉丝1', '20', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('4', '4', '1', '鳝鱼丝1', '25', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('5', '5', '1', '日本豆腐1', '18', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('6', '6', '1', '鲫鱼汤1', '25', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('7', '7', '1', '铁板肉1', '40', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('8', '8', '1', '青菜汤1', '15', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('9', '9', '1', '爆浆肉丸1', '10', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('10', '10', '1', '冬瓜汤1', '15', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('21', '1', '2', '佛跳墙2', '100', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('22', '2', '2', '青瓜丝2', '30', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('23', '3', '2', '鸡肉丝2', '20', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('24', '4', '2', '鳝鱼丝2', '25', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('25', '5', '2', '日本豆腐2', '18', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('26', '6', '2', '鲫鱼汤2', '25', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('27', '7', '2', '铁板肉2', '40', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('28', '8', '2', '青菜汤2', '15', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('29', '9', '2', '爆浆肉丸2', '10', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('30', '10', '2', '冬瓜汤2', '15', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('31', '1', '3', '佛跳墙3', '100', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('32', '2', '3', '青瓜丝3', '30', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('33', '3', '3', '鸡肉丝3', '20', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('34', '4', '3', '鳝鱼丝3', '25', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('35', '5', '3', '日本豆腐3', '18', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('36', '6', '3', '鲫鱼汤3', '25', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('37', '7', '3', '铁板肉3', '40', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('38', '8', '3', '青菜汤3', '15', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('39', '9', '3', '爆浆肉丸3', '10', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('40', '10', '3', '冬瓜汤3', '15', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('41', '1', '4', '佛跳墙4', '100', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('42', '2', '4', '青瓜丝4', '30', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('43', '3', '4', '鸡肉丝4', '20', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('44', '4', '4', '鳝鱼丝4', '25', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('45', '5', '4', '日本豆腐4', '18', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('46', '6', '4', '鲫鱼汤4', '25', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('47', '7', '4', '铁板肉4', '40', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('48', '8', '4', '青菜汤4', '15', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('49', '9', '4', '爆浆肉丸4', '10', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('50', '10', '4', '冬瓜汤4', '15', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('51', '1', '5', '佛跳墙5', '100', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('52', '2', '5', '青瓜丝5', '30', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('53', '3', '5', '鸡肉丝5', '20', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('54', '4', '5', '鳝鱼丝5', '25', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('55', '5', '5', '日本豆腐5', '18', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('56', '6', '5', '鲫鱼汤5', '25', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('57', '7', '5', '铁板肉5', '40', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('58', '8', '5', '青菜汤5', '15', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('59', '9', '5', '爆浆肉丸5', '10', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('60', '10', '5', '冬瓜汤5', '15', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('61', '1', '6', '佛跳墙6', '100', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('62', '2', '6', '青瓜丝6', '30', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('63', '3', '6', '鸡肉丝6', '20', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('64', '4', '6', '鳝鱼丝6', '25', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('65', '5', '6', '日本豆腐6', '18', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('66', '6', '6', '鲫鱼汤6', '25', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('67', '7', '6', '铁板肉6', '40', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('68', '8', '6', '青菜汤6', '15', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('69', '9', '6', '爆浆肉丸6', '10', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('70', '10', '6', '冬瓜汤6', '15', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('71', '1', '7', '佛跳墙7', '100', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('72', '2', '7', '青瓜丝7', '30', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('73', '3', '7', '鸡肉丝7', '20', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('74', '4', '7', '鳝鱼丝7', '25', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('75', '5', '7', '日本豆腐7', '18', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('76', '6', '7', '鲫鱼汤7', '25', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('77', '7', '7', '铁板肉7', '40', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('78', '8', '7', '青菜汤7', '15', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('79', '9', '7', '爆浆肉丸7', '10', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('80', '10', '7', '冬瓜汤7', '15', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('81', '1', '8', '佛跳墙8', '100', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('82', '2', '8', '青瓜丝8', '30', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('83', '3', '8', '鸡肉丝8', '20', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('84', '4', '8', '鳝鱼丝8', '25', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('85', '5', '8', '日本豆腐8', '18', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('86', '6', '8', '鲫鱼汤8', '25', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('87', '7', '8', '铁板肉8', '40', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('88', '8', '8', '青菜汤8', '15', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('89', '9', '8', '爆浆肉丸8', '10', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('90', '10', '8', '冬瓜汤8', '15', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('91', '1', '1', '铁板牛肉1', '80', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('92', '2', '1', '东波肉1', '100', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('93', '3', '2', '虾堡2', '20', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('94', '4', '2', '日本寿司2', '40', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('95', '5', '3', '羊肉串3', '5', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('96', '6', '3', '潮汕小吃3', '20', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('97', '7', '4', '瘦肉饼4', '3', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('98', '8', '4', 'yjw套餐4', '10', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('99', '9', '5', '卤肉饭5', '8', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('100', '10', '5', '榨菜肉丝面5', '6', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('101', '1', '6', '炒米粉6', '5', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('102', '2', '6', '贡丸汤6', '20', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('103', '3', '6', '馄饨汤6', '5', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('104', '4', '7', '蚵仔煎7', '10', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('105', '5', '7', '糯米糕7', '1', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('106', '6', '7', '水晶饺7', '4', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('107', '7', '8', '豆干8', '1', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('108', '8', '8', '妅烧栗子鸡8', '30', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('109', '8', '8', '糖醋鱼片8', '25', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishmenu` VALUES ('110', '10', '8', '白果虾仁8', '20', '0', null, null, '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0', '0');
INSERT INTO `dishstyle` VALUES ('1', '鲁菜', '鲁菜即山东风味菜，由济南、胶东、孔府菜点三部分组成。济南菜尤重制汤，清汤、奶汤的使用及熬制都有严格规定，菜品以清鲜脆嫩着\r\n\r\n称。胶东菜起源于福山、烟台、青岛，以烹饪海鲜见长，口味以鲜嫩为主，偏重清', '2014-03-25', '2014-03-25 00:00:00', '0');
INSERT INTO `dishstyle` VALUES ('2', '川菜', '川菜风味包括成都、重庆和乐山、自贡等地方菜的特色。主要特点在于味型多样，变化精妙。辣椒、胡椒、花椒、豆瓣酱等是主要调味品，不同\r\n\r\n的配比，化出了麻辣、酸辣、椒麻、麻酱、蒜泥、芥末、红油、糖醋、鱼香', '2014-03-25', '2014-03-25 00:00:00', '0');
INSERT INTO `dishstyle` VALUES ('3', '粤菜', '粤菜即广东菜，由广州、潮州、东江三地特色菜点发展而成，是起步较晚的菜系，但它影响极大，不仅香港、澳门，而且世界各国的中菜馆，多\r\n\r\n数是以粤菜为主。粤菜注意吸取各菜系之长，形成多种烹饪形式，是具有自', '2014-03-25', '2014-03-25 00:00:00', '0');
INSERT INTO `dishstyle` VALUES ('4', '苏菜', '苏菜由淮扬、苏锡、徐海三大地方风味菜肴组成，以淮扬菜为主体。淮扬地处苏中，东至海启通泰盐阜，西至金陵六合，南及京口金坛，北达两\r\n\r\n淮。淮扬菜的特点是选料严谨，注意刀工和火工，强调本味，突出主料，色', '2014-03-25', '2014-03-25 00:00:00', '0');
INSERT INTO `dishstyle` VALUES ('5', '闽菜', '闽菜是以福州、闽南、闽西三地区地方风味菜为主形成的菜系。福州菜清鲜、爽淡，偏于甜酸，尤其讲究调汤，另一特色是善于用红糖作配料，\r\n\r\n具有防变质、去腥、增香、生味、调色作用。闽南菜以厦门为代表，同样具', '0000-00-00', '2014-03-25 00:00:00', '0');
INSERT INTO `dishstyle` VALUES ('6', '浙菜', '浙菜有悠久的历史，它的风味包括杭州、宁波和绍兴三个地方的菜点特色。杭州菜重视原料的鲜、活、嫩，以鱼、虾、时令蔬菜为主，讲究刀工\r\n\r\n，口味清鲜，突出本味。宁波菜咸鲜合一，以烹制海鲜见长，讲究鲜嫩软滑', '2014-03-25', '2014-03-25 00:00:00', '0');
INSERT INTO `dishstyle` VALUES ('7', '湘菜', '湘菜包括湘江流域、洞庭湖区和湘西山区三个地区的菜点特色。湘江流域以长江、衡阳、湘潭为中心，是湘菜的主要代表。其特色是油重色浓，\r\n\r\n讲求实惠，注重鲜香、酸辣、软嫩，尤以煨菜和腊菜着称。洞庭湖区的菜以', '2014-03-25', '2014-03-25 00:00:00', '0');
INSERT INTO `dishstyle` VALUES ('8', '徽菜', '徽菜风味包括皖南、沿江、沿淮之地的菜点特色。皖南菜包括黄山、歙县（古徽州）、屯溪等地，讲究火功，善烹野味，量大油重，朴素实惠，\r\n\r\n保持原汁原味；不少菜肴都是取用木炭小火炖、煨而成，汤清味醇，原锅上', '2014-03-25', '2014-03-25 00:00:00', '0');
INSERT INTO `order_item` VALUES ('1', '100', '1', '0');
INSERT INTO `order_item` VALUES ('2', '100', '2', '0');
INSERT INTO `order_item` VALUES ('3', '100', '3', '0');
INSERT INTO `order_item` VALUES ('4', '100', '4', '0');
INSERT INTO `order_item` VALUES ('5', '100', '5', '0');
INSERT INTO `order_item` VALUES ('6', '100', '6', '0');
INSERT INTO `order_item` VALUES ('7', '100', '7', '0');
INSERT INTO `order_item` VALUES ('8', '100', '8', '0');
INSERT INTO `order_item` VALUES ('9', '4', '9', '2');
INSERT INTO `order_item` VALUES ('10', '5', '10', '2');
INSERT INTO `order_item` VALUES ('11', '6', '11', '3');
INSERT INTO `order_item` VALUES ('12', '7', '12', '2');
INSERT INTO `order_item` VALUES ('13', '8', '13', '3');
INSERT INTO `order_item` VALUES ('14', '9', '14', '3');
INSERT INTO `order_item` VALUES ('15', '10', '15', '2');
INSERT INTO `order_item` VALUES ('16', '11', '16', '2');
INSERT INTO `order_item` VALUES ('17', '12', '17', '1');
INSERT INTO `order_item` VALUES ('18', '13', '18', '3');
INSERT INTO `order_item` VALUES ('19', '14', '19', '4');
INSERT INTO `order_list` VALUES ('3', '0', '0', '20', '3223222222', '323', '2014-03-19 00:00:00', '0', '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0');
INSERT INTO `order_list` VALUES ('4', '0', '0', '20', '3232', '111111111', '2014-03-19 00:00:00', '0', '2014-03-19 00:00:00', '2014-03-19 00:00:00', '0');
INSERT INTO `order_list` VALUES ('5', '1', '42', '20', '五邑大学16-310', '06633214238', 'Wed Mar 26 10:37:56 CST 2014', '0', 'Wed Mar 26 10:37:56 CST 2014', 'Wed Mar 26 10:37:56 CST 2014', '0');
INSERT INTO `order_list` VALUES ('6', '1', '84', '20', '五邑大学16-310', '06633214238', 'Wed Mar 26 10:37:56 CST 2014', '0', 'Wed Mar 26 10:37:56 CST 2014', 'Wed Mar 26 10:37:56 CST 2014', '0');
INSERT INTO `order_list` VALUES ('7', '1', '63', '20', '五邑大学16-310', '06633214238', 'Wed Mar 26 14:25:35 CST 2014', '0', 'Wed Mar 26 14:25:35 CST 2014', 'Wed Mar 26 14:25:35 CST 2014', '0');
INSERT INTO `order_list` VALUES ('8', '1', '42', '20', '五邑大学16-310', '06633214238', 'Wed Mar 26 14:25:35 CST 2014', '0', 'Wed Mar 26 14:25:35 CST 2014', 'Wed Mar 26 14:25:35 CST 2014', '0');
INSERT INTO `order_list` VALUES ('9', '1', '63', '20', '五邑大学16-310', '06633214238', 'Wed Mar 26 14:27:34 CST 2014', '0', 'Wed Mar 26 14:27:34 CST 2014', 'Wed Mar 26 14:27:34 CST 2014', '0');
INSERT INTO `order_list` VALUES ('10', '1', '63', '20', '五邑大学16-310', '06633214238', 'Wed Mar 26 14:27:34 CST 2014', '0', 'Wed Mar 26 14:27:34 CST 2014', 'Wed Mar 26 14:27:34 CST 2014', '0');
INSERT INTO `order_list` VALUES ('11', '1', '42', '20', '五邑大学16-310', '06633214238', 'Wed Mar 26 14:29:08 CST 2014', '0', 'Wed Mar 26 14:29:08 CST 2014', 'Wed Mar 26 14:29:08 CST 2014', '0');
INSERT INTO `order_list` VALUES ('12', '1', '42', '20', '五邑大学16-310', '06633214238', 'Wed Mar 26 14:29:08 CST 2014', '0', 'Wed Mar 26 14:29:08 CST 2014', 'Wed Mar 26 14:29:08 CST 2014', '0');
INSERT INTO `order_list` VALUES ('13', '1', '21', '20', '五邑大学16-312', '13428281948', 'Wed Mar 26 16:16:48 CST 2014', '0', 'Wed Mar 26 16:16:48 CST 2014', 'Wed Mar 26 16:16:48 CST 2014', '0');
INSERT INTO `order_list` VALUES ('14', '1', '63', '20', '五邑大学16-312', '13428281948', 'Wed Mar 26 16:17:30 CST 2014', '0', 'Wed Mar 26 16:17:30 CST 2014', 'Wed Mar 26 16:17:30 CST 2014', '0');
INSERT INTO `order_list` VALUES ('15', '1', '400', '1', '五邑大学16-312', '13428281948', 'Wed Mar 26 19:00:47 CST 2014', '0', 'Wed Mar 26 19:00:47 CST 2014', 'Wed Mar 26 19:00:47 CST 2014', '0');
INSERT INTO `rest_message` VALUES ('1', '1', '20', 'Sat Mar 22 19:04:16 CST 2014', 'hello，I am Jimmy，哈哈');
INSERT INTO `rest_message` VALUES ('2', '1', '20', 'Sat Mar 22 19:04:16 CST 2014', 'hello，I am Jimmy，哈哈');
INSERT INTO `rest_message` VALUES ('3', '1', '20', 'Sat Mar 22 19:04:16 CST 2014', 'hello，I am Jimmy，哈哈');
INSERT INTO `restaurant` VALUES ('1', '1', '1', '44', '2', '1', '大1寸 2.jpg', '1', '2014-03-21 00:00:00', '2014-03-21 00:00:00', '1', '1');
INSERT INTO `restaurant` VALUES ('2', '1', '1', '55', '2', '1', '大1寸 2.jpg', '1', '2014-03-21 00:00:00', '2014-03-21 00:00:00', '1', '1');
INSERT INTO `restaurant` VALUES ('20', '7', '44444', '4', '06633214238', '44', '/images/360.jpg', '44', 'Sat Mar 22 11:18:48 CST 2014', 'Sat Mar 22 11:18:48 CST 2014', '1', '1');
INSERT INTO `restaurant` VALUES ('21', '5', '444', '1', '1111111111', '22222222222222', '/images/大1寸 2.jpg', '222', 'Sat Mar 22 11:19:24 CST 2014', 'Sat Mar 22 11:19:24 CST 2014', '1', '1');
INSERT INTO `restaurant` VALUES ('22', '6', '13', '2', '343', '43', '/images/P_A0546.jpg', '23', 'Sat Mar 22 12:01:53 CST 2014', 'Sat Mar 22 12:01:53 CST 2014', '1', '1');
INSERT INTO `restaurant` VALUES ('23', '2', '12356', '3', '344', '3444', '/images/1888dbd74b21a36694a8d016c3676281.jpg', '231', 'Sat Mar 22 13:33:32 CST 2014', 'Sat Mar 22 13:33:32 CST 2014', '1', '1');
INSERT INTO `shopcar` VALUES ('1', '0', '0', '0', null, '0', null, null);
INSERT INTO `shopcar` VALUES ('2', '0', '0', '0', null, '0', null, null);
INSERT INTO `shopcar` VALUES ('3', '0', '0', '0', null, '0', null, null);
INSERT INTO `shopcar` VALUES ('4', '0', '0', '0', null, '0', null, null);
INSERT INTO `shopcar` VALUES ('5', '0', '0', '0', null, '0', null, null);
INSERT INTO `shopcar` VALUES ('6', '0', '0', '0', null, '0', null, null);
INSERT INTO `shopcar` VALUES ('7', '0', '0', '0', null, '0', null, null);
INSERT INTO `user` VALUES ('lyj', 'lyj');
INSERT INTO `user` VALUES ('qwe', '111');
INSERT INTO `user` VALUES ('wind', '123456');
