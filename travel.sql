-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 14, 2021 at 02:12 PM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 7.3.27

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
  `tgl_pb` date NOT NULL,
  `harga` int(100) NOT NULL,
  `des` varchar(50) NOT NULL,
  `jenis_kendaraan` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pembelian`
--

INSERT INTO `pembelian` (`kode_pb`, `kode_tk`, `ktp`, `tgl_pb`, `harga`, `des`, `jenis_kendaraan`) VALUES
('100', '1000020', '14002000830081', '2021-07-02', 400000, 'Pekanbaru', 'Bus'),
('102', '1000022', '140020008409', '2021-07-08', 400000, 'Pekanbaru', 'Pesawat'),
('103', '12222', '1400067895', '2021-07-29', 200000, 'Jakarta', 'Bus');

-- --------------------------------------------------------

--
-- Table structure for table `tiket`
--

CREATE TABLE `tiket` (
  `kode_tk` varchar(20) NOT NULL,
  `supp` varchar(50) NOT NULL,
  `kelas` varchar(50) NOT NULL,
  `harga` int(50) NOT NULL,
  `ket` varchar(100) NOT NULL,
  `des` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tiket`
--

INSERT INTO `tiket` (`kode_tk`, `supp`, `kelas`, `harga`, `ket`, `des`) VALUES
('1000020', 'Makmur', 'Bisinis', 400000, 'Bus Pariwisata', 'Pekanbaru'),
('100092', 'Pesawat', 'Ekonomi', 20000, 'Airplane', 'Jakarta'),
('267789', 'Pesawat', 'Bisnis', 1234567, 'bus', 'Jakarta');

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
