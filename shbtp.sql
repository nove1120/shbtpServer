/*
Navicat MySQL Data Transfer

Source Server         : localhost3306 MySQL
Source Server Version : 80011
Source Host           : localhost:3306
Source Database       : shbtp

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2020-06-03 07:32:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for book_base
-- ----------------------------
DROP TABLE IF EXISTS `book_base`;
CREATE TABLE `book_base` (
  `bid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '书籍ID',
  `uid` bigint(20) NOT NULL COMMENT '发布用户UID',
  `book_name` varchar(32) NOT NULL DEFAULT '' COMMENT '书名',
  `author` varchar(32) NOT NULL DEFAULT '' COMMENT '作者',
  `publisher` varchar(32) NOT NULL DEFAULT '' COMMENT '出版社',
  `publishingTime` varchar(32) NOT NULL DEFAULT '' COMMENT '出版年份',
  `ISBN` char(20) NOT NULL DEFAULT '' COMMENT 'ISBN',
  `data_from` tinyint(1) NOT NULL DEFAULT '0' COMMENT '书籍数据来源 0来自第三方数据源 1手动输入 手动输入将不支持ISBN查询',
  `category` char(10) NOT NULL DEFAULT '' COMMENT '书籍类别',
  `grade` tinyint(1) NOT NULL DEFAULT '0' COMMENT '新旧程度 0-未定义 1-全新 2-非全新无明显痕迹 3-有不影响阅读的折痕卷页或污渍、无缺页 4-有明显污渍、破损或缺页 5-垃圾成色',
  `price` double(10,1) NOT NULL DEFAULT '0.0' COMMENT '价格',
  `location` varchar(255) DEFAULT NULL COMMENT '发布位置',
  `state` smallint(2) unsigned NOT NULL DEFAULT '0' COMMENT '出售状态 0-下架 1-在售 2-售出',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`bid`),
  FULLTEXT KEY `title_fulltext` (`book_name`,`author`,`publisher`) /*!50100 WITH PARSER `ngram` */ 
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='书籍基础信息表';

-- ----------------------------
-- Records of book_base
-- ----------------------------
INSERT INTO `book_base` VALUES ('29', '1', '昆虫记', '法布尔', '同心出版社', '2008', '9787807166993', '0', 'Q', '1', '10.0', '黑龙江$哈尔滨$南岗区$黑龙江大学', '0', '2020-04-23 16:22:05', null);
INSERT INTO `book_base` VALUES ('30', '3', '水浒传', '施耐庵', '中国文联出版社', '2009', '9787505960046', '0', 'I', '2', '20.0', '北京$北京市$东城区$', '0', '2020-04-23 17:54:51', '2020-05-14 17:36:51');
INSERT INTO `book_base` VALUES ('31', '3', '昆虫记', '法布尔', '同心出版社', '2008', '9787807166993', '0', 'Q', '1', '11.0', '黑龙江$哈尔滨$南岗区$黑龙江大学', '0', '2020-04-24 18:15:37', '2020-05-15 02:17:33');
INSERT INTO `book_base` VALUES ('33', '3', '昆虫记', '法布尔', '同心出版社', '2008', '9787807166993', '0', 'Q', '1', '15.0', '黑龙江$哈尔滨$南岗区$黑龙江大学', '0', '2020-04-24 18:17:23', '2020-05-15 02:17:40');
INSERT INTO `book_base` VALUES ('42', '1', '通俗天文学', '西蒙', '新世界出版社', '2014', '9787510450808', '0', 'P', '0', '19.9', '黑龙江$鸡西$虎林市$', '0', '2020-05-14 23:54:30', null);
INSERT INTO `book_base` VALUES ('43', '1', '电脑组装与维修', '王红军', '机械工业出版社', '2016', '9787111511038', '0', 'T', '1', '25.0', '黑龙江$哈尔滨$南岗区$黑龙江大学', '0', '2020-05-14 23:57:44', null);
INSERT INTO `book_base` VALUES ('44', '1', '相对论', '爱因斯坦', '新世界出版社', '2014', '9787510450129', '0', 'O', '0', '15.5', '黑龙江$哈尔滨$南岗区$黑龙江大学', '0', '2020-05-15 00:01:43', null);
INSERT INTO `book_base` VALUES ('45', '1', '图解经济学原理', '阿尔弗雷德', '中国华侨出版社', '2014', '', '0', 'F', '0', '7.0', '黑龙江$哈尔滨$南岗区$', '0', '2020-05-15 00:05:07', '2020-05-15 11:09:37');
INSERT INTO `book_base` VALUES ('46', '1', '大话移动通信', '丁奇', '人民邮电出版社', '2011', '9787115262066', '0', 'T', '2', '22.0', '黑龙江$鸡西$鸡冠区$', '0', '2020-05-15 00:16:55', null);
INSERT INTO `book_base` VALUES ('47', '1', 'c++项目开发实战入门', '明日科技', '吉林大学出版社', '2016', '', '0', 'T', '0', '44.0', '黑龙江$哈尔滨$道里区$', '0', '2020-05-15 00:20:57', null);
INSERT INTO `book_base` VALUES ('48', '1', '零基础学java', '明日科技', '吉林大学出版社', '2015', '', '0', 'T', '1', '21.0', '北京$北京市$东城区$', '0', '2020-05-15 00:51:01', null);
INSERT INTO `book_base` VALUES ('49', '1', '昆虫记', '法布尔', '同心出版社', '2008', '9787807166993', '0', 'Q', '0', '13.0', '黑龙江$哈尔滨$南岗区$黑龙江大学', '0', '2020-04-24 18:17:03', '2020-05-15 02:15:58');
INSERT INTO `book_base` VALUES ('50', '1', '经济学原理', '曼昆', '北京大学出版社', '2013', '', '0', 'F', '1', '25.0', '黑龙江$鸡西$鸡冠区$', '0', '2020-05-15 00:59:23', null);
INSERT INTO `book_base` VALUES ('51', '1', '经济学通识', '薛兆丰', '北京大学出版社', '2014', '9787301258699', '0', 'F', '0', '20.0', '黑龙江$哈尔滨$道里区$黑龙江大学', '0', '2020-05-15 01:01:17', null);
INSERT INTO `book_base` VALUES ('52', '1', '国际经济学', '多米尼克', '清华大学出版社', '2011', '9787302408635', '0', 'F', '3', '14.0', '北京$北京市$东城区$', '0', '2020-05-15 01:02:38', null);
INSERT INTO `book_base` VALUES ('53', '1', '管理经济学', '陈章武', '清华大学出版社', '2013', '9787302510116', '0', 'F', '0', '34.0', '北京$北京市$房山区$', '0', '2020-05-15 01:04:46', null);
INSERT INTO `book_base` VALUES ('54', '1', '房地产经济学', '董藩', '清华大学出版社', '2011', '', '0', 'F', '2', '10.0', '北京$北京市$东城区$', '0', '2020-05-15 01:06:35', null);
INSERT INTO `book_base` VALUES ('55', '1', '数据结构(C++语言版)', '邓俊辉', '清华大学出版社', '2012', '', '0', 'T', '1', '19.0', '北京$北京市$宣武区$', '0', '2020-05-15 01:09:07', null);
INSERT INTO `book_base` VALUES ('56', '1', '大学物理学', '张三慧', '清华大学出版社', '2018', '', '0', 'O', '0', '25.0', '黑龙江$哈尔滨$南岗区$黑龙江大学', '0', '2020-05-15 01:11:36', null);
INSERT INTO `book_base` VALUES ('57', '1', '小岛经济学', '彼得希夫', '中信出版社', '2018', '', '0', 'F', '3', '15.0', '吉林$吉林$舒兰市$', '0', '2020-05-15 01:14:06', null);
INSERT INTO `book_base` VALUES ('58', '1', '西方经济学', '高鸿业', '中国人民大学出版社', '2016', '', '0', 'F', '1', '21.0', '黑龙江$哈尔滨$南岗区$哈尔滨理工大学', '0', '2020-05-15 01:15:39', null);
INSERT INTO `book_base` VALUES ('59', '1', '经济学的思维方式', '托马斯索维尔', '四川人民出版社', '2017', '', '0', 'F', '0', '25.0', '黑龙江$哈尔滨$松北区$哈尔滨师范大学', '0', '2020-05-15 01:17:41', null);
INSERT INTO `book_base` VALUES ('60', '1', '技术经济学', '吴宗法', '清华大学出版社', '2011', '', '0', 'F', '2', '21.0', '北京$北京市$东城区$北京航空航天大学', '0', '2020-05-15 01:19:39', null);
INSERT INTO `book_base` VALUES ('61', '1', '计量经济学', '马薇', '清华大学出版社', '2013', '', '0', 'F', '0', '16.0', '黑龙江$哈尔滨$道外区$哈尔滨工程大学', '0', '2020-05-15 01:22:01', null);
INSERT INTO `book_base` VALUES ('62', '1', '理解传媒经济学', '吉利安', '清华大学出版社', '2014', '', '0', 'F', '0', '27.0', '黑龙江$哈尔滨$南岗区$哈尔滨学院', '0', '2020-05-15 01:23:59', null);
INSERT INTO `book_base` VALUES ('63', '1', '宏观经济学', '曼昆', '中国人民大学出版社', '2014', '', '0', 'F', '0', '45.0', '辽宁$沈阳$和平区$', '0', '2020-05-15 01:25:35', null);
INSERT INTO `book_base` VALUES ('64', '1', '计量经济学导论', '杰夫里', '中国人民大学', '2015', '', '0', 'F', '2', '0.0', '北京$北京市$东城区$', '0', '2020-05-15 01:28:10', null);
INSERT INTO `book_base` VALUES ('65', '1', '产业经济学', '杨凤', '清华大学出版社', '2014', '', '0', 'F', '4', '12.0', '黑龙江$哈尔滨$南岗区$黑龙江大学', '0', '2020-05-15 01:29:50', null);
INSERT INTO `book_base` VALUES ('66', '1', '社会市场经济', '朱民', '中信出版社', '2016', '', '0', 'F', '2', '9.9', '上海$上海市$黄浦区$上海财经大学', '0', '2020-05-15 01:31:57', null);
INSERT INTO `book_base` VALUES ('67', '1', '金融经济学二十五讲', '徐高', '中国人民大学出版社', '2018', '', '0', 'F', '1', '29.0', '山西$太原$小店区$', '0', '2020-05-15 01:34:24', null);
INSERT INTO `book_base` VALUES ('68', '1', '薛兆丰经济学讲义', '薛兆丰', '中信出版集团', '2019', '', '0', 'F', '0', '28.0', '黑龙江$哈尔滨$呼兰区$', '1', '2020-05-15 01:37:31', '2020-05-15 11:14:21');
INSERT INTO `book_base` VALUES ('69', '1', '数据结构java', '刘小晶', '清华大学出版社', '2016', '', '0', 'T', '0', '24.0', '河北$石家庄$长安区$', '0', '2020-05-15 01:39:51', null);
INSERT INTO `book_base` VALUES ('70', '1', '数据结构题集', '严蔚敏', '清华大学出版社', '2014', '', '0', 'F', '0', '33.0', '黑龙江$哈尔滨$道里区$黑龙江大学', '0', '2020-05-15 01:42:48', null);
INSERT INTO `book_base` VALUES ('71', '1', '数据结构与算法分析', '马克', '机械工业出版社', '2015', '', '0', 'T', '2', '32.0', '北京$北京市$东城区$', '0', '2020-05-15 01:44:25', null);
INSERT INTO `book_base` VALUES ('72', '1', '算法竞赛入门经典', '刘汝佳', '清华大学出版社', '2018', '', '0', 'T', '4', '0.0', '黑龙江$哈尔滨$南岗区$黑龙江大学', '0', '2020-05-15 01:46:21', null);
INSERT INTO `book_base` VALUES ('73', '1', '数据结构与算法java语言描述', '李新叶', '中国电力出版社', '2016', '', '0', 'T', '1', '26.0', '江苏$南京$玄武区$南京理工大学', '0', '2020-05-15 01:48:16', null);
INSERT INTO `book_base` VALUES ('74', '1', '图解数据结构使用python', '吴灿铭', '清华大学出版社', '2019', '', '0', 'T', '0', '25.0', '北京$北京市$东城区$', '0', '2020-05-15 01:50:09', null);
INSERT INTO `book_base` VALUES ('75', '1', '昆虫记', '法布尔', '同心出版社', '2014', '9787807166993', '0', 'Q', '1', '15.5', '黑龙江$哈尔滨$南岗区$', '0', '2020-05-15 10:55:37', null);

-- ----------------------------
-- Table structure for book_desc
-- ----------------------------
DROP TABLE IF EXISTS `book_desc`;
CREATE TABLE `book_desc` (
  `bid` bigint(20) NOT NULL COMMENT '书籍ID',
  `text_desc` varchar(512) NOT NULL DEFAULT '' COMMENT '文本描述',
  `picture_url` varchar(512) NOT NULL DEFAULT '' COMMENT '图片相对路径 最多9图 多url之间使用&分隔',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`bid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='书籍描述信息表';

-- ----------------------------
-- Records of book_desc
-- ----------------------------
INSERT INTO `book_desc` VALUES ('29', '欢迎购买', '1587629988823414.jpg$1587629989084943.jpg', '2020-04-23 16:22:05');
INSERT INTO `book_desc` VALUES ('30', '水浒传', '1587635507208732.jpg$1587635507440642.jpg', '2020-04-23 17:54:51');
INSERT INTO `book_desc` VALUES ('31', '欢迎购买1', '1587629988823414.jpg$1587629989084943.jpg', '2020-04-24 18:19:54');
INSERT INTO `book_desc` VALUES ('33', '欢迎购买3', '1587629988823414.jpg$1587629989084943.jpg', '2020-04-24 18:19:56');
INSERT INTO `book_desc` VALUES ('42', '通俗天文学 很新', '1589471522409316.JPEG$1589471522593472.JPEG', '2020-05-14 23:54:30');
INSERT INTO `book_desc` VALUES ('43', '几乎全新 电脑组装与维修', '1589471736520977.JPEG$1589471736730388.JPEG$1589471736907566.JPEG', '2020-05-14 23:57:44');
INSERT INTO `book_desc` VALUES ('44', '经典物理学著作', '1589472086870161.JPEG$1589472087108647.JPEG$1589472087281853.JPEG$1589472087440605.JPEG', '2020-05-15 00:01:43');
INSERT INTO `book_desc` VALUES ('45', '快来买吧 ', '1589472169520618.JPEG$1589472180112969.JPEG', '2020-05-15 00:05:07');
INSERT INTO `book_desc` VALUES ('46', '移动通信书', '158947300414695.JPEG', '2020-05-15 00:16:55');
INSERT INTO `book_desc` VALUES ('47', 'c++入门', '1589473164509558.png', '2020-05-15 00:20:57');
INSERT INTO `book_desc` VALUES ('48', 'java入门书', '1589475000762234.png', '2020-05-15 00:51:01');
INSERT INTO `book_desc` VALUES ('49', '欢迎购买2', '1587629988823414.jpg$1587629989084943.jpg', '2020-05-15 02:16:12');
INSERT INTO `book_desc` VALUES ('50', '经典经济学', '1589475522074534.png$1589475522115949.png', '2020-05-15 00:59:23');
INSERT INTO `book_desc` VALUES ('51', '经济学书籍', '1589475609610463.png$1589475609649508.png$1589475609670623.png', '2020-05-15 01:01:17');
INSERT INTO `book_desc` VALUES ('52', '国际经济', '1589475700555448.png', '2020-05-15 01:02:38');
INSERT INTO `book_desc` VALUES ('53', '管理与经济的结合', '1589475790752820.png$1589475790793332.png', '2020-05-15 01:04:46');
INSERT INTO `book_desc` VALUES ('54', '房地产经济', '1589475989792850.png$1589475989833593.png', '2020-05-15 01:06:35');
INSERT INTO `book_desc` VALUES ('55', '数据结构 编程必须学', '1589476051508171.png', '2020-05-15 01:09:07');
INSERT INTO `book_desc` VALUES ('56', '大物全新', '1589476219070828.png', '2020-05-15 01:11:36');
INSERT INTO `book_desc` VALUES ('57', '小岛经济学', '15894763678031.png$1589476367828126.png', '2020-05-15 01:14:06');
INSERT INTO `book_desc` VALUES ('58', '西方经济学', '158947647866948.png', '2020-05-15 01:15:39');
INSERT INTO `book_desc` VALUES ('59', '经济学思维', '1589476596234205.png$1589476596289484.png', '2020-05-15 01:17:41');
INSERT INTO `book_desc` VALUES ('60', '技术经济学', '158947671422240.png$1589476714267572.png', '2020-05-15 01:19:39');
INSERT INTO `book_desc` VALUES ('61', '计量经济学', '1589476848115743.png', '2020-05-15 01:22:01');
INSERT INTO `book_desc` VALUES ('62', '理解传媒经济', '1589476948827229.png', '2020-05-15 01:23:59');
INSERT INTO `book_desc` VALUES ('63', '宏观经济学', '158947708731377.png', '2020-05-15 01:25:35');
INSERT INTO `book_desc` VALUES ('64', '计量经济学', '1589477244208754.png', '2020-05-15 01:28:10');
INSERT INTO `book_desc` VALUES ('65', '产业经济', '1589477381333800.png', '2020-05-15 01:29:50');
INSERT INTO `book_desc` VALUES ('66', '社会市场', '1589477447903955.png', '2020-05-15 01:31:57');
INSERT INTO `book_desc` VALUES ('67', '金融经济学二十五讲', '158947758703187.png', '2020-05-15 01:34:24');
INSERT INTO `book_desc` VALUES ('68', '经济学讲义', '1589477786210946.png', '2020-05-15 01:37:31');
INSERT INTO `book_desc` VALUES ('69', 'java', '1589477932954289.png', '2020-05-15 01:39:51');
INSERT INTO `book_desc` VALUES ('70', '数据结构题集', '1589478101061284.png', '2020-05-15 01:42:48');
INSERT INTO `book_desc` VALUES ('71', '数据结构与算法分析', '158947819978366.png', '2020-05-15 01:44:25');
INSERT INTO `book_desc` VALUES ('72', '算法竞赛入门经典', '1589478306199830.png', '2020-05-15 01:46:21');
INSERT INTO `book_desc` VALUES ('73', '数据结构算法', '1589478488425267.png', '2020-05-15 01:48:16');
INSERT INTO `book_desc` VALUES ('74', 'py数据结构', '1589478515350440.png', '2020-05-15 01:50:09');
INSERT INTO `book_desc` VALUES ('75', '昆虫记', '1589511278806434.JPEG$1589511279049862.JPEG', '2020-05-15 10:55:37');

-- ----------------------------
-- Table structure for book_order
-- ----------------------------
DROP TABLE IF EXISTS `book_order`;
CREATE TABLE `book_order` (
  `oid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `bid` bigint(20) NOT NULL COMMENT '书籍id',
  `sell_uid` bigint(20) NOT NULL COMMENT '出售用户id',
  `buy_uid` bigint(20) NOT NULL COMMENT '购买用户id',
  `consignee` varchar(32) NOT NULL DEFAULT '' COMMENT '收货人姓名',
  `phone_number` varchar(16) DEFAULT NULL COMMENT '电话',
  `location` varchar(255) NOT NULL DEFAULT '' COMMENT '位置(省市区)',
  `address` varchar(255) NOT NULL DEFAULT '' COMMENT '详细地址',
  `express_company` varchar(64) DEFAULT '' COMMENT '快递公司',
  `express_number` varchar(64) DEFAULT '' COMMENT '快递单号',
  `mode` tinyint(1) NOT NULL DEFAULT '0' COMMENT '交易方式',
  `state` tinyint(1) NOT NULL DEFAULT '0' COMMENT '订单状态',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`oid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户地址信息表';

-- ----------------------------
-- Records of book_order
-- ----------------------------
INSERT INTO `book_order` VALUES ('1', '29', '1', '3', 'adsad', '121212', 'dadadw', 'dscecew', '1234', '1234', '0', '2', '2020-05-13 00:00:52', '2020-05-14 17:04:35');
INSERT INTO `book_order` VALUES ('3', '30', '3', '1', '行模糊', '18888888888', '北京北京市东城区', '学府路74号 黑龙江大学', null, null, '0', '3', '2020-05-13 22:40:37', '2020-05-14 17:07:23');
INSERT INTO `book_order` VALUES ('4', '30', '3', '1', '行模糊', '18888888888', '北京北京市东城区', '学府路74号 黑龙江大学', null, null, '0', '3', '2020-05-13 22:42:38', '2020-05-14 17:12:58');
INSERT INTO `book_order` VALUES ('5', '45', '1', '3', '樊宣佐', '15590852179', '黑龙江哈尔滨南岗区', '学府路74号黑龙江大学', null, null, '0', '3', '2020-05-15 10:46:31', '2020-05-15 10:52:19');
INSERT INTO `book_order` VALUES ('6', '68', '1', '3', '樊宣佐', '15590852179', '黑龙江哈尔滨南岗区', '学府路74号黑龙江大学', null, null, '0', '3', '2020-05-15 11:05:52', '2020-05-15 11:07:07');
INSERT INTO `book_order` VALUES ('7', '68', '1', '3', '樊宣佐', '15590852179', '黑龙江哈尔滨南岗区', '学府路74号黑龙江大学', null, null, '0', '3', '2020-05-15 11:14:21', '2020-05-15 11:16:12');

-- ----------------------------
-- Table structure for user_account
-- ----------------------------
DROP TABLE IF EXISTS `user_account`;
CREATE TABLE `user_account` (
  `uid` bigint(20) NOT NULL COMMENT '用户ID',
  `password` char(64) NOT NULL COMMENT '用户密码',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户账户信息表';

-- ----------------------------
-- Records of user_account
-- ----------------------------
INSERT INTO `user_account` VALUES ('1', 'c9935f89c41c33577de584d8ecac61c897dd244a6110673e63b66bb500a8b5ad', '2020-05-14 23:11:17');
INSERT INTO `user_account` VALUES ('3', 'c9935f89c41c33577de584d8ecac61c897dd244a6110673e63b66bb500a8b5ad', '2020-05-14 23:11:17');
INSERT INTO `user_account` VALUES ('4', 'c9935f89c41c33577de584d8ecac61c897dd244a6110673e63b66bb500a8b5ad', '2020-05-14 23:11:17');
INSERT INTO `user_account` VALUES ('10', '94001d478683ad7315f195de3f733ecb2aca554fcc1274fe1dca89c1a5c5d47a', '2020-05-15 11:00:36');

-- ----------------------------
-- Table structure for user_address
-- ----------------------------
DROP TABLE IF EXISTS `user_address`;
CREATE TABLE `user_address` (
  `address_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '地址id',
  `uid` bigint(20) NOT NULL COMMENT '用户id',
  `consignee` varchar(32) NOT NULL DEFAULT '' COMMENT '收货人姓名 ',
  `phone_number` varchar(16) DEFAULT NULL COMMENT '电话',
  `location` varchar(255) NOT NULL DEFAULT '' COMMENT '位置(省市区)',
  `address` varchar(255) NOT NULL DEFAULT '' COMMENT '详细地址',
  `default_flag` tinyint(1) NOT NULL DEFAULT '0' COMMENT '默认地址标记',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户地址信息表';

-- ----------------------------
-- Records of user_address
-- ----------------------------
INSERT INTO `user_address` VALUES ('6', '1', 'sdfad', '23', '1231', '321', '0', '2020-05-12 14:14:23', null);
INSERT INTO `user_address` VALUES ('7', '1', '擦擦自回退', '15590852179', 'bgsbt', '主贵自助胡', '0', '2020-05-12 14:14:35', '2020-05-13 15:55:29');
INSERT INTO `user_address` VALUES ('8', '1', 'sdfew', '1322131', 'sdqw', '2ed3', '0', '2020-05-12 14:14:47', null);
INSERT INTO `user_address` VALUES ('9', '1', '仔细听明我X5', '15590852179', '北京北京市东城区', '你住哦你好污', '0', '2020-05-12 21:45:41', '2020-05-12 21:49:44');
INSERT INTO `user_address` VALUES ('10', '1', '行模糊', '18888888888', '北京北京市东城区', '学府路74号 黑龙江大学', '1', '2020-05-12 21:49:36', '2020-05-13 15:57:26');
INSERT INTO `user_address` VALUES ('11', '3', '樊宣佐', '15590852179', '黑龙江哈尔滨南岗区', '学府路74号黑龙江大学', '0', '2020-05-15 10:33:21', '2020-05-15 10:41:35');
INSERT INTO `user_address` VALUES ('15', '3', '樊宣佐', '15590852179', '黑龙江哈尔滨南岗区', '黑龙江大学', '1', '2020-05-15 11:12:43', '2020-05-15 11:12:46');

-- ----------------------------
-- Table structure for user_base
-- ----------------------------
DROP TABLE IF EXISTS `user_base`;
CREATE TABLE `user_base` (
  `uid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `user_name` varchar(32) NOT NULL DEFAULT '' COMMENT '用户名，唯一',
  `gender` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '用户性别 0-未选 1-male 2-female ',
  `birthday` char(12) NOT NULL DEFAULT '' COMMENT '用户生日',
  `phone_number` varchar(16) DEFAULT NULL COMMENT '手机号码(唯一)',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱(唯一)',
  `face` varchar(255) NOT NULL DEFAULT '' COMMENT '头像',
  `location` varchar(255) NOT NULL DEFAULT '' COMMENT '常用地址',
  `school` varchar(64) NOT NULL DEFAULT '' COMMENT '就读院校',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`uid`),
  UNIQUE KEY `user_name` (`user_name`),
  UNIQUE KEY `phone_number` (`phone_number`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户基础信息表';

-- ----------------------------
-- Records of user_base
-- ----------------------------
INSERT INTO `user_base` VALUES ('1', 'nove1120', '0', '2001-12-1', null, null, 'timg-1.jpg', '浙江$杭州$上城区', '未填写', '2020-05-14 23:11:17', '2020-05-15 10:19:24');
INSERT INTO `user_base` VALUES ('3', 'TestUser1', '0', '', null, null, '1588855007631321.jpg', '浙江$杭州$上城区$杭州师范大学', '', '2020-05-14 23:11:17', '2020-05-14 23:44:01');
INSERT INTO `user_base` VALUES ('4', 'zhangsan', '1', '2000-12-1', '', null, 'test.jpg', '黑龙江$哈尔滨$南岗区', '黑龙江大学', '2020-05-14 23:11:17', '2020-05-15 02:19:05');
INSERT INTO `user_base` VALUES ('10', 'TestUser2', '1', '1999-12-1', '15590852179', null, '20200515102856Aicy.png', '黑龙江$哈尔滨$南岗区', '黑龙江大学', '2020-05-15 11:00:36', '2020-05-15 11:01:49');
