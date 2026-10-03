package com.example.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "saved_stories")
data class SavedStoryEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val title: String,
    val content: String,
    val backgroundStyle: String,
    val fontStyle: String,
    val alignment: String,
    val timestamp: Long = System.currentTimeMillis()
)

@Entity(tableName = "favorite_emojis")
data class FavoriteEmojiEntity(
    @PrimaryKey
    val unicode: String,
    val name: String,
    val category: String,
    val timestamp: Long = System.currentTimeMillis()
)

@Entity(tableName = "custom_combos")
data class CustomComboEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val title: String,
    val emojis: String,
    val category: String,
    val timestamp: Long = System.currentTimeMillis()
)
