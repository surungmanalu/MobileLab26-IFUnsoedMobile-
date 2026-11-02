package com.example.infogempabmkg.data.network

import com.example.infogempabmkg.data.model.GempaResponse
import retrofit2.http.GET

interface BmkgApiService {
    @GET("DataMKG/TEWS/gempaterkini.json")
    suspend fun getGempaTerkini(): GempaResponse
}
