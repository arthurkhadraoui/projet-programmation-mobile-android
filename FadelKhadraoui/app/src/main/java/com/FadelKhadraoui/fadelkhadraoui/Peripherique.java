package com.fadelkhadraoui.fadelkhadraoui;

public class Peripherique {
    private String name;
    private Boolean status;
    private Pictures imagePeripherique;
    private String type;

    public Peripherique(String name, Boolean status, Pictures imagePeripherique, String type) {
        this.name = name;
        this.status = status;
        this.imagePeripherique = imagePeripherique;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Boolean getStatus() {
        return status;
    }

    public Pictures getImagePeripherique() {
        return imagePeripherique;
    }

    public String getType() {
        return type;
    }
}
