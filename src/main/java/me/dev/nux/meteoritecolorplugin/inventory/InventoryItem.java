package me.dev.nux.meteoritecolorplugin.inventory;

import org.bukkit.ChatColor;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InventoryItem {

    private ItemStack itemStack;
    private ItemMeta itemMeta;
    private int slot;

    public InventoryItem(ItemStack itemStack, String displayName, int slot) {
        this.itemStack = itemStack;
        this.slot = slot;

        itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', displayName));

        itemStack.setItemMeta(itemMeta);

    }

    public ItemStack getItemStack() {
        return itemStack;
    }

    public int getSlot() {
        return slot;
    }

    public ItemMeta getItemMeta() {
        return itemMeta;
    }

}
