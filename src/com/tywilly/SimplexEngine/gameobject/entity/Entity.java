package com.tywilly.SimplexEngine.gameobject.entity;

import com.tywilly.SimplexEngine.gameobject.GameObject;

import static org.lwjgl.opengl.GL11.*;

public class Entity extends GameObject {

    private float[] verticies;
    private int[] indeicie;

    public Entity(float x, float y, float z) {
        super(x, y, z);
    }

    @Override
    public void onDraw(){

        glBegin(GL_TRIANGLES);
        glVertex3f(0.0f, 1.0f, -0.5f);
        glVertex3f(1.0f, -1.0f, -0.5f);
        glVertex3f(-1.0f, -1.0f, -0.5f);
        glEnd();

        System.out.println("WE DRAW!");

    }
}
