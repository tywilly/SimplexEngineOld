package com.tywilly.SimplexEngine.input;

public class InputEvent {

    public enum InputAction{

        KEY_PRESSED, KEY_RELEASED

    }

    private InputAction action;
    private char key;

    public InputEvent(InputAction action, char key){
        this.action = action;
        this.key = key;
    }



}
