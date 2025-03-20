package ru.nsu.salina;

import java.util.Arrays;

public class Main {
    static final int SIZE = 10_000_000;

    static final int HALF = SIZE / 2;
    private final static float[] arr = new float[SIZE];
    public static void main(String[] args) {
        getWorkTime();
        try {
            getWorkTimeThreads();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void getWorkTime() {
        Arrays.fill(arr, 1);
        long startTime = System.currentTimeMillis();
        fillArray(SIZE, arr);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken 1: " + (endTime - startTime));
    }
    public static void getWorkTimeThreads() throws InterruptedException {
        Arrays.fill(arr, 1);
        long startTime = System.currentTimeMillis();
        float[] part1 = new float[HALF];
        float[] part2 = new float[HALF];
        System.arraycopy(arr, 0, part1, 0, HALF);
        System.arraycopy(arr, HALF, part2, 0, HALF);
        Thread thread1 = new Thread(() -> {
            fillArray(HALF, part1);
        });
        Thread thread2 = new Thread(() -> {
            fillArray(HALF, part2);
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.arraycopy(part1, 0, arr, 0, HALF);
        System.arraycopy(part2, 0, arr, HALF, HALF);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken 2: " + (endTime - startTime));
    }
    private static void fillArray(int size, float[] array) {
        for (int i = 0; i < size; i++) {
            array[i] =  (float)(array[i] * Math.sin(0.2f + (float)i / 5) * Math.cos(0.2f + (float)i / 5) * Math.cos(0.4f + (float)i / 2));
        }
    }
}

