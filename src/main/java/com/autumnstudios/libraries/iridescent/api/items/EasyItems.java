package com.autumnstudios.libraries.iridescent.api.items;

import com.autumnstudios.libraries.iridescent.api.chat.Chat;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.Objects;

public final class EasyItems {

    public static ItemStack generate(Material type, String itemName, boolean unbreakable, @Nullable int amount, boolean glow, boolean hideFlags, String...lore) {
        ItemStack stack;
        if (Objects.nonNull(amount)) {stack = new ItemStack(type, amount);}
        else {stack = new ItemStack(type);}
        ItemMeta meta = stack.getItemMeta();
        meta.setDisplayName(Chat.gen(itemName));
        meta.setUnbreakable(unbreakable);
        if (glow) {meta.addEnchant(Enchantment.LOYALTY, 1, true);}
        if (hideFlags) {meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);}
        meta.setLore(Arrays.asList(lore));
        stack.setItemMeta(meta);
        return stack;
    }
}
