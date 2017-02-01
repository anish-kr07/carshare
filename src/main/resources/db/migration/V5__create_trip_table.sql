CREATE TABLE trips (
  `id`              INT           NOT NULL AUTO_INCREMENT,
  `version`         INT           NOT NULL  DEFAULT 0,
  `duration`        DECIMAL(3,2)  NOT NULL,
  `start_time`      TIMESTAMP     NOT NULL,
  `is_day`          BOOLEAN       NOT NULL,
  `stop_time`       TIMESTAMP     NOT NULL,
  `distance`        DECIMAL(5,2)  NOT NULL,
  `cost`            DECIMAL(5,2)  NOT NULL,
  `tip`             DECIMAL(5,2)  NOT NULL  DEFAULT 0,
  `total_cost`      DECIMAL(9,2)  NOT NULL,
  `created`         TIMESTAMP     NOT NULL  DEFAULT NOW(),
  `modified`        TIMESTAMP     NOT NULL  DEFAULT NOW(),
  PRIMARY KEY (`id`));
