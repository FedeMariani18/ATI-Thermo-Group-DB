-- MySQL dump 10.13  Distrib 8.0.42, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: ati_thermo_group
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.32-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `articoli`
--

DROP TABLE IF EXISTS `articoli`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `articoli` (
  `id_prodotto` int(11) NOT NULL,
  `id_seriale` int(11) NOT NULL,
  `id_magazzino` int(11) DEFAULT NULL,
  `numero_scansia` int(11) DEFAULT NULL,
  `colonna` int(11) DEFAULT NULL,
  `piano` int(11) DEFAULT NULL,
  `id_bolla_vendita` int(11) DEFAULT NULL,
  `id_bolla_acquisto` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_prodotto`,`id_seriale`),
  KEY `id_magazzino` (`id_magazzino`,`numero_scansia`,`colonna`,`piano`),
  KEY `id_bolla_vendita` (`id_bolla_vendita`),
  KEY `id_bolla_acquisto` (`id_bolla_acquisto`),
  CONSTRAINT `articoli_ibfk_1` FOREIGN KEY (`id_prodotto`) REFERENCES `prodotti` (`id_prodotto`),
  CONSTRAINT `articoli_ibfk_2` FOREIGN KEY (`id_magazzino`, `numero_scansia`, `colonna`, `piano`) REFERENCES `quadranti` (`id_magazzino`, `numero_scansia`, `colonna`, `piano`),
  CONSTRAINT `articoli_ibfk_3` FOREIGN KEY (`id_bolla_vendita`) REFERENCES `bolle_vendita` (`id_bolla_vendita`),
  CONSTRAINT `articoli_ibfk_4` FOREIGN KEY (`id_bolla_acquisto`) REFERENCES `bolle_acquisto` (`id_bolla_acquisto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `articoli`
--

LOCK TABLES `articoli` WRITE;
/*!40000 ALTER TABLE `articoli` DISABLE KEYS */;
INSERT INTO `articoli` VALUES (1,1001,1,1,1,1,1,1),(1,2005,4,1,1,1,2,NULL),(1,2006,4,1,1,1,2,2002),(1,2007,4,1,1,1,2,NULL),(2,1002,2,1,1,1,2,2),(3,1003,3,1,1,1,3,3),(4,1004,1,1,1,1,4,NULL),(7,3001,5,1,1,1,7,2003),(7,3002,5,1,1,1,8,NULL),(8,2001,5,1,1,1,7,4),(8,2002,5,1,1,1,7,NULL),(8,2003,5,1,1,1,8,2000),(8,2004,5,1,1,1,8,NULL);
/*!40000 ALTER TABLE `articoli` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bolle_acquisto`
--

DROP TABLE IF EXISTS `bolle_acquisto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bolle_acquisto` (
  `id_bolla_acquisto` int(11) NOT NULL AUTO_INCREMENT,
  `data` date DEFAULT NULL,
  `p_iva` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_bolla_acquisto`),
  KEY `p_iva` (`p_iva`),
  CONSTRAINT `bolle_acquisto_ibfk_1` FOREIGN KEY (`p_iva`) REFERENCES `utenti_mercato` (`p_iva`)
) ENGINE=InnoDB AUTO_INCREMENT=2007 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bolle_acquisto`
--

LOCK TABLES `bolle_acquisto` WRITE;
/*!40000 ALTER TABLE `bolle_acquisto` DISABLE KEYS */;
INSERT INTO `bolle_acquisto` VALUES (1,'2025-07-14','12345678901'),(2,'2025-07-14','98765432109'),(3,'2025-07-13','11112222333'),(4,'2025-07-12','44445555666'),(2000,'2025-07-14','11112222333'),(2001,'2025-07-12','22223333444'),(2002,'2025-07-11','77778888999'),(2003,'2025-07-10','55667788991'),(2004,'2025-07-09','99887766554'),(2005,'2025-07-15','55667788991'),(2006,'2025-07-15','99887766554');
/*!40000 ALTER TABLE `bolle_acquisto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bolle_vendita`
--

DROP TABLE IF EXISTS `bolle_vendita`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bolle_vendita` (
  `id_bolla_vendita` int(11) NOT NULL AUTO_INCREMENT,
  `id_ordine` int(11) DEFAULT NULL,
  `data` date DEFAULT NULL,
  `p_iva` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_bolla_vendita`),
  KEY `id_ordine` (`id_ordine`),
  KEY `p_iva` (`p_iva`),
  CONSTRAINT `bolle_vendita_ibfk_1` FOREIGN KEY (`id_ordine`) REFERENCES `ordini` (`id_ordine`),
  CONSTRAINT `bolle_vendita_ibfk_2` FOREIGN KEY (`p_iva`) REFERENCES `utenti_mercato` (`p_iva`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bolle_vendita`
--

LOCK TABLES `bolle_vendita` WRITE;
/*!40000 ALTER TABLE `bolle_vendita` DISABLE KEYS */;
INSERT INTO `bolle_vendita` VALUES (1,1,'2025-07-14','12345678901'),(2,2,'2025-07-14','98765432109'),(3,3,'2025-07-14','11112222333'),(4,4,'2025-07-14','44445555666'),(5,5,'2025-07-15','22223333444'),(6,6,'2025-07-15','77778888999'),(7,7,'2025-07-15','55667788991'),(8,8,'2025-07-15','99887766554'),(9,9,'2025-07-15','55667788991'),(10,10,'2025-07-15','99887766554');
/*!40000 ALTER TABLE `bolle_vendita` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categorie`
--

DROP TABLE IF EXISTS `categorie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categorie` (
  `id_categoria` int(11) NOT NULL AUTO_INCREMENT,
  `id_categoria_statistica` int(11) DEFAULT NULL,
  `descrizione` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_categoria`),
  KEY `id_categoria_statistica` (`id_categoria_statistica`),
  CONSTRAINT `categorie_ibfk_1` FOREIGN KEY (`id_categoria_statistica`) REFERENCES `categorie_statistiche` (`id_categoria_statistica`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorie`
--

LOCK TABLES `categorie` WRITE;
/*!40000 ALTER TABLE `categorie` DISABLE KEYS */;
INSERT INTO `categorie` VALUES (1,1,'Categoria 1'),(2,2,'Categoria 2'),(3,3,'Categoria 3'),(4,4,'Categoria 4'),(5,5,'Caldaie a condensazione');
/*!40000 ALTER TABLE `categorie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categorie_statistiche`
--

DROP TABLE IF EXISTS `categorie_statistiche`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categorie_statistiche` (
  `id_categoria_statistica` int(11) NOT NULL AUTO_INCREMENT,
  `descrizione` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_categoria_statistica`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorie_statistiche`
--

LOCK TABLES `categorie_statistiche` WRITE;
/*!40000 ALTER TABLE `categorie_statistiche` DISABLE KEYS */;
INSERT INTO `categorie_statistiche` VALUES (1,'Categoria Statistica 1'),(2,'Categoria Statistica 2'),(3,'Categoria Statistica 3'),(4,'Categoria Statistica 4'),(5,'Impianti di riscaldamento');
/*!40000 ALTER TABLE `categorie_statistiche` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `città`
--

DROP TABLE IF EXISTS `città`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `città` (
  `nome_citta` varchar(100) NOT NULL,
  PRIMARY KEY (`nome_citta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `città`
--

LOCK TABLES `città` WRITE;
/*!40000 ALTER TABLE `città` DISABLE KEYS */;
INSERT INTO `città` VALUES ('Bologna'),('Milano'),('Torino');
/*!40000 ALTER TABLE `città` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dipendenti`
--

DROP TABLE IF EXISTS `dipendenti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dipendenti` (
  `codice_fiscale` varchar(20) NOT NULL,
  `nome` varchar(50) DEFAULT NULL,
  `cognome` varchar(50) DEFAULT NULL,
  `anno_di_nascita` int(11) DEFAULT NULL,
  `nome_ruolo` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`codice_fiscale`),
  KEY `nome_ruolo` (`nome_ruolo`),
  CONSTRAINT `dipendenti_ibfk_1` FOREIGN KEY (`nome_ruolo`) REFERENCES `ruoli_dipendente` (`nome_ruolo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dipendenti`
--

LOCK TABLES `dipendenti` WRITE;
/*!40000 ALTER TABLE `dipendenti` DISABLE KEYS */;
INSERT INTO `dipendenti` VALUES ('BNCLNZ90A01H501K','Lorenzo','Bianchi',1990,'Operaio'),('FRRGPP92B01H501Q','Giuseppe','Ferrari',1992,'Responsabile'),('RSSMRA80A01H501Z','Mario','Rossi',1980,'Operaio'),('VRDLGI85C10H501T','Luigi','Verdi',1985,'Responsabile');
/*!40000 ALTER TABLE `dipendenti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `distinte_base`
--

DROP TABLE IF EXISTS `distinte_base`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `distinte_base` (
  `id_prodotto_finale` int(11) NOT NULL,
  `id_prodotto` int(11) NOT NULL,
  `quantita` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_prodotto_finale`,`id_prodotto`),
  KEY `id_prodotto` (`id_prodotto`),
  CONSTRAINT `distinte_base_ibfk_1` FOREIGN KEY (`id_prodotto_finale`) REFERENCES `prodotti` (`id_prodotto`),
  CONSTRAINT `distinte_base_ibfk_2` FOREIGN KEY (`id_prodotto`) REFERENCES `prodotti` (`id_prodotto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `distinte_base`
--

LOCK TABLES `distinte_base` WRITE;
/*!40000 ALTER TABLE `distinte_base` DISABLE KEYS */;
INSERT INTO `distinte_base` VALUES (1,2,2),(2,1,3),(3,1,1),(4,2,2);
/*!40000 ALTER TABLE `distinte_base` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `distinte_base_passaggi`
--

DROP TABLE IF EXISTS `distinte_base_passaggi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `distinte_base_passaggi` (
  `nome_passaggio` varchar(100) NOT NULL,
  `id_prodotto` int(11) NOT NULL,
  `stima_durata` int(11) DEFAULT NULL,
  PRIMARY KEY (`nome_passaggio`,`id_prodotto`),
  KEY `id_prodotto` (`id_prodotto`),
  CONSTRAINT `distinte_base_passaggi_ibfk_1` FOREIGN KEY (`nome_passaggio`) REFERENCES `passaggi_di_lavorazione` (`nome_passaggio`),
  CONSTRAINT `distinte_base_passaggi_ibfk_2` FOREIGN KEY (`id_prodotto`) REFERENCES `prodotti` (`id_prodotto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `distinte_base_passaggi`
--

LOCK TABLES `distinte_base_passaggi` WRITE;
/*!40000 ALTER TABLE `distinte_base_passaggi` DISABLE KEYS */;
INSERT INTO `distinte_base_passaggi` VALUES ('Assemblaggio',2,45),('Controllo qualità',4,35),('Taglio',1,30),('Taglio',3,25);
/*!40000 ALTER TABLE `distinte_base_passaggi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gruppi`
--

DROP TABLE IF EXISTS `gruppi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gruppi` (
  `id_categoria_statistica` int(11) DEFAULT NULL,
  `id_categoria` int(11) DEFAULT NULL,
  `id_gruppo` int(11) NOT NULL AUTO_INCREMENT,
  `descrizione` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_gruppo`),
  KEY `id_categoria` (`id_categoria`),
  CONSTRAINT `gruppi_ibfk_1` FOREIGN KEY (`id_categoria`) REFERENCES `categorie` (`id_categoria`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gruppi`
--

LOCK TABLES `gruppi` WRITE;
/*!40000 ALTER TABLE `gruppi` DISABLE KEYS */;
INSERT INTO `gruppi` VALUES (1,1,1,'Gruppo A'),(2,2,2,'Gruppo B'),(3,3,3,'Gruppo C'),(4,4,4,'Gruppo D'),(5,5,5,'Linea Premium');
/*!40000 ALTER TABLE `gruppi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `magazzini`
--

DROP TABLE IF EXISTS `magazzini`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `magazzini` (
  `id_magazzino` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `via` varchar(100) DEFAULT NULL,
  `civico` varchar(10) DEFAULT NULL,
  `nome_citta` varchar(100) DEFAULT NULL,
  `capacita_max` int(11) DEFAULT NULL,
  `capacita_residua` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_magazzino`),
  KEY `nome_citta` (`nome_citta`),
  CONSTRAINT `magazzini_ibfk_1` FOREIGN KEY (`nome_citta`) REFERENCES `città` (`nome_citta`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `magazzini`
--

LOCK TABLES `magazzini` WRITE;
/*!40000 ALTER TABLE `magazzini` DISABLE KEYS */;
INSERT INTO `magazzini` VALUES (1,'Magazzino Nord','Via Roma','10','Milano',1000,998),(2,'Magazzino Sud','Via Torino','5','Torino',800,799),(3,'Magazzino Est','Via Firenze','22','Milano',600,599),(4,'Magazzino Ovest','Via Napoli','8','Torino',3,0),(5,'Deposito Centrale','Via degli Artigiani','12','Bologna',1200,1194);
/*!40000 ALTER TABLE `magazzini` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordini`
--

DROP TABLE IF EXISTS `ordini`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ordini` (
  `id_ordine` int(11) NOT NULL AUTO_INCREMENT,
  `data` date DEFAULT NULL,
  `p_iva` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_ordine`),
  KEY `p_iva` (`p_iva`),
  CONSTRAINT `ordini_ibfk_1` FOREIGN KEY (`p_iva`) REFERENCES `utenti_mercato` (`p_iva`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordini`
--

LOCK TABLES `ordini` WRITE;
/*!40000 ALTER TABLE `ordini` DISABLE KEYS */;
INSERT INTO `ordini` VALUES (1,'2025-07-14','12345678901'),(2,'2025-07-14','98765432109'),(3,'2025-07-13','11112222333'),(4,'2025-07-12','44445555666'),(5,'2025-07-12','22223333444'),(6,'2025-07-11','77778888999'),(7,'2025-07-10','55667788991'),(8,'2025-07-09','99887766554'),(9,'2025-07-13','55667788991'),(10,'2025-07-14','99887766554');
/*!40000 ALTER TABLE `ordini` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `passaggi_di_lavorazione`
--

DROP TABLE IF EXISTS `passaggi_di_lavorazione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `passaggi_di_lavorazione` (
  `nome_passaggio` varchar(100) NOT NULL,
  `descrizione` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`nome_passaggio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passaggi_di_lavorazione`
--

LOCK TABLES `passaggi_di_lavorazione` WRITE;
/*!40000 ALTER TABLE `passaggi_di_lavorazione` DISABLE KEYS */;
INSERT INTO `passaggi_di_lavorazione` VALUES ('Assemblaggio','Assemblaggio dei componenti'),('Collaudo','Verifica funzionamento e sicurezza'),('Controllo qualità','Controllo qualità finale'),('Imballaggio','Imballaggio del prodotto'),('Taglio','Taglio dei materiali');
/*!40000 ALTER TABLE `passaggi_di_lavorazione` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prodotti`
--

DROP TABLE IF EXISTS `prodotti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prodotti` (
  `id_prodotto` int(11) NOT NULL AUTO_INCREMENT,
  `prezzo_listino` decimal(10,2) DEFAULT NULL,
  `descrizione` varchar(255) DEFAULT NULL,
  `peso` decimal(10,2) DEFAULT NULL,
  `superficie` decimal(10,2) DEFAULT NULL,
  `prezzo_inventario` decimal(10,2) DEFAULT NULL,
  `codice_a_barre` varchar(100) DEFAULT NULL,
  `nome_stato` varchar(100) DEFAULT NULL,
  `id_gruppo` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_prodotto`),
  KEY `nome_stato` (`nome_stato`),
  KEY `id_gruppo` (`id_gruppo`),
  CONSTRAINT `prodotti_ibfk_1` FOREIGN KEY (`nome_stato`) REFERENCES `stati_di_lavorazione` (`nome_stato`),
  CONSTRAINT `prodotti_ibfk_2` FOREIGN KEY (`id_gruppo`) REFERENCES `gruppi` (`id_gruppo`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prodotti`
--

LOCK TABLES `prodotti` WRITE;
/*!40000 ALTER TABLE `prodotti` DISABLE KEYS */;
INSERT INTO `prodotti` VALUES (1,100.00,'Prodotto 1',1.50,2.00,90.00,'CODE00001','In produzione',1),(2,200.00,'Prodotto 2',2.00,3.00,180.00,'CODE00002','Completato',2),(3,150.00,'Prodotto 3',1.80,2.50,140.00,'CODE00003','In attesa',3),(4,120.00,'Prodotto 4',1.20,1.50,110.00,'CODE00004','In produzione',1),(5,95.00,'Prodotto 5',1.10,1.80,85.00,'CODE00005','In verifica',4),(6,250.00,'Prodotto 6',3.00,4.00,230.00,'CODE00006','Completato',2),(7,850.00,'Caldaia murale a condensazione 24kW',35.00,0.75,790.00,'THRM001','Assemblato',5),(8,120.00,'Valvola miscelatrice termostatica 3/4\"',1.20,0.15,105.00,'THRM002','In produzione',1);
/*!40000 ALTER TABLE `prodotti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quadranti`
--

DROP TABLE IF EXISTS `quadranti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quadranti` (
  `id_magazzino` int(11) NOT NULL,
  `numero_scansia` int(11) NOT NULL,
  `colonna` int(11) NOT NULL,
  `piano` int(11) NOT NULL,
  `capacita` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_magazzino`,`numero_scansia`,`colonna`,`piano`),
  CONSTRAINT `quadranti_ibfk_1` FOREIGN KEY (`id_magazzino`, `numero_scansia`) REFERENCES `scansie` (`id_magazzino`, `numero_scansia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quadranti`
--

LOCK TABLES `quadranti` WRITE;
/*!40000 ALTER TABLE `quadranti` DISABLE KEYS */;
INSERT INTO `quadranti` VALUES (1,1,1,1,100),(2,1,1,1,100),(3,1,1,1,50),(4,1,1,1,80),(5,1,1,1,100);
/*!40000 ALTER TABLE `quadranti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `richieste`
--

DROP TABLE IF EXISTS `richieste`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `richieste` (
  `id_ordine` int(11) NOT NULL,
  `id_prodotto` int(11) NOT NULL,
  `quantita` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_ordine`,`id_prodotto`),
  KEY `id_prodotto` (`id_prodotto`),
  CONSTRAINT `richieste_ibfk_1` FOREIGN KEY (`id_ordine`) REFERENCES `ordini` (`id_ordine`),
  CONSTRAINT `richieste_ibfk_2` FOREIGN KEY (`id_prodotto`) REFERENCES `prodotti` (`id_prodotto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `richieste`
--

LOCK TABLES `richieste` WRITE;
/*!40000 ALTER TABLE `richieste` DISABLE KEYS */;
INSERT INTO `richieste` VALUES (1,1,10),(2,2,5),(3,3,7),(4,4,3),(5,5,6),(6,6,4),(7,7,2),(8,8,10),(9,7,1),(9,8,5),(10,8,8);
/*!40000 ALTER TABLE `richieste` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ruoli_dipendente`
--

DROP TABLE IF EXISTS `ruoli_dipendente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ruoli_dipendente` (
  `nome_ruolo` varchar(100) NOT NULL,
  `descrizione` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`nome_ruolo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ruoli_dipendente`
--

LOCK TABLES `ruoli_dipendente` WRITE;
/*!40000 ALTER TABLE `ruoli_dipendente` DISABLE KEYS */;
INSERT INTO `ruoli_dipendente` VALUES ('Operaio','Addetto alla produzione'),('Responsabile','Responsabile di reparto');
/*!40000 ALTER TABLE `ruoli_dipendente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scansie`
--

DROP TABLE IF EXISTS `scansie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `scansie` (
  `id_magazzino` int(11) NOT NULL,
  `numero_scansia` int(11) NOT NULL,
  PRIMARY KEY (`id_magazzino`,`numero_scansia`),
  CONSTRAINT `scansie_ibfk_1` FOREIGN KEY (`id_magazzino`) REFERENCES `magazzini` (`id_magazzino`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scansie`
--

LOCK TABLES `scansie` WRITE;
/*!40000 ALTER TABLE `scansie` DISABLE KEYS */;
INSERT INTO `scansie` VALUES (1,1),(2,1),(3,1),(4,1),(5,1);
/*!40000 ALTER TABLE `scansie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schede_di_lavorazione`
--

DROP TABLE IF EXISTS `schede_di_lavorazione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `schede_di_lavorazione` (
  `codice_fiscale` varchar(20) NOT NULL,
  `id_prodotto` int(11) NOT NULL,
  `id_seriale` int(11) NOT NULL,
  `data` date NOT NULL,
  `ora_inizio` time DEFAULT NULL,
  `ora_fine` time DEFAULT NULL,
  PRIMARY KEY (`codice_fiscale`,`id_prodotto`,`id_seriale`,`data`),
  KEY `id_prodotto` (`id_prodotto`,`id_seriale`),
  CONSTRAINT `schede_di_lavorazione_ibfk_1` FOREIGN KEY (`codice_fiscale`) REFERENCES `dipendenti` (`codice_fiscale`),
  CONSTRAINT `schede_di_lavorazione_ibfk_2` FOREIGN KEY (`id_prodotto`, `id_seriale`) REFERENCES `articoli` (`id_prodotto`, `id_seriale`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schede_di_lavorazione`
--

LOCK TABLES `schede_di_lavorazione` WRITE;
/*!40000 ALTER TABLE `schede_di_lavorazione` DISABLE KEYS */;
INSERT INTO `schede_di_lavorazione` VALUES ('BNCLNZ90A01H501K',3,1003,'2025-07-14','10:00:00','12:00:00'),('FRRGPP92B01H501Q',4,1004,'2025-07-14','11:00:00','14:00:00'),('RSSMRA80A01H501Z',1,1001,'2025-07-14','08:00:00','12:00:00'),('VRDLGI85C10H501T',2,1002,'2025-07-14','09:00:00','13:00:00');
/*!40000 ALTER TABLE `schede_di_lavorazione` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sconti_complessivi`
--

DROP TABLE IF EXISTS `sconti_complessivi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sconti_complessivi` (
  `id_sconto_complessivo` int(11) NOT NULL AUTO_INCREMENT,
  `percentuale` decimal(5,2) DEFAULT NULL,
  PRIMARY KEY (`id_sconto_complessivo`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sconti_complessivi`
--

LOCK TABLES `sconti_complessivi` WRITE;
/*!40000 ALTER TABLE `sconti_complessivi` DISABLE KEYS */;
INSERT INTO `sconti_complessivi` VALUES (1,5.00),(2,10.00),(3,7.50),(4,15.00),(5,20.00),(6,3.50),(7,12.00),(8,8.50);
/*!40000 ALTER TABLE `sconti_complessivi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sconti_prodotto`
--

DROP TABLE IF EXISTS `sconti_prodotto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sconti_prodotto` (
  `id_sconto_prodotto` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_sconto_prodotto`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sconti_prodotto`
--

LOCK TABLES `sconti_prodotto` WRITE;
/*!40000 ALTER TABLE `sconti_prodotto` DISABLE KEYS */;
INSERT INTO `sconti_prodotto` VALUES (1),(2),(3),(4),(5),(6),(7),(8);
/*!40000 ALTER TABLE `sconti_prodotto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scontistiche_clienti_prodotti`
--

DROP TABLE IF EXISTS `scontistiche_clienti_prodotti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `scontistiche_clienti_prodotti` (
  `id_prodotto` int(11) NOT NULL,
  `id_sconto_prodotto` int(11) NOT NULL,
  `percentuale` decimal(5,2) DEFAULT NULL,
  PRIMARY KEY (`id_prodotto`,`id_sconto_prodotto`),
  KEY `id_sconto_prodotto` (`id_sconto_prodotto`),
  CONSTRAINT `scontistiche_clienti_prodotti_ibfk_1` FOREIGN KEY (`id_prodotto`) REFERENCES `prodotti` (`id_prodotto`),
  CONSTRAINT `scontistiche_clienti_prodotti_ibfk_2` FOREIGN KEY (`id_sconto_prodotto`) REFERENCES `sconti_prodotto` (`id_sconto_prodotto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scontistiche_clienti_prodotti`
--

LOCK TABLES `scontistiche_clienti_prodotti` WRITE;
/*!40000 ALTER TABLE `scontistiche_clienti_prodotti` DISABLE KEYS */;
INSERT INTO `scontistiche_clienti_prodotti` VALUES (1,1,5.00),(2,2,10.00);
/*!40000 ALTER TABLE `scontistiche_clienti_prodotti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stati_di_lavorazione`
--

DROP TABLE IF EXISTS `stati_di_lavorazione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stati_di_lavorazione` (
  `nome_stato` varchar(100) NOT NULL,
  `descrizione` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`nome_stato`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stati_di_lavorazione`
--

LOCK TABLES `stati_di_lavorazione` WRITE;
/*!40000 ALTER TABLE `stati_di_lavorazione` DISABLE KEYS */;
INSERT INTO `stati_di_lavorazione` VALUES ('Assemblato','Il prodotto è stato assemblato e pronto per test'),('Completato','Il prodotto è stato completato'),('In attesa','In attesa di lavorazione'),('In produzione','Il prodotto è in produzione'),('In verifica','Controlli in corso');
/*!40000 ALTER TABLE `stati_di_lavorazione` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipi_pagamento`
--

DROP TABLE IF EXISTS `tipi_pagamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipi_pagamento` (
  `id_pagamento` int(11) NOT NULL AUTO_INCREMENT,
  `descrizione` varchar(255) DEFAULT NULL,
  `durata` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_pagamento`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipi_pagamento`
--

LOCK TABLES `tipi_pagamento` WRITE;
/*!40000 ALTER TABLE `tipi_pagamento` DISABLE KEYS */;
INSERT INTO `tipi_pagamento` VALUES (1,'Pagamento a 30 giorni',30),(2,'Pagamento immediato',0);
/*!40000 ALTER TABLE `tipi_pagamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipologie_utenti_mercato`
--

DROP TABLE IF EXISTS `tipologie_utenti_mercato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipologie_utenti_mercato` (
  `nome_tipologia_utente_mercato` varchar(100) NOT NULL,
  `descrizione` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`nome_tipologia_utente_mercato`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipologie_utenti_mercato`
--

LOCK TABLES `tipologie_utenti_mercato` WRITE;
/*!40000 ALTER TABLE `tipologie_utenti_mercato` DISABLE KEYS */;
INSERT INTO `tipologie_utenti_mercato` VALUES ('Cliente finale','Cliente diretto'),('Rivenditore','Rivenditore autorizzato');
/*!40000 ALTER TABLE `tipologie_utenti_mercato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utenti_mercato`
--

DROP TABLE IF EXISTS `utenti_mercato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `utenti_mercato` (
  `p_iva` varchar(20) NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `nazione` varchar(100) DEFAULT NULL,
  `banca` varchar(100) DEFAULT NULL,
  `id_pagamento` int(11) DEFAULT NULL,
  `nome_tipologia_utente_mercato` varchar(100) DEFAULT NULL,
  `id_sconto_prodotto` int(11) DEFAULT NULL,
  `id_sconto_complessivo` int(11) DEFAULT NULL,
  PRIMARY KEY (`p_iva`),
  KEY `id_pagamento` (`id_pagamento`),
  KEY `nome_tipologia_utente_mercato` (`nome_tipologia_utente_mercato`),
  KEY `id_sconto_prodotto` (`id_sconto_prodotto`),
  KEY `id_sconto_complessivo` (`id_sconto_complessivo`),
  CONSTRAINT `utenti_mercato_ibfk_1` FOREIGN KEY (`id_pagamento`) REFERENCES `tipi_pagamento` (`id_pagamento`),
  CONSTRAINT `utenti_mercato_ibfk_2` FOREIGN KEY (`nome_tipologia_utente_mercato`) REFERENCES `tipologie_utenti_mercato` (`nome_tipologia_utente_mercato`),
  CONSTRAINT `utenti_mercato_ibfk_3` FOREIGN KEY (`id_sconto_prodotto`) REFERENCES `sconti_prodotto` (`id_sconto_prodotto`),
  CONSTRAINT `utenti_mercato_ibfk_4` FOREIGN KEY (`id_sconto_complessivo`) REFERENCES `sconti_complessivi` (`id_sconto_complessivo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utenti_mercato`
--

LOCK TABLES `utenti_mercato` WRITE;
/*!40000 ALTER TABLE `utenti_mercato` DISABLE KEYS */;
INSERT INTO `utenti_mercato` VALUES ('11112222333','Cliente 3','Italia','Banca C',1,'Cliente finale',3,3),('12345678901','Cliente 1','Italia','Banca A',1,'Rivenditore',1,1),('22223333444','Cliente 5','Italia','Banca E',1,'Cliente finale',5,5),('44445555666','Cliente 4','Italia','Banca D',2,'Rivenditore',4,4),('55667788991','Termoidraulica Rossi Srl','Italia','Banca Intesa',1,'Rivenditore',7,7),('77778888999','Cliente 6','Italia','Banca F',2,'Rivenditore',6,6),('98765432109','Cliente 2','Italia','Banca B',2,'Cliente finale',2,2),('99887766554','Idroimpianti Bianchi','Italia','Unicredit',2,'Cliente finale',8,8);
/*!40000 ALTER TABLE `utenti_mercato` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-07-15  1:36:47
