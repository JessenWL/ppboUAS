-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 14, 2021 at 03:52 PM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 8.0.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `travel`
--

-- --------------------------------------------------------

--
-- Table structure for table `pelanggan`
--

CREATE TABLE `pelanggan` (
  `ktp` varchar(25) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `umur` varchar(50) NOT NULL,
  `jk` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pelanggan`
--

INSERT INTO `pelanggan` (`ktp`, `nama`, `alamat`, `umur`, `jk`) VALUES
('', '123', 'asd', '12', 'Laki - laki'),
('14002000830081', 'Zahwa Ainnayya Abdullah', 'Jln.selamat', '19 Tahun', 'Perempuan'),
('18888892', 'Suga', 'Korea', '28', 'Laki - laki');

-- --------------------------------------------------------

--
-- Table structure for table `pembelian`
--

CREATE TABLE `pembelian` (
  `kode_pb` varchar(25) NOT NULL,
  `kode_tk` varchar(25) NOT NULL,
  `ktp` varchar(25) NOT NULL,
  `harga` int(100) NOT NULL,
  `des` varchar(50) NOT NULL,
  `tgl_pb` date NOT NULL,
  `jenis_kendaraan` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pembelian`
--

INSERT INTO `pembelian` (`kode_pb`, `kode_tk`, `ktp`, `harga`, `des`, `tgl_pb`, `jenis_kendaraan`) VALUES
('100', '0001', '1000990', 50000, 'FKS', '2021-07-19', 'Kapal');

-- --------------------------------------------------------

--
-- Table structure for table `tiket`
--

CREATE TABLE `tiket` (
  `kode_tk` varchar(20) NOT NULL,
  `kelas` varchar(50) NOT NULL,
  `harga` int(50) NOT NULL,
  `des` varchar(50) NOT NULL,
  `supp` varchar(100) NOT NULL,
  `jns` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tiket`
--

INSERT INTO `tiket` (`kode_tk`, `kelas`, `harga`, `des`, `supp`, `jns`) VALUES
('1000020', 'Bisinis', 400000, 'Pekanbaru', 'Bus Pariwisata', 'Makmur'),
('100092', 'Ekonomi', 20000, 'Jakarta', 'Airplane', 'Pesawat'),
('267789', 'Bisnis', 1234567, 'Jakarta', 'Lion', 'Pesawat');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`ktp`);

--
-- Indexes for table `tiket`
--
ALTER TABLE `tiket`
  ADD PRIMARY KEY (`kode_tk`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
