CREATE TABLE `second_entity` (
  `id` varchar(255) NOT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `first_entity` (
  `id` varchar(255) NOT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `joins` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_joins_idx` (`joins`),
  CONSTRAINT `FK_joins` FOREIGN KEY (`joins`) REFERENCES `join_entity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `join_entity` (
  `id` varchar(255) NOT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `first_entity_id` varchar(255) DEFAULT NULL,
  `second_entity_id` varchar(255) DEFAULT NULL,
  `reason` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_secondentityid_idx` (`second_entity_id`),
  KEY `FK_firstentityid_idx` (`first_entity_id`),
  CONSTRAINT `FK_firstentityid` FOREIGN KEY (`first_entity_id`) REFERENCES `first_entity` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_secondentityid` FOREIGN KEY (`second_entity_id`) REFERENCES `second_entity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `custom_name` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `first_entity_custom_name` (
  `first_entity_id` varchar(255) DEFAULT NULL,
  `custom_name_id` varchar(255) DEFAULT NULL,
  UNIQUE KEY `UNIQUE` (`first_entity_id`,`custom_name_id`),
  KEY `FK_first_entity_idx` (`first_entity_id`),
  KEY `FK_custom_name2_idx` (`custom_name_id`),
  CONSTRAINT `FK_custom_name2` FOREIGN KEY (`custom_name_id`) REFERENCES `custom_name` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_first_entity2` FOREIGN KEY (`first_entity_id`) REFERENCES `first_entity` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;