package com.tywilly.SimplexEngine.scene;

import com.tywilly.SimplexEngine.gameobject.GameObject;

import java.util.ArrayList;

public abstract class Scene {

    private ArrayList<GameObject> objectList;

    public Scene(){
        objectList = new ArrayList<>();
    }

    public ArrayList<GameObject> getObjectList(){
        return objectList;
    }

    public abstract void onLoad();

    public abstract void onDestroy();

}
