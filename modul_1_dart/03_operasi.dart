// 03_operasi.dart
// Modul 1: Pemrograman Mobile - Bahasa Pemrograman Dart
// Operasi Matematika dan Logika

void main() {
  int hasilTambah = 5 + 3;
  double hasilBagi = 10 / 2;
  int hasilBagiBulat = 10 ~/ 3; // Pembagian bilangan bulat (truncating division)
  bool hasilPerbandingan = 5 > 3;
  bool operasiLogika = (5 > 3) && (10 > 2);

  print('=== Operasi Matematika dan Logika ===');
  print('Hasil Penjumlahan (5 + 3)       : $hasilTambah');
  print('Hasil Pembagian (10 / 2)         : $hasilBagi');
  print('Hasil Pembagian Bulat (10 ~/ 3)  : $hasilBagiBulat');
  print('Hasil Perbandingan (5 > 3)       : $hasilPerbandingan');
  print('Hasil Operasi Logika (AND)       : $operasiLogika');
}
