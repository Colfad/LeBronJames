/*
Source Server         : localhost
Source Server Version : 50534
Source Host           : localhost:3306
Source Database       : locus

Target Server Type    : MYSQL
Target Server Version : 50534
File Encoding         : 65001

Date: 2013-12-10 11:16:42
*/

-- ----------------------------
-- Create Database locus
-- ----------------------------

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for xz_artery
-- ----------------------------
DROP TABLE IF EXISTS `xz_artery`;
CREATE TABLE `xz_artery` (
  `id` varchar(255) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `bloodFat` tinyint(1) NOT NULL,
  `drink` tinyint(1) NOT NULL,
  `familyHistory` tinyint(1) NOT NULL,
  `glycuresis` tinyint(1) NOT NULL,
  `heartDisease` tinyint(1) NOT NULL,
  `highBloodPressure` tinyint(1) NOT NULL,
  `patientAddress` varchar(255) DEFAULT NULL,
  `patientAge` varchar(255) DEFAULT NULL,
  `patientMobile` varchar(255) DEFAULT NULL,
  `patientName` varchar(255) DEFAULT NULL,
  `patientNumber` varchar(255) DEFAULT NULL,
  `patientSex` tinyint(1) NOT NULL,
  `smoking` tinyint(1) NOT NULL,
  `arteryClinic_id` varchar(255) DEFAULT NULL,
  `arteryCoil_id` varchar(255) DEFAULT NULL,
  `arteryDescrib_id` varchar(255) DEFAULT NULL,
  `arteryTreat_id` varchar(255) DEFAULT NULL,
  `arteryVisit_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4ED63806762BFAB9` (`arteryClinic_id`),
  KEY `FK4ED638063D311BFB` (`arteryVisit_id`),
  KEY `FK4ED638062F0FB919` (`arteryCoil_id`),
  KEY `FK4ED6380637D2B95B` (`arteryDescrib_id`),
  KEY `FK4ED638063119F59B` (`arteryTreat_id`),
  CONSTRAINT `FK4ED638063119F59B` FOREIGN KEY (`arteryTreat_id`) REFERENCES `xz_artery_treat` (`id`),
  CONSTRAINT `FK4ED638062F0FB919` FOREIGN KEY (`arteryCoil_id`) REFERENCES `xz_artery_coil` (`id`),
  CONSTRAINT `FK4ED6380637D2B95B` FOREIGN KEY (`arteryDescrib_id`) REFERENCES `xz_artery_describ` (`id`),
  CONSTRAINT `FK4ED638063D311BFB` FOREIGN KEY (`arteryVisit_id`) REFERENCES `xz_artery_visit` (`id`),
  CONSTRAINT `FK4ED63806762BFAB9` FOREIGN KEY (`arteryClinic_id`) REFERENCES `xz_artery_clinic` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for xz_artery_clinic
-- ----------------------------
DROP TABLE IF EXISTS `xz_artery_clinic`;
CREATE TABLE `xz_artery_clinic` (
  `id` varchar(255) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `blood` tinyint(1) NOT NULL,
  `bloodPressure` varchar(255) DEFAULT NULL,
  `bloodTimes` varchar(255) DEFAULT NULL,
  `firstSign` varchar(255) DEFAULT NULL,
  `fisherLevel` varchar(255) DEFAULT NULL,
  `gcs` varchar(255) DEFAULT NULL,
  `huntHessLevel` varchar(255) DEFAULT NULL,
  `mrs` varchar(255) DEFAULT NULL,
  `nihss` varchar(255) DEFAULT NULL,
  `toCTTime` varchar(255) DEFAULT NULL,
  `toShTime` varchar(255) DEFAULT NULL,
  `wfns` varchar(255) DEFAULT NULL,
  `wpCheckout` varchar(255) DEFAULT NULL,
  `parent_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7604E741CA9B16B8` (`parent_id`),
  CONSTRAINT `FK7604E741CA9B16B8` FOREIGN KEY (`parent_id`) REFERENCES `xz_artery` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for xz_artery_coil
-- ----------------------------
DROP TABLE IF EXISTS `xz_artery_coil`;
CREATE TABLE `xz_artery_coil` (
  `id` varchar(255) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `bi` varchar(255) DEFAULT NULL,
  `engTotalLength` varchar(255) DEFAULT NULL,
  `length` varchar(255) DEFAULT NULL,
  `number` varchar(255) DEFAULT NULL,
  `tenTotalLength` varchar(255) DEFAULT NULL,
  `tweTotalLength` varchar(255) DEFAULT NULL,
  `parent_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK25F34328CA9B16B8` (`parent_id`),
  CONSTRAINT `FK25F34328CA9B16B8` FOREIGN KEY (`parent_id`) REFERENCES `xz_artery` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for xz_artery_describ
-- ----------------------------
DROP TABLE IF EXISTS `xz_artery_describ`;
CREATE TABLE `xz_artery_describ` (
  `id` varchar(255) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `blood` varchar(255) DEFAULT NULL,
  `height` varchar(255) DEFAULT NULL,
  `length` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `lr` varchar(255) DEFAULT NULL,
  `num` varchar(255) DEFAULT NULL,
  `parentA` varchar(255) DEFAULT NULL,
  `ratioDome` varchar(255) DEFAULT NULL,
  `ratioNeck` varchar(255) DEFAULT NULL,
  `shape` varchar(255) DEFAULT NULL,
  `volume` varchar(255) DEFAULT NULL,
  `width` varchar(255) DEFAULT NULL,
  `parent_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK74145DA1CA9B16B8` (`parent_id`),
  CONSTRAINT `FK74145DA1CA9B16B8` FOREIGN KEY (`parent_id`) REFERENCES `xz_artery` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for xz_artery_treat
-- ----------------------------
DROP TABLE IF EXISTS `xz_artery_treat`;
CREATE TABLE `xz_artery_treat` (
  `id` varchar(255) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `auxiliary` varchar(255) DEFAULT NULL,
  `checkInTime` varchar(255) DEFAULT NULL,
  `checkOutTime` varchar(255) DEFAULT NULL,
  `complication` varchar(255) DEFAULT NULL,
  `guidewire` varchar(255) DEFAULT NULL,
  `guiding` varchar(255) DEFAULT NULL,
  `memo` varchar(255) DEFAULT NULL,
  `microcatheter` varchar(255) DEFAULT NULL,
  `stent` varchar(255) DEFAULT NULL,
  `technicalSuccess` tinyint(1) NOT NULL,
  `toShTime` varchar(255) DEFAULT NULL,
  `parent_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9965FEA1CA9B16B8` (`parent_id`),
  CONSTRAINT `FK9965FEA1CA9B16B8` FOREIGN KEY (`parent_id`) REFERENCES `xz_artery` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for xz_artery_visit
-- ----------------------------
DROP TABLE IF EXISTS `xz_artery_visit`;
CREATE TABLE `xz_artery_visit` (
  `id` varchar(255) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `again` tinyint(1) NOT NULL,
  `sixHIHSS` varchar(255) DEFAULT NULL,
  `sixMRS` varchar(255) DEFAULT NULL,
  `threeGOS` varchar(255) DEFAULT NULL,
  `threeHIHSS` varchar(255) DEFAULT NULL,
  `threeMRS` varchar(255) DEFAULT NULL,
  `treatAgain` varchar(255) DEFAULT NULL,
  `visitDate` varchar(255) DEFAULT NULL,
  `parent_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK997E4BD2CA9B16B8` (`parent_id`),
  CONSTRAINT `FK997E4BD2CA9B16B8` FOREIGN KEY (`parent_id`) REFERENCES `xz_artery` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for xz_baseinfo
-- ----------------------------
DROP TABLE IF EXISTS `xz_baseinfo`;
CREATE TABLE `xz_baseinfo` (
  `id` varchar(255) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `biliaryStenosis` varchar(255) DEFAULT NULL,
  `ceReport` varchar(255) DEFAULT NULL,
  `ctDate` varchar(255) DEFAULT NULL,
  `mcrpDate` varchar(255) DEFAULT NULL,
  `mrDate` varchar(255) DEFAULT NULL,
  `mrReport` varchar(255) DEFAULT NULL,
  `mrcpReport` varchar(255) DEFAULT NULL,
  `patientId` varchar(255) DEFAULT NULL,
  `patientName` varchar(255) DEFAULT NULL,
  `rumorHeight` varchar(255) DEFAULT NULL,
  `rumorLength` varchar(255) DEFAULT NULL,
  `rumorWidth` varchar(255) DEFAULT NULL,
  `tumorKind` varchar(255) DEFAULT NULL,
  `tumorLocation` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for xz_column
-- ----------------------------
DROP TABLE IF EXISTS `xz_column`;
CREATE TABLE `xz_column` (
  `id` varchar(255) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `columnLength` varchar(255) DEFAULT NULL,
  `columnName` varchar(255) DEFAULT NULL,
  `columnType` varchar(255) DEFAULT NULL,
  `gridShow` tinyint(1) DEFAULT NULL,
  `showName` varchar(255) DEFAULT NULL,
  `table_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK52123B33FD909E1E` (`table_id`),
  CONSTRAINT `FK52123B33FD909E1E` FOREIGN KEY (`table_id`) REFERENCES `xz_table` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for xz_file_repository
-- ----------------------------
DROP TABLE IF EXISTS `xz_file_repository`;
CREATE TABLE `xz_file_repository` (
  `id` varchar(255) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `fileName` varchar(255) DEFAULT NULL,
  `mimeTypeExtensionName` varchar(255) DEFAULT NULL,
  `mimeTypeName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for xz_hepatoma_biological
-- ----------------------------
DROP TABLE IF EXISTS `xz_hepatoma_biological`;
CREATE TABLE `xz_hepatoma_biological` (
  `id` varchar(255) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `akp` varchar(255) DEFAULT NULL,
  `alb` varchar(255) DEFAULT NULL,
  `ast` varchar(255) DEFAULT NULL,
  `bun` varchar(255) DEFAULT NULL,
  `ca` varchar(255) DEFAULT NULL,
  `checkTime` varchar(255) DEFAULT NULL,
  `chlorine` varchar(255) DEFAULT NULL,
  `ci` varchar(255) DEFAULT NULL,
  `dbil` varchar(255) DEFAULT NULL,
  `globin` varchar(255) DEFAULT NULL,
  `glucose` varchar(255) DEFAULT NULL,
  `gpt` varchar(255) DEFAULT NULL,
  `indirectBilirubin` varchar(255) DEFAULT NULL,
  `na` varchar(255) DEFAULT NULL,
  `potassium` varchar(255) DEFAULT NULL,
  `tbil` varchar(255) DEFAULT NULL,
  `tc` varchar(255) DEFAULT NULL,
  `tg` varchar(255) DEFAULT NULL,
  `yast` varchar(255) DEFAULT NULL,
  `parent_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for xz_hepatoma_blood
-- ----------------------------
DROP TABLE IF EXISTS `xz_hepatoma_blood`;
CREATE TABLE `xz_hepatoma_blood` (
  `id` varchar(255) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `checkTime` varchar(255) DEFAULT NULL,
  `cultureBacteriaResult` varchar(255) DEFAULT NULL,
  `hemoculture` tinyint(1) NOT NULL,
  `hemoglobin` varchar(255) DEFAULT NULL,
  `lymphocyte` varchar(255) DEFAULT NULL,
  `neurtropil` varchar(255) DEFAULT NULL,
  `platelet` varchar(255) DEFAULT NULL,
  `whiteBloodCell` varchar(255) DEFAULT NULL,
  `parent_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for xz_hepatoma_hepatitis
-- ----------------------------
DROP TABLE IF EXISTS `xz_hepatoma_hepatitis`;
CREATE TABLE `xz_hepatoma_hepatitis` (
  `id` varchar(255) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `checkTime` varchar(255) DEFAULT NULL,
  `hbcab` varchar(255) DEFAULT NULL,
  `hbsab` varchar(255) DEFAULT NULL,
  `hbsag` varchar(255) DEFAULT NULL,
  `hcvab` varchar(255) DEFAULT NULL,
  `parent_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for xz_hepatoma_pic
-- ----------------------------
DROP TABLE IF EXISTS `xz_hepatoma_pic`;
CREATE TABLE `xz_hepatoma_pic` (
  `id` varchar(255) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `amount` varchar(255) DEFAULT NULL,
  `ctReport` varchar(255) DEFAULT NULL,
  `ctTime` varchar(255) DEFAULT NULL,
  `dgkz` tinyint(1) NOT NULL,
  `dgqf` tinyint(1) NOT NULL,
  `ectReport` varchar(255) DEFAULT NULL,
  `ectTime` varchar(255) DEFAULT NULL,
  `fs` varchar(255) DEFAULT NULL,
  `gdm` tinyint(1) NOT NULL,
  `gdmDetail` varchar(255) DEFAULT NULL,
  `gjm` tinyint(1) NOT NULL,
  `gjmDetail` varchar(255) DEFAULT NULL,
  `gjml` tinyint(1) NOT NULL,
  `gjmlDetail` varchar(255) DEFAULT NULL,
  `gzy` tinyint(1) NOT NULL,
  `gzyDetail` varchar(255) DEFAULT NULL,
  `lType` varchar(255) DEFAULT NULL,
  `lbjzy` tinyint(1) NOT NULL,
  `lbjzyDetail` varchar(255) DEFAULT NULL,
  `liver` tinyint(1) NOT NULL,
  `mjm` tinyint(1) NOT NULL,
  `mjmDetail` varchar(255) DEFAULT NULL,
  `mrReport` varchar(255) DEFAULT NULL,
  `mrTime` varchar(255) DEFAULT NULL,
  `one` varchar(255) DEFAULT NULL,
  `pd` tinyint(1) NOT NULL,
  `petctReport` varchar(255) DEFAULT NULL,
  `petctTime` varchar(255) DEFAULT NULL,
  `sgwqz` tinyint(1) NOT NULL,
  `sqm` tinyint(1) NOT NULL,
  `sqmDetail` varchar(255) DEFAULT NULL,
  `ssxzy` tinyint(1) NOT NULL,
  `ssxzyDetail` varchar(255) DEFAULT NULL,
  `three` varchar(255) DEFAULT NULL,
  `two` varchar(255) DEFAULT NULL,
  `xs` varchar(255) DEFAULT NULL,
  `parent_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for xz_hepatoma_tumor
-- ----------------------------
DROP TABLE IF EXISTS `xz_hepatoma_tumor`;
CREATE TABLE `xz_hepatoma_tumor` (
  `id` varchar(255) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `afp` varchar(255) DEFAULT NULL,
  `ca` varchar(255) DEFAULT NULL,
  `cea` varchar(255) DEFAULT NULL,
  `checkTime` varchar(255) DEFAULT NULL,
  `parent_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for xz_hepatoma_visit
-- ----------------------------
DROP TABLE IF EXISTS `xz_hepatoma_visit`;
CREATE TABLE `xz_hepatoma_visit` (
  `id` varchar(255) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `again` tinyint(1) NOT NULL,
  `sixHIHSS` varchar(255) DEFAULT NULL,
  `sixMRS` varchar(255) DEFAULT NULL,
  `threeGOS` varchar(255) DEFAULT NULL,
  `threeHIHSS` varchar(255) DEFAULT NULL,
  `threeMRS` varchar(255) DEFAULT NULL,
  `treatAgain` varchar(255) DEFAULT NULL,
  `visitDate` varchar(255) DEFAULT NULL,
  `parent_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for xz_icterus
-- ----------------------------
DROP TABLE IF EXISTS `xz_icterus`;
CREATE TABLE `xz_icterus` (
  `id` varchar(255) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `bloodFat` tinyint(1) NOT NULL,
  `drink` tinyint(1) NOT NULL,
  `familyHistory` tinyint(1) NOT NULL,
  `glycuresis` tinyint(1) NOT NULL,
  `heartDisease` tinyint(1) NOT NULL,
  `highBloodPressure` tinyint(1) NOT NULL,
  `patientAddress` varchar(255) DEFAULT NULL,
  `patientAge` varchar(255) DEFAULT NULL,
  `patientMobile` varchar(255) DEFAULT NULL,
  `patientName` varchar(255) DEFAULT NULL,
  `patientNumber` varchar(255) DEFAULT NULL,
  `patientSex` tinyint(1) NOT NULL,
  `smoking` tinyint(1) NOT NULL,
  `cType` varchar(255) DEFAULT NULL,
  `checkInTime` varchar(255) DEFAULT NULL,
  `ecog` varchar(255) DEFAULT NULL,
  `height` varchar(255) DEFAULT NULL,
  `operateAvidence` varchar(255) DEFAULT NULL,
  `operateCheck` varchar(255) DEFAULT NULL,
  `operateInfo` varchar(255) DEFAULT NULL,
  `otherOperateInfo` varchar(255) DEFAULT NULL,
  `painScore` varchar(255) DEFAULT NULL,
  `searchDept` varchar(255) DEFAULT NULL,
  `treatGroup` varchar(255) DEFAULT NULL,
  `weight` varchar(255) DEFAULT NULL,
  `zCode` varchar(255) DEFAULT NULL,
  `icterusOperate_id` varchar(255) DEFAULT NULL,
  `icterusPic_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1989F168D27505B9` (`icterusPic_id`),
  KEY `FK1989F16881CF13F9` (`icterusOperate_id`),
  CONSTRAINT `FK1989F16881CF13F9` FOREIGN KEY (`icterusOperate_id`) REFERENCES `xz_icterus_operate` (`id`),
  CONSTRAINT `FK1989F168D27505B9` FOREIGN KEY (`icterusPic_id`) REFERENCES `xz_icterus_pic` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for xz_icterus_biological
-- ----------------------------
DROP TABLE IF EXISTS `xz_icterus_biological`;
CREATE TABLE `xz_icterus_biological` (
  `id` varchar(255) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `akp` varchar(255) DEFAULT NULL,
  `alb` varchar(255) DEFAULT NULL,
  `ast` varchar(255) DEFAULT NULL,
  `bun` varchar(255) DEFAULT NULL,
  `ca` varchar(255) DEFAULT NULL,
  `checkTime` varchar(255) DEFAULT NULL,
  `chlorine` varchar(255) DEFAULT NULL,
  `ci` varchar(255) DEFAULT NULL,
  `dbil` varchar(255) DEFAULT NULL,
  `globin` varchar(255) DEFAULT NULL,
  `glucose` varchar(255) DEFAULT NULL,
  `gpt` varchar(255) DEFAULT NULL,
  `indirectBilirubin` varchar(255) DEFAULT NULL,
  `na` varchar(255) DEFAULT NULL,
  `potassium` varchar(255) DEFAULT NULL,
  `tbil` varchar(255) DEFAULT NULL,
  `tc` varchar(255) DEFAULT NULL,
  `tg` varchar(255) DEFAULT NULL,
  `yast` varchar(255) DEFAULT NULL,
  `parent_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKD7C7D938A0583096` (`parent_id`),
  CONSTRAINT `FKD7C7D938A0583096` FOREIGN KEY (`parent_id`) REFERENCES `xz_icterus` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for xz_icterus_blood
-- ----------------------------
DROP TABLE IF EXISTS `xz_icterus_blood`;
CREATE TABLE `xz_icterus_blood` (
  `id` varchar(255) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `checkTime` varchar(255) DEFAULT NULL,
  `cultureBacteriaResult` varchar(255) DEFAULT NULL,
  `hemoculture` tinyint(1) NOT NULL,
  `hemoglobin` varchar(255) DEFAULT NULL,
  `lymphocyte` varchar(255) DEFAULT NULL,
  `neurtropil` varchar(255) DEFAULT NULL,
  `platelet` varchar(255) DEFAULT NULL,
  `whiteBloodCell` varchar(255) DEFAULT NULL,
  `parent_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKF1CD6C63A0583096` (`parent_id`),
  CONSTRAINT `FKF1CD6C63A0583096` FOREIGN KEY (`parent_id`) REFERENCES `xz_icterus` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for xz_icterus_immune
-- ----------------------------
DROP TABLE IF EXISTS `xz_icterus_immune`;
CREATE TABLE `xz_icterus_immune` (
  `id` varchar(255) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `cFour` varchar(255) DEFAULT NULL,
  `cThree` varchar(255) DEFAULT NULL,
  `checkTime` varchar(255) DEFAULT NULL,
  `iga` varchar(255) DEFAULT NULL,
  `igg` varchar(255) DEFAULT NULL,
  `igm` varchar(255) DEFAULT NULL,
  `parent_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK53DF533AA0583096` (`parent_id`),
  CONSTRAINT `FK53DF533AA0583096` FOREIGN KEY (`parent_id`) REFERENCES `xz_icterus` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for xz_icterus_operate
-- ----------------------------
DROP TABLE IF EXISTS `xz_icterus_operate`;
CREATE TABLE `xz_icterus_operate` (
  `id` varchar(255) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `checkOutTime` varchar(255) DEFAULT NULL,
  `complication` tinyint(1) NOT NULL,
  `complicationDetail` varchar(255) DEFAULT NULL,
  `complicationResult` varchar(255) DEFAULT NULL,
  `dSize` varchar(255) DEFAULT NULL,
  `dTotal` varchar(255) DEFAULT NULL,
  `dType` varchar(255) DEFAULT NULL,
  `infectBeforeOperate` tinyint(1) NOT NULL,
  `numberOfD` varchar(255) DEFAULT NULL,
  `numberOfDrain` varchar(255) DEFAULT NULL,
  `numberOfStrut` varchar(255) DEFAULT NULL,
  `operateReason` varchar(255) DEFAULT NULL,
  `operateReport` varchar(255) DEFAULT NULL,
  `operateSuccess` tinyint(1) NOT NULL,
  `operateTime` varchar(255) DEFAULT NULL,
  `operator` varchar(255) DEFAULT NULL,
  `piceceOfD` varchar(255) DEFAULT NULL,
  `site` varchar(255) DEFAULT NULL,
  `strutSize` varchar(255) DEFAULT NULL,
  `strutType` varchar(255) DEFAULT NULL,
  `takeOver` tinyint(1) NOT NULL,
  `takeOverTime` varchar(255) DEFAULT NULL,
  `width` varchar(255) DEFAULT NULL,
  `parent_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6A1CB9ADA0583096` (`parent_id`),
  CONSTRAINT `FK6A1CB9ADA0583096` FOREIGN KEY (`parent_id`) REFERENCES `xz_icterus` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for xz_icterus_pic
-- ----------------------------
DROP TABLE IF EXISTS `xz_icterus_pic`;
CREATE TABLE `xz_icterus_pic` (
  `id` varchar(255) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `ctReport` varchar(255) DEFAULT NULL,
  `ctTime` varchar(255) DEFAULT NULL,
  `cuLength` varchar(255) DEFAULT NULL,
  `ectReport` varchar(255) DEFAULT NULL,
  `height` varchar(255) DEFAULT NULL,
  `iMount` varchar(255) DEFAULT NULL,
  `iMove` tinyint(1) NOT NULL,
  `iNumber` varchar(255) DEFAULT NULL,
  `length` varchar(255) DEFAULT NULL,
  `mrReport` varchar(255) DEFAULT NULL,
  `mrTime` varchar(255) DEFAULT NULL,
  `mrcpReport` varchar(255) DEFAULT NULL,
  `mrcpTime` varchar(255) DEFAULT NULL,
  `petctReport` varchar(255) DEFAULT NULL,
  `petctTime` varchar(255) DEFAULT NULL,
  `site` varchar(255) DEFAULT NULL,
  `strut` varchar(255) DEFAULT NULL,
  `strutMove` tinyint(1) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  `width` varchar(255) DEFAULT NULL,
  `parent_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK770FDE33A0583096` (`parent_id`),
  CONSTRAINT `FK770FDE33A0583096` FOREIGN KEY (`parent_id`) REFERENCES `xz_icterus` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for xz_icterus_tumor
-- ----------------------------
DROP TABLE IF EXISTS `xz_icterus_tumor`;
CREATE TABLE `xz_icterus_tumor` (
  `id` varchar(255) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `afp` varchar(255) DEFAULT NULL,
  `ca` varchar(255) DEFAULT NULL,
  `cea` varchar(255) DEFAULT NULL,
  `checkTime` varchar(255) DEFAULT NULL,
  `parent_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKF2CF2358A0583096` (`parent_id`),
  CONSTRAINT `FKF2CF2358A0583096` FOREIGN KEY (`parent_id`) REFERENCES `xz_icterus` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for xz_icterus_visit
-- ----------------------------
DROP TABLE IF EXISTS `xz_icterus_visit`;
CREATE TABLE `xz_icterus_visit` (
  `id` varchar(255) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `bodyScore` varchar(255) DEFAULT NULL,
  `loseVisit` varchar(255) DEFAULT NULL,
  `loseVisitTime` varchar(255) DEFAULT NULL,
  `otherQuestion` varchar(255) DEFAULT NULL,
  `painScore` varchar(255) DEFAULT NULL,
  `sickAgain` varchar(255) DEFAULT NULL,
  `sickAgainTime` varchar(255) DEFAULT NULL,
  `treatAgain` varchar(255) DEFAULT NULL,
  `visitResult` varchar(255) DEFAULT NULL,
  `visitTime` varchar(255) DEFAULT NULL,
  `visitor` varchar(255) DEFAULT NULL,
  `parent_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKF2E5F3B4A0583096` (`parent_id`),
  CONSTRAINT `FKF2E5F3B4A0583096` FOREIGN KEY (`parent_id`) REFERENCES `xz_icterus` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for xz_mime_type
-- ----------------------------
DROP TABLE IF EXISTS `xz_mime_type`;
CREATE TABLE `xz_mime_type` (
  `MT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `MT_NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`MT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for xz_mime_type_extension
-- ----------------------------
DROP TABLE IF EXISTS `xz_mime_type_extension`;
CREATE TABLE `xz_mime_type_extension` (
  `MTE_ID` int(11) DEFAULT NULL,
  `MTE_NAME` varchar(255) NOT NULL,
  PRIMARY KEY (`MTE_NAME`),
  KEY `FK986F4828ABB4CE9` (`MTE_ID`),
  CONSTRAINT `FK986F4828ABB4CE9` FOREIGN KEY (`MTE_ID`) REFERENCES `xz_mime_type` (`MT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for xz_role
-- ----------------------------
DROP TABLE IF EXISTS `xz_role`;
CREATE TABLE `xz_role` (
  `id` varchar(255) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `permissions` varchar(5000) DEFAULT NULL,
  `roleName` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for xz_table
-- ----------------------------
DROP TABLE IF EXISTS `xz_table`;
CREATE TABLE `xz_table` (
  `id` varchar(255) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `tableName` varchar(255) DEFAULT NULL,
  `useFor` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for xz_team
-- ----------------------------
DROP TABLE IF EXISTS `xz_team`;
CREATE TABLE `xz_team` (
  `id` varchar(255) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `teamName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for xz_team_role
-- ----------------------------
DROP TABLE IF EXISTS `xz_team_role`;
CREATE TABLE `xz_team_role` (
  `team_id` varchar(255) NOT NULL,
  `role_id` varchar(255) NOT NULL,
  KEY `FK2D09981B8E567AA6` (`role_id`),
  KEY `FK2D09981BE67BDD46` (`team_id`),
  CONSTRAINT `FK2D09981BE67BDD46` FOREIGN KEY (`team_id`) REFERENCES `xz_team` (`id`),
  CONSTRAINT `FK2D09981B8E567AA6` FOREIGN KEY (`role_id`) REFERENCES `xz_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for xz_user
-- ----------------------------
DROP TABLE IF EXISTS `xz_user`;
CREATE TABLE `xz_user` (
  `id` varchar(255) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `user_address` varchar(255) DEFAULT NULL,
  `user_email` varchar(255) DEFAULT NULL,
  `user_mobile` varchar(255) DEFAULT NULL,
  `user_password` varchar(255) DEFAULT NULL,
  `realName` varchar(255) DEFAULT NULL,
  `salt` varchar(100) DEFAULT NULL,
  `user_status` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `user_pic` varchar(255) DEFAULT NULL,
  `team_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKA18CA6E8E67BDD46` (`team_id`),
  CONSTRAINT `FKA18CA6E8E67BDD46` FOREIGN KEY (`team_id`) REFERENCES `xz_team` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for xz_user_role
-- ----------------------------
DROP TABLE IF EXISTS `xz_user_role`;
CREATE TABLE `xz_user_role` (
  `user_id` varchar(255) NOT NULL,
  `role_id` varchar(255) NOT NULL,
  KEY `FK4BBFA36D8E567AA6` (`role_id`),
  KEY `FK4BBFA36D33813E86` (`user_id`),
  CONSTRAINT `FK4BBFA36D33813E86` FOREIGN KEY (`user_id`) REFERENCES `xz_user` (`id`),
  CONSTRAINT `FK4BBFA36D8E567AA6` FOREIGN KEY (`role_id`) REFERENCES `xz_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
