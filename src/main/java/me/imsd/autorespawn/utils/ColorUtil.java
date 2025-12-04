package me.imsd.autorespawn.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.ChatColor;

public class ColorUtil {

    private static final Pattern HEX_PATTERN = Pattern.compile("&#([A-Fa-f0-9]{6})");

    private static final MiniMessage MINI_MESSAGE = MiniMessage.miniMessage();
    private static final LegacyComponentSerializer LEGACY_SERIALIZER = LegacyComponentSerializer.builder()
            .character('§')
            .hexColors()
            .useUnusualXRepeatedCharacterHexFormat()
            .build();

    public static String translateColor(String message) {
        if (message == null) {
            return "";
        }

        if (message.contains("<") || message.contains(">")) {
            try {
                Component component = MINI_MESSAGE.deserialize(message);
                message = LEGACY_SERIALIZER.serialize(component);
            } catch (Exception ignored) {

            }
        }

        String hexCode;
        StringBuilder replacement;
        Matcher matcher = HEX_PATTERN.matcher(message);

        while (matcher.find()) {
            hexCode = matcher.group(1);
            replacement = new StringBuilder("§x");
            char[] hexChars = hexCode.toCharArray();

            for (char ch : hexChars) {
                replacement.append("§").append(ch);
            }

            message = message.replace("&#" + hexCode, replacement.toString());
        }

        return ChatColor.translateAlternateColorCodes('&', message);
    }
}