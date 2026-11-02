package com.example.infogempabmkg.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.infogempabmkg.data.model.GempaItem
import com.example.infogempabmkg.ui.GempaUiState
import com.example.infogempabmkg.ui.components.EmptyView
import com.example.infogempabmkg.ui.components.ErrorView
import com.example.infogempabmkg.ui.components.GempaCard
import com.example.infogempabmkg.ui.components.LoadingView

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    uiState: GempaUiState,
    searchQuery: String,
    onSearchQueryChange: (String) -> Unit,
    onGempaClick: (GempaItem) -> Unit,
    onRetry: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = "Info Gempa BMKG",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Katalog Gempa Terkini M ≥ 5.0",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.8f)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // Search Bar untuk filter lokal wilayah
            OutlinedTextField(
                value = searchQuery,
                onValueChange = onSearchQueryChange,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 12.dp),
                placeholder = {
                    Text(text = "Cari berdasarkan wilayah (misal: Jawa, Papua)...")
                },
                singleLine = true,
                shape = RoundedCornerShape(12.dp),
                trailingIcon = {
                    if (searchQuery.isNotEmpty()) {
                        TextButton(onClick = { onSearchQueryChange("") }) {
                            Text("Hapus", style = MaterialTheme.typography.labelSmall)
                        }
                    }
                }
            )

            // State Handling: Loading, Error, Success
            when (uiState) {
                is GempaUiState.Loading -> {
                    LoadingView()
                }

                is GempaUiState.Error -> {
                    ErrorView(
                        message = uiState.message,
                        onRetry = onRetry
                    )
                }

                is GempaUiState.Success -> {
                    val gempaList = uiState.gempaList
                    if (gempaList.isEmpty()) {
                        EmptyView(
                            message = if (searchQuery.isNotEmpty()) {
                                "Tidak ada gempa ditemukan untuk wilayah \"$searchQuery\""
                            } else {
                                "Belum ada data gempa tersedia"
                            }
                        )
                    } else {
                        // Menampilkan kumpulan gempa HANYA menggunakan LazyColumn
                        LazyColumn(
                            modifier = Modifier.fillMaxSize(),
                            contentPadding = PaddingValues(
                                start = 16.dp,
                                end = 16.dp,
                                top = 4.dp,
                                bottom = 20.dp
                            ),
                            verticalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            items(
                                items = gempaList,
                                key = { it.uniqueId }
                            ) { gempa ->
                                GempaCard(
                                    gempa = gempa,
                                    onClick = { onGempaClick(gempa) }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@androidx.compose.ui.tooling.preview.Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    com.example.infogempabmkg.ui.theme.InfoGempaBMKGTheme {
        HomeScreen(
            uiState = GempaUiState.Success(
                gempaList = listOf(
                    GempaItem(
                        tanggal = "06 Okt 2026",
                        jam = "18:20:00 WIB",
                        coordinates = "-8.33,120.59",
                        magnitude = "5.3",
                        kedalaman = "10 km",
                        wilayah = "34 km TimurLaut RUTENG-MANGGARAI-NTT",
                        potensi = "Tidak berpotensi tsunami"
                    ),
                    GempaItem(
                        tanggal = "05 Okt 2026",
                        jam = "10:15:22 WIB",
                        coordinates = "2.52,128.09",
                        magnitude = "6.2",
                        kedalaman = "145 km",
                        wilayah = "42 km TimurLaut PULAUDOI-MALUT",
                        potensi = "Tidak berpotensi tsunami"
                    )
                )
            ),
            searchQuery = "",
            onSearchQueryChange = {},
            onGempaClick = {},
            onRetry = {}
        )
    }
}
