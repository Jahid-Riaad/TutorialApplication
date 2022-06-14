package com.tutorial.app.exceptionHandles;


public class TutorialAlreadyExistsException extends RuntimeException {

    private String message;

    public TutorialAlreadyExistsException(String message) {
        super(message);
        this.message = message;
    }

    public TutorialAlreadyExistsException() {
    }

}