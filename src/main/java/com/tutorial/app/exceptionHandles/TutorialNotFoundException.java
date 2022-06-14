package com.tutorial.app.exceptionHandles;



public class TutorialNotFoundException extends RuntimeException {

    private String message;

    public TutorialNotFoundException(String message) {
        super(message);
        this.message = message;
    }

    public TutorialNotFoundException() {
    }

}
