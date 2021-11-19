package com.pb.shovyrin.hw8;

public class Auth {
    private String login;
    private String password;

    public String getLogin() {
        return login;
    }

    public Auth() {

    }

    public void signUp(String login, String password, String confirmPassword) throws WrongPasswordException {
        String loginPattern = "^\\D+\\d+$";
        String passPattern = "^\\D+\\d+[,.?!]+$";
        if(login.length() < 5 || login.length() > 20){
            throw new WrongPasswordException("Длина логина должна быть от 5 до 20 символов");
        }
        if(password.length() < 5){
            throw new WrongPasswordException("Длина пароля должна быть больше 5 символов");
        }
        if (!login.matches(loginPattern)) {
            throw new WrongPasswordException("Логин не соответствует условиям");
        }
        if (!password.matches(passPattern)) {
            throw new WrongPasswordException("Пароль не соответствует условиям");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Введенные пароли не совпадают!");
        }
        //регистрация прошла успешно
        this.login = login;
        this.password = password;
    }

    public void signIn(String login, String password) throws WrongLoginException {
        if (!this.login.equals(login)) {
            throw new WrongLoginException("Ошибка ввода логина");
        }
        if (!this.password.equals(password)) {
            throw new WrongLoginException("Ошибка ввода пароля");
        }
    }
}
