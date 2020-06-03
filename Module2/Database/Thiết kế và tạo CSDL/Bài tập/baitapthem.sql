-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: shopee
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Dumping data for table `categovies`
--

LOCK TABLES `categovies` WRITE;
/*!40000 ALTER TABLE `categovies` DISABLE KEYS */;
INSERT INTO `categovies` VALUES (13,'Bất Động Sản'),(1,'Điện Thoại'),(11,'Đồ Điện Tử'),(9,'Đồ Dùng Nhà Bếp'),(5,'Đồng Hồ'),(8,'Dụng Cụ Cầm Tay'),(7,'Máy Ảnh & Máy Quay Phim'),(6,'Máy Tính & Laptop'),(10,'Mỹ Phẩm'),(3,'Thời Trang Nam'),(4,'Thời Trang Nữ'),(12,'Thực Phẩm'),(2,'Xe Cộ');
/*!40000 ALTER TABLE `categovies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'Cường',123123,'Đà Nẵng','cuong@gmail.com'),(2,'Duy',131313,'Sài Gòn','duy@gmail.com'),(3,'Ngân',121212,'Hội An','ngan@gmail.com'),(4,'Quân',141414,'Đà Nẵng','quan@gmail.com'),(5,'Hùng',151515,'Đak lak','hung@gmail.com'),(6,'Toàn',161616,'Huế','toan@gmail.com'),(7,'Tú',171717,'Đà Nẵng','tu@gmail.com'),(8,'Bách',181818,'Đà Nẵng','bach@gmail.com'),(9,'Tùng',191919,'Đà Nẵng','tung@gmail.com'),(10,'Hậu',202020,'Đà Nẵng','hau@gmail.com');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'Thiện','1/1/1996','Đà Nẵng'),(2,'Thành','1/1/1992','Đà Nằng'),(3,'Trà','1/1/1995','Quảng Trị'),(4,'Mậu','1/1/1998','Hà Tĩnh'),(5,'Long','1/1/1996','Đà Nẵng'),(6,'An','1/1/1994','Tam Kỳ'),(7,'Sơn','1/1/1995','Huế'),(8,'Thảo','1/1/1994','Đà Nẵng'),(9,'LiuLo','1/1/1996','Đà Nẵng'),(10,'LaLa','1/1/1996','Đà Nẵng');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `order_detail`
--

LOCK TABLES `order_detail` WRITE;
/*!40000 ALTER TABLE `order_detail` DISABLE KEYS */;
INSERT INTO `order_detail` VALUES (1,1,2),(1,3,3),(1,4,1),(1,5,2),(2,1,1),(3,1,1),(4,2,1),(5,2,1),(8,6,3),(8,7,4),(9,8,1),(9,9,2),(10,10,3);
/*!40000 ALTER TABLE `order_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,'Done','Cash',5,1),(2,'On The Way','Cash',3,3),(3,'On The Way','Cash',2,4),(4,'On The Way','Cash',4,6),(5,'On The Way','Cash',7,8),(6,'On The Way','Cash',10,7),(7,'Done','Visa',1,2),(8,'Done','Visa',1,9),(9,'Done','Visa',1,5),(10,'Done','Visa',1,10);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'Iphone 8',1000,'aca',0,10,1,2),(2,'Organ T100',2000,'acac',0,11,11,3),(3,'Macbook Pro',2000,'asca',0,12,6,2),(4,'VSmart 3',200,'ascac',0,11,1,4),(5,'LV limited',2000,'ascv',0,11,4,10),(6,'Tivi SS10',500,'asvsa',0,11,11,1),(7,'Bột Giặt Omo',20,'ascxz',0,11,9,5),(8,'Cà Phê Hòa Tan',20,'asqwe',0,11,12,6),(9,'Iphone 7 Plus',1000,'asvfd',0,11,1,2),(10,'Iphone X',1000,'asdcz',0,11,1,2);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` VALUES (1,'SamSung',123312,'Đà Nẵng'),(2,'Apple',112456,'Đà Nẵng'),(3,'Yamaha',543678,'Đà Nẵng'),(4,'Vin',123545,'Đà Nẵng'),(5,'Unilever',132132,'Đà Nẵng'),(6,'Trung Nguyên',121212,'Đà Nẵng'),(7,'Nestle',131313,'Đà Nẵng'),(8,'Channel',456452,'Đà Nẵng'),(9,'Gucci',12553,'Đà Nẵng'),(10,'Louis Vuitton',123345,'Đà Nẵng');
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-28 10:23:26
