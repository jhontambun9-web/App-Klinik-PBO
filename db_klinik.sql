-- Membuat database
CREATE DATABASE IF NOT EXISTS db_klinik;
USE db_klinik;

-- Tabel Users
CREATE TABLE IF NOT EXISTS users (
    id_user INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    level VARCHAR(20) DEFAULT 'admin'
);

-- Tabel Pasien
CREATE TABLE IF NOT EXISTS pasien (
    id_pasien INT AUTO_INCREMENT PRIMARY KEY,
    nama_pasien VARCHAR(100) NOT NULL,
    jenis_kelamin VARCHAR(20),
    tgl_lahir DATE,
    alamat VARCHAR(200),
    no_telp VARCHAR(20),
    keluhan VARCHAR(200)
);

-- Tabel Dokter
CREATE TABLE IF NOT EXISTS dokter (
    id_dokter INT AUTO_INCREMENT PRIMARY KEY,
    nama_dokter VARCHAR(100) NOT NULL,
    spesialis VARCHAR(50),
    no_telp VARCHAR(20),
    alamat VARCHAR(200)
);

-- Tabel Perawat
CREATE TABLE IF NOT EXISTS perawat (
    id_perawat INT AUTO_INCREMENT PRIMARY KEY,
    nama_perawat VARCHAR(100) NOT NULL,
    jenis_kelamin VARCHAR(20),
    no_telp VARCHAR(20),
    alamat VARCHAR(200)
);

-- Data Dummy
INSERT INTO users (username, password, level) VALUES ('admin', 'admin123', 'admin');

INSERT INTO pasien (nama_pasien, jenis_kelamin, tgl_lahir, alamat, no_telp, keluhan) VALUES 
('Budi Santoso', 'Laki-laki', '1990-05-12', 'Jl. Merdeka No 1', '08123456789', 'Flu Berat'),
('Siti Aminah', 'Perempuan', '1995-08-20', 'Jl. Sudirman No 5', '08577788899', 'Sakit Kepala');

INSERT INTO dokter (nama_dokter, spesialis, no_telp, alamat) VALUES 
('dr. Andi Pratama', 'Umum', '081122334455', 'Jl. Kesehatan No 10'),
('dr. Sarah Wijaya', 'Gigi', '081199887766', 'Jl. Mawar No 2');

INSERT INTO perawat (nama_perawat, jenis_kelamin, no_telp, alamat) VALUES 
('Rina Susanti', 'Perempuan', '082233445566', 'Jl. Melati No 3'),
('Joko Widodo', 'Laki-laki', '082266554433', 'Jl. Anggrek No 8');
