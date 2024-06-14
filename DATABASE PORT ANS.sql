-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 14-Jun-2024 às 19:34
-- Versão do servidor: 10.4.24-MariaDB
-- versão do PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `portans`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `atracacoes`
--

CREATE TABLE `atracacoes` (
  `id_atracacao` int(11) NOT NULL,
  `id_navio` int(11) NOT NULL,
  `dataChegada` datetime NOT NULL,
  `dataPartida` datetime DEFAULT NULL,
  `berco` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `atracacoes`
--

INSERT INTO `atracacoes` (`id_atracacao`, `id_navio`, `dataChegada`, `dataPartida`, `berco`) VALUES
(1, 1, '2024-06-14 00:00:00', '2024-07-14 00:00:00', 12),
(2, 1, '2024-06-14 00:00:00', '2024-07-14 00:00:00', 20),
(5, 1, '2024-06-14 10:26:52', '2024-06-14 10:26:52', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `conteineres`
--

CREATE TABLE `conteineres` (
  `id_container` int(11) NOT NULL,
  `numContainer` varchar(20) NOT NULL,
  `tipoContainer` varchar(50) NOT NULL,
  `peso` decimal(10,2) NOT NULL,
  `dimensoes` varchar(100) NOT NULL,
  `origem` varchar(255) DEFAULT NULL,
  `destino` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `conteineres`
--

INSERT INTO `conteineres` (`id_container`, `numContainer`, `tipoContainer`, `peso`, `dimensoes`, `origem`, `destino`) VALUES
(1, '30013HA047', '1000', '12.00', '30-30', 'China', 'Angola'),
(2, '250313HA047', '500', '12.00', '10-30', 'China', 'Angola');

-- --------------------------------------------------------

--
-- Estrutura da tabela `localizacao_conteineres`
--

CREATE TABLE `localizacao_conteineres` (
  `id_localizacao` int(11) NOT NULL,
  `id_container` int(11) NOT NULL,
  `data` datetime NOT NULL,
  `localizacao` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `localizacao_conteineres`
--

INSERT INTO `localizacao_conteineres` (`id_localizacao`, `id_container`, `data`, `localizacao`) VALUES
(1, 1, '2024-06-14 17:59:16', 'Área Geral'),
(2, 1, '2024-06-14 17:35:23', 'Geral');

-- --------------------------------------------------------

--
-- Estrutura da tabela `movimentacoes_carga`
--

CREATE TABLE `movimentacoes_carga` (
  `id_movimentacao` int(11) NOT NULL,
  `id_container` int(11) NOT NULL,
  `data_hora` datetime NOT NULL,
  `tipo_movimentacao` varchar(50) NOT NULL,
  `localizacao_origem` varchar(255) NOT NULL,
  `localizacao_destino` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `navios`
--

CREATE TABLE `navios` (
  `id_navio` int(11) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `bandeira` varchar(50) NOT NULL,
  `tipo_navio` varchar(100) NOT NULL,
  `capacidade_carga` decimal(10,2) NOT NULL,
  `companhia_maritima` varchar(255) NOT NULL,
  `dados_contato` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `navios`
--

INSERT INTO `navios` (`id_navio`, `nome`, `bandeira`, `tipo_navio`, `capacidade_carga`, `companhia_maritima`, `dados_contato`) VALUES
(1, 'MAERSK', 'USA', 'Transportador', '30.00', 'MAERSK', '2022');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `atracacoes`
--
ALTER TABLE `atracacoes`
  ADD PRIMARY KEY (`id_atracacao`),
  ADD KEY `id_navio` (`id_navio`);

--
-- Índices para tabela `conteineres`
--
ALTER TABLE `conteineres`
  ADD PRIMARY KEY (`id_container`);

--
-- Índices para tabela `localizacao_conteineres`
--
ALTER TABLE `localizacao_conteineres`
  ADD PRIMARY KEY (`id_localizacao`),
  ADD KEY `id_container` (`id_container`);

--
-- Índices para tabela `movimentacoes_carga`
--
ALTER TABLE `movimentacoes_carga`
  ADD PRIMARY KEY (`id_movimentacao`),
  ADD KEY `id_container` (`id_container`);

--
-- Índices para tabela `navios`
--
ALTER TABLE `navios`
  ADD PRIMARY KEY (`id_navio`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `atracacoes`
--
ALTER TABLE `atracacoes`
  MODIFY `id_atracacao` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de tabela `conteineres`
--
ALTER TABLE `conteineres`
  MODIFY `id_container` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `localizacao_conteineres`
--
ALTER TABLE `localizacao_conteineres`
  MODIFY `id_localizacao` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `movimentacoes_carga`
--
ALTER TABLE `movimentacoes_carga`
  MODIFY `id_movimentacao` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `navios`
--
ALTER TABLE `navios`
  MODIFY `id_navio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `atracacoes`
--
ALTER TABLE `atracacoes`
  ADD CONSTRAINT `atracacoes_ibfk_1` FOREIGN KEY (`id_navio`) REFERENCES `navios` (`id_navio`);

--
-- Limitadores para a tabela `localizacao_conteineres`
--
ALTER TABLE `localizacao_conteineres`
  ADD CONSTRAINT `localizacao_conteineres_ibfk_1` FOREIGN KEY (`id_container`) REFERENCES `conteineres` (`id_container`);

--
-- Limitadores para a tabela `movimentacoes_carga`
--
ALTER TABLE `movimentacoes_carga`
  ADD CONSTRAINT `movimentacoes_carga_ibfk_1` FOREIGN KEY (`id_container`) REFERENCES `conteineres` (`id_container`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
