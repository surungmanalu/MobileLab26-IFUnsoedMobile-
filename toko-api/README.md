# Backend Toko API (CodeIgniter 4 RESTful API)

Backend RESTful API untuk aplikasi mobile Flutter `tokokita`, sesuai dengan materi **Modul 4 & Modul 5 Pemrograman Mobile**.

## Persiapan Basis Data (MySQL)
1. Buka XAMPP Control Panel dan jalankan service **Apache** dan **MySQL**.
2. Masuk ke phpMyAdmin (`http://localhost/phpmyadmin`).
3. Buat database baru bernama `toko_api` dan impor berkas [toko_api.sql](toko_api.sql).

## Daftar Endpoint API
- **Registrasi**: `POST /registrasi`
  - Body (JSON): `{"nama": "...", "email": "...", "password": "..."}`
- **Login**: `POST /login`
  - Body (JSON): `{"email": "...", "password": "..."}`
- **List Produk**: `GET /produk`
- **Detail Produk**: `GET /produk/{id}`
- **Tambah Produk**: `POST /produk`
  - Body (JSON): `{"kode_produk": "...", "nama_produk": "...", "harga": 10000}`
- **Ubah Produk**: `PUT /produk/{id}`
- **Hapus Produk**: `DELETE /produk/{id}`
