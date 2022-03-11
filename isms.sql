/*
 Navicat Premium Data Transfer

 Source Server         : LocalDB
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost:3306
 Source Schema         : isms

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 10/02/2022 15:26:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for city
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city`  (
  `city_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '区域id',
  `city_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '区域名称',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '是否删除 0:未删除 1:删除',
  PRIMARY KEY (`city_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '区域表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of city
-- ----------------------------
INSERT INTO `city` VALUES (1, '上城区', 0);
INSERT INTO `city` VALUES (2, '滨江区', 0);
INSERT INTO `city` VALUES (3, '萧山区', 0);
INSERT INTO `city` VALUES (4, '西湖区', 0);
INSERT INTO `city` VALUES (5, '下城区', 0);
INSERT INTO `city` VALUES (6, '拱墅区', 0);
INSERT INTO `city` VALUES (7, '富阳区', 0);
INSERT INTO `city` VALUES (8, '临平区', 0);
INSERT INTO `city` VALUES (9, '钱塘区', 0);
INSERT INTO `city` VALUES (10, '余杭区', 0);
INSERT INTO `city` VALUES (11, '柯桥区', 1);
INSERT INTO `city` VALUES (12, 'test02', 1);
INSERT INTO `city` VALUES (13, 'test02', 1);
INSERT INTO `city` VALUES (14, 'test02', 1);
INSERT INTO `city` VALUES (15, '测试地区', 0);
INSERT INTO `city` VALUES (16, '测试地区01', 1);
INSERT INTO `city` VALUES (17, '测试地区001', 0);

-- ----------------------------
-- Table structure for machine
-- ----------------------------
DROP TABLE IF EXISTS `machine`;
CREATE TABLE `machine`  (
  `m_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '设备id',
  `m_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备名称',
  `is_online` int(11) NULL DEFAULT 0 COMMENT '是否在线   0:在线 1:不在线',
  `is_enable` int(11) NULL DEFAULT 0 COMMENT '是否启用 0：启用  1：未启用',
  `work_id` int(11) NULL DEFAULT NULL COMMENT '此id跟工地表的id对应',
  `type_id` int(11) NULL DEFAULT NULL COMMENT '此id跟设备类型表的id对应',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '是否删除  0:未删除  1：已删除',
  `create_date` date NULL DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`m_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '设备表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of machine
-- ----------------------------
INSERT INTO `machine` VALUES (1, '长城监控设备', 0, 0, 1, 1, 0, '2021-10-29', '2022-01-24 17:16:17');
INSERT INTO `machine` VALUES (2, '长城监控设备1', 0, 0, 7, 2, 0, '2021-10-29', '2021-11-01 09:51:21');
INSERT INTO `machine` VALUES (3, '长城监控设备2', 0, 0, 2, 2, 0, '2021-10-29', '2021-10-29 19:58:56');
INSERT INTO `machine` VALUES (4, '长城监控设备3', 0, 0, 2, 1, 0, '2021-10-29', '2021-10-30 10:31:01');
INSERT INTO `machine` VALUES (5, '长城监控设备4', 0, 0, 1, 1, 0, '2021-10-29', '2021-10-29 17:00:31');
INSERT INTO `machine` VALUES (6, '飞腾供电设备', 0, 0, 2, 3, 0, '2021-10-29', '2021-10-29 17:11:08');
INSERT INTO `machine` VALUES (7, '飞腾供电设备2', 0, 0, 2, 3, 0, '2021-10-29', '2021-10-29 17:11:34');
INSERT INTO `machine` VALUES (8, '飞腾供电设备3', 0, 0, 2, 3, 0, '2021-10-29', '2021-10-29 17:11:46');
INSERT INTO `machine` VALUES (9, '盯死你考勤设备', 0, 0, 1, 2, 0, '2021-10-29', '2021-10-29 17:12:28');
INSERT INTO `machine` VALUES (10, '盯死你考勤设备2', 0, 0, 2, 2, 0, '2021-10-29', '2021-10-29 17:12:46');
INSERT INTO `machine` VALUES (11, '大运汽车', 0, 0, 1, 4, 0, '2021-10-29', '2021-10-29 17:13:17');
INSERT INTO `machine` VALUES (12, '测试设备', 0, 1, 1, 1, 0, '2021-11-01', '2021-11-01 09:51:38');
INSERT INTO `machine` VALUES (13, '测试设备2', 0, 1, 1, 1, 1, '2021-11-01', '2021-11-01 11:33:28');
INSERT INTO `machine` VALUES (14, '测试设备2', 0, 0, 1, 1, 0, '2021-11-01', '2021-11-01 14:35:05');
INSERT INTO `machine` VALUES (15, '测试设备999', 0, 0, 17, 12, 1, '2021-11-01', '2021-11-01 14:43:53');
INSERT INTO `machine` VALUES (16, '测试设备999', 1, 0, 16, 12, 0, '2021-11-01', '2021-11-01 14:44:32');
INSERT INTO `machine` VALUES (17, '长城监控设备1111', 0, 0, 1, 2, 1, '2021-11-02', '2021-11-02 09:33:53');

-- ----------------------------
-- Table structure for machine_type
-- ----------------------------
DROP TABLE IF EXISTS `machine_type`;
CREATE TABLE `machine_type`  (
  `type_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '设备类型',
  `type_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备类型名称',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '是否删除   0：未删除   1：已删除',
  PRIMARY KEY (`type_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '设备类型表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of machine_type
-- ----------------------------
INSERT INTO `machine_type` VALUES (1, '监控设备', 0);
INSERT INTO `machine_type` VALUES (2, '考勤设备', 0);
INSERT INTO `machine_type` VALUES (3, '供电设备', 0);
INSERT INTO `machine_type` VALUES (4, '运输设备', 0);
INSERT INTO `machine_type` VALUES (5, '电器设备', 0);
INSERT INTO `machine_type` VALUES (6, '测试设备', 0);
INSERT INTO `machine_type` VALUES (7, '测试设备1', 0);
INSERT INTO `machine_type` VALUES (8, '测试设备2', 0);
INSERT INTO `machine_type` VALUES (9, '测试设备3', 1);
INSERT INTO `machine_type` VALUES (10, '测试设备3', 0);
INSERT INTO `machine_type` VALUES (11, '测试设备999', 1);
INSERT INTO `machine_type` VALUES (12, '测试设备999', 0);
INSERT INTO `machine_type` VALUES (13, '监控设备1111', 1);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `u_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'null' COMMENT '邮箱',
  `phone` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'null' COMMENT '手机号',
  `is_admin` int(11) NULL DEFAULT 1 COMMENT '身份 0:员工 1:管理员',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '用户状态 0:未删除  1:已删除',
  PRIMARY KEY (`u_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (2, 'admin', 'admin', 'null', 'null', 1, 0);
INSERT INTO `user` VALUES (3, 'admin1', 'admin1', 'null', 'null', 1, 0);
INSERT INTO `user` VALUES (4, 'test', '123', 'null', 'null', 1, 0);
INSERT INTO `user` VALUES (5, 'test1', 'test1', 'null', 'null', 0, 0);
INSERT INTO `user` VALUES (6, 'test3', '123', 'null', 'null', 0, 0);
INSERT INTO `user` VALUES (8, 'test5', '123', 'null', 'null', 0, 0);
INSERT INTO `user` VALUES (9, 'test6', '123', 'null', 'null', 0, 0);
INSERT INTO `user` VALUES (10, 'test7', '1234', 'null', 'null', 0, 0);
INSERT INTO `user` VALUES (11, 'test8', '123', 'null', 'null', 0, 1);
INSERT INTO `user` VALUES (12, 'test9', '123456', 'null', 'null', 0, 1);
INSERT INTO `user` VALUES (13, 'test8', '123', 'null', 'null', 1, 0);
INSERT INTO `user` VALUES (14, 'test9', '123', 'null', 'null', 0, 0);
INSERT INTO `user` VALUES (15, '1111', '1111', 'null', 'null', 0, 0);

-- ----------------------------
-- Table structure for worksite
-- ----------------------------
DROP TABLE IF EXISTS `worksite`;
CREATE TABLE `worksite`  (
  `work_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '工地id',
  `work_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工地名称',
  `work_addr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工地地址',
  `city_id` int(11) NULL DEFAULT NULL COMMENT '此id跟城市id对应',
  `u_id` int(11) NULL DEFAULT NULL COMMENT '此id跟用户表id对应',
  `create_time` date NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '是否删除  0:未删除  1:已删除',
  PRIMARY KEY (`work_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '工地表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of worksite
-- ----------------------------
INSERT INTO `worksite` VALUES (1, '下城区工地', '浙江省杭州市下城区10001', 5, 2, '2021-10-28', '2021-10-29 13:54:18', 0);
INSERT INTO `worksite` VALUES (2, '滨江区工地004', '浙江省杭州市滨江区10001', 2, 2, '2021-10-25', '2021-11-01 11:48:23', 0);
INSERT INTO `worksite` VALUES (3, 'test03', 'test03', 3, 2, '2021-10-29', '2021-10-29 13:54:22', 1);
INSERT INTO `worksite` VALUES (4, 'test04', 'test03111', 4, 2, '2021-10-28', '2021-10-30 10:21:51', 1);
INSERT INTO `worksite` VALUES (5, 'test05', 'test05', 5, 2, '2021-10-29', '2021-10-29 13:54:26', 0);
INSERT INTO `worksite` VALUES (6, 'test06', 'test06', 6, 2, '2021-10-29', '2021-10-29 13:54:29', 0);
INSERT INTO `worksite` VALUES (7, 'test07', 'test07', 7, 2, '2021-10-29', '2021-10-29 13:54:27', 0);
INSERT INTO `worksite` VALUES (8, 'test08', 'test08', 8, 2, '2021-10-29', '2021-10-29 13:54:31', 0);
INSERT INTO `worksite` VALUES (9, 'test09', 'test09', 9, 2, '2021-10-29', '2021-10-29 13:54:33', 0);
INSERT INTO `worksite` VALUES (10, 'test10', 'test10111', 10, 2, '2021-10-28', '2021-11-01 11:11:46', 1);
INSERT INTO `worksite` VALUES (11, '上城区工地', '浙江省杭州市上城区九沙大道100号', 1, 2, '2021-10-29', '2021-10-29 13:54:36', 0);
INSERT INTO `worksite` VALUES (12, 'test11', 'test11', 1, 2, '2021-10-29', '2021-10-29 13:54:37', 0);
INSERT INTO `worksite` VALUES (13, 'test12', 'test12', 1, 2, '2021-10-29', '2021-10-29 13:54:41', 0);
INSERT INTO `worksite` VALUES (14, 'test13', 'test13', 1, 2, '2021-10-29', '2021-10-29 13:54:39', 0);
INSERT INTO `worksite` VALUES (15, '测试', '测试', 1, 4, '2021-10-30', NULL, 0);
INSERT INTO `worksite` VALUES (16, '滨江区工地', '浙江省杭州市滨江区10001', 2, 2, '2021-11-01', NULL, 0);
INSERT INTO `worksite` VALUES (17, '滨江区工地002', '浙江省杭州市滨江区10002', 2, 2, '2021-10-31', '2021-11-01 11:51:51', 1);
INSERT INTO `worksite` VALUES (18, '滨江区工地003', '浙江省杭州市滨江区10003', 2, 2, '2021-10-31', '2021-11-01 11:54:36', 1);
INSERT INTO `worksite` VALUES (19, '111111', '11tttttt', 2, 2, '2021-11-01', '2021-11-02 09:29:57', 1);

SET FOREIGN_KEY_CHECKS = 1;
