package com.pb.shovyrin.hw11;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Person implements Serializable {
    private String userFio;
    private LocalDate birthDay;
    private String phone;
    private String adress;
    private LocalDateTime editTime;

    public String getUserFio() {
        return userFio;
    }

    public void setUserFio(String userFio) {
        this.userFio = userFio;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public LocalDateTime getEditTime() {
        return editTime;
    }

    public void setEditTime(LocalDateTime editTime) {
        this.editTime = editTime;
    }

    public Person() {
    }

    public Person(String userFio, LocalDate birthDay, String phone, String adress) {
        this.userFio = userFio;
        this.birthDay = birthDay;
        this.phone = phone;
        this.adress = adress;
        this.editTime = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "\nФИО: " + this.getUserFio() +
                "\nДата рождения: " + this.getBirthDay() +
                "\nТелефоны: " + this.getPhone() +
                "\nАдрес: " + this.getAdress()+
                "\nДата и время редактирования: " + this.getEditTime() + "\n----------------------";
    }
}