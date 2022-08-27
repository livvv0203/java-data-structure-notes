package com.jieqing;

public class Main {

    public static void main(String[] args) {
        TextBox textBox1 = new TextBox(); // Referencing the address on heap
        TextBox textBox2 = textBox1;
        textBox1.setText(("Box 1"));
        System.out.println(textBox1.text.toUpperCase());
    }
}









