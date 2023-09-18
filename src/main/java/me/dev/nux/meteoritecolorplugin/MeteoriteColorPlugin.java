package me.dev.nux.meteoritecolorplugin;

import com.meteoritepvp.api.MeteoritePlugin;
import me.dev.nux.meteoritecolorplugin.color.Color;
import me.dev.nux.meteoritecolorplugin.color.ColorManager;
import me.dev.nux.meteoritecolorplugin.commands.ColorCommand;
import me.dev.nux.meteoritecolorplugin.commands.ColorsCommand;
import org.bukkit.plugin.java.JavaPlugin;
import sun.net.www.MeteredStream;

public final class MeteoriteColorPlugin extends MeteoritePlugin {

    private static ColorManager colorManager;

    private static MeteoriteColorPlugin instance;
    @Override
    protected void onInit() {
        super.onInit();

        instance = this;

        colorManager = new ColorManager();

        ColorCommand colorCommand = new ColorCommand();
        ColorsCommand colorsCommand = new ColorsCommand(this);

        registerCommandObject(colorCommand);
        registerCommandObject(colorsCommand);

    }

    @Override
    public void onEnable() {
        super.onEnable();

        registerPlaceholderParameter("color", (sender -> ColorManager.getColorsAsString()));

    }

    public static MeteoriteColorPlugin getInstance() {
        return instance;
    }

    public static ColorManager getColorManager() {
        return colorManager;
    }

}
