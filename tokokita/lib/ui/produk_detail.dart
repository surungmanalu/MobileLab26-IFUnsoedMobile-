import 'package:flutter/material.dart';

class ProdukDetail extends StatelessWidget {
  final String? kodeProduk;
  final String? namaProduk;
  final int? hargaProduk;

  const ProdukDetail({
    super.key,
    this.kodeProduk,
    this.namaProduk,
    this.hargaProduk,
  });

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Detail Produk"),
      ),
      body: Container(
        margin: const EdgeInsets.all(10),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Text("Kode Produk : ${kodeProduk ?? ''}"),
            const SizedBox(height: 8),
            Text("Nama Produk : ${namaProduk ?? ''}"),
            const SizedBox(height: 8),
            Text("Harga Produk : ${hargaProduk ?? 0}"),
          ],
        ),
      ),
    );
  }
}
