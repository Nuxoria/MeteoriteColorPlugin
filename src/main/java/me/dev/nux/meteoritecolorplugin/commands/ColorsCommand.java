package me.dev.nux.meteoritecolorplugin.commands;

import com.meteoritepvp.api.MeteoritePlugin;
import com.meteoritepvp.api.command.Command;
import com.meteoritepvp.api.command.CommandClass;
import com.meteoritepvp.api.inventory.MeteoriteInventory;
import com.meteoritepvp.api.inventory.presets.BasicInventory;
import com.meteoritepvp.api.utils.CC;
import me.dev.nux.meteoritecolorplugin.color.ColorManager;
import me.dev.nux.meteoritecolorplugin.inventory.InventoryItem;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class ColorsCommand implements CommandClass {

    private MeteoriteInventory meteoriteInventory;

    public ColorsCommand(MeteoritePlugin plugin) {

        meteoriteInventory = new MeteoriteInventory(
                plugin,
                "UNIVERSAL INVENTORY",
                9,
                6,
                false
        );

        BasicInventory page = new BasicInventory();

        List<InventoryItem> inventoryItems = ColorManager.getAllColors().stream()
                .map(color -> new InventoryItem(
                        new ItemStack(color.getColorType().getMaterial()),
                        color.getColorType().getDisplayName(),
                        meteoriteInventory.getInventory().firstEmpty()
                ))
                .collect(Collectors.toList());

        setupInventory(page, inventoryItems);

        // DOING THIS SO THE PLAYER CANNOT MOVE THE ITEMS AROUND
        page.setOnSlotClickListener(event ->
                event.getEvent().setCancelled(true));

        meteoriteInventory.applyPage(page);

    }

    @Command(
            name = "colors",
            description = "Displays all the existing colors in a GUI",
            aliases = "cs"
    )
    public void showGUI(Player player) {

        if (player != null)
            meteoriteInventory.show(player);
        else
            return;

        player.sendMessage(CC.format("&aOpening GUI..."));

    }

    public void setupInventory(BasicInventory page, List<InventoryItem> inventoryItems) {

        inventoryItems.stream()
                        .forEach(inventoryItem -> page.setItem(inventoryItem.getSlot(), inventoryItem.getItemStack()));

        page.update();

    }

}
