package com.tywilly.SimplexEngine.scene;

import com.tywilly.SimplexEngine.util.SELogger;

public class SceneManager {

    private Scene currentScene;
    private SELogger logger;


    public SceneManager(){
        logger = new SELogger("SceneManager");
        logger.info("SceneManager initialized");
    }

    public Scene getCurrentScene(){
        return currentScene;
    }

    public void loadScene(Scene newScene){
        logger.info("Loading scene...");

        currentScene.onDestroy();

        currentScene = newScene;

        currentScene.onLoad();
    }

    public void removeScene(){
        logger.info("Unloading scene...");
        currentScene.onDestroy();
        currentScene = null;
    }

}
