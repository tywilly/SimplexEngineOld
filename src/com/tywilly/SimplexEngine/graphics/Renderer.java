package com.tywilly.SimplexEngine.graphics;

import com.tywilly.SimplexEngine.SimplexEngine;
import com.tywilly.SimplexEngine.util.SELogger;

import org.lwjgl.glfw.*;
import org.lwjgl.opengl.GL;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

public class Renderer {

    private SELogger logger = new SELogger("Renderer");

    private SimplexEngine engineContext;

    public Renderer(SimplexEngine engineContext){
        this.engineContext = engineContext;
    }

    public void init(){
        logger.info("Initializing renderer");

        GLFWErrorCallback.createPrint(System.out);

        if(!glfwInit())
            logger.error("Failed to init GLFW!");

        if(engineContext.getWindow().initWindow() != 0)
            logger.error("Failed to initialize window");

        GL.createCapabilities(); // This is very important.
    }

    public void cleanUp(){
        logger.info("Shutting down renderer");

        glfwTerminate();

    }

    public void setUpView(){
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        //glOrtho(0, engineContext.getWindow().getWidth(), engineContext.getWindow().getHeight(), 0, 1, -1);
        glViewport(0,0, engineContext.getWindow().getWidth(), engineContext.getWindow().getHeight());
        glMatrixMode(GL_MODELVIEW);
    }

}
