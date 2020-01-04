-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: hethonggtvl
-- ------------------------------------------------------
-- Server version	8.0.18

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
-- Table structure for table `danhmucnganhnghe`
--

DROP TABLE IF EXISTS `danhmucnganhnghe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `danhmucnganhnghe` (
  `iddanhmuc` int(11) NOT NULL AUTO_INCREMENT,
  `tendanhmuc` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`iddanhmuc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `danhmucnganhnghe`
--

LOCK TABLES `danhmucnganhnghe` WRITE;
/*!40000 ALTER TABLE `danhmucnganhnghe` DISABLE KEYS */;
/*!40000 ALTER TABLE `danhmucnganhnghe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nguoitimviec`
--

DROP TABLE IF EXISTS `nguoitimviec`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nguoitimviec` (
  `idnguoitimviec` int(11) NOT NULL,
  `ho` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `ten` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `sdt` int(11) NOT NULL,
  `diachi` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `hocvan` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `kinhnghiem` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tienganh` int(11) DEFAULT NULL,
  `tinhoc` int(11) DEFAULT NULL,
  `tendangnhap` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`idnguoitimviec`),
  KEY `fk_nguoitimviec_taikhoan` (`tendangnhap`),
  CONSTRAINT `fk_nguoitimviec_taikhoan` FOREIGN KEY (`tendangnhap`) REFERENCES `taikhoan` (`tendangnhap`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nguoitimviec`
--

LOCK TABLES `nguoitimviec` WRITE;
/*!40000 ALTER TABLE `nguoitimviec` DISABLE KEYS */;
/*!40000 ALTER TABLE `nguoitimviec` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhatuyendung`
--

DROP TABLE IF EXISTS `nhatuyendung`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhatuyendung` (
  `idnhatuyendung` int(11) NOT NULL,
  `tennhatuyendung` varchar(45) CHARACTER SET utf8 NOT NULL,
  `tencongty` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `sdt` int(11) NOT NULL,
  `thanhpho` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `tendangnhap` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`idnhatuyendung`),
  KEY `fk_nhatuyendung_taikhoan` (`tendangnhap`),
  CONSTRAINT `fk_nhatuyendung_taikhoan` FOREIGN KEY (`tendangnhap`) REFERENCES `taikhoan` (`tendangnhap`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhatuyendung`
--

LOCK TABLES `nhatuyendung` WRITE;
/*!40000 ALTER TABLE `nhatuyendung` DISABLE KEYS */;
/*!40000 ALTER TABLE `nhatuyendung` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qlthongtindk`
--

DROP TABLE IF EXISTS `qlthongtindk`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `qlthongtindk` (
  `id_vieclam` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `id_danhmuc` int(11) NOT NULL,
  `id_nguoitimviec` int(11) NOT NULL,
  `ngaydangki` date NOT NULL,
  PRIMARY KEY (`id_vieclam`,`id_danhmuc`,`id_nguoitimviec`),
  KEY `fk_qlthongtindk_danhmuc_idx` (`id_danhmuc`),
  KEY `fk_qlthongtindk_nguoitimviec_idx` (`id_nguoitimviec`),
  CONSTRAINT `fk_qlthongtindk_danhmuc` FOREIGN KEY (`id_danhmuc`) REFERENCES `danhmucnganhnghe` (`iddanhmuc`),
  CONSTRAINT `fk_qlthongtindk_nguoitimviec` FOREIGN KEY (`id_nguoitimviec`) REFERENCES `nguoitimviec` (`idnguoitimviec`),
  CONSTRAINT `fk_qlthongtindk_vieclam` FOREIGN KEY (`id_vieclam`) REFERENCES `vieclam` (`idvieclam`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qlthongtindk`
--

LOCK TABLES `qlthongtindk` WRITE;
/*!40000 ALTER TABLE `qlthongtindk` DISABLE KEYS */;
/*!40000 ALTER TABLE `qlthongtindk` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qlthongtintuyendung`
--

DROP TABLE IF EXISTS `qlthongtintuyendung`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `qlthongtintuyendung` (
  `idvieclam` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `idnhatuyendung` int(11) NOT NULL,
  `ngaydangki` date NOT NULL,
  PRIMARY KEY (`idvieclam`,`idnhatuyendung`),
  KEY `fk_qlthongtintuyendung_nhatuyendung_idx` (`idnhatuyendung`),
  CONSTRAINT `fk_qlthongtintuyendung_nhatuyendung` FOREIGN KEY (`idnhatuyendung`) REFERENCES `nhatuyendung` (`idnhatuyendung`),
  CONSTRAINT `fk_qlthongtintuyendung_vieclam` FOREIGN KEY (`idvieclam`) REFERENCES `vieclam` (`idvieclam`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qlthongtintuyendung`
--

LOCK TABLES `qlthongtintuyendung` WRITE;
/*!40000 ALTER TABLE `qlthongtintuyendung` DISABLE KEYS */;
/*!40000 ALTER TABLE `qlthongtintuyendung` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `taikhoan`
--

DROP TABLE IF EXISTS `taikhoan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `taikhoan` (
  `tendangnhap` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `matkhau` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `loainguoidung` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`tendangnhap`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taikhoan`
--

LOCK TABLES `taikhoan` WRITE;
/*!40000 ALTER TABLE `taikhoan` DISABLE KEYS */;
INSERT INTO `taikhoan` VALUES ('admin','admin','admin'),('quang','1','Người tìm việc'),('tan','1','Nhà tuyển dụng');
/*!40000 ALTER TABLE `taikhoan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vieclam`
--

DROP TABLE IF EXISTS `vieclam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vieclam` (
  `idvieclam` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `tenvieclam` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `vitri` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `luong` int(11) NOT NULL,
  `diachi` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `ngaydang` date NOT NULL,
  `id_nhatuyendung` int(11) NOT NULL,
  `id_danhmuc` int(11) NOT NULL,
  PRIMARY KEY (`idvieclam`),
  KEY `fk_vieclam_nhatuyendung_idx` (`id_nhatuyendung`),
  KEY `fk_vieclam_danhmuc_idx` (`id_danhmuc`),
  CONSTRAINT `fk_vieclam_danhmuc` FOREIGN KEY (`id_danhmuc`) REFERENCES `danhmucnganhnghe` (`iddanhmuc`),
  CONSTRAINT `fk_vieclam_nhatuyendung` FOREIGN KEY (`id_nhatuyendung`) REFERENCES `nhatuyendung` (`idnhatuyendung`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vieclam`
--

LOCK TABLES `vieclam` WRITE;
/*!40000 ALTER TABLE `vieclam` DISABLE KEYS */;
/*!40000 ALTER TABLE `vieclam` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'hethonggtvl'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-01-04 14:37:21
