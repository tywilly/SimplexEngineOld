package com.tywilly.SimplexEngine.graphics;

import com.tywilly.SimplexEngine.util.SELogger;

import org.lwjgl.glfw.*;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

public class Renderer {

    private SELogger logger = new SELogger("Renderer");

    public void init(){
        logger.info("Initializing renderer");

        GLFWErrorCallback.createPrint(System.out);

        if(!glfwInit())
            logger.error("Failed to init GLFW!");
    }

    public void renderLoop(){
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);




    }

}
