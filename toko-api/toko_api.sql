-- Skema Database: toko_api
-- Modul 4 Pemrograman Mobile: Operasi CRUD dengan API CodeIgniter 4

CREATE DATABASE IF NOT EXISTS `toko_api`;
USE `toko_api`;

-- 1. Tabel Member
CREATE TABLE IF NOT EXISTS `member` (
    `id` INT(11) AUTO_INCREMENT PRIMARY KEY,
    `nama` VARCHAR(255) NOT NULL,
    `email` VARCHAR(255) NOT NULL,
    `password` VARCHAR(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 2. Tabel Member Token
CREATE TABLE IF NOT EXISTS `member_token` (
    `id` INT(11) AUTO_INCREMENT PRIMARY KEY,
    `member_id` INT(11) NOT NULL,
    `auth_key` VARCHAR(255) NOT NULL,
    INDEX (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 3. Tabel Produk
CREATE TABLE IF NOT EXISTS `produk` (
    `id` INT(11) AUTO_INCREMENT PRIMARY KEY,
    `kode_produk` VARCHAR(50) NOT NULL,
    `nama_produk` VARCHAR(255) NOT NULL,
    `harga` INT(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dummy Data Awal
INSERT INTO `member` (`id`, `nama`, `email`, `password`) VALUES
(1, 'Administrator', 'admin@admin.com', '$2y$10$wT1r5WJkKjRkmwS04359yOGh0/pP6Zc3mP1B3lQkO39g9f6Z.gPuy');

INSERT INTO `produk` (`id`, `kode_produk`, `nama_produk`, `harga`) VALUES
(1, 'A001', 'Kamera DSLR Canon', 5000000),
(2, 'A002', 'Laptop ASUS ROG', 15000000),
(3, 'A003', 'Headset Wireless Sony', 2000000);
