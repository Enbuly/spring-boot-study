/*
Navicat MySQL Data Transfer

Source Server         : my sql
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : spring-boot-example

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2018-12-29 12:08:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `course` varchar(255) DEFAULT NULL,
  `score` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES ('1', 'one', 'math', '66');
INSERT INTO `score` VALUES ('2', 'one', 'english', '90');
INSERT INTO `score` VALUES ('3', 'two', 'math', '44');
INSERT INTO `score` VALUES ('4', 'two', 'english', '99');
INSERT INTO `score` VALUES ('5', 'three', 'math', '66');
INSERT INTO `score` VALUES ('6', 'three', 'english', '88');
INSERT INTO `score` VALUES ('7', 'three', 'yuwen', '77');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb4 NOT NULL DEFAULT '',
  `salary` decimal(10,0) NOT NULL,
  `status` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `phone` varchar(15) CHARACTER SET utf8mb4 NOT NULL DEFAULT '',
  `password` varchar(50) CHARACTER SET utf8mb4 NOT NULL DEFAULT '',
  `role_id` tinyint(3) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'zzy', '28000', '0', '15602227266', '120157', '1');
INSERT INTO `user` VALUES ('2', 'zzx', '15000', '0', '13714802768', '120157', '2');
INSERT INTO `user` VALUES ('3', 'zyl', '70000', '0', '18927837656', '120157', '2');
INSERT INTO `user` VALUES ('8', 'zzq', '25000', '0', '17826765739', '120157', '2');
INSERT INTO `user` VALUES ('9', 'zxq', '24000', '0', '13714802788', '120157', '2');
INSERT INTO `user` VALUES ('11', 'jason', '32000', '0', '13714802788', '120157', '2');
INSERT INTO `user` VALUES ('12', 'czy', '22000', '0', '15602228767', '120157', '2');
INSERT INTO `user` VALUES ('14', 'zzyyy', '2000', '0', '16777777777', '120157', '2');
INSERT INTO `user` VALUES ('15', 'zzzzz', '2000', '0', '18888888888', '120157', '2');
