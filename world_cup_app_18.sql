-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Mar 30, 2018 at 05:26 PM
-- Server version: 5.6.38
-- PHP Version: 5.6.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `worldcuptest`
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
-- Table structure for table `fos_user`
--

CREATE TABLE `fos_user` (
  `id` int(11) NOT NULL,
  `username` varchar(180) COLLATE utf8_unicode_ci NOT NULL,
  `username_canonical` varchar(180) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(180) COLLATE utf8_unicode_ci NOT NULL,
  `email_canonical` varchar(180) COLLATE utf8_unicode_ci NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  `salt` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `last_login` datetime DEFAULT NULL,
  `confirmation_token` varchar(180) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password_requested_at` datetime DEFAULT NULL,
  `roles` longtext COLLATE utf8_unicode_ci NOT NULL COMMENT '(DC2Type:array)'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `fos_user`
--

INSERT INTO `fos_user` (`id`, `username`, `username_canonical`, `email`, `email_canonical`, `enabled`, `salt`, `password`, `last_login`, `confirmation_token`, `password_requested_at`, `roles`) VALUES
(1, 'testuser', 'testuser', 'test@example.com', 'test@example.com', 1, NULL, '$2y$13$PlMIKVidCIrkDmFxw6Hm9uEvu6uB5sPAYoHvnavOF4RG24iaBSU9W', NULL, NULL, NULL, 'a:0:{}'),
(3, 'codereview', 'codereview', 'user.chris@codereviewsvideo.com', 'user.chris@codereviewsvideo.com', 1, NULL, '$2y$13$4ZFMLhCEWyia6Ly1DNV9oeM5gF2xo.7AbsKaHn7O3O1KLB3I1cRhC', '2018-03-23 19:41:24', NULL, NULL, 'a:0:{}'),
(4, 'idris', 'idris', 'idris.mahjoubi@esprit.tn', 'idris.mahjoubi@esprit.tn', 1, NULL, '$2y$13$UgYYauGuciqhdRJlm7kMWOMQd3fCaCgAuXBMWG/pyuLhkZWzRRfbK', '2018-03-29 15:55:13', 'AtSzuqDq39Df-QRTYmCP172ndEM9K1bEW8JVf_XITGk', '2018-03-23 19:44:59', 'a:0:{}');

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
-- Table structure for table `NOTE`
--

CREATE TABLE `NOTE` (
  `NOTE_ID` int(11) NOT NULL,
  `PLAYER_ID` int(11) NOT NULL,
  `USER_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `PARTICIPATION`
--

CREATE TABLE `PARTICIPATION` (
  `PARTICIPATION_ID` int(11) NOT NULL,
  `EVENT_ID` int(11) NOT NULL,
  `USER_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `USER`
--

CREATE TABLE `USER` (
  `USER_ID` int(11) NOT NULL,
  `USER_NAME` varchar(30) NOT NULL,
  `USER_LASTNAME` varchar(30) NOT NULL,
  `USER_BIRTHDAY` date NOT NULL,
  `USER_EMAIL` varchar(30) NOT NULL,
  `USER_LOGIN` varchar(30) NOT NULL,
  `USER_PASSWORD` varchar(30) NOT NULL,
  `USER_CIN` varchar(30) DEFAULT NULL,
  `USER_TYPE` varchar(45) NOT NULL DEFAULT 'membre'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `USER`
--

INSERT INTO `USER` (`USER_ID`, `USER_NAME`, `USER_LASTNAME`, `USER_BIRTHDAY`, `USER_EMAIL`, `USER_LOGIN`, `USER_PASSWORD`, `USER_CIN`, `USER_TYPE`) VALUES
(4, 'sdf', 'hjgf', '2018-03-28', 'jhg', 'fjhg', 'fjhg', 'jhgf', 'membre'),
(5, 'kjhg', 'jkh', '2018-03-08', 'hg', 'kjhg', 'jkhg', 'gkj', 'membre');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `fos_user`
--
ALTER TABLE `fos_user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UNIQ_957A647992FC23A8` (`username_canonical`),
  ADD UNIQUE KEY `UNIQ_957A6479A0D96FBF` (`email_canonical`),
  ADD UNIQUE KEY `UNIQ_957A6479C05FB297` (`confirmation_token`);

--
-- Indexes for table `NOTE`
--
ALTER TABLE `NOTE`
  ADD PRIMARY KEY (`NOTE_ID`);

--
-- Indexes for table `PARTICIPATION`
--
ALTER TABLE `PARTICIPATION`
  ADD PRIMARY KEY (`PARTICIPATION_ID`);

--
-- Indexes for table `USER`
--
ALTER TABLE `USER`
  ADD PRIMARY KEY (`USER_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `fos_user`
--
ALTER TABLE `fos_user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `NOTE`
--
ALTER TABLE `NOTE`
  MODIFY `NOTE_ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `PARTICIPATION`
--
ALTER TABLE `PARTICIPATION`
  MODIFY `PARTICIPATION_ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `USER`
--
ALTER TABLE `USER`
  MODIFY `USER_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
