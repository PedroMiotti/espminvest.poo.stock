CREATE TABLE `espminvest.poo.stock`.`estimate` (
  `estimate_id` INT NOT NULL AUTO_INCREMENT,
  `stock_id` INT NULL,
  `estimate_date` DATETIME NULL,
  `estimate__value` DECIMAL(12,2) NULL,
  PRIMARY KEY (`estimate_id`));

CREATE TABLE `espminvest.poo.stock`.`stock` (
`stock_id` INT NOT NULL,
`stock_name` VARCHAR(45) NULL,
`stock_sign` VARCHAR(45) NULL,
PRIMARY KEY (`stock_id`));