package com.autumnstudios.libraries.iridescent.api.inv;

import com.autumnstudios.libraries.iridescent.api.chat.Chat;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.*;

public class IridInventory {

    public String title;
    int size;
    boolean useBorder;
    List<String> format;
    boolean disabled = false;
    public Map<Integer, ItemStack> itemMap;

    public IridInventory(boolean useBorder, int size, String title, String...format) {
        this.itemMap = new HashMap<>();
        this.useBorder = useBorder;
        this.size = (size * 9);
        this.title = title;
        if (!(format.length == size)) {
            Bukkit.getLogger().severe("Couldn't create inventory! Format is incorrect");
            disabled = true;
            return;
        }
        for (String s : format) {
            if (!(s.length() == 9)) {
                Bukkit.getLogger().severe("Couldn't create inventory! Format is incorrect");
                disabled = true;
            }
        }

        if (disabled) {return;}
        this.format = new ArrayList<>(List.of(format));

    }

    public void makeGuiSlot(char slot, ItemStack stack) {
        for (String s : format) {
            if (Objects.equals(s, String.valueOf(slot))) {
                itemMap.put(format.indexOf(s), stack);
            }
        }
    }



    public Inventory generateInventory() {
        Inventory inv = Bukkit.createInventory(null, size, Chat.gen(title));
        for (Map.Entry<Integer, ItemStack> set : itemMap.entrySet()) {
            inv.setItem(set.getKey(), set.getValue());
        }
        return inv;
    }


}
