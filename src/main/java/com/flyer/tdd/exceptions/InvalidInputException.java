package com.flyer.tdd.exceptions;

import com.flyer.tdd.utils.Constants;

public class InvalidInputException extends Exception {
    public InvalidInputException() {
        super("Input is not valid! Please enter " + Constants.INPUT_SIZE + " distinct space separated single digits.");
    }
}