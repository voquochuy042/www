-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               11.1.2-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.3.0.6589
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for shopping
CREATE DATABASE IF NOT EXISTS `shopping` /*!40100 DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci */;
USE `shopping`;

-- Dumping structure for table shopping.customer
CREATE TABLE IF NOT EXISTS `customer` (
  `cust_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `phone` varchar(15) DEFAULT NULL,
  `cust_name` varchar(150) DEFAULT NULL,
  `email` varchar(150) DEFAULT NULL,
  `address` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`cust_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table shopping.customer: ~9 rows (approximately)
DELETE FROM `customer`;
INSERT INTO `customer` (`cust_id`, `phone`, `cust_name`, `email`, `address`) VALUES
	(2, '0123-567-987', 'Hoang Van A', ' maithib@email.com', '                                                                456 Elm St, City B, State Y, 54321\r\n                            \r\n                            '),
	(3, '0123-567-987', 'Mai Thi B', 'bob.johnson@example.com', '789 Oak St, City C, State Z, 67890'),
	(4, '0123-567-987', 'Trung Nguyen C', 'trungnguyenc@email.com', '321 Birch St, City D, State W, 13579'),
	(5, '0123-567-987', 'Thao Le D', 'thaoled@email.com', '987 Pine St, City E, State V, 24680'),
	(6, '0123-567-987', 'Nam Pham E', 'namphame@email.com', '654 Cedar St, City F, State U, 86420'),
	(7, '0123-567-987', 'Linh Nguyen F', 'linhnguyenf@email.com', '222 Maple St, City G, State T, 97531'),
	(8, '0123-567-987', ' Tuan Tran G', 'tuantrang@email.com', '888 Redwood St, City H, State S, 46801'),
	(9, '0123-567-987', 'Thuy Nguyen K', 'hanhhoangh@email.com', '555 Sequoia St, City I, State R, 35790'),
	(10, '0123-567-987', 'Sarah Adams', 'thuynguyenk@email.com', '777 Spruce St, City J, State Q, 15973');

-- Dumping structure for table shopping.employee
CREATE TABLE IF NOT EXISTS `employee` (
  `status` int(11) DEFAULT NULL,
  `dob` datetime(6) DEFAULT NULL,
  `emp_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `phone` varchar(15) DEFAULT NULL,
  `email` varchar(150) DEFAULT NULL,
  `full_name` varchar(150) DEFAULT NULL,
  `address` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`emp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table shopping.employee: ~11 rows (approximately)

INSERT INTO `employee` (`status`, `dob`, `emp_id`, `phone`, `email`, `full_name`, `address`) VALUES
    (0, '2002-09-10 00:00:00.000000', 1, '0123-456-789', 'nguyenthanhha@example.com', 'Nguyen Thanh Ha', '123 Mai Lao Bang P13,Quan Tan Binh'),
    (-1, '1999-05-20 00:00:00.000000', 2, '0123-456-789', 'leminhtuan@example.com', 'Le Minh Tuan', ' 456 Elm St Thanh Pho Ho Chi Minh'),
    (1, '1992-11-10 00:00:00.000000', 3, '0123-456-789', 'trannocanh@example.com', 'Tran Ngoc Anh', ' 789 Oak St Quan Go Vap SO 4'),
    (1, '1988-07-03 17:45:00.000000', 4, '0123-456-789', 'phamhonglinh@example.com', 'Pham Hong Linh', '101 Pine St'),
    (1, '1995-03-28 10:20:00.000000', 5, '0123-456-789', 'vuthibaotram@example.com', 'Vu Thi Bao Tram', '202 Cedar St'),
    (1, '1987-09-05 16:10:00.000000', 6, '0123-456-789', 'hoangvanhung@example.com', 'Hoang Van Hung', '303 Maple St'),
    (1, '1993-12-18 08:45:00.000000', 7, '0123-456-789', 'dothilananh@example.com', 'Do Thi Lan Anh', '404 Birch St'),
    (1, '1997-06-12 11:30:00.000000', 8, '0123-456-789', 'ngoquangminh@example.com', 'Ngo Quang Minh', '505 Walnut St'),
    (1, '1986-04-22 13:25:00.000000', 9, '0123-456-789', 'maihongnhung@example.com', 'Mai Hong Nhung', '606 Ash St'),
    (1, '1994-08-29 15:50:00.000000', 10, '0123-456-789', 'trinhvanduc@example.com', 'Trinh Van Duc', '707 Spruce St'),
    (1, '2023-09-15 00:00:00.000000', 11, '0123-456-789', 'nguyenvanan@example.com', 'Nguyen Van An', 'b');

-- Dumping structure for table shopping.orders
CREATE TABLE IF NOT EXISTS `orders` (
  `cust_id` bigint(20) DEFAULT NULL,
  `emp_id` bigint(20) DEFAULT NULL,
  `order_date` datetime(6) DEFAULT NULL,
  `order_id` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`order_id`),
  KEY `FK4fsf94p5k9yr5hov1frq86i4u` (`cust_id`),
  KEY `FKpd24pnaws1e3ibjjfphaas21o` (`emp_id`),
  CONSTRAINT `FK4fsf94p5k9yr5hov1frq86i4u` FOREIGN KEY (`cust_id`) REFERENCES `customer` (`cust_id`),
  CONSTRAINT `FKpd24pnaws1e3ibjjfphaas21o` FOREIGN KEY (`emp_id`) REFERENCES `employee` (`emp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=135 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table shopping.orders: ~15 rows (approximately)
DELETE FROM `orders`;
INSERT INTO `orders` (`cust_id`, `emp_id`, `order_date`, `order_id`) VALUES
	(9, 2, '2023-11-22 22:04:54.769059', 20),
	(5, 7, '2023-11-22 22:27:27.782549', 21),
	(6, 5, '2023-11-24 11:56:33.232932', 22),
	(9, 8, '2023-11-24 11:58:30.118788', 23),
	(9, 9, '2023-11-24 13:29:42.789215', 124),
	(6, 1, '2023-11-24 13:30:14.964672', 125),
	(4, 5, '2023-11-24 13:30:35.785197', 126),
	(6, 10, '2023-11-24 13:31:08.714131', 127),
	(4, 2, '2023-11-24 13:31:46.179359', 128),
	(7, 8, '2023-11-24 13:32:31.257112', 129),
	(5, 1, '2023-11-24 13:33:06.251398', 130),
	(3, 4, '2023-11-24 13:33:40.721844', 131),
	(2, 9, '2023-11-24 13:34:22.241396', 132),
	(8, 7, '2023-11-24 13:40:01.732590', 133),
	(9, 3, '2023-11-24 13:42:24.892311', 134);

-- Dumping structure for table shopping.order_detail
CREATE TABLE IF NOT EXISTS `order_detail` (
  `price` double NOT NULL,
  `quantity` double NOT NULL,
  `order_id` bigint(20) NOT NULL,
  `product_id` bigint(20) NOT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`order_id`,`product_id`),
  KEY `FKexyb4mccotvu7p3x6pga6j5h7` (`product_id`),
  CONSTRAINT `FKexyb4mccotvu7p3x6pga6j5h7` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`),
  CONSTRAINT `FKrws2q0si6oyd6il8gqe2aennc` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table shopping.order_detail: ~38 rows (approximately)
DELETE FROM `order_detail`;
INSERT INTO `order_detail` (`price`, `quantity`, `order_id`, `product_id`, `note`) VALUES
	(4800, 3, 20, 1, 'Order Complete'),
	(6000, 3, 20, 3, 'Order Complete'),
	(4000, 2, 21, 3, 'Order Complete'),
	(3300, 3, 21, 4, 'Order Complete'),
	(1200, 3, 21, 6, 'Order Complete'),
	(9600, 6, 22, 1, 'Order Complete'),
	(10000, 5, 22, 3, 'Order Complete'),
	(3300, 3, 23, 4, 'Order Complete'),
	(2550, 3, 23, 5, 'Order Complete'),
	(1600, 4, 23, 6, 'Order Complete'),
	(8000, 4, 124, 3, 'Order Complete'),
	(2000, 5, 124, 6, 'Order Complete'),
	(3200, 2, 125, 1, 'Order Complete'),
	(2000, 5, 125, 6, 'Order Complete'),
	(3600, 3, 125, 7, 'Order Complete'),
	(1200, 3, 126, 6, 'Order Complete'),
	(850, 1, 127, 5, 'Order Complete'),
	(2100, 3, 127, 8, 'Order Complete'),
	(1200, 4, 127, 9, 'Order Complete'),
	(6000, 3, 128, 3, 'Order Complete'),
	(2800, 7, 128, 6, 'Order Complete'),
	(3600, 3, 128, 7, 'Order Complete'),
	(16000, 8, 129, 3, 'Order Complete'),
	(3400, 4, 129, 5, 'Order Complete'),
	(2000, 5, 129, 6, 'Order Complete'),
	(6000, 5, 129, 7, 'Order Complete'),
	(8000, 4, 130, 3, 'Order Complete'),
	(3300, 3, 130, 4, 'Order Complete'),
	(7800, 6, 130, 10, 'Order Complete'),
	(8000, 4, 131, 3, 'Order Complete'),
	(1600, 4, 131, 6, 'Order Complete'),
	(7200, 6, 131, 7, 'Order Complete'),
	(3900, 13, 132, 9, 'Order Complete'),
	(11700, 9, 132, 10, 'Order Complete'),
	(8000, 5, 133, 1, 'Order Complete'),
	(10000, 5, 133, 3, 'Order Complete'),
	(17600, 11, 134, 1, 'Order Complete'),
	(22800, 12, 134, 2, 'Order Complete');

-- Dumping structure for table shopping.product
CREATE TABLE IF NOT EXISTS `product` (
  `status` int(11) DEFAULT NULL CHECK (`status` between -1 and 1),
  `product_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `unit` varchar(25) DEFAULT NULL,
  `manufacturer_name` varchar(100) DEFAULT NULL,
  `name` varchar(150) DEFAULT NULL,
  `description` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table shopping.product: ~10 rows (approximately)
DELETE FROM `product`;
INSERT INTO `product` (`status`, `product_id`, `unit`, `manufacturer_name`, `name`, `description`) VALUES
	(1, 1, 'Cai', 'Chính hãng Apple', 'iPhone 11 64GB', 'Chính hãng Apple Việt Nam'),
	(1, 2, 'Cai', 'Chính hãng Apple', 'MacBook Pro M2 Chính Hãng', 'Chính hãng Apple Việt Nam'),
	(1, 3, 'Cai', 'Chính hãng Apple', 'iPad 9 WiFi', 'Chính hãng Apple Việt Nam'),
	(1, 4, 'Cai', 'Lenovo', 'Laptop Lenovo IdeaPad 3', 'Chính hãng Apple Việt Nam'),
	(1, 5, 'Cai', 'Lenovo', 'Laptop Lenovo Yoga Slim 7 Pro', 'Chính hãng Apple Việt Nam'),
	(1, 6, 'Cai', 'Chính hãng Apple', 'Apple Macbook Air M2 2022 8GB 256GB', 'Chính hãng Apple Việt Nam'),
	(1, 7, 'Cai', 'Chính hãng Apple', 'Laptop Asus VivoBook Go 14', 'Chính hãng Apple Việt Nam'),
	(1, 8, 'Cai', 'Chính hãng Apple', 'Apple Macbook Air M2 2022 16GB 256GB ', 'Chính hãng Apple Việt Nam'),
	(1, 9, 'Cai', 'Valorant', 'Valorant', 'Chính hãng Apple Việt Nam'),
	(1, 10, 'Cai', 'Valorant', 'Valorant', 'Chính hãng Apple Việt Nam');

-- Dumping structure for table shopping.product_image
CREATE TABLE IF NOT EXISTS `product_image` (
  `image_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) DEFAULT NULL,
  `alternative` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`image_id`),
  KEY `FK8pjxf5wdhewnyb99b6a6bwp4` (`product_id`),
  CONSTRAINT `FK8pjxf5wdhewnyb99b6a6bwp4` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table shopping.product_image: ~10 rows (approximately)
DELETE FROM `product_image`;
INSERT INTO `product_image` (`image_id`, `product_id`, `alternative`, `path`) VALUES
	(1, 1, 'iPhone 11 64GB', 'product_img_1.jpg'),
	(2, 2, 'MacBook Pro M2 Chính Hãng', 'product_img_2.jpg'),
	(3, 3, 'iPad 9 WiFi', 'product_img_3.jpg'),
	(4, 4, 'Laptop Lenovo IdeaPad 3', 'product_img_4.jpg'),
	(5, 5, 'Laptop Lenovo Yoga Slim 7 Pro', 'product_img_5.jpg'),
	(6, 6, 'Image 2 Alt', 'product_img_6.jpg'),
	(7, 7, 'Image 1 Alt', 'product_img_7.jpg'),
	(8, 8, 'Image 2 Alt', 'product_img_8.jpg'),
	(9, 9, 'Image 1 Alt', 'product_img_9.jpg'),
	(10, 10, 'Image 2 Alt', 'product_img_10.jpg');

-- Dumping structure for table shopping.product_price
CREATE TABLE IF NOT EXISTS `product_price` (
  `price` double NOT NULL,
  `price_date_time` datetime(6) NOT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`price_date_time`),
  KEY `FK9gx3vor0wn8fegbmk6rv7ba7w` (`product_id`),
  CONSTRAINT `FK9gx3vor0wn8fegbmk6rv7ba7w` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table shopping.product_price: ~20 rows (approximately)
DELETE FROM `product_price`;
INSERT INTO `product_price` (`price`, `price_date_time`, `product_id`, `note`) VALUES
	(8300, '2020-09-07 19:56:58.000000', 7, 'Price increase'),
	(900, '2021-01-28 14:56:58.000000', 2, 'Price decrease'),
	(600, '2021-05-29 15:56:58.000000', 2, 'New product price'),
	(1200, '2021-07-25 19:56:58.000000', 1, 'Price increase'),
	(1300, '2021-09-07 14:56:58.000000', 10, 'Price increase'),
	(1200, '2021-09-22 14:56:58.000000', 7, 'Price increase'),
	(500, '2021-10-05 15:56:58.000000', 4, 'New product price'),
	(1500, '2021-10-29 18:56:58.000000', 2, 'New product price'),
	(800, '2022-09-20 14:56:58.000000', 5, 'Price decrease'),
	(1100, '2022-09-21 14:56:58.000000', 4, 'Price increase'),
	(1900, '2022-09-22 16:56:58.000000', 1, 'Price increase'),
	(300, '2022-10-05 14:56:58.000000', 9, 'New product price'),
	(500, '2022-10-25 14:56:58.000000', 3, 'New product price'),
	(2000, '2022-12-24 14:56:58.000000', 3, 'Price decrease'),
	(850, '2023-08-22 15:56:58.000000', 5, 'Price decrease'),
	(400, '2023-09-19 14:56:58.000000', 6, 'New product price'),
	(1000, '2023-09-28 14:56:58.000000', 1, 'Price increase'),
	(1600, '2023-09-29 16:56:58.000000', 1, 'Price increase'),
	(700, '2023-11-21 14:56:58.000000', 8, 'Price decrease'),
	(1900, '2023-12-29 17:56:58.000000', 2, 'Price decrease');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
