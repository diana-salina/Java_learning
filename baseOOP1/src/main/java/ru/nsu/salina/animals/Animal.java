package ru.nsu.salina.animals;

public class Animal {
    protected int runLimit;
    protected int swimLimit;
    protected String successMessage;
    protected String failureMessage;
    static int animalsAmount = 0;
    public Animal() {
        runLimit = -1;
        swimLimit = -1;
        successMessage = "";
        failureMessage = "";
        ++animalsAmount;
    }

    public static int getAmount() {
        return animalsAmount;
    }

    public void run(int distance) {
        String printOut;
        if (distance < 0){
            printOut = "Бежать назад..?";
        } else if (runLimit == -1 || distance < runLimit) {
            if (successMessage.isEmpty()) {
                printOut =  "Животное пробежало " + distance + " м";
            } else {
                printOut = successMessage;
            }
        } else {
            printOut = failureMessage;
        }
        System.out.println(printOut);
    }
    public void swim(int distance) {
        String printOut;
        if (distance < 0){
            printOut = "Плыть назад..?";
        } else if (swimLimit == -1 || distance < runLimit) {
            if (successMessage.isEmpty()) {
                printOut =  "Животное проплыло " + distance + " м";
            } else {
                printOut = successMessage;
            }
        } else {
            printOut = failureMessage;
        }
        System.out.println(printOut);
    }
}
