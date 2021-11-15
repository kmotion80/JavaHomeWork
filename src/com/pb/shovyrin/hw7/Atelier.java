package com.pb.shovyrin.hw7;

public class Atelier {
    public static void main(String[] args) {
        Tshirt tshirt = new Tshirt(Size.XXS, 100, "red");
        Pants pants = new Pants(Size.S, 250, "white");
        Skirt skirt = new Skirt(Size.M, 300, "gray");
        Tie tie = new Tie(Size.L, 80, "blue");
        Clothes[] clothes = {tshirt,pants,skirt,tie};
        System.out.println("Представляем мужскую одежду: ");
        dressMan(clothes);

        System.out.println("Представляем женскую одежду: ");
        dressWomen(clothes);
    }

    public static void dressMan(Clothes[] clothes){
        for(Clothes clothe: clothes){
            if(clothe instanceof ManClothes){
                ((ManClothes) clothe).dressMan();
            }
        }
    }
    public static void dressWomen(Clothes[] clothes){
        for(Clothes clothe: clothes){
            if(clothe instanceof WomenClothes){
                ((WomenClothes) clothe).dressWomen();
            }
        }
    }
}
