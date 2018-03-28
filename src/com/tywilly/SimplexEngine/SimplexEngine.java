package com.tywilly.SimplexEngine;

import static org.lwjgl.glfw.GLFW.*;

import com.tywilly.SimplexEngine.graphics.Renderer;
import com.tywilly.SimplexEngine.util.SELogger;
import com.tywilly.SimplexEngine.window.Window;

public abstract class SimplexEngine {

    private SELogger logger = new SELogger();
    private Renderer renderer;
    private Window window;

    public SimplexEngine(){

    }

    public void setWindow(Window window){
        this.window = window;
    }

    public void initBase(){
        logger.info("Initializing SimplexEngine");

        renderer = new Renderer();
        renderer.init();

        if(window != null)
            if(window.initWindow() != 0)
                logger.error("Failed to create window!");

        logger.info("Starting game loop");

        while(!glfwWindowShouldClose(window.getWindowID())){
            //LOOOP

            renderer.renderLoop();

            glfwSwapBuffers(window.getWindowID());
            glfwPollEvents();
        }

    }

    public void startEngine(){
        startup();
    }

    public abstract void startup();

    public abstract void shutdown();

}
