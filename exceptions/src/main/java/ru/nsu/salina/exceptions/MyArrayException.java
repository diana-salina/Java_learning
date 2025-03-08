package ru.nsu.salina.exceptions;

public class MyArrayException extends RuntimeException{
    public MyArrayException(){
    }
    public MyArrayException(String msg) {
        super(msg);
    }
}
