-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 03, 2022 at 08:35 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `matdist`
--

-- --------------------------------------------------------

--
-- Table structure for table `food`
--

CREATE TABLE `food` (
  `id` int(11) NOT NULL,
  `serving_date` varchar(30) NOT NULL,
  `title` varchar(64) NOT NULL,
  `img_src` varchar(256) NOT NULL,
  `rating` int(1) NOT NULL DEFAULT 0,
  `ingredients` varchar(200) NOT NULL,
  `week_day` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `food`
--

INSERT INTO `food` (`id`, `serving_date`, `title`, `img_src`, `rating`, `ingredients`, `week_day`) VALUES
(0, '30 Maj', 'Panbiff med sås och klyft potatis', 'pannbiff.jpg', 0, 'Protin, Vitamin B12', 'Måndag'),
(1, '30 Maj', 'Grillad lax med potatis och sallad', 'grillad_lax.jpg', 0, 'Omega3, Omega6', 'Måndag'),
(2, '31 Maj', 'Onigiri', 'onigiri.jpg', 0, 'Omega3, Omega6', 'Tisdag'),
(3, '31 Maj', 'Pyttipanna med ägg', 'pyttipanna.jpg', 0, 'Protin, Vitamin B12', 'Tisdag'),
(4, '1 Juni', 'Stekt sill med mos', 'steksill.jpg', 0, 'Omega3, Omega6', 'Onsdag'),
(5, '1 Juni', 'Ärtsoppa med fläsk', 'ärtsoppa.jpg', 0, 'Protin', 'Onsdag'),
(6, '2 Juni', 'Isterband med dillstuvad potatis', 'isterband.jpg', 0, 'Protin', 'Torsdag'),
(7, '3 Juni', 'Raggmunkar med stekfläsk', 'raggmunk.jpg', 0, 'Protin', 'Fredag'),
(8, '4 Juni', 'Rotmos med falukorv', 'rotmos.jpg', 0, 'Protin', 'Lördag'),
(9, '4 Juni', 'Onigiri', 'onigiri.jpg', 0, 'Omega3, Omega6, Vitamin B12', 'Lördag');

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `id` int(11) NOT NULL,
  `title` varchar(64) NOT NULL,
  `img_src` varchar(256) NOT NULL,
  `rateing` int(1) NOT NULL,
  `ingredients` varchar(200) NOT NULL,
  `username` varchar(64) NOT NULL,
  `serving_date` varchar(30) NOT NULL,
  `week_day` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`id`, `title`, `img_src`, `rateing`, `ingredients`, `username`, `serving_date`, `week_day`) VALUES
(28, 'Panbiff med sås och klyft potatis', 'pannbiff.jpg', 0, 'Protin, Vitamin B12', 'Yuki Raiden', '30 Maj', 'Måndag'),
(29, 'Onigiri', 'onigiri.jpg', 0, 'Omega3, Omega6', 'Yuki Raiden', '31 Maj', 'Tisdag'),
(30, 'Grillad lax med potatis och sallad', 'grillad_lax.jpg', 0, 'Omega3, Omega6', 'Sakuya Kirigiri', '30 Maj', 'Måndag'),
(31, 'Onigiri', 'onigiri.jpg', 0, 'Omega3, Omega6', 'Sakuya Kirigiri', '31 Maj', 'Tisdag'),
(32, 'Stekt sill med mos', 'steksill.jpg', 0, 'Omega3, Omega6', 'Sakuya Kirigiri', '1 Juni', 'Onsdag'),
(33, 'Isterband med dillstuvad potatis', 'isterband.jpg', 0, 'Protin', 'Sakuya Kirigiri', '2 Juni', 'Torsdag');

-- --------------------------------------------------------

--
-- Table structure for table `rateing_img`
--

CREATE TABLE `rateing_img` (
  `id` int(11) NOT NULL,
  `like` varchar(20) NOT NULL,
  `dislike` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `rateing_img`
--

INSERT INTO `rateing_img` (`id`, `like`, `dislike`) VALUES
(1, 'like', 'dislike');

-- --------------------------------------------------------

--
-- Table structure for table `rating`
--

CREATE TABLE `rating` (
  `rateing` varchar(11) DEFAULT NULL,
  `username` varchar(64) NOT NULL,
  `title` varchar(128) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `rating`
--

INSERT INTO `rating` (`rateing`, `username`, `title`, `id`) VALUES
('1', 'Yuki Raiden', 'Onigiri', 51);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(32) DEFAULT NULL,
  `password` varchar(128) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password`) VALUES
(0, 'Sakuya Kirigiri', '0x2*4*8*32*256'),
(1, 'Yuki Raiden', '(^_^)'),
(4, 'Sakuya Yae', 'Sakura');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `food`
--
ALTER TABLE `food`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rateing_img`
--
ALTER TABLE `rateing_img`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rating`
--
ALTER TABLE `rating`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;

--
-- AUTO_INCREMENT for table `rateing_img`
--
ALTER TABLE `rateing_img`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `rating`
--
ALTER TABLE `rating`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=56;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
