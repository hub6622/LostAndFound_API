/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.41-log : Database - lostandfound
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`lostandfound` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `lostandfound`;

/*Table structure for table `sys_file` */

DROP TABLE IF EXISTS `sys_file`;

CREATE TABLE `sys_file` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `file_name` char(50) DEFAULT NULL,
  `user_id` int(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `file_url` text,
  `update_time` datetime DEFAULT NULL,
  `item_id` int(50) DEFAULT NULL,
  `is_avatar` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

/*Data for the table `sys_file` */

insert  into `sys_file`(`id`,`file_name`,`user_id`,`create_time`,`file_url`,`update_time`,`item_id`,`is_avatar`) values (1,'81f96395-f074-4c73-a4f6-b21a1f9ce7d7.jpg',4,'2024-10-22 20:50:52','http://120.26.93.27:9000/public/81f96395-f074-4c73-a4f6-b21a1f9ce7d7.jpg','2024-10-27 15:43:45',NULL,1),(2,'e228df3b-d158-4ae9-b148-15b2a1e08b5e.jpg',4,'2024-10-27 14:49:53','http://120.26.93.27:9000/public/e228df3b-d158-4ae9-b148-15b2a1e08b5e.jpg','2024-10-27 15:43:45',28,0),(3,'92ad881a-8a37-440e-8553-cb2cc7ecbef7.jpg',1,'2024-10-27 15:06:18','http://120.26.93.27:9000/public/92ad881a-8a37-440e-8553-cb2cc7ecbef7.jpg','2024-10-29 18:11:29',29,0),(4,'5d885bca-9ab6-4d06-8034-ec6b3ce2f141.jpg',1,'2024-10-27 15:08:54','http://120.26.93.27:9000/public/5d885bca-9ab6-4d06-8034-ec6b3ce2f141.jpg','2024-10-27 15:43:45',30,0),(5,'f246a71c-af50-4159-bd8c-87de069fe847.jpg',1,'2024-10-27 15:11:25','http://120.26.93.27:9000/public/f246a71c-af50-4159-bd8c-87de069fe847.jpg','2024-10-27 15:43:45',31,0),(12,'81908b6d-2748-49a5-af52-71fa00505a48.jpg',1,'2024-10-27 15:26:21','http://120.26.93.27:9000/public/81908b6d-2748-49a5-af52-71fa00505a48.jpg','2024-10-27 15:51:45',32,0),(13,'ce2a0fe2-9d67-4685-9654-1a7c115bf736.jpg',4,'2024-10-27 15:27:29','http://120.26.93.27:9000/public/ce2a0fe2-9d67-4685-9654-1a7c115bf736.jpg','2024-10-29 10:22:55',39,0),(14,'370ec439-3115-4d36-b79d-6a7374c00d1f.jpg',4,'2024-10-27 15:29:51','http://120.26.93.27:9000/public/370ec439-3115-4d36-b79d-6a7374c00d1f.jpg','2024-10-27 15:51:45',40,0),(15,'0d48d250-8840-41b3-9a8c-17144b0b1a01.jpg',4,'2024-10-27 17:02:27','http://120.26.93.27:9000/public/0d48d250-8840-41b3-9a8c-17144b0b1a01.jpg',NULL,41,0),(16,'b8150b7b-bc1a-4b1b-8a90-8e4b7abb0577.jpg',1,'2024-10-27 17:03:27','http://120.26.93.27:9000/public/b8150b7b-bc1a-4b1b-8a90-8e4b7abb0577.jpg',NULL,NULL,1),(17,'0ee8f2aa-1b21-4438-9aec-188f26f1d93b.webp',4,'2024-10-27 17:23:47','http://120.26.93.27:9000/public/0ee8f2aa-1b21-4438-9aec-188f26f1d93b.webp','2024-10-29 18:50:38',43,0),(20,'0db768ac-02e8-4933-9f21-1b7e9e8e8a7a.png',17,'2024-10-27 17:31:27','http://120.26.93.27:9000/public/0db768ac-02e8-4933-9f21-1b7e9e8e8a7a.png',NULL,NULL,1),(21,'#',4,'2024-10-29 10:16:44','#',NULL,42,0),(22,'d0e0b5c1-183d-4dc2-9fc2-4d37990cee07.png',18,'2024-10-29 18:35:17','http://120.26.93.27:9000/public/d0e0b5c1-183d-4dc2-9fc2-4d37990cee07.png',NULL,NULL,1),(23,'0ee8f2aa-1b21-4438-9aec-188f26f1d93b.webp',18,'2024-10-29 18:38:16','http://120.26.93.27:9000/public/0ee8f2aa-1b21-4438-9aec-188f26f1d93b.webp','2024-10-29 18:50:38',43,0),(24,'225fcee2-e7e2-4b7e-8c72-ed732ad07af3.jpeg',19,'2024-10-29 18:48:35','http://120.26.93.27:9000/public/225fcee2-e7e2-4b7e-8c72-ed732ad07af3.jpeg',NULL,NULL,1),(25,'8cd8b651-bcd7-4383-9311-c367afe8dfd3.jpg',19,'2024-10-29 18:50:05','http://120.26.93.27:9000/public/8cd8b651-bcd7-4383-9311-c367afe8dfd3.jpg',NULL,44,0),(29,'b2b9e714-a771-402e-a672-412a2529f800.jpg',1,'2024-11-05 21:45:39','http://120.26.93.27:9000/public/b2b9e714-a771-402e-a672-412a2529f800.jpg',NULL,47,0),(30,'b9396ecd-edd8-4ab7-be03-ec36b579b194.jpg',1,'2024-11-05 21:46:20','http://120.26.93.27:9000/public/b9396ecd-edd8-4ab7-be03-ec36b579b194.jpg',NULL,48,0);

/*Table structure for table `sys_notice` */

DROP TABLE IF EXISTS `sys_notice`;

CREATE TABLE `sys_notice` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `content` text,
  `author_id` int(10) DEFAULT NULL,
  `confirm` int(2) DEFAULT NULL,
  `item_id` int(5) DEFAULT NULL,
  `tradeTime` datetime DEFAULT NULL,
  `contact` varchar(50) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `recipient_id` int(50) DEFAULT NULL,
  `system` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

/*Data for the table `sys_notice` */

insert  into `sys_notice`(`id`,`content`,`author_id`,`confirm`,`item_id`,`tradeTime`,`contact`,`updateTime`,`recipient_id`,`system`) values (2,'这是我的东西，我们在西北门见面吧',1,1,28,'2024-10-27 06:16:24','15888888883','2024-10-27 14:16:55',4,0),(4,';',4,1,29,'2024-11-02 09:10:26','13381619674','2024-11-02 17:10:32',1,0),(14,'222',1,1,40,'2024-11-04 11:43:17','15888888883','2024-11-04 19:43:21',4,0),(15,'我捡到了，明天给你',4,0,43,'2024-11-05 12:22:16','13381619674','2024-11-04 20:22:20',18,0),(19,'这个时间我没空，你看看这个时间行不行',4,1,40,'2024-11-04 12:44:50','','2024-11-04 20:44:53',1,0),(21,'同意了你的请求',1,1,40,NULL,NULL,'2024-11-04 22:30:25',4,0),(22,'你好，我的学生证',1,1,40,'2024-11-08 14:36:36','agileboot@163.com','2024-11-04 22:36:49',4,0),(23,'同意了你的请求',1,1,40,NULL,NULL,'2024-11-04 22:37:16',4,0),(24,'这个时间我没空，你看看这个时间行不行',4,1,40,'2024-11-07 14:37:31','','2024-11-04 22:37:53',1,0),(25,'这个时间我没空，你看看这个时间行不行',1,1,40,'2024-11-06 14:38:03','','2024-11-04 22:38:12',4,0),(26,'同意了你的请求',4,1,40,NULL,NULL,'2024-11-04 22:38:18',1,0),(27,'',1,1,40,'2024-11-05 08:51:38','这是我的qq：1633321257','2024-11-05 16:51:57',4,0),(28,'这个时间我没空，你看看这个时间行不行',4,1,40,'2024-11-05 08:53:34','','2024-11-05 16:53:42',1,0),(29,'同意了你的请求',1,2,40,NULL,NULL,'2024-11-05 16:54:03',4,0),(30,'这是一个系统通知',1,0,NULL,NULL,NULL,'2024-11-06 11:04:56',1,1),(31,'这是一个系统通知',1,0,NULL,NULL,NULL,'2024-11-06 11:04:56',2,1),(32,'这是一个系统通知',1,0,NULL,NULL,NULL,'2024-11-06 11:04:56',3,1),(33,'这是一个系统通知',1,0,NULL,NULL,NULL,'2024-11-06 11:04:56',4,1),(34,'这是一个系统通知',1,0,NULL,NULL,NULL,'2024-11-06 11:04:56',17,1),(35,'这是一个系统通知',1,0,NULL,NULL,NULL,'2024-11-06 11:04:56',18,1),(36,'这是一个系统通知',1,1,NULL,NULL,NULL,'2024-11-06 11:04:56',19,1),(37,'这是一个系统通知',1,0,NULL,NULL,NULL,'2024-11-06 11:04:56',23,1),(38,'这是一个系统通知',1,0,NULL,NULL,NULL,'2024-11-06 11:04:56',24,1),(39,'这是一个系统通知',1,0,NULL,NULL,NULL,'2024-11-06 11:04:56',25,1),(40,'这是一个系统通知',1,0,NULL,NULL,NULL,'2024-11-06 11:04:56',26,1);

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(64) NOT NULL COMMENT '用户账号',
  `biography` text COMMENT '个人简介',
  `email` varchar(128) DEFAULT '' COMMENT '用户邮箱',
  `phone_number` varchar(18) DEFAULT '' COMMENT '手机号码',
  `sex` smallint(6) DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
  `avatar` varchar(512) DEFAULT '' COMMENT '头像地址',
  `password` varchar(128) NOT NULL DEFAULT '' COMMENT '密码',
  `status` smallint(6) NOT NULL DEFAULT '0' COMMENT '帐号状态（1正常 2停用 3冻结）',
  `login_date` datetime DEFAULT NULL COMMENT '最后登录时间',
  `is_admin` tinyint(1) NOT NULL DEFAULT '0' COMMENT '超级管理员标志（1是，0否）',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

/*Data for the table `sys_user` */

insert  into `sys_user`(`user_id`,`username`,`biography`,`email`,`phone_number`,`sex`,`avatar`,`password`,`status`,`login_date`,`is_admin`,`create_time`) values (1,'admin',NULL,'agileboot@163.com','15888888883',1,'http://120.26.93.27:9000/public/b8150b7b-bc1a-4b1b-8a90-8e4b7abb0577.jpg','25d55ad283aa400af464c76d713c07ad',1,'2024-11-06 11:26:54',1,'2022-05-21 08:30:54'),(2,'ag1',NULL,'agileboot1@qq.com','15666666666',1,'http://120.26.93.27:9000/public/d5f11b41-4b24-49ae-9268-283a580b7767.png','$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2',1,'2022-05-21 08:30:54',0,'2022-05-21 08:30:54'),(3,'ag2',NULL,'agileboot2@qq.com','15666666667',1,'http://120.26.93.27:9000/public/fe90fc1a-af9a-4c11-83bf-e45206585ae9.png','25d55ad283aa400af464c76d713c07ad',1,'2024-10-27 17:24:45',0,'2022-05-21 08:30:54'),(4,'ppg','我是一名正常的用户，遵纪守法的好公民!!!','163@qq.com','13381619674',1,'http://120.26.93.27:9000/public/81f96395-f074-4c73-a4f6-b21a1f9ce7d7.jpg','25d55ad283aa400af464c76d713c07ad',1,'2024-11-05 16:52:10',0,'2024-10-17 20:07:21'),(17,'ag3',NULL,'','',0,'http://120.26.93.27:9000/public/0db768ac-02e8-4933-9f21-1b7e9e8e8a7a.png','25d55ad283aa400af464c76d713c07ad',1,'2024-10-27 17:32:15',0,'2024-10-27 17:31:27'),(18,'cjd',NULL,'','',0,'http://120.26.93.27:9000/public/d0e0b5c1-183d-4dc2-9fc2-4d37990cee07.png','25d55ad283aa400af464c76d713c07ad',1,'2024-10-29 18:35:18',0,'2024-10-29 18:35:17'),(19,'xjl','','996@qq.com','13245678908',0,'http://120.26.93.27:9000/public/225fcee2-e7e2-4b7e-8c72-ed732ad07af3.jpeg','25d55ad283aa400af464c76d713c07ad',1,'2024-11-06 11:27:05',0,'2024-10-29 18:48:35'),(23,'2',NULL,'2','2',1,NULL,'',1,NULL,1,'2024-11-05 22:24:22'),(24,'3',NULL,'3','3',0,NULL,'',0,NULL,0,'2024-11-05 22:24:30'),(25,'333',NULL,'333','333',1,NULL,'',0,NULL,1,'2024-11-05 22:24:38'),(26,'3',NULL,'33','3',0,NULL,'',0,NULL,0,'2024-11-05 22:24:47');

/*Table structure for table `t_category` */

DROP TABLE IF EXISTS `t_category`;

CREATE TABLE `t_category` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `t_category` */

insert  into `t_category`(`id`,`category_name`,`create_time`,`update_time`) values (1,'钥匙','2024-10-24 10:39:15',NULL),(2,'生活用品','2024-10-24 22:40:26','2024-10-24 22:44:38'),(3,'证件','2024-10-27 14:18:10',NULL),(4,'手机','2024-10-27 14:18:17',NULL),(5,'钱包','2024-10-27 14:18:23',NULL),(6,'笔记本','2024-10-27 14:18:27',NULL),(7,'衣服','2024-10-27 14:18:39',NULL),(8,'相机','2024-10-27 14:18:43',NULL),(9,'银行卡','2024-10-27 14:18:54',NULL),(10,'其他','2024-10-27 14:19:19',NULL),(11,'首饰','2024-10-27 14:19:26',NULL),(12,'蓝牙耳机','2024-10-27 15:05:20',NULL),(13,'电子产品','2024-10-27 15:29:46',NULL);

/*Table structure for table `t_comment_reply` */

DROP TABLE IF EXISTS `t_comment_reply`;

CREATE TABLE `t_comment_reply` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `author_id` int(20) DEFAULT NULL,
  `reply_time` datetime DEFAULT NULL,
  `content` text,
  `item_id` int(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `t_comment_reply` */

insert  into `t_comment_reply`(`id`,`author_id`,`reply_time`,`content`,`item_id`) values (1,3,'2024-10-27 15:39:12','哈哈，他包是打原神的',41),(2,3,'2024-10-27 15:39:29','教室那鼠标油啊',32),(3,3,'2024-10-27 15:39:36','你不觉得吗',32),(4,3,'2024-10-27 15:39:47','人家就带，怎么着',32),(5,3,'2024-10-27 15:41:34','嘻嘻',32),(6,1,'2024-10-27 15:44:29','坏事做尽',28),(14,4,'2024-10-29 18:21:21','人机',41);

/*Table structure for table `t_comments` */

DROP TABLE IF EXISTS `t_comments`;

CREATE TABLE `t_comments` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `author_id` int(20) DEFAULT NULL,
  `content` text,
  `comment_time` datetime DEFAULT NULL,
  `comment_order` int(1) DEFAULT NULL,
  `item_id` int(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `t_comments` */

insert  into `t_comments`(`id`,`author_id`,`content`,`comment_time`,`comment_order`,`item_id`) values (1,4,'教室鼠标不好用吗','2024-10-27 15:33:12',NULL,32),(2,4,'让你带鼠标，丢了吧','2024-10-27 15:33:48',NULL,32),(3,4,'带平板打原神吗','2024-10-27 15:34:20',NULL,41),(4,4,'你的耳机我偷走了，已经卖掉换钱了','2024-10-27 15:34:56',NULL,30),(5,4,'这学生证有名字吗，发出来看看啊','2024-10-27 15:37:23',NULL,40),(6,3,'我开走的','2024-10-27 15:42:00',NULL,28),(7,1,'和我的IPAD很像','2024-10-27 15:44:12',NULL,41);

/*Table structure for table `t_item` */

DROP TABLE IF EXISTS `t_item`;

CREATE TABLE `t_item` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `title` varchar(30) DEFAULT NULL,
  `content` text,
  `picUrl` varchar(500) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `view_counts` int(10) DEFAULT NULL,
  `comment_counts` int(10) DEFAULT NULL,
  `author_id` int(10) DEFAULT NULL,
  `lostfound` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;

/*Data for the table `t_item` */

insert  into `t_item`(`id`,`title`,`content`,`picUrl`,`create_time`,`view_counts`,`comment_counts`,`author_id`,`lostfound`) values (28,'我的迈巴赫钥匙丢了，谁捡到了吗？','我靠，我车被谁开走了','http://120.26.93.27:9000/public/e228df3b-d158-4ae9-b148-15b2a1e08b5e.jpg','2024-10-11 17:26:47',114,3,4,1),(29,'我在人工食堂拾得一张雪雪雪的校园卡','是在靠近某某面馆前面的桌子上','http://120.26.93.27:9000/public/92ad881a-8a37-440e-8553-cb2cc7ecbef7.jpg','2024-10-27 14:49:53',12,0,1,0),(30,'在公共教学楼丢失蓝牙耳机','是在A108丢失的oppo耳机','http://120.26.93.27:9000/public/5d885bca-9ab6-4d06-8034-ec6b3ce2f141.jpg','2024-10-27 15:06:18',6,1,1,1),(31,'捡到肖同学的身份证','在观潮A二楼楼梯间捡到','http://120.26.93.27:9000/public/f246a71c-af50-4159-bd8c-87de069fe847.jpg','2024-10-27 15:08:54',2,0,1,0),(32,'在人工智能教室311丢失鼠标一个','','http://120.26.93.27:9000/public/81908b6d-2748-49a5-af52-71fa00505a48.jpg','2024-10-27 15:11:25',12,8,1,1),(39,'捡到一支笔.','在公共教学楼212','http://120.26.93.27:9000/public/ce2a0fe2-9d67-4685-9654-1a7c115bf736.jpg','2024-10-27 15:26:21',5,0,4,0),(40,'学生证，在操场上捡到的','靠近光电那个操场门附近','http://120.26.93.27:9000/public/370ec439-3115-4d36-b79d-6a7374c00d1f.jpg','2024-10-27 15:27:29',19,1,4,0),(41,'本人在教学楼遗失了我的IPAD','我的IPAD与2024年10月25日于人工智能教室301遗失','http://120.26.93.27:9000/public/0d48d250-8840-41b3-9a8c-17144b0b1a01.jpg','2024-10-27 15:29:51',11,5,4,1),(43,'apple watch','去公共教学楼101的时候忘记拿了','http://120.26.93.27:9000/public/0ee8f2aa-1b21-4438-9aec-188f26f1d93b.webp','2024-10-29 18:38:16',12,0,18,1),(44,' sony xm5','去陶吉吉演唱会落了','http://120.26.93.27:9000/public/8cd8b651-bcd7-4383-9311-c367afe8dfd3.jpg','2024-10-29 18:50:05',5,0,19,1),(46,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(47,'电脑丢了','我的笔记本昨天忘教室里没了','http://120.26.93.27:9000/public/b2b9e714-a771-402e-a672-412a2529f800.jpg','2024-11-05 21:45:39',0,0,1,0),(48,'手电筒，有人捡到吗','应该是在校外马路上丢的','http://120.26.93.27:9000/public/b9396ecd-edd8-4ab7-be03-ec36b579b194.jpg','2024-11-05 21:46:20',0,0,1,0);

/*Table structure for table `t_item_category` */

DROP TABLE IF EXISTS `t_item_category`;

CREATE TABLE `t_item_category` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `item_id` int(100) DEFAULT NULL,
  `category_id` int(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8;

/*Data for the table `t_item_category` */

insert  into `t_item_category`(`id`,`item_id`,`category_id`) values (3,27,1),(4,21,1),(33,28,1),(34,28,2),(51,38,2),(52,38,4),(53,38,7),(54,38,5),(55,38,3),(56,30,12),(57,30,2),(58,31,3),(59,32,6),(60,32,10),(63,40,3),(65,41,10),(66,41,13),(71,39,2),(72,29,10),(73,29,3),(76,44,12),(77,43,13),(78,45,1),(79,45,2),(80,47,13),(81,47,6),(82,48,2),(83,48,10);

/*Table structure for table `t_item_comment_reply` */

DROP TABLE IF EXISTS `t_item_comment_reply`;

CREATE TABLE `t_item_comment_reply` (
  `item` int(10) DEFAULT NULL,
  `comment` int(10) DEFAULT NULL,
  `reply` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_item_comment_reply` */

insert  into `t_item_comment_reply`(`item`,`comment`,`reply`) values (32,1,NULL),(32,2,NULL),(41,3,NULL),(30,4,NULL),(40,5,NULL),(NULL,3,1),(NULL,1,2),(NULL,1,3),(NULL,2,4),(NULL,2,5),(28,6,NULL),(41,7,NULL),(NULL,6,6),(NULL,7,14);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
