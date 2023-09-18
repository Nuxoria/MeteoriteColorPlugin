package me.dev.nux.meteoritecolorplugin.color;

import org.bukkit.Material;

public enum ColorType {

    RED(Material.RED_WOOL, "&cRED"),
    GREEN(Material.GREEN_WOOL, "&aGREEN"),
    BLUE(Material.BLUE_WOOL, "&bBLUE");

    private Material material;
    private String displayName;

    ColorType(Material material, String displayName) {
        this.material = material;
        this.displayName = displayName;
    }

    public Material getMaterial() {
        return material;
    }

    public String getDisplayName() {
        return displayName;
    }

}
