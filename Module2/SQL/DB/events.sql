-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 27, 2025 at 08:37 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";

START TRANSACTION;

SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */
;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */
;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */
;
/*!40101 SET NAMES utf8mb4 */
;

--
-- Database: `user_management`
--

-- --------------------------------------------------------

--
-- Table structure for table `events`
--

CREATE TABLE `events` (
    `event_id` int(11) NOT NULL,
    `title` varchar(200) NOT NULL,
    `description` text DEFAULT NULL,
    `city` varchar(100) NOT NULL,
    `start_date` datetime NOT NULL,
    `end_date` datetime NOT NULL,
    `status` enum(
        'upcoming',
        'completed',
        'cancelled'
    ) DEFAULT NULL,
    `organizer_id` int(11) DEFAULT NULL
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_general_ci;

--
-- Dumping data for table `events`
--

INSERT INTO
    `events` (
        `event_id`,
        `title`,
        `description`,
        `city`,
        `start_date`,
        `end_date`,
        `status`,
        `organizer_id`
    )
VALUES (
        1,
        'Tech Innovators Meetup',
        'A meetup for tech enthusiasts.',
        'New York',
        '2025-06-10 10:00:00',
        '2025-06-10 16:00:00',
        'upcoming',
        1
    ),
    (
        2,
        'AI & ML Conference',
        'Conference on AI and ML advancements.',
        'Chicago',
        '2025-05-15 09:00:00',
        '2025-05-15 17:00:00',
        'completed',
        3
    ),
    (
        3,
        'Frontend Development Bootcamp',
        'Hands-on training on frontend tech.',
        'Los Angeles',
        '2025-07-01 10:00:00',
        '2025-07-03 16:00:00',
        'upcoming',
        2
    );

--
-- Indexes for dumped tables
--

--
-- Indexes for table `events`
--
ALTER TABLE `events`
ADD PRIMARY KEY (`event_id`),
ADD KEY `organizer_id` (`organizer_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `events`
--
ALTER TABLE `events`
MODIFY `event_id` int(11) NOT NULL AUTO_INCREMENT,
AUTO_INCREMENT = 4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `events`
--
ALTER TABLE `events`
ADD CONSTRAINT `events_ibfk_1` FOREIGN KEY (`organizer_id`) REFERENCES `users` (`user_id`);

COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */
;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */
;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */
;

CREATE TABLE Events (
    event_id INT PRIMARY KEY AUTO_INCREMENT,
    event_name VARCHAR(200) NOT NULL,
    event_date DATE NOT NULL,
    city VARCHAR(100) NOT NULL,
    venue VARCHAR(200) NOT NULL,
    description TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE UserEvents (
    user_id INT,
    event_id INT,
    registration_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (user_id, event_id),
    FOREIGN KEY (user_id) REFERENCES Users (user_id),
    FOREIGN KEY (event_id) REFERENCES Events (event_id)
);

-- Insert sample events
INSERT INTO
    Events (
        event_name,
        event_date,
        city,
        venue,
        description
    )
VALUES (
        'Tech Conference 2024',
        '2024-06-15',
        'New York',
        'Convention Center',
        'Annual technology conference'
    ),
    (
        'Music Festival',
        '2024-07-20',
        'Los Angeles',
        'Downtown Arena',
        'Summer music festival'
    ),
    (
        'Food Expo',
        '2024-08-10',
        'Chicago',
        'Exhibition Hall',
        'International food exhibition'
    ),
    (
        'Art Gallery Opening',
        '2024-06-25',
        'New York',
        'Modern Art Museum',
        'Contemporary art exhibition'
    ),
    (
        'Sports Tournament',
        '2024-07-05',
        'Los Angeles',
        'Sports Complex',
        'Annual sports championship'
    );

-- Register users for events
INSERT INTO
    UserEvents (user_id, event_id)
VALUES (1, 1), -- Alice in Tech Conference
    (1, 4), -- Alice in Art Gallery
    (2, 2), -- Bob in Music Festival
    (2, 5), -- Bob in Sports Tournament
    (3, 3), -- Charlie in Food Expo
    (4, 1), -- Diana in Tech Conference
    (4, 4), -- Diana in Art Gallery
    (5, 2), -- Ethan in Music Festival
    (5, 5);
-- Ethan in Sports Tournament