SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `cinemaudea` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `cinemaudea` ;

-- -----------------------------------------------------
-- Table `cinemaudea`.`socio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemaudea`.`socio` (
  `idsocio` INT NOT NULL AUTO_INCREMENT,
  `tipodocumento` VARCHAR(3) NOT NULL,
  `nrodocumento` VARCHAR(20) NOT NULL,
  `nombre` VARCHAR(60) NOT NULL,
  `apellidos` VARCHAR(60) NULL,
  `fechanacimiento` DATE NULL,
  `genero` VARCHAR(1) NOT NULL,
  `email` VARCHAR(120) NOT NULL,
  `contrasena` VARCHAR(60) NOT NULL,
  `telefono` VARCHAR(45) NULL,
  `celular` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`idsocio`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cinemaudea`.`pais`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemaudea`.`pais` (
  `codigopais` VARCHAR(3) NOT NULL,
  `nombre` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`codigopais`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cinemaudea`.`pelicula`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemaudea`.`pelicula` (
  `idpelicula` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `fecha` VARCHAR(45) NOT NULL,
  `sinopsis` TEXT NOT NULL,
  `duracion` INT NOT NULL,
  `url_imagen` VARCHAR(120) NOT NULL,
  `pais` VARCHAR(3) NOT NULL,
  PRIMARY KEY (`idpelicula`),
  INDEX `fk_pelicula_pais1_idx` (`pais` ASC),
  CONSTRAINT `fk_pelicula_pais1`
    FOREIGN KEY (`pais`)
    REFERENCES `cinemaudea`.`pais` (`codigopais`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cinemaudea`.`persona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemaudea`.`persona` (
  `idpersona` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(120) NOT NULL,
  `pais` VARCHAR(3) NOT NULL,
  PRIMARY KEY (`idpersona`),
  INDEX `fk_persona_pais1_idx` (`pais` ASC),
  CONSTRAINT `fk_persona_pais1`
    FOREIGN KEY (`pais`)
    REFERENCES `cinemaudea`.`pais` (`codigopais`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cinemaudea`.`elenco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemaudea`.`elenco` (
  `idelenco` INT NOT NULL AUTO_INCREMENT,
  `pelicula` INT NOT NULL,
  `persona` INT NOT NULL,
  `personaje` VARCHAR(100) NOT NULL,
  INDEX `fk_elenco_pelicula1_idx` (`pelicula` ASC),
  INDEX `fk_elenco_persona1_idx` (`persona` ASC),
  PRIMARY KEY (`idelenco`),
  CONSTRAINT `fk_elenco_pelicula1`
    FOREIGN KEY (`pelicula`)
    REFERENCES `cinemaudea`.`pelicula` (`idpelicula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_elenco_persona1`
    FOREIGN KEY (`persona`)
    REFERENCES `cinemaudea`.`persona` (`idpersona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cinemaudea`.`equipo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemaudea`.`equipo` (
  `idequipo` INT NOT NULL AUTO_INCREMENT,
  `pelicula` INT NOT NULL,
  `persona` INT NOT NULL,
  `actividad` VARCHAR(50) NOT NULL,
  INDEX `fk_equipo_pelicula_idx` (`pelicula` ASC),
  INDEX `fk_equipo_persona1_idx` (`persona` ASC),
  PRIMARY KEY (`idequipo`),
  CONSTRAINT `fk_equipo_pelicula`
    FOREIGN KEY (`pelicula`)
    REFERENCES `cinemaudea`.`pelicula` (`idpelicula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_equipo_persona1`
    FOREIGN KEY (`persona`)
    REFERENCES `cinemaudea`.`persona` (`idpersona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cinemaudea`.`calificacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemaudea`.`calificacion` (
  `idcalificacion` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATETIME NOT NULL,
  `calificacion` FLOAT NOT NULL,
  `comentario` TEXT NULL,
  `pelicula` INT NOT NULL,
  `socio` INT NOT NULL,
  PRIMARY KEY (`idcalificacion`),
  INDEX `fk_calificacion_pelicula1_idx` (`pelicula` ASC),
  INDEX `fk_calificacion_socio1_idx` (`socio` ASC),
  CONSTRAINT `fk_calificacion_pelicula1`
    FOREIGN KEY (`pelicula`)
    REFERENCES `cinemaudea`.`pelicula` (`idpelicula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_calificacion_socio1`
    FOREIGN KEY (`socio`)
    REFERENCES `cinemaudea`.`socio` (`idsocio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cinemaudea`.`genero`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemaudea`.`genero` (
  `idgenero` INT NOT NULL AUTO_INCREMENT,
  `genero` VARCHAR(60) NOT NULL,
  `descripcion` TEXT NULL,
  PRIMARY KEY (`idgenero`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cinemaudea`.`idioma`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemaudea`.`idioma` (
  `ididioma` INT NOT NULL AUTO_INCREMENT,
  `idioma` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ididioma`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cinemaudea`.`formato`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemaudea`.`formato` (
  `idformato` INT NOT NULL AUTO_INCREMENT,
  `formato` VARCHAR(45) NOT NULL,
  `proyeccion` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`idformato`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cinemaudea`.`formato_pelicula`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemaudea`.`formato_pelicula` (
  `formatopelicula` INT NOT NULL AUTO_INCREMENT,
  `pelicula` INT NOT NULL,
  `idioma` INT NOT NULL,
  `subtitulos` INT NULL,
  `formato` INT NOT NULL,
  PRIMARY KEY (`formatopelicula`),
  INDEX `fk_formato_pelicula_pelicula1_idx` (`pelicula` ASC),
  INDEX `fk_formato_pelicula_idioma1_idx` (`idioma` ASC),
  INDEX `fk_formato_pelicula_idioma2_idx` (`subtitulos` ASC),
  INDEX `fk_formato_pelicula_formato1_idx` (`formato` ASC),
  CONSTRAINT `fk_formato_pelicula_pelicula1`
    FOREIGN KEY (`pelicula`)
    REFERENCES `cinemaudea`.`pelicula` (`idpelicula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_formato_pelicula_idioma1`
    FOREIGN KEY (`idioma`)
    REFERENCES `cinemaudea`.`idioma` (`ididioma`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_formato_pelicula_idioma2`
    FOREIGN KEY (`subtitulos`)
    REFERENCES `cinemaudea`.`idioma` (`ididioma`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_formato_pelicula_formato1`
    FOREIGN KEY (`formato`)
    REFERENCES `cinemaudea`.`formato` (`idformato`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cinemaudea`.`cartelera`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemaudea`.`cartelera` (
  `idcartelera` INT NOT NULL AUTO_INCREMENT,
  `fechainicio` DATE NOT NULL,
  `fechafin` DATE NOT NULL,
  `formatopelicula` INT NOT NULL,
  PRIMARY KEY (`idcartelera`),
  INDEX `fk_cartelera_formato_pelicula1_idx` (`formatopelicula` ASC),
  CONSTRAINT `fk_cartelera_formato_pelicula1`
    FOREIGN KEY (`formatopelicula`)
    REFERENCES `cinemaudea`.`formato_pelicula` (`formatopelicula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cinemaudea`.`teatro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemaudea`.`teatro` (
  `idteatro` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(120) NOT NULL,
  `direccion` VARCHAR(120) NOT NULL,
  `telefono` VARCHAR(45) NOT NULL,
  `ciudad` VARCHAR(45) NULL,
  PRIMARY KEY (`idteatro`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cinemaudea`.`sala`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemaudea`.`sala` (
  `idsala` INT NOT NULL AUTO_INCREMENT,
  `ubicacion` VARCHAR(45) NOT NULL,
  `sillas` INT NOT NULL,
  `teatro` INT NOT NULL,
  PRIMARY KEY (`idsala`),
  INDEX `fk_sala_teatro1_idx` (`teatro` ASC),
  CONSTRAINT `fk_sala_teatro1`
    FOREIGN KEY (`teatro`)
    REFERENCES `cinemaudea`.`teatro` (`idteatro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cinemaudea`.`localidad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemaudea`.`localidad` (
  `idlocalidad` VARCHAR(6) NOT NULL,
  `localidad` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`idlocalidad`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cinemaudea`.`silla`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemaudea`.`silla` (
  `idsilla` INT NOT NULL AUTO_INCREMENT,
  `letra` VARCHAR(4) NOT NULL,
  `numero` INT(4) NOT NULL,
  `sala` INT NOT NULL,
  `localidad` VARCHAR(6) NOT NULL,
  PRIMARY KEY (`idsilla`),
  INDEX `fk_silla_sala1_idx` (`sala` ASC),
  INDEX `fk_silla_localidad1_idx` (`localidad` ASC),
  CONSTRAINT `fk_silla_sala1`
    FOREIGN KEY (`sala`)
    REFERENCES `cinemaudea`.`sala` (`idsala`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_silla_localidad1`
    FOREIGN KEY (`localidad`)
    REFERENCES `cinemaudea`.`localidad` (`idlocalidad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cinemaudea`.`funcion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemaudea`.`funcion` (
  `idfuncion` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATE NOT NULL,
  `inicio` TIME NOT NULL,
  `fin` TIME NOT NULL,
  `sala` INT NOT NULL,
  `cartelera` INT NOT NULL,
  PRIMARY KEY (`idfuncion`),
  INDEX `fk_funcion_sala1_idx` (`sala` ASC),
  INDEX `fk_funcion_cartelera1_idx` (`cartelera` ASC),
  CONSTRAINT `fk_funcion_sala1`
    FOREIGN KEY (`sala`)
    REFERENCES `cinemaudea`.`sala` (`idsala`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_funcion_cartelera1`
    FOREIGN KEY (`cartelera`)
    REFERENCES `cinemaudea`.`cartelera` (`idcartelera`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cinemaudea`.`estado_boleta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemaudea`.`estado_boleta` (
  `idestadoboleta` INT NOT NULL AUTO_INCREMENT,
  `estado` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idestadoboleta`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cinemaudea`.`boleta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemaudea`.`boleta` (
  `idboleta` INT NOT NULL AUTO_INCREMENT,
  `silla` INT NOT NULL,
  `funcion` INT NOT NULL,
  `socio` INT NULL,
  `estadoboleta` INT NOT NULL,
  PRIMARY KEY (`idboleta`),
  INDEX `fk_boleta_silla1_idx` (`silla` ASC),
  INDEX `fk_boleta_funcion1_idx` (`funcion` ASC),
  INDEX `fk_boleta_socio1_idx` (`socio` ASC),
  INDEX `fk_boleta_estado_boleta1_idx` (`estadoboleta` ASC),
  CONSTRAINT `fk_boleta_silla1`
    FOREIGN KEY (`silla`)
    REFERENCES `cinemaudea`.`silla` (`idsilla`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_boleta_funcion1`
    FOREIGN KEY (`funcion`)
    REFERENCES `cinemaudea`.`funcion` (`idfuncion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_boleta_socio1`
    FOREIGN KEY (`socio`)
    REFERENCES `cinemaudea`.`socio` (`idsocio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_boleta_estado_boleta1`
    FOREIGN KEY (`estadoboleta`)
    REFERENCES `cinemaudea`.`estado_boleta` (`idestadoboleta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cinemaudea`.`transaccion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemaudea`.`transaccion` (
  `idtransaccion` VARCHAR(50) NOT NULL,
  `descripcion` VARCHAR(255) NOT NULL,
  `amount` FLOAT NOT NULL,
  `tax` FLOAT NOT NULL,
  `taxreturnbase` INT(32) NOT NULL,
  `signature` VARCHAR(50) NOT NULL,
  `currency` VARCHAR(50) NOT NULL,
  `transactionstate` INT(2) NULL,
  `polresponsecode` VARCHAR(64) NULL,
  `socio` INT NOT NULL,
  PRIMARY KEY (`idtransaccion`),
  INDEX `fk_transaccion_socio1_idx` (`socio` ASC),
  CONSTRAINT `fk_transaccion_socio1`
    FOREIGN KEY (`socio`)
    REFERENCES `cinemaudea`.`socio` (`idsocio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cinemaudea`.`compras`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemaudea`.`compras` (
  `transaccion` VARCHAR(50) NOT NULL,
  `boleta` INT NOT NULL,
  INDEX `fk_compras_transaccion1_idx` (`transaccion` ASC),
  INDEX `fk_compras_boleta1_idx` (`boleta` ASC),
  PRIMARY KEY (`transaccion`, `boleta`),
  CONSTRAINT `fk_compras_transaccion1`
    FOREIGN KEY (`transaccion`)
    REFERENCES `cinemaudea`.`transaccion` (`idtransaccion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_compras_boleta1`
    FOREIGN KEY (`boleta`)
    REFERENCES `cinemaudea`.`boleta` (`idboleta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cinemaudea`.`tarifa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemaudea`.`tarifa` (
  `idtarifa` INT NOT NULL AUTO_INCREMENT,
  `formato` INT NOT NULL,
  `localidad` VARCHAR(6) NOT NULL,
  `contarjeta` FLOAT NULL,
  `sintarjeta` FLOAT NULL,
  `puntos` INT NULL,
  PRIMARY KEY (`idtarifa`),
  INDEX `fk_tarifa_formato1_idx` (`formato` ASC),
  INDEX `fk_tarifa_localidad1_idx` (`localidad` ASC),
  CONSTRAINT `fk_tarifa_formato1`
    FOREIGN KEY (`formato`)
    REFERENCES `cinemaudea`.`formato` (`idformato`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tarifa_localidad1`
    FOREIGN KEY (`localidad`)
    REFERENCES `cinemaudea`.`localidad` (`idlocalidad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cinemaudea`.`producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemaudea`.`producto` (
  `idproducto` INT NOT NULL AUTO_INCREMENT,
  `producto` VARCHAR(120) NOT NULL,
  `valor` FLOAT NOT NULL,
  `puntos_redimir` INT NULL,
  `puntos_acumular` INT NULL,
  PRIMARY KEY (`idproducto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cinemaudea`.`redime`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemaudea`.`redime` (
  `idredime` INT NOT NULL AUTO_INCREMENT,
  `producto` INT NOT NULL,
  `socio` INT NOT NULL,
  `puntos` INT NOT NULL,
  `fecha` DATE NOT NULL,
  `cantidad` INT NULL,
  PRIMARY KEY (`idredime`),
  INDEX `fk_redime_producto1_idx` (`producto` ASC),
  INDEX `fk_redime_socio1_idx` (`socio` ASC),
  CONSTRAINT `fk_redime_producto1`
    FOREIGN KEY (`producto`)
    REFERENCES `cinemaudea`.`producto` (`idproducto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_redime_socio1`
    FOREIGN KEY (`socio`)
    REFERENCES `cinemaudea`.`socio` (`idsocio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cinemaudea`.`compra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemaudea`.`compra` (
  `idcompra` INT NOT NULL AUTO_INCREMENT,
  `producto` INT NOT NULL,
  `socio` INT NOT NULL,
  `puntos` INT NOT NULL,
  `fecha` DATE NULL,
  `cantidad` INT NULL,
  INDEX `fk_compra_producto1_idx` (`producto` ASC),
  INDEX `fk_compra_socio1_idx` (`socio` ASC),
  PRIMARY KEY (`idcompra`),
  CONSTRAINT `fk_compra_producto1`
    FOREIGN KEY (`producto`)
    REFERENCES `cinemaudea`.`producto` (`idproducto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_compra_socio1`
    FOREIGN KEY (`socio`)
    REFERENCES `cinemaudea`.`socio` (`idsocio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cinemaudea`.`generos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemaudea`.`generos` (
  `idgeneros` INT NOT NULL AUTO_INCREMENT,
  `pelicula_idpelicula` INT NOT NULL,
  `genero_idgenero` INT NOT NULL,
  PRIMARY KEY (`idgeneros`),
  INDEX `fk_generos_pelicula1_idx` (`pelicula_idpelicula` ASC),
  INDEX `fk_generos_genero1_idx` (`genero_idgenero` ASC),
  CONSTRAINT `fk_generos_pelicula1`
    FOREIGN KEY (`pelicula_idpelicula`)
    REFERENCES `cinemaudea`.`pelicula` (`idpelicula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_generos_genero1`
    FOREIGN KEY (`genero_idgenero`)
    REFERENCES `cinemaudea`.`genero` (`idgenero`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `cinemaudea`.`socio`
-- -----------------------------------------------------
START TRANSACTION;
USE `cinemaudea`;
INSERT INTO `cinemaudea`.`socio` (`idsocio`, `tipodocumento`, `nrodocumento`, `nombre`, `apellidos`, `fechanacimiento`, `genero`, `email`, `contrasena`, `telefono`, `celular`) VALUES (1, 'CC', '1040', 'Socio', 'Apellidos', NULL, 'M', 'socio@socio.com', '1b1844daa452df42c6f9123857ca686c', '5222222', '3000000000');
INSERT INTO `cinemaudea`.`socio` (`idsocio`, `tipodocumento`, `nrodocumento`, `nombre`, `apellidos`, `fechanacimiento`, `genero`, `email`, `contrasena`, `telefono`, `celular`) VALUES (2, 'CC', '1111', 'Socio 2', 'Apellidos', NULL, 'M', 'socio1@socio.com', '1b1844daa452df42c6f9123857ca686c', '522214', '3001000000');

COMMIT;


-- -----------------------------------------------------
-- Data for table `cinemaudea`.`pais`
-- -----------------------------------------------------
START TRANSACTION;
USE `cinemaudea`;
INSERT INTO `cinemaudea`.`pais` (`codigopais`, `nombre`) VALUES ('CO', 'Colombia');
INSERT INTO `cinemaudea`.`pais` (`codigopais`, `nombre`) VALUES ('US', 'Estados Unidos');

COMMIT;


-- -----------------------------------------------------
-- Data for table `cinemaudea`.`pelicula`
-- -----------------------------------------------------
START TRANSACTION;
USE `cinemaudea`;
INSERT INTO `cinemaudea`.`pelicula` (`idpelicula`, `nombre`, `fecha`, `sinopsis`, `duracion`, `url_imagen`, `pais`) VALUES (1, 'SwordFish', '2001-12-12', 'Stanley Jobson (Hugh Jackman), un experto en informática que acaba de salir de prisión, es requerido por el terrorista Gabriel Shear (John Travolta) para que le ayude a decodificar un complicado código de seguridad de una cuenta secreta. Sólo unos pocos hackers en el mundo son capaces de realizar dicho trabajo, y él es uno de ellos', 210, 'swordfish.jpg', 'US');
INSERT INTO `cinemaudea`.`pelicula` (`idpelicula`, `nombre`, `fecha`, `sinopsis`, `duracion`, `url_imagen`, `pais`) VALUES (2, 'Dracula: The Dark Prince', '2014-01-01', 'In his search for the Lightbringer, Dracula crosses paths with a beautiful crusader named Alina who bears a remarkable resemblance to his murdered bride. One look at her and Dracula', 160, 'dracula.jpg', 'US');
INSERT INTO `cinemaudea`.`pelicula` (`idpelicula`, `nombre`, `fecha`, `sinopsis`, `duracion`, `url_imagen`, `pais`) VALUES (3, '60 Segundos', '2001-10-10', 'Hace ya tiempo que Randall \"Memphis\" Raines ha dejado atrás su pasado delictivo. Pero cuando se entera de que su hermano está en peligro, para salvarlo se ve obligado a hacer lo que mejor sabe hacer: robar coches: 50 coches y un contrato. Fanático del automovilismo, Memphis es una leyenda en el negocio de robo de coches. No se le resiste ninguna cerradura, ninguna alarma', 232, '60segundos.jpg', 'US');

COMMIT;


-- -----------------------------------------------------
-- Data for table `cinemaudea`.`persona`
-- -----------------------------------------------------
START TRANSACTION;
USE `cinemaudea`;
INSERT INTO `cinemaudea`.`persona` (`idpersona`, `nombre`, `pais`) VALUES (1, 'Halle Berry', 'US');
INSERT INTO `cinemaudea`.`persona` (`idpersona`, `nombre`, `pais`) VALUES (2, 'Hugh Jackman', 'US');
INSERT INTO `cinemaudea`.`persona` (`idpersona`, `nombre`, `pais`) VALUES (3, 'John Travolta', 'US');
INSERT INTO `cinemaudea`.`persona` (`idpersona`, `nombre`, `pais`) VALUES (4, 'Nicolas Cage', 'US');

COMMIT;


-- -----------------------------------------------------
-- Data for table `cinemaudea`.`elenco`
-- -----------------------------------------------------
START TRANSACTION;
USE `cinemaudea`;
INSERT INTO `cinemaudea`.`elenco` (`idelenco`, `pelicula`, `persona`, `personaje`) VALUES (NULL, 1, 1, 'Ginger Knowles');
INSERT INTO `cinemaudea`.`elenco` (`idelenco`, `pelicula`, `persona`, `personaje`) VALUES (NULL, 1, 2, 'Stanley Jobson');
INSERT INTO `cinemaudea`.`elenco` (`idelenco`, `pelicula`, `persona`, `personaje`) VALUES (NULL, 1, 3, 'Gabriel Shear');
INSERT INTO `cinemaudea`.`elenco` (`idelenco`, `pelicula`, `persona`, `personaje`) VALUES (NULL, 3, 4, 'Randall Memphis');

COMMIT;


-- -----------------------------------------------------
-- Data for table `cinemaudea`.`genero`
-- -----------------------------------------------------
START TRANSACTION;
USE `cinemaudea`;
INSERT INTO `cinemaudea`.`genero` (`idgenero`, `genero`, `descripcion`) VALUES (1, 'Terror', 'Peliculas de terror Super descriptivo');
INSERT INTO `cinemaudea`.`genero` (`idgenero`, `genero`, `descripcion`) VALUES (2, 'Accion', 'Accion');
INSERT INTO `cinemaudea`.`genero` (`idgenero`, `genero`, `descripcion`) VALUES (3, 'Humor', 'Humor');
INSERT INTO `cinemaudea`.`genero` (`idgenero`, `genero`, `descripcion`) VALUES (4, 'Suspenso', 'Suspenso');

COMMIT;


-- -----------------------------------------------------
-- Data for table `cinemaudea`.`idioma`
-- -----------------------------------------------------
START TRANSACTION;
USE `cinemaudea`;
INSERT INTO `cinemaudea`.`idioma` (`ididioma`, `idioma`) VALUES (1, 'Español');
INSERT INTO `cinemaudea`.`idioma` (`ididioma`, `idioma`) VALUES (2, 'Ingles');
INSERT INTO `cinemaudea`.`idioma` (`ididioma`, `idioma`) VALUES (3, 'Mandarin');

COMMIT;


-- -----------------------------------------------------
-- Data for table `cinemaudea`.`formato`
-- -----------------------------------------------------
START TRANSACTION;
USE `cinemaudea`;
INSERT INTO `cinemaudea`.`formato` (`idformato`, `formato`, `proyeccion`) VALUES (1, '2D', '35mm');
INSERT INTO `cinemaudea`.`formato` (`idformato`, `formato`, `proyeccion`) VALUES (2, '2D', 'Digital');
INSERT INTO `cinemaudea`.`formato` (`idformato`, `formato`, `proyeccion`) VALUES (3, '3D', 'IMAX');
INSERT INTO `cinemaudea`.`formato` (`idformato`, `formato`, `proyeccion`) VALUES (4, '3D', 'Digital');

COMMIT;


-- -----------------------------------------------------
-- Data for table `cinemaudea`.`formato_pelicula`
-- -----------------------------------------------------
START TRANSACTION;
USE `cinemaudea`;
INSERT INTO `cinemaudea`.`formato_pelicula` (`formatopelicula`, `pelicula`, `idioma`, `subtitulos`, `formato`) VALUES (1, 1, 2, 1, 2);
INSERT INTO `cinemaudea`.`formato_pelicula` (`formatopelicula`, `pelicula`, `idioma`, `subtitulos`, `formato`) VALUES (2, 1, 2, 1, 1);
INSERT INTO `cinemaudea`.`formato_pelicula` (`formatopelicula`, `pelicula`, `idioma`, `subtitulos`, `formato`) VALUES (3, 2, 2, 1, 3);
INSERT INTO `cinemaudea`.`formato_pelicula` (`formatopelicula`, `pelicula`, `idioma`, `subtitulos`, `formato`) VALUES (NULL, 3, 2, 1, 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `cinemaudea`.`cartelera`
-- -----------------------------------------------------
START TRANSACTION;
USE `cinemaudea`;
INSERT INTO `cinemaudea`.`cartelera` (`idcartelera`, `fechainicio`, `fechafin`, `formatopelicula`) VALUES (1, '2013-03-01', '2014-03-30', 1);
INSERT INTO `cinemaudea`.`cartelera` (`idcartelera`, `fechainicio`, `fechafin`, `formatopelicula`) VALUES (2, '2013-03-01', '2014-03-30', 2);
INSERT INTO `cinemaudea`.`cartelera` (`idcartelera`, `fechainicio`, `fechafin`, `formatopelicula`) VALUES (3, '2013-03-01', '2014-03-30', 3);
INSERT INTO `cinemaudea`.`cartelera` (`idcartelera`, `fechainicio`, `fechafin`, `formatopelicula`) VALUES (4, '2013-03-01', '2014-03-30', 4);

COMMIT;


-- -----------------------------------------------------
-- Data for table `cinemaudea`.`teatro`
-- -----------------------------------------------------
START TRANSACTION;
USE `cinemaudea`;
INSERT INTO `cinemaudea`.`teatro` (`idteatro`, `nombre`, `direccion`, `telefono`, `ciudad`) VALUES (1, 'Teatro UDEA', 'Alguna parter', '3249898', 'Medellin');

COMMIT;


-- -----------------------------------------------------
-- Data for table `cinemaudea`.`sala`
-- -----------------------------------------------------
START TRANSACTION;
USE `cinemaudea`;
INSERT INTO `cinemaudea`.`sala` (`idsala`, `ubicacion`, `sillas`, `teatro`) VALUES (1, 'Bloque 19', 120, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `cinemaudea`.`localidad`
-- -----------------------------------------------------
START TRANSACTION;
USE `cinemaudea`;
INSERT INTO `cinemaudea`.`localidad` (`idlocalidad`, `localidad`) VALUES ('1', 'General');
INSERT INTO `cinemaudea`.`localidad` (`idlocalidad`, `localidad`) VALUES ('2', 'Preferencial');

COMMIT;


-- -----------------------------------------------------
-- Data for table `cinemaudea`.`silla`
-- -----------------------------------------------------
START TRANSACTION;
USE `cinemaudea`;
INSERT INTO `cinemaudea`.`silla` (`idsilla`, `letra`, `numero`, `sala`, `localidad`) VALUES (1, 'A', 1, 1, '1');
INSERT INTO `cinemaudea`.`silla` (`idsilla`, `letra`, `numero`, `sala`, `localidad`) VALUES (2, 'A', 2, 1, '1');
INSERT INTO `cinemaudea`.`silla` (`idsilla`, `letra`, `numero`, `sala`, `localidad`) VALUES (3, 'B', 1, 1, '2');
INSERT INTO `cinemaudea`.`silla` (`idsilla`, `letra`, `numero`, `sala`, `localidad`) VALUES (4, 'B', 2, 1, '2');
INSERT INTO `cinemaudea`.`silla` (`idsilla`, `letra`, `numero`, `sala`, `localidad`) VALUES (5, 'A', 3, 1, '1');
INSERT INTO `cinemaudea`.`silla` (`idsilla`, `letra`, `numero`, `sala`, `localidad`) VALUES (6, 'A', 4, 1, '1');
INSERT INTO `cinemaudea`.`silla` (`idsilla`, `letra`, `numero`, `sala`, `localidad`) VALUES (7, 'B', 3, 1, '2');

COMMIT;


-- -----------------------------------------------------
-- Data for table `cinemaudea`.`funcion`
-- -----------------------------------------------------
START TRANSACTION;
USE `cinemaudea`;
INSERT INTO `cinemaudea`.`funcion` (`idfuncion`, `fecha`, `inicio`, `fin`, `sala`, `cartelera`) VALUES (1, '2013-03-09', '20:00', '22:00', 1, 1);
INSERT INTO `cinemaudea`.`funcion` (`idfuncion`, `fecha`, `inicio`, `fin`, `sala`, `cartelera`) VALUES (2, '2014-03-16', '10:00', '12:00', 1, 2);
INSERT INTO `cinemaudea`.`funcion` (`idfuncion`, `fecha`, `inicio`, `fin`, `sala`, `cartelera`) VALUES (3, '2014-03-14', '12:00', '14:00', 1, 2);
INSERT INTO `cinemaudea`.`funcion` (`idfuncion`, `fecha`, `inicio`, `fin`, `sala`, `cartelera`) VALUES (4, '2014-03-20', '10:00', '12:00', 1, 4);

COMMIT;


-- -----------------------------------------------------
-- Data for table `cinemaudea`.`estado_boleta`
-- -----------------------------------------------------
START TRANSACTION;
USE `cinemaudea`;
INSERT INTO `cinemaudea`.`estado_boleta` (`idestadoboleta`, `estado`) VALUES (1, 'Reservado');
INSERT INTO `cinemaudea`.`estado_boleta` (`idestadoboleta`, `estado`) VALUES (2, 'Cancelado');
INSERT INTO `cinemaudea`.`estado_boleta` (`idestadoboleta`, `estado`) VALUES (3, 'Pagado');

COMMIT;


-- -----------------------------------------------------
-- Data for table `cinemaudea`.`tarifa`
-- -----------------------------------------------------
START TRANSACTION;
USE `cinemaudea`;
INSERT INTO `cinemaudea`.`tarifa` (`idtarifa`, `formato`, `localidad`, `contarjeta`, `sintarjeta`, `puntos`) VALUES (1, 1, '1', 8000, 10000, 250);
INSERT INTO `cinemaudea`.`tarifa` (`idtarifa`, `formato`, `localidad`, `contarjeta`, `sintarjeta`, `puntos`) VALUES (2, 2, '1', 10000, 13000, 270);
INSERT INTO `cinemaudea`.`tarifa` (`idtarifa`, `formato`, `localidad`, `contarjeta`, `sintarjeta`, `puntos`) VALUES (3, 4, '1', 15000, 18000, 300);
INSERT INTO `cinemaudea`.`tarifa` (`idtarifa`, `formato`, `localidad`, `contarjeta`, `sintarjeta`, `puntos`) VALUES (4, 3, '1', 17000, 20000, 350);
INSERT INTO `cinemaudea`.`tarifa` (`idtarifa`, `formato`, `localidad`, `contarjeta`, `sintarjeta`, `puntos`) VALUES (5, 1, '2', 13000, 15000, 300);
INSERT INTO `cinemaudea`.`tarifa` (`idtarifa`, `formato`, `localidad`, `contarjeta`, `sintarjeta`, `puntos`) VALUES (6, 2, '2', 15000, 18000, 320);
INSERT INTO `cinemaudea`.`tarifa` (`idtarifa`, `formato`, `localidad`, `contarjeta`, `sintarjeta`, `puntos`) VALUES (7, 4, '2', 20000, 23000, 350);
INSERT INTO `cinemaudea`.`tarifa` (`idtarifa`, `formato`, `localidad`, `contarjeta`, `sintarjeta`, `puntos`) VALUES (8, 3, '2', 22000, 25000, 400);

COMMIT;


-- -----------------------------------------------------
-- Data for table `cinemaudea`.`generos`
-- -----------------------------------------------------
START TRANSACTION;
USE `cinemaudea`;
INSERT INTO `cinemaudea`.`generos` (`idgeneros`, `pelicula_idpelicula`, `genero_idgenero`) VALUES (NULL, 1, 2);
INSERT INTO `cinemaudea`.`generos` (`idgeneros`, `pelicula_idpelicula`, `genero_idgenero`) VALUES (NULL, 2, 1);
INSERT INTO `cinemaudea`.`generos` (`idgeneros`, `pelicula_idpelicula`, `genero_idgenero`) VALUES (NULL, 3, 2);
INSERT INTO `cinemaudea`.`generos` (`idgeneros`, `pelicula_idpelicula`, `genero_idgenero`) VALUES (NULL, 3, 4);

COMMIT;

