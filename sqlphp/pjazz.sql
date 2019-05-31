-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: 2019 m. Bir 01 d. 00:54
-- Server version: 10.3.12-MariaDB-log
-- PHP Version: 7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `etravi_php`
--

-- --------------------------------------------------------

--
-- Sukurta duomenų struktūra lentelei `nariai`
--

CREATE TABLE `nariai` (
  `id` int(30) NOT NULL,
  `vardas` text NOT NULL,
  `elpastas` text NOT NULL,
  `slaptazodis` text NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Sukurta duomenų kopija lentelei `nariai`
--

INSERT INTO `nariai` (`id`, `vardas`, `elpastas`, `slaptazodis`) VALUES
(1, 'sadasd ', 'asdasd@asdasd.lt ', 'asdasd ');

-- --------------------------------------------------------

--
-- Sukurta duomenų struktūra lentelei `pica`
--

CREATE TABLE `pica` (
  `id` int(11) NOT NULL,
  `pavadinimas` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `dydis` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `gerimas` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `padazas` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `kaina` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Sukurta duomenų kopija lentelei `pica`
--

INSERT INTO `pica` (`id`, `pavadinimas`, `dydis`, `gerimas`, `padazas`, `kaina`) VALUES
(5, 'HavajÅ³', 'DidelÄ—45cm', 'Pepsi', 'Cesnakinis:', 5),
(8, 'Italiano', 'MaÅ¾a25cm', 'Pepsi', 'Astrus:', 5);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `nariai`
--
ALTER TABLE `nariai`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pica`
--
ALTER TABLE `pica`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `nariai`
--
ALTER TABLE `nariai`
  MODIFY `id` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `pica`
--
ALTER TABLE `pica`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
