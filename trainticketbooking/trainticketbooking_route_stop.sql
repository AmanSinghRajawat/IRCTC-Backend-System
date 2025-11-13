-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: trainticketbooking
-- ------------------------------------------------------
-- Server version	8.0.36

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `route_stop`
--

DROP TABLE IF EXISTS `route_stop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `route_stop` (
  `stop_id` bigint NOT NULL AUTO_INCREMENT,
  `arrival_time` time(6) NOT NULL,
  `departure_time` time(6) NOT NULL,
  `distance_from_origin` int NOT NULL,
  `halt_duration` int NOT NULL,
  `sequence_number` int NOT NULL,
  `station_id` bigint NOT NULL,
  `route_id` bigint NOT NULL,
  PRIMARY KEY (`stop_id`),
  KEY `FKcbwg6oncsc4teg59fompqdix9` (`station_id`),
  KEY `FKrah0j8khs716aqhsqt3x5yxbw` (`route_id`),
  CONSTRAINT `FKcbwg6oncsc4teg59fompqdix9` FOREIGN KEY (`station_id`) REFERENCES `station` (`station_id`),
  CONSTRAINT `FKrah0j8khs716aqhsqt3x5yxbw` FOREIGN KEY (`route_id`) REFERENCES `route` (`route_id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `route_stop`
--

LOCK TABLES `route_stop` WRITE;
/*!40000 ALTER TABLE `route_stop` DISABLE KEYS */;
INSERT INTO `route_stop` VALUES (1,'06:00:00.000000','06:10:00.000000',0,10,1,6,101),(2,'08:00:00.000000','08:10:00.000000',80,10,2,9,101),(3,'10:00:00.000000','10:10:00.000000',160,10,3,1,101),(4,'10:00:00.000000','10:10:00.000000',80,10,5,12,114),(5,'12:00:00.000000','12:10:00.000000',80,10,5,4,114),(6,'10:00:00.000000','10:10:00.000000',0,50,1,14,119),(15,'12:00:00.000000','12:10:00.000000',200,10,3,7,119),(20,'14:00:00.000000','14:10:00.000000',315,10,4,4,119),(21,'14:00:00.000000','14:10:00.000000',315,10,2,6,119),(23,'14:00:00.000000','14:30:00.000000',0,30,1,6,103),(24,'18:00:00.000000','18:30:00.000000',100,10,3,7,103),(25,'16:00:00.000000','16:10:00.000000',50,10,2,11,103),(26,'21:00:00.000000','21:30:00.000000',230,30,4,4,103),(27,'08:00:00.000000','08:10:00.000000',0,10,1,15,118),(28,'12:00:00.000000','12:10:00.000000',500,10,2,7,118),(29,'14:00:00.000000','14:10:00.000000',650,10,3,4,118),(30,'15:00:00.000000','15:10:00.000000',700,10,4,9,118),(31,'17:00:00.000000','17:10:00.000000',900,10,5,10,118);
/*!40000 ALTER TABLE `route_stop` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-11-13 18:59:29
