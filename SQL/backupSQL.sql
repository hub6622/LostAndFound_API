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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `sys_notice` */

insert  into `sys_notice`(`id`,`content`,`author_id`,`confirm`,`item_id`,`tradeTime`,`contact`,`updateTime`) values (7,'这是我的草泥马',4,NULL,21,'2024-10-24 08:42:55','163@qq.com','2024-10-11 16:43:14');

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `post_id` bigint(20) DEFAULT NULL COMMENT '职位id',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色id',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门ID',
  `username` varchar(64) NOT NULL COMMENT '用户账号',
  `nickname` varchar(32) NOT NULL COMMENT '用户昵称',
  `user_type` smallint(6) DEFAULT '0' COMMENT '用户类型（00系统用户）',
  `email` varchar(128) DEFAULT '' COMMENT '用户邮箱',
  `phone_number` varchar(18) DEFAULT '' COMMENT '手机号码',
  `sex` smallint(6) DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
  `avatar` varchar(512) DEFAULT '' COMMENT '头像地址',
  `password` varchar(128) NOT NULL DEFAULT '' COMMENT '密码',
  `status` smallint(6) NOT NULL DEFAULT '0' COMMENT '帐号状态（1正常 2停用 3冻结）',
  `login_ip` varchar(128) DEFAULT '' COMMENT '最后登录IP',
  `login_date` datetime DEFAULT NULL COMMENT '最后登录时间',
  `is_admin` tinyint(1) NOT NULL DEFAULT '0' COMMENT '超级管理员标志（1是，0否）',
  `creator_id` bigint(20) DEFAULT NULL COMMENT '更新者ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updater_id` bigint(20) DEFAULT NULL COMMENT '更新者ID',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(512) DEFAULT NULL COMMENT '备注',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

/*Data for the table `sys_user` */

insert  into `sys_user`(`user_id`,`post_id`,`role_id`,`dept_id`,`username`,`nickname`,`user_type`,`email`,`phone_number`,`sex`,`avatar`,`password`,`status`,`login_ip`,`login_date`,`is_admin`,`creator_id`,`create_time`,`updater_id`,`update_time`,`remark`,`deleted`) values (1,1,1,4,'admin','valarchie1',0,'agileboot@163.com','15888888883',0,'/profile/avatar/20230725164110_blob_6b7a989b1cdd4dd396665d2cfd2addc5.png','$2a$10$o55UFZAtyWnDpRV6dvQe8.c/MjlFacC49ASj2usNXm9BY74SYI/uG',1,'0:0:0:0:0:0:0:1','2024-10-09 20:57:52',1,NULL,'2022-05-21 08:30:54',1,'2024-10-09 21:22:21','管理员',0),(2,2,2,5,'ag1','valarchie2',0,'agileboot1@qq.com','15666666666',1,'/profile/avatar/20230725114818_avatar_b5bf400732bb43369b4df58802049b22.png','$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2',1,'127.0.0.1','2022-05-21 08:30:54',0,NULL,'2022-05-21 08:30:54',1,'2024-10-09 21:22:05','测试员1',0),(3,2,0,5,'ag2','valarchie3',0,'agileboot2@qq.com','15666666667',1,'/profile/avatar/20230725114818_avatar_b5bf400732bb43369b4df58802049b22.png','$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2',1,'127.0.0.1','2022-05-21 08:30:54',0,NULL,'2022-05-21 08:30:54',NULL,NULL,'测试员2',0),(4,NULL,NULL,NULL,'ppg','ppg',0,'163@qq.com','13381619674',0,'http://www.ppg6.store:9000/public/9eb6176c-5fd4-40b5-8e99-81123002019e.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=PPG%2F20241009%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20241009T061424Z&X-Amz-Expires=604800&X-Amz-SignedHeaders=host&X-Amz-Signature=425e0a3b9cc4ecc63c8d6180b9ca465a7f1201ad1e12d3680459f46f785a9209','0192023a7bbd73250516f069df18b500',1,'0:0:0:0:0:0:0:1','2024-10-09 15:25:57',0,NULL,NULL,1,'2024-10-09 15:25:57',NULL,0);

/*Table structure for table `t_comment_reply` */

DROP TABLE IF EXISTS `t_comment_reply`;

CREATE TABLE `t_comment_reply` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `author_id` int(20) DEFAULT NULL,
  `reply_time` datetime DEFAULT NULL,
  `content` text,
  `item_id` int(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;

/*Data for the table `t_comment_reply` */

insert  into `t_comment_reply`(`id`,`author_id`,`reply_time`,`content`,`item_id`) values (54,4,'2024-10-12 14:31:47','2',20);

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
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf8;

/*Data for the table `t_comments` */

insert  into `t_comments`(`id`,`author_id`,`content`,`comment_time`,`comment_order`,`item_id`) values (78,4,'2','2024-10-12 14:31:45',NULL,20);

/*Table structure for table `t_item` */

DROP TABLE IF EXISTS `t_item`;

CREATE TABLE `t_item` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `title` varchar(30) DEFAULT NULL,
  `content` text,
  `picUrl` varchar(500) DEFAULT NULL,
  `category` varchar(10) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `view_counts` int(10) DEFAULT NULL,
  `comment_counts` int(10) DEFAULT NULL,
  `author_id` int(10) DEFAULT NULL,
  `lostfound` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

/*Data for the table `t_item` */

insert  into `t_item`(`id`,`title`,`content`,`picUrl`,`category`,`create_time`,`view_counts`,`comment_counts`,`author_id`,`lostfound`) values (1,'1号图片','美1','http://www.ppg6.store:9000/public/58d5c6b0-7886-43d9-97d7-741c19873623.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=PPG%2F20241008%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20241008T065016Z&X-Amz-Expires=604800&X-Amz-SignedHeaders=host&X-Amz-Signature=fd3937b49d1fc6ae8ad2ccf2eb6db55801b56018afb6d8cef7941ea119f97cd7','车钥匙','2024-10-08 14:58:05',2,0,4,0),(19,'4号图片','美4','http://www.ppg6.store:9000/public/968bf671-cb0c-420e-a79b-631b71953e44.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=PPG%2F20241012%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20241012T071342Z&X-Amz-Expires=604800&X-Amz-SignedHeaders=host&X-Amz-Signature=e4cea707af49db2a7b93ec8d77f051344e3e15703234a4641133bafcb65823f0',NULL,'2024-10-08 14:58:11',8,0,4,1),(20,'5号图片','美5','http://www.ppg6.store:9000/public/14173b1c-466d-45f7-8ca8-4e1d0d63b9b9.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=PPG%2F20241008%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20241008T065549Z&X-Amz-Expires=604800&X-Amz-SignedHeaders=host&X-Amz-Signature=10096139d0d088a38f7fccb001754aebd6cd397984d9511df10a46f4069a015f',NULL,'2024-10-08 14:58:15',2,2,4,1),(21,'6号图片','华民族长远利益考虑，走生态优先、绿色发展之路，使绿水青山产生巨大生态效益、经济效益、社会效益，使母亲河永葆生机活力。”“长江拥有独特的生态系统，是我国重要的生态宝库。当前和今后相当长一个时期，要把修复长江生态环境摆在压倒性位置，共抓大保护，不搞大开发。”习近平总书记的话语掷地有声。6年来，沿江11省市推进生态环境整治，促进经济社会发展全面绿色转型，一场场生态保护攻坚战接连打响，长江经济带生态环境保护发生转折性变化，经济社会发展取得历史性成就。\r\n数据显示，截至2021年三季度，长江经济带经济总量占全国的比重约47%，生物医药、集成电路和装备制造等产业规模占全国比重均超过50%。长江经济带生态保','http://www.ppg6.store:9000/public/5f63034f-1054-44b0-bbc5-b010cd6a0843.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=PPG%2F20241008%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20241008T065602Z&X-Amz-Expires=604800&X-Amz-SignedHeaders=host&X-Amz-Signature=1997f23fe42b25ac76513577044ae8cececfd0e16493dd8db2dbe4e637d419da',NULL,'2024-10-08 14:58:13',125,0,4,1),(27,'哔哩哔哩','666','http://www.ppg6.store:9000/public/aed02d51-71d8-45a1-8366-e7d4de17748f.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=PPG%2F20241010%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20241010T080520Z&X-Amz-Expires=604800&X-Amz-SignedHeaders=host&X-Amz-Signature=b471f923d6e44164ca95602f58cac521e38ba674391c31dced811c8cb77baa77','','2024-10-10 16:05:26',100,0,4,0),(28,'我的迈巴赫钥匙丢了，谁捡到了','草泥马，我车被谁开走了','http://www.ppg6.store:9000/public/e228df3b-d158-4ae9-b148-15b2a1e08b5e.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=PPG%2F20241011%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20241011T092634Z&X-Amz-Expires=604800&X-Amz-SignedHeaders=host&X-Amz-Signature=1cf060dccccfccfae481aec1abc583008b0f5e317714cc1afb70d80a80c9c79d','车钥匙','2024-10-11 17:26:47',48,0,4,1),(33,'2222222222222','2222222222222','222222222222222222222','233','2024-10-12 14:41:15',0,0,4,1),(34,'111','失去','#','','2024-10-12 15:46:27',0,0,4,0),(35,'使','拾取','#','','2024-10-12 15:50:44',1,0,4,0);

/*Table structure for table `t_item_comment_reply` */

DROP TABLE IF EXISTS `t_item_comment_reply`;

CREATE TABLE `t_item_comment_reply` (
  `item` int(10) DEFAULT NULL,
  `comment` int(10) DEFAULT NULL,
  `reply` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_item_comment_reply` */

insert  into `t_item_comment_reply`(`item`,`comment`,`reply`) values (20,78,NULL),(NULL,78,54);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
