package com.company;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Contacts newContact = new Contacts();
        addObjectContacts(newContact);
        addObjectMissedCalls();
        System.out.println("\n\nПрограмма: пропущенные вызовы.\n");
        while (true) {
            System.out.println("Меню:\n" +
                    "1. Добавить контакт\n" +
                    "2. Добавить пропущенный вызов\n" +
                    "3. Вывести все пропущенные вызовы\n" +
                    "4. Очистить пропущенные вызовы\n" +
                    "5. Выход\n" +
                    "7. Изменить контакт\n" +
                    "7. Удалить контакт\n" +
                    "Выберите пункт из меню (1-4):");
            int input = scanner.nextInt();
            switch (input) {
                case 1: {
                    System.out.println("Введите имя, фамилию, телефон и группу через запятую");
                    scanner.nextLine();
                    String inputContact = scanner.nextLine();
                    String[] masContact = inputContact.split(", ");
                    String name = masContact[0];
                    String surname = masContact[1];
                    String phone = masContact[2];
                    Group group = Group.valueOf(masContact[3]);

                    Contact contact = new Contact(name, surname, phone, group);
                    newContact.contactsAdd(contact);
                    break;
                }
                case 2: {
                    System.out.println("Введите номер телефона пропущенного вызова");
                    scanner.nextLine();
                    String inputPhone = scanner.nextLine();
                    MissedCalls missedCall = new MissedCalls(LocalDateTime.now(), inputPhone);
                    missedCall.missedCallAdd(missedCall.getTime(), missedCall.getPhone());
                    break;
                }
                case 3: {
                    MissedCalls missedCall = new MissedCalls();
                    missedCall.missedCallsPrint();
                    break;
                }
                case 4: {
                    MissedCalls missedCall = new MissedCalls();
                    missedCall.missedCallsDelete();
                    break;
                }
                case 5: {
                    System.out.println("Выход...");
                    break;
                }
                case 7: {
                    newContact.contactsUpdate();
                    break;
                }
                case 8: {
                    newContact.contactsDelete();
                    break;
                }
                default:
                    break;
            }
            System.out.println("Для продолжения нажмите Enter, для выхода - 'end'");
            String end = scanner.nextLine();
            if ("end".equals(end)) {
                break;
            }
        }
    }

    private static void addObjectMissedCalls() {
        MissedCalls missedCalls1 = new MissedCalls(LocalDateTime.now(), "8 916 523 13 22");
        MissedCalls missedCalls2 = new MissedCalls(LocalDateTime.now(), "8 916 123 45 67");
        MissedCalls missedCalls3 = new MissedCalls(LocalDateTime.now().minusMinutes(5), "8 916 514 76 14");

        missedCalls1.missedCallAdd(missedCalls1.getTime(), missedCalls1.getPhone());
        missedCalls1.missedCallAdd(missedCalls2.getTime(), missedCalls2.getPhone());
        missedCalls1.missedCallAdd(missedCalls3.getTime(), missedCalls3.getPhone());
    }

    public static void addObjectContacts(Contacts newContact) {
        Contact contact1 = new Contact("Вася", "Пупкин", "8 916 123 45 67", Group.WORK);
        Contact contact2 = new Contact("Петя", "Иванов", "8 916 765 43 21", Group.FRIENDLY);

        newContact.contactsAdd(contact1);
        newContact.contactsAdd(contact2);
    }
}
