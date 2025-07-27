package ru.nsu.salina;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    static int N = 3;
    public static void main(String[] args) {
    String[] array = {"AAA", "BB", "BB", "C", "BB", "AAA"};
    task1(array);
    System.out.println("--------------------");
    List<Employee> employees = new ArrayList<>(Arrays.asList(
            new Employee("Mary", 18, 9000),
            new Employee("Poll", 20, 10000),
            new Employee("Bob", 22, 15000),
            new Employee("John", 24, 12000)
            ));
    task2(employees);
    System.out.println("--------------------");
    task3(employees, N);
    }
    private static void task1(String[] args) {
        Arrays.stream(args)
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .ifPresent(System.out::println);
    }
    private static void task2(List<Employee> employees) {
        employees.stream()
                .map(Employee::getSalary)
                .mapToInt(n -> n)
                .average()
                .ifPresent(n -> System.out.printf("Средняя зарплата: %.2f\n", n));
    }
    private static void task3(List<Employee> employees, int n) {
        System.out.println(employees.stream()
                .sorted((e1, e2) -> e2.getAge() - e1.getAge())
                .limit(n)
                .map(Employee::getName)
                .collect(Collectors.joining(", ",n + " самых старших сотрудников зовут: ", ";"))
        );
    }
    static class Employee {
        private String name;
        private int age;
        private int salary;
        public Employee(String name, int age, int salary) {
            this.name = name;
            this.age = age;
            this.salary = salary;
        }
        public String getName() {return name;}
        public int getAge() {return age;}
        public int getSalary() {return salary;}
    }
}