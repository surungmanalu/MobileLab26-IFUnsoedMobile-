package com.example.infogempabmkg.ui

import com.example.infogempabmkg.data.model.GempaItem

/**
 * Representasi State UI untuk mematuhi pola arsitektur MVVM (P5 StateFlow)
 */
sealed interface GempaUiState {
    data object Loading : GempaUiState
    data class Success(val gempaList: List<GempaItem>) : GempaUiState
    data class Error(val message: String) : GempaUiState
}
