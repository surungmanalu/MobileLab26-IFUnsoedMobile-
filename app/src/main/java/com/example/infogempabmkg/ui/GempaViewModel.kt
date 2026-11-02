package com.example.infogempabmkg.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.infogempabmkg.data.model.GempaItem
import com.example.infogempabmkg.data.repository.GempaRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class GempaViewModel(
    private val repository: GempaRepository = GempaRepository()
) : ViewModel() {

    private val _uiState = MutableStateFlow<GempaUiState>(GempaUiState.Loading)
    val uiState: StateFlow<GempaUiState> = _uiState.asStateFlow()

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    // Cache daftar gempa lengkap dari API untuk penyaringan lokal (Search by Wilayah)
    private var allGempaList: List<GempaItem> = emptyList()

    init {
        loadGempaData()
    }

    /**
     * Memuat data gempa dari API BMKG melalui Repository
     */
    fun loadGempaData() {
        viewModelScope.launch {
            _uiState.value = GempaUiState.Loading
            val result = repository.getGempaTerkini()
            result.onSuccess { list ->
                allGempaList = list
                applyLocalFilter()
            }.onFailure { throwable ->
                _uiState.value = GempaUiState.Error(
                    throwable.localizedMessage ?: "Gagal terhubung ke server BMKG. Periksa koneksi internet Anda."
                )
            }
        }
    }

    /**
     * Menangani perubahan query pencarian dan memfilter data secara lokal berdasarkan Wilayah
     */
    fun onSearchQueryChange(query: String) {
        _searchQuery.value = query
        applyLocalFilter()
    }

    private fun applyLocalFilter() {
        val query = _searchQuery.value.trim()
        val filtered = if (query.isEmpty()) {
            allGempaList
        } else {
            allGempaList.filter { it.wilayah.contains(query, ignoreCase = true) }
        }
        _uiState.value = GempaUiState.Success(gempaList = filtered)
    }

    /**
     * Mengambil item gempa tertentu berdasarkan uniqueId untuk Detail Screen
     */
    fun getGempaById(uniqueId: String): GempaItem? {
        return allGempaList.find { it.uniqueId == uniqueId }
    }
}
