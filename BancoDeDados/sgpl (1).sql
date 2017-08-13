-- phpMyAdmin SQL Dump
-- version 4.7.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: 13-Ago-2017 às 21:54
-- Versão do servidor: 5.6.25
-- PHP Version: 7.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
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
-- Estrutura da tabela `endereco`
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
-- Extraindo dados da tabela `endereco`
--

INSERT INTO `endereco` (`id`, `logradouro`, `numero`, `complemento`, `bairro`, `cidade`, `cep`, `estado`, `pais`) VALUES
(9, 'Rua do Binário', '10', 'Casa Verde', 'Sete Setembro', 'Januária', '39480-000', 'MG', 'Brasil'),
(10, 'Rua do Binário', '10', 'Casa Verde', 'Sete Setembro', 'Januária', '39480-000', 'MG', 'Brasil'),
(11, 'Rua do Binário', '10', 'Casa Verde', 'Sete Setembro', 'Januária', '39480-000', 'MG', 'Brasil'),
(12, 'Rua do Binário', '10', 'Casa Verde', 'Sete Setembro', 'Januária', '39480-000', 'MG', 'Brasil');

-- --------------------------------------------------------

--
-- Estrutura da tabela `fornecedor`
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
-- Extraindo dados da tabela `fornecedor`
--

INSERT INTO `fornecedor` (`id`, `razaoSocial`, `nomeFantasia`, `cnpj`, `telefone`, `email`, `endereco`) VALUES
(5, 'Luis1 LTDA', 'Distribuidora do Luis', '1921281281', 'luisLTDA@gmail.com', '123123', 0),
(7, 'Luis1 LTDA', 'Distribuidora do Luis', '1921281281', 'luisLTDA@gmail.com', '123123', 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `historico_renegociacao`
--

CREATE TABLE `historico_renegociacao` (
  `id` int(11) NOT NULL,
  `descricao` varchar(50) NOT NULL,
  `data` date NOT NULL,
  `pregao` int(11) NOT NULL,
  `fornecedor` int(11) NOT NULL,
  `usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `historico_renegociacao`
--

INSERT INTO `historico_renegociacao` (`id`, `descricao`, `data`, `pregao`, `fornecedor`, `usuario`) VALUES
(1, 'Pagara corretamente...', '2017-07-04', 0, 32, 5);

-- --------------------------------------------------------

--
-- Estrutura da tabela `item_pedido`
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
-- Extraindo dados da tabela `item_pedido`
--

INSERT INTO `item_pedido` (`id`, `quantidade`, `Fornecedor1`, `valorFornecedor1`, `Fornecedor2`, `valorFornecedor2`, `Fornecedor3`, `valorFornecedor3`, `pedido`, `produto`) VALUES
(1, 20, 6, 30, 5, 31, 7, 32, 1, 0),
(2, 5, 10, 5, 20, 5, 15, 8, 3, 1),
(3, 10, 10, 5, 15, 5, 10, 5, 0, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `item_pregao`
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

--
-- Extraindo dados da tabela `item_pregao`
--

INSERT INTO `item_pregao` (`id`, `quantidade`, `valorReferencia`, `pregao`, `produto`, `fornecedor`, `statusItem`) VALUES
(1, 10, 20, 0, 0, 32, 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `notas_empenho`
--

CREATE TABLE `notas_empenho` (
  `id` int(11) NOT NULL,
  `numero_nota` int(11) NOT NULL,
  `item` int(11) NOT NULL,
  `valor` double NOT NULL,
  `pago` tinyint(1) NOT NULL,
  `data_pagamento` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `notas_empenho`
--

INSERT INTO `notas_empenho` (`id`, `numero_nota`, `item`, `valor`, `pago`, `data_pagamento`) VALUES
(1, 60, 16, 30, 1, NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `nota_empenho`
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

--
-- Extraindo dados da tabela `nota_empenho`
--

INSERT INTO `nota_empenho` (`id`, `data`, `valor`, `status`, `fornecedor`, `pregao`, `usuario`) VALUES
(1, '2017-07-04', 10.3, 'Desativado', 0, 0, 5);

-- --------------------------------------------------------

--
-- Estrutura da tabela `notificacao_fornecedor`
--

CREATE TABLE `notificacao_fornecedor` (
  `id` int(11) NOT NULL,
  `descricao` varchar(100) NOT NULL,
  `data` date NOT NULL,
  `status` int(11) NOT NULL,
  `fornecedor` int(11) NOT NULL,
  `pregao` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `notificacao_fornecedor`
--

INSERT INTO `notificacao_fornecedor` (`id`, `descricao`, `data`, `status`, `fornecedor`, `pregao`) VALUES
(1, 'Em curso....', '2017-07-10', 1, 32, 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `pedido`
--

CREATE TABLE `pedido` (
  `id` int(11) NOT NULL,
  `data` date NOT NULL,
  `usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `pedido`
--

INSERT INTO `pedido` (`id`, `data`, `usuario`) VALUES
(3, '2017-08-06', 5),
(4, '2017-07-04', 5),
(5, '2017-08-07', 5);

-- --------------------------------------------------------

--
-- Estrutura da tabela `pregao`
--

CREATE TABLE `pregao` (
  `id` int(11) NOT NULL,
  `data` date NOT NULL,
  `diasEntrega` int(11) DEFAULT NULL,
  `pedido` int(11) DEFAULT NULL,
  `usuario` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `pregao`
--

INSERT INTO `pregao` (`id`, `data`, `diasEntrega`, `pedido`, `usuario`) VALUES
(25, '2017-08-07', 0, NULL, NULL),
(26, '2017-08-07', 2, 3, NULL),
(27, '2017-08-07', 1, 3, NULL),
(28, '2017-08-09', 0, 4, NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `pregao_itens`
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

--
-- Extraindo dados da tabela `pregao_itens`
--

INSERT INTO `pregao_itens` (`id`, `produto_id`, `qtd`, `pregao_id`, `valor_referencia`, `fornecedor_id`, `status_item`) VALUES
(10, 1, 5, NULL, '6.00', NULL, NULL),
(11, 1, 5, 28, '6.00', NULL, NULL),
(15, 1, 5, 28, '300.00', NULL, 2),
(16, 1, 50, 28, '500.00', 5, 3);

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE `produto` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `catmat` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `produto`
--

INSERT INTO `produto` (`id`, `nome`, `catmat`) VALUES
(1, 'Computador', '123456');

-- --------------------------------------------------------

--
-- Estrutura da tabela `setor`
--

CREATE TABLE `setor` (
  `id` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `setor`
--

INSERT INTO `setor` (`id`, `nome`) VALUES
(1, 'Setor1'),
(2, 'Setor1'),
(3, 'Administração'),
(4, 'Protocolo'),
(5, 'Administracao'),
(6, 'Coordenação licitação');

-- --------------------------------------------------------

--
-- Estrutura da tabela `status_item`
--

CREATE TABLE `status_item` (
  `id` int(11) NOT NULL,
  `nome` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `status_item`
--

INSERT INTO `status_item` (`id`, `nome`) VALUES
(1, 'Ativos');

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
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
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`id`, `nome`, `email`, `senha`, `setor`, `endereco`) VALUES
(5, 'Joao Paulo', 'jp@gmail.com', '123', 1, 1),
(6, 'Érica Santan', 'erica@gmail.com', '123', 6, NULL);

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
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `historico_renegociacao`
--
ALTER TABLE `historico_renegociacao`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `item_pedido`
--
ALTER TABLE `item_pedido`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `item_pregao`
--
ALTER TABLE `item_pregao`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `notas_empenho`
--
ALTER TABLE `notas_empenho`
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
  ADD PRIMARY KEY (`id`);

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
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `endereco`
--
ALTER TABLE `endereco`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `fornecedor`
--
ALTER TABLE `fornecedor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `historico_renegociacao`
--
ALTER TABLE `historico_renegociacao`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `item_pedido`
--
ALTER TABLE `item_pedido`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `item_pregao`
--
ALTER TABLE `item_pregao`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `notas_empenho`
--
ALTER TABLE `notas_empenho`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `nota_empenho`
--
ALTER TABLE `nota_empenho`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `notificacao_fornecedor`
--
ALTER TABLE `notificacao_fornecedor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `pedido`
--
ALTER TABLE `pedido`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `pregao`
--
ALTER TABLE `pregao`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;
--
-- AUTO_INCREMENT for table `pregao_itens`
--
ALTER TABLE `pregao_itens`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT for table `produto`
--
ALTER TABLE `produto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `setor`
--
ALTER TABLE `setor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `status_item`
--
ALTER TABLE `status_item`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `pregao`
--
ALTER TABLE `pregao`
  ADD CONSTRAINT `fk_pedido` FOREIGN KEY (`pedido`) REFERENCES `pedido` (`id`);

--
-- Limitadores para a tabela `pregao_itens`
--
ALTER TABLE `pregao_itens`
  ADD CONSTRAINT `fk_pregao_id` FOREIGN KEY (`pregao_id`) REFERENCES `pregao` (`id`),
  ADD CONSTRAINT `fk_produto_id` FOREIGN KEY (`produto_id`) REFERENCES `produto` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
