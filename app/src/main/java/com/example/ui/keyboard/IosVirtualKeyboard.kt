package com.example.ui.keyboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Backspace
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material.icons.filled.Mood
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ui.components.IosKeyButton

@Composable
fun IosVirtualKeyboard(
    onCharTyped: (String) -> Unit,
    onBackspace: () -> Unit,
    onEmojiToggle: () -> Unit,
    modifier: Modifier = Modifier
) {
    var isShifted by remember { mutableStateOf(false) }
    var isNumbersMode by remember { mutableStateOf(false) }

    val row1Letters = listOf("q", "w", "e", "r", "t", "y", "u", "i", "o", "p")
    val row2Letters = listOf("a", "s", "d", "f", "g", "h", "j", "k", "l")
    val row3Letters = listOf("z", "x", "c", "v", "b", "n", "m")

    val row1Numbers = listOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "0")
    val row2Numbers = listOf("-", "/", ":", ";", "(", ")", "$", "&", "@", "\"")
    val row3Numbers = listOf(".", ",", "?", "!", "'")

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f))
            .padding(vertical = 6.dp, horizontal = 3.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        // Row 1
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            val keys = if (isNumbersMode) row1Numbers else row1Letters
            keys.forEach { key ->
                val displayKey = if (isShifted && !isNumbersMode) key.uppercase() else key
                IosKeyButton(
                    label = displayKey,
                    onClick = {
                        onCharTyped(displayKey)
                        if (isShifted) isShifted = false
                    },
                    modifier = Modifier.weight(1f)
                )
            }
        }

        // Row 2
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = if (isNumbersMode) 0.dp else 14.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            val keys = if (isNumbersMode) row2Numbers else row2Letters
            keys.forEach { key ->
                val displayKey = if (isShifted && !isNumbersMode) key.uppercase() else key
                IosKeyButton(
                    label = displayKey,
                    onClick = {
                        onCharTyped(displayKey)
                        if (isShifted) isShifted = false
                    },
                    modifier = Modifier.weight(1f)
                )
            }
        }

        // Row 3 (Shift, letters/punctuation, Backspace)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (!isNumbersMode) {
                // Shift key
                IosKeyButton(
                    label = if (isShifted) "⬆" else "⇧",
                    onClick = { isShifted = !isShifted },
                    isSpecial = true,
                    contentColor = if (isShifted) MaterialTheme.colorScheme.primary else null,
                    modifier = Modifier.weight(1.35f),
                    testTag = "ios_key_shift"
                )
            }

            val row3 = if (isNumbersMode) row3Numbers else row3Letters
            row3.forEach { key ->
                val displayKey = if (isShifted && !isNumbersMode) key.uppercase() else key
                IosKeyButton(
                    label = displayKey,
                    onClick = {
                        onCharTyped(displayKey)
                        if (isShifted) isShifted = false
                    },
                    modifier = Modifier.weight(1f)
                )
            }

            // Backspace key
            IosKeyButton(
                label = "⌫",
                onClick = onBackspace,
                isSpecial = true,
                modifier = Modifier.weight(1.35f),
                testTag = "ios_key_backspace"
            )
        }

        // Row 4 (123 toggle, Emoji toggle, Space, return)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // 123 / ABC toggle
            IosKeyButton(
                label = if (isNumbersMode) "ABC" else "123",
                onClick = { isNumbersMode = !isNumbersMode },
                isSpecial = true,
                modifier = Modifier.weight(1.35f),
                testTag = "ios_key_123"
            )

            // Emoji / Globe toggle
            IosKeyButton(
                label = "😃",
                onClick = onEmojiToggle,
                isSpecial = true,
                modifier = Modifier.weight(1.1f),
                testTag = "ios_key_emoji_toggle"
            )

            // Spacebar
            IosKeyButton(
                label = "space",
                onClick = { onCharTyped(" ") },
                modifier = Modifier.weight(4.2f),
                testTag = "ios_key_space"
            )

            // Return
            IosKeyButton(
                label = "return",
                onClick = { onCharTyped("\n") },
                isSpecial = true,
                modifier = Modifier.weight(1.7f),
                testTag = "ios_key_return"
            )
        }
    }
}
