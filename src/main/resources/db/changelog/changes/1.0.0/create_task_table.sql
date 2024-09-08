-- CREATE DATABASE  IF NOT EXISTS `employee_directory`;
-- USE `employee_directory`;

--
-- Table structure for table `task`
--
CREATE TABLE task (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `status` tinyint(1) DEFAULT FALSE,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;