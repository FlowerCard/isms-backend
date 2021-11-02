/*
SQLyog Ultimate v12.4.3 (64 bit)
MySQL - 5.7.36 : Database - ISMS
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ISMS` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `ISMS`;

/*Table structure for table `city` */

DROP TABLE IF EXISTS `city`;

CREATE TABLE `city` (
  `city_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '区域id',
  `city_name` varchar(255) DEFAULT NULL COMMENT '区域名称',
  `is_delete` int(11) DEFAULT '0' COMMENT '是否删除 0:未删除 1:删除',
  PRIMARY KEY (`city_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='区域表';

/*Data for the table `city` */

insert  into `city`(`city_id`,`city_name`,`is_delete`) values 
(1,'上城区',0),
(2,'滨江区',0),
(3,'萧山区',0),
(4,'西湖区',0),
(5,'下城区',0),
(6,'拱墅区',0),
(7,'富阳区',0),
(8,'临平区',0),
(9,'钱塘区',0),
(10,'余杭区',0),
(11,'柯桥区',1),
(12,'test02',1),
(13,'test02',1),
(14,'test02',1),
(15,'测试地区',0),
(16,'测试地区01',1),
(17,'测试地区001',0);

/*Table structure for table `machine` */

DROP TABLE IF EXISTS `machine`;

CREATE TABLE `machine` (
  `m_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '设备id',
  `m_name` varchar(255) DEFAULT NULL COMMENT '设备名称',
  `is_online` int(11) DEFAULT '0' COMMENT '是否在线   0:在线 1:不在线',
  `is_enable` int(11) DEFAULT '0' COMMENT '是否启用 0：启用  1：未启用',
  `work_id` int(11) DEFAULT NULL COMMENT '此id跟工地表的id对应',
  `type_id` int(11) DEFAULT NULL COMMENT '此id跟设备类型表的id对应',
  `is_delete` int(11) DEFAULT '0' COMMENT '是否删除  0:未删除  1：已删除',
  `create_date` date DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`m_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='设备表';

/*Data for the table `machine` */

insert  into `machine`(`m_id`,`m_name`,`is_online`,`is_enable`,`work_id`,`type_id`,`is_delete`,`create_date`,`update_date`) values 
(1,'长城监控设备',0,0,1,1,0,'2021-10-29','2021-11-01 10:51:54'),
(2,'长城监控设备1',0,0,7,2,0,'2021-10-29','2021-11-01 09:51:21'),
(3,'长城监控设备2',0,0,2,2,0,'2021-10-29','2021-10-29 19:58:56'),
(4,'长城监控设备3',0,0,2,1,0,'2021-10-29','2021-10-30 10:31:01'),
(5,'长城监控设备4',0,0,1,1,0,'2021-10-29','2021-10-29 17:00:31'),
(6,'飞腾供电设备',0,0,2,3,0,'2021-10-29','2021-10-29 17:11:08'),
(7,'飞腾供电设备2',0,0,2,3,0,'2021-10-29','2021-10-29 17:11:34'),
(8,'飞腾供电设备3',0,0,2,3,0,'2021-10-29','2021-10-29 17:11:46'),
(9,'盯死你考勤设备',0,0,1,2,0,'2021-10-29','2021-10-29 17:12:28'),
(10,'盯死你考勤设备2',0,0,2,2,0,'2021-10-29','2021-10-29 17:12:46'),
(11,'大运汽车',0,0,1,4,0,'2021-10-29','2021-10-29 17:13:17'),
(12,'测试设备',0,1,1,1,0,'2021-11-01','2021-11-01 09:51:38'),
(13,'测试设备2',0,1,1,1,1,'2021-11-01','2021-11-01 11:33:28'),
(14,'测试设备2',0,0,1,1,0,'2021-11-01','2021-11-01 14:35:05'),
(15,'测试设备999',0,0,17,12,1,'2021-11-01','2021-11-01 14:43:53'),
(16,'测试设备999',1,0,16,12,0,'2021-11-01','2021-11-01 14:44:32'),
(17,'长城监控设备1111',0,0,1,2,1,'2021-11-02','2021-11-02 09:33:53');

/*Table structure for table `machine_type` */

DROP TABLE IF EXISTS `machine_type`;

CREATE TABLE `machine_type` (
  `type_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '设备类型',
  `type_name` varchar(255) DEFAULT NULL COMMENT '设备类型名称',
  `is_delete` int(11) DEFAULT '0' COMMENT '是否删除   0：未删除   1：已删除',
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='设备类型表';

/*Data for the table `machine_type` */

insert  into `machine_type`(`type_id`,`type_name`,`is_delete`) values 
(1,'监控设备',0),
(2,'考勤设备',0),
(3,'供电设备',0),
(4,'运输设备',0),
(5,'电器设备',0),
(6,'测试设备',0),
(7,'测试设备1',0),
(8,'测试设备2',0),
(9,'测试设备3',1),
(10,'测试设备3',0),
(11,'测试设备999',1),
(12,'测试设备999',0),
(13,'监控设备1111',1);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `u_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `is_admin` int(11) DEFAULT '1' COMMENT '身份 0:员工 1:管理员',
  `is_delete` int(11) DEFAULT '0' COMMENT '用户状态 0:未删除  1:已删除',
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='用户表';

/*Data for the table `user` */

insert  into `user`(`u_id`,`username`,`password`,`is_admin`,`is_delete`) values 
(2,'admin','admin',1,0),
(3,'admin1','admin1',1,0),
(4,'test','123',1,0),
(5,'test1','test1',0,0),
(6,'test3','123',0,0),
(8,'test5','123',0,0),
(9,'test6','123',0,0),
(10,'test7','1234',0,0),
(11,'test8','123',0,1),
(12,'test9','123456',0,1),
(13,'test8','123',1,0),
(14,'test9','123',0,0),
(15,'1111','1111',0,0);

/*Table structure for table `worksite` */

DROP TABLE IF EXISTS `worksite`;

CREATE TABLE `worksite` (
  `work_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '工地id',
  `work_name` varchar(255) DEFAULT NULL COMMENT '工地名称',
  `work_addr` varchar(255) DEFAULT NULL COMMENT '工地地址',
  `city_id` int(11) DEFAULT NULL COMMENT '此id跟城市id对应',
  `u_id` int(11) DEFAULT NULL COMMENT '此id跟用户表id对应',
  `create_time` date DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_delete` int(11) DEFAULT '0' COMMENT '是否删除  0:未删除  1:已删除',
  PRIMARY KEY (`work_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COMMENT='工地表';

/*Data for the table `worksite` */

insert  into `worksite`(`work_id`,`work_name`,`work_addr`,`city_id`,`u_id`,`create_time`,`update_time`,`is_delete`) values 
(1,'下城区工地','浙江省杭州市下城区10001',5,2,'2021-10-28','2021-10-29 13:54:18',0),
(2,'滨江区工地004','浙江省杭州市滨江区10001',2,2,'2021-10-25','2021-11-01 11:48:23',0),
(3,'test03','test03',3,2,'2021-10-29','2021-10-29 13:54:22',1),
(4,'test04','test03111',4,2,'2021-10-28','2021-10-30 10:21:51',1),
(5,'test05','test05',5,2,'2021-10-29','2021-10-29 13:54:26',0),
(6,'test06','test06',6,2,'2021-10-29','2021-10-29 13:54:29',0),
(7,'test07','test07',7,2,'2021-10-29','2021-10-29 13:54:27',0),
(8,'test08','test08',8,2,'2021-10-29','2021-10-29 13:54:31',0),
(9,'test09','test09',9,2,'2021-10-29','2021-10-29 13:54:33',0),
(10,'test10','test10111',10,2,'2021-10-28','2021-11-01 11:11:46',1),
(11,'上城区工地','浙江省杭州市上城区九沙大道100号',1,2,'2021-10-29','2021-10-29 13:54:36',0),
(12,'test11','test11',1,2,'2021-10-29','2021-10-29 13:54:37',0),
(13,'test12','test12',1,2,'2021-10-29','2021-10-29 13:54:41',0),
(14,'test13','test13',1,2,'2021-10-29','2021-10-29 13:54:39',0),
(15,'测试','测试',1,4,'2021-10-30',NULL,0),
(16,'滨江区工地','浙江省杭州市滨江区10001',2,2,'2021-11-01',NULL,0),
(17,'滨江区工地002','浙江省杭州市滨江区10002',2,2,'2021-10-31','2021-11-01 11:51:51',1),
(18,'滨江区工地003','浙江省杭州市滨江区10003',2,2,'2021-10-31','2021-11-01 11:54:36',1),
(19,'111111','11tttttt',2,2,'2021-11-01','2021-11-02 09:29:57',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
