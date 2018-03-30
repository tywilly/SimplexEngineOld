package com.tywilly.SimplexEngineExamples;

import com.tywilly.SimplexEngine.SimplexEngine;
import com.tywilly.SimplexEngine.gameobject.entity.Entity;
import com.tywilly.SimplexEngine.scene.Scene;
import com.tywilly.SimplexEngine.window.Window;

public class SimplexEngineExample extends SimplexEngine {

    @Override
    public void startup() {
        //Create a window
        this.setWindow(new Window(300,300,"SimplexEngine Example"));

        //Initialize the base Engine
        this.initBase();

        Scene mainScene = new Scene(){

            @Override
            public void onLoad() {
                this.addGameObject(new Entity(0.5f,-0.5f,0));
                this.addGameObject(new Entity(-0.5f,-0.5f,0));
                this.addGameObject(new Entity(0,0.5f,0));
            }

            @Override
            public void onDestroy() {

            }
        };

        getSceneManager().loadScene(mainScene);

        this.startLoop();

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
