package com.company;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class MissedCalls extends Contacts {
    private LocalDateTime time;
    private String phone;

    public MissedCalls(LocalDateTime time, String phone) {
        this.time = time;
        this.phone = phone;
    }

    public MissedCalls() {
    }

    public static Map<LocalDateTime, String> missedCalls = new TreeMap<>();

    public void missedCallAdd(LocalDateTime time, String phone) {
        missedCalls.put(time, phone);
        System.out.println("Телефон " + phone + " Время: " + time.format(DateTimeFormatter.ofPattern("dd.MM.yy в HH:mm:ss")) + " успешно добавлен в пропущенные звонки");
    }

    public void missedCallsPrint() {
        for (Map.Entry<LocalDateTime, String> entry : missedCalls.entrySet()) {
            LocalDateTime time = entry.getKey();
            String value = entry.getValue();

            String result = contactsSearch(value);
            if (!result.equals(""))
                System.out.println("Пропущенный вызов: " + result);
            else
                System.out.println("Пропущенный вызов: " + time.format(DateTimeFormatter.ofPattern("dd.MM.yy в HH:mm:ss")) + " от: " + value);
        }
    }

    public void missedCallsDelete() {
        missedCalls.clear();
        System.out.println("Все пропущенные вызовы успешно удалены");
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String getPhone() {
        return phone;
    }
}
