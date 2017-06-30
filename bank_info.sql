-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-06-2017 a las 19:32:09
-- Versión del servidor: 10.1.21-MariaDB
-- Versión de PHP: 5.6.30

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
(1, 'Credito Hipotecario', 'Credito hipotecario es el producto nuemro no en nuestro banco', 5478547, 1, 0),
(2, 'Cuenta de Ahorro', 'cuenta de ahorro preferencial es nuestro producto numero uno para los clientes mas selectos', 45873, 2, 0),
(3, 'Leasing Banco', 'Product description updated.', 999, 1, 1),
(4, 'Leasing Banco', 'Este producto es nuevo en nuestro banco', 100, 1, 1),
(5, 'Leasing Banco', 'Este producto es nuevo en nuestro banco', 100, 1, 1),
(6, 'Leasing Bntntntt', 'Este producto es nuevo en nuestro banco', 100, 2, 1),
(7, 'Leasing Banco', 'Este producto es nuevo en nuestro banco', 100, 1, 0),
(8, 'Leasing Banco', 'Este producto es nuevo en nuestro banco', 100, 1, 1),
(9, '       ', 'This is a new Product in the bank', 100, 1, 0),
(13, 'Leasing Bancoloololololo', 'Product d', 100, 2, 0),
(14, 'Leasing Banco', 'Product description updated.', 100, 2, 1),
(15, 'nom', 'desc', 0, 2, 0),
(16, 'fff', 'fff', 0, 1, 0),
(17, 'dd', 'dd', 0, 1, 0),
(18, 'PRODUCTO', 'DESCRIPCION', 344, 2, 0),
(19, 'otro hiju', 'desc', 899, 2, 0),
(20, 'juemadre', 'ya esta creando', 600, 2, 0),
(21, 'OTRO ', 'DDDD', 0, 1, 0),
(22, 'fff', 'aaa', 0, 1, 1),
(23, 'fff', 'aaa', 0, 1, 0),
(24, 'hol', 'a quemas', 0, 1, 0),
(25, 'nuevo', 'ddff', 0, 1, 0),
(26, 'hola', 'hijo mio', 12, 2, 1),
(27, 'hh', 'jj', 0, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbltype`
--

CREATE TABLE `tbltype` (
  `intIdProductType` int(10) NOT NULL,
  `strTypeDescription` text COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci COMMENT='table with the type of bank products';

--
-- Volcado de datos para la tabla `tbltype`
--

INSERT INTO `tbltype` (`intIdProductType`, `strTypeDescription`) VALUES
(1, 'Ahorro'),
(2, 'Credito');

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
-- Indices de la tabla `tbltype`
--
ALTER TABLE `tbltype`
  ADD PRIMARY KEY (`intIdProductType`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tblproduct`
--
ALTER TABLE `tblproduct`
  MODIFY `intId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;
--
-- AUTO_INCREMENT de la tabla `tbltype`
--
ALTER TABLE `tbltype`
  MODIFY `intIdProductType` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tblproduct`
--
ALTER TABLE `tblproduct`
  ADD CONSTRAINT `product_ibfk_1` FOREIGN KEY (`intType`) REFERENCES `tbltype` (`intIdProductType`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
