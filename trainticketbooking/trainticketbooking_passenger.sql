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
-- Table structure for table `passenger`
--

DROP TABLE IF EXISTS `passenger`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `passenger` (
  `passenger_id` bigint NOT NULL AUTO_INCREMENT,
  `age` int NOT NULL,
  `booking_status` enum('CANCELLED','CONFIRMED','RAC','WAITING_LIST') DEFAULT NULL,
  `coach_type` enum('AC_2_TIER','AC_3_TIER','FIRST_CLASS','GENERAL','LADIES','SLEEPER') NOT NULL,
  `gender` varchar(255) NOT NULL,
  `id_proof` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `seat_number` varchar(255) DEFAULT NULL,
  `coach_id` bigint DEFAULT NULL,
  `ticket_id` bigint DEFAULT NULL,
  PRIMARY KEY (`passenger_id`),
  KEY `FKjawy9pk2m3k575bfqebs7lg5n` (`coach_id`),
  KEY `FKos3sguiasei5a6ysi44ovwou2` (`ticket_id`),
  CONSTRAINT `FKjawy9pk2m3k575bfqebs7lg5n` FOREIGN KEY (`coach_id`) REFERENCES `coach` (`coach_id`),
  CONSTRAINT `FKos3sguiasei5a6ysi44ovwou2` FOREIGN KEY (`ticket_id`) REFERENCES `ticket` (`ticket_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passenger`
--

LOCK TABLES `passenger` WRITE;
/*!40000 ALTER TABLE `passenger` DISABLE KEYS */;
INSERT INTO `passenger` VALUES (1,31,'WAITING_LIST','SLEEPER','MALE',NULL,'Rahul Singh',NULL,NULL,2),(2,24,'CONFIRMED','AC_3_TIER','FEMALE',NULL,'Seema Kumari','B2-4',46,2),(3,31,'CONFIRMED','AC_3_TIER','FEMALE',NULL,'Pooja','B2-5',46,3),(4,24,'CONFIRMED','AC_2_TIER','FEMALE',NULL,'Seema Kumari','A1-1',45,3),(6,31,'CONFIRMED','AC_3_TIER','FEMALE',NULL,'Pooja','B2-6',46,4),(7,24,'CONFIRMED','AC_2_TIER','FEMALE',NULL,'Seema Kumari','A1-2',45,4);
/*!40000 ALTER TABLE `passenger` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-11-13 18:59:27
