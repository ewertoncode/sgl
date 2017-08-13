-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Aug 13, 2017 at 04:33 PM
-- Server version: 5.7.19-0ubuntu0.16.04.1
-- PHP Version: 7.0.22-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sgpl`
--

-- --------------------------------------------------------

--
-- Table structure for table `endereco`
--

CREATE TABLE `endereco` (
  `id` int(11) NOT NULL,
  `logradouro` varchar(100) NOT NULL,
  `numero` varchar(10) DEFAULT NULL,
  `complemento` varchar(30) DEFAULT NULL,
  `bairro` varchar(50) DEFAULT NULL,
  `cidade` varchar(50) DEFAULT NULL,
  `cep` varchar(9) DEFAULT NULL,
  `estado` varchar(50) DEFAULT NULL,
  `pais` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `endereco`
--

INSERT INTO `endereco` (`id`, `logradouro`, `numero`, `complemento`, `bairro`, `cidade`, `cep`, `estado`, `pais`) VALUES
(1, 'Rua das Flores', '123', 'Casa', 'Belo Monte', 'Januária', '39480-000', 'Minas Gerais', 'Brasil'),
(2, 'Rua Independência', '213', 'AP', 'Vila  América', 'Januária', '39480-000', 'Minas Gerais', 'Brasil'),
(3, 'Rua Canaã', '654', 'AP', 'Centro', 'Januária', '39480-000', 'Minas Gerais', 'Brasil'),
(4, 'Coqueiros', '453', 'Loja Verde', 'Centro', 'Januária', '39480-000', 'Minas Gerais', 'Brasil'),
(5, 'Sete Setembro', '63', 'AP', 'Vila Verde', 'Januária', '39480-000', 'Minas Gerais', 'Brasil');

-- --------------------------------------------------------

--
-- Table structure for table `fornecedor`
--

CREATE TABLE `fornecedor` (
  `id` int(11) NOT NULL,
  `razaoSocial` varchar(255) NOT NULL,
  `nomeFantasia` varchar(45) NOT NULL,
  `cnpj` varchar(45) NOT NULL,
  `telefone` varchar(45) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `endereco` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fornecedor`
--

INSERT INTO `fornecedor` (`id`, `razaoSocial`, `nomeFantasia`, `cnpj`, `telefone`, `email`, `endereco`) VALUES
(1, 'Casa Martel LTDA', 'Casa Martel', '53.453.453/4534-63', '55 (33) 34534-5344', 'cm@gmail.com', 1),
(2, 'Easy Informática LTDA', 'Easy Informática', '98.234.723/8749-23', '55 (33) 99122-3123', 'easyinformatica@hotmail.com', 2),
(3, 'DF Soluções LTDA', 'DF Soluções ', '42.342.346/2874-62', '55 (33) 91231-2312', 'dfsoluções@gmail.com', 3),
(4, 'Distribuidora Amaral LTDA', 'Distribuidora Amaral ', '32.423.423/4234-23', '55 (  )      -    ', 'distribuidoraamaral@yahoo.com', 4),
(5, 'Graal Consultoria LTDA', 'Graal Consultoria ', '62.374.623/4234-21', '55 (33) 91321-2312', 'graalconsultoria@hotmail.com', 5);

-- --------------------------------------------------------

--
-- Table structure for table `historico_renegociacao`
--

CREATE TABLE `historico_renegociacao` (
  `id` int(11) NOT NULL,
  `descricao` varchar(50) NOT NULL,
  `data` date NOT NULL,
  `pregao` int(11) NOT NULL,
  `fornecedor` int(11) NOT NULL,
  `usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `item_pedido`
--

CREATE TABLE `item_pedido` (
  `id` int(11) NOT NULL,
  `quantidade` double NOT NULL,
  `Fornecedor1` int(11) NOT NULL,
  `valorFornecedor1` double NOT NULL,
  `Fornecedor2` int(11) NOT NULL,
  `valorFornecedor2` double NOT NULL,
  `Fornecedor3` int(11) NOT NULL,
  `valorFornecedor3` double NOT NULL,
  `pedido` int(11) NOT NULL,
  `produto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `item_pedido`
--

INSERT INTO `item_pedido` (`id`, `quantidade`, `Fornecedor1`, `valorFornecedor1`, `Fornecedor2`, `valorFornecedor2`, `Fornecedor3`, `valorFornecedor3`, `pedido`, `produto`) VALUES
(1, 10, 1, 1203.12, 2, 1241.43, 3, 1233.43, 1, 1),
(2, 8, 3, 1024.67, 4, 1031.77, 5, 1019.99, 2, 6),
(3, 20, 3, 122.8, 4, 131.66, 5, 109.12, 2, 3),
(4, 100, 3, 102.8, 4, 101.66, 5, 99.12, 2, 5),
(5, 81, 4, 124, 5, 127.34, 1, 123.21, 3, 3),
(6, 3, 4, 1124, 5, 1127.34, 1, 1213.21, 3, 1),
(7, 3, 1, 938.12, 1, 888.23, 1, 892.53, 4, 2),
(8, 7, 1, 123.12, 1, 152.21, 1, 163.47, 4, 4),
(9, 79, 3, 132.12, 5, 89.34, 4, 83.53, 5, 5),
(10, 12, 3, 1327.12, 5, 1634.12, 4, 1123.12, 5, 6);

-- --------------------------------------------------------

--
-- Table structure for table `item_pregao`
--

CREATE TABLE `item_pregao` (
  `id` int(11) NOT NULL,
  `quantidade` double NOT NULL,
  `valorReferencia` double NOT NULL,
  `pregao` int(11) NOT NULL,
  `produto` int(11) NOT NULL,
  `fornecedor` int(11) NOT NULL,
  `statusItem` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `nota_empenho`
--

CREATE TABLE `nota_empenho` (
  `id` int(11) NOT NULL,
  `data` date NOT NULL,
  `valor` double NOT NULL,
  `status` varchar(30) NOT NULL,
  `fornecedor` int(11) NOT NULL,
  `pregao` int(11) NOT NULL,
  `usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `notificacao_fornecedor`
--

CREATE TABLE `notificacao_fornecedor` (
  `id` int(11) NOT NULL,
  `descricao` varchar(100) NOT NULL,
  `data` date NOT NULL,
  `status` int(11) NOT NULL,
  `fornecedor` int(11) NOT NULL,
  `pregao` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `pedido`
--

CREATE TABLE `pedido` (
  `id` int(11) NOT NULL,
  `data` date NOT NULL,
  `usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pedido`
--

INSERT INTO `pedido` (`id`, `data`, `usuario`) VALUES
(1, '2017-08-13', 1),
(2, '2017-08-13', 1),
(3, '2017-08-13', 3),
(4, '2017-08-13', 4),
(5, '2017-08-13', 6);

-- --------------------------------------------------------

--
-- Table structure for table `pregao`
--

CREATE TABLE `pregao` (
  `id` int(11) NOT NULL,
  `data` date NOT NULL,
  `diasEntrega` int(11) DEFAULT NULL,
  `pedido` int(11) DEFAULT NULL,
  `usuario` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `pregao_itens`
--

CREATE TABLE `pregao_itens` (
  `id` int(11) NOT NULL,
  `produto_id` int(11) NOT NULL,
  `qtd` int(2) NOT NULL,
  `pregao_id` int(11) DEFAULT NULL,
  `valor_referencia` decimal(10,2) NOT NULL,
  `fornecedor_id` int(11) DEFAULT NULL,
  `status_item` int(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `produto`
--

CREATE TABLE `produto` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `catmat` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `produto`
--

INSERT INTO `produto` (`id`, `nome`, `catmat`) VALUES
(1, 'Desktop Dell 8GB', '164867'),
(2, 'Mesa Madeira Marfim', '103726'),
(3, 'Memória RAM 16GB', '526372'),
(4, 'Banco Acolchoado', '927362'),
(5, 'Folha sem Pauta A4', '836472'),
(6, 'Impressora HP4000', '948309');

-- --------------------------------------------------------

--
-- Table structure for table `setor`
--

CREATE TABLE `setor` (
  `id` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `setor`
--

INSERT INTO `setor` (`id`, `nome`) VALUES
(1, 'Administrativo'),
(2, 'Contabilidade'),
(3, 'Obras');

-- --------------------------------------------------------

--
-- Table structure for table `status_item`
--

CREATE TABLE `status_item` (
  `id` int(11) NOT NULL,
  `nome` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `email` varchar(30) NOT NULL,
  `senha` varchar(30) NOT NULL,
  `setor` int(11) NOT NULL,
  `endereco` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usuario`
--

INSERT INTO `usuario` (`id`, `nome`, `email`, `senha`, `setor`, `endereco`) VALUES
(1, 'Marcos André Fonseca', 'marcosAF@gmail.com', '123', 3, NULL),
(2, 'Felipe Castro ', 'felipeC@gmail.com', '123', 1, NULL),
(3, 'Wilson Matias', 'wilsonM@hotmail.com', '123', 2, NULL),
(4, 'Felipe Neto SilvA', 'FelipeNS@hotmail.com', '123', 3, NULL),
(5, 'Lucas Machado Gomes', 'LucasMG@gmail.com', '123', 1, NULL),
(6, 'Ricardo Paiva', 'ricardoP@hotmail.com', '1223', 3, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `endereco`
--
ALTER TABLE `endereco`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `fornecedor`
--
ALTER TABLE `fornecedor`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_endereco` (`endereco`);

--
-- Indexes for table `historico_renegociacao`
--
ALTER TABLE `historico_renegociacao`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `item_pedido`
--
ALTER TABLE `item_pedido`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_produto` (`produto`);

--
-- Indexes for table `item_pregao`
--
ALTER TABLE `item_pregao`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `nota_empenho`
--
ALTER TABLE `nota_empenho`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `notificacao_fornecedor`
--
ALTER TABLE `notificacao_fornecedor`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_usuario` (`usuario`);

--
-- Indexes for table `pregao`
--
ALTER TABLE `pregao`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_pedido` (`pedido`);

--
-- Indexes for table `pregao_itens`
--
ALTER TABLE `pregao_itens`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_pregao_id` (`pregao_id`),
  ADD KEY `fk_produto_id` (`produto_id`);

--
-- Indexes for table `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `setor`
--
ALTER TABLE `setor`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `status_item`
--
ALTER TABLE `status_item`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_setor` (`setor`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `endereco`
--
ALTER TABLE `endereco`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `fornecedor`
--
ALTER TABLE `fornecedor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `historico_renegociacao`
--
ALTER TABLE `historico_renegociacao`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `item_pedido`
--
ALTER TABLE `item_pedido`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `item_pregao`
--
ALTER TABLE `item_pregao`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `nota_empenho`
--
ALTER TABLE `nota_empenho`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `notificacao_fornecedor`
--
ALTER TABLE `notificacao_fornecedor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `pedido`
--
ALTER TABLE `pedido`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `pregao`
--
ALTER TABLE `pregao`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `pregao_itens`
--
ALTER TABLE `pregao_itens`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `produto`
--
ALTER TABLE `produto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `setor`
--
ALTER TABLE `setor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `status_item`
--
ALTER TABLE `status_item`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `fornecedor`
--
ALTER TABLE `fornecedor`
  ADD CONSTRAINT `fk_endereco` FOREIGN KEY (`endereco`) REFERENCES `endereco` (`id`);

--
-- Constraints for table `item_pedido`
--
ALTER TABLE `item_pedido`
  ADD CONSTRAINT `fk_produto` FOREIGN KEY (`produto`) REFERENCES `produto` (`id`);

--
-- Constraints for table `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `fk_usuario` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`);

--
-- Constraints for table `pregao`
--
ALTER TABLE `pregao`
  ADD CONSTRAINT `fk_pedido` FOREIGN KEY (`pedido`) REFERENCES `pedido` (`id`);

--
-- Constraints for table `pregao_itens`
--
ALTER TABLE `pregao_itens`
  ADD CONSTRAINT `fk_pregao_id` FOREIGN KEY (`pregao_id`) REFERENCES `pregao` (`id`),
  ADD CONSTRAINT `fk_produto_id` FOREIGN KEY (`produto_id`) REFERENCES `produto` (`id`);

--
-- Constraints for table `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `fk_setor` FOREIGN KEY (`setor`) REFERENCES `setor` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
