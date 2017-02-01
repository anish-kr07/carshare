CREATE TABLE trips (
  `id`              INT           NOT NULL AUTO_INCREMENT,
  `version`         INT           NOT NULL  DEFAULT 0,
  `duration`        DECIMAL       NOT NULL,
  `start_time`      TIME          NOT NULL,
  `is_day`          BOOLEAN       NOT NULL,
  `stop_time`       TIME          NOT NULL,
  `distance`        DECIMAL       NOT NULL,
  `cost`            DECIMAL       NOT NULL,
  `tip`             DECIMAL       NOT NULL  DEFAULT 0,
  `total_cost`      DECIMAL       NOT NULL,
  `created`         TIMESTAMP     NOT NULL  DEFAULT NOW(),
  `modified`        TIMESTAMP     NOT NULL  DEFAULT NOW(),
  PRIMARY KEY (`id`));
