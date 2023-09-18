package me.dev.nux.meteoritecolorplugin.color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ColorManager {

    private static List<Color> allColors;

    public ColorManager() {
        allColors = new ArrayList<>();
    }

    public static void addColor(Color color) {
        allColors.add(color);
    }

    public static void removeColor(Color color) {
        allColors.remove(color);
    }

    public static List<Color> getAllColors() {
        return allColors;
    }

    private static boolean isValidColorType(String colorTypeStr) {

        for (ColorType c : ColorType.values()) {

            if (c.toString().equals(colorTypeStr.toUpperCase()))
                return true;

        }

        return false;

    }

    public static Color toColor(String colorStr) {

        ColorType colorType = isValidColorType(colorStr) ? ColorType.valueOf(colorStr.toUpperCase()) : null;

        if (colorType == null) return null;

        return new Color(colorType);

    }

    public static List<String> getColorsAsString() {

        List<String> colors =
                allColors.stream()
                        .map(color -> color.getColorType().toString())
                        .collect(Collectors.toList());

        return colors;

    }


}
