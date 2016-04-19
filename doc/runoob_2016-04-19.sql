-- MySQL dump 10.13  Distrib 5.6.28, for debian-linux-gnu (x86_64)
--
-- Host: 192.168.83.132    Database: runoob
-- ------------------------------------------------------
-- Server version	5.6.28-0ubuntu0.14.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `runoob`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `runoob` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `runoob`;

--
-- Table structure for table `privilege`
--

DROP TABLE IF EXISTS `privilege`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `privilege` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT '0' COMMENT '父权限ID',
  `name` varchar(20) NOT NULL,
  `url` varchar(1024) NOT NULL,
  `remark` varchar(128) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `privilege`
--

LOCK TABLES `privilege` WRITE;
/*!40000 ALTER TABLE `privilege` DISABLE KEYS */;
INSERT INTO `privilege` VALUES (1,0,'首页','/','','2016-04-19 08:47:06'),(2,0,'用户模块','','','2016-04-19 08:47:31'),(3,2,'用户模块>查看','/user/index','','2016-04-19 08:48:02'),(4,2,'用户模块>添加','/user/insert','','2016-04-19 08:59:29'),(5,2,'用户模块>编辑','/user/update','','2016-04-19 09:00:56'),(6,2,'用户模块>删除','/user/del','','2016-04-19 09:01:34'),(7,2,'用户模块>分配角色','/user/assign','','2016-04-19 09:21:23'),(8,0,'角色模块','','','2016-04-19 08:50:01'),(9,8,'角色模块>查看','/role/index','','2016-04-19 08:50:44'),(10,8,'角色模块>添加','/role/insert','','2016-04-19 09:31:41'),(11,8,'角色模块>编辑','/role/update','','2016-04-19 09:25:21'),(12,8,'角色模块>删除','/role/del','','2016-04-19 09:25:37'),(13,8,'角色模块>分配权限','/role/assign','','2016-04-19 09:26:22'),(14,0,'权限模块','','','2016-04-19 08:51:05'),(15,14,'权限模块>查看','/privilege/index','','2016-04-19 08:54:38'),(16,14,'权限模块>添加','/privilege/insert','','2016-04-19 09:29:37'),(17,14,'权限模块>编辑','/privilege/update','','2016-04-19 09:28:09'),(18,14,'权限模块>删除','/privilege/del','','2016-04-19 09:28:27');
/*!40000 ALTER TABLE `privilege` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `remark` varchar(128) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'超级管理员','上帝般存在!!!','2016-04-19 09:46:33'),(2,'测试用户','浏览权限','2016-04-19 09:46:49');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_privilege`
--

DROP TABLE IF EXISTS `role_privilege`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role_privilege` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NOT NULL,
  `privilege_id` bigint(20) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_privilege`
--

LOCK TABLES `role_privilege` WRITE;
/*!40000 ALTER TABLE `role_privilege` DISABLE KEYS */;
INSERT INTO `role_privilege` VALUES (26,1,1,'2016-04-19 10:33:36'),(27,1,2,'2016-04-19 10:33:36'),(28,1,3,'2016-04-19 10:33:36'),(29,1,4,'2016-04-19 10:33:36'),(30,1,5,'2016-04-19 10:33:36'),(31,1,6,'2016-04-19 10:33:36'),(32,1,7,'2016-04-19 10:33:36'),(33,1,8,'2016-04-19 10:33:36'),(34,1,9,'2016-04-19 10:33:36'),(35,1,10,'2016-04-19 10:33:36'),(36,1,11,'2016-04-19 10:33:36'),(37,1,12,'2016-04-19 10:33:36'),(38,1,13,'2016-04-19 10:33:36'),(39,1,14,'2016-04-19 10:33:36'),(40,1,15,'2016-04-19 10:33:36'),(41,1,16,'2016-04-19 10:33:36'),(42,1,17,'2016-04-19 10:33:36'),(43,1,18,'2016-04-19 10:33:36'),(44,2,1,'2016-04-19 10:33:52'),(45,2,2,'2016-04-19 10:33:52'),(46,2,3,'2016-04-19 10:33:52'),(47,2,8,'2016-04-19 10:33:52'),(48,2,9,'2016-04-19 10:33:52'),(49,2,14,'2016-04-19 10:33:52'),(50,2,15,'2016-04-19 10:33:52');
/*!40000 ALTER TABLE `role_privilege` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `pwd` varchar(32) NOT NULL,
  `status` tinyint(4) DEFAULT NULL COMMENT '标识活跃度',
  `mobile` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','1c63129ae9db9c60c3e8aa94d3e00495',0,'13584674354','zhaoxiufei@gmail.com','2016-04-19 09:45:14','2016-04-19 09:45:14'),(2,'test','e10adc3949ba59abbe56e057f20f883e',0,'13584670086','test@gmail.com','2016-04-19 09:45:37','2016-04-19 09:45:37');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (3,1,1,'2016-04-19 10:33:18'),(4,2,2,'2016-04-19 10:33:23');
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-04-19 18:34:24
