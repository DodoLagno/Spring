package fr.diginamic.springdemo.exceptions;

public class VilleNotFoundException extends RuntimeException {

    public VilleNotFoundException(String message) {
        super(message);
    }
}

