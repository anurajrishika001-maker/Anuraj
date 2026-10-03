package com.example.util

enum class FontStyle(val displayName: String, val sample: String) {
    DEFAULT("SF Pro Clean", "Apple iOS Style"),
    SERIF("New York Serif", "𝐀𝐩𝐩𝐥𝐞 𝐒𝐭𝐲𝐥𝐞"),
    SERIF_ITALIC("Serif Italic", "𝐴𝑝𝑝𝑙𝑒 𝑆𝑡𝑦𝑙𝑒"),
    SCRIPT("Aesthetic Script", "𝒜𝓅𝓅𝓁𝑒 𝒮𝓉𝓎𝓁𝑒"),
    SCRIPT_BOLD("Bold Cursive", "𝓐𝓹𝓹𝓵𝓮 𝓢𝓽𝔂𝓵𝓮"),
    MONOSPACE("Typewriter", "𝙰𝚙𝚙𝚕𝚎 𝚂𝚝𝚢𝚕𝚎"),
    DOUBLE_STRUCK("Outline Glass", "𝔸𝕡𝕡𝕝𝕖 𝕊𝕥𝕪𝕝𝕖"),
    CIRCLED("Bubble Caps", "Ⓐⓟⓟⓛⓔ Ⓢⓣⓨⓛⓔ"),
    GOTHIC("Gothic Fraktur", "𝔄𝔭𝔭𝔩𝔢 𝔖𝔱𝔶𝔩𝔢"),
    SMALL_CAPS("Minimal Caps", "ᴀᴘᴘʟᴇ sᴛʏʟᴇ"),
    AESTHETIC_SPACED("Vapor Spaced", "Ａ ｐ ｐ ｌ ｅ")
}

object FontStyler {

    fun transform(text: String, style: FontStyle): String {
        if (text.isEmpty() || style == FontStyle.DEFAULT) return text

        val sb = StringBuilder()
        for (char in text) {
            val transformed = when (style) {
                FontStyle.DEFAULT -> char.toString()
                FontStyle.SERIF -> toBoldSerif(char)
                FontStyle.SERIF_ITALIC -> toItalicSerif(char)
                FontStyle.SCRIPT -> toScript(char)
                FontStyle.SCRIPT_BOLD -> toBoldScript(char)
                FontStyle.MONOSPACE -> toMonospace(char)
                FontStyle.DOUBLE_STRUCK -> toDoubleStruck(char)
                FontStyle.CIRCLED -> toCircled(char)
                FontStyle.GOTHIC -> toGothic(char)
                FontStyle.SMALL_CAPS -> toSmallCaps(char)
                FontStyle.AESTHETIC_SPACED -> if (char == ' ') "   " else "$char "
            }
            sb.append(transformed)
        }
        return sb.toString().trimEnd()
    }

    private fun toBoldSerif(c: Char): String = when (c) {
        in 'A'..'Z' -> String(Character.toChars(0x1D400 + (c - 'A')))
        in 'a'..'z' -> String(Character.toChars(0x1D41A + (c - 'a')))
        in '0'..'9' -> String(Character.toChars(0x1D7CE + (c - '0')))
        else -> c.toString()
    }

    private fun toItalicSerif(c: Char): String = when (c) {
        in 'A'..'Z' -> String(Character.toChars(0x1D434 + (c - 'A')))
        in 'a'..'z' -> when (c) {
            'h' -> "ℎ"
            else -> String(Character.toChars(0x1D44E + (c - 'a')))
        }
        else -> c.toString()
    }

    private fun toScript(c: Char): String = when (c) {
        in 'A'..'Z' -> when (c) {
            'B' -> "ℬ"; 'E' -> "ℰ"; 'F' -> "ℱ"; 'H' -> "ℋ"; 'I' -> "ℐ"; 'L' -> "ℒ"; 'M' -> "ℳ"; 'R' -> "ℛ"
            else -> String(Character.toChars(0x1D49C + (c - 'A')))
        }
        in 'a'..'z' -> when (c) {
            'e' -> "ℯ"; 'g' -> "ℊ"; 'o' -> "ℴ"
            else -> String(Character.toChars(0x1D4B6 + (c - 'a')))
        }
        else -> c.toString()
    }

    private fun toBoldScript(c: Char): String = when (c) {
        in 'A'..'Z' -> String(Character.toChars(0x1D4D0 + (c - 'A')))
        in 'a'..'z' -> String(Character.toChars(0x1D4EA + (c - 'a')))
        else -> c.toString()
    }

    private fun toMonospace(c: Char): String = when (c) {
        in 'A'..'Z' -> String(Character.toChars(0x1D670 + (c - 'A')))
        in 'a'..'z' -> String(Character.toChars(0x1D68A + (c - 'a')))
        in '0'..'9' -> String(Character.toChars(0x1D7F6 + (c - '0')))
        else -> c.toString()
    }

    private fun toDoubleStruck(c: Char): String = when (c) {
        in 'A'..'Z' -> when (c) {
            'C' -> "ℂ"; 'H' -> "ℍ"; 'N' -> "ℕ"; 'P' -> "ℙ"; 'Q' -> "ℚ"; 'R' -> "ℝ"; 'Z' -> "ℤ"
            else -> String(Character.toChars(0x1D538 + (c - 'A')))
        }
        in 'a'..'z' -> String(Character.toChars(0x1D552 + (c - 'a')))
        in '0'..'9' -> String(Character.toChars(0x1D7D8 + (c - '0')))
        else -> c.toString()
    }

    private fun toCircled(c: Char): String = when (c) {
        in 'A'..'Z' -> String(Character.toChars(0x24B6 + (c - 'A')))
        in 'a'..'z' -> String(Character.toChars(0x24D0 + (c - 'a')))
        in '1'..'9' -> String(Character.toChars(0x2460 + (c - '1')))
        '0' -> "⓪"
        else -> c.toString()
    }

    private fun toGothic(c: Char): String = when (c) {
        in 'A'..'Z' -> when (c) {
            'C' -> "ℭ"; 'H' -> "ℌ"; 'I' -> "ℑ"; 'R' -> "ℜ"; 'Z' -> "ℨ"
            else -> String(Character.toChars(0x1D504 + (c - 'A')))
        }
        in 'a'..'z' -> String(Character.toChars(0x1D51E + (c - 'a')))
        else -> c.toString()
    }

    private fun toSmallCaps(c: Char): String = when (c.lowercaseChar()) {
        'a' -> "ᴀ"; 'b' -> "ʙ"; 'c' -> "ᴄ"; 'd' -> "ᴅ"; 'e' -> "ᴇ"; 'f' -> "ғ"; 'g' -> "ɢ"; 'h' -> "ʜ"
        'i' -> "ɪ"; 'j' -> "ᴊ"; 'k' -> "ᴋ"; 'l' -> "ʟ"; 'm' -> "ᴍ"; 'n' -> "ɴ"; 'o' -> "ᴏ"; 'p' -> "ᴘ"
        'q' -> "ǫ"; 'r' -> "ʀ"; 's' -> "s"; 't' -> "ᴛ"; 'u' -> "ᴜ"; 'v' -> "ᴠ"; 'w' -> "ᴡ"; 'x' -> "x"
        'y' -> "ʏ"; 'z' -> "ᴢ"
        else -> c.toString()
    }
}
