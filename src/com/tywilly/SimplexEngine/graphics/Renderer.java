package com.tywilly.SimplexEngine.graphics;

import com.tywilly.SimplexEngine.SimplexEngine;
import com.tywilly.SimplexEngine.gameobject.GameObject;
import com.tywilly.SimplexEngine.util.SELogger;

import org.lwjgl.glfw.*;

import java.util.ArrayList;

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
    }

    public void cleanUp(){
        logger.info("Shutting down renderer");

        glfwTerminate();

    }

    public void renderLoop(){
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

        ArrayList<GameObject> objects = engineContext.getSceneManager().getCurrentScene().getObjectList();

        for(GameObject obj : objects){

            obj.onDraw();

        }

    }

}
