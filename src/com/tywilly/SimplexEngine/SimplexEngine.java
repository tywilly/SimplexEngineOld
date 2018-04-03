package com.tywilly.SimplexEngine;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;

import com.tywilly.SimplexEngine.gameobject.GameObject;
import com.tywilly.SimplexEngine.graphics.Renderer;
import com.tywilly.SimplexEngine.graphics.shader.Shader;
import com.tywilly.SimplexEngine.graphics.shader.ShaderManager;
import com.tywilly.SimplexEngine.scene.SceneManager;
import com.tywilly.SimplexEngine.util.SELogger;
import com.tywilly.SimplexEngine.window.Window;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;

public abstract class SimplexEngine {

    private SELogger logger = new SELogger();
    private Window window;

    private Renderer renderer;
    private SceneManager sceneManager;
    private ShaderManager shaderManager;

    public SimplexEngine(){

    }

    public void setWindow(Window window){
        this.window = window;
    }

    public Window getWindow() { return this.window; }

    public SceneManager getSceneManager(){
        return sceneManager;
    }

    public Renderer getRenderer(){
        return renderer;
    }

    public void initBase(){
        logger.info("Initializing SimplexEngine");

        renderer = new Renderer(this);
        renderer.init();

        sceneManager = new SceneManager(this);
        shaderManager = new ShaderManager(this);

        shaderManager.loadShader("default", "res/graphics/shaders/vertex/default.vs",
                "res/graphics/shaders/fragment/default.fs");

        logger.info("Starting game loop");

        renderer.setUpView();


    }

    public void startLoop(){

        long startTime;
        long deltaTime = 0L;
        Shader shader = shaderManager.getShader("default");

        while(!glfwWindowShouldClose(window.getWindowID())){
            //LOOOP

            startTime = System.currentTimeMillis();

            GL11.glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

            shader.bindShader();

            for(GameObject obj : sceneManager.getCurrentScene().getObjectList()){

                obj.onUpdate(deltaTime);
                obj.onDraw();

            }

            glfwSwapBuffers(window.getWindowID());
            glfwPollEvents();

            deltaTime = System.currentTimeMillis() - startTime;

        }

        shader.deleteShader();

        //The window has closed!
        shutdown();

    }

    public void cleanUp(){

        logger.info("Shutting down SimplexEngine");

        sceneManager.removeScene();

        window.cleanUp();

        renderer.cleanUp();

    }

    public void startEngine(){
        startup();
    }

    public abstract void startup();

    public abstract void shutdown();

}
