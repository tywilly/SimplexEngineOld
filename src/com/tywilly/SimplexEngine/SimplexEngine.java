package com.tywilly.SimplexEngine;

import com.tywilly.SimplexEngine.graphics.Renderer;
import com.tywilly.SimplexEngine.util.SELogger;
import com.tywilly.SimplexEngine.window.Window;

public abstract class SimplexEngine {

    private SELogger logger = new SELogger();
    private Renderer renderer;

    public SimplexEngine(){

    }

    public void initBase(){
        logger.info("Initializing SimplexEngine");

        renderer = new Renderer();
        renderer.init();


    }

    public abstract void startup();

    public abstract void shutdown();
}
