CREATE DATABASE  IF NOT EXISTS `campus` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `campus`;
-- MySQL dump 10.13  Distrib 5.7.26, for Linux (x86_64)
--
-- Host: localhost    Database: campus
-- ------------------------------------------------------
-- Server version	5.7.26-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categoria` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categoria` varchar(150) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `categoria` (`categoria`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,'Desarrollo'),(4,'Fotografía'),(3,'Marketing'),(2,'Negocios');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `apellidos` varchar(50) NOT NULL,
  `mail` varchar(50) NOT NULL,
  `contrasenya` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `mail` (`mail`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Para','Probar','prueba@prueba.com','21232f297a57a5a743894a0e4a801fc3'),(2,'Prueba','dos','prueba2@prueba.com','21232f297a57a5a743894a0e4a801fc3');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente_curso`
--

DROP TABLE IF EXISTS `cliente_curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente_curso` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_cliente` int(11) NOT NULL,
  `id_curso` int(11) NOT NULL,
  `id_tema` int(11) DEFAULT NULL,
  `active` int(11) DEFAULT NULL,
  `random` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente_curso`
--

LOCK TABLES `cliente_curso` WRITE;
/*!40000 ALTER TABLE `cliente_curso` DISABLE KEYS */;
INSERT INTO `cliente_curso` VALUES (11,1,7,22,1,53221),(12,1,8,NULL,1,45265),(13,1,9,NULL,1,15817),(14,1,12,27,NULL,36216),(15,2,7,NULL,NULL,77791);
/*!40000 ALTER TABLE `cliente_curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curso`
--

DROP TABLE IF EXISTS `curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `curso` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(50) NOT NULL,
  `descripcion` text NOT NULL,
  `url_foto` varchar(200) DEFAULT NULL,
  `url_pdf` varchar(200) DEFAULT NULL,
  `url_video` varchar(200) DEFAULT NULL,
  `fecha` datetime NOT NULL,
  `idProfesor` int(11) DEFAULT NULL,
  `publicado` tinyint(1) DEFAULT NULL,
  `precio` decimal(6,2) NOT NULL,
  `fecha_duracion` datetime DEFAULT NULL,
  `idEmpresa` int(11) DEFAULT NULL,
  `categoria` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_idx` (`categoria`),
  CONSTRAINT `id` FOREIGN KEY (`categoria`) REFERENCES `categoria` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso`
--

LOCK TABLES `curso` WRITE;
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
INSERT INTO `curso` VALUES (7,'Java','La API Java es una interfaz de programación de aplicaciones (API, por sus siglas del inglés: Application Programming Interface) provista por los creadores del lenguaje de programación Java, que da a los programadores los medios para desarrollar aplicaciones Java.\r\n\r\nComo el lenguaje Java es un lenguaje orientado a objetos, la API de Java provee de un conjunto de clases utilitarias para efectuar toda clase de tareas necesarias dentro de un programa.\r\n\r\nLa API Java está organizada en paquetes lógicos, donde cada paquete contiene un conjunto de clases relacionadas semánticamente.','61559931525010javaa.png',NULL,NULL,'2019-06-07 20:18:48',6,1,10.00,NULL,NULL,NULL),(8,'JavaScript','JavaScript es un lenguaje de programación interpretado, dialecto del estándar ECMAScript. Se define como orientado a objetos, ? basado en prototipos, imperativo, débilmente tipado y dinámico.','61559931806068javascript.jpg','61559931806068DocumentaciónProyectoFinal.pdf',NULL,'2019-06-07 20:23:29',6,1,49.99,NULL,NULL,NULL),(9,'jQuery','jQuery es una biblioteca multiplataforma de JavaScript, creada inicialmente por John Resig, que permite simplificar la manera de interactuar con los documentos HTML, manipular el árbol DOM, manejar eventos, desarrollar animaciones y agregar interacción con la técnica AJAX a páginas web.?','61559932067742Jquery-Logo.png',NULL,NULL,'2019-06-07 20:27:50',6,1,12.00,NULL,NULL,NULL),(10,'MySQL','MySQL es un sistema de gestión de bases de datos relacional desarrollado bajo licencia dual: Licencia pública general/Licencia comercial por Oracle Corporation y está considerada como la base datos de código abierto más popular del mundo,1?2? y una de las más populares en general junto a Oracle y Microsoft SQL Server, sobre todo para entornos de desarrollo web.\r\n\r\nMySQL fue inicialmente desarrollado por MySQL AB (empresa fundada por David Axmark, Allan Larsson y Michael Widenius). MySQL AB fue adquirida por Sun Microsystems en 2008, y ésta a su vez fue comprada por Oracle Corporation en 2010, la cual ya era dueña desde 2005 de Innobase Oy, empresa finlandesa desarrolladora del motor InnoDB para MySQL.','61559932250091mysql.jpg',NULL,NULL,'2019-06-07 20:30:53',6,1,15.99,NULL,NULL,NULL),(12,'PHP','PHP, acrónimo recursivo en inglés de PHP: Hypertext Preprocessor (preprocesador de hipertexto), es un lenguaje de programación de propósito general de código del lado del servidor originalmente diseñado para el desarrollo web de contenido dinámico. Fue uno de los primeros lenguajes de programación del lado del servidor que se podían incorporar directamente en un documento HTML en lugar de llamar a un archivo externo que procese los datos. El código es interpretado por un servidor web con un módulo de procesador de PHP que genera el HTML resultante.','61559932542369php.jpg',NULL,NULL,'2019-06-07 20:35:45',6,1,15.00,NULL,NULL,NULL),(13,'C#','C# es un lenguaje de programación orientado a objetos desarrollado y estandarizado por Microsoft como parte de su plataforma .NET, que después fue aprobado como un estándar por la ECMA e ISO. C# es uno de los lenguajes de programación diseñados para la infraestructura de lenguaje común.','61559934086167cc.png',NULL,NULL,'2019-06-07 21:01:29',6,1,30.00,NULL,NULL,NULL),(14,'Prueba','Prueba','61560167586154mysql.jpg',NULL,NULL,'2019-06-10 13:53:09',6,0,10.00,NULL,NULL,NULL),(15,'Titulo','descripcion','61560173348332php.jpg',NULL,NULL,'2019-06-10 15:33:52',6,0,10.00,NULL,NULL,NULL),(18,'tyhrth','hrthrth','61560174649128javaa.png',NULL,NULL,'2019-06-10 15:50:52',6,0,4.00,NULL,NULL,NULL),(19,'Mas pruebas','dfd','61560174766361Jquery-Logo.png',NULL,NULL,'2019-06-10 15:53:48',6,0,21.00,NULL,NULL,3);
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curso_info`
--

DROP TABLE IF EXISTS `curso_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `curso_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_curso` int(11) NOT NULL,
  `texto` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso_info`
--

LOCK TABLES `curso_info` WRITE;
/*!40000 ALTER TABLE `curso_info` DISABLE KEYS */;
INSERT INTO `curso_info` VALUES (37,7,'info'),(38,7,'apre'),(39,8,'info'),(40,8,'apre'),(41,9,'info'),(42,9,'apre'),(43,10,'info'),(44,10,'apre'),(47,12,'info'),(48,12,'apre'),(49,13,'info'),(50,13,'apre'),(51,14,'info'),(52,14,'apre'),(53,15,'info'),(54,15,'apre'),(59,18,'info'),(60,18,'apre'),(61,19,'info'),(62,19,'apre');
/*!40000 ALTER TABLE `curso_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curso_tema`
--

DROP TABLE IF EXISTS `curso_tema`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `curso_tema` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_curso` int(11) NOT NULL,
  `titulo` varchar(100) NOT NULL,
  `precio` decimal(6,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso_tema`
--

LOCK TABLES `curso_tema` WRITE;
/*!40000 ALTER TABLE `curso_tema` DISABLE KEYS */;
INSERT INTO `curso_tema` VALUES (22,7,'Tema 1',10.00),(23,7,'Tema 2',10.00),(24,8,'Tema 1',10.00),(25,9,'Tema 1',10.00),(26,10,'MySQL el renacer',99.00),(27,12,'Tema 1',10.00),(28,13,'Tema 1',10.00),(29,13,'Tema 2',10.00),(30,13,'Tema 3',15.00);
/*!40000 ALTER TABLE `curso_tema` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `info`
--

DROP TABLE IF EXISTS `info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_curso_info` int(11) NOT NULL,
  `id_curso` int(11) NOT NULL,
  `texto` text NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_curso_info` (`id_curso_info`),
  CONSTRAINT `info_ibfk_1` FOREIGN KEY (`id_curso_info`) REFERENCES `curso_info` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `info`
--

LOCK TABLES `info` WRITE;
/*!40000 ALTER TABLE `info` DISABLE KEYS */;
INSERT INTO `info` VALUES (25,37,7,'Java API'),(27,37,7,'Presentaciones en PDF'),(28,38,7,'A programar en Java'),(29,38,7,'A utilizar APIs'),(30,39,8,'Sintaxis y semántica'),(31,39,8,'Ejemplos sencillos'),(32,39,8,'Uso en páginas web'),(33,40,8,'Imperativo y estructurado'),(34,40,8,'En un pro de javascri'),(35,41,9,'Características'),(36,42,9,'	Versiones'),(37,43,10,'Plataformas'),(38,44,10,'Características distintivas'),(39,47,12,'Sintaxis'),(40,47,12,'	Características de PHP'),(41,48,12,'Características de PHP'),(42,50,13,'Variables'),(43,50,13,'Matrices'),(44,50,13,'	Métodos'),(45,50,13,'Clases y objetos'),(46,49,13,'Muchas Cosas');
/*!40000 ALTER TABLE `info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `newpass`
--

DROP TABLE IF EXISTS `newpass`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `newpass` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mail` varchar(50) NOT NULL,
  `token` varchar(150) NOT NULL,
  `fechaFin` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `newpass`
--

LOCK TABLES `newpass` WRITE;
/*!40000 ALTER TABLE `newpass` DISABLE KEYS */;
/*!40000 ALTER TABLE `newpass` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profesor`
--

DROP TABLE IF EXISTS `profesor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `profesor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `apellidos` varchar(50) DEFAULT NULL,
  `mail` varchar(50) NOT NULL,
  `contrasenya` varchar(50) NOT NULL,
  `comunidad` varchar(50) NOT NULL,
  `DNI` varchar(45) DEFAULT NULL,
  `CIF` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `mail` (`mail`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesor`
--

LOCK TABLES `profesor` WRITE;
/*!40000 ALTER TABLE `profesor` DISABLE KEYS */;
INSERT INTO `profesor` VALUES (6,'Prodesor','Uno','profesor@gmail.com','21232f297a57a5a743894a0e4a801fc3','Baleares','4758962d',NULL);
/*!40000 ALTER TABLE `profesor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registro_compra`
--

DROP TABLE IF EXISTS `registro_compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `registro_compra` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_factura` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `id_curso` int(11) NOT NULL,
  `id_tema` int(11) DEFAULT NULL,
  `fecha` datetime NOT NULL,
  `precio_base` decimal(6,2) NOT NULL,
  `iva` decimal(6,2) NOT NULL,
  `precio` decimal(6,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registro_compra`
--

LOCK TABLES `registro_compra` WRITE;
/*!40000 ALTER TABLE `registro_compra` DISABLE KEYS */;
INSERT INTO `registro_compra` VALUES (21,17536148,1,7,22,'2019-06-07 20:52:16',8.27,1.73,10.00),(22,18576031,1,8,NULL,'2019-06-07 20:52:56',41.32,8.67,49.99),(23,19499298,1,9,NULL,'2019-06-10 14:24:59',9.92,2.08,12.00),(24,112191008,1,12,27,'2019-06-10 17:06:31',8.27,1.73,10.00),(25,27044259,2,7,NULL,'2019-06-11 09:44:04',8.27,1.73,10.00);
/*!40000 ALTER TABLE `registro_compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tema`
--

DROP TABLE IF EXISTS `tema`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tema` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_curso_tema` int(11) NOT NULL,
  `id_curso` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `url` varchar(200) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_curso_tema` (`id_curso_tema`),
  CONSTRAINT `tema_ibfk_1` FOREIGN KEY (`id_curso_tema`) REFERENCES `curso_tema` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tema`
--

LOCK TABLES `tema` WRITE;
/*!40000 ALTER TABLE `tema` DISABLE KEYS */;
INSERT INTO `tema` VALUES (19,22,7,'Java API','61559931659826javaa.png'),(20,23,7,'Java API','61559931679986javaa.png'),(21,24,8,'Java script','61559931930558javascript.jpg'),(22,25,9,'jQuery','61559932143238Jquery-Logo.png'),(23,26,10,'MySQL','61559932382638mysql.jpg'),(24,27,12,'php','61559933300765php.jpg'),(25,28,13,'C#','61559934189107cc.png'),(26,29,13,'C#','61559934204959cc.png'),(27,30,13,'C#','61559934221735cc.png');
/*!40000 ALTER TABLE `tema` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'campus'
--

--
-- Dumping routines for database 'campus'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-12 12:07:34
