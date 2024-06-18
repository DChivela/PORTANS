-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 17-Jun-2024 às 01:18
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
  `IDMov` int(11) NOT NULL,
  `IDContainer` int(11) NOT NULL,
  `Data` datetime NOT NULL,
  `tipoMov` varchar(50) NOT NULL,
  `LocalOrigem` varchar(255) NOT NULL,
  `LocalDestino` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `movimentacoes_carga`
--

INSERT INTO `movimentacoes_carga` (`IDMov`, `IDContainer`, `Data`, `tipoMov`, `LocalOrigem`, `LocalDestino`) VALUES
(1, 2, '2024-06-17 00:22:49', 'DUPLA', 'ÁREA H', 'SECTOR B'),
(2, 1, '2024-06-16 23:45:12', 'MAQUINÁRIA', 'SECTOR Z', 'SECTOR B');

-- --------------------------------------------------------

--
-- Estrutura da tabela `navios`
--

CREATE TABLE `navios` (
  `IDNavio` int(11) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `bandeira` varchar(50) NOT NULL,
  `tipoNavio` varchar(100) NOT NULL,
  `capacidadeCarga` decimal(10,2) NOT NULL,
  `companhia` varchar(255) NOT NULL,
  `InfoContato` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `navios`
--

INSERT INTO `navios` (`IDNavio`, `nome`, `bandeira`, `tipoNavio`, `capacidadeCarga`, `companhia`, `InfoContato`) VALUES
(1, 'MAERSK', 'USA', 'Transportador', '30.00', 'MAERSK', '2022'),
(2, 'TESIUN', 'RUS', 'PESQUEIRO', '20.00', 'TESIUN RUS', 'DADOS DE TESTE PARA O PRIMEIRO REGISTO\nDO NAVIO');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_funcionarios`
--

CREATE TABLE `tb_funcionarios` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `Bi` varchar(30) DEFAULT NULL,
  `Nif` varchar(20) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `senha` varchar(10) DEFAULT NULL,
  `cargo` varchar(100) DEFAULT NULL,
  `nivel_acesso` varchar(50) DEFAULT NULL,
  `telefone` varchar(30) DEFAULT NULL,
  `Telefone2` varchar(30) DEFAULT NULL,
  `CodPostal` varchar(100) DEFAULT NULL,
  `Provincia` varchar(255) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  `complemento` varchar(200) DEFAULT NULL,
  `Bairro` varchar(100) DEFAULT NULL,
  `Cidade` varchar(100) DEFAULT NULL,
  `Pais` varchar(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tb_funcionarios`
--

INSERT INTO `tb_funcionarios` (`id`, `nome`, `Bi`, `Nif`, `email`, `senha`, `cargo`, `nivel_acesso`, `telefone`, `Telefone2`, `CodPostal`, `Provincia`, `numero`, `complemento`, `Bairro`, `Cidade`, `Pais`) VALUES
(6, 'Domingos Chivela', '005730013HA047', '51719230011', 'domingostchivela18@gmail.com', '000', 'Analista de Dados', 'Administrador', '(244)947449844', '(244)940089024', '0000-0000', 'Huíla', 55, 'Outros', 'Mitcha', 'Lubango', 'AN'),
(7, 'Funcionário de Teste', '11.111.111', '5555555555', 'funcionario@gmail.com', '1959', 'entregador', 'NORMAL USER', '(   )   -   -   ', '(   )   -   -   ', '    -    ', 'rua das flores mais lindas', 55, '    -    ', '    -    ', '37440-000', 'AN'),
(9, 'Domingos Hamba Chivela', '005730013HA047', '51719230011', 'domingostchivela18@gmail.com', '000', 'Analista de Dados', 'ADMINISTRADOR', '(244)947-449-844', '(244)940-089-024', '0000-0000', 'Huíla', 55, '0000-0000', '0000-0000', 'Outros', 'AN');

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
  ADD PRIMARY KEY (`IDMov`),
  ADD KEY `id_container` (`IDContainer`);

--
-- Índices para tabela `navios`
--
ALTER TABLE `navios`
  ADD PRIMARY KEY (`IDNavio`);

--
-- Índices para tabela `tb_funcionarios`
--
ALTER TABLE `tb_funcionarios`
  ADD PRIMARY KEY (`id`);

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
  MODIFY `IDMov` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `navios`
--
ALTER TABLE `navios`
  MODIFY `IDNavio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `tb_funcionarios`
--
ALTER TABLE `tb_funcionarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `atracacoes`
--
ALTER TABLE `atracacoes`
  ADD CONSTRAINT `atracacoes_ibfk_1` FOREIGN KEY (`id_navio`) REFERENCES `navios` (`IDNavio`);

--
-- Limitadores para a tabela `localizacao_conteineres`
--
ALTER TABLE `localizacao_conteineres`
  ADD CONSTRAINT `localizacao_conteineres_ibfk_1` FOREIGN KEY (`id_container`) REFERENCES `conteineres` (`id_container`);

--
-- Limitadores para a tabela `movimentacoes_carga`
--
ALTER TABLE `movimentacoes_carga`
  ADD CONSTRAINT `movimentacoes_carga_ibfk_1` FOREIGN KEY (`IDContainer`) REFERENCES `conteineres` (`id_container`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
