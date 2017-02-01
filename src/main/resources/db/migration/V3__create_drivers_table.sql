CREATE TABLE drivers (
  `id`              INT         NOT NULL AUTO_INCREMENT,
  `version`         INT         NOT NULL  DEFAULT 0,
  `name`            VARCHAR(45) NOT NULL,
  `age`             INT         NOT NULL,
  `gender`          ENUM('MALE', 'FEMALE','OTHERS') NOT NULL,
  `licenseno`       VARCHAR(45) NOT NULL,
  `violation_count` INT         NOT NULL  DEFAULT 0,
  `created`         TIMESTAMP   NOT NULL  DEFAULT NOW(),
  `modified`        TIMESTAMP   NOT NULL  DEFAULT NOW(),
  PRIMARY KEY (`id`));
