package com.pb.shovyrin.hw7;

public class Tie extends Clothes implements ManClothes{
    public Tie(Size size, int price, String color) {
        super(size, price, color);
    }

    @Override
    public void dressMan() {
        System.out.println("Галстук мужской, " + this.size.getDescription() + ", цена: " + price + ", цвет: " + color);
    }
}
