package com.autumnstudios.libraries.iridescent.api.util;

public class DateTime {

    int ticks = 0;
    public DateTime(double time, String unit) {
        switch (unit) {
            case "sec", "s" -> ticks = (int) Math.round(time / 20);
            case "min", "m" -> ticks = (int) Math.round((time / 20) / 60);
        }
    }

    public int inTicks() {

        return ticks;
    }
}
