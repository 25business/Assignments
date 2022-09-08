-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 27, 2022 at 02:14 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `assigment_baza`
--
CREATE DATABASE IF NOT EXISTS `assigment_baza` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE `assigment_baza`;

DELIMITER $$
--
-- Procedures
--
DROP PROCEDURE IF EXISTS `korespodencija_brisanje`$$
CREATE DEFINER=`jadmin`@`localhost` PROCEDURE `korespodencija_brisanje` (IN `in_id` INT(20))  BEGIN
START TRANSACTION;
	DELETE FROM korespodencija
    WHERE korespodencija_id = in_id;
COMMIT;
END$$

DROP PROCEDURE IF EXISTS `korespodencija_izmena_poruka`$$
CREATE DEFINER=`jadmin`@`localhost` PROCEDURE `korespodencija_izmena_poruka` (IN `in_id` INT(20), IN `in_poruka` MEDIUMTEXT)  BEGIN
START TRANSACTION;
	UPDATE korespodencija
    SET poruka=in_poruka
    WHERE korespodencija_id= in_id;
COMMIT;
END$$

DROP PROCEDURE IF EXISTS `korespodencija_unos`$$
CREATE DEFINER=`jadmin`@`localhost` PROCEDURE `korespodencija_unos` (IN `in_poruka` MEDIUMTEXT, IN `in_datum` DATE, IN `in_status` INT(20), IN `in_korisnik_primalac` INT(20), IN `in_korisnik_posiljalac` INT(20))  BEGIN
START TRANSACTION;
INSERT INTO korespodencija (korespodencija_id, poruka, datum, status, korisnik_primalac, korisnik_posiljalac) VALUES (NULL, in_poruka, in_datum, in_status, in_korisnik_primalac, in_korisnik_posiljalac);
COMMIT;
END$$

DROP PROCEDURE IF EXISTS `korisnik_brisanje`$$
CREATE DEFINER=`jadmin`@`localhost` PROCEDURE `korisnik_brisanje` (IN `in_id` INT(50))  BEGIN
START TRANSACTION;
	DELETE FROM korisnik
    WHERE korisnik_id = in_id;
COMMIT;
END$$

DROP PROCEDURE IF EXISTS `korisnik_izmena_podataka`$$
CREATE DEFINER=`jadmin`@`localhost` PROCEDURE `korisnik_izmena_podataka` (IN `in_id` INT(20), IN `in_ime` VARCHAR(50), IN `in_prezime` VARCHAR(50), IN `in_datum_rodjenja` DATE, IN `in_email` VARCHAR(50), IN `in_korisnicko_ime` VARCHAR(50))  BEGIN
START TRANSACTION;
	UPDATE korisnik
    SET ime=in_ime, prezime=in_prezime, datum_rodjenja=in_datum_rodjenja, email=in_email, korisnicko_ime=in_korisnicko_ime
    WHERE korisnik_id= in_id;
COMMIT;
END$$

DROP PROCEDURE IF EXISTS `korisnik_unos`$$
CREATE DEFINER=`jadmin`@`localhost` PROCEDURE `korisnik_unos` (IN `in_ime` VARCHAR(50), IN `in_prezime` VARCHAR(50), IN `in_datum_rodjenja` DATE, IN `in_email` VARCHAR(50), IN `in_korisnicko_ime` VARCHAR(50))  BEGIN
START TRANSACTION;
INSERT INTO korisnik (korisnik_id, ime, prezime, datum_rodjenja, email, korisnicko_ime) VALUES (NULL, in_ime, in_prezime, in_datum_rodjenja, in_email, in_korisnicko_ime);
COMMIT;
END$$

DROP PROCEDURE IF EXISTS `plata_brisanje`$$
CREATE DEFINER=`jadmin`@`localhost` PROCEDURE `plata_brisanje` (IN `in_id` INT(20))  BEGIN
START TRANSACTION;
	DELETE FROM plata
    WHERE plata_id = in_id;
COMMIT;
END$$

DROP PROCEDURE IF EXISTS `plata_izmena_podataka`$$
CREATE DEFINER=`jadmin`@`localhost` PROCEDURE `plata_izmena_podataka` (IN `in_id` INT(20), IN `in_datum` DATE, IN `in_iznos` INT(20), IN `in_korisnik_id` INT(20), IN `in_status` INT(20), IN `in_tip_zaposlenja` VARCHAR(20))  BEGIN
START TRANSACTION;
	UPDATE plata
    SET datum=in_datum, iznos=in_iznos, korisnik_id=in_korisnik_id, status=in_status, tip_zaposlenja=in_tip_zaposlenja
    WHERE plata_id= in_id;
COMMIT;
END$$

DROP PROCEDURE IF EXISTS `plata_unos`$$
CREATE DEFINER=`jadmin`@`localhost` PROCEDURE `plata_unos` (IN `in_datum` DATE, IN `in_iznos` INT(20), IN `in_korisnik_id` INT(20), IN `in_status` INT(20), IN `in_tip_zaposlenja` VARCHAR(50))  BEGIN
START TRANSACTION;
INSERT INTO plata (plata_id, datum, iznos, korisnik_id, status, tip_zaposlenja) VALUES (NULL, in_datum, in_iznos, in_korisnik_id, in_status, in_tip_zaposlenja);
COMMIT;
END$$

DROP PROCEDURE IF EXISTS `prikaz_poruka`$$
CREATE DEFINER=`jadmin`@`localhost` PROCEDURE `prikaz_poruka` ()  SELECT COUNT(poruka), korisnik_posiljalac FROM korespodencija GROUP BY korisnik_posiljalac$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `korespodencija`
--

DROP TABLE IF EXISTS `korespodencija`;
CREATE TABLE IF NOT EXISTS `korespodencija` (
  `korespodencija_id` int(11) NOT NULL AUTO_INCREMENT,
  `poruka` mediumtext COLLATE utf8mb4_unicode_ci NOT NULL,
  `datum` date NOT NULL,
  `status` tinyint(1) NOT NULL,
  `korisnik_primalac` int(11) NOT NULL,
  `korisnik_posiljalac` int(11) NOT NULL,
  PRIMARY KEY (`korespodencija_id`),
  UNIQUE KEY `korisnik_primalac` (`korisnik_primalac`,`korisnik_posiljalac`),
  KEY `korisnik_posiljalac` (`korisnik_posiljalac`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `korespodencija`
--

INSERT INTO `korespodencija` (`korespodencija_id`, `poruka`, `datum`, `status`, `korisnik_primalac`, `korisnik_posiljalac`) VALUES
(1, 'Poslao sam dokumenta na overavanje.', '2022-02-01', 1, 3, 5),
(2, 'Koja je lozinka racunara?', '2022-01-27', 1, 5, 4),
(3, 'Lozinka je sistem1234 .', '2022-01-27', 1, 4, 5),
(4, 'Primljeno.', '2022-02-01', 1, 5, 3),
(5, 'Kada je pauza?', '2022-01-12', 1, 4, 3),
(6, 'U 09:15AM', '2022-01-12', 1, 3, 4);

-- --------------------------------------------------------

--
-- Table structure for table `korisnik`
--

DROP TABLE IF EXISTS `korisnik`;
CREATE TABLE IF NOT EXISTS `korisnik` (
  `korisnik_id` int(11) NOT NULL AUTO_INCREMENT,
  `ime` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `prezime` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `datum_rodjenja` date NOT NULL,
  `email` varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL,
  `korisnicko_ime` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `kratka_biografija` mediumtext COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `fotografija` mediumblob DEFAULT NULL,
  PRIMARY KEY (`korisnik_id`),
  UNIQUE KEY `e-mail` (`email`,`korisnicko_ime`),
  KEY `datum_rodjenja` (`datum_rodjenja`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `korisnik`
--

INSERT INTO `korisnik` (`korisnik_id`, `ime`, `prezime`, `datum_rodjenja`, `email`, `korisnicko_ime`, `kratka_biografija`, `fotografija`) VALUES
(3, 'Marko', 'Obradovic', '1994-02-04', 'marko55@mail.com', 'marko55', NULL, NULL),
(4, 'Bogdan', 'Nikolic', '2000-05-10', 'bogdan00@mail.com', 'bogdan00', NULL, NULL),
(5, 'Veljko', 'Milosevic', '1889-06-15', 'veljko89@mail.com', 'veljko89', NULL, NULL),
(35, 'Branislav', 'Mihajlovic', '0000-00-00', 'bane@gmail.com', 'bane201', NULL, NULL),
(37, '123', '123', '0000-00-00', '123', '123', NULL, NULL);

-- --------------------------------------------------------

--
-- Stand-in structure for view `myview`
-- (See below for the actual view)
--
DROP VIEW IF EXISTS `myview`;
CREATE TABLE IF NOT EXISTS `myview` (
`ime` varchar(45)
,`prezime` varchar(45)
,`datum_rodjenja` date
);

-- --------------------------------------------------------

--
-- Table structure for table `plata`
--

DROP TABLE IF EXISTS `plata`;
CREATE TABLE IF NOT EXISTS `plata` (
  `plata_id` int(11) NOT NULL AUTO_INCREMENT,
  `datum` date NOT NULL,
  `iznos` double NOT NULL,
  `korisnik_id` int(11) NOT NULL,
  `status` tinyint(1) NOT NULL,
  `tip_zaposlenja` varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`plata_id`),
  UNIQUE KEY `korisnik_id` (`korisnik_id`),
  KEY `datum` (`datum`),
  KEY `iznos` (`iznos`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `plata`
--

INSERT INTO `plata` (`plata_id`, `datum`, `iznos`, `korisnik_id`, `status`, `tip_zaposlenja`) VALUES
(1, '2022-01-11', 700, 3, 1, 'Na neodredjeno'),
(2, '2022-01-11', 900, 4, 1, 'Na neodredjeno'),
(3, '1995-04-04', 800, 35, 1, 'Na neodredjeno');

-- --------------------------------------------------------

--
-- Structure for view `myview`
--
DROP TABLE IF EXISTS `myview`;

DROP VIEW IF EXISTS `myview`;
CREATE ALGORITHM=UNDEFINED DEFINER=`jadmin`@`localhost` SQL SECURITY DEFINER VIEW `myview`  AS SELECT `korisnik`.`ime` AS `ime`, `korisnik`.`prezime` AS `prezime`, `korisnik`.`datum_rodjenja` AS `datum_rodjenja` FROM `korisnik` ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `korespodencija`
--
ALTER TABLE `korespodencija` ADD FULLTEXT KEY `poruka` (`poruka`);

--
-- Indexes for table `korisnik`
--
ALTER TABLE `korisnik` ADD FULLTEXT KEY `ime` (`ime`);
ALTER TABLE `korisnik` ADD FULLTEXT KEY `prezime` (`prezime`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `korespodencija`
--
ALTER TABLE `korespodencija`
  ADD CONSTRAINT `korespodencija_ibfk_1` FOREIGN KEY (`korisnik_primalac`) REFERENCES `korisnik` (`korisnik_id`),
  ADD CONSTRAINT `korespodencija_ibfk_2` FOREIGN KEY (`korisnik_posiljalac`) REFERENCES `korisnik` (`korisnik_id`);

--
-- Constraints for table `plata`
--
ALTER TABLE `plata`
  ADD CONSTRAINT `plata_ibfk_1` FOREIGN KEY (`korisnik_id`) REFERENCES `korisnik` (`korisnik_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
