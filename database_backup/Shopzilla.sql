CREATE DATABASE  IF NOT EXISTS `shopzilla` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `shopzilla`;
-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: shopzilla
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `buyer`
--

DROP TABLE IF EXISTS `buyer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `buyer` (
  `UserName` varchar(50) NOT NULL,
  `password` varchar(15) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `mobile_no` varchar(15) NOT NULL,
  `address` varchar(70) NOT NULL,
  `balance` decimal(15,2) NOT NULL,
  `is_deleted` int DEFAULT '0',
  `deleted_date` date DEFAULT NULL,
  UNIQUE KEY `UserName` (`UserName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `buyer`
--

LOCK TABLES `buyer` WRITE;
/*!40000 ALTER TABLE `buyer` DISABLE KEYS */;
INSERT INTO `buyer` VALUES ('Amit_271','password1','Amit','Sharma','9876543210','123 Main St, Delhi',0.00,1,'2023-06-22'),('Neha_87','password2','Neha','Patel','8765432109','456 Oak St, Mumbai',298535.72,0,NULL),('Pooja_72','password4','Pooja','Gupta','6543210987','456 Elm St, Chennai',223382.81,0,NULL),('Priya_2','password5','Priya','Verma','9876543211','345 Park St, Kolkata',265520.09,0,NULL),('Rahul_901','password3','Rahul','Singh','7654321098','789 Maple St, Bangalore',183797.99,0,NULL),('Raj_28','password6','Raj','Gandhi','8765432108','567 Beach Rd, Goa',107452.02,0,NULL),('Sneha_278','password7','Sneha','Kapoor','7654321097','789 Hill St, Hyderabad',190699.83,0,NULL),('Vikram_271','password8','Vikram','Mehra','6543210986','234 Lake Ave, Chandigarh',81143.13,0,NULL);
/*!40000 ALTER TABLE `buyer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `cat_id` int NOT NULL AUTO_INCREMENT,
  `cat_name` varchar(25) DEFAULT NULL,
  `gst_per` int DEFAULT NULL,
  PRIMARY KEY (`cat_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Clothing',5),(2,'Electronics',7),(3,'Grocery',9),(4,'Miscellaneous',12);
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `product_id` int NOT NULL AUTO_INCREMENT,
  `product_name` varchar(40) DEFAULT NULL,
  `price_per_piece` decimal(8,2) DEFAULT NULL,
  `seller_unique_num` int DEFAULT NULL,
  `seller_username` varchar(50) NOT NULL,
  `seller_name` varchar(70) NOT NULL,
  `quantity` int DEFAULT NULL,
  `description` text,
  `category_id` int DEFAULT NULL,
  `sold_status` int DEFAULT '0',
  `is_hide` int DEFAULT '0',
  `return_policy` int DEFAULT '1',
  PRIMARY KEY (`product_id`),
  KEY `seller_unique_num` (`seller_unique_num`),
  KEY `category_id` (`category_id`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`seller_unique_num`) REFERENCES `seller` (`SellerId`),
  CONSTRAINT `product_ibfk_2` FOREIGN KEY (`category_id`) REFERENCES `category` (`cat_id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Silk Saree',2999.99,1,'Raj_2345','Raj Kumar',39,'Premium quality silk saree with intricate designs and luxurious feel.',1,0,1,0),(2,'Leather Wallet',499.50,5,'Anita_1516','Anita Patel',77,'Stylish and durable leather wallet with multiple compartments.',1,0,0,1),(3,'Block Print Scarf',499.50,9,'Anjali_2324','Anjali Gupta',80,'Lightweight scarf with beautiful block prints, perfect for adding a touch of Indian fashion.',1,0,0,1),(4,'Handloom Cotton Saree',1999.99,1,'Raj_2345','Raj Kumar',30,'Traditional handloom cotton saree with intricate patterns.',1,0,1,1),(5,'Handcrafted Leather Bag',799.50,5,'Anita_1516','Anita Patel',40,'Handmade leather bag with spacious compartments and trendy design.',1,0,0,1),(6,'Traditional Kundan Jewelry Set',2999.99,9,'Anjali_2324','Anjali Gupta',20,'Exquisite Kundan jewelry set with intricate craftsmanship.',1,0,0,1),(7,'Men\'s Casual Shirt',699.99,2,'Neha_6789','Neha Sharma',50,'Stylish and comfortable casual shirt for men.',1,0,0,1),(8,'Women\'s Ethnic Kurti',899.50,6,'Anjali_2324','Anjali Gupta',60,'Trendy and fashionable ethnic kurti for women.',1,0,0,1),(9,'Sports Shoes',1299.00,3,'Priya_1112','Priya Gupta',30,'High-quality sports shoes for enhanced performance and comfort.',1,0,0,1),(10,'Kids\' Party Dress',599.50,7,'Deepak_1718','Deepak Joshi',40,'Adorable party dress for kids to make them look cute and stylish.',1,0,0,1),(11,'Bluetooth Earphones',999.00,2,'Neha_6789','Neha Sharma',100,'High-quality wireless earphones for a seamless music experience.',2,0,0,1),(12,'Classical Music CD Set',699.00,7,'Deepak_1718','Deepak Joshi',120,'A curated collection of classical music CDs by renowned Indian artists.',2,0,0,1),(13,'Smartphone',14999.00,2,'Neha_6789','Neha Sharma',50,'Advanced smartphone with powerful features and high-quality camera.',2,0,0,1),(14,'Wireless Bluetooth Speaker',1299.00,7,'Deepak_1718','Deepak Joshi',80,'Portable wireless speaker with rich sound quality and long battery life.',2,0,0,1),(15,'Air Purifier',3999.00,4,'Priya_1112','Priya Gupta',30,'Efficient air purifier to improve the air quality in your home or office.',2,0,0,1),(16,'HD LED TV',21999.00,3,'Manish_8910','Manish Verma',25,'High-definition LED TV with a large screen for an immersive viewing experience.',2,0,0,1),(17,'Digital Camera',7999.00,3,'Manish_8910','Manish Verma',35,'Professional-grade digital camera for capturing stunning photos and videos.',2,0,0,1),(18,'Gaming Console',16999.00,7,'Deepak_1718','Deepak Joshi',20,'Next-generation gaming console for an immersive gaming experience.',2,0,0,1),(19,'Laptop',34999.00,3,'Manish_8910','Manish Verma',14,'Powerful laptop for seamless multitasking and high-performance computing.',2,0,0,1),(20,'Wireless Headphones',1499.00,2,'Neha_6789','Neha Sharma',40,'Wireless headphones with excellent sound quality and comfortable fit.',2,0,0,1),(21,'Organic Green Tea',199.00,10,'Pooja_2324','Pooja Rajput',200,'Premium quality organic green tea for a refreshing and healthy beverage.',3,0,0,1),(22,'Extra Virgin Olive Oil',299.50,6,'Anjali_2324','Anjali Gupta',150,'Imported extra virgin olive oil for enhancing the taste of your dishes.',3,0,0,1),(23,'Ground Coffee',249.00,10,'Pooja_2324','Pooja Rajput',120,'Finely ground coffee beans for a rich and aromatic coffee experience.',3,0,0,1),(24,'Organic Quinoa',149.50,9,'Anjali_2324','Anjali Gupta',100,'Healthy and nutritious organic quinoa grains for wholesome meals.',3,0,0,1),(25,'Premium Chocolate',99.00,8,'Vikas_2122','Vikas Shah',200,'Indulgent and high-quality chocolate bars for a sweet treat.',3,0,0,1),(26,'Organic Honey',249.50,9,'Anjali_2324','Anjali Gupta',150,'Pure and natural organic honey sourced from trusted beekeepers.',3,0,0,1),(27,'Spices Gift Set',199.00,10,'Pooja_2324','Pooja Rajput',80,'A collection of aromatic spices to add flavors to your dishes.',3,0,0,1),(28,'Healthy Snack Pack',149.50,8,'Vikas_2122','Vikas Shah',120,'Assortment of healthy and tasty snacks for guilt-free snacking.',3,0,0,1),(29,'Organic Dried Fruits',299.00,9,'Anjali_2324','Anjali Gupta',100,'Assorted organic dried fruits for a nutritious and delicious snack.',3,0,0,1),(30,'Gluten-Free Pasta',199.50,10,'Pooja_2324','Pooja Rajput',80,'Delicious gluten-free pasta made from high-quality ingredients.',3,0,0,1),(31,'Decorative Wall Clock',499.00,6,'Anita_1516','Anita Patel',50,'Aesthetic wall clock to enhance the look of your living space.',4,0,0,1),(32,'Handmade Ceramic Vase',299.50,7,'Deepak_1718','Deepak Joshi',60,'Unique and elegant handmade ceramic vase for showcasing flowers.',4,0,0,1),(33,'Fragrance Diffuser Set',399.00,8,'Sonia_1920','Sonia Malhotra',40,'Aromatic fragrance diffuser set to create a pleasant ambiance.',4,0,0,1),(34,'Vintage Leather Journal',199.50,9,'Vikas_2122','Vikas Shah',70,'Vintage-style leather journal for writing and sketching.',4,0,0,1),(35,'Scented Candles Set',299.00,10,'Pooja_2324','Pooja Rajput',50,'Set of scented candles to create a relaxing and soothing atmosphere.',4,0,0,1),(36,'Home Decorative Cushions',249.50,1,'Raj_2345','Raj Kumar',79,'Stylish and comfortable decorative cushions for your living room.',4,0,1,1),(37,'Wall Art Painting',599.00,2,'Neha_6789','Neha Sharma',30,'Captivating wall art painting to add a touch of elegance to your home.',4,0,0,1),(38,'Antique Brass Showpiece',799.50,3,'Manish_8910','Manish Verma',20,'Exquisite antique brass showpiece for displaying in your showcase.',4,0,0,1),(39,'Handwoven Cotton Rug',499.00,4,'Priya_1112','Priya Gupta',40,'Handwoven cotton rug with beautiful patterns and vibrant colors.',4,0,0,1),(40,'Decorative Table Lamp',349.50,5,'Amit_1314','Amit Singh',30,'Elegant and decorative table lamp to illuminate your space.',4,0,0,1),(41,'Realme 3',4000.00,1,'Raj_2345','Raj Batham',10,'realme phone 8MP front Camera 30MP back Camera',1,0,1,0);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `returnproduct`
--

DROP TABLE IF EXISTS `returnproduct`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `returnproduct` (
  `return_id` int NOT NULL AUTO_INCREMENT,
  `product_id` int NOT NULL,
  `product_name` varchar(60) DEFAULT NULL,
  `reason_for_return` text NOT NULL,
  `return_date` date NOT NULL,
  `buyer_id` varchar(15) NOT NULL,
  `buyer_name` varchar(50) NOT NULL,
  `quantity` int DEFAULT NULL,
  `return_type` varchar(20) DEFAULT NULL,
  `transaction_id` int DEFAULT NULL,
  PRIMARY KEY (`return_id`),
  KEY `product_id` (`product_id`),
  KEY `buyer_id` (`buyer_id`),
  KEY `transaction_id` (`transaction_id`),
  CONSTRAINT `returnproduct_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`),
  CONSTRAINT `returnproduct_ibfk_2` FOREIGN KEY (`buyer_id`) REFERENCES `buyer` (`UserName`),
  CONSTRAINT `returnproduct_ibfk_3` FOREIGN KEY (`transaction_id`) REFERENCES `transactions` (`transaction_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `returnproduct`
--

LOCK TABLES `returnproduct` WRITE;
/*!40000 ALTER TABLE `returnproduct` DISABLE KEYS */;
INSERT INTO `returnproduct` VALUES (1,1,'Laptop','laptop is not working prperly and also it lagging ','2023-06-22','Amit_271','Amit Sharma',1,'REFUND',NULL),(2,1,'Leather Wallet','quality of the product is not much as i think','2023-06-22','Amit_271','Amit Sharma',1,'REFUND',NULL),(3,2,'Leather Wallet','quality is not good as i think ','2023-06-22','Amit_271','Amit Sharma',1,'REFUND',NULL),(4,36,'Home Decorative Cushions','quality is not good as much i think','2023-06-22','Amit_271','Amit Sharma',1,'REFUND',5),(5,1,'Silk Saree','saree is not better a sisjmcsmclc','2023-06-22','Amit_271','Amit Sharma',1,'REFUND',6);
/*!40000 ALTER TABLE `returnproduct` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seller`
--

DROP TABLE IF EXISTS `seller`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seller` (
  `SellerId` int NOT NULL AUTO_INCREMENT,
  `UserName` varchar(50) NOT NULL,
  `password` varchar(15) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `mobile_no` varchar(15) NOT NULL,
  `address` varchar(70) NOT NULL,
  `income` decimal(15,2) NOT NULL,
  `is_deleted` int DEFAULT '0',
  `pending_amount` decimal(10,2) DEFAULT '0.00',
  `deleted_date` date DEFAULT NULL,
  PRIMARY KEY (`SellerId`),
  UNIQUE KEY `UserName` (`UserName`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seller`
--

LOCK TABLES `seller` WRITE;
/*!40000 ALTER TABLE `seller` DISABLE KEYS */;
INSERT INTO `seller` VALUES (1,'Raj_2345','password1','Raj','Batham','9876543210','123 ABC Street, Mumbai',1886.76,0,0.00,NULL),(2,'Neha_6789','password2','Neha','Sharma','8765432109','456 XYZ Street, Delhi',196968.80,0,0.00,NULL),(3,'Manish_8910','password3','Manish','Verma','7654321098','789 PQR Street, Bangalore',336920.93,0,0.00,NULL),(4,'Priya_1112','password4','Priya','Gupta','6543210987','321 LMN Street, Kolkata',106453.60,0,0.00,NULL),(5,'Amit_1314','password5','Amit','Singh','5432109876','987 XYZ Street, Chennai',300423.74,0,0.00,NULL),(6,'Anita_1516','password6','Anita','Patel','4321098765','654 PQR Street, Hyderabad',299899.26,0,0.00,NULL),(7,'Deepak_1718','password7','Deepak','Joshi','3210987654','987 ABC Street, Pune',197940.30,0,0.00,NULL),(8,'Sonia_1920','password8','Sonia','Malhotra','2109876543','789 XYZ Street, Ahmedabad',290003.72,0,0.00,NULL),(9,'Vikas_2122','password9','Vikas','Shah','1098765432','456 PQR Street, Jaipur',56197.69,0,0.00,NULL),(10,'Pooja_2324','password10','Pooja','Rajput','0987654321','321 ABC Street, Chandigarh',110977.32,0,0.00,NULL);
/*!40000 ALTER TABLE `seller` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transactions`
--

DROP TABLE IF EXISTS `transactions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transactions` (
  `transaction_id` int NOT NULL AUTO_INCREMENT,
  `product_id` int NOT NULL,
  `product_name` varchar(50) NOT NULL,
  `buyer_id` varchar(15) NOT NULL,
  `buyer_name` varchar(100) NOT NULL,
  `quantity` int DEFAULT '1',
  `purchase_date` date NOT NULL,
  `amount_per_piece` decimal(15,2) NOT NULL,
  `price` decimal(30,2) NOT NULL,
  `gst_percentage` int NOT NULL,
  `tax_amount` decimal(20,2) NOT NULL,
  `total_price` decimal(20,2) NOT NULL,
  `return_policy` tinyint(1) DEFAULT '1',
  `is_hide` int DEFAULT '0',
  PRIMARY KEY (`transaction_id`),
  KEY `product_id` (`product_id`),
  KEY `buyer_id` (`buyer_id`),
  CONSTRAINT `transactions_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`),
  CONSTRAINT `transactions_ibfk_2` FOREIGN KEY (`buyer_id`) REFERENCES `buyer` (`UserName`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transactions`
--

LOCK TABLES `transactions` WRITE;
/*!40000 ALTER TABLE `transactions` DISABLE KEYS */;
INSERT INTO `transactions` VALUES (1,19,'Laptop','Amit_271','Amit Sharma',1,'2023-06-22',34999.00,34999.00,7,2449.93,37448.93,1,1),(2,2,'Leather Wallet','Amit_271','Amit Sharma',1,'2023-06-22',499.50,499.50,5,24.98,524.48,1,1),(3,2,'Leather Wallet','Amit_271','Amit Sharma',1,'2023-06-22',499.50,499.50,5,24.98,524.48,1,1),(4,2,'Leather Wallet','Amit_271','Amit Sharma',1,'2023-06-22',499.50,499.50,5,24.98,524.48,1,1),(5,36,'Home Decorative Cushions','Amit_271','Amit Sharma',1,'2023-06-22',249.50,249.50,12,29.94,279.44,1,1),(6,1,'Silk Saree','Amit_271','Amit Sharma',1,'2023-06-22',2999.99,2999.99,5,150.00,3149.99,1,1),(7,2,'Leather Wallet','Amit_271','Amit Sharma',1,'2023-06-22',499.50,499.50,5,24.98,524.48,0,1);
/*!40000 ALTER TABLE `transactions` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-22  6:14:44
