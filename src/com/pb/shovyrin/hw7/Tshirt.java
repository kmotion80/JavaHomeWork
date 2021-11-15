package com.pb.shovyrin.hw7;

public class Tshirt extends Clothes implements ManClothes, WomenClothes {
    public Tshirt(Size size, int price, String color) {
        super(size, price, color);
    }

    @Override
    public void dressMan() {
        System.out.println("Футблока мужская, " + this.size.getDescription() + ", цена: " + price + ", цвет: " + color);
    }

    @Override
    public void dressWomen() {
        System.out.println("Футблока женская, " + this.size.getDescription() + ", цена: " + price + ", цвет: " + color);
    }
}
