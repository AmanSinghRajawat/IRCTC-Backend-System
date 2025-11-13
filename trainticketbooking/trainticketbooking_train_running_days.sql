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
-- Table structure for table `train_running_days`
--

DROP TABLE IF EXISTS `train_running_days`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `train_running_days` (
  `train_id` bigint NOT NULL,
  `running_day` enum('FRIDAY','MONDAY','SATURDAY','SUNDAY','THURSDAY','TUESDAY','WEDNESDAY') DEFAULT NULL,
  KEY `FK5ipdv4jr4athcy617betbfri5` (`train_id`),
  CONSTRAINT `FK5ipdv4jr4athcy617betbfri5` FOREIGN KEY (`train_id`) REFERENCES `train` (`train_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `train_running_days`
--

LOCK TABLES `train_running_days` WRITE;
/*!40000 ALTER TABLE `train_running_days` DISABLE KEYS */;
INSERT INTO `train_running_days` VALUES (1,'MONDAY'),(1,'TUESDAY'),(1,'WEDNESDAY'),(1,'THURSDAY'),(2,'MONDAY'),(2,'SUNDAY'),(2,'WEDNESDAY'),(2,'FRIDAY'),(3,'TUESDAY'),(3,'THURSDAY'),(3,'SATURDAY'),(4,'SUNDAY'),(4,'MONDAY'),(4,'TUESDAY'),(4,'WEDNESDAY'),(4,'THURSDAY'),(4,'FRIDAY'),(4,'SATURDAY'),(5,'SUNDAY'),(5,'MONDAY'),(5,'TUESDAY'),(5,'WEDNESDAY'),(6,'SUNDAY'),(6,'MONDAY'),(6,'WEDNESDAY'),(7,'SUNDAY'),(7,'MONDAY'),(7,'TUESDAY'),(7,'WEDNESDAY'),(7,'THURSDAY'),(7,'FRIDAY'),(7,'SATURDAY'),(8,'SUNDAY'),(8,'TUESDAY'),(8,'SATURDAY');
/*!40000 ALTER TABLE `train_running_days` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-11-13 18:59:28
