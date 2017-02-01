CREATE TABLE cities (
  `id`        INT         NOT NULL  AUTO_INCREMENT,
  `version`   INT         NOT NULL  DEFAULT 0,
  `name`      VARCHAR(45) NOT NULL,
  `state`     VARCHAR(45) NOT NULL,
  `dayrate`   INT         NOT NULL,
  `nightrate` INT         NOT NULL,
  `created`   TIMESTAMP   NOT NULL  DEFAULT NOW(),
  `modified`  TIMESTAMP   NOT NULL  DEFAULT NOW(),
  PRIMARY KEY (`id`));
