-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-05-2026 a las 01:35:36
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sport_store_A4C10`
--

DELIMITER $$
--
-- Funciones
--
CREATE DEFINER=`root`@`localhost` FUNCTION `longitud_nombre` (`nombre` VARCHAR(100)) RETURNS INT(11) DETERMINISTIC BEGIN
    RETURN LENGTH(nombre);
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `nombre_ciudad` (`nombre` VARCHAR(100), `ciudad` VARCHAR(50)) RETURNS VARCHAR(200) CHARSET utf8mb4 COLLATE utf8mb4_general_ci DETERMINISTIC BEGIN
    RETURN CONCAT(nombre, ' - ', ciudad);
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `nombre_mayuscula` (`nombre` VARCHAR(100)) RETURNS VARCHAR(100) CHARSET utf8mb4 COLLATE utf8mb4_general_ci DETERMINISTIC BEGIN
    RETURN UPPER(nombre);
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `promedio_ventas` (`p_id_vendedor` INT) RETURNS DECIMAL(10,2) DETERMINISTIC BEGIN
    DECLARE resultado DECIMAL(10,2);
    SELECT ROUND(AVG(total), 2)
    INTO resultado
    FROM VENTAS
    WHERE id_vendedor = p_id_vendedor;
    RETURN resultado;
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `salario_anual` (`p_id_vendedor` INT) RETURNS DECIMAL(10,2) DETERMINISTIC BEGIN
    DECLARE resultado DECIMAL(10,2);
    SELECT salario * 12
    INTO resultado
    FROM VENDEDORES
    WHERE id_vendedor = p_id_vendedor;
    RETURN resultado;
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `total_venta` (`p_id_venta` INT) RETURNS DECIMAL(10,2) DETERMINISTIC BEGIN
    DECLARE resultado DECIMAL(10,2);
    SELECT SUM(cantidad * precio_unitario) 
    INTO resultado
    FROM DETALLE_VENTAS
    WHERE id_venta = p_id_venta;
    RETURN resultado;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categorias`
--

CREATE TABLE `categorias` (
  `id_categoria` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `descripcion` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `categorias`
--

INSERT INTO `categorias` (`id_categoria`, `nombre`, `descripcion`) VALUES
(1, 'Fútbol', 'Artículos deportivos para la práctica del fútbol'),
(2, 'Baloncesto', 'Artículos deportivos para la práctica del baloncesto'),
(3, 'Béisbol', 'Artículos deportivos para la práctica del béisbol'),
(4, 'Boxeo', 'Artículos deportivos para la práctica del boxeo'),
(5, 'Natación', 'Artículos deportivos para la práctica de la natación'),
(6, 'Tenis', 'Artículos deportivos para la práctica del tenis');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `id_cliente` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `ciudad` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`id_cliente`, `nombre`, `telefono`, `email`, `ciudad`) VALUES
(1, 'Carlos Mendoza', '3101234567', 'carlos.mendoza@gmail.com', 'Barranquilla'),
(2, 'Laura Perez', '3152345678', 'laura.perez@gmail.com', 'Bogotá'),
(3, 'Andrés Torres', '3003456789', 'andres.torres@gmail.com', 'Medellín'),
(4, 'María Gutierrez', '3184567890', 'maria.gutierrez@gmail.com', 'Cali'),
(5, 'Juan Ramirez', '3205678901', 'juan.ramirez@gmail.com', 'Barranquilla'),
(6, 'Valentina Castro', '3116789012', 'valentina.castro@gmail.com', 'Cartagena'),
(7, 'Diego Herrera', '3007890123', 'diego.herrera@gmail.com', 'Bucaramanga'),
(8, 'Camila Rios', '3148901234', 'camila.rios@gmail.com', 'Barranquilla'),
(9, 'Sebastian Lopez', '3219012345', 'sebastian.lopez@gmail.com', 'Santa Marta'),
(10, 'Natalia Vargas', '3100123456', 'natalia.vargas@gmail.com', 'Medellín');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_ventas`
--

CREATE TABLE `detalle_ventas` (
  `id_detalle` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precio_unitario` decimal(10,2) NOT NULL,
  `id_venta` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `detalle_ventas`
--

INSERT INTO `detalle_ventas` (`id_detalle`, `cantidad`, `precio_unitario`, `id_venta`, `id_producto`) VALUES
(1, 1, 85000.00, 1, 1),
(2, 2, 35000.00, 1, 3),
(3, 1, 180000.00, 2, 17),
(4, 2, 30000.00, 2, 18),
(5, 1, 150000.00, 3, 2),
(6, 1, 220000.00, 4, 5),
(7, 1, 110000.00, 4, 11),
(8, 1, 95000.00, 4, 12),
(9, 1, 95000.00, 5, 9),
(10, 2, 25000.00, 5, 10),
(11, 1, 110000.00, 6, 11),
(12, 2, 40000.00, 6, 14),
(13, 1, 250000.00, 7, 13),
(14, 1, 75000.00, 7, 16),
(15, 1, 40000.00, 8, 14),
(16, 2, 20000.00, 8, 15),
(17, 1, 195000.00, 9, 19),
(18, 1, 45000.00, 9, 7),
(19, 2, 90000.00, 10, 5),
(20, 1, 180000.00, 10, 17),
(21, 2, 30000.00, 10, 18),
(22, 1, 150000.00, 11, 2),
(23, 1, 85000.00, 11, 1),
(24, 1, 35000.00, 11, 3),
(25, 1, 95000.00, 12, 9),
(26, 2, 40000.00, 12, 14),
(27, 1, 220000.00, 13, 6),
(28, 1, 180000.00, 13, 17),
(29, 1, 45000.00, 13, 7),
(30, 1, 110000.00, 14, 11),
(31, 2, 30000.00, 14, 18),
(32, 1, 90000.00, 14, 5),
(33, 1, 95000.00, 15, 12),
(34, 2, 25000.00, 15, 10),
(35, 1, 45000.00, 15, 7),
(36, 1, 250000.00, 16, 13),
(37, 1, 65000.00, 16, 4),
(38, 1, 35000.00, 16, 3),
(39, 1, 180000.00, 17, 17),
(40, 2, 50000.00, 17, 7),
(41, 1, 195000.00, 18, 19),
(42, 1, 120000.00, 18, 8),
(43, 2, 25000.00, 18, 10),
(44, 1, 85000.00, 19, 1),
(45, 2, 40000.00, 19, 14),
(46, 1, 150000.00, 20, 2),
(47, 1, 95000.00, 20, 9),
(48, 1, 30000.00, 20, 18);

--
-- Disparadores `detalle_ventas`
--
DELIMITER $$
CREATE TRIGGER `actualizar_stock_venta` AFTER INSERT ON `detalle_ventas` FOR EACH ROW BEGIN
    UPDATE PRODUCTOS
    SET stock = stock - NEW.cantidad
    WHERE id_producto = NEW.id_producto;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `actualizar_total_venta` AFTER INSERT ON `detalle_ventas` FOR EACH ROW BEGIN
    UPDATE VENTAS
    SET total = (
        SELECT SUM(cantidad * precio_unitario)
        FROM DETALLE_VENTAS
        WHERE id_venta = NEW.id_venta
    )
    WHERE id_venta = NEW.id_venta;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `restaurar_stock_eliminacion` AFTER DELETE ON `detalle_ventas` FOR EACH ROW BEGIN
    UPDATE PRODUCTOS
    SET stock = stock + OLD.cantidad
    WHERE id_producto = OLD.id_producto;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `id_producto` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  `stock` int(11) NOT NULL DEFAULT 0,
  `id_categoria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`id_producto`, `nombre`, `precio`, `stock`, `id_categoria`) VALUES
(1, 'Balón de fútbol', 85000.00, 20, 1),
(2, 'Guayos', 150000.00, 15, 1),
(3, 'Espinilleras', 35000.00, 25, 1),
(4, 'Camiseta de fútbol', 65000.00, 30, 1),
(5, 'Balón de baloncesto', 90000.00, 18, 2),
(6, 'Zapatillas de baloncesto', 220000.00, 12, 2),
(7, 'Rodilleras de baloncesto', 45000.00, 20, 2),
(8, 'Bate de béisbol', 120000.00, 10, 3),
(9, 'Guante de béisbol', 95000.00, 14, 3),
(10, 'Pelota de béisbol', 25000.00, 40, 3),
(11, 'Guantes de boxeo', 110000.00, 16, 4),
(12, 'Casco de boxeo', 95000.00, 12, 4),
(13, 'Saco de boxeo', 250000.00, 8, 4),
(14, 'Gafas de natación', 40000.00, 22, 5),
(15, 'Gorro de natación', 20000.00, 30, 5),
(16, 'Traje de baño', 75000.00, 18, 5),
(17, 'Raqueta de tenis', 180000.00, 10, 6),
(18, 'Pelotas de tenis x3', 30000.00, 35, 6),
(19, 'Zapatillas de tenis', 195000.00, 12, 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vendedores`
--

CREATE TABLE `vendedores` (
  `id_vendedor` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `salario` decimal(10,2) NOT NULL,
  `fecha_ingreso` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `vendedores`
--

INSERT INTO `vendedores` (`id_vendedor`, `nombre`, `telefono`, `salario`, `fecha_ingreso`) VALUES
(1, 'Pedro Alvarado', '3101112233', 1800000.00, '2022-03-15'),
(2, 'Luisa Fernanda Mora', '3152223344', 1650000.00, '2023-07-22'),
(3, 'Ricardo Pinto', '3003334455', 1750000.00, '2021-01-10'),
(4, 'Stephanie Blanco', '3184445566', 1600000.00, '2024-05-08'),
(5, 'Mauricio Sanchez', '3205556677', 1900000.00, '2022-11-30');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE `ventas` (
  `id_venta` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `total` decimal(10,2) NOT NULL DEFAULT 0.00,
  `id_cliente` int(11) NOT NULL,
  `id_vendedor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ventas`
--

INSERT INTO `ventas` (`id_venta`, `fecha`, `total`, `id_cliente`, `id_vendedor`) VALUES
(1, '2024-01-10', 235000.00, 1, 1),
(2, '2024-01-15', 310000.00, 2, 2),
(3, '2024-02-03', 150000.00, 3, 3),
(4, '2024-02-20', 420000.00, 4, 4),
(5, '2024-03-05', 195000.00, 5, 5),
(6, '2024-03-18', 280000.00, 6, 1),
(7, '2024-04-02', 375000.00, 7, 2),
(8, '2024-04-25', 110000.00, 8, 3),
(9, '2024-05-10', 265000.00, 9, 4),
(10, '2024-05-30', 390000.00, 10, 5),
(11, '2024-06-05', 320000.00, 1, 3),
(12, '2024-06-18', 175000.00, 3, 1),
(13, '2024-07-02', 445000.00, 5, 2),
(14, '2024-07-20', 260000.00, 7, 4),
(15, '2024-08-08', 190000.00, 2, 5),
(16, '2024-08-25', 350000.00, 4, 1),
(17, '2024-09-10', 280000.00, 6, 3),
(18, '2024-09-28', 415000.00, 8, 2),
(19, '2024-10-15', 165000.00, 9, 4),
(20, '2024-10-30', 295000.00, 10, 5);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vista_historial_clientes`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `vista_historial_clientes` (
`cliente` varchar(100)
,`ciudad` varchar(50)
,`total_compras` bigint(21)
,`total_gastado` decimal(32,2)
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vista_productos_categoria`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `vista_productos_categoria` (
`id_producto` int(11)
,`producto` varchar(100)
,`precio` decimal(10,2)
,`stock` int(11)
,`categoria` varchar(50)
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vista_productos_mas_vendidos`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `vista_productos_mas_vendidos` (
`producto` varchar(100)
,`total_vendido` decimal(32,0)
,`ingresos_generados` decimal(42,2)
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vista_ventas_detalladas`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `vista_ventas_detalladas` (
`id_venta` int(11)
,`fecha` date
,`total` decimal(10,2)
,`cliente` varchar(100)
,`ciudad` varchar(50)
,`vendedor` varchar(100)
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vista_ventas_por_vendedor`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `vista_ventas_por_vendedor` (
`vendedor` varchar(100)
,`total_ventas` bigint(21)
,`ingresos_totales` decimal(32,2)
,`promedio_venta` decimal(11,2)
);

-- --------------------------------------------------------

--
-- Estructura para la vista `vista_historial_clientes`
--
DROP TABLE IF EXISTS `vista_historial_clientes`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vista_historial_clientes`  AS SELECT `c`.`nombre` AS `cliente`, `c`.`ciudad` AS `ciudad`, count(`v`.`id_venta`) AS `total_compras`, sum(`v`.`total`) AS `total_gastado` FROM (`clientes` `c` join `ventas` `v` on(`c`.`id_cliente` = `v`.`id_cliente`)) GROUP BY `c`.`id_cliente`, `c`.`nombre`, `c`.`ciudad` ;

-- --------------------------------------------------------

--
-- Estructura para la vista `vista_productos_categoria`
--
DROP TABLE IF EXISTS `vista_productos_categoria`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vista_productos_categoria`  AS SELECT `p`.`id_producto` AS `id_producto`, `p`.`nombre` AS `producto`, `p`.`precio` AS `precio`, `p`.`stock` AS `stock`, `c`.`nombre` AS `categoria` FROM (`productos` `p` join `categorias` `c` on(`p`.`id_categoria` = `c`.`id_categoria`)) ;

-- --------------------------------------------------------

--
-- Estructura para la vista `vista_productos_mas_vendidos`
--
DROP TABLE IF EXISTS `vista_productos_mas_vendidos`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vista_productos_mas_vendidos`  AS SELECT `p`.`nombre` AS `producto`, sum(`dv`.`cantidad`) AS `total_vendido`, sum(`dv`.`cantidad` * `dv`.`precio_unitario`) AS `ingresos_generados` FROM (`detalle_ventas` `dv` join `productos` `p` on(`dv`.`id_producto` = `p`.`id_producto`)) GROUP BY `p`.`id_producto`, `p`.`nombre` ORDER BY sum(`dv`.`cantidad`) DESC ;

-- --------------------------------------------------------

--
-- Estructura para la vista `vista_ventas_detalladas`
--
DROP TABLE IF EXISTS `vista_ventas_detalladas`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vista_ventas_detalladas`  AS SELECT `v`.`id_venta` AS `id_venta`, `v`.`fecha` AS `fecha`, `v`.`total` AS `total`, `c`.`nombre` AS `cliente`, `c`.`ciudad` AS `ciudad`, `ve`.`nombre` AS `vendedor` FROM ((`ventas` `v` join `clientes` `c` on(`v`.`id_cliente` = `c`.`id_cliente`)) join `vendedores` `ve` on(`v`.`id_vendedor` = `ve`.`id_vendedor`)) ;

-- --------------------------------------------------------

--
-- Estructura para la vista `vista_ventas_por_vendedor`
--
DROP TABLE IF EXISTS `vista_ventas_por_vendedor`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vista_ventas_por_vendedor`  AS SELECT `ve`.`nombre` AS `vendedor`, count(`v`.`id_venta`) AS `total_ventas`, sum(`v`.`total`) AS `ingresos_totales`, round(avg(`v`.`total`),2) AS `promedio_venta` FROM (`ventas` `v` join `vendedores` `ve` on(`v`.`id_vendedor` = `ve`.`id_vendedor`)) GROUP BY `ve`.`id_vendedor`, `ve`.`nombre` ;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categorias`
--
ALTER TABLE `categorias`
  ADD PRIMARY KEY (`id_categoria`);

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id_cliente`);

--
-- Indices de la tabla `detalle_ventas`
--
ALTER TABLE `detalle_ventas`
  ADD PRIMARY KEY (`id_detalle`),
  ADD KEY `fk_detalle_venta` (`id_venta`),
  ADD KEY `fk_detalle_producto` (`id_producto`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`id_producto`),
  ADD KEY `fk_producto_categoria` (`id_categoria`);

--
-- Indices de la tabla `vendedores`
--
ALTER TABLE `vendedores`
  ADD PRIMARY KEY (`id_vendedor`);

--
-- Indices de la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD PRIMARY KEY (`id_venta`),
  ADD KEY `fk_venta_cliente` (`id_cliente`),
  ADD KEY `fk_venta_vendedor` (`id_vendedor`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categorias`
--
ALTER TABLE `categorias`
  MODIFY `id_categoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id_cliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `detalle_ventas`
--
ALTER TABLE `detalle_ventas`
  MODIFY `id_detalle` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `id_producto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT de la tabla `vendedores`
--
ALTER TABLE `vendedores`
  MODIFY `id_vendedor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `ventas`
--
ALTER TABLE `ventas`
  MODIFY `id_venta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detalle_ventas`
--
ALTER TABLE `detalle_ventas`
  ADD CONSTRAINT `fk_detalle_producto` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id_producto`),
  ADD CONSTRAINT `fk_detalle_venta` FOREIGN KEY (`id_venta`) REFERENCES `ventas` (`id_venta`);

--
-- Filtros para la tabla `productos`
--
ALTER TABLE `productos`
  ADD CONSTRAINT `fk_producto_categoria` FOREIGN KEY (`id_categoria`) REFERENCES `categorias` (`id_categoria`);

--
-- Filtros para la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD CONSTRAINT `fk_venta_cliente` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id_cliente`),
  ADD CONSTRAINT `fk_venta_vendedor` FOREIGN KEY (`id_vendedor`) REFERENCES `vendedores` (`id_vendedor`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
