package com.autumnstudios.libraries.iridescent.api.chat;

import org.bukkit.ChatColor;

public final class Chat {
    public static String gen(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    public static String gen(String msg, char colorCode) {
        return ChatColor.translateAlternateColorCodes(colorCode, msg);
    }

    public static String genLegacy(String msg) {
        return msg.replaceAll("&", "§");
    }
}
