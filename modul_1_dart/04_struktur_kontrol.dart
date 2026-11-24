// 04_struktur_kontrol.dart
// Modul 1: Pemrograman Mobile - Bahasa Pemrograman Dart
// Struktur Kontrol: Percabangan (if-else) dan Perulangan (for, while)

void main() {
  int angka = 4;

  print('=== Struktur Kontrol: Percabangan ===');
  if (angka > 5) {
    print('Angka lebih besar dari 5');
  } else {
    print('Angka tidak lebih besar dari 5');
  }

  print('\n=== Struktur Kontrol: Perulangan (for) ===');
  for (int i = 0; i < 5; i++) {
    print('Iterasi ke-$i');
  }

  print('\n=== Struktur Kontrol: Perulangan (while) ===');
  while (angka > 0) {
    print('Nilai angka: $angka');
    angka--;
  }
}
