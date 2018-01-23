-- create a cycle_tracking_data --

DROP SCHEMA IF EXISTS `cycle_tracking_system`;

CREATE SCHEMA `cycle_tracking_system`;

USE `cycle_tracking_system`;

SET FOREIGN_KEY_CHECKS = 0;

-- create the tables. --

-- 1. table --> cycle_stand_table

DROP TABLE IF EXISTS `stand`;
CREATE TABLE `stand` (

  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(245) DEFAULT NULL,
  `formatted_address` varchar(245) DEFAULT NULL,
  `lat` point DEFAULT NULL,
  `lng` point DEFAULT NULL,
	
   PRIMARY KEY (`id`)
   
) ENGINE=InnoDB /*AUTO_INCREMENT=6*/ DEFAULT CHARSET=latin1;


-- 2. table --> cycle_table

DROP TABLE IF EXISTS `cycle`;
CREATE TABLE `cycle` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(245) DEFAULT NULL,
  `Number` int(110) DEFAULT NULL,
  `Name` varchar(245) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
  
) ENGINE=InnoDB /*AUTO_INCREMENT=6*/ DEFAULT CHARSET=latin1;

-- 3. table -> create a relational table which holds the many to many mapping between
-- cycle and stand --

DROP TABLE IF EXISTS `cycle_stand`;
CREATE TABLE `cycle_stand` (
  `stand_id` int NOT NULL,
  `cycle_id` int NOT NULL,
  
  PRIMARY KEY (`stand_id`,`cycle_id`),
  
   KEY `FK_CYCLE_idx` (`cycle_id`),
  
  CONSTRAINT `FK_STAND` FOREIGN KEY (`stand_id`) 
  REFERENCES `stand` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  
  CONSTRAINT `FK_CYCLE` FOREIGN KEY (`cycle_id`) 
  REFERENCES `cycle` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
  
) ENGINE=InnoDB /*AUTO_INCREMENT=6*/ DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
 
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(245) DEFAULT NULL,
  `mobile` int(12) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `formattedAddress` varchar(245) DEFAULT NULL,
  `lat` point DEFAULT NULL,
  `lng` point DEFAULT NULL,
  `created` timestamp,
  `updated` timestamp,
  
  PRIMARY KEY (`id`)
  
) ENGINE=InnoDB /*AUTO_INCREMENT=6*/ DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `user_track`;
CREATE TABLE `user_track` (
 
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `formattedAddress` varchar(245) DEFAULT NULL,
  `lat` point DEFAULT NULL,
  `lng` point DEFAULT NULL,
  `start_time` timestamp,
  `end_time` timestamp,
  
  PRIMARY KEY (`user_id`),
  
  CONSTRAINT `FK_USER_ID` FOREIGN KEY (`user_id`) 
  REFERENCES `user` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
  
) ENGINE=InnoDB /*AUTO_INCREMENT=6*/ DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `booking_track`;
CREATE TABLE `booking_track` (
 
  `booking_id` int(11) NOT NULL AUTO_INCREMENT,
  `booking_time` time,
  `booking_date` timestamp,
  `user_id`  int default null,
  `cycle_id` int default null,
  `stand_id` int default null,
  
  PRIMARY KEY (`booking_id`),
  
  CONSTRAINT `FK_USER_IDx` FOREIGN KEY (`user_id`) 
  REFERENCES `user` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  
  
  CONSTRAINT `FK_CYCLE_ID` FOREIGN KEY (`cycle_id`) 
  REFERENCES `cycle` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,

  CONSTRAINT `FK_STAND_ID` FOREIGN KEY (`stand_id`) 
  REFERENCES `stand` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
  
  
) ENGINE=InnoDB /*AUTO_INCREMENT=6*/ DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;







