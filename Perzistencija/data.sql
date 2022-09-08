-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 01, 2022 at 02:09 PM
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
-- Database: `perzistencija_baza`
--

-- --------------------------------------------------------

--
-- Table structure for table `data`
--

CREATE TABLE `data` (
  `staff_id` int(11) NOT NULL,
  `ime` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `broj_godina` int(11) NOT NULL,
  `adresa` varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL,
  `visina_dohotka` int(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `data`
--

INSERT INTO `data` (`staff_id`, `ime`, `broj_godina`, `adresa`, `visina_dohotka`) VALUES
(1, 'Lorilee', 64, '9 Cordelia Lane', 500),
(2, 'Julietta', 14, '0 Maple Circle', 700),
(3, 'Niels', 45, '29919 Meadow Valley Hill', 800),
(4, 'Zeke', 71, '14542 Dorton Court', 900),
(5, 'Cornall', 76, '2624 Banding Circle', 1000),
(6, 'Lynn', 31, '51102 Dunning Road', 1100),
(7, 'Elihu', 50, '4 Lake View Junction', 1200),
(8, 'Haven', 52, '49 Dakota Circle', 1300),
(9, 'Carmela', 62, '3011 Orin Place', 1400),
(10, 'Faustina', 45, '936 Manley Lane', 1500),
(15, 'Branislav', 21, 'Beograd', 2700),
(16, 'Haven', 32, 'SAD', 5500);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `data`
--
ALTER TABLE `data`
  ADD PRIMARY KEY (`staff_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `data`
--
ALTER TABLE `data`
  MODIFY `staff_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
