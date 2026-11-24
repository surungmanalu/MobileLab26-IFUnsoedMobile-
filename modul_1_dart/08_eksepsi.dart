// 08_eksepsi.dart
// Modul 1: Pemrograman Mobile - Bahasa Pemrograman Dart
// Penanganan Kesalahan (Exception Handling) dengan try, on, catch, finally

void main() {
  print('=== Penanganan Eksepsi (Exception Handling) ===');

  // Contoh 1: Menangani jenis eksepsi spesifik (UnsupportedError / IntegerDivisionByZero)
  try {
    int a = 5 ~/ 0;
    print(a);
  } on UnsupportedError {
    print('Operasi tidak didukung (UnsupportedError)');
  }

  // Contoh 2: Menangani error umum dengan objek catch (e)
  try {
    int a = 5 ~/ 0;
    print(a);
  } catch (e) {
    print('Error tertangkap: $e');
  } finally {
    print('Blok finally selalu dijalankan.');
  }
}
