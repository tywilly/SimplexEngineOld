package com.tywilly.SimplexEngine.scene;

import com.tywilly.SimplexEngine.SimplexEngine;
import com.tywilly.SimplexEngine.util.SELogger;

public class SceneManager {

    public static final Scene EMPTY_SCENE = new Scene(){
        @Override
        public void onLoad() {}
        @Override
        public void onDestroy() {}
    };

    private Scene currentScene;
    private SELogger logger;

    private SimplexEngine engineContext;

    public SceneManager(SimplexEngine engineContext){
        this.engineContext = engineContext;
        logger = new SELogger("SceneManager");

        currentScene = SceneManager.EMPTY_SCENE;
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
