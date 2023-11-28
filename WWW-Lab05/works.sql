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


-- Dumping database structure for works
CREATE DATABASE IF NOT EXISTS `works` /*!40100 DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci */;
USE `works`;

-- Dumping structure for table works.address
CREATE TABLE IF NOT EXISTS `address` (
  `add_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `city` varchar(50) DEFAULT NULL,
  `country` smallint(6) DEFAULT NULL CHECK (`country` between 0 and 271),
  `number` varchar(20) DEFAULT NULL,
  `street` varchar(150) DEFAULT NULL,
  `zipcode` varchar(7) DEFAULT NULL,
  PRIMARY KEY (`add_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table works.address: ~21 rows (approximately)
DELETE FROM `address`;
INSERT INTO `address` (`add_id`, `city`, `country`, `number`, `street`, `zipcode`) VALUES
	(1, 'South Vicentestad', 1, '7658', '28976 Jill Flat', '95426'),
	(2, 'North Vaniaberg', 1, '75458', '28242 Aron Shores', '99387'),
	(3, 'Langoshstad', 1, '426', '33834 Pfeffer Courts', '23922'),
	(4, 'South Teri', 1, '87892', '33667 Mariano Valleys', '10152'),
	(5, 'Deandreahaven', 1, '53361', '32960 Anibal Road', '44748'),
	(6, 'Metzport', 1, '93763', '74962 O\'Connell Inlet', '56431'),
	(7, 'Lake Jamaalmouth', 1, '9448', '619 Frami Ferry', '18783'),
	(8, 'Jeraldineberg', 1, '21353', '3207 Koepp Neck', '94907'),
	(9, 'New Marlystown', 1, '958', '28897 Juliane Gardens', '37914'),
	(10, 'South Orville', 1, '139', '4001 Aufderhar Mountain', '79233'),
	(11, 'Alvafort', 1, '565', '00624 Stanton Walks', '70057'),
	(12, 'South Roy', 1, '8675', '85115 Kshlerin Radial', '83883'),
	(13, 'Schambergerfurt', 1, '44760', '92971 Evonne Radial', '52863'),
	(14, 'Caseyton', 1, '40207', '4486 Shaun Green', '58390'),
	(15, 'Port Jan', 1, '299', '867 Altenwerth Burg', '81313'),
	(16, 'Gibsonview', 1, '29844', '995 Lang Neck', '39220'),
	(17, 'Gerholdstad', 1, '09164', '755 Renita Common', '97921'),
	(18, 'West Claudie', 1, '227', '284 Osinski Trafficway', '61045'),
	(19, 'Welchbury', 1, '950', '3027 Tremblay Stream', '04721'),
	(20, 'East Antonetta', 1, '941', '048 Luvenia Mill', '43302'),
	(21, 'HCM', 258, '23/27', 'Mai Lao bang', '08124');

-- Dumping structure for table works.candidate
CREATE TABLE IF NOT EXISTS `candidate` (
  `can_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dob` date NOT NULL,
  `email` varchar(255) NOT NULL,
  `full_name` varchar(255) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `add_id` bigint(20) NOT NULL,
  PRIMARY KEY (`can_id`),
  UNIQUE KEY `UK_qfut8ruekode092nlkipgl09g` (`email`),
  UNIQUE KEY `UK_9i5yt1gvm0chg5e10qkns7tll` (`phone`),
  UNIQUE KEY `UK_t80xy3wrb06a2a4s1su9asjt6` (`add_id`),
  CONSTRAINT `FKpp1pcm1idkj1sthlhaqm06gct` FOREIGN KEY (`add_id`) REFERENCES `address` (`add_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table works.candidate: ~20 rows (approximately)
DELETE FROM `candidate`;
INSERT INTO `candidate` (`can_id`, `dob`, `email`, `full_name`, `phone`, `add_id`) VALUES
	(1, '1980-07-26', 'dorinda.satterfield@yahoo.com', 'Ja Crist', '937-251-0994', 1),
	(2, '1965-11-26', 'alton.padberg@gmail.com', 'Dr. Earnest Stanton', '(251) 210-2245', 2),
	(3, '1970-06-12', 'laine.ondricka@hotmail.com', 'Rudy Terry', '1-636-603-4993', 3),
	(4, '1999-07-04', 'rosaura.dickinson@gmail.com', 'Tyron Gleichner', '334.614.8812', 4),
	(5, '1962-01-07', 'sanjuanita.rutherford@hotmail.com', 'Meda Toy', '1-337-573-0730', 5),
	(6, '1995-08-28', 'alpha.paucek@gmail.com', 'Dona Rempel', '254-610-3642', 6),
	(7, '2001-04-30', 'morgan.howell@hotmail.com', 'Richard Cummings', '423-724-6948', 7),
	(8, '1975-07-08', 'glen.schinner@yahoo.com', 'Concepcion Raynor', '917.646.5198', 8),
	(9, '1984-09-17', 'yetta.stamm@yahoo.com', 'Gene Rosenbaum', '256-704-8938', 9),
	(10, '1990-05-01', 'cathryn.lebsack@hotmail.com', 'Dewitt Shields', '1-253-770-8896', 10),
	(11, '1964-04-03', 'jaime.koepp@yahoo.com', 'Augustus Schaden', '229.616.4319', 11),
	(12, '1966-04-01', 'shaunta.prosacco@gmail.com', 'Dr. Doyle Prosacco', '541.940.4249', 12),
	(13, '1986-04-12', 'cyrus.macgyver@yahoo.com', 'Ike Kiehn', '704.859.7352', 13),
	(14, '1997-06-24', 'donte.bernier@yahoo.com', 'Leopoldo Mann', '1-479-775-5731', 14),
	(15, '1974-06-13', 'shelley.satterfield@gmail.com', 'Erick Crona MD', '1-567-856-6513', 15),
	(16, '2003-04-09', 'dillon.goldner@hotmail.com', 'Ilana McLaughlin', '614-603-3430', 16),
	(17, '1975-03-26', 'nell.bogisich@gmail.com', 'Neta Thiel V', '(940) 806-9097', 17),
	(18, '1965-09-24', 'hortensia.macejkovic@gmail.com', 'Rana Willms', '231-408-3870', 18),
	(19, '1985-02-03', 'houston.blick@yahoo.com', 'Mr. Benito Koss', '308-518-8613', 19),
	(20, '1986-07-21', 'taina.hickle@gmail.com', 'Cathy Wiza', '(731) 914-0960', 20),
	(22, '2012-01-09', 'aaa@gmail.com', '', '01414142512', 21);

-- Dumping structure for table works.candidate_skill
CREATE TABLE IF NOT EXISTS `candidate_skill` (
  `can_id` bigint(20) NOT NULL,
  `skill_id` bigint(20) NOT NULL,
  `more_infos` varchar(1000) DEFAULT NULL,
  `skill_level` tinyint(4) NOT NULL CHECK (`skill_level` between 0 and 4),
  PRIMARY KEY (`can_id`,`skill_id`),
  KEY `FKb7cxhiqhcah7c20a2cdlvr1f8` (`skill_id`),
  CONSTRAINT `FKb0m5tm3fi0upa3b3kjx3vrlxs` FOREIGN KEY (`can_id`) REFERENCES `candidate` (`can_id`),
  CONSTRAINT `FKb7cxhiqhcah7c20a2cdlvr1f8` FOREIGN KEY (`skill_id`) REFERENCES `skill` (`skill_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table works.candidate_skill: ~0 rows (approximately)
DELETE FROM `candidate_skill`;

-- Dumping structure for table works.company
CREATE TABLE IF NOT EXISTS `company` (
  `com_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `about` varchar(2000) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `comp_name` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `web_url` varchar(255) DEFAULT NULL,
  `add_id` bigint(20) NOT NULL,
  PRIMARY KEY (`com_id`),
  UNIQUE KEY `UK_6shnfufxk9y1hav2atbeyaon2` (`add_id`),
  CONSTRAINT `FKi35520i7yexo7ftktc8157xjr` FOREIGN KEY (`add_id`) REFERENCES `address` (`add_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table works.company: ~20 rows (approximately)
DELETE FROM `company`;
INSERT INTO `company` (`com_id`, `about`, `email`, `comp_name`, `phone`, `web_url`, `add_id`) VALUES
	(1, 'Incidunt pariatur fugit ad et.', 'odilia.dach@hotmail.com', 'Swaniawski Group', '(731) 269-4485 x4966', 'https://www.soo-miller.org/eum/quo?voluptas=consequatur&quibusdam=ut', 1),
	(2, 'Harum debitis voluptatem et cum.', 'jerry.smitham@yahoo.com', 'Marks, Rodriguez and Kunde', '(269) 975-0539 x8359', 'https://www.sondra-kassulke.net:39323/?dolorem=aliquid&sit=enim', 2),
	(3, 'Fugiat voluptas consequatur aut.', 'marilu.hudson@gmail.com', 'Skiles LLC', '(309) 316-4270', 'https://www.hunter-hamill.name/molestiae/distinctio?quis=eum&rerum=officiis#optio', 3),
	(4, 'Est quo omnis neque commodi porro.', 'arie.osinski@yahoo.com', 'West Group', '(918) 510-1385 x2386', 'https://www.earl-streich.name/ut/voluptas?aut=error&atque=ut#culpa', 4),
	(5, 'Et mollitia sed ducimus mollitia voluptatem.', 'arletta.kassulke@yahoo.com', 'Mohr, Abbott and Daniel', '(925) 386-5771 x0713', 'http://www.jude-legros.info:45184/eum', 5),
	(6, 'Nemo temporibus autem ea.', 'dell.barrows@gmail.com', 'Klocko and Sons', '(386) 360-6454 x2570', 'https://www.regan-labadie.net:49485/?reiciendis=reprehenderit&ipsam=ipsa#dolor', 6),
	(7, 'Nam eaque est sapiente reiciendis.', 'dave.bogan@hotmail.com', 'Metz Group', '(253) 234-6897', 'https://www.aldo-brakus.org/est/sed#in', 7),
	(8, 'Et ea rem et ut vitae rerum quia.', 'odell.monahan@yahoo.com', 'Kozey-Ortiz', '(501) 878-2191 x3039', 'https://www.leonard-jenkins.io/optio/quibusdam?expedita=esse&qui=excepturi#perferendis', 8),
	(9, 'Ad autem et qui repellendus laborum.', 'ellsworth.king@gmail.com', 'Johns Group', '(614) 831-7153', 'https://www.normand-sipes.info:7435/?doloremque=et&fuga=ea#facere', 9),
	(10, 'Expedita consectetur dolore rerum.', 'ivory.corkery@yahoo.com', 'Powlowski-Collier', '(216) 252-2369', 'https://www.sherita-okuneva.org/voluptates/nostrum#corporis', 10),
	(11, 'Occaecati consequatur repellat aut.', 'blake.oberbrunner@gmail.com', 'Dibbert, Steuber and Keebler', '(414) 260-9860 x4180', 'https://www.andreas-lueilwitz.biz:63856/?dolor=necessitatibus&voluptates=quam#nemo', 11),
	(12, 'Molestias et at est dolores cupiditate consequatur.', 'jeana.runolfsdottir@yahoo.com', 'Heller LLC', '(720) 414-7524 x7759', 'https://www.alvin-kassulke.name:53650/', 12),
	(13, 'Aut sapiente perspiciatis non.', 'jolene.brown@yahoo.com', 'Fahey-Medhurst', '(719) 918-5876 x5086', 'https://www.mathew-ullrich.co:20939/provident/nisivero?omnis=aut&sequi=odit', 13),
	(14, 'Ut ullam quae iste modi.', 'florentino.bailey@gmail.com', 'Wolff, Schultz and Okuneva', '(832) 305-6062 x4715', 'https://www.emilio-hartmann.co:1253/et/repudiandae', 14),
	(15, 'A id iusto esse dolorem necessitatibus beatae.', 'howard.morissette@hotmail.com', 'Schmidt, Douglas and Fay', '(479) 978-8157', 'https://www.leilani-greenholt.io:62962/?aut=est&dolor=libero', 15),
	(16, 'Consequatur eligendi autem sit.', 'judson.mueller@gmail.com', 'Wolff-Weissnat', '(606) 308-5731', 'https://www.sarah-mayert.co/#laboriosam', 16),
	(17, 'Quas quod ducimus quis laudantium dolor modi quia.', 'anissa.bartell@hotmail.com', 'Dare Group', '(650) 737-7669 x5096', 'http://www.bobby-mosciski.name:46940/qui/porroporro?quod=voluptates&expedita=ut', 17),
	(18, 'Esse ut consequatur temporibus quas voluptas.', 'myrna.schmidt@gmail.com', 'Gislason-Emard', '(240) 989-8598 x8334', 'http://www.eliz-botsford.biz/inventore/ex#ut', 18),
	(19, 'Est voluptatem sed dolore.', 'chang.maggio@hotmail.com', 'Paucek Group', '(210) 254-9926 x5511', 'https://www.adolph-bauch.net/quidem/commodi#eius', 19),
	(20, 'Consequatur qui et inventore rem doloribus.', 'latonya.ritchie@yahoo.com', 'Purdy, Boehm and Boyer', '(870) 417-1409 x9071', 'https://www.seth-glover.org/mollitia', 20);

-- Dumping structure for table works.experience
CREATE TABLE IF NOT EXISTS `experience` (
  `exp_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `company` varchar(120) NOT NULL,
  `from_date` date NOT NULL,
  `role` varchar(100) NOT NULL,
  `to_date` date NOT NULL,
  `work_desc` varchar(400) NOT NULL,
  `can_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`exp_id`),
  KEY `FK8d5oqe0wxh52v352i04qnuady` (`can_id`),
  CONSTRAINT `FK8d5oqe0wxh52v352i04qnuady` FOREIGN KEY (`can_id`) REFERENCES `candidate` (`can_id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table works.experience: ~60 rows (approximately)
DELETE FROM `experience`;
INSERT INTO `experience` (`exp_id`, `company`, `from_date`, `role`, `to_date`, `work_desc`, `can_id`) VALUES
	(1, 'Stamm-Stroman', '2023-04-09', 'National Healthcare Specialist', '2023-05-02', 'Dolor rem non.', 1),
	(2, 'Smith, Bayer and Kreiger', '2023-07-16', 'Customer Producer', '2023-07-20', 'Minus commodi soluta rerum hic.', 2),
	(3, 'Moore-Hammes', '2023-07-20', 'International Planner', '2023-08-13', 'Repellat corrupti ex quasi beatae officia.', 3),
	(4, 'McDermott-Dickens', '2023-06-30', 'National Officer', '2023-07-17', 'In excepturi placeat molestiae dolor inventore autem et.', 4),
	(5, 'Kunze, Bednar and Ruecker', '2023-01-05', 'Forward Design Assistant', '2023-01-07', 'Voluptate velit culpa provident optio corporis.', 5),
	(6, 'Padberg-Kshlerin', '2023-08-11', 'Future Coordinator', '2023-09-06', 'Aut consequuntur porro vel iste est modi quas.', 6),
	(7, 'Kub-Stokes', '2023-11-04', 'Future Assistant', '2023-11-27', 'Id doloribus et odit voluptatum placeat corporis asperiores.', 7),
	(8, 'Farrell Group', '2023-07-21', 'Legacy Developer', '2023-08-06', 'Necessitatibus aut eius dolores quia ut consequatur.', 8),
	(9, 'Fisher, Greenfelder and Mertz', '2023-04-11', 'Global Representative', '2023-04-24', 'Et debitis et quam.', 9),
	(10, 'Halvorson, Bins and White', '2023-04-08', 'Lead Associate', '2023-04-26', 'Aperiam qui quis odit dolorem harum sunt.', 10),
	(11, 'O\'Keefe, Heathcote and McGlynn', '2022-12-22', 'Product Legal Consultant', '2023-01-06', 'Id ut officiis autem vel odit non.', 11),
	(12, 'Stoltenberg-Stamm', '2023-08-04', 'Hospitality Strategist', '2023-08-22', 'Quo occaecati itaque assumenda cum sint animi.', 12),
	(13, 'Greenfelder-Veum', '2023-10-05', 'Administration Supervisor', '2023-10-24', 'Quia expedita ad nobis porro.', 13),
	(14, 'Corwin Inc', '2023-09-15', 'Dynamic Construction Consultant', '2023-09-28', 'Ab qui odio eos ratione.', 14),
	(15, 'Kuhic-Maggio', '2023-08-30', 'Human Technology Analyst', '2023-09-19', 'Ut officia et.', 15),
	(16, 'Stroman-Roob', '2023-05-24', 'Construction Coordinator', '2023-05-28', 'Repellat nemo distinctio ea.', 16),
	(17, 'McKenzie and Sons', '2023-08-24', 'Community-Services Consultant', '2023-09-03', 'Alias quia dolore quia accusamus.', 17),
	(18, 'Greenfelder Inc', '2023-08-22', 'Central Producer', '2023-09-05', 'Nemo qui eligendi expedita.', 18),
	(19, 'Dare, Hill and O\'Kon', '2023-06-11', 'Product Community-Services Supervisor', '2023-06-15', 'Sit eos atque harum illum molestias dolorum.', 19),
	(20, 'Bartoletti LLC', '2022-12-06', 'Healthcare Technician', '2022-12-21', 'Voluptas ea ut vel sed blanditiis inventore nostrum.', 20),
	(21, 'Lockman-Treutel', '2022-12-11', 'Customer Accounting Consultant', '2022-12-29', 'Voluptate quibusdam iste magni veniam qui laboriosam sapiente.', 1),
	(22, 'Hodkiewicz and Sons', '2023-08-15', 'Marketing Officer', '2023-09-13', 'Maiores in hic laboriosam possimus consequuntur voluptatem.', 2),
	(23, 'Haley-Murphy', '2022-12-11', 'Global Banking Assistant', '2022-12-23', 'Dolore dolor porro.', 3),
	(24, 'Altenwerth and Sons', '2023-09-20', 'Administration Assistant', '2023-10-15', 'Minima totam labore.', 4),
	(25, 'Dietrich, Harvey and Batz', '2023-07-19', 'Corporate Planner', '2023-07-20', 'Fuga aspernatur molestias molestiae exercitationem.', 5),
	(26, 'Sanford, Paucek and Bode', '2023-07-18', 'Marketing Engineer', '2023-08-02', 'Velit voluptatem nobis ex numquam amet vitae.', 6),
	(27, 'Green-Schuster', '2023-10-19', 'Product Executive', '2023-11-17', 'Magnam maiores nobis accusamus id illo explicabo explicabo.', 7),
	(28, 'Purdy, Zulauf and Dare', '2023-06-21', 'IT Technician', '2023-06-22', 'Voluptatem eos corporis quo enim voluptates.', 8),
	(29, 'Schimmel-Rutherford', '2023-11-01', 'Forward Hospitality Consultant', '2023-11-13', 'Vero similique velit ex inventore laboriosam.', 9),
	(30, 'Kunze, White and Kautzer', '2023-07-24', 'Senior Administration Specialist', '2023-07-31', 'Odit blanditiis labore.', 10),
	(31, 'Mann, Mertz and Schneider', '2023-06-17', 'Corporate Marketing Consultant', '2023-07-07', 'Aut unde ratione.', 11),
	(32, 'Hettinger-Farrell', '2023-04-12', 'Legacy IT Agent', '2023-04-28', 'Voluptatibus et aliquid et quia enim.', 12),
	(33, 'Von Group', '2023-02-10', 'Retail Director', '2023-02-22', 'Qui animi consequatur.', 13),
	(34, 'Blick Group', '2023-02-23', 'Dynamic Accounting Strategist', '2023-03-07', 'Provident totam quasi atque ut sapiente.', 14),
	(35, 'Homenick-Weissnat', '2023-04-22', 'Senior Supervisor', '2023-05-19', 'Voluptates voluptatibus ipsa voluptatem id id voluptas.', 15),
	(36, 'O\'Reilly, Mitchell and Fadel', '2023-05-12', 'Direct Architect', '2023-05-27', 'Aut et ut ea molestias et.', 16),
	(37, 'Moen Inc', '2023-05-12', 'District Supervisor', '2023-05-16', 'Laborum sequi autem.', 17),
	(38, 'Russel-Blanda', '2023-05-31', 'Hospitality Planner', '2023-06-29', 'Et repudiandae culpa ex provident est tempore at.', 18),
	(39, 'Kemmer, Treutel and Kessler', '2023-07-28', 'Direct Mining Supervisor', '2023-08-09', 'Voluptatibus repellendus sed dicta rem quas enim.', 19),
	(40, 'Schmitt Group', '2023-09-07', 'Healthcare Orchestrator', '2023-09-14', 'Sint pariatur repellendus nesciunt ut aut non.', 20),
	(41, 'Rosenbaum, Powlowski and Casper', '2022-12-14', 'Education Producer', '2023-01-10', 'Est voluptates libero ipsum sint.', 1),
	(42, 'Yundt, Mohr and Keebler', '2023-05-01', 'Forward Banking Designer', '2023-05-07', 'Hic qui et rerum eligendi.', 2),
	(43, 'Koelpin Inc', '2022-11-29', 'Accounting Executive', '2022-12-01', 'In et consequatur quam quia ipsa sed.', 3),
	(44, 'Lockman-Connelly', '2023-06-13', 'Legacy Engineer', '2023-06-17', 'Excepturi quis sit eos quo magnam possimus unde.', 4),
	(45, 'Barton-Hane', '2022-12-31', 'Community-Services Developer', '2023-01-13', 'Velit corrupti natus ullam non.', 5),
	(46, 'Hamill, Conn and Russel', '2023-02-28', 'Central Designer', '2023-03-17', 'Eveniet dolores quod.', 6),
	(47, 'Koepp LLC', '2023-03-15', 'Legacy Marketing Facilitator', '2023-03-22', 'Cumque illum quod adipisci.', 7),
	(48, 'Mante-Lang', '2023-05-20', 'Global Manufacturing Facilitator', '2023-05-28', 'Sed ut velit iusto alias at incidunt.', 8),
	(49, 'Bode Group', '2023-06-13', 'Sales Executive', '2023-07-05', 'Mollitia omnis velit repellendus aliquid molestiae.', 9),
	(50, 'Pacocha Inc', '2023-01-25', 'Dynamic Marketing Analyst', '2023-01-30', 'Non animi delectus ut.', 10),
	(51, 'Gutkowski Group', '2023-06-06', 'Advertising Administrator', '2023-06-13', 'In doloribus iure eaque.', 11),
	(52, 'Kautzer Group', '2023-06-05', 'Technology Consultant', '2023-06-28', 'Omnis velit quia.', 12),
	(53, 'Abernathy-Gulgowski', '2023-02-08', 'Senior Legal Coordinator', '2023-02-18', 'A impedit rerum qui dolores perspiciatis quo.', 13),
	(54, 'Hermann LLC', '2023-02-19', 'Forward Construction Representative', '2023-03-20', 'Vitae est ut.', 14),
	(55, 'Buckridge-Little', '2023-01-18', 'Community-Services Architect', '2023-01-26', 'Beatae dignissimos tempore autem exercitationem sunt.', 15),
	(56, 'Marks Group', '2023-05-09', 'Direct Accounting Representative', '2023-05-21', 'Aliquid quasi ipsum et nulla velit ad.', 16),
	(57, 'Sawayn-Douglas', '2023-01-22', 'Regional Developer', '2023-01-25', 'Tempore aut magni laborum.', 17),
	(58, 'Ryan, Hyatt and Kub', '2023-01-20', 'National Administration Coordinator', '2023-02-12', 'Rerum quos dolores nulla enim quia.', 18),
	(59, 'Nicolas, Reinger and Bins', '2023-10-11', 'Marketing Planner', '2023-10-22', 'Ad ut voluptatum consequatur nulla.', 19),
	(60, 'Considine-Bailey', '2023-11-16', 'Marketing Agent', '2023-11-27', 'Perspiciatis laboriosam velit et.', 20);

-- Dumping structure for table works.job
CREATE TABLE IF NOT EXISTS `job` (
  `job_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `job_desc` varchar(2000) NOT NULL,
  `job_name` varchar(255) NOT NULL,
  `com_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`job_id`),
  KEY `FKexhlpi1dtnhxnftqe4udd1ucg` (`com_id`),
  CONSTRAINT `FKexhlpi1dtnhxnftqe4udd1ucg` FOREIGN KEY (`com_id`) REFERENCES `company` (`com_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table works.job: ~20 rows (approximately)
DELETE FROM `job`;
INSERT INTO `job` (`job_id`, `job_desc`, `job_name`, `com_id`) VALUES
	(1, 'Administration', 'Banking Technician', 1),
	(2, 'Build UI', 'Front-end DEV', 2),
	(3, 'Consulting', 'IT Officer', 3),
	(4, 'Manufacturing', 'Manufacturing Supervisor', 4),
	(5, 'Government', 'Senior Producer', 5),
	(6, 'Build UI', 'Front-end DEV', 6),
	(7, 'Marketing', 'Principal Producer', 7),
	(8, 'Legal', 'IT Planner', 8),
	(9, 'Hospitality', 'Future Manufacturing Supervisor', 9),
	(10, 'Healthcare', 'Product Representative', 10),
	(11, 'Real-Estate', 'Corporate Agent', 11),
	(12, 'Consulting', 'Central Manufacturing Director', 12),
	(13, 'Technology', 'Sales Architect', 13),
	(14, 'IT', 'Corporate Banking Specialist', 14),
	(15, 'Community-Services', 'Internal Manufacturing Liaison', 15),
	(16, 'Legal', 'National Community-Services Facilitator', 16),
	(17, 'Real-Estate', 'Forward IT Orchestrator', 17),
	(18, 'Education', 'Community-Services Liaison', 18),
	(19, 'Accounting', 'District Education Liaison', 19),
	(20, 'Mining', 'Accounting Manager', 20);

-- Dumping structure for table works.job_skill
CREATE TABLE IF NOT EXISTS `job_skill` (
  `job_id` bigint(20) NOT NULL,
  `skill_id` bigint(20) NOT NULL,
  `more_infos` varchar(1000) DEFAULT NULL,
  `skill_level` tinyint(4) DEFAULT NULL CHECK (`skill_level` between 1 and 5),
  PRIMARY KEY (`job_id`,`skill_id`),
  KEY `FKj33qbbf3vk1lvhqpcosnh54u1` (`skill_id`),
  CONSTRAINT `FK9ix4wg520ii2gu2felxdhdup6` FOREIGN KEY (`job_id`) REFERENCES `job` (`job_id`),
  CONSTRAINT `FKj33qbbf3vk1lvhqpcosnh54u1` FOREIGN KEY (`skill_id`) REFERENCES `skill` (`skill_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table works.job_skill: ~40 rows (approximately)
DELETE FROM `job_skill`;
INSERT INTO `job_skill` (`job_id`, `skill_id`, `more_infos`, `skill_level`) VALUES
	(2, 3, 'Nunc sed orci lobortis augue scelerisque mollis. Phasellus libero mauris,', 1),
	(3, 2, 'nunc sit amet metus. Aliquam erat volutpat. Nulla facilisis. Suspendisse', 4),
	(3, 14, 'eleifend non, dapibus rutrum, justo. Praesent luctus. Curabitur egestas nunc', 1),
	(4, 12, 'vulputate eu, odio. Phasellus at augue id ante dictum cursus.', 4),
	(4, 18, 'consectetuer adipiscing elit. Etiam laoreet, libero et tristique pellentesque, tellus', 3),
	(5, 11, 'non enim commodo hendrerit. Donec porttitor tellus non magna. Nam', 3),
	(5, 15, 'montes, nascetur ridiculus mus. Proin vel nisl. Quisque fringilla euismod', 5),
	(6, 3, 'est, congue a, aliquet vel, vulputate eu, odio. Phasellus at', 4),
	(6, 20, 'nec quam. Curabitur vel lectus. Cum sociis natoque penatibus et', 1),
	(7, 4, 'Proin sed turpis nec mauris blandit mattis. Cras eget nisi', 2),
	(7, 11, 'molestie tellus. Aenean egestas hendrerit neque. In ornare sagittis felis.', 3),
	(7, 13, 'odio semper cursus. Integer mollis. Integer tincidunt aliquam arcu. Aliquam', 4),
	(8, 1, 'adipiscing lacus. Ut nec urna et arcu imperdiet ullamcorper. Duis', 3),
	(8, 9, 'Donec luctus aliquet odio. Etiam ligula tortor, dictum eu, placerat', 5),
	(9, 2, 'sem egestas blandit. Nam nulla magna, malesuada vel, convallis in,', 5),
	(10, 13, 'egestas a, scelerisque sed, sapien. Nunc pulvinar arcu et pede.', 2),
	(11, 3, 'sem semper erat, in consectetuer ipsum nunc id enim. Curabitur', 3),
	(11, 7, 'vitae semper egestas, urna justo faucibus lectus, a sollicitudin orci', 1),
	(11, 14, 'et netus et malesuada fames ac turpis egestas. Aliquam fringilla', 2),
	(11, 18, 'est, mollis non, cursus non, egestas a, dui. Cras pellentesque.', 1),
	(12, 13, 'quis arcu vel quam dignissim pharetra. Nam ac nulla. In', 5),
	(13, 10, 'in faucibus orci luctus et ultrices posuere cubilia Curae Donec', 4),
	(13, 13, 'libero est, congue a, aliquet vel, vulputate eu, odio. Phasellus', 5),
	(13, 19, 'id, blandit at, nisi. Cum sociis natoque penatibus et magnis', 3),
	(13, 20, 'elit sed consequat auctor, nunc nulla vulputate dui, nec tempus', 4),
	(14, 4, 'eu dui. Cum sociis natoque penatibus et magnis dis parturient', 2),
	(14, 6, 'ornare. Fusce mollis. Duis sit amet diam eu dolor egestas', 1),
	(14, 9, 'nec enim. Nunc ut erat. Sed nunc est, mollis non,', 2),
	(14, 13, 'a purus. Duis elementum, dui quis accumsan convallis, ante lectus', 4),
	(14, 15, 'tristique neque venenatis lacus. Etiam bibendum fermentum metus. Aenean sed', 3),
	(15, 12, 'libero. Integer in magna. Phasellus dolor elit, pellentesque a, facilisis', 5),
	(15, 14, 'libero mauris, aliquam eu, accumsan sed, facilisis vitae, orci. Phasellus', 5),
	(17, 6, 'sapien imperdiet ornare. In faucibus. Morbi vehicula. Pellentesque tincidunt tempus', 4),
	(17, 9, 'sed consequat auctor, nunc nulla vulputate dui, nec tempus mauris', 3),
	(17, 10, 'nibh enim, gravida sit amet, dapibus id, blandit at, nisi.', 4),
	(17, 11, 'In lorem. Donec elementum, lorem ut aliquam iaculis, lacus pede', 2),
	(17, 17, 'ipsum sodales purus, in molestie tortor nibh sit amet orci.', 2),
	(18, 10, 'Aliquam nec enim. Nunc ut erat. Sed nunc est, mollis', 3),
	(19, 15, 'Aenean egestas hendrerit neque. In ornare sagittis felis. Donec tempor,', 3),
	(20, 15, 'penatibus et magnis dis parturient montes, nascetur ridiculus mus. Aenean', 3);

-- Dumping structure for table works.skill
CREATE TABLE IF NOT EXISTS `skill` (
  `skill_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `skill_desc` varchar(300) NOT NULL,
  `skill_name` varchar(150) NOT NULL,
  `skill_type` tinyint(4) DEFAULT NULL CHECK (`skill_type` between 1 and 5),
  PRIMARY KEY (`skill_id`)
) ENGINE=InnoDB AUTO_INCREMENT=122 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table works.skill: ~81 rows (approximately)
DELETE FROM `skill`;
INSERT INTO `skill` (`skill_id`, `skill_desc`, `skill_name`, `skill_type`) VALUES
	(1, 'Eius debitis illum.', 'Communication', 0),
	(2, 'Distinctio quaerat minima.', 'Leadership', 1),
	(3, 'Et delectus minus corrupti.', 'Proactive', 2),
	(4, 'Optio ipsa alias neque et.', 'Technical savvy', 0),
	(5, 'Quisquam temporibus dolorem aliquid voluptatem consequatur.', 'Networking skills', 1),
	(6, 'Repudiandae velit vitae exercitationem.', 'Problem solving', 2),
	(7, 'Voluptatem hic veritatis similique asperiores.', 'Proactive', 0),
	(8, 'Numquam rem praesentium maiores sed.', 'Problem solving', 1),
	(9, 'Debitis est voluptate molestiae aut ipsum.', 'Fast learner', 2),
	(10, 'Accusantium est debitis sint.', 'Fast learner', 0),
	(11, 'Recusandae earum odio iusto expedita assumenda.', 'Leadership', 1),
	(12, 'Error at optio veritatis nihil consectetur pariatur odio.', 'Organisation', 2),
	(13, 'Et nobis consequatur sint minus fugiat ut molestias.', 'Organisation', 0),
	(14, 'Rem inventore atque ut.', 'Technical savvy', 1),
	(15, 'Esse tempora dignissimos perspiciatis voluptates quam voluptatem molestiae.', 'Fast learner', 2),
	(16, 'Ea accusamus temporibus officiis eaque.', 'Confidence', 0),
	(17, 'Ullam voluptas at.', 'Technical savvy', 1),
	(18, 'Laboriosam provident dolor.', 'Technical savvy', 2),
	(19, 'Minima in distinctio.', 'Leadership', 0),
	(20, 'Rerum optio et nisi sed non perferendis voluptatum.', 'Fast learner', 1),
	(61, 'Eum non et ad.', 'Technical savvy', 0),
	(62, 'Repellendus voluptas eaque vero exercitationem dolorem quos ut.', 'Confidence', 1),
	(63, 'Quia in similique beatae rerum.', 'Leadership', 2),
	(64, 'Sit architecto nemo in temporibus et.', 'Technical savvy', 0),
	(65, 'Ullam et voluptatem iusto.', 'Problem solving', 1),
	(66, 'Optio tempora et voluptas.', 'Self-motivated', 2),
	(67, 'Eos quas ullam praesentium aut aut odit.', 'Work under pressure', 0),
	(68, 'Iure dolor aliquam sint molestiae.', 'Self-motivated', 1),
	(69, 'Provident pariatur omnis.', 'Communication', 2),
	(70, 'Libero ut rerum dolore cumque rerum sed tempore.', 'Problem solving', 0),
	(71, 'Sed mollitia aliquam voluptates at repellendus est ipsa.', 'Problem solving', 1),
	(72, 'Quia et nesciunt aut dolor autem placeat facilis.', 'Fast learner', 2),
	(73, 'Tempora consequatur delectus perferendis repellat perferendis eum.', 'Communication', 0),
	(74, 'Aut dolor et rerum cumque quis nisi consectetur.', 'Teamwork', 1),
	(75, 'Explicabo maiores voluptates.', 'Communication', 2),
	(76, 'Aut voluptatibus rerum facere ut assumenda debitis.', 'Proactive', 0),
	(77, 'Architecto ut veritatis nam repellendus sunt neque qui.', 'Self-motivated', 1),
	(78, 'Qui sit ut fuga odit molestias aut.', 'Self-motivated', 2),
	(79, 'Nobis impedit blanditiis.', 'Communication', 0),
	(80, 'Labore deleniti ipsa placeat sit praesentium assumenda qui.', 'Leadership', 1),
	(81, 'Voluptas iste optio.', 'Problem solving', 2),
	(82, 'Voluptas ut labore delectus.', 'Work under pressure', 0),
	(83, 'Voluptatem eius excepturi non fugit debitis voluptate excepturi.', 'Fast learner', 1),
	(84, 'Dolores assumenda voluptatem quia qui.', 'Self-motivated', 2),
	(85, 'Velit dolor illo quo nihil mollitia sit.', 'Confidence', 0),
	(86, 'Qui velit quia sapiente magnam cupiditate.', 'Work under pressure', 1),
	(87, 'Voluptatum laborum temporibus eum dignissimos et.', 'Leadership', 2),
	(88, 'Aspernatur quas molestiae adipisci reprehenderit.', 'Teamwork', 0),
	(89, 'Qui magni delectus qui est aut cupiditate.', 'Problem solving', 1),
	(90, 'Est cum et voluptate corrupti.', 'Organisation', 2),
	(91, 'Accusamus voluptas eligendi placeat ipsam dolorem qui et.', 'Communication', 0),
	(92, 'Enim explicabo voluptas est.', 'Communication', 1),
	(93, 'Quaerat ut qui soluta earum esse voluptas.', 'Networking skills', 2),
	(94, 'Architecto repudiandae amet.', 'Technical savvy', 0),
	(95, 'Placeat non atque.', 'Self-motivated', 1),
	(96, 'Voluptas modi voluptatum occaecati dolore dignissimos illo.', 'Confidence', 2),
	(97, 'Quisquam earum modi maxime quidem.', 'Work under pressure', 0),
	(98, 'Et adipisci et soluta debitis vel.', 'Technical savvy', 1),
	(99, 'Sunt qui beatae dolores nihil illum.', 'Confidence', 2),
	(100, 'Odit qui tempora.', 'Work under pressure', 0),
	(101, 'Est expedita nobis id.', 'Communication', 1),
	(102, 'Est et quisquam necessitatibus maiores dolore et.', 'Proactive', 2),
	(103, 'In ipsam ut libero magni.', 'Confidence', 0),
	(104, 'Quos inventore itaque consequatur magnam repellat.', 'Self-motivated', 1),
	(105, 'Distinctio doloremque quia quia.', 'Organisation', 2),
	(106, 'Enim est iure aut quia iusto ipsum.', 'Communication', 0),
	(107, 'In a repellendus magnam.', 'Communication', 1),
	(108, 'Et eum enim suscipit consequatur.', 'Leadership', 2),
	(109, 'Dignissimos incidunt est architecto.', 'Technical savvy', 0),
	(110, 'Dolore sed dolorem.', 'Technical savvy', 1),
	(111, 'Nisi illum eius debitis explicabo ut voluptatibus.', 'Technical savvy', 2),
	(112, 'Exercitationem impedit voluptatem aut adipisci.', 'Work under pressure', 0),
	(113, 'Soluta et quae error et exercitationem corporis assumenda.', 'Problem solving', 1),
	(114, 'Ipsam aspernatur quia eveniet sit.', 'Leadership', 2),
	(115, 'Non aut nisi labore et saepe.', 'Communication', 0),
	(116, 'Eligendi ut dolorem quaerat corrupti expedita.', 'Technical savvy', 1),
	(117, 'Ut deserunt asperiores quia asperiores expedita.', 'Proactive', 2),
	(118, 'Non tenetur et est voluptatibus voluptas laudantium.', 'Teamwork', 0),
	(119, 'Autem possimus labore et.', 'Problem solving', 1),
	(120, 'Et exercitationem quod consequatur.', 'Proactive', 2),
	(121, 'Listen, Speak, Read , Write with English', 'Communacation English', 2);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
