// 06_kelas_dan_objek.dart
// Modul 1: Pemrograman Mobile - Bahasa Pemrograman Dart
// Pemrograman Berorientasi Objek (OOP): Kelas, Atribut, Konstruktor, dan Metode

class Mahasiswa {
  String nama;
  int usia;
  String? jurusan;

  // Constructor
  Mahasiswa(this.nama, this.usia, [this.jurusan]);

  // Method
  void perkenalan() {
    if (jurusan != null) {
      print('Halo, saya $nama, berusia $usia tahun dari jurusan $jurusan.');
    } else {
      print('Halo, saya $nama dan saya berusia $usia tahun.');
    }
  }
}

void main() {
  print('=== Pemrograman Berorientasi Objek (OOP) ===');
  Mahasiswa mhs1 = Mahasiswa("Alice", 22);
  mhs1.perkenalan();

  Mahasiswa mhs2 = Mahasiswa("Nicholas", 20, "Informatika");
  mhs2.perkenalan();
}
