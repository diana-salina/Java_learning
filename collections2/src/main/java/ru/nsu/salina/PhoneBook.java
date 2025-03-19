package ru.nsu.salina;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PhoneBook {
    Map<String, Set<String>> book;
    public PhoneBook() {
        book = new HashMap<>();
    }
    public void add(String surname, String phone) {
        if (surname.isEmpty() || phone.isEmpty()) {
            System.out.println("Информация не указана");
            return;
        }
        if (surname.matches(".*\\d.*")) {
            System.out.println("Фамилия не может содержать числа");
            return;
        }
        if (!phone.matches("^(\\+7|8)\\s?\\d{3}\\s?\\d{3}\\s?\\d{2}\\s?\\d{2}$")) {
            System.out.println("Номер не соответствует формату мобильного номера в РФ");
            return;
        }
        Set<String> phones = book.getOrDefault(surname, new HashSet<>());
        phones.add(phone);
        book.put(surname, phones);
    }
    public Set<String> get(String surname) {
        return book.getOrDefault(surname, null);
    }
}
