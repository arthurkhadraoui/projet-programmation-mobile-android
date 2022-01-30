package com.FadelKhadraoui;

public class device {
    private String state;
    private String type;

    public device(String state, String type) {
        this.state = state;
        this.type = type;
    }

    public String getState(){
        return this.state;
    }

    public String getType(){
        return this.type;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setType(String type) {
        this.type = type;
    }
}