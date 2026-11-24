// 09_async_await.dart
// Modul 1: Pemrograman Mobile - Bahasa Pemrograman Dart
// Pemrograman Asinkronus (Async, Await, dan Future)

Future<void> prosesData() async {
  print('Sedang memproses data di latar belakang...');
  await Future.delayed(Duration(seconds: 2));
  print('Data berhasil diproses!');
}

Future<String> ambilDataUser() async {
  await Future.delayed(Duration(seconds: 1));
  return 'User ID: 12345 - Surung Nicholas';
}

Future<void> main() async {
  print('=== Pemrograman Asinkronus (Async & Await) ===');
  print('Memulai pemrosesan...');

  await prosesData();

  String userInfo = await ambilDataUser();
  print('Hasil pengambilan user: $userInfo');

  print('Pemrosesan selesai.');
}
