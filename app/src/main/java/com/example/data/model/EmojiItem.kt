package com.example.data.model

data class EmojiItem(
    val unicode: String,
    val name: String,
    val category: EmojiCategory,
    val iosVersion: String = "iOS 16.4",
    val appleStyleNote: String = "Glossy 3D finish with Apple characteristic warm tones and precise facial reflections",
    val androidDifference: String = "Android default tends to be flatter with minimal gradient highlights",
    val keywords: List<String> = emptyList(),
    val isNew: Boolean = false
)

data class EmojiCombo(
    val id: String,
    val title: String,
    val emojis: String,
    val mood: String,
    val category: String
)

data class GuideStep(
    val stepNumber: Int,
    val title: String,
    val description: String,
    val note: String? = null,
    val isActionRequired: Boolean = false
)

data class BrandGuide(
    val brandName: String,
    val osName: String,
    val compatibilitySummary: String,
    val successRate: String,
    val steps: List<GuideStep>,
    val tips: List<String>
)
