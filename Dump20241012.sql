CREATE DATABASE  IF NOT EXISTS `registros` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `registros`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: registros
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
-- Temporary view structure for view `consultahistorialindicador`
--

DROP TABLE IF EXISTS `consultahistorialindicador`;
/*!50001 DROP VIEW IF EXISTS `consultahistorialindicador`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `consultahistorialindicador` AS SELECT 
 1 AS `IND_ID`,
 1 AS `IND_NOMBRE`,
 1 AS `DET_VALOR_ESPERADO`,
 1 AS `DET_VALOR_MINIMO`,
 1 AS `DET_VALOR_MAXIMO`,
 1 AS `DET_VALOR_MEDIDA`,
 1 AS `DET_FECHA`,
 1 AS `DET_DESCRIPCION`,
 1 AS `COLOR`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `reg_detalle_indicador`
--

DROP TABLE IF EXISTS `reg_detalle_indicador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reg_detalle_indicador` (
  `DET_IND_ID` int NOT NULL AUTO_INCREMENT,
  `IND_ID` int DEFAULT NULL,
  `DET_VALOR_ESPERADO` decimal(10,2) DEFAULT NULL,
  `DET_VALOR_MINIMO` decimal(10,2) DEFAULT NULL,
  `DET_VALOR_MAXIMO` decimal(10,2) DEFAULT NULL,
  `DET_VALOR_MEDIDA` decimal(10,2) DEFAULT NULL,
  `DET_FECHA` date DEFAULT NULL,
  `DET_DESCRIPCION` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`DET_IND_ID`),
  KEY `fk_indicador_detalle_indicador_idx` (`IND_ID`),
  CONSTRAINT `fk_indicador_detalle_indicador` FOREIGN KEY (`IND_ID`) REFERENCES `reg_indicadores` (`IND_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reg_detalle_indicador`
--

LOCK TABLES `reg_detalle_indicador` WRITE;
/*!40000 ALTER TABLE `reg_detalle_indicador` DISABLE KEYS */;
INSERT INTO `reg_detalle_indicador` VALUES (1,1,1000.00,800.00,1200.00,1000.00,'2024-10-11','se actualizo el valor de medida'),(2,1,1000.00,800.00,1200.00,2000.00,'2024-10-12','CAMBIO EN EL VALOR DE MEDIDA'),(3,1,1000.00,800.00,1200.00,3000.00,'2024-10-12','CAMBIO EN EL VALOR DE MEDIDA'),(4,1,1000.00,800.00,1200.00,5000.00,'2024-10-01','cambio de fecha'),(5,1,1000.00,800.00,1200.00,6000.00,'2024-10-19','cambio de fecha');
/*!40000 ALTER TABLE `reg_detalle_indicador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reg_indicadores`
--

DROP TABLE IF EXISTS `reg_indicadores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reg_indicadores` (
  `IND_ID` int NOT NULL AUTO_INCREMENT,
  `IND_NOMBRE` varchar(100) DEFAULT NULL,
  `IND_VALOR_ESPERADO` decimal(10,2) DEFAULT NULL,
  `IND_VALOR_MINIMO` decimal(10,2) DEFAULT NULL,
  `IND_VALOR_MAXIMO` decimal(10,2) DEFAULT NULL,
  `IND_VALOR_MEDIDA` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`IND_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reg_indicadores`
--

LOCK TABLES `reg_indicadores` WRITE;
/*!40000 ALTER TABLE `reg_indicadores` DISABLE KEYS */;
INSERT INTO `reg_indicadores` VALUES (1,'FOTO COPIADORA',1000.00,800.00,1200.00,6000.00),(2,'CAMION',1000.00,900.00,1200.00,NULL),(3,'CAMION 2',1000.00,900.00,1200.00,NULL),(4,'CAMION 3',1000.00,900.00,1200.00,NULL);
/*!40000 ALTER TABLE `reg_indicadores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `consultahistorialindicador`
--

/*!50001 DROP VIEW IF EXISTS `consultahistorialindicador`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `consultahistorialindicador` AS select `indi`.`IND_ID` AS `IND_ID`,`indi`.`IND_NOMBRE` AS `IND_NOMBRE`,cast(`detindi`.`DET_VALOR_ESPERADO` as char charset utf8mb4) AS `DET_VALOR_ESPERADO`,cast(`detindi`.`DET_VALOR_MINIMO` as char charset utf8mb4) AS `DET_VALOR_MINIMO`,cast(`detindi`.`DET_VALOR_MAXIMO` as char charset utf8mb4) AS `DET_VALOR_MAXIMO`,cast(`detindi`.`DET_VALOR_MEDIDA` as char charset utf8mb4) AS `DET_VALOR_MEDIDA`,`detindi`.`DET_FECHA` AS `DET_FECHA`,`detindi`.`DET_DESCRIPCION` AS `DET_DESCRIPCION`,(case when (`detindi`.`DET_VALOR_MEDIDA` < `detindi`.`DET_VALOR_MINIMO`) then 'ROJO' when ((`detindi`.`DET_VALOR_MEDIDA` >= `detindi`.`DET_VALOR_MINIMO`) and (`detindi`.`DET_VALOR_MEDIDA` < `detindi`.`DET_VALOR_ESPERADO`)) then 'AMARRILLO' when ((`detindi`.`DET_VALOR_MEDIDA` >= `detindi`.`DET_VALOR_ESPERADO`) and (`detindi`.`DET_VALOR_MEDIDA` <= `detindi`.`DET_VALOR_MAXIMO`)) then 'VERDE' when (`detindi`.`DET_VALOR_MEDIDA` > `detindi`.`DET_VALOR_MAXIMO`) then 'AZUL' end) AS `COLOR` from (`reg_indicadores` `indi` join `reg_detalle_indicador` `detindi` on((`indi`.`IND_ID` = `detindi`.`IND_ID`))) order by `detindi`.`DET_FECHA` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-12 17:03:53
