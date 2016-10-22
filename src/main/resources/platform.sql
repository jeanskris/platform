-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema InfoPlatform
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema InfoPlatform
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `InfoPlatform` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
-- -----------------------------------------------------
-- Schema infoplatform
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema infoplatform
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `infoplatform` DEFAULT CHARACTER SET utf8 ;
USE `InfoPlatform` ;

-- -----------------------------------------------------
-- Table `InfoPlatform`.`servers`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `InfoPlatform`.`servers` ;

CREATE TABLE IF NOT EXISTS `InfoPlatform`.`servers` (
  `serverid` INT NOT NULL COMMENT '',
  `servername` VARCHAR(45) NULL COMMENT '',
  `connectStatus` VARCHAR(45) NULL COMMENT '',
  PRIMARY KEY (`serverid`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `InfoPlatform`.`API`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `InfoPlatform`.`API` ;

CREATE TABLE IF NOT EXISTS `InfoPlatform`.`API` (
  `idAPI` INT NOT NULL COMMENT '',
  `serverid` INT NOT NULL COMMENT '',
  `packagedAPI` VARCHAR(45) NULL COMMENT '',
  `originalAPI` VARCHAR(45) NULL COMMENT '',
  `returnData` VARCHAR(45) NULL COMMENT ' no request methods or parameter, the validation about those are completed on oringinal server.Here we just receive return data or some error message, and send it to target server.',
  PRIMARY KEY (`idAPI`)  COMMENT '',
  UNIQUE INDEX `idAPI_UNIQUE` (`idAPI` ASC)  COMMENT '',
  INDEX `fk_API_servers_idx` (`serverid` ASC)  COMMENT '',
  CONSTRAINT `fk_API_servers`
    FOREIGN KEY (`serverid`)
    REFERENCES `InfoPlatform`.`servers` (`serverid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `InfoPlatform`.`User`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `InfoPlatform`.`User` ;

CREATE TABLE IF NOT EXISTS `InfoPlatform`.`User` (
  `PrivateID` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `UUID` VARCHAR(64) NOT NULL COMMENT '',
  `IDCardNumber` VARCHAR(18) NULL COMMENT '',
  `UserName` VARCHAR(45) NULL COMMENT '',
  `PhoneNum` VARCHAR(20) NULL COMMENT '',
  `Password` VARCHAR(32) NULL COMMENT 'MD5',
  `Sex` VARCHAR(45) NULL COMMENT '',
  `Attachment` VARCHAR(120) NULL COMMENT '',
  UNIQUE INDEX `PrivateID_UNIQUE` (`PrivateID` ASC)  COMMENT '',
  UNIQUE INDEX `UUID_UNIQUE` (`UUID` ASC)  COMMENT '',
  PRIMARY KEY (`PrivateID`)  COMMENT '',
  UNIQUE INDEX `IDCardNumber_UNIQUE` (`IDCardNumber` ASC)  COMMENT '',
  UNIQUE INDEX `PhoneNum_UNIQUE` (`PhoneNum` ASC)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `InfoPlatform`.`Developer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `InfoPlatform`.`Developer` ;

CREATE TABLE IF NOT EXISTS `InfoPlatform`.`Developer` (
  `DeveloperID` VARCHAR(64) NOT NULL COMMENT '',
  `User_UUID` VARCHAR(64) NOT NULL COMMENT '',
  PRIMARY KEY (`DeveloperID`, `User_UUID`)  COMMENT '',
  INDEX `fk_Developer_User1_idx` (`User_UUID` ASC)  COMMENT '',
  CONSTRAINT `fk_Developer_User1`
    FOREIGN KEY (`User_UUID`)
    REFERENCES `InfoPlatform`.`User` (`UUID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `InfoPlatform`.`Application`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `InfoPlatform`.`Application` ;

CREATE TABLE IF NOT EXISTS `InfoPlatform`.`Application` (
  `APPID` VARCHAR(64) NOT NULL COMMENT '',
  `APPName` VARCHAR(100) NOT NULL COMMENT '',
  `DeveloperID` VARCHAR(64) NOT NULL COMMENT '',
  `URL` VARCHAR(100) NULL COMMENT '',
  `Categary` VARCHAR(45) NULL COMMENT '',
  `Description` VARCHAR(200) NULL COMMENT '',
  `Logo` VARCHAR(200) NULL COMMENT '',
  `Tags` VARCHAR(100) NULL COMMENT '',
  PRIMARY KEY (`APPID`)  COMMENT '',
  UNIQUE INDEX `APPName_UNIQUE` (`APPName` ASC)  COMMENT '',
  UNIQUE INDEX `URL_UNIQUE` (`URL` ASC)  COMMENT '',
  INDEX `fk_Application_Developer1_idx` (`DeveloperID` ASC)  COMMENT '',
  CONSTRAINT `fk_Application_Developer1`
    FOREIGN KEY (`DeveloperID`)
    REFERENCES `InfoPlatform`.`Developer` (`DeveloperID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `InfoPlatform`.`Interface`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `InfoPlatform`.`Interface` ;

CREATE TABLE IF NOT EXISTS `InfoPlatform`.`Interface` (
  `InterfaceID` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `DataAddr` VARCHAR(200) NULL COMMENT '',
  `Method` VARCHAR(45) NULL COMMENT 'WS/RPC/Http',
  `Parameters` VARCHAR(100) NULL COMMENT '',
  `APPID` VARCHAR(64) NOT NULL COMMENT '',
  PRIMARY KEY (`InterfaceID`)  COMMENT '',
  INDEX `fk_Interface_Application1_idx` (`APPID` ASC)  COMMENT '',
  CONSTRAINT `fk_Interface_Application1`
    FOREIGN KEY (`APPID`)
    REFERENCES `InfoPlatform`.`Application` (`APPID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `infoplatform` ;

-- -----------------------------------------------------
-- Table `infoplatform`.`servers`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `infoplatform`.`servers` ;

CREATE TABLE IF NOT EXISTS `infoplatform`.`servers` (
  `serverid` INT(11) NOT NULL COMMENT '',
  `servername` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `connectStatus` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`serverid`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `infoplatform`.`api`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `infoplatform`.`api` ;

CREATE TABLE IF NOT EXISTS `infoplatform`.`api` (
  `idAPI` INT(11) NOT NULL COMMENT '',
  `serverid` INT(11) NOT NULL COMMENT '',
  `packagedAPI` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `originalAPI` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `returnData` VARCHAR(45) NULL DEFAULT NULL COMMENT ' no request methods or parameter, the validation about those are completed on oringinal server.Here we just receive return data or some error message, and send it to target server.',
  PRIMARY KEY (`idAPI`)  COMMENT '',
  UNIQUE INDEX `idAPI_UNIQUE` (`idAPI` ASC)  COMMENT '',
  INDEX `fk_API_servers_idx` (`serverid` ASC)  COMMENT '',
  CONSTRAINT `fk_API_servers`
    FOREIGN KEY (`serverid`)
    REFERENCES `infoplatform`.`servers` (`serverid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
