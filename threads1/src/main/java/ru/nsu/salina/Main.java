package ru.nsu.salina;

import java.util.Arrays;

public class Main {
    static final int SIZE = 10_000_000;

    static final int HALF = SIZE / 2;
    private final static float[] arr = new float[SIZE];
    public static void main(String[] args) {
        getWorkTime();
        getWorkTimeThreads();
    }
    public static void getWorkTime() {
        Arrays.fill(arr, 1.0f);
        long startTime = System.currentTimeMillis();
        fillArray(SIZE, arr, 0);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken 1: " + (endTime - startTime));
    }
    public static void getWorkTimeThreads() {
        Arrays.fill(arr, 1);
        long startTime = System.currentTimeMillis();
        float[] part1 = new float[HALF];
        float[] part2 = new float[HALF];
        System.arraycopy(arr, 0, part1, 0, HALF);
        System.arraycopy(arr, HALF, part2, 0, HALF);
        Thread thread1 = new Thread(() -> {
            fillArray(HALF, part1, 0);
        });
        Thread thread2 = new Thread(() -> {
            fillArray(HALF, part2, HALF);
        });
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(part1, 0, arr, 0, HALF);
        System.arraycopy(part2, 0, arr, HALF, HALF);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken 2: " + (endTime - startTime));
    }
    private static void fillArray(int size, float[] array, int ratio) {
        for (int j = 0; j < size; j++) {
            int i = j + ratio;
            array[j] =  (float)(array[j] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
}

