-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 19, 2016 at 05:48 PM
-- Server version: 5.7.10-log
-- PHP Version: 5.6.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `lecaddyfutedb`
--

-- --------------------------------------------------------

--
-- Table structure for table `address`
--

CREATE TABLE `address` (
  `id` int(11) NOT NULL,
  `active` int(11) DEFAULT NULL,
  `bp` int(11) DEFAULT NULL,
  `code_postal` varchar(255) DEFAULT NULL,
  `date_activation` datetime DEFAULT NULL,
  `date_creation` datetime DEFAULT NULL,
  `date_fermeture` datetime DEFAULT NULL,
  `date_modification` datetime DEFAULT NULL,
  `pays` int(11) DEFAULT NULL,
  `quartier` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  `rue` varchar(255) DEFAULT NULL,
  `signature` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `ville` varchar(255) DEFAULT NULL,
  `website` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `bill`
--

CREATE TABLE `bill` (
  `id` int(11) NOT NULL,
  `active` int(11) DEFAULT NULL,
  `date_activation` datetime DEFAULT NULL,
  `date_creation` datetime DEFAULT NULL,
  `date_facture` datetime DEFAULT NULL,
  `date_fermeture` datetime DEFAULT NULL,
  `date_modification` datetime DEFAULT NULL,
  `id_source` int(11) DEFAULT NULL,
  `montant` double DEFAULT NULL,
  `signature` varchar(255) DEFAULT NULL,
  `statut` int(11) DEFAULT NULL,
  `version` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `id` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  `firstname` varchar(50) NOT NULL,
  `date_of_birth` date NOT NULL,
  `sex` enum('F','M') DEFAULT NULL,
  `ip_address` varchar(15) NOT NULL,
  `date_activation` date DEFAULT NULL,
  `is_activated` tinyint(1) DEFAULT NULL,
  `date_modification` date DEFAULT NULL,
  `address_line1` varchar(50) NOT NULL,
  `adress_line2` varchar(50) DEFAULT NULL,
  `zip_code` varchar(10) NOT NULL,
  `neighborhood` varchar(50) NOT NULL,
  `city` varchar(100) NOT NULL,
  `country` varchar(100) NOT NULL,
  `cellphone` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `menu`
--

CREATE TABLE `menu` (
  `id` int(11) NOT NULL,
  `label_fr` varchar(50) NOT NULL,
  `label_en` varchar(50) DEFAULT NULL,
  `description` varchar(255) NOT NULL,
  `action` varchar(255) DEFAULT NULL,
  `classe` varchar(255) DEFAULT NULL,
  `code_libelle` varchar(255) DEFAULT NULL,
  `date_creation` datetime DEFAULT NULL,
  `date_modification` datetime DEFAULT NULL,
  `icone` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `ordre` smallint(6) DEFAULT NULL,
  `parent` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `menus`
--

CREATE TABLE `menus` (
  `id` int(11) NOT NULL,
  `action` varchar(255) DEFAULT NULL,
  `classe` varchar(255) DEFAULT NULL,
  `code_libelle` varchar(255) DEFAULT NULL,
  `date_creation` datetime DEFAULT NULL,
  `date_modification` datetime DEFAULT NULL,
  `description` varchar(255) NOT NULL,
  `icone` varchar(255) DEFAULT NULL,
  `label_en` varchar(255) DEFAULT NULL,
  `label_fr` varchar(255) NOT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `ordre` smallint(6) DEFAULT NULL,
  `parent` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `neighborhood`
--

CREATE TABLE `neighborhood` (
  `id` int(11) NOT NULL,
  `id_city` int(11) NOT NULL,
  `name` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `parameter`
--

CREATE TABLE `parameter` (
  `code` varchar(255) NOT NULL,
  `createdDate` date DEFAULT NULL,
  `createdDateTime` datetime DEFAULT NULL,
  `createdHour` time DEFAULT NULL,
  `creatorId` int(11) DEFAULT NULL,
  `description` longtext,
  `isActiveData` int(11) DEFAULT NULL,
  `isDeleteData` int(11) DEFAULT NULL,
  `lastModifierId` int(11) DEFAULT NULL,
  `lastUpdatedDateTime` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `signature` varchar(255) DEFAULT NULL,
  `universalId` varchar(255) DEFAULT NULL,
  `value` longtext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `parameter_db`
--

CREATE TABLE `parameter_db` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `value` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `parameter_db`
--

INSERT INTO `parameter_db` (`id`, `name`, `value`) VALUES
(1, 'total_visitors', '38');

-- --------------------------------------------------------

--
-- Table structure for table `payment_method`
--

CREATE TABLE `payment_method` (
  `id` int(11) NOT NULL,
  `label` varchar(50) NOT NULL,
  `description` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id` int(11) NOT NULL,
  `id_product_category` int(11) NOT NULL,
  `designation` varchar(150) NOT NULL,
  `brand` varchar(150) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `main_image` varchar(255) DEFAULT NULL,
  `image_thum1` varchar(255) DEFAULT NULL,
  `image_thum2` varchar(255) DEFAULT NULL,
  `image_thum3` varchar(255) DEFAULT NULL,
  `image_thum4` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `product_category`
--

CREATE TABLE `product_category` (
  `id` int(11) NOT NULL,
  `name` varchar(150) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `product_category`
--

INSERT INTO `product_category` (`id`, `name`, `description`, `image`) VALUES
(1, 'produits_laitier', NULL, NULL),
(2, 'produits_hygienique', NULL, NULL),
(3, 'produits_beaute', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `promoted_product`
--

CREATE TABLE `promoted_product` (
  `id` int(11) NOT NULL,
  `id_produit` int(11) NOT NULL,
  `id_shop` int(11) NOT NULL,
  `price` double DEFAULT NULL,
  `date_creation` date NOT NULL,
  `date_expiration` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `propositiongarantie`
--

CREATE TABLE `propositiongarantie` (
  `id` int(11) NOT NULL,
  `id_garantie` int(11) DEFAULT NULL,
  `typegarantie` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `rayonproduit`
--

CREATE TABLE `rayonproduit` (
  `id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `short_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `rayonproduit`
--

INSERT INTO `rayonproduit` (`id`, `description`, `name`, `short_name`) VALUES
(1, NULL, 'rayon.bebe', 'bebe'),
(2, NULL, 'rayon.hygiene.beaute', 'Hygiene-beaute'),
(3, NULL, 'rayon.produits.entretien', 'produit-entretien'),
(4, NULL, 'rayon.boisson.alcool', 'boisson-alcool'),
(5, NULL, 'rayon.epices.sucrees', 'epices-salees');

-- --------------------------------------------------------

--
-- Table structure for table `rights`
--

CREATE TABLE `rights` (
  `id` int(11) NOT NULL,
  `id_menu` int(11) NOT NULL,
  `id_role` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `label` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `name`, `label`) VALUES
(1, 'ROLE_ADMIN', 'label.admin'),
(2, 'ROLE_USER', 'label.user'),
(3, 'ROLE_SHOP', 'label.shop'),
(4, 'ROLE_VISITOR', 'label.visitor');

-- --------------------------------------------------------

--
-- Table structure for table `service`
--

CREATE TABLE `service` (
  `id` int(11) NOT NULL,
  `id_shop` int(11) NOT NULL,
  `id_type_service` int(11) NOT NULL,
  `title` varchar(50) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `image_path` varchar(100) DEFAULT NULL,
  `status` int(11) NOT NULL,
  `date_creation` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `shop`
--

CREATE TABLE `shop` (
  `id` int(11) NOT NULL,
  `id_shop_category` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `date_creation` date NOT NULL,
  `date_activation` date DEFAULT NULL,
  `is_activated` tinyint(1) DEFAULT NULL,
  `date_modification` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `shopping_list`
--

CREATE TABLE `shopping_list` (
  `id` int(11) NOT NULL,
  `id_product` int(11) NOT NULL,
  `price` double DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `date_creation` date NOT NULL,
  `date_modification` datetime DEFAULT NULL,
  `status` enum('Editing','Selected') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `shop_address`
--

CREATE TABLE `shop_address` (
  `id` int(11) NOT NULL,
  `id_shop` int(11) NOT NULL,
  `address_line1` varchar(50) NOT NULL,
  `adress_line2` varchar(50) DEFAULT NULL,
  `zip_code` varchar(10) NOT NULL,
  `neighborhood` varchar(50) NOT NULL,
  `city` varchar(100) NOT NULL,
  `country` varchar(100) NOT NULL,
  `cellphone` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `shop_bill`
--

CREATE TABLE `shop_bill` (
  `id` int(11) NOT NULL,
  `id_shop_billing_account` int(11) NOT NULL,
  `id_type_service` int(11) NOT NULL,
  `amount` double DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `date_create` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `shop_billing_account`
--

CREATE TABLE `shop_billing_account` (
  `id` int(11) NOT NULL,
  `id_shop` int(11) NOT NULL,
  `id_payment_method` int(11) DEFAULT NULL,
  `card_number` varchar(50) NOT NULL,
  `code` int(3) NOT NULL,
  `date_of_expiration` date NOT NULL,
  `address_line1` varchar(50) NOT NULL,
  `adress_line2` varchar(50) DEFAULT NULL,
  `zip_code` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `shop_bills`
--

CREATE TABLE `shop_bills` (
  `id` int(11) NOT NULL,
  `amount` double DEFAULT NULL,
  `date_create` datetime NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `id_shop_billing_account` int(11) NOT NULL,
  `id_type_service` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `shop_membership_bill`
--

CREATE TABLE `shop_membership_bill` (
  `id` int(11) NOT NULL,
  `id_shop_billing_account` int(11) NOT NULL,
  `id_shop` int(11) NOT NULL,
  `amount` double DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `date_create` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `shop_membership_bills`
--

CREATE TABLE `shop_membership_bills` (
  `id` int(11) NOT NULL,
  `amount` double DEFAULT NULL,
  `date_create` datetime NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `id_shop` int(11) NOT NULL,
  `id_shop_billing_account` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `status`
--

CREATE TABLE `status` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `description` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `type_service`
--

CREATE TABLE `type_service` (
  `id` int(11) NOT NULL,
  `label` varchar(50) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `type_services`
--

CREATE TABLE `type_services` (
  `id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `label` varchar(255) NOT NULL,
  `price` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `passwordConfirmed` varchar(100) NOT NULL,
  `firstname` varchar(100) DEFAULT NULL,
  `lastname` varchar(100) DEFAULT NULL,
  `idrole` int(11) NOT NULL,
  `email` varchar(100) NOT NULL,
  `date_creation` datetime NOT NULL,
  `date_modification` datetime DEFAULT NULL,
  `address_id` int(11) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `date_activation` datetime DEFAULT NULL,
  `is_active` int(11) NOT NULL,
  `id_role` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- --------------------------------------------------------

--
-- Table structure for table `user_billing_account`
--

CREATE TABLE `user_billing_account` (
  `id` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_payment_method` int(11) DEFAULT NULL,
  `card_number` varchar(50) NOT NULL,
  `code` int(3) NOT NULL,
  `date_of_expiration` date NOT NULL,
  `address_line1` varchar(50) NOT NULL,
  `adress_line2` varchar(50) DEFAULT NULL,
  `zip_code` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `user_membership_bill`
--

CREATE TABLE `user_membership_bill` (
  `id` int(11) NOT NULL,
  `id_user_billing_account` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `amount` double DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `date_create` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `user_shopping_list`
--

CREATE TABLE `user_shopping_list` (
  `id` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_shopping_list` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `user_shopping_list_bill`
--

CREATE TABLE `user_shopping_list_bill` (
  `id` int(11) NOT NULL,
  `id_user_billing_account` int(11) NOT NULL,
  `id_shopping_list` int(11) NOT NULL,
  `amount` double DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `date_create` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `visitor_counter`
--

CREATE TABLE `visitor_counter` (
  `id` int(11) NOT NULL,
  `anneeVisite` varchar(255) DEFAULT NULL,
  `heureVisite` varchar(255) DEFAULT NULL,
  `jourVisite` varchar(255) DEFAULT NULL,
  `moiVisite` varchar(255) DEFAULT NULL,
  `nbVisite` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



--
-- Indexes for dumped tables
--

--
-- Indexes for table `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `bill`
--
ALTER TABLE `bill`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_19m8nwa1wp2kt0lh5e1e7ynku` (`parent`);

--
-- Indexes for table `menus`
--
ALTER TABLE `menus`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `neighborhood`
--
ALTER TABLE `neighborhood`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `parameter`
--
ALTER TABLE `parameter`
  ADD PRIMARY KEY (`code`);

--
-- Indexes for table `parameter_db`
--
ALTER TABLE `parameter_db`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `payment_method`
--
ALTER TABLE `payment_method`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `product_category`
--
ALTER TABLE `product_category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `promoted_product`
--
ALTER TABLE `promoted_product`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `propositiongarantie`
--
ALTER TABLE `propositiongarantie`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rayonproduit`
--
ALTER TABLE `rayonproduit`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`);

--
-- Indexes for table `rights`
--
ALTER TABLE `rights`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `service`
--
ALTER TABLE `service`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `shop`
--
ALTER TABLE `shop`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `shopping_list`
--
ALTER TABLE `shopping_list`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `shop_address`
--
ALTER TABLE `shop_address`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `shop_bill`
--
ALTER TABLE `shop_bill`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `shop_billing_account`
--
ALTER TABLE `shop_billing_account`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `shop_bills`
--
ALTER TABLE `shop_bills`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `shop_membership_bill`
--
ALTER TABLE `shop_membership_bill`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `shop_membership_bills`
--
ALTER TABLE `shop_membership_bills`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `status`
--
ALTER TABLE `status`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `type_service`
--
ALTER TABLE `type_service`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `type_services`
--
ALTER TABLE `type_services`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_dhlcfg8h1drrgu0irs1ro3ohb` (`address_id`),
  ADD KEY `FK_4j34htxrd33rn7lvap5j7fl8u` (`id_role`);

--
-- Indexes for table `user_billing_account`
--
ALTER TABLE `user_billing_account`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_membership_bill`
--
ALTER TABLE `user_membership_bill`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_shopping_list`
--
ALTER TABLE `user_shopping_list`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_shopping_list_bill`
--
ALTER TABLE `user_shopping_list_bill`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `visitor_counter`
--
ALTER TABLE `visitor_counter`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `address`
--
ALTER TABLE `address`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `neighborhood`
--
ALTER TABLE `neighborhood`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `parameter_db`
--
ALTER TABLE `parameter_db`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `payment_method`
--
ALTER TABLE `payment_method`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `product_category`
--
ALTER TABLE `product_category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `promoted_product`
--
ALTER TABLE `promoted_product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `service`
--
ALTER TABLE `service`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `shop`
--
ALTER TABLE `shop`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `shopping_list`
--
ALTER TABLE `shopping_list`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `shop_address`
--
ALTER TABLE `shop_address`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `shop_bill`
--
ALTER TABLE `shop_bill`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `shop_billing_account`
--
ALTER TABLE `shop_billing_account`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `shop_bills`
--
ALTER TABLE `shop_bills`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `shop_membership_bill`
--
ALTER TABLE `shop_membership_bill`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `shop_membership_bills`
--
ALTER TABLE `shop_membership_bills`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `status`
--
ALTER TABLE `status`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `type_service`
--
ALTER TABLE `type_service`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `type_services`
--
ALTER TABLE `type_services`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50;
--
-- AUTO_INCREMENT for table `user_billing_account`
--
ALTER TABLE `user_billing_account`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `user_membership_bill`
--
ALTER TABLE `user_membership_bill`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `user_shopping_list`
--
ALTER TABLE `user_shopping_list`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `user_shopping_list_bill`
--
ALTER TABLE `user_shopping_list_bill`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `visitor_counter`
--
ALTER TABLE `visitor_counter`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `menu`
--
ALTER TABLE `menu`
  ADD CONSTRAINT `FK_19m8nwa1wp2kt0lh5e1e7ynku` FOREIGN KEY (`parent`) REFERENCES `menu` (`id`);

--
-- Constraints for table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `FK_4j34htxrd33rn7lvap5j7fl8u` FOREIGN KEY (`id_role`) REFERENCES `role` (`id`),
  ADD CONSTRAINT `FK_dhlcfg8h1drrgu0irs1ro3ohb` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
