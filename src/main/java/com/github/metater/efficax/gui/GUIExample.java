package com.github.metater.efficax.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class GUIExample {
    private final Inventory inventory;

    public GUIExample() {
        inventory = Bukkit.createInventory(null, 9, "Example");
        initItems();
    }

    public void initItems() {
        inventory.addItem(createGUIItem(Material.DIAMOND_SWORD, "Example Sword", "§aFirst line of the lore", "§bSecond line of the lore"));
        inventory.addItem(createGUIItem(Material.IRON_HELMET, "§bExample Helmet", "§aFirst line of the lore", "§bSecond line of the lore"));
    }

    protected ItemStack createGUIItem(final Material material, final String name, final String... lore) {
        final ItemStack item = new ItemStack(material, 1);
        final ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(name);
        meta.setLore(Arrays.asList(lore));
        item.setItemMeta(meta);

        return item;
    }

    public void openInventory(final HumanEntity humanEntity) {
        humanEntity.openInventory(inventory);
    }

    @EventHandler
    public void onInventoryClick(final InventoryClickEvent e) {
        if (e.getInventory() != inventory) return;

        e.setCancelled(true);

        final ItemStack clickedItem = e.getCurrentItem();

        if (clickedItem == null || clickedItem.getType() == Material.AIR) return;

        final Player player = (Player) e.getWhoClicked();

        player.sendMessage("You clicked at slot: " + e.getRawSlot());
    }

    @EventHandler
    public void onInventoryClick(final InventoryDragEvent e) {
        if (e.getInventory().equals(inventory)) {
            e.setCancelled(true);
        }
    }
}
