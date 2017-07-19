-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: 19-Jul-2017 às 00:26
-- Versão do servidor: 5.7.18-0ubuntu0.16.04.1
-- PHP Version: 7.0.18-0ubuntu0.16.04.1

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
(4, 'Luis LTDA', 'Distribuidora do Luis', '1921281281', 'luisLTDA@gmail.com', '123123', NULL);

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
(1, 20, 6, 30, 5, 31, 7, 32, 1, 0);

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
(1, 'Em curso', '2017-07-10', 1, 32, 0);

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
(3, '2017-07-04', 5),
(4, '2017-07-04', 5);

-- --------------------------------------------------------

--
-- Estrutura da tabela `pregao`
--

CREATE TABLE `pregao` (
  `id` int(11) NOT NULL,
  `data` date NOT NULL,
  `diasEntrega` date NOT NULL,
  `pedido` int(11) NOT NULL,
  `usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `pregao`
--

INSERT INTO `pregao` (`id`, `data`, `diasEntrega`, `pedido`, `usuario`) VALUES
(2, '2017-07-04', '2017-07-06', 1, 5);

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
(1, 'Setor1');

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
(5, 'Joao Paulo', 'jp@gmail.com', '123', 1, 1);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `historico_renegociacao`
--
ALTER TABLE `historico_renegociacao`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `item_pedido`
--
ALTER TABLE `item_pedido`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `item_pregao`
--
ALTER TABLE `item_pregao`
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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `pregao`
--
ALTER TABLE `pregao`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `setor`
--
ALTER TABLE `setor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `status_item`
--
ALTER TABLE `status_item`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
