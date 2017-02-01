CREATE TABLE cars (
  `id`        INT         NOT NULL AUTO_INCREMENT,
  `version`   INT         NOT NULL  DEFAULT 0,
  `make`      VARCHAR(45) NOT NULL,
  `model`     VARCHAR(45) NOT NULL,
  `year`      INT         NOT NULL,
  `type`      ENUM('BASIC', 'LUX') NOT NULL,
  `carno`     VARCHAR(45) NOT NULL,
`lux_charge`  INT         NOT NULL DEFAULT 0,
  `created`   TIMESTAMP   NOT NULL  DEFAULT NOW(),
  `modified`  TIMESTAMP   NOT NULL  DEFAULT NOW(),
  PRIMARY KEY (`id`));
