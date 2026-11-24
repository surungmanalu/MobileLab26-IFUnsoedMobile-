// 07_import_library.dart
// Modul 1: Pemrograman Mobile - Bahasa Pemrograman Dart
// Penggunaan Library Eksternal / Bawaan (dart:math)

import 'dart:math';

void main() {
  print('=== Import Library (dart:math) ===');
  int acak = Random().nextInt(10);
  print('Angka acak (0-9): $acak');

  double akar = sqrt(64);
  print('Akar kuadrat dari 64: $akar');

  double pangkat = pow(2, 5).toDouble();
  print('2 pangkat 5: $pangkat');
}
