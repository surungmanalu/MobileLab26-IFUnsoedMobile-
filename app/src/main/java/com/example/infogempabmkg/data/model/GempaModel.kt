package com.example.infogempabmkg.data.model

import com.google.gson.annotations.SerializedName

data class GempaResponse(
    @SerializedName("Infogempa")
    val infoGempa: InfoGempaData
)

data class InfoGempaData(
    @SerializedName("gempa")
    val gempaList: List<GempaItem>
)

data class GempaItem(
    @SerializedName("Tanggal")
    val tanggal: String = "",

    @SerializedName("Jam")
    val jam: String = "",

    @SerializedName("DateTime")
    val dateTime: String = "",

    @SerializedName("Coordinates")
    val coordinates: String = "",

    @SerializedName("Lintang")
    val lintang: String = "",

    @SerializedName("Bujur")
    val bujur: String = "",

    @SerializedName("Magnitude")
    val magnitude: String = "",

    @SerializedName("Kedalaman")
    val kedalaman: String = "",

    @SerializedName("Wilayah")
    val wilayah: String = "",

    @SerializedName("Potensi")
    val potensi: String = ""
) {
    /**
     * ID unik yang dihasilkan dari kombinasi tanggal-jam dan koordinat
     */
    val uniqueId: String
        get() = "${dateTime.ifEmpty { tanggal + jam }}_$coordinates"
            .replace(" ", "_")
            .replace(":", "-")
            .replace(",", "_")
}

// Extension function untuk format & indikasi tingkat keparahan gempa
fun GempaItem.getMagnitudeDouble(): Double {
    return this.magnitude.toDoubleOrNull() ?: 0.0
}

fun GempaItem.isPotentialTsunami(): Boolean {
    return !this.potensi.contains("tidak berpotensi", ignoreCase = true)
}
