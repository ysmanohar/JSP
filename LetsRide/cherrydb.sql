drop database if exists letsride;
create database letsride;

use letsride;

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(20) DEFAULT NULL,
  `lastname` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `age` int(10) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `phone` bigint(20) DEFAULT NULL,
  `sex` varchar(6) DEFAULT NULL,
  `address` varchar(30) DEFAULT NULL,
  `city` varchar(30) DEFAULT NULL,
  `zip` bigint(20) DEFAULT NULL,
  `role` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
INSERT INTO `users` VALUES 
(4,'test','test','admin',20,'test@letsride.com',5647837463,'male','raleigh','raleigh',234567,'T'),
(7,'Sid','Shan','sid123',24,'sid2k11@hotmail.com',1234567890,'male','asdfg hjkjkl','nimapara',90909,'T'),
(8,'clark','kent','wonder',99,'clark@superman.com',704895673,'male','metropolis','metropolis',28262,'D'),
(13,'admin','admin','admin',24,'admin1@letsride.com',7049573954,'male','ut-north','Charlotte',28262,'A'),
(14,'admin','admin','admin',24,'admin2@letsride.com',7894561232,'male','ut-north','Charlotte',28262,'A');

CREATE TABLE `myrides` (
  `driverid` int(11) DEFAULT NULL,
  `travelid` int(11) DEFAULT NULL,
  `travellerid` int(11) DEFAULT NULL
) ;

CREATE TABLE `notification` (
  `travellerid` int(11) DEFAULT NULL,
  `driverid` int(11) DEFAULT NULL,
  `action` varchar(30) DEFAULT NULL,
  `travelid` int(11) DEFAULT NULL,
  `fromtable` varchar(10) DEFAULT NULL
) ;
INSERT INTO `notification` VALUES (0,1,'delete',6,'travel');
CREATE TABLE `travel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `source` varchar(30) DEFAULT NULL,
  `destination` varchar(30) DEFAULT NULL,
  `distance` bigint(10) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  `capacity` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `userid` (`userid`),
  CONSTRAINT `travel_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `users` (`id`)
);
INSERT INTO `travel` VALUES (1,'A','B',5,2,8,9,'2016-05-12'),(3,'A','D',20,2,8,9,'2016-05-12'),(4,'B','C',5,2,8,9,'2016-05-12'),(5,'B','D',15,2,8,9,'2016-05-12');
CREATE TABLE `traveltime` (
  `timeid` int(11) DEFAULT NULL,
  `travelid` int(11) DEFAULT NULL,
  `hour` int(11) DEFAULT NULL,
  `minute` int(11) DEFAULT NULL,
  KEY `travelid` (`travelid`)
);
INSERT INTO `traveltime` VALUES (2,1,6,20),(3,2,6,20),(4,3,6,20),
(5,4,6,20),(6,5,6,20),(7,6,6,20),
(3,2,6,20),(4,3,6,20),(5,4,6,20),(6,5,6,20),(7,6,6,20),(8,7,6,20),
(2,1,6,20),(3,2,6,20),(4,3,6,20),(5,4,6,20),
(6,5,6,20),(7,6,6,20),(2,1,6,20),(3,2,6,20),(4,3,6,20),(5,4,6,20),(6,5,6,20),(7,6,6,20);

Create table Doubts(
   ID int NOT NULL AUTO_INCREMENT,
   custname varchar(30),
   email  varchar(30),
   phone varchar(30),
   doubt  varchar(100),
   postdate  varchar(15),
   PRIMARY KEY (ID));
   
   Create table Sentmail(
   custname varchar(30),
   email  varchar(30),
   phone varchar(30),
   doubt  varchar(100),
   reply varchar(100));

use letsride;
select * from users; 
