package com.example.util

import android.os.Build

data class DeviceInfo(
    val manufacturer: String,
    val model: String,
    val androidVersion: String,
    val apiLevel: Int,
    val isAndroid13: Boolean,
    val matchedBrand: String,
    val statusMessage: String
)

object DeviceDetector {
    fun getDeviceInfo(): DeviceInfo {
        val manufacturer = Build.MANUFACTURER.orEmpty()
        val model = Build.MODEL.orEmpty()
        val release = Build.VERSION.RELEASE.orEmpty()
        val api = Build.VERSION.SDK_INT
        val isAndroid13 = api == 33 || release == "13"

        val lowerMfr = manufacturer.lowercase()
        val matchedBrand = when {
            lowerMfr.contains("samsung") -> "Samsung"
            lowerMfr.contains("xiaomi") || lowerMfr.contains("redmi") || lowerMfr.contains("poco") -> "Xiaomi / Redmi / POCO"
            lowerMfr.contains("oppo") || lowerMfr.contains("realme") || lowerMfr.contains("oneplus") -> "Realme / Oppo / OnePlus"
            lowerMfr.contains("vivo") || lowerMfr.contains("iqoo") -> "Vivo / iQOO"
            lowerMfr.contains("google") -> "Google Pixel"
            else -> "Stock Android / Other"
        }

        val statusMessage = if (isAndroid13) {
            "Verified Android 13 (API 33). High compatibility with iOS emoji mods!"
        } else if (api > 33) {
            "Android ${release} (API $api). Fully supports Android 13+ methods."
        } else {
            "Android ${release} (API $api). Compatible with zFont 3 & iOS Story Styler."
        }

        return DeviceInfo(
            manufacturer = manufacturer.replaceFirstChar { it.uppercase() },
            model = model,
            androidVersion = release,
            apiLevel = api,
            isAndroid13 = isAndroid13,
            matchedBrand = matchedBrand,
            statusMessage = statusMessage
        )
    }
}
