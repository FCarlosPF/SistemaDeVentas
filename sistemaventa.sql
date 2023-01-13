-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Tiempo de generación: 13-01-2023 a las 04:37:47
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sistemaventa`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `id` int(11) NOT NULL,
  `dni` int(20) NOT NULL,
  `nombre` varchar(150) NOT NULL,
  `telefono` int(15) NOT NULL,
  `direccion` varchar(200) NOT NULL,
  `razon` varchar(200) NOT NULL,
  `fecha` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`id`, `dni`, `nombre`, `telefono`, `direccion`, `razon`, `fecha`) VALUES
(2, 72232355, 'Sideral', 264859724, 'Psj. Sucre 160', 'Factureo y Obras', '2023-01-05 12:52:58'),
(3, 20493584, 'Sandra Mendoza', 983546212, 'Psj. Gladiolos 165', 'Qaliwarma', '2023-01-05 13:00:28'),
(4, 26594826, 'Jorge Salazar', 900665489, 'Oxapampa', 'Comida Asiatica', '2023-01-05 13:10:17'),
(5, 26361548, 'Janeth', 987654321, 'Jr. Moquegua', 'Popeyes', '2023-01-05 13:11:13'),
(6, 26594871, 'Hortensia', 231526587, 'Psj. Universitaria 168', 'Ricardo Menendez', '2023-01-05 13:14:18'),
(7, 59487963, 'Lupitass', 964090278, 'Jr. Guindales 508', 'Sillones Alfonso', '2023-01-05 13:22:59');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `config`
--

CREATE TABLE `config` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `ruc` varchar(20) NOT NULL,
  `telefono` int(15) NOT NULL,
  `direccion` varchar(200) NOT NULL,
  `razon` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `config`
--

INSERT INTO `config` (`id`, `nombre`, `ruc`, `telefono`, `direccion`, `razon`) VALUES
(1, 'Don Maximo', '36594780', 980003724, 'psj. sucre 178', 'Don Maximo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle`
--

CREATE TABLE `detalle` (
  `id` int(11) NOT NULL,
  `cod_pro` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  `id_venta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `detalle`
--

INSERT INTO `detalle` (`id`, `cod_pro`, `cantidad`, `precio`, `id_venta`) VALUES
(1, 2621, 10, '10.80', 0),
(2, 2648964, 15, '5.00', 0),
(3, 2621, 10, '10.80', 0),
(4, 2621, 10, '10.80', 0),
(5, 2621, 5, '10.80', 0),
(6, 2621, 10, '10.80', 0),
(7, 2621, 10, '10.80', 25),
(8, 2621, 10, '10.80', 26),
(9, 2621, 10, '10.80', 27),
(10, 2621, 10, '10.80', 28),
(11, 2621, 10, '10.80', 29),
(12, 2621, 10, '10.80', 30),
(13, 2621, 10, '10.80', 31),
(14, 2621, 10, '10.80', 32),
(15, 2621, 1, '10.80', 34),
(16, 2621, 1, '10.80', 35),
(17, 2621, 1, '10.80', 36),
(18, 2621, 1, '10.80', 37),
(19, 2621, 25, '10.80', 38),
(20, 2621, 0, '10.80', 39),
(21, 2621, 0, '10.80', 40);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `id` int(11) NOT NULL,
  `codigo` varchar(30) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `proveedor` varchar(100) NOT NULL,
  `stock` int(11) NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  `fecha` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`id`, `codigo`, `nombre`, `proveedor`, `stock`, `precio`, `fecha`) VALUES
(3, '2621', 'Comida de perro', 'Lupita', 0, '10.80', '2023-01-06 13:02:11'),
(5, '2648964', 'Piña', 'Pepito', 25, '5.00', '2023-01-06 18:39:54');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

CREATE TABLE `proveedor` (
  `id` int(11) NOT NULL,
  `ruc` int(20) NOT NULL,
  `nombre` varchar(200) NOT NULL,
  `telefono` int(15) NOT NULL,
  `direccion` varchar(200) NOT NULL,
  `razon` varchar(200) NOT NULL,
  `fecha` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `proveedor`
--

INSERT INTO `proveedor` (`id`, `ruc`, `nombre`, `telefono`, `direccion`, `razon`, `fecha`) VALUES
(6, 26154969, 'Lupita', 963251365, 'Psj. Capricho 321', 'Licoreria Zarita', '2023-01-05 21:18:49');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `correo` varchar(100) NOT NULL,
  `pass` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `nombre`, `correo`, `pass`) VALUES
(1, 'Carlos', 'carlospaucarflorescarlos@gmail.com', '123');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE `ventas` (
  `id` int(11) NOT NULL,
  `cliente` varchar(100) NOT NULL,
  `vendedor` varchar(100) NOT NULL,
  `total` decimal(10,2) NOT NULL,
  `fecha` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `ventas`
--

INSERT INTO `ventas` (`id`, `cliente`, `vendedor`, `total`, `fecha`) VALUES
(1, 'Sideral', 'Vendedor', '162.00', '12/01/2023'),
(2, 'Sideral', 'Vendedor', '108.00', '2023-01-09 14:28:09'),
(3, 'Sideral', 'Vendedor', '108.00', '2023-01-09 14:29:00'),
(4, 'Sideral', 'Vendedor', '108.00', '2023-01-09 14:30:29'),
(5, 'Sideral', 'Vendedor', '108.00', '2023-01-09 14:32:23'),
(6, 'Sideral', 'Vendedor', '162.00', '2023-01-09 14:35:40'),
(7, 'Sideral', 'Vendedor', '162.00', '2023-01-09 14:35:41'),
(8, 'Sideral', 'Vendedor', '162.00', '2023-01-09 14:35:41'),
(9, 'Sideral', 'Vendedor', '162.00', '2023-01-09 14:35:41'),
(10, 'Sideral', 'Vendedor', '162.00', '2023-01-09 14:35:41'),
(16, 'Sideral', 'Vendedor', '108.00', '2023-01-09 14:37:03'),
(17, 'Sideral', 'Vendedor', '108.00', '2023-01-09 14:40:07'),
(18, 'Sideral', 'Vendedor', '133.00', '2023-01-09 14:41:51'),
(19, 'Sideral', 'Vendedor', '183.00', '2023-01-09 14:43:49'),
(20, 'Sideral', 'Vendedor', '183.00', '2023-01-09 14:44:38'),
(21, 'Sideral', 'Vendedor', '108.00', '2023-01-09 14:52:57'),
(22, 'Sideral', 'Vendedor', '108.00', '2023-01-09 14:56:26'),
(23, 'Sideral', 'Vendedor', '54.00', '2023-01-09 14:59:06'),
(24, 'Sideral', 'Vendedor', '108.00', '2023-01-09 15:01:24'),
(25, 'Sideral', 'Vendedor', '108.00', '2023-01-09 15:02:21'),
(26, 'Sideral', 'Vendedor', '108.00', '2023-01-09 17:57:46'),
(27, 'Sideral', 'Vendedor', '108.00', '2023-01-09 17:58:21'),
(28, 'Sideral', 'Vendedor', '108.00', '2023-01-09 17:58:46'),
(29, 'Sideral', 'Vendedor', '108.00', '2023-01-09 17:59:27'),
(30, 'Sideral', 'Vendedor', '108.00', '2023-01-09 18:00:51'),
(31, 'Sideral', 'Vendedor', '108.00', '2023-01-09 18:02:15'),
(32, 'Sideral', 'Vendedor', '108.00', '2023-01-09 18:02:46'),
(33, 'Sideral', 'Vendedor', '0.00', '2023-01-09 18:03:43'),
(34, 'Sideral', 'Vendedor', '10.80', '2023-01-09 18:48:03'),
(35, 'Sideral', 'Vendedor', '10.80', '2023-01-09 18:48:34'),
(36, 'Sideral', 'Vendedor', '10.80', '2023-01-09 18:49:38'),
(37, 'Sideral', 'Vendedor', '10.80', '2023-01-09 18:50:13'),
(38, 'Sideral', 'Vendedor', '270.00', '2023-01-12 16:11:59'),
(39, 'Sideral', 'Vendedor', '0.00', '12/01/2023'),
(40, 'Sideral', 'Vendedor', '0.00', '12/01/2023');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `config`
--
ALTER TABLE `config`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `detalle`
--
ALTER TABLE `detalle`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `config`
--
ALTER TABLE `config`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `detalle`
--
ALTER TABLE `detalle`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `ventas`
--
ALTER TABLE `ventas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
