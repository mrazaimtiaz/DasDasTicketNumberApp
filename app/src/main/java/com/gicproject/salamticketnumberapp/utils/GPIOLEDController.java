package com.gicproject.salamticketnumberapp.utils;

import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;

class GPIOLEDController {
    private static final String TAG = "GPIOLEDController";
    private static final boolean DEBUG = true;

    private String LEDR = "/sys/class/leds/ledR/brightness";
    private String LEDG = "/sys/class/leds/ledG/brightness";
    private String LEDB = "/sys/class/leds/ledB/brightness";
    private String LEDP = "/sys/class/leds/led_pwr/brightness";

    public static final String LEDON = "01";
    public static final String LEDOFF = "00";
    public static final String LED_COLOR_RED = "red";
    public static final String LED_COLOR_GREEN = "green";
    public static final String LED_COLOR_BLUE = "blue";
    public static final String LED_COLOR_BRIGHTNESS = "brightness";
    public static final String LED_COLOR_BRIGHTNESS_LOW = "10";
    public static final String LED_COLOR_BRIGHTNESS_MID = "100";
    public static final String LED_COLOR_BRIGHTNESS_HIGH = "255";

    public void setLEDValue(String ledColor, Boolean switchValue) {
        switch (ledColor) {
            case LED_COLOR_RED:
                if (switchValue)
                    writeValue(LEDR, String.valueOf(LEDON));
                else
                    writeValue(LEDR, String.valueOf(LEDOFF));
                break;
            case LED_COLOR_GREEN:
                if (switchValue)
                    writeValue(LEDG, String.valueOf(LEDON));
                else
                    writeValue(LEDG, String.valueOf(LEDOFF));
                break;
            case LED_COLOR_BLUE:
                if (switchValue)
                    writeValue(LEDB, String.valueOf(LEDON));
                else
                    writeValue(LEDB, String.valueOf(LEDOFF));
                break;
        }
    }

    public void setLEDValue(String ledBrightness) {
        writeValue(LEDP, ledBrightness);
    }

    private void writeValue(String gpo, String value) {
        if (DEBUG) Log.d(TAG, "writeValue: " + "gpo=" + gpo + "  value=" + value);
        File file = new File(gpo);
        FileOutputStream os = null;
        try {
            os = new FileOutputStream(file, true);
            if (os != null)
                os.write((value).getBytes());
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
