/*
SQLyog Enterprise - MySQL GUI v7.12 
MySQL - 5.1.41 : Database - perpus
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`perpus` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `perpus`;

/*Table structure for table `buku` */

CREATE TABLE `buku` (
  `id` varchar(5) NOT NULL,
  `judul` varchar(20) DEFAULT NULL,
  `pengarang` varchar(20) DEFAULT NULL,
  `penerbit` varchar(20) DEFAULT NULL,
  `tahun_terbit` int(4) DEFAULT NULL,
  `isbn` varchar(10) DEFAULT NULL,
  `jml_halaman` int(11) DEFAULT '0',
  `hrg_sewa` int(11) DEFAULT '0',
  `status` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Table structure for table `detil_transaksi` */

CREATE TABLE `detil_transaksi` (
  `no_peminjaman` varchar(5) NOT NULL,
  `id_buku` varchar(5) NOT NULL,
  `nilai_sewa` int(11) DEFAULT NULL,
  PRIMARY KEY (`no_peminjaman`,`id_buku`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Table structure for table `member` */

CREATE TABLE `member` (
  `id` varchar(5) NOT NULL,
  `nama` varchar(25) DEFAULT NULL,
  `alamat` varchar(30) DEFAULT NULL,
  `jenis_pengenal` tinyint(1) DEFAULT NULL,
  `no_pengenal` varchar(20) DEFAULT NULL,
  `kontak` varchar(15) DEFAULT NULL,
  `tgl_daftar` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Table structure for table `pegawai` */

CREATE TABLE `pegawai` (
  `username` varchar(10) NOT NULL,
  `nama` varchar(25) NOT NULL,
  `alamat` varchar(30) NOT NULL,
  `kontak` varchar(15) DEFAULT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Table structure for table `transaksi` */

CREATE TABLE `transaksi` (
  `no_peminjaman` varchar(5) NOT NULL,
  `tgl_pinjam` date DEFAULT NULL,
  `tgl_batas` date DEFAULT NULL,
  `tgl_kembali` date DEFAULT NULL,
  `denda` int(11) DEFAULT '0',
  `id_member` varchar(10) DEFAULT NULL,
  `id_pegawai` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`no_peminjaman`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;