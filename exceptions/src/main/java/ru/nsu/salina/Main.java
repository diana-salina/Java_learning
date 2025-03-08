package ru.nsu.salina;

import ru.nsu.salina.exceptions.MyArrayDataException;
import ru.nsu.salina.exceptions.MyArrayException;
import ru.nsu.salina.exceptions.MyArraySizeException;

public class Main {
    public static void main(String[] args) {
        String[][] test1 = {{"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}};
        String[][] test2 = {{"1", "2", "3", "4"},
                {"1", "2", "3", "4s"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}};
        String[][] test3 = {{"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4", "5"}};

        try {
            System.out.println(customCalculation(test1));
        } catch (MyArrayException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(customCalculation(test2));
        } catch (MyArrayException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(customCalculation(test3));
        } catch (MyArrayException e) {
            e.printStackTrace();
        }

    }
    public static int customCalculation(String[][] matrix) throws MyArrayException {
        if (matrix.length != 4) {
            throw new MyArraySizeException();
        }
        int result = 0;
        for (int line = 0; line < matrix.length; ++line) {
            if (matrix[line].length != 4) {
                throw new MyArraySizeException();
            }
            for (int element = 0; element < matrix[line].length; ++element) {
                try {
                    result += Integer.parseInt(matrix[line][element]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(line, element, matrix[line][element]);
                }
            }
        }
        return result;
    }
}