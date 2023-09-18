package me.dev.nux.meteoritecolorplugin.color;

import java.util.ArrayList;
import java.util.List;

public class Color {
    private ColorType colorType;

    public Color(ColorType colorType) {

        this.colorType = colorType;

    }

    public ColorType getColorType() {
        return colorType;
    }

    public void setColorType(ColorType colorType) {
        this.colorType = colorType;
    }

}
