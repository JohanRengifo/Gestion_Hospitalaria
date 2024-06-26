-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: May 10, 2024 at 11:11 PM
-- Server version: 8.0.30
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hospitalgen`
--

-- --------------------------------------------------------

--
-- Table structure for table `analisis`
--

CREATE TABLE `analisis` (
  `id` int NOT NULL,
  `id_paciente` int DEFAULT NULL,
  `tipo_analisis` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `fecha_realizacion` date DEFAULT NULL,
  `medico_solicitante` int DEFAULT NULL,
  `enfermero_realizador` int DEFAULT NULL,
  `resultado` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `id_usuario_medico` int DEFAULT NULL,
  `id_usuario_enfermero` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `analisis`
--

INSERT INTO `analisis` (`id`, `id_paciente`, `tipo_analisis`, `fecha_realizacion`, `medico_solicitante`, `enfermero_realizador`, `resultado`, `id_usuario_medico`, `id_usuario_enfermero`) VALUES
(3, 1, 'Vista', '2024-02-15', 1, 1, 'Ciego', NULL, NULL),
(4, 1, 'Optometrica', '2022-02-23', 1, 1, 'Esta Ciego Parcero', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `empleadossanitarios`
--

CREATE TABLE `empleadossanitarios` (
  `id` int NOT NULL,
  `numero_empleado` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `nombre` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `tipo` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `especialidad` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `id_usuario` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `empleadossanitarios`
--

INSERT INTO `empleadossanitarios` (`id`, `numero_empleado`, `nombre`, `tipo`, `especialidad`, `id_usuario`) VALUES
(1, '1048067755', 'johan', NULL, 'Medicina General', 1);

-- --------------------------------------------------------

--
-- Table structure for table `eventos`
--

CREATE TABLE `eventos` (
  `id_evento` int NOT NULL,
  `id_usuario` int DEFAULT NULL,
  `rol_usuario` enum('paciente','enfermero','doctor') COLLATE utf8mb4_general_ci DEFAULT NULL,
  `tipo_evento` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `fecha_registro` timestamp NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `pacientes`
--

CREATE TABLE `pacientes` (
  `id` int NOT NULL,
  `numero_historia_clinica` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `nombre` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `direccion` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `id_usuario` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pacientes`
--

INSERT INTO `pacientes` (`id`, `numero_historia_clinica`, `nombre`, `direccion`, `id_usuario`) VALUES
(1, '1048067754', '1048067754', 'popayan', 2);

-- --------------------------------------------------------

--
-- Table structure for table `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int NOT NULL,
  `nombre` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `nombre_usuario` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `direccion` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `rol` enum('paciente','enfermero','doctor') COLLATE utf8mb4_general_ci DEFAULT NULL,
  `fecha_registro` timestamp NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `usuarios`
--

INSERT INTO `usuarios` (`id`, `nombre`, `nombre_usuario`, `password`, `direccion`, `rol`, `fecha_registro`) VALUES
(1, 'Johan', '1048067755', '123', 'Popayan', 'doctor', '2024-05-09 02:11:47'),
(2, 'johan', '1048067754', '123', 'Popayan', 'paciente', '2024-05-09 14:35:36'),
(3, 'johan', '1048067756', '123', 'Popayan', 'enfermero', '2024-05-09 14:35:36');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `analisis`
--
ALTER TABLE `analisis`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_paciente` (`id_paciente`),
  ADD KEY `medico_solicitante` (`medico_solicitante`),
  ADD KEY `enfermero_realizador` (`enfermero_realizador`),
  ADD KEY `fk_analisis_usuarios_medicos` (`id_usuario_medico`),
  ADD KEY `fk_analisis_usuarios_enfermeros` (`id_usuario_enfermero`);

--
-- Indexes for table `empleadossanitarios`
--
ALTER TABLE `empleadossanitarios`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_empleadossanitarios_usuarios` (`id_usuario`);

--
-- Indexes for table `eventos`
--
ALTER TABLE `eventos`
  ADD PRIMARY KEY (`id_evento`),
  ADD KEY `id_usuario` (`id_usuario`);

--
-- Indexes for table `pacientes`
--
ALTER TABLE `pacientes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_pacientes_usuarios` (`id_usuario`);

--
-- Indexes for table `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nombre_usuario` (`nombre_usuario`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `analisis`
--
ALTER TABLE `analisis`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `eventos`
--
ALTER TABLE `eventos`
  MODIFY `id_evento` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `analisis`
--
ALTER TABLE `analisis`
  ADD CONSTRAINT `analisis_ibfk_1` FOREIGN KEY (`id_paciente`) REFERENCES `pacientes` (`id`),
  ADD CONSTRAINT `analisis_ibfk_2` FOREIGN KEY (`medico_solicitante`) REFERENCES `empleadossanitarios` (`id`),
  ADD CONSTRAINT `analisis_ibfk_3` FOREIGN KEY (`enfermero_realizador`) REFERENCES `empleadossanitarios` (`id`),
  ADD CONSTRAINT `fk_analisis_usuarios_enfermeros` FOREIGN KEY (`id_usuario_enfermero`) REFERENCES `usuarios` (`id`),
  ADD CONSTRAINT `fk_analisis_usuarios_medicos` FOREIGN KEY (`id_usuario_medico`) REFERENCES `usuarios` (`id`);

--
-- Constraints for table `empleadossanitarios`
--
ALTER TABLE `empleadossanitarios`
  ADD CONSTRAINT `fk_empleados_usuarios` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`),
  ADD CONSTRAINT `fk_empleadossanitarios_usuarios` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`);

--
-- Constraints for table `eventos`
--
ALTER TABLE `eventos`
  ADD CONSTRAINT `eventos_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`);

--
-- Constraints for table `pacientes`
--
ALTER TABLE `pacientes`
  ADD CONSTRAINT `fk_pacientes_usuarios` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
