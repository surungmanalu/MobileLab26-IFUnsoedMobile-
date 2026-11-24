// 05_fungsi.dart
// Modul 1: Pemrograman Mobile - Bahasa Pemrograman Dart
// Fungsi dan Modularitas Kode

int tambah(int a, int b) {
  return a + b;
}

int kali(int a, int b) => a * b; // Arrow syntax function

void main() {
  int hasil1 = tambah(3, 7);
  int hasil2 = kali(4, 5);

  print('=== Fungsi pada Dart ===');
  print('Hasil penjumlahan: $hasil1');
  print('Hasil perkalian (arrow syntax): $hasil2');
}
