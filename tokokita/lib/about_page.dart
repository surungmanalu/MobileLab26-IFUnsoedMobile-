import 'package:flutter/material.dart';
import 'package:tokokita/sidemenu.dart';

class AboutPage extends StatelessWidget {
  const AboutPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('About Page'),
      ),
      body: const Center(
        child: Text('Ini adalah halaman About'),
      ),
      drawer: const Sidemenu(),
    );
  }
}
