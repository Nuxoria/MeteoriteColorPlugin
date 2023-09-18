package me.dev.nux.meteoritecolorplugin.commands;

import com.meteoritepvp.api.command.Command;
import com.meteoritepvp.api.command.CommandClass;
import com.meteoritepvp.api.utils.CC;
import me.dev.nux.meteoritecolorplugin.MeteoriteColorPlugin;
import me.dev.nux.meteoritecolorplugin.color.Color;
import me.dev.nux.meteoritecolorplugin.color.ColorManager;
import me.dev.nux.meteoritecolorplugin.color.ColorType;
import org.bukkit.entity.Player;

@Command(
        name = "color",
        description = "Add or remove colors",
        aliases = "c"
)
public class ColorCommand implements CommandClass {

    @Command(
            name = "add",
            description = "Add a new color",
            params = "color")
    public void addColor(Player player, String[] params) {

        Color color = ColorManager.toColor(params[0]);

        if (color == null) {
            player.sendMessage(CC.format("&c" + params[0] + " &cis not a valid color."));
            return;
        }

        ColorManager.addColor(color);

    }

    @Command(
            name = "remove",
            description = "Remove an existing color",
            params = "@color"
    )
    public void removeColor(String[] params, Player player) {

        Color color = ColorManager.toColor(params[0].toUpperCase());

        if (color == null) {
            player.sendMessage(CC.format("&c" + params[0] + " &cis not a valid color."));
            return;
        }

        ColorManager.removeColor(color);

    }

}
