package com.example.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.local.entities.CustomComboEntity
import com.example.data.local.entities.FavoriteEmojiEntity
import com.example.data.local.entities.SavedStoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AppDao {
    // Stories
    @Query("SELECT * FROM saved_stories ORDER BY timestamp DESC")
    fun getAllStories(): Flow<List<SavedStoryEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStory(story: SavedStoryEntity): Long

    @Query("DELETE FROM saved_stories WHERE id = :id")
    suspend fun deleteStory(id: Long)

    // Favorites
    @Query("SELECT * FROM favorite_emojis ORDER BY timestamp DESC")
    fun getFavoriteEmojis(): Flow<List<FavoriteEmojiEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFavorite(emoji: FavoriteEmojiEntity)

    @Query("DELETE FROM favorite_emojis WHERE unicode = :unicode")
    suspend fun removeFavorite(unicode: String)

    @Query("SELECT EXISTS(SELECT 1 FROM favorite_emojis WHERE unicode = :unicode)")
    suspend fun isFavorite(unicode: String): Boolean

    // Custom Combos
    @Query("SELECT * FROM custom_combos ORDER BY timestamp DESC")
    fun getCustomCombos(): Flow<List<CustomComboEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCombo(combo: CustomComboEntity): Long

    @Query("DELETE FROM custom_combos WHERE id = :id")
    suspend fun deleteCombo(id: Long)
}
