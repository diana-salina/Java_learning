package ru.nsu.salina;

import ru.nsu.salina.fruits.Apple;
import ru.nsu.salina.fruits.Orange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("### TASK №1 ###");
        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        replace(numbers, 3, 6);
        System.out.println(Arrays.toString(numbers));

        System.out.println("### TASK №2 ###");
        List<Integer> list = reverseToList(numbers);
        System.out.println(list);

        System.out.println("### TASK №3 ###");
        FruitBox<Apple> apples = new FruitBox<>(new Apple(), new Apple(), new Apple());
        FruitBox<Orange> oranges = new FruitBox<>(new Orange(), new Orange());
        System.out.println("Яблоки: " + apples.getWeight());
        System.out.println("Апельсины: " + oranges.getWeight());
        System.out.println(apples.compare(oranges));
        FruitBox<Apple> apples2 = new FruitBox<>();
        apples.moveTo(apples2);
        System.out.println(apples2.compare(apples) + " " + apples2.getWeight() + " " + apples.getWeight());


    }
    public static void replace(Object[] arr, int ind1, int ind2) {
        Object tmp = arr[ind1];
        arr[ind1] = arr[ind2];
        arr[ind2] = tmp;
    }
    public static <T> ArrayList<T> reverseToList(T[] arr) {
        return new ArrayList<>(Arrays.asList(arr));
    }
}