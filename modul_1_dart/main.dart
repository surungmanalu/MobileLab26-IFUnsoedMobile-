// main.dart
// Modul 1: Pemrograman Mobile - Bahasa Pemrograman Dart
// Entrypoint ringkas yang mendemonstrasikan seluruh materi pokok Modul 1

import 'dart:math';

// 1. Model OOP
class Mahasiswa {
  String nama;
  int usia;

  Mahasiswa(this.nama, this.usia);

  void perkenalan() {
    print('Halo, saya $nama dan saya berusia $usia tahun.');
  }
}

// 2. Fungsi
int hitungTambah(int a, int b) => a + b;

// 3. Asinkronus
Future<void> jalankanAsync() async {
  print('[Async] Menunggu proses simulasi jaringan...');
  await Future.delayed(Duration(seconds: 1));
  print('[Async] Selesai.');
}

Future<void> main() async {
  print('==================================================');
  print('      MODUL 1: BAHASA PEMROGRAMAN DART            ');
  print('==================================================\n');

  // A. Tipe Data
  int angka = 10;
  double desimal = 3.14;
  String teks = "Halo, dunia!";
  bool benar = true;
  print('1. Tipe Data: int=$angka, double=$desimal, String="$teks", bool=$benar');

  // B. Operasi Matematika & Logika
  int hasilTambah = 5 + 3;
  double hasilBagi = 10 / 2;
  bool hasilPerbandingan = 5 > 3;
  print('2. Operasi: 5+3=$hasilTambah, 10/2=$hasilBagi, (5>3)=$hasilPerbandingan');

  // C. Struktur Kontrol
  print('3. Struktur Kontrol:');
  if (angka > 5) {
    print('   -> Angka ($angka) lebih besar dari 5');
  } else {
    print('   -> Angka tidak lebih besar dari 5');
  }

  stdoutLoop:
  for (int i = 0; i < 3; i++) {
    print('   -> Loop for: iterasi ke-$i');
  }

  // D. Fungsi
  print('4. Fungsi: hasil tambah(3, 7) = ${hitungTambah(3, 7)}');

  // E. OOP
  print('5. OOP:');
  Mahasiswa mhs = Mahasiswa("Alice", 22);
  mhs.perkenalan();

  // F. Import Library
  print('6. Import Library (dart:math):');
  print('   -> Random (0-9): ${Random().nextInt(10)}');

  // G. Exception Handling
  print('7. Exception Handling:');
  try {
    int _ = 5 ~/ 0;
  } on UnsupportedError {
    print('   -> UnsupportedError tertangkap dengan aman.');
  } catch (e) {
    print('   -> Error: $e');
  }

  // H. Async Await
  print('8. Asinkronus:');
  await jalankanAsync();

  print('\n=== Modul 1 Selesai Dijalankan Tanpa Error ===');
}
