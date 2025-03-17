-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 18/03/2025 às 00:25
-- Versão do servidor: 10.4.32-MariaDB
-- Versão do PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `cinema`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `bilheteria`
--

CREATE TABLE `bilheteria` (
  `id_bilhete` int(11) NOT NULL,
  `id_cadastro` int(11) DEFAULT NULL,
  `num_assento` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `bilheteria`
--

INSERT INTO `bilheteria` (`id_bilhete`, `id_cadastro`, `num_assento`) VALUES
(10, NULL, 0),
(11, NULL, 8);

-- --------------------------------------------------------

--
-- Estrutura para tabela `cadastro`
--

CREATE TABLE `cadastro` (
  `id_cadastro` int(11) NOT NULL,
  `nome_cadastro` varchar(200) DEFAULT NULL,
  `anonasc_cadastro` date DEFAULT NULL,
  `email_cadastro` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `cadastro`
--

INSERT INTO `cadastro` (`id_cadastro`, `nome_cadastro`, `anonasc_cadastro`, `email_cadastro`) VALUES
(10, 'João Pedro Uggioni Damin', '2008-11-15', 'jpuggro@gmail.com');

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `bilheteria`
--
ALTER TABLE `bilheteria`
  ADD PRIMARY KEY (`id_bilhete`),
  ADD KEY `cadastroidfk` (`id_cadastro`);

--
-- Índices de tabela `cadastro`
--
ALTER TABLE `cadastro`
  ADD PRIMARY KEY (`id_cadastro`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `bilheteria`
--
ALTER TABLE `bilheteria`
  MODIFY `id_bilhete` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de tabela `cadastro`
--
ALTER TABLE `cadastro`
  MODIFY `id_cadastro` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `bilheteria`
--
ALTER TABLE `bilheteria`
  ADD CONSTRAINT `bilheteria_ibfk_1` FOREIGN KEY (`id_cadastro`) REFERENCES `cadastro` (`id_cadastro`),
  ADD CONSTRAINT `cadastroidfk` FOREIGN KEY (`id_cadastro`) REFERENCES `cadastro` (`id_cadastro`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
