package ru.nsu.salina.exceptions;

public class MyArrayDataException extends MyArrayException{
    private int row;
    private int column;
    private String data;
    public MyArrayDataException(int row, int column, String data) {
        super("Invalid data in [" + row + "; " + column + "]: " + data);
        this.data = data;
        this.column = column;
        this.row = row;
    }
    public int getRow() {
        return row;
    }
    public int getColumn() {
        return column;
    }
    public String getData() {
        return data;
    }
}
