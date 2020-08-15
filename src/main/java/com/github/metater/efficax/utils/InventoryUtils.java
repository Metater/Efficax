package com.github.metater.efficax.utils;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryUtils {
    public boolean isEmpty(Inventory inventory) {
        for (ItemStack item : inventory.getStorageContents()) {
            if (item != null) {
                return false;
            }
        }

        return true;
    }
}
