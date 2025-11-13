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
-- Table structure for table `train`
--

DROP TABLE IF EXISTS `train`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `train` (
  `train_id` bigint NOT NULL AUTO_INCREMENT,
  `seats` varbinary(255) DEFAULT NULL,
  `train_name` varchar(255) NOT NULL,
  `train_number` bigint NOT NULL,
  `train_type` enum('EXPRESS','PASSENGER','SUPERFAST') NOT NULL,
  PRIMARY KEY (`train_id`),
  UNIQUE KEY `UK5kdorev80dwqi2uem9f401u0e` (`train_name`),
  UNIQUE KEY `UK5mk8elq5bgy1fnyhfx1v4espy` (`train_number`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `train`
--

LOCK TABLES `train` WRITE;
/*!40000 ALTER TABLE `train` DISABLE KEYS */;
INSERT INTO `train` VALUES (1,NULL,'Kerala Express',12121,'EXPRESS'),(2,NULL,'UP Sampark Kranti Express',13131,'SUPERFAST'),(3,NULL,'MP Sampark Kranti Express',14141,'SUPERFAST'),(4,NULL,'Agra-Jhansi Passenger',15151,'PASSENGER'),(5,NULL,'Delhi-Bandra Express',16161,'EXPRESS'),(6,NULL,'Chennai-Bangalore Express',17171,'SUPERFAST'),(7,NULL,'Kota-Bhind Passenger',18181,'PASSENGER'),(8,NULL,'Vande Bharat Express',19191,'SUPERFAST'),(9,NULL,'Gondbana Express',20201,'SUPERFAST'),(10,NULL,'Chattisgarh Express',21211,'EXPRESS'),(11,NULL,'Jhansi-Bandra Express',22221,'SUPERFAST'),(12,NULL,'Naalanda Express',23231,'SUPERFAST');
/*!40000 ALTER TABLE `train` ENABLE KEYS */;
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
