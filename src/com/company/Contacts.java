package com.company;

import java.util.*;

public class Contacts {
    private HashMap<String, Contact> contacts = new HashMap<>();

    public void contactsAdd(Contact contact) {
        contacts.put(contact.getPhone(), contact);
        System.out.println("Контакт " + contact.getName() + " " + contact.getSurname() + " успешно создан");
    }

    public void contactsDelete() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя и фамилию через пробел");
        String input = scanner.nextLine();
        String[] nameSurname = input.split(" ");
        for (HashMap.Entry<String, Contact> entry : contacts.entrySet()) {
            Contact value = entry.getValue();
            if (nameSurname[0].equals(value.getName()) && nameSurname[1].equals(value.getSurname())) {
                contacts.remove(entry.getKey(), entry.getValue());
                System.out.println("Контакт успешно удален");
            }
        }
    }

    public void contactsUpdate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер телефона");
        String input = scanner.nextLine();
        for (HashMap.Entry<String, Contact> entry : contacts.entrySet()) {
            String key = entry.getKey();
            if (input.equals(key)) {
                System.out.println("Введите новую информацию через запятую");
                String infoContact = scanner.nextLine();
                String[] masInfoContact = infoContact.split(", ");
                Contact updateContact = new Contact(masInfoContact[0], masInfoContact[1], masInfoContact[2], Group.valueOf(masInfoContact[3]));
                contacts.put(key, updateContact);
            }
        }
    }

    public void contactsSearch(HashMap<String, Contact> contacts) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер телефона");
        String input = scanner.nextLine();
        for (String entry : contacts.keySet()) {
            if (input.equals(entry)) {
                System.out.println("Найден контакт:");
                System.out.println(contacts.get(entry).toString());
            }
        }
    }

    public String contactsSearch(String phone) {
        String ret = "";
        for (Map.Entry<String, Contact> entry : contacts.entrySet()) {
            if (phone.equals(entry.getKey())) {
                ret = entry.getValue().toString();
            }
        }
        return ret;
    }

    public void contactsPrint(HashMap<String, Contact> contacts) {
        for (HashMap.Entry<String, Contact> entry : contacts.entrySet()) {
            Contact value = entry.getValue();
            System.out.println(toString(value));
        }
    }

    public String toString(Contact value) {
        return "Имя: " + value.getName() + ", Фамилия: " + value.getSurname() + ", Номер телефона: " + value.getPhone() + ", Группа: " + value.getGroup();
    }
}