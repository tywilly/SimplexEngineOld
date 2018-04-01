package com.tywilly.SimplexEngine.gameobject;

import com.tywilly.SimplexEngine.input.InputEvent;

/**
 * GameObject represents a very basic object in the game.
 */
public abstract class GameObject {

    private float x,y,z;

    public GameObject(float x, float y, float z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void setX(float x){
        this.x = x;
    }

    public float getX(){
        return x;
    }

    public void setY(float y){
        this.y = y;
    }

    public float getY(){
        return y;
    }

    public void setZ(float z){
        this.z = z;
    }

    public float getZ(){
        return z;
    }

    public void onDraw(){}

    public void onUpdate(long deltaTime){}

    public void onInput(InputEvent event){}

    public void cleanUp(){}

}
