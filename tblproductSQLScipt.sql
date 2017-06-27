-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-06-2017 a las 06:39:28
-- Versión del servidor: 10.1.21-MariaDB
-- Versión de PHP: 7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bank_info`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblproduct`
--

CREATE TABLE `tblproduct` (
  `intId` int(11) NOT NULL,
  `strName` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `strDescription` varchar(200) COLLATE utf8_spanish_ci NOT NULL,
  `intNmbrOfPeople` int(11) NOT NULL,
  `intType` int(11) NOT NULL,
  `blnIsActive` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci COMMENT='This table store the products ofered by the bank';

--
-- Volcado de datos para la tabla `tblproduct`
--

INSERT INTO `tblproduct` (`intId`, `strName`, `strDescription`, `intNmbrOfPeople`, `intType`, `blnIsActive`) VALUES
(1, 'Credito Hipotecario', 'Credito hipotecario es el producto nuemro no en nuestro banco', 5478547, 1, 1),
(2, 'Cuenta de Ahorro', 'cuenta de ahorro preferencial es nuestro producto numero uno para los clientes mas selectos', 45873, 2, 0),
(3, 'Leasing Banco', 'Descripcion updateeeed', 100, 1, 1),
(4, 'Leasing Banco', 'Este producto es nuevo en nuestro banco', 100, 1, 1),
(5, 'Leasing Banco', 'Este producto es nuevo en nuestro banco', 100, 1, 1),
(6, 'Leasing Banco', 'Este producto es nuevo en nuestro banco', 100, 1, 1),
(7, 'Leasing Banco', 'Este producto es nuevo en nuestro banco', 100, 1, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tblproduct`
--
ALTER TABLE `tblproduct`
  ADD PRIMARY KEY (`intId`),
  ADD KEY `intType` (`intType`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tblproduct`
--
ALTER TABLE `tblproduct`
  MODIFY `intId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tblproduct`
--
ALTER TABLE `tblproduct`
  ADD CONSTRAINT `product_ibfk_1` FOREIGN KEY (`intType`) REFERENCES `tbltype` (`intIdType`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
