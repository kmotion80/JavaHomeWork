package com.pb.shovyrin.hw11;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

public class PhoneBook implements Serializable {

    private ArrayList<Person> personList;

    public void setPersonList(ArrayList<Person> personList) {
        this.personList = personList;
    }

    public ArrayList<Person> getPersonList() {
        return personList;
    }

    public PhoneBook() {
        this.personList = new ArrayList<>();
    }

    public void add(Person person){
        this.personList.add(person);
    }

    public void remove(int index){
        this.personList.remove(index);
    }

    public void drawPersonBook(){
        for(Person p: this.personList){
            this.drawPerson(p);
        }
    }

    public void drawPerson(Person p){
        System.out.println(p.toString());
    }

    public int findByFio(String fio){
        int index = -1;
        for(int i = 0; i < this.personList.size(); i++){
            if(this.personList.get(i).getUserFio().equals(fio)){
                index = i;
                break;
            }
        }
        return index;
    }
    public int findByPhone(String phone){
        int index = -1;
        for(int i = 0; i < this.personList.size(); i++){
            if(this.personList.get(i).getPhone().equals(phone)){
                index = i;
                break;
            }
        }
        return index;
    }

    public void sortByFio(){
        Comparator<Person> cmp = new Main.PersonNameComparator();
        this.personList.sort(cmp);
    }

    public void sortByPhone(){
        Comparator<Person> cmp = new Main.PhoneComparator();
        this.personList.sort(cmp);
    }
}
