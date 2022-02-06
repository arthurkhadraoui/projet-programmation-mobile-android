package com.fadelkhadraoui.fadelkhadraoui;

public class Capteur {
    private String name;
    private String lastValue;
    private String unit;
    private Pictures imageCapteur;

    public Capteur(String name, String lastValue, String unit, Pictures imageCapteur) {
        this.name = name;
        this.lastValue = lastValue;
        this.unit = unit;
        this.imageCapteur = imageCapteur;
    }

    public String getName() {
        return name;
    }

    public String getLastValue() {
        return lastValue;
    }

    public String getUnit() {
        return unit;
    }

    public Pictures getImageCapteur() {
        return imageCapteur;
    }
}
