-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 04, 2022 at 01:17 PM
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `korespodencija`
--

INSERT INTO `korespodencija` (`korespodencija_id`, `poruka`, `datum`, `status`, `korisnik_primalac`, `korisnik_posiljalac`) VALUES
(1, 'Poslao sam dokumenta na overavanje.', '2022-02-01', 1, 3, 5),
(2, 'Koja je lozinka racunara?', '2022-01-27', 1, 5, 4),
(3, 'Lozinka je sistem1234 .', '2022-01-27', 1, 4, 5),
(4, 'Primljeno.', '2022-02-01', 1, 5, 3),
(5, 'Kada je pauza?', '2022-01-12', 1, 4, 3),
(6, 'U 09:00AM', '2022-01-12', 1, 3, 4);

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
  `e-mail` varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL,
  `korisnicko_ime` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `kratka_biografija` mediumtext COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `fotografija` mediumblob DEFAULT NULL,
  PRIMARY KEY (`korisnik_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `korisnik`
--

INSERT INTO `korisnik` (`korisnik_id`, `ime`, `prezime`, `datum_rodjenja`, `e-mail`, `korisnicko_ime`, `kratka_biografija`, `fotografija`) VALUES
(3, 'Marko', 'Obradovic', '1994-02-04', 'marko55@mail.com', 'marko55', NULL, NULL),
(4, 'Bogdan', 'Nikolic', '2000-05-10', 'bogdan00@mail.com', 'bogdan00', NULL, NULL),
(5, 'Veljko', 'Milosevic', '1889-06-15', 'veljko89@mail.com', 'veljko89', NULL, NULL);

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
  UNIQUE KEY `korisnik_id` (`korisnik_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `plata`
--

INSERT INTO `plata` (`plata_id`, `datum`, `iznos`, `korisnik_id`, `status`, `tip_zaposlenja`) VALUES
(1, '2022-01-11', 700, 3, 1, 'Na neodredjeno'),
(2, '2022-01-11', 900, 4, 1, 'Na neodredjeno'),
(3, '2022-01-11', 1500, 5, 1, 'Na neodredjeno');

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
