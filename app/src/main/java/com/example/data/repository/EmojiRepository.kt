package com.example.data.repository

import com.example.data.local.AppDao
import com.example.data.local.entities.CustomComboEntity
import com.example.data.local.entities.FavoriteEmojiEntity
import com.example.data.local.entities.SavedStoryEntity
import kotlinx.coroutines.flow.Flow

class EmojiRepository(private val appDao: AppDao) {
    val allStories: Flow<List<SavedStoryEntity>> = appDao.getAllStories()
    val favoriteEmojis: Flow<List<FavoriteEmojiEntity>> = appDao.getFavoriteEmojis()
    val customCombos: Flow<List<CustomComboEntity>> = appDao.getCustomCombos()

    suspend fun saveStory(story: SavedStoryEntity): Long = appDao.insertStory(story)
    suspend fun deleteStory(id: Long) = appDao.deleteStory(id)

    suspend fun addFavorite(unicode: String, name: String, category: String) {
        appDao.addFavorite(FavoriteEmojiEntity(unicode = unicode, name = name, category = category))
    }

    suspend fun removeFavorite(unicode: String) {
        appDao.removeFavorite(unicode)
    }

    suspend fun isFavorite(unicode: String): Boolean = appDao.isFavorite(unicode)

    suspend fun saveCustomCombo(title: String, emojis: String, category: String): Long {
        return appDao.insertCombo(CustomComboEntity(title = title, emojis = emojis, category = category))
    }

    suspend fun deleteCustomCombo(id: Long) = appDao.deleteCombo(id)
}
