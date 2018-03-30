-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Mar 30, 2018 at 03:27 PM
-- Server version: 5.6.38
-- PHP Version: 5.6.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `world_cup_app_18`
--

-- --------------------------------------------------------

--
-- Table structure for table `ARTICLE`
--

CREATE TABLE `ARTICLE` (
  `ARTICLE_ID` int(11) NOT NULL,
  `ARTICLE_TITLE` varchar(150) NOT NULL,
  `ARTICLE_DESCRIPTION` text NOT NULL,
  `ARTICLE_IMAGE` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `GAME`
--

CREATE TABLE `GAME` (
  `GAME_ID` int(3) NOT NULL,
  `GAME_KIND` varchar(40) NOT NULL,
  `GAME_WINNERTEAM` varchar(45) NOT NULL,
  `GAME_LOSSTEAM` varchar(45) NOT NULL,
  `GAME_TIME` varchar(45) NOT NULL,
  `GAME_DATE` date NOT NULL,
  `GAME_WINNERTEAMSCORE` int(2) NOT NULL,
  `GAME_LOSSTEAMSCORE` int(2) NOT NULL,
  `GAME_REFEREE` varchar(50) NOT NULL DEFAULT 'UNKNOWN',
  `GAME_STADIUM` varchar(40) NOT NULL,
  `GAME_VENUE` varchar(40) NOT NULL,
  `GAME_MATCHNUMBER` int(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `GAME`
--

INSERT INTO `GAME` (`GAME_ID`, `GAME_KIND`, `GAME_WINNERTEAM`, `GAME_LOSSTEAM`, `GAME_TIME`, `GAME_DATE`, `GAME_WINNERTEAMSCORE`, `GAME_LOSSTEAMSCORE`, `GAME_REFEREE`, `GAME_STADIUM`, `GAME_VENUE`, `GAME_MATCHNUMBER`) VALUES
(129, 'Group A', 'Russia', 'Saudi Arabia', '18:00', '2018-06-14', 0, 0, 'unknown', 'Luzhniki Stadium', 'Moscow', 1),
(130, 'Group A', 'Egypt', 'Uruguay', '17:00', '2018-06-15', 0, 0, 'unknown', 'Ekaterinburg Arena', 'Ekaterinburg', 2),
(131, 'Group B', 'Morocco', 'IR Iran', '18:00', '2018-06-15', 0, 0, 'unknown', 'Saint Petersburg Stadium', 'Saint Petersburg', 4),
(132, 'Group B', 'Portugal', 'Spain', '21:00', '2018-06-15', 0, 0, 'unknown', 'Fisht Stadium', 'Sochi', 3),
(133, 'Group C', 'France', 'Australia', '13:00', '2018-06-16', 0, 0, 'unknown', 'Kazan Arena', 'Kazan', 5),
(134, 'Group D', 'Argentina', 'Iceland', '16:00', '2018-06-16', 0, 0, 'unknown', 'Spartak Stadium', 'Moscow', 7),
(135, 'Group C', 'Peru', 'Denmark', '19:00', '2018-06-16', 0, 0, 'unknown', 'Mordovia Arena', 'Saransk', 6),
(136, 'Group D', 'Croatia', 'Nigeria', '21:00', '2018-06-16', 0, 0, 'unknown', 'Kaliningrad Stadium', 'Kaliningrad', 8),
(137, 'Group E', 'Costa Rica', 'Serbia', '16:00', '2018-06-17', 0, 0, 'unknown', 'Samara Arena', 'Samara', 10),
(138, 'Group F', 'Germany', 'Mexico', '18:00', '2018-06-17', 0, 0, 'unknown', 'Luzhniki Stadium', 'Moscow', 11),
(139, 'Group E', 'Brazil', 'Switzerland', '21:00', '2018-06-17', 0, 0, 'unknown', 'Rostov Arena', 'Rostov-On-Don', 9),
(140, 'Group F', 'Sweden', 'Korea Republic', '15:00', '2018-06-18', 0, 0, 'unknown', 'Nizhny Novgorod Stadium', 'Nizhny Novgorod', 12),
(141, 'Group G', 'Belgium', 'Panama', '18:00', '2018-06-18', 0, 0, 'unknown', 'Fisht Stadium', 'Sochi', 13),
(142, 'Group G', 'Tunisia', 'England', '21:00', '2018-06-18', 0, 0, 'unknown', 'Volgograd Arena', 'Volgograd', 14),
(143, 'Group H', 'Colombia', 'Japan', '15:00', '2018-06-19', 0, 0, 'unknown', 'Mordovia Arena', 'Saransk', 16),
(144, 'Group H', 'Poland', 'Senegal', '18:00', '2018-06-19', 0, 0, 'unknown', 'Spartak Stadium', 'Moscow', 15),
(145, 'Group A', 'Russia', 'Egypt', '21:00', '2018-06-19', 0, 0, 'unknown', 'Saint Petersburg Stadium', 'Saint Petersburg', 17),
(146, 'Group B', 'Portugal', 'Morocco', '15:00', '2018-06-20', 0, 0, 'unknown', 'Luzhniki Stadium', 'Moscow', 19),
(147, 'Group A', 'Uruguay', 'Saudi Arabia', '18:00', '2018-06-20', 0, 0, 'unknown', 'Rostov Arena', 'Rostov-On-Don', 18),
(148, 'Group B', 'IR Iran', 'Spain', '21:00', '2018-06-20', 0, 0, 'unknown', 'Kazan Arena', 'Kazan', 20),
(149, 'Group C', 'Denmark', 'Australia', '16:00', '2018-06-21', 0, 0, 'unknown', 'Samara Arena', 'Samara', 22),
(150, 'Group C', 'France', 'Peru', '20:00', '2018-06-21', 0, 0, 'unknown', 'Ekaterinburg Arena', 'Ekaterinburg', 21),
(151, 'Group D', 'Argentina', 'Croatia', '21:00', '2018-06-21', 0, 0, 'unknown', 'Nizhny Novgorod Stadium', 'Nizhny Novgorod', 23),
(152, 'Group E', 'Brazil', 'Costa Rica', '15:00', '2018-06-22', 0, 0, 'unknown', 'Saint Petersburg Stadium', 'Saint Petersburg', 25),
(153, 'Group D', 'Nigeria', 'Iceland', '18:00', '2018-06-22', 0, 0, 'unknown', 'Volgograd Arena', 'Volgograd', 24),
(154, 'Group E', 'Serbia', 'Switzerland', '20:00', '2018-06-22', 0, 0, 'unknown', 'Kaliningrad Stadium', 'Kaliningrad', 26),
(155, 'Group G', 'Belgium', 'Tunisia', '15:00', '2018-06-23', 0, 0, 'unknown', 'Spartak Stadium', 'Moscow', 29),
(156, 'Group F', 'Korea Republic', 'Mexico', '18:00', '2018-06-23', 0, 0, 'unknown', 'Rostov Arena', 'Rostov-On-Don', 28),
(157, 'Group F', 'Germany', 'Sweden', '21:00', '2018-06-23', 0, 0, 'unknown', 'Fisht Stadium', 'Sochi', 27),
(158, 'Group G', 'England', 'Panama', '15:00', '2018-06-24', 0, 0, 'unknown', 'Nizhny Novgorod Stadium', 'Nizhny Novgorod', 30),
(159, 'Group H', 'Japan', 'Senegal', '20:00', '2018-06-24', 0, 0, 'unknown', 'Ekaterinburg Arena', 'Ekaterinburg', 32),
(160, 'Group H', 'Poland', 'Colombia', '21:00', '2018-06-24', 0, 0, 'unknown', 'Kazan Arena', 'Kazan', 31),
(161, 'Group A', 'Uruguay', 'Russia', '18:00', '2018-06-25', 0, 0, 'unknown', 'Samara Arena', 'Samara', 33),
(162, 'Group A', 'Saudi Arabia', 'Egypt', '17:00', '2018-06-25', 0, 0, 'unknown', 'Volgograd Arena', 'Volgograd', 34),
(163, 'Group B', 'IR Iran', 'Portugal', '21:00', '2018-06-25', 0, 0, 'unknown', 'Mordovia Arena', 'Saransk', 35),
(164, 'Group B', 'Spain', 'Morocco', '20:00', '2018-06-25', 0, 0, 'unknown', 'Kaliningrad Stadium', 'Kaliningrad', 36),
(165, 'Group C', 'Denmark', 'France', '17:00', '2018-06-26', 0, 0, 'unknown', 'Luzhniki Stadium', 'Moscow', 37),
(166, 'Group C', 'Australia', 'Peru', '17:00', '2018-06-26', 0, 0, 'unknown', 'Fisht Stadium', 'Sochi', 38),
(167, 'Group D', 'Nigeria', 'Argentina', '21:00', '2018-06-26', 0, 0, 'unknown', 'Saint Petersburg Stadium', 'Saint Petersburg', 39),
(168, 'Group D', 'Iceland', 'Croatia', '21:00', '2018-06-26', 0, 0, 'unknown', 'Rostov Arena', 'Rostov-On-Don', 40),
(169, 'Group F', 'Mexico', 'Sweden', '19:00', '2018-06-27', 0, 0, 'unknown', 'Ekaterinburg Arena', 'Ekaterinburg', 44),
(170, 'Group F', 'Korea Republic', 'Germany', '17:00', '2018-06-27', 0, 0, 'unknown', 'Kazan Arena', 'Kazan', 43),
(171, 'Group E', 'Serbia', 'Brazil', '21:00', '2018-06-27', 0, 0, 'unknown', 'Spartak Stadium', 'Moscow', 41),
(172, 'Group E', 'Switzerland', 'Costa Rica', '21:00', '2018-06-27', 0, 0, 'unknown', 'Nizhny Novgorod Stadium', 'Nizhny Novgorod', 42),
(173, 'Group H', 'Japan', 'Poland', '17:00', '2018-06-28', 0, 0, 'unknown', 'Volgograd Arena', 'Volgograd', 47),
(174, 'Group H', 'Senegal', 'Colombia', '18:00', '2018-06-28', 0, 0, 'unknown', 'Samara Arena', 'Samara', 48),
(175, 'Group G', 'Panama', 'Tunisia', '21:00', '2018-06-28', 0, 0, 'unknown', 'Mordovia Arena', 'Saransk', 46),
(176, 'Group G', 'England', 'Belgium', '20:00', '2018-06-28', 0, 0, 'unknown', 'Kaliningrad Stadium', 'Kaliningrad', 45),
(177, 'Round of 16', '[1C]', '[2D]', '17:00', '2018-06-30', 0, 0, 'unknown', 'Kazan Arena', 'Kazan', 50),
(178, 'Round of 16', '[1A]', '[2B]', '21:00', '2018-06-30', 0, 0, 'unknown', 'Fisht Stadium', 'Sochi', 49),
(179, 'Round of 16', '[1B]', '[2A]', '17:00', '2018-07-01', 0, 0, 'unknown', 'Luzhniki Stadium', 'Moscow', 51),
(180, 'Round of 16', '[1D]', '[2C]', '21:00', '2018-07-01', 0, 0, 'unknown', 'Nizhny Novgorod Stadium', 'Nizhny Novgorod', 52),
(181, 'Round of 16', '[1E]', '[2F]', '18:00', '2018-07-02', 0, 0, 'unknown', 'Samara Arena', 'Samara', 53),
(182, 'Round of 16', '[1G]', '[2H]', '21:00', '2018-07-02', 0, 0, 'unknown', 'Rostov Arena', 'Rostov-On-Don', 54),
(183, 'Round of 16', '[1F]', '[2E]', '17:00', '2018-07-03', 0, 0, 'unknown', 'Saint Petersburg Stadium', 'Saint Petersburg', 55),
(184, 'Round of 16', '[1H]', '[2G]', '21:00', '2018-07-03', 0, 0, 'unknown', 'Spartak Stadium', 'Moscow', 56),
(185, 'Quarter-finals', '[W49]', '[W50]', '17:00', '2018-07-06', 0, 0, 'unknown', 'Nizhny Novgorod Stadium', 'Nizhny Novgorod', 57),
(186, 'Quarter-finals', '[W53]', '[W54]', '21:00', '2018-07-06', 0, 0, 'unknown', 'Kazan Arena', 'Kazan', 58),
(187, 'Quarter-finals', '[W55]', '[W56]', '18:00', '2018-07-07', 0, 0, 'unknown', 'Samara Arena', 'Samara', 60),
(188, 'Quarter-finals', '[W51]', '[W52]', '21:00', '2018-07-07', 0, 0, 'unknown', 'Fisht Stadium', 'Sochi', 59),
(189, 'Semi-finals', '[W57]', '[W58]', '21:00', '2018-07-10', 0, 0, 'unknown', 'Saint Petersburg Stadium', 'Saint Petersburg', 61),
(190, 'Semi-finals', '[W59]', '[W60]', '21:00', '2018-07-11', 0, 0, 'unknown', 'Luzhniki Stadium', 'Moscow', 62),
(191, 'Play-off for third place', '[L61]', '[L62]', '17:00', '2018-07-14', 0, 0, 'unknown', 'Saint Petersburg Stadium', 'Saint Petersburg', 63),
(192, 'Final', '[W61]', '[W62]', '18:00', '2018-07-15', 0, 0, 'unknown', 'Luzhniki Stadium', 'Moscow', 64),
(193, 'sdf', 'qsd', 'qs', '12:12', '2018-03-06', 2, 3, 'qsd', 'qsd', 'qsd', 12);

-- --------------------------------------------------------

--
-- Table structure for table `GOAL`
--

CREATE TABLE `GOAL` (
  `GOAL_ID` int(3) NOT NULL,
  `GOAL_GAME` int(3) DEFAULT NULL,
  `GOAL_PLAYER` int(4) DEFAULT NULL,
  `GOAL_TIME` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `HOTEL`
--

CREATE TABLE `HOTEL` (
  `HOTEL_ID` int(3) NOT NULL,
  `HOTEL_NAME` varchar(30) NOT NULL,
  `HOTEL_LOCATION` varchar(30) NOT NULL,
  `HOTEL_STARS` int(1) NOT NULL,
  `HOTEL_LOCATION_X` varchar(50) NOT NULL,
  `HOTEL_LOCATION_Y` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `PLAYER`
--

CREATE TABLE `PLAYER` (
  `PLAYER_ID` int(4) NOT NULL,
  `PLAYER_NAME` varchar(40) NOT NULL,
  `PLAYER_AGE` int(2) NOT NULL,
  `PLAYER_TEAM` int(3) DEFAULT NULL,
  `PLAYER_PICTURE` int(3) DEFAULT NULL,
  `PLAYER_POSITION` varchar(25) NOT NULL,
  `PLAYER_CLUB` varchar(25) NOT NULL,
  `PLAYER_HEIGHT` varchar(25) NOT NULL,
  `PLAYER_WEIGHT` varchar(25) NOT NULL,
  `PLAYER_TSHIRT` int(2) NOT NULL,
  `PLAYER_TSHIRT` int(2) NOT NULL,
  `PLAYER_NUMBER_NOTE` int(3) NOT NULL,
  `PLAYER_RATING` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `STADIUM`
--

CREATE TABLE `STADIUM` (
  `STADIUM_ID` int(1) NOT NULL,
  `STADIUM_NAME` varchar(25) NOT NULL,
  `STADIUM_LOCATION` varchar(50) NOT NULL,
  `STADIUM_CAPACITY` int(1) NOT NULL,
  `STADIUM_PICTURE` varchar(500) DEFAULT NULL,
  `STADIUM_LOCATION_X` varchar(50) NOT NULL,
  `STADIUM_LOCATION_Y` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `STATION`
--

CREATE TABLE `STATION` (
  `STATION_ID` int(11) NOT NULL,
  `STATION_NAME` varchar(20) NOT NULL,
  `STATION_LOCATION` varchar(30) NOT NULL,
  `STATION_TYPE` varchar(30) NOT NULL,
  `STATION_LOCATION_X` varchar(50) NOT NULL,
  `STATION_LOCATION_Y` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `TEAM`
--

CREATE TABLE `TEAM` (
  `TEAM_ID` int(3) NOT NULL,
  `TEAM_NAME` varchar(45) DEFAULT NULL,
  `TEAM_COACH` varchar(45) DEFAULT NULL,
  `TEAM_INTMATCHPLAYED` int(1) DEFAULT '0',
  `TEAM_INTMATCHWON` int(1) DEFAULT '0',
  `TEAM_INTMATCHLOST` int(1) DEFAULT '0',
  `TEAM_INTMATCHDRAW` int(1) DEFAULT '0',
  `TEAM_GOALSFOR` int(2) DEFAULT '0',
  `TEAM_GOALSAGAINST` int(2) DEFAULT '0',
  `TEAM_POINTS` int(2) DEFAULT '0',
  `TEAM_POSITION` int(3) DEFAULT '0',
  `TEAM_GROUP` char(1) DEFAULT NULL,
  `TEAM_CONTINENT` varchar(45) DEFAULT NULL,
  `TEAM_LOGO` varchar(500) DEFAULT NULL,
  `TEAM_FLAG` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `TEAM`
--

INSERT INTO `TEAM` (`TEAM_ID`, `TEAM_NAME`, `TEAM_COACH`, `TEAM_INTMATCHPLAYED`, `TEAM_INTMATCHWON`, `TEAM_INTMATCHLOST`, `TEAM_INTMATCHDRAW`, `TEAM_GOALSFOR`, `TEAM_GOALSAGAINST`, `TEAM_POINTS`, `TEAM_POSITION`, `TEAM_GROUP`, `TEAM_CONTINENT`, `TEAM_LOGO`, `TEAM_FLAG`) VALUES
(1, 'Egypt', '', 0, 0, 0, 0, 0, 0, 0, 0, '', '', NULL, NULL),
(2, 'Morocco', '', 0, 0, 0, 0, 0, 0, 0, 0, '', '', NULL, NULL),
(3, 'Nigeria', '', 0, 0, 0, 0, 0, 0, 0, 0, '', '', NULL, NULL),
(4, 'Senegal', '', 0, 0, 0, 0, 0, 0, 0, 0, '', '', NULL, NULL),
(5, 'Tunisia', '', 0, 0, 0, 0, 0, 0, 0, 0, '', '', NULL, NULL),
(6, 'Australia', '', 0, 0, 0, 0, 0, 0, 0, 0, '', '', NULL, NULL),
(7, 'IR Iran', '', 0, 0, 0, 0, 0, 0, 0, 0, '', '', NULL, NULL),
(8, 'Japan', '', 0, 0, 0, 0, 0, 0, 0, 0, '', '', NULL, NULL),
(9, 'Korea Republic', '', 0, 0, 0, 0, 0, 0, 0, 0, '', '', NULL, NULL),
(10, 'Saudi Arabia', '', 0, 0, 0, 0, 0, 0, 0, 0, '', '', 'saudi_arabia_national_football.png', NULL),
(11, 'Belgium', '', 0, 0, 0, 0, 0, 0, 0, 0, '', '', NULL, NULL),
(12, 'Croatia', '', 0, 0, 0, 0, 0, 0, 0, 0, '', '', NULL, NULL),
(13, 'Denmark', '', 0, 0, 0, 0, 0, 0, 0, 0, '', '', NULL, NULL),
(14, 'England', '', 0, 0, 0, 0, 0, 0, 0, 0, '', '', NULL, NULL),
(15, 'France', '', 0, 0, 0, 0, 0, 0, 0, 0, '', '', NULL, NULL),
(16, 'Germany', '', 0, 0, 0, 0, 0, 0, 0, 0, '', '', NULL, NULL),
(17, 'Iceland', '', 0, 0, 0, 0, 0, 0, 0, 0, '', '', NULL, NULL),
(18, 'Poland', '', 0, 0, 0, 0, 0, 0, 0, 0, '', '', NULL, NULL),
(19, 'Portugal', '', 0, 0, 0, 0, 0, 0, 0, 0, '', '', NULL, NULL),
(20, 'Russia', '', 0, 0, 0, 0, 0, 0, 0, 0, '', '', 'téléchargement (2).png', NULL),
(21, 'Serbia', '', 0, 0, 0, 0, 0, 0, 0, 0, '', '', NULL, NULL),
(22, 'Spain', '', 0, 0, 0, 0, 0, 0, 0, 0, '', '', NULL, NULL),
(23, 'Sweden', '', 0, 0, 0, 0, 0, 0, 0, 0, '', '', NULL, NULL),
(24, 'Switzerland', '', 0, 0, 0, 0, 0, 0, 0, 0, '', '', NULL, NULL),
(25, 'Costa Rica', '', 0, 0, 0, 0, 0, 0, 0, 0, '', '', NULL, NULL),
(26, 'Mexico', '', 0, 0, 0, 0, 0, 0, 0, 0, '', '', NULL, NULL),
(27, 'Panama', '', 0, 0, 0, 0, 0, 0, 0, 0, '', '', NULL, NULL),
(28, 'Argentina', '', 0, 0, 0, 0, 0, 0, 0, 0, '', '', NULL, NULL),
(29, 'Brazil', '', 0, 0, 0, 0, 0, 0, 0, 0, '', '', NULL, NULL),
(30, 'Colombia', '', 0, 0, 0, 0, 0, 0, 0, 0, '', '', NULL, NULL),
(31, 'Peru', '', 0, 0, 0, 0, 0, 0, 0, 0, '', '', NULL, NULL),
(32, 'Uruguay', '', 0, 0, 0, 0, 0, 0, 0, 0, '', '', NULL, NULL);

--
-- Indexes for table `ARTICLE`
--
ALTER TABLE `ARTICLE`
  ADD PRIMARY KEY (`ARTICLE_ID`);

--
-- Indexes for table `GAME`
--
ALTER TABLE `GAME`
  ADD PRIMARY KEY (`GAME_ID`);

--
-- Indexes for table `GOAL`
--
ALTER TABLE `GOAL`
  ADD PRIMARY KEY (`GOAL_ID`),
  ADD KEY `FK_GOAL_GAME` (`GOAL_GAME`),
  ADD KEY `FK_GOAL_PLAYER` (`GOAL_PLAYER`);

--
-- Indexes for table `HOTEL`
--
ALTER TABLE `HOTEL`
  ADD PRIMARY KEY (`HOTEL_ID`);

--
-- Indexes for table `PLAYER`
--
ALTER TABLE `PLAYER`
  ADD PRIMARY KEY (`PLAYER_ID`),
  ADD KEY `FK_PLAYER_TEAM` (`PLAYER_TEAM`);

--
-- Indexes for table `STADIUM`
--
ALTER TABLE `STADIUM`
  ADD PRIMARY KEY (`STADIUM_ID`);

--
-- Indexes for table `STATION`
--
ALTER TABLE `STATION`
  ADD PRIMARY KEY (`STATION_ID`);

--
-- Indexes for table `TEAM`
--
ALTER TABLE `TEAM`
  ADD PRIMARY KEY (`TEAM_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ARTICLE`
--
ALTER TABLE `ARTICLE`
  MODIFY `ARTICLE_ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `GAME`
--
ALTER TABLE `GAME`
  MODIFY `GAME_ID` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=194;

--
-- AUTO_INCREMENT for table `GOAL`
--
ALTER TABLE `GOAL`
  MODIFY `GOAL_ID` int(3) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `HOTEL`
--
ALTER TABLE `HOTEL`
  MODIFY `HOTEL_ID` int(3) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `PLAYER`
--
ALTER TABLE `PLAYER`
  MODIFY `PLAYER_ID` int(4) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `STADIUM`
--
ALTER TABLE `STADIUM`
  MODIFY `STADIUM_ID` int(1) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `STATION`
--
ALTER TABLE `STATION`
  MODIFY `STATION_ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `TEAM`
--
ALTER TABLE `TEAM`
  MODIFY `TEAM_ID` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT for table `USER`
--
ALTER TABLE `USER`
  MODIFY `USER_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

