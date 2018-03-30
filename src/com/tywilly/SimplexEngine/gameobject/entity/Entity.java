package com.tywilly.SimplexEngine.gameobject.entity;

import com.tywilly.SimplexEngine.gameobject.GameObject;

import static org.lwjgl.opengl.GL11.*;

public class Entity extends GameObject {

    private float[] verticies;
    private int[] indeicie;

    private float rotX = 0;

    private float scale = 0.5f;

    public Entity(float x, float y, float z) {
        super(x, y, z);
    }

    @Override
    public void onDraw(){

        glPushMatrix();

        glTranslatef(this.getX(), this.getY(), this.getZ());
        glScalef(scale,scale, 1.0f);
        glRotatef(rotX, 0.0f, 0.0f, 1.0f);

        glBegin(GL_TRIANGLES);
        glColor3f(1.0f, 0.0f,0.0f);
        glVertex3f(0.0f, 1.0f, 0.5f);
        glColor3f(0.0f, 1.0f,0.0f);
        glVertex3f(1.0f, -1.0f, 0.5f);
        glColor3f(0.0f, 0.0f,1.0f);
        glVertex3f(-1.0f, -1.0f, 0.5f);
        glEnd();

        glPopMatrix();

    }

    @Override
    public void onUpdate(long deltaTime){
        rotX++;
    }
}
