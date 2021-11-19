package com.pb.shovyrin.hw8;

import java.util.Scanner;

public class OnlineShop {
    public static void main(String[] args) {
        Auth user = new Auth();
        String login;
        String pass;
        String confPass;

        Scanner in = new Scanner(System.in);

        System.out.println("Регистрация пользователя в магазине!");
        System.out.println("Введите логин: ");
        login = in.nextLine();
        System.out.println("Введите пароль: ");
        pass = in.nextLine();
        System.out.println("Подтверждение пароля:");
        confPass = in.nextLine();

        try{
            user.signUp(login, pass, confPass);
        }catch(WrongPasswordException ex){
            ex.printStackTrace();
            return;
        }

        System.out.println("Регистрация прошла успешно");
        System.out.println("Войдите на сайт");
        System.out.println("Введите логин:");
        login = in.nextLine();
        System.out.println("Введите пароль:");
        pass = in.nextLine();

        try{
            user.signIn(login, pass);
        }catch(WrongLoginException ex){
            ex.printStackTrace();
            return;
        }

        System.out.println(user.getLogin() + " вошел на сайт! Вы можете совершать покупки.");
    }
}
