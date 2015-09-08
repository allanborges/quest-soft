
/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
DROP TABLE IF EXISTS tb_pergunta;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE tb_pergunta (
  id_pergunta bigint(20) NOT NULL,
  pergunta varchar(255) DEFAULT NULL,
  PRIMARY KEY (id_pergunta)
);
/*!40101 SET character_set_client = @saved_cs_client */;

LOCK TABLES tb_pergunta WRITE;
/*!40000 ALTER TABLE tb_pergunta DISABLE KEYS */;
INSERT INTO tb_pergunta VALUES (1,'JAVA'),(2,'PHP'),(3,'Python'),(10,'C++'),(11,'Ruby');
/*!40000 ALTER TABLE tb_pergunta ENABLE KEYS */;
UNLOCK TABLES;
DROP TABLE IF EXISTS tb_quest;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE tb_quest (
  id_quest bigint(20) NOT NULL,
  aberta tinyint(1) NOT NULL,
  enunciado text NOT NULL,
  PRIMARY KEY (id_quest)
);
/*!40101 SET character_set_client = @saved_cs_client */;

LOCK TABLES tb_quest WRITE;
/*!40000 ALTER TABLE tb_quest DISABLE KEYS */;
INSERT INTO tb_quest VALUES (1,0,'Qual seua linguagem preferida'),(4,1,'O que você acha da situação atual do Brasil?');
/*!40000 ALTER TABLE tb_quest ENABLE KEYS */;
UNLOCK TABLES;
DROP TABLE IF EXISTS tb_quest_x_tb_pergunta;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE tb_quest_x_tb_pergunta (
  id_quest bigint(20) NOT NULL,
  id_pergunta bigint(20) NOT NULL,
  UNIQUE KEY UK_g9g2sy046w02qxjnh2umrgd4i (id_quest,id_pergunta),
  KEY FK_dsp4bi3ju0ulbg7ki8ubg33tg (id_pergunta),
  KEY FK_f9g946tskxq64vxki6j0rm82l (id_quest),
  CONSTRAINT FK_f9g946tskxq64vxki6j0rm82l FOREIGN KEY (id_quest) REFERENCES tb_quest (id_quest),
  CONSTRAINT FK_dsp4bi3ju0ulbg7ki8ubg33tg FOREIGN KEY (id_pergunta) REFERENCES tb_pergunta (id_pergunta)
);
/*!40101 SET character_set_client = @saved_cs_client */;

LOCK TABLES tb_quest_x_tb_pergunta WRITE;
/*!40000 ALTER TABLE tb_quest_x_tb_pergunta DISABLE KEYS */;
/*!40000 ALTER TABLE tb_quest_x_tb_pergunta ENABLE KEYS */;
UNLOCK TABLES;
DROP TABLE IF EXISTS tb_resposta_usuario;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE tb_resposta_usuario (
  id_resposta bigint(20) NOT NULL,
  email varchar(255) NOT NULL,
  nome varchar(255) NOT NULL,
  resposta text,
  id_pergunta bigint(20) DEFAULT NULL,
  id_quest bigint(20) NOT NULL,
  PRIMARY KEY (id_resposta),
  KEY FK_76r2isr2wgx98g3twmicihmni (id_pergunta),
  KEY FK_5fo3ipu04x0103mg3m25bxa4j (id_quest),
  CONSTRAINT FK_5fo3ipu04x0103mg3m25bxa4j FOREIGN KEY (id_quest) REFERENCES tb_quest (id_quest),
  CONSTRAINT FK_76r2isr2wgx98g3twmicihmni FOREIGN KEY (id_pergunta) REFERENCES tb_pergunta (id_pergunta)
);
/*!40101 SET character_set_client = @saved_cs_client */;

LOCK TABLES tb_resposta_usuario WRITE;
/*!40000 ALTER TABLE tb_resposta_usuario DISABLE KEYS */;
/*!40000 ALTER TABLE tb_resposta_usuario ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

