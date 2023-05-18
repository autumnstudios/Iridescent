package com.autumnstudios.libraries.iridescent.api.items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nullable;

public enum QuickItems {
    BORDER(Material.GRAY_STAINED_GLASS_PANE, "&e", true, 1, false, true, "");

    public ItemStack item;

    QuickItems(Material type, String itemName, boolean unbreakable, @Nullable int amount, boolean glow, boolean hideFlags, String...lore) {
        this.item = EasyItems.generate(type, itemName, unbreakable, amount, glow, hideFlags, lore);
    }
}
