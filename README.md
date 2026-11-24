# Praktikum Pemrograman Mobile (Flutter)

Repositori ini pada branch `flutter` berisi implementasi seluruh modul praktikum Pemrograman Mobile (Modul 1 hingga Modul 5) Laboratorium Informatika Universitas Jenderal Soedirman.

---

## Ringkasan Pengerjaan Modul 1 – 5

### 1. Modul 1: Bahasa Pemrograman Dart
- **Fokus**: Fondasi bahasa pemrograman Dart.
- **Implementasi**: Penulisan program dasar Dart yang mencakup tipe data dasar, operasi matematika/logika, struktur kontrol (`if-else`, perulangan `for`/`while`), fungsi, OOP (kelas, objek, atribut, konstruktor, dan method), library bawaan (`dart:math`), penanganan kesalahan (*exception handling* dengan `try-catch`), serta pemrograman asinkronus (`Future`, `async`, dan `await`).
- **Lokasi Berkas**: Folder [`modul_1_dart/`](modul_1_dart/)

### 2. Modul 2: Pengenalan dan Desain Framework Flutter
- **Fokus**: Inisialisasi framework Flutter dan penyusunan komponen UI dasar.
- **Implementasi**: Pembuatan project Flutter **`tokokita`**, penerapan `StatelessWidget` dan `StatefulWidget`, layouting widget (`Center`, `Column`, `Row`), pembuatan form input produk (`produk_form.dart`), detail produk (`produk_detail.dart`), serta penyusunan katalog list produk menggunakan `ListView` dan `Card` (`produk_page.dart`).
- **Lokasi Berkas**: Folder [`tokokita/`](tokokita/)

### 3. Modul 3: Routes, Login, dan Local Storage
- **Fokus**: Sistem navigasi halaman, autentikasi form, dan penyimpanan sesi lokal.
- **Implementasi**: Penambahan dependency `shared_preferences`, pembuatan halaman login dengan validasi input, penyimpanan dan pengambilan username dari penyimpanan lokal (*local storage*), navigasi rute (`Navigator.push` / `pushReplacement`), serta pembuatan menu navigasi samping (`Drawer`) yang memuat tautan ke Halaman Home, About, dan fungsi Logout.
- **Lokasi Berkas**: Folder [`tokokita/`](tokokita/)

### 4. Modul 4: Operasi CRUD dengan API CodeIgniter 4 (Bagian 1)
- **Fokus**: Pembangunan backend RESTful API dan penyiapan struktur model/UI di Flutter.
- **Implementasi**:
  - **Backend**: Pembuatan RESTful API dengan framework PHP CodeIgniter 4 dan database MySQL `toko_api` (tabel `member`, `member_token`, dan `produk`), controller registrasi, login dengan token acak (*auth key*), serta CRUD produk.
  - **Frontend**: Pembuatan model data (`login.dart`, `registrasi.dart`, `produk.dart`) dengan deserialisasi JSON serta pemisahan arsitektur antarmuka pengguna di folder `ui/`.
- **Lokasi Berkas**: Folder [`toko-api/`](toko-api/) dan [`tokokita/`](tokokita/)

### 5. Modul 5: Operasi CRUD dengan API CodeIgniter 4 (Bagian 2)
- **Fokus**: Integrasi penuh frontend Flutter dengan backend RESTful API berbasis arsitektur BLoC.
- **Implementasi**:
  - Pembuatan layer helper: `user_info.dart` (manajemen token & user ID), `api_url.dart` (katalog endpoint API), `app_exception.dart` (penanganan error HTTP), dan `api.dart` (HTTP client method GET, POST, PUT, DELETE dengan header token Bearer).
  - Pembuatan Business Logic Component: `RegistrasiBloc`, `LoginBloc`, `LogoutBloc`, dan `ProdukBloc`.
  - Pembuatan widget dialog terpadu: `SuccessDialog` dan `WarningDialog`.
  - Integrasi UI: Registrasi user baru, login ke sistem, list produk dinamis via `FutureBuilder`, penambahan produk baru, pengubahan data produk, dan penghapusan produk dengan dialog konfirmasi.
- **Lokasi Berkas**: Folder [`tokokita/`](tokokita/)
