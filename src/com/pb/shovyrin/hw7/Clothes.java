package com.pb.shovyrin.hw7;

public abstract class Clothes {
    public Size size;
    public int price;
    public String color;

    public Clothes(Size size, int price, String color) {
        this.size = size;
        this.price = price;
        this.color = color;
    }
}
