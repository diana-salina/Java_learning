package ru.nsu.salina;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("### TASK №1 ###");
        String[] strArr = {"a", "aa", "aaa", "aa", "aaa", "aa", "aaa", "b", "a", "aaa"};
        task1(strArr);

        System.out.println("### TASK №2 ###");
        PhoneBook pb = new PhoneBook();
        pb.add("Salina", "+7 913 777 77 77");
        pb.add("Salina", "89137777778");
        pb.add("Salina", "+791377777");
        pb.add("Попов", "89137777888");
        System.out.println("Salina: " + pb.get("Salina"));
        System.out.println("Попов: " + pb.get("Попов"));
    }

    private static void task1(String[] strArr) {
        Map<String, Integer> strMap = new HashMap<>();
        for (String str : strArr) {
            strMap.put(str, strMap.getOrDefault(str, 0) + 1);
        }
        for (String str : strMap.keySet()) {
            System.out.println(str + " : " + strMap.get(str));
        }

    }
}