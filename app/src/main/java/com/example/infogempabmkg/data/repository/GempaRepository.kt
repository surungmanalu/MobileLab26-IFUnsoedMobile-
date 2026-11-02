package com.example.infogempabmkg.data.repository

import com.example.infogempabmkg.data.model.GempaItem
import com.example.infogempabmkg.data.network.BmkgApiService
import com.example.infogempabmkg.data.network.RetrofitClient

class GempaRepository(
    private val apiService: BmkgApiService = RetrofitClient.apiService
) {
    /**
     * Mengambil daftar gempa terkini dari API BMKG.
     * Mengembalikan Result berisi List<GempaItem> atau Exception bila gagal.
     */
    suspend fun getGempaTerkini(): Result<List<GempaItem>> {
        return try {
            val response = apiService.getGempaTerkini()
            val gempaList = response.infoGempa.gempaList
            Result.success(gempaList)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
