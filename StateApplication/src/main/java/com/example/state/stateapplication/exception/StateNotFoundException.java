package com.example.state.stateapplication.exception;

public class StateNotFoundException extends RuntimeException{
    public StateNotFoundException(String message){
        super(message);
    }
}
