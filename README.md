# Info Gempa BMKG - Katalog & Monitoring Gempa Bumi
> **Paket 1 - Responsi Mobile Programming I**  
> Aplikasi Android berbasis **Jetpack Compose** untuk memantau data gempa terkini di seluruh Indonesia secara dinamis langsung dari server resmi BMKG.

---

## 📱 Tangkapan Layar (Screenshots)

| 1. Home Screen (Katalog & Pencarian) | 2. Detail Screen (Parameter Lengkap) |
| :---: | :---: |
| *(Letakkan screenshot Home Screen di sini)* | *(Letakkan screenshot Detail Screen di sini)* |
| `docs/screenshots/home_screen.png` | `docs/screenshots/detail_screen.png` |

---

## 🌟 Fitur Utama

1. **Pemantauan Gempa Real-time (M ≥ 5.0)**:
   - Mengambil data gempa bumi terkini secara dinamis dari REST API resmi BMKG tanpa memerlukan API Key.
2. **Pencarian & Filter Lokal Instan**:
   - Fitur pencarian cepat berdasarkan wilayah (*Search by Wilayah*) yang menyaring data secara lokal (*real-time reactive search*).
3. **Pemberitahuan Status Potensi Tsunami**:
   - Deteksi visual jelas dengan penandaan warna khusus (*alert color*) apakah gempa berpotensi tsunami atau tidak.
4. **Indikator Visual Kekuatan Gempa (Magnitudo)**:
   - Warna lencana magnitudo dinamis: Hijau (< 5.0 SR), Oranye (5.0 - 5.9 SR), dan Merah (≥ 6.0 SR).
5. **Dukungan Tema Gelap & Terang (Material Design 3)**:
   - Mengikuti preferensi tema sistem Android dengan palet warna kebencanaan BMKG yang elegan dan kontras tinggi.
6. **State-Driven UI & Penanganan Error**:
   - Menampilkan *Loading State*, *Error State* dengan tombol coba lagi (*Retry*), dan *Empty State* ketika kata kunci pencarian tidak ditemukan.

---

## 🏗️ Pola Arsitektur (MVVM)

Aplikasi dibangun sepenuhnya mengikuti prinsip **Clean Architecture & MVVM (Model-View-ViewModel)** dengan aliran data satu arah (*Unidirectional Data Flow*):

```
┌─────────────────────────────────────────────────────────────┐
│                       REST API BMKG                         │
│       https://data.bmkg.go.id/DataMKG/TEWS/gempaterkini.json │
└──────────────────────────────┬──────────────────────────────┘
                               │ (Retrofit + Gson Converter)
                               ▼
┌─────────────────────────────────────────────────────────────┐
│                      DATA LAYER                             │
│  - BmkgApiService (Retrofit Interface)                      │
│  - RetrofitClient (Singleton Instance)                      │
│  - GempaModel (Data classes & Extension Functions)          │
│  - GempaRepository (Abstraksi & Exception Handling)         │
└──────────────────────────────┬──────────────────────────────┘
                               │ Result<List<GempaItem>>
                               ▼
┌─────────────────────────────────────────────────────────────┐
│                    VIEWMODEL LAYER                          │
│  - GempaViewModel                                           │
│  - StateFlow<GempaUiState> (Loading, Success, Error)        │
│  - StateFlow<String> (Search Query & Real-time Filter)      │
└──────────────────────────────┬──────────────────────────────┘
                               │ StateFlow (Pola P5)
                               ▼
┌─────────────────────────────────────────────────────────────┐
│                     UI / VIEW LAYER                         │
│  - Jetpack Compose Layouts                                  │
│  - Scaffold + TopAppBar (Material 3)                        │
│  - HomeScreen (LazyColumn & SearchBar)                      │
│  - DetailScreen (Parameter Lengkap & Tombol Kembali)        │
│  - Navigation Compose (GempaNavGraph)                       │
└─────────────────────────────────────────────────────────────┘
```

### State UI (`GempaUiState` - Pola P5)
```kotlin
sealed interface GempaUiState {
    data object Loading : GempaUiState
    data class Success(val gempaList: List<GempaItem>) : GempaUiState
    data class Error(val message: String) : GempaUiState
}
```

---

## 🌐 Endpoint API

* **Penyedia Data**: Badan Meteorologi, Klimatologi, dan Geofisika (BMKG)
* **Base URL**: `https://data.bmkg.go.id/`
* **Endpoint**: `/DataMKG/TEWS/gempaterkini.json`
* **Full URL**: `https://data.bmkg.go.id/DataMKG/TEWS/gempaterkini.json`
* **Struktur Data JSON**:
  ```json
  {
    "Infogempa": {
      "gempa": [
        {
          "Tanggal": "...",
          "Jam": "...",
          "Coordinates": "...",
          "Magnitude": "...",
          "Kedalaman": "...",
          "Wilayah": "...",
          "Potensi": "..."
        }
      ]
    }
  }
  ```

---

## 🛠️ Rincian Teknis & Dependensi

* **Bahasa**: Kotlin (memanfaatkan *Data Class*, *Null-safety*, *Lambda expressions*, dan *Extension functions*).
* **UI Toolkit**: Android Jetpack Compose dengan Material Design 3.
* **List Component**: Menggunakan `LazyColumn` (tanpa RecyclerView XML atau komponen lain).
* **Networking**:
  - `com.squareup.retrofit2:retrofit:2.11.0`
  - `com.squareup.retrofit2:converter-gson:2.11.0`
* **Navigasi & Lifecycle**:
  - `androidx.navigation:navigation-compose:2.8.8`
  - `androidx.lifecycle:lifecycle-viewmodel-compose`
* **Kepatuhan Aturan**:
  - Bebas dari library gambar pihak ketiga (tidak ada Coil/Glide/Picasso).
  - Tidak memanggil API langsung dari fungsi Composable (wajib lewat ViewModel & Repository).
  - Maksimal 2 layar yang terhubung via `NavHost`.

---

## 🚀 Cara Menjalankan & Membangun (Build)

### 1. Prasyarat
- Android Studio Ladybug / Meerkat / terbaru
- JDK 17 / 21 / 25
- Android SDK Platform 34-37

### 2. Menjalankan di Emulator / Device
```bash
./gradlew installDebug
```

### 3. Membangun APK Debug
```bash
./gradlew assembleDebug
```
Output berkas APK dapat ditemukan pada direktori:
`app/build/outputs/apk/debug/app-debug.apk`
