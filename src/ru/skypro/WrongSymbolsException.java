package ru.skypro;

public class WrongSymbolsException extends RuntimeException {
    public WrongSymbolsException (String message){
        super(message);
    }
}
