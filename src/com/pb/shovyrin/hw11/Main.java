package com.pb.shovyrin.hw11;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    static class PersonNameComparator implements Comparator<Person> {
        public int compare(Person a, Person b) {
            return a.getUserFio().compareTo(b.getUserFio());
        }
    }

    static class PhoneComparator implements Comparator<Person> {
        public int compare(Person a, Person b) {
            return a.getPhone().compareTo(b.getPhone());
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        boolean isExit = false;

        PhoneBook phonebook = new PhoneBook();

        System.out.println("Телефонная книга v1.0.0\nДля работы с книгой выберите пункт меню:");

        while (!isExit) {
            System.out.println("Для добавления элемента введите 1\n" +
                    "Для удаления элемента введите 2\n" +
                    "Для поиска элемента введите 3\n" +
                    "Для вывода отсортированных элементов введите 4\n" +
                    "Для редактирования элемента введите 5\n" +
                    "Для записи в файл введите 6\n" +
                    "Для чтения из файла введите 7\n" +
                    "Для выхода введите 0");
            String choice = in.nextLine();
            switch (choice) {
                case "1":
                    phonebook.add(addPerson());
                    break;
                case "2":
                    deleteItem(phonebook);
                    break;
                case "3":
                    findElement(phonebook);
                    break;
                case "4":
                    useSort(phonebook);
                    break;
                case "5":
                    editElement(phonebook);
                    break;
                case "6":
                    saveJson(phonebook);
                    break;
                case "7":
                    phonebook.setPersonList(loadJson());
                    phonebook.drawPersonBook();
                    break;
                case "0":
                    isExit = true;
                    System.out.println("Всего хорошего!");
                    break;
                default:
                    System.out.println("Не корректный ввод");
                    isExit = true;
            }
        }
    }

    public static Person addPerson() {
        Scanner in = new Scanner(System.in);
        System.out.println("---------------------\nДобавление нового элемента\n---------------------");
        System.out.println("Введите ФИО: ");
        String fio = in.nextLine();
        System.out.println("Введите дату рождения в формате YYYY-MM-DD:");
        String dateBirth = in.nextLine();
        System.out.println("Добавьте главный номер телефона: ");
        String phone = in.nextLine();
        System.out.println("Введите город: ");
        String adress = in.nextLine();
        String[] dt = dateBirth.split("-", 0);
        return new Person(fio, LocalDate.of(Integer.parseInt(dt[0]), Integer.parseInt(dt[1]), Integer.parseInt(dt[2])), phone, adress);
    }

    public static void deleteItem(PhoneBook phonebook) {
        Scanner in = new Scanner(System.in);
        System.out.println("---------------------\nУдаление элемента\n---------------------");
        System.out.println("Введите ФИО для поиска: ");
        String fio = in.nextLine();
        int index = phonebook.findByFio(fio);
        if (index > -1) {
            phonebook.remove(index);
        } else {
            System.out.println("Клиент с таким ФИО не найден!");
        }
    }

    public static void findElement(PhoneBook phonebook) {
        Scanner in = new Scanner(System.in);
        System.out.println("---------------------\nПоиск элементов\n---------------------");
        System.out.println("Для поиска введите ФИО или номер телефона: ");
        String find = in.nextLine();
        int index = phonebook.findByFio(find);
        if (index == -1) {
            index = phonebook.findByPhone(find);
        }
        if (index > -1) {
            Person p = phonebook.getPersonList().get(index);
            phonebook.drawPerson(p);
        } else {
            System.out.println("Такой элемент не найден!");
        }
    }

    private static void useSort(PhoneBook phonebook) {
        Scanner in = new Scanner(System.in);
        System.out.println("-------------\nВывод отсортированного списка\n--------------");
        System.out.println("Выберите по какому показателю произвести сортировку:\n 1 - ФИО, 2 - Основной телефон");
        int choice = in.nextInt();
        switch (choice) {
            case 1:
                phonebook.sortByFio();
                break;
            case 2:
                phonebook.sortByPhone();
                break;
            default:
                System.out.println("Не корректный выбор");
        }

        phonebook.drawPersonBook();
    }

    private static void editElement(PhoneBook phonebook) {
        Scanner in = new Scanner(System.in);
        System.out.println("-------------\nРедактирование элемента\n--------------");
        System.out.println("В телефонной книге следующие контакты:");
        for (Person p : phonebook.getPersonList()) {
            System.out.println(p.getUserFio());
        }

        System.out.println("Введите ФИО контакта для редактирования: ");
        String findFio = in.nextLine();
        int index = phonebook.findByFio(findFio);
        if (index > -1) {
            System.out.println("Введите ФИО: ");
            String fio = in.nextLine();
            System.out.println("Введите дату рождения в формате YYYY-MM-DD:");
            String dateBirth = in.nextLine();
            System.out.println("Добавьте главный номер телефона: ");
            String phone = in.nextLine();
            System.out.println("Введите город: ");
            String adress = in.nextLine();
            String[] dt = dateBirth.split("-", 0);

            Person p = phonebook.getPersonList().get(index);
            p.setUserFio(fio);
            p.setBirthDay(LocalDate.of(Integer.parseInt(dt[0]), Integer.parseInt(dt[1]), Integer.parseInt(dt[2])));
            p.setPhone(phone);
            p.setAdress(adress);
            p.setEditTime(LocalDateTime.now());

            System.out.println("Данные обновлены успешно");
        } else {
            System.out.println("Контакт не найден");
        }
    }

    private static void saveJson(PhoneBook phoneBook) throws Exception {
        ObjectMapper om = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addSerializer(LocalDate.class, new LocalDateSerializer());
        module.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
        om.registerModule(module);

        String json = om.writerWithDefaultPrettyPrinter().writeValueAsString(phoneBook.getPersonList());

        Path path = Paths.get("files/phonebook-json.txt");
        try (FileWriter file = new FileWriter(String.valueOf(path))) {
            // Writing to a file
            file.write(json);
            file.close();
            System.out.println("Данные сохранены в файле!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static ArrayList<Person> loadJson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(LocalDate.class, new LocalDateDeserializer());
        module.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer());
        mapper.registerModule(module);

        ArrayList<Person> list = mapper.readValue(Paths.get("files/phonebook-json.txt").toFile(), new TypeReference<ArrayList<Person>>() {
        });
        System.out.println("Загрузка телефонной книги произведена успешно");

        return list;
    }
}
