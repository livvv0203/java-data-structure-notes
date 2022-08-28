package com.jieqing;

public class TextBox {

    public String text = "Default Text"; // Reference type

    public void setText(String text) {
        this.text = text;
    }

    public void clear() {
        this.text = "";
    }

    @Override
    public String toString() {
        return text;
    }

}
