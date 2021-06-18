CREATE TABLE `bet_info` (
  `bet_info_id` int NOT NULL AUTO_INCREMENT,
  `prize` decimal(7,2) NOT NULL,
  `bet_amount` decimal(7,2) NOT NULL,
  `multiplier` decimal(4,2) NOT NULL,
  `bet_status` varchar(20) NOT NULL DEFAULT 'Waiting',
  `date` datetime NOT NULL,
  `bet_details` varchar(45) NOT NULL,
  `user_id` int NOT NULL,
  `bet_id` int NOT NULL,
  PRIMARY KEY (`bet_info_id`),
  KEY `fk_bet_info_users1_idx` (`user_id`),
  KEY `fk_bet_info_bets1_idx` (`bet_id`),
  CONSTRAINT `fk_bet_info_users1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE `bets` (
  `bet_id` int NOT NULL AUTO_INCREMENT,
  `type_of_bet` varchar(45) NOT NULL DEFAULT 'stopper',
  `first_multiplier` decimal(4,2) DEFAULT NULL,
  `second_multiplier` decimal(4,2) DEFAULT NULL,
  `race_id` int NOT NULL,
  PRIMARY KEY (`bet_id`),
  UNIQUE KEY `bet_id_UNIQUE` (`bet_id`),
  KEY `fk_bets_races1_idx` (`race_id`),
  CONSTRAINT `fk_bets_races1` FOREIGN KEY (`race_id`) REFERENCES `races` (`race_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

CREATE TABLE `participants` (
  `participant_id` int NOT NULL AUTO_INCREMENT,
  `horse` varchar(45) NOT NULL,
  `weight` int NOT NULL,
  `jockey` varchar(45) NOT NULL,
  PRIMARY KEY (`participant_id`),
  UNIQUE KEY `participant_id_UNIQUE` (`participant_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

CREATE TABLE `payment_cards` (
  `payment_cards_id` int NOT NULL AUTO_INCREMENT,
  `balance` decimal(8,2) NOT NULL,
  `card_number` varchar(16) NOT NULL,
  PRIMARY KEY (`payment_cards_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

CREATE TABLE `race_data` (
  `race_data_id` int NOT NULL AUTO_INCREMENT,
  `date` datetime NOT NULL,
  `participant_id` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`race_data_id`),
  KEY `fk_race_data_participants1_idx` (`participant_id`),
  CONSTRAINT `fk_race_data_participants1` FOREIGN KEY (`participant_id`) REFERENCES `participants` (`participant_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

CREATE TABLE `races` (
  `race_id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `rounds` int NOT NULL,
  `details` varchar(100) NOT NULL,
  `race_data_id` int NOT NULL,
  PRIMARY KEY (`race_id`),
  UNIQUE KEY `race_id_UNIQUE` (`race_id`),
  KEY `fk_race_race_data1_idx` (`race_data_id`),
  CONSTRAINT `fk_race_race_data1` FOREIGN KEY (`race_data_id`) REFERENCES `race_data` (`race_data_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

CREATE TABLE `roles` (
  `role_id` int NOT NULL,
  `role_name` varchar(20) NOT NULL,
  PRIMARY KEY (`role_id`),
  UNIQUE KEY `role_id_UNIQUE` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `users` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(45) NOT NULL,
  `login` varchar(16) NOT NULL,
  `password` varchar(40) NOT NULL,
  `amount_of_bets` int DEFAULT '0',
  `is_approved` tinyint DEFAULT '0',
  `role_id` int NOT NULL DEFAULT '1',
  `wallet_id` int NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `id_UNIQUE` (`user_id`),
  KEY `fk_users_roles_idx` (`role_id`),
  KEY `fk_users_wallet1_idx` (`wallet_id`),
  CONSTRAINT `fk_users_roles` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`),
  CONSTRAINT `fk_users_wallet1` FOREIGN KEY (`wallet_id`) REFERENCES `wallets` (`wallet_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

CREATE TABLE `wallets` (
  `wallet_id` int NOT NULL AUTO_INCREMENT,
  `balance` decimal(7,2) NOT NULL,
  PRIMARY KEY (`wallet_id`),
  UNIQUE KEY `wallet_id_UNIQUE` (`wallet_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
