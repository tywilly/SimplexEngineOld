package com.tywilly.SimplexEngineExamples;

import com.tywilly.SimplexEngine.SimplexEngine;
import com.tywilly.SimplexEngine.window.Window;

public class SimplexEngineExample extends SimplexEngine {

    @Override
    public void startup() {
        //Create a window
        this.setWindow(new Window(300,300,"SimplexEngine Example"));

        //Initialize the base Engine
        this.initBase();

    }

    @Override
    public void shutdown() {

        //Clean up all systems of the Engine
        this.cleanUp();

    }


    public static void main(String[] args){
        new SimplexEngineExample().startEngine();
    }
}
