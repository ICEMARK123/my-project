/*
 Navicat Premium Data Transfer

 Source Server         : taiheremote
 Source Server Type    : MySQL
 Source Server Version : 50534
 Source Host           : 10.241.11.13:3306
 Source Schema         : polaris

 Target Server Type    : MySQL
 Target Server Version : 50534
 File Encoding         : 65001

 Date: 18/10/2019 15:25:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for global_setting_cfg
-- ----------------------------
DROP TABLE IF EXISTS `global_setting_cfg`;
CREATE TABLE `global_setting_cfg` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键<seq>',
  `remark` varchar(128) NOT NULL COMMENT '配置简单描述',
  `type` int(4) NOT NULL COMMENT '全局配置类型',
  `channel` varchar(32) DEFAULT NULL COMMENT '渠道',
  `version_name` varchar(50) DEFAULT NULL COMMENT '版本名称',
  `version_code` int(11) DEFAULT '0' COMMENT '版本号',
  `content` text COMMENT '具体配置内容Json格式',
  `status` varchar(2) NOT NULL DEFAULT '00' COMMENT '状态',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for revisit_record
-- ----------------------------
DROP TABLE IF EXISTS `revisit_record`;
CREATE TABLE `revisit_record` (
  `id` int(12) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `people_id` int(12) NOT NULL COMMENT '寻人id',
  `uhid` varchar(50) NOT NULL COMMENT 'UHID',
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '姓名',
  `gender` char(5) NOT NULL DEFAULT '' COMMENT '性别',
  `age` int(11) NOT NULL COMMENT '年龄',
  `revisit_record` text COMMENT '回访记录',
  `contact1` varchar(50) DEFAULT '' COMMENT '联系人1',
  `telephone1` varchar(50) DEFAULT NULL COMMENT '联系人电话1',
  `contact2` varchar(50) DEFAULT '' COMMENT '联系人2',
  `telephone2` varchar(50) DEFAULT NULL COMMENT '联系人电话2',
  `revisit_time` timestamp NULL DEFAULT NULL COMMENT '上次回访时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `status` int(1) NOT NULL DEFAULT '1' COMMENT '1待回访， 2已回访, 已停止',
  `remark` varchar(255) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `ix_uhid_name` (`uhid`,`name`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for search_people
-- ----------------------------
DROP TABLE IF EXISTS `search_people`;
CREATE TABLE `search_people` (
  `id` int(12) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `app_id` varchar(20) NOT NULL COMMENT 'app_id',
  `uhid` varchar(50) NOT NULL COMMENT 'UHID',
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '姓名',
  `display_title` varchar(100) DEFAULT '' COMMENT '展示标题',
  `gender` char(5) NOT NULL DEFAULT '' COMMENT '性别',
  `detail_address` varchar(500) DEFAULT '' COMMENT '详细地址',
  `age` int(11) NOT NULL COMMENT '年龄',
  `display_img` text COMMENT '照片',
  `lost_img` text COMMENT '照片',
  `description` text COMMENT '情况介绍',
  `lost_time` timestamp NULL DEFAULT NULL COMMENT '丢失时间',
  `lost_address` varchar(500) NOT NULL DEFAULT '' COMMENT '丢失地点',
  `lost_reason` varchar(500) DEFAULT '' COMMENT '丢失原因',
  `find_time` timestamp NULL DEFAULT NULL COMMENT '发现时间',
  `find_address` varchar(500) DEFAULT '' COMMENT '发现地点',
  `rescue_unit` varchar(50) DEFAULT '' COMMENT '救助单位',
  `identification_img` text COMMENT '走失者病例证明或残疾证明',
  `contact1` varchar(50) DEFAULT '' COMMENT '联系人1',
  `telephone1` varchar(50) DEFAULT '' COMMENT '联系人1电话',
  `contact2` varchar(50) DEFAULT '' COMMENT '联系人2',
  `telephone2` varchar(50) DEFAULT '' COMMENT '联系人2电话',
  `call_police` int(11) NOT NULL COMMENT '是否已经报警，报警1，未报警0',
  `examine_history` text COMMENT '审核历史',
  `push_time` timestamp NULL DEFAULT NULL COMMENT '推送时间',
  `push_interval` int(11) DEFAULT NULL COMMENT '推送间隔',
  `push_times` int(11) DEFAULT NULL COMMENT '最大推送次数',
  `pushed_times` int(11) DEFAULT '0' COMMENT '已推送次数',
  `status` int(11) DEFAULT '0' COMMENT '状态：等待审核0, 审核不通过1, 正在寻人2, 已停止3',
  `revisit_record` text COMMENT '回访记录',
  `stop` varchar(200) DEFAULT '' COMMENT '停止',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `search_type` int(11) NOT NULL DEFAULT '1' COMMENT '寻人1，寻亲2',
  `remark` text COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `ix_uhid_name` (`uhid`,`name`)
) ENGINE=InnoDB AUTO_INCREMENT=159 DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
