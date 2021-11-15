package com.pb.shovyrin.hw7;

public class Pants extends Clothes implements ManClothes, WomenClothes {
    public Pants(Size size, int price, String color) {
        super(size, price, color);
    }

    @Override
    public void dressMan() {
        System.out.println("Штаны мужские, " + this.size.getDescription() + ", цена: " + price + ", цвет: " + color);
    }

    @Override
    public void dressWomen() {
        System.out.println("Штаны женские, " + this.size.getDescription() + ", цена: " + price + ", цвет: " + color);
    }
}
