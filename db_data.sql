-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 27, 2022 at 09:58 AM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_kita`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_donatur`
--

CREATE TABLE `tb_donatur` (
  `id_donatur` int(11) NOT NULL,
  `nama_donatur` varchar(40) NOT NULL,
  `profesi_donatur` varchar(20) DEFAULT '-',
  `telp_donatur` varchar(15) DEFAULT '-',
  `alamat_donatur` varchar(150) DEFAULT '-'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `tb_rekap`
--

CREATE TABLE `tb_rekap` (
  `id_rekap` int(11) NOT NULL,
  `tgl_rekap` date NOT NULL,
  `id_donatur` int(11) NOT NULL,
  `jenis_transaksi` varchar(10) NOT NULL,
  `nama_bank` varchar(30) DEFAULT '-',
  `id_relawan` int(11) NOT NULL,
  `jumlah_donasi` int(15) NOT NULL,
  `kegiatan` varchar(150) NOT NULL,
  `keterangan` varchar(300) DEFAULT '-'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `tb_relawan`
--

CREATE TABLE `tb_relawan` (
  `id_relawan` int(11) NOT NULL,
  `nama_relawan` varchar(40) NOT NULL,
  `telp_relawan` varchar(15) DEFAULT '-',
  `alamat_relawan` varchar(150) DEFAULT '-'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_donatur`
--
ALTER TABLE `tb_donatur`
  ADD PRIMARY KEY (`id_donatur`),
  ADD UNIQUE KEY `unik_namatelpdonatur` (`nama_donatur`,`telp_donatur`);

--
-- Indexes for table `tb_rekap`
--
ALTER TABLE `tb_rekap`
  ADD PRIMARY KEY (`id_rekap`),
  ADD KEY `id_donatur` (`id_donatur`),
  ADD KEY `id_relawan` (`id_relawan`);

--
-- Indexes for table `tb_relawan`
--
ALTER TABLE `tb_relawan`
  ADD PRIMARY KEY (`id_relawan`),
  ADD UNIQUE KEY `unik_namatelprelawan` (`nama_relawan`,`telp_relawan`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_donatur`
--
ALTER TABLE `tb_donatur`
  MODIFY `id_donatur` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tb_rekap`
--
ALTER TABLE `tb_rekap`
  MODIFY `id_rekap` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tb_relawan`
--
ALTER TABLE `tb_relawan`
  MODIFY `id_relawan` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tb_rekap`
--
ALTER TABLE `tb_rekap`
  ADD CONSTRAINT `tb_rekap_ibfk_1` FOREIGN KEY (`id_donatur`) REFERENCES `tb_donatur` (`id_donatur`),
  ADD CONSTRAINT `tb_rekap_ibfk_2` FOREIGN KEY (`id_relawan`) REFERENCES `tb_relawan` (`id_relawan`),
  ADD CONSTRAINT `tb_rekap_ibfk_3` FOREIGN KEY (`id_relawan`) REFERENCES `tb_relawan` (`id_relawan`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
