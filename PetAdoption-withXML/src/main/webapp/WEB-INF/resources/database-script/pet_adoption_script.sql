DROP SCHEMA IF EXISTS `pet_adoption`;

CREATE SCHEMA `pet_adoption`;

use `pet_adoption`;


DROP TABLE IF EXISTS `owner`;

CREATE TABLE `owner` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `foster`;

CREATE TABLE `foster` (
   `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `pet`;

CREATE TABLE `pet` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `age` double DEFAULT NULL,
  `breed` varchar(45) DEFAULT NULL,
  `describe` varchar(255) DEFAULT NULL,
  `adopted` boolean DEFAULT false,
  `owner_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  
  KEY `FK_OWNER_idx` (`owner_id`),
  
  CONSTRAINT `FK_OWNER` 
  FOREIGN KEY (`owner_id`) 
  REFERENCES `owner` (`id`) 
  
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


