package com.example.data

import com.example.data.model.BrandGuide
import com.example.data.model.EmojiCategory
import com.example.data.model.EmojiCombo
import com.example.data.model.EmojiItem
import com.example.data.model.GuideStep

object EmojiDataSource {

    val EMOJI_LIST: List<EmojiItem> = listOf(
        // Smileys & Emotion
        EmojiItem("🥹", "Face Holding Back Tears", EmojiCategory.SMILEYS, "iOS 15.4", "Huge shimmering glassy eye reflections with soft emotional smile", "Android tears are smaller with flatter pupils", listOf("cry", "happy", "grateful", "tears"), true),
        EmojiItem("🫠", "Melting Face", EmojiCategory.SMILEYS, "iOS 15.4", "Soft sagging liquid edges with Apple's iconic glossy yellow gradient", "Android outline is less distorted", listOf("melt", "hot", "sarcastic", "dissolve"), true),
        EmojiItem("🫡", "Saluting Face", EmojiCategory.SMILEYS, "iOS 15.4", "Apple 3D hand shading with angled thumb and crisp brow shadow", "Flatter skin gradient on standard Android", listOf("salute", "yes sir", "respect", "okay"), true),
        EmojiItem("🫣", "Face with Peeking Eye", EmojiCategory.SMILEYS, "iOS 15.4", "Single dilated eye peeking between glossy modeled fingers", "Different finger positioning on Android", listOf("peek", "shy", "scared", "can't watch"), true),
        EmojiItem("🫢", "Face with Open Eyes & Hand Over Mouth", EmojiCategory.SMILEYS, "iOS 15.4", "Shocked open eyes with realistic palm shadow", "Android eyes have different expression shape", listOf("shock", "gasp", "oops", "secret"), true),
        EmojiItem("🤫", "Shushing Face", EmojiCategory.SMILEYS, "iOS 11.1", "Tilted finger with Apple distinctive lip tuck and specular highlights", "Android finger is straight vertical", listOf("shh", "quiet", "secret", "silent")),
        EmojiItem("🥰", "Smiling Face with Hearts", EmojiCategory.SMILEYS, "iOS 12.1", "Rosy airbrushed cheeks with 3 glossy floating gradient hearts", "Android hearts are smaller with sharper corners", listOf("love", "adore", "crush", "cute")),
        EmojiItem("😂", "Face with Tears of Joy", EmojiCategory.SMILEYS, "iOS 6.0", "Iconic teardrop curvature with toothy grin and Apple depth", "Android teardrops are rounder and less directional", listOf("laugh", "lol", "crying", "funny")),
        EmojiItem("🤣", "Rolling on the Floor Laughing", EmojiCategory.SMILEYS, "iOS 10.2", "45-degree angle tilt with dramatic eye squints and wet tear gleam", "Android rotation angle differs", listOf("rofl", "hilarious", "laugh")),
        EmojiItem("🥺", "Pleading Face", EmojiCategory.SMILEYS, "iOS 12.1", "Ultra-wide puppy eyes with dramatic circular Apple highlights", "Android eyes highlight is simpler", listOf("please", "puppy", "beg", "sad")),
        EmojiItem("✨", "Sparkles", EmojiCategory.SMILEYS, "iOS 6.0", "Four-pointed golden stars with Apple signature diamond gleam", "Android sparkles have thicker center curves", listOf("shine", "magic", "clean", "aesthetic")),
        EmojiItem("❤️‍🔥", "Heart on Fire", EmojiCategory.SMILEYS, "iOS 14.5", "Deep crimson heart enveloped in realistic multi-layered orange flames", "Android flames are more cartoonish", listOf("fire", "passion", "love", "hot"), true),
        EmojiItem("❤️‍🩹", "Mending Heart", EmojiCategory.SMILEYS, "iOS 14.5", "Cracked heart held together with realistic woven fabric bandage", "Android bandage is a flat grey band", listOf("heal", "recovery", "heartbreak", "better"), true),
        EmojiItem("😮‍💨", "Face Exhaling", EmojiCategory.SMILEYS, "iOS 14.5", "Soft white vapor cloud curling gracefully past the cheek", "Android steam cloud is bulkier", listOf("sigh", "relief", "tired", "whew"), true),
        EmojiItem("😵‍💫", "Face with Spiral Eyes", EmojiCategory.SMILEYS, "iOS 14.5", "Hypnotic concentric black spirals inside detailed eye sockets", "Android spirals are looser with different spacing", listOf("dizzy", "confused", "hypnotized", "woah"), true),
        EmojiItem("😶‍🌫️", "Face in Clouds", EmojiCategory.SMILEYS, "iOS 14.5", "Fluffy white stratocumulus clouds obscuring forehead and chin", "Android cloud density is lighter", listOf("smoke", "fog", "lost", "dreamy"), true),

        // People & Body
        EmojiItem("🫶", "Heart Hands", EmojiCategory.PEOPLE, "iOS 15.4", "Interlocking thumbs forming an anatomical heart shape with realistic fingernails", "Android fingers are slightly flatter", listOf("heart", "love", "kpop", "gesture"), true),
        EmojiItem("🫰", "Hand with Index and Thumb Crossed", EmojiCategory.PEOPLE, "iOS 15.4", "K-Drama finger heart with crisp dimensional finger folds", "Android has different thumb knuckle angle", listOf("finger heart", "money", "cute", "korea"), true),
        EmojiItem("🫵", "Index Pointing at the Viewer", EmojiCategory.PEOPLE, "iOS 15.4", "Dramatic foreshortening pointing straight toward user camera", "Android perspective is less pronounced", listOf("you", "point", "choose", "target"), true),
        EmojiItem("🫦", "Biting Lip", EmojiCategory.PEOPLE, "iOS 15.4", "Sensual upper teeth biting bottom lip with glossy shine", "Android lip geometry is stiffer", listOf("flirt", "nervous", "lip", "sexy"), true),
        EmojiItem("🫂", "People Hugging", EmojiCategory.PEOPLE, "iOS 14.2", "Two stylized translucent cyan figures embracing closely", "Android hugging figures are royal blue", listOf("hug", "comfort", "friendship", "care")),
        EmojiItem("🤍", "White Heart", EmojiCategory.PEOPLE, "iOS 13.2", "Soft porcelain white heart with delicate edge beveling and shadow", "Android white heart has subtle grey outline", listOf("love", "pure", "white", "minimal")),
        EmojiItem("🫀", "Anatomical Heart", EmojiCategory.PEOPLE, "iOS 14.2", "Medical-grade aorta, ventricles, and coronary vessels in deep crimson", "Android anatomical heart is simplified", listOf("heart", "biology", "real", "medical")),
        EmojiItem("🫁", "Lungs", EmojiCategory.PEOPLE, "iOS 14.2", "Detailed bronchial tree and trachea with pink lobular shading", "Android lungs have fewer bronchial branches", listOf("breath", "breathe", "lungs", "air")),
        EmojiItem("🤌", "Pinched Fingers", EmojiCategory.PEOPLE, "iOS 14.2", "Iconic Italian gesture with upturned fingertips and thumb contact", "Android fingers have slightly different spacing", listOf("italian", "chef kiss", "what", "gesture")),
        EmojiItem("💅", "Nail Polish", EmojiCategory.PEOPLE, "iOS 6.0", "Iconic sassy red lacquered nails with glossy enamel reflection", "Android polish brush angle is different", listOf("slay", "beauty", "sass", "diva")),

        // Animals & Nature
        EmojiItem("🫧", "Bubbles", EmojiCategory.ANIMALS, "iOS 15.4", "Iridescent soap spheres reflecting a miniature window light source", "Android bubbles lack the delicate chromatic reflection", listOf("soap", "clean", "sparkle", "water", "aesthetic"), true),
        EmojiItem("🪷", "Lotus", EmojiCategory.ANIMALS, "iOS 15.4", "Serene pink water lily floating above a deep green lotus pad", "Android flower petals are more geometric", listOf("flower", "peace", "zen", "lotus"), true),
        EmojiItem("🪹", "Empty Nest", EmojiCategory.ANIMALS, "iOS 15.4", "Woven twigs with realistic natural shadow and empty hollow", "Android nest is rounder", listOf("nest", "home", "cozy", "bird"), true),
        EmojiItem("🪺", "Nest with Eggs", EmojiCategory.ANIMALS, "iOS 15.4", "Three robin-egg blue eggs nestled in dry twig bedding", "Android eggs are beige/white", listOf("eggs", "spring", "new life", "hatch"), true),
        EmojiItem("🪸", "Coral", EmojiCategory.ANIMALS, "iOS 15.4", "Vibrant branching staghorn coral in warm salmon pink", "Android coral has purple tones", listOf("ocean", "sea", "reef", "marine"), true),
        EmojiItem("🦋", "Butterfly", EmojiCategory.ANIMALS, "iOS 10.2", "Radiant morpho butterfly with glowing electric blue wings", "Android blue butterfly is slightly darker cyan", listOf("butterfly", "aesthetic", "blue", "transform")),
        EmojiItem("🧸", "Teddy Bear", EmojiCategory.ANIMALS, "iOS 12.1", "Soft plush brown teddy bear with vintage button eyes and stitched nose", "Android teddy bear is lighter tan", listOf("cute", "toy", "cozy", "soft")),

        // Food & Drink
        EmojiItem("🧋", "Bubble Tea", EmojiCategory.FOOD, "iOS 14.0", "Tall clear plastic cup with brown boba pearls, ice cubes, and fat straw", "Android tapioca pearls are spaced differently", listOf("boba", "tea", "drink", "sweet")),
        EmojiItem("🥑", "Avocado", EmojiCategory.FOOD, "iOS 10.2", "Creamy lime green avocado half with glistening dark seed pit", "Android avocado seed has flatter lighting", listOf("food", "healthy", "guac", "brunch")),
        EmojiItem("🥐", "Croissant", EmojiCategory.FOOD, "iOS 10.2", "Golden flaky buttery pastry with crisp crust ridges", "Android pastry is softer in appearance", listOf("breakfast", "french", "bakery", "pastry")),
        EmojiItem("🫘", "Beans", EmojiCategory.FOOD, "iOS 15.4", "Kidney beans with smooth glossy coat and rich burgundy hue", "Android beans are styled differently", listOf("food", "protein", "healthy"), true),
        EmojiItem("🫙", "Jar", EmojiCategory.FOOD, "iOS 15.4", "Clear mason jar with screw top lid and realistic glass refractions", "Android jar reflections are flatter", listOf("glass", "preserve", "jam", "storage"), true),

        // Objects & Tech
        EmojiItem("🪪", "Identification Card", EmojiCategory.OBJECTS, "iOS 15.4", "Apple Wallet style ID with photo silhouette and magnetic strip", "Android ID looks like a standard badge", listOf("id", "license", "card", "pass"), true),
        EmojiItem("🛝", "Playground Slide", EmojiCategory.OBJECTS, "iOS 15.4", "Bright blue curving plastic slide with metal ladder rungs", "Android slide is straight yellow", listOf("play", "fun", "park", "kids"), true),
        EmojiItem("🛞", "Wheel", EmojiCategory.OBJECTS, "iOS 15.4", "Alloy tire with radial tread pattern and brake rotor glimpse", "Android wheel is flatter", listOf("car", "drive", "tire", "speed"), true),
        EmojiItem("🛟", "Ring Buoy", EmojiCategory.OBJECTS, "iOS 15.4", "Orange safety life preserver with white reflective straps and rope", "Android buoy uses different ropes", listOf("save", "safety", "water", "help"), true),
        EmojiItem("🪄", "Magic Wand", EmojiCategory.OBJECTS, "iOS 14.0", "Black wand with white tip radiating colorful iridescent pixie dust", "Android sparks are yellow stars only", listOf("magic", "sparkle", "wizard", "spell")),
        EmojiItem("🪩", "Mirror Ball / Disco Ball", EmojiCategory.OBJECTS, "iOS 15.4", "Dazzling disco sphere with hundreds of individual faceted mirrored tiles", "Android disco ball has larger tiles", listOf("party", "dance", "disco", "music", "aesthetic"), true),
        EmojiItem("🔋", "Battery", EmojiCategory.OBJECTS, "iOS 6.0", "Apple green status indicator bar with metallic terminal nub", "Android battery orientation differs", listOf("charge", "power", "energy", "life")),

        // Symbols & Aesthetic
        EmojiItem("🪪", "ID Badge", EmojiCategory.SYMBOLS, "iOS 15.4", "Smart plastic card", "Badge style", listOf("card", "id")),
        EmojiItem("🪫", "Low Battery", EmojiCategory.SYMBOLS, "iOS 15.4", "Horizontal battery shell with glowing critical red indicator bar", "Android red bar is centered differently", listOf("dead", "tired", "low", "phone"), true),
        EmojiItem("🧿", "Nazar Amulet", EmojiCategory.SYMBOLS, "iOS 12.1", "Ceramic Turkish evil eye glass with concentric blue, white, and black rings", "Android nazar amulet has flatter glaze", listOf("protection", "luck", "aesthetic", "blue")),
        EmojiItem("🪬", "Hamsa", EmojiCategory.SYMBOLS, "iOS 15.4", "Intricate blue hand amulet with protective open eye in palm", "Android hamsa has different line weight", listOf("blessing", "symbol", "charm", "spirit"), true),
        EmojiItem("🪞", "Mirror", EmojiCategory.SYMBOLS, "iOS 14.2", "Gilded oval hand mirror with subtle diagonal glass reflection", "Android mirror frame is silver", listOf("beauty", "reflection", "look", "aesthetic"))
    )

    val AESTHETIC_COMBOS: List<EmojiCombo> = listOf(
        EmojiCombo("1", "Soft Angelic", "🫧🤍🧴✨", "Dreamy & Pure", "Aesthetic"),
        EmojiCombo("2", "Cozy Autumn", "☕️📖🍂🕯️", "Warm & Cozy", "Seasons"),
        EmojiCombo("3", "Clean Girl", "🥑🧴🤍🧘‍♀️", "Fresh & Minimal", "Lifestyle"),
        EmojiCombo("4", "Balletcore", "🧸🎀🩰🍰", "Cute & Pastel", "Fashion"),
        EmojiCombo("5", "Late Night Vibes", "🎧🪩🌙🍸", "Moody & Energetic", "Night"),
        EmojiCombo("6", "Dark Academia", "🕯️🎻📜🕰️", "Vintage & Thoughtful", "Intellectual"),
        EmojiCombo("7", "Matcha & Sunshine", "🍵🪴💚🥐", "Organic & Refreshing", "Cafe"),
        EmojiCombo("8", "Cyber Y2K", "👾💿🪩🛸", "Futuristic & Retro", "Tech"),
        EmojiCombo("9", "Tropical Island", "🌴🥥🌊🍹", "Summer Paradise", "Travel"),
        EmojiCombo("10", "Love Letter", "💌🌹💍💖", "Romantic & Sweet", "Love"),
        EmojiCombo("11", "Hustle & Vision", "📈⚡️💼🚀", "Productive & Focused", "Career"),
        EmojiCombo("12", "Broken & Healing", "🫀❤️‍🩹🫂🌧️", "Emotional & Real", "Mood")
    )

    val BRAND_GUIDES: List<BrandGuide> = listOf(
        BrandGuide(
            brandName = "Samsung",
            osName = "One UI 5.0 / 5.1 (Android 13)",
            compatibilitySummary = "100% Working without root using the zFont 3 / Mono method with Samsung Cloud Backup.",
            successRate = "98% Tested on Android 13",
            steps = listOf(
                GuideStep(1, "Install zFont 3 or Mono", "Download zFont 3 from Play Store or Mono v2.1 for Samsung.", "No root required on Android 13."),
                GuideStep(2, "Select iOS 16.4 / iOS 17 Emoji Font", "Inside zFont, pick the Apple Emoji Font (.ttf) package from the Emoji tab.", "Supports all newest emojis (🫠, 🥹, 🫶, 🫧)."),
                GuideStep(3, "Apply Samsung Prerequisite Font", "Install 'SamsungSans' font from Galaxy Store and set it as system font.", "This acts as the bridge font."),
                GuideStep(4, "Backup 'Settings' Only", "Go to Settings > Accounts & Backup > Back up data. Select ONLY 'Settings' and tap Back Up Now.", "Takes about 5 seconds."),
                GuideStep(5, "Install Custom Font & Restore", "Uninstall SamsungSans, install the zFont package, then Restore 'Settings' from Samsung Cloud.", "Your system emoji will instantly flip to Apple iOS style across all apps!")
            ),
            tips = listOf(
                "Works across Samsung Keyboard, Instagram, WhatsApp, and System UI.",
                "To revert, simply switch font back to 'Default' in Settings > Display > Font size and style."
            )
        ),
        BrandGuide(
            brandName = "Xiaomi / Redmi / POCO",
            osName = "MIUI 14 / HyperOS (Android 13)",
            compatibilitySummary = "Native Theme Store support on Android 13 via Region switch.",
            successRate = "99% Success",
            steps = listOf(
                GuideStep(1, "Change Region to India or Global", "Go to Settings > Additional Settings > Region > Select 'India'.", "Enables the font engine in Themes app without affecting language."),
                GuideStep(2, "Open Themes App", "Open the official Xiaomi Themes app and go to the 'Fonts' tab (T icon).", null),
                GuideStep(3, "Search 'iOS 16 Emoji' or 'iOS 17 Emoji'", "Search for 'iOS 16 Emoji' or 'Apple Emoji' by certified creators.", "Ensure preview shows 🥹, 🫶, 🫧."),
                GuideStep(4, "Download and Apply", "Tap Download > Apply Font.", "System will prompt to Reboot."),
                GuideStep(5, "Reboot Phone", "After reboot, iOS emojis will be active system-wide.", "You can now safely switch your Region back to your home country.")
            ),
            tips = listOf(
                "Keyboards like Gboard will automatically pick up the iOS emoji glyphs.",
                "Font applies to status bar notifications, lockscreen, and all messenger apps."
            )
        ),
        BrandGuide(
            brandName = "Realme / Oppo / OnePlus",
            osName = "ColorOS 13 / OxygenOS 13 / Realme UI 4.0",
            compatibilitySummary = "Supported via the 'Support Dai Characters' display toggle in Android 13.",
            successRate = "95% Success",
            steps = listOf(
                GuideStep(1, "Download zFont 3", "Install zFont 3 from Google Play Store.", null),
                GuideStep(2, "Select iOS Emoji Font", "In zFont, select the iOS 16 / 17 Emoji Pack and tap Apply.", null),
                GuideStep(3, "Choose 'Support Dai Characters' Method", "Select the Oppo/Realme ColorOS method.", "Android 13 requires region trick."),
                GuideStep(4, "Set Region to Myanmar", "Go to phone Settings > Language & Region > Set Region to 'Myanmar'. Keep language as English.", "Enables the Dai font switch."),
                GuideStep(5, "Toggle 'Support Dai Characters'", "Go to Settings > Display & Brightness > Toggle ON 'Support Dai Characters'.", "All emojis instantly convert to iOS Apple style!")
            ),
            tips = listOf(
                "Time zone might shift when changing region: simply turn on 'Set Time Automatically' to keep accurate time."
            )
        ),
        BrandGuide(
            brandName = "Vivo / iQOO",
            osName = "Funtouch OS 13 (Android 13)",
            compatibilitySummary = "Works through Vivo iTheme custom font engine.",
            successRate = "94% Success",
            steps = listOf(
                GuideStep(1, "Install zFont 3", "Install zFont 3 from Play Store.", null),
                GuideStep(2, "Load Apple Emoji Font", "Select iOS 16 / iOS 17 TTF and choose 'Funtouch OS / Vivo method'.", null),
                GuideStep(3, "Install Custom Font File", "Follow on-screen prompt to replace the temporary font in Vivo iTheme directory.", null),
                GuideStep(4, "Apply via iTheme App", "Open iTheme > Me > Local Fonts > Select the custom font and tap Apply.", null)
            ),
            tips = listOf(
                "Compatible with Funtouch OS 13 built-in Vivo keyboard and Gboard."
            )
        ),
        BrandGuide(
            brandName = "Google Pixel / Motorola / Stock Android",
            osName = "Android 13 (API 33)",
            compatibilitySummary = "Stock Android protects system fonts partition in Android 13.",
            successRate = "Root: 100% | Non-Root: App-level Styler",
            steps = listOf(
                GuideStep(1, "Non-Root Method (Recommended)", "Use this app's iOS Keyboard Simulator & Story Creator to type and copy iOS emojis directly into Instagram, WhatsApp, TikTok, and bio texts.", "Zero risk, no PC required."),
                GuideStep(2, "Instagram Story Trick", "In Instagram Stories, add iOS emoji directly or copy from our Story Creator. Instagram for Android has Apple font rendering built into several story font styles!", null),
                GuideStep(3, "Root Method (For Enthusiasts)", "If rooted with Magisk / KernelSU on Android 13, flash the 'iOS 16.4 Emoji Systemless' module.", "Modifies NotoColorEmoji.ttf systemlessly.")
            ),
            tips = listOf(
                "WhatsApp already includes Apple-style emoji artwork inside its chat bubbles on Android 13 by default!"
            )
        )
    )
}
