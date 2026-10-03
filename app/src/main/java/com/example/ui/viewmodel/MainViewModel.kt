package com.example.ui.viewmodel

import android.app.Application
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.EmojiDataSource
import com.example.data.local.AppDatabase
import com.example.data.local.entities.CustomComboEntity
import com.example.data.local.entities.FavoriteEmojiEntity
import com.example.data.local.entities.SavedStoryEntity
import com.example.data.model.BrandGuide
import com.example.data.model.EmojiCategory
import com.example.data.model.EmojiCombo
import com.example.data.model.EmojiItem
import com.example.data.repository.EmojiRepository
import com.example.ui.components.NavTab
import com.example.util.DeviceDetector
import com.example.util.DeviceInfo
import com.example.util.FontStyle
import com.example.util.FontStyler
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: EmojiRepository

    init {
        val database = AppDatabase.getDatabase(application)
        repository = EmojiRepository(database.appDao())
    }

    // Navigation
    private val _currentTab = MutableStateFlow(NavTab.KEYBOARD)
    val currentTab: StateFlow<NavTab> = _currentTab.asStateFlow()

    fun selectTab(tab: NavTab) {
        _currentTab.value = tab
    }

    // Device Info for Android 13
    val deviceInfo: DeviceInfo = DeviceDetector.getDeviceInfo()

    // Database Flows
    val savedStories: StateFlow<List<SavedStoryEntity>> = repository.allStories
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val favoriteEmojis: StateFlow<List<FavoriteEmojiEntity>> = repository.favoriteEmojis
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val customCombos: StateFlow<List<CustomComboEntity>> = repository.customCombos
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    // Toast & Alerts
    private val _toastEvent = MutableSharedFlow<String>()
    val toastEvent: SharedFlow<String> = _toastEvent.asSharedFlow()

    fun showToast(message: String) {
        viewModelScope.launch {
            _toastEvent.emit(message)
        }
    }

    // ==========================================
    // KEYBOARD & TYPING PAD STATE
    // ==========================================
    private val _keyboardText = MutableStateFlow("Hey! Check out these iOS emojis on Android 13 🥹🫶✨")
    val keyboardText: StateFlow<String> = _keyboardText.asStateFlow()

    private val _isEmojiDrawerOpen = MutableStateFlow(false)
    val isEmojiDrawerOpen: StateFlow<Boolean> = _isEmojiDrawerOpen.asStateFlow()

    private val _selectedEmojiCategory = MutableStateFlow(EmojiCategory.SMILEYS)
    val selectedEmojiCategory: StateFlow<EmojiCategory> = _selectedEmojiCategory.asStateFlow()

    private val _emojiSearchQuery = MutableStateFlow("")
    val emojiSearchQuery: StateFlow<String> = _emojiSearchQuery.asStateFlow()

    val filteredEmojis: StateFlow<List<EmojiItem>> = combine(
        _selectedEmojiCategory,
        _emojiSearchQuery
    ) { category, query ->
        if (query.isNotBlank()) {
            val q = query.trim().lowercase()
            EmojiDataSource.EMOJI_LIST.filter { item ->
                item.name.lowercase().contains(q) ||
                    item.keywords.any { it.contains(q) } ||
                    item.unicode.contains(q)
            }
        } else {
            EmojiDataSource.EMOJI_LIST.filter { it.category == category }
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), EmojiDataSource.EMOJI_LIST)

    fun appendKeyboardText(str: String) {
        _keyboardText.value += str
    }

    fun backspaceKeyboardText() {
        if (_keyboardText.value.isNotEmpty()) {
            // Check for multi-byte or surrogate pair emojis
            val text = _keyboardText.value
            val lastCodePoint = Character.codePointBefore(text, text.length)
            val charCount = Character.charCount(lastCodePoint)
            _keyboardText.value = text.substring(0, text.length - charCount)
        }
    }

    fun clearKeyboardText() {
        _keyboardText.value = ""
    }

    fun setKeyboardText(text: String) {
        _keyboardText.value = text
    }

    fun toggleEmojiDrawer() {
        _isEmojiDrawerOpen.value = !_isEmojiDrawerOpen.value
    }

    fun setEmojiDrawerOpen(open: Boolean) {
        _isEmojiDrawerOpen.value = open
    }

    fun selectEmojiCategory(cat: EmojiCategory) {
        _selectedEmojiCategory.value = cat
        _emojiSearchQuery.value = ""
    }

    fun searchEmojis(query: String) {
        _emojiSearchQuery.value = query
    }

    // ==========================================
    // STORY CREATOR STATE
    // ==========================================
    private val _storyText = MutableStateFlow("Making aesthetic stories with iOS emojis on Android 13 🫧🤍\nLate night thoughts & coffee ☕️📖")
    val storyText: StateFlow<String> = _storyText.asStateFlow()

    private val _selectedFontStyle = MutableStateFlow(FontStyle.DEFAULT)
    val selectedFontStyle: StateFlow<FontStyle> = _selectedFontStyle.asStateFlow()

    private val _selectedBgPreset = MutableStateFlow("Sunset Glow")
    val selectedBgPreset: StateFlow<String> = _selectedBgPreset.asStateFlow()

    private val _textAlign = MutableStateFlow("Center")
    val textAlign: StateFlow<String> = _textAlign.asStateFlow()

    private val _activeBadge = MutableStateFlow<String?>("🕒 11:11 PM")
    val activeBadge: StateFlow<String?> = _activeBadge.asStateFlow()

    fun updateStoryText(newText: String) {
        _storyText.value = newText
    }

    fun selectFontStyle(style: FontStyle) {
        _selectedFontStyle.value = style
    }

    fun selectBgPreset(preset: String) {
        _selectedBgPreset.value = preset
    }

    fun setTextAlign(align: String) {
        _textAlign.value = align
    }

    fun setBadge(badge: String?) {
        _activeBadge.value = badge
    }

    fun getFormattedStoryOutput(): String {
        val base = _storyText.value
        val transformed = FontStyler.transform(base, _selectedFontStyle.value)
        val badge = _activeBadge.value
        return if (badge != null) "$transformed\n\n[$badge]" else transformed
    }

    fun saveCurrentStory() {
        viewModelScope.launch {
            val content = getFormattedStoryOutput()
            val title = if (content.length > 25) content.take(25) + "..." else content
            repository.saveStory(
                SavedStoryEntity(
                    title = title,
                    content = content,
                    backgroundStyle = _selectedBgPreset.value,
                    fontStyle = _selectedFontStyle.value.displayName,
                    alignment = _textAlign.value
                )
            )
            showToast("Saved to your iOS Stories library!")
        }
    }

    fun deleteStory(id: Long) {
        viewModelScope.launch {
            repository.deleteStory(id)
            showToast("Story deleted.")
        }
    }

    // ==========================================
    // FAVORITES & COMBOS
    // ==========================================
    fun toggleFavorite(emoji: EmojiItem) {
        viewModelScope.launch {
            val isFav = repository.isFavorite(emoji.unicode)
            if (isFav) {
                repository.removeFavorite(emoji.unicode)
                showToast("Removed ${emoji.unicode} from favorites")
            } else {
                repository.addFavorite(emoji.unicode, emoji.name, emoji.category.displayName)
                showToast("Added ${emoji.unicode} to favorites ✨")
            }
        }
    }

    fun isEmojiFavorite(unicode: String): Boolean {
        return favoriteEmojis.value.any { it.unicode == unicode }
    }

    fun saveCustomCombo(title: String, emojis: String, category: String = "Custom") {
        viewModelScope.launch {
            repository.saveCustomCombo(title, emojis, category)
            showToast("Combo '$title' saved!")
        }
    }

    fun deleteCustomCombo(id: Long) {
        viewModelScope.launch {
            repository.deleteCustomCombo(id)
            showToast("Combo deleted.")
        }
    }

    // ==========================================
    // CLIPBOARD ACTIONS
    // ==========================================
    fun copyToClipboard(text: String, label: String = "iOS Emoji") {
        val clipboard = getApplication<Application>().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText(label, text)
        clipboard.setPrimaryClip(clip)
        showToast("Copied to clipboard! Ready to paste.")
    }

    // ==========================================
    // GUIDES
    // ==========================================
    fun getGuideForCurrentDevice(): BrandGuide {
        val matched = deviceInfo.matchedBrand
        return EmojiDataSource.BRAND_GUIDES.firstOrNull { it.brandName.contains(matched, ignoreCase = true) }
            ?: EmojiDataSource.BRAND_GUIDES.first()
    }
}
