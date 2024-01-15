-- -----------------------------------------------------
-- Schema food_techchallenge
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `food_techchallenge` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `food_techchallenge` ;

-- -----------------------------------------------------
-- Table `food_techchallenge`.`categorias`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `food_techchallenge`.`categorias` (
  `id` BIGINT NOT NULL,
  `descricao` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `food_techchallenge`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `food_techchallenge`.`user` (
  `id` BIGINT NOT NULL,
  `cpf` VARCHAR(255) NULL DEFAULT NULL,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `nome` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UK_2qv8vmk5wxu215bevli5derq` (`cpf` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `food_techchallenge`.`pedidos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `food_techchallenge`.`pedidos` (
  `id` BIGINT NOT NULL,
  `datapedido` DATETIME(6) NULL DEFAULT NULL,
  `order_status` VARCHAR(255) NULL DEFAULT NULL,
  `total` FLOAT NULL DEFAULT NULL,
  `user_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKfsfnec7aligosf4a9uwd90x9d` (`user_id` ASC) VISIBLE,
  CONSTRAINT `FKfsfnec7aligosf4a9uwd90x9d`
    FOREIGN KEY (`user_id`)
    REFERENCES `food_techchallenge`.`user` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `food_techchallenge`.`produtos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `food_techchallenge`.`produtos` (
  `id` BIGINT NOT NULL,
  `categoria_id` BIGINT NULL DEFAULT NULL,
  `descricao` VARCHAR(255) NULL DEFAULT NULL,
  `nome` VARCHAR(255) NULL DEFAULT NULL,
  `preco` FLOAT NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `food_techchallenge`.`itenspedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `food_techchallenge`.`itenspedido` (
  `id` BIGINT NOT NULL,
  `pedido_id` BIGINT NULL DEFAULT NULL,
  `produto_id` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK1sfuslkhoh2oa3ps0fom0muxm` (`pedido_id` ASC) VISIBLE,
  INDEX `FK9yhqgrgxeymyxf8xpli8hry43` (`produto_id` ASC) VISIBLE,
  CONSTRAINT `FK1sfuslkhoh2oa3ps0fom0muxm`
    FOREIGN KEY (`pedido_id`)
    REFERENCES `food_techchallenge`.`pedidos` (`id`),
  CONSTRAINT `FK9yhqgrgxeymyxf8xpli8hry43`
    FOREIGN KEY (`produto_id`)
    REFERENCES `food_techchallenge`.`produtos` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;



--INSERT INTO `food_techchallenge`.`categorias` (`id`, `descricao`) VALUES ('1', 'Lanche');
--INSERT INTO `food_techchallenge`.`categorias` (`id`, `descricao`) VALUES ('2', 'Acompanhamento');
--INSERT INTO `food_techchallenge`.`categorias` (`id`, `descricao`) VALUES ('3', 'Bebida');
--INSERT INTO `food_techchallenge`.`categorias` (`id`, `descricao`) VALUES ('4', 'Sobremesa');
