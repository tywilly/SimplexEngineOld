package com.tywilly.SimplexEngine.gameobject.entity;

import com.tywilly.SimplexEngine.gameobject.GameObject;
import com.tywilly.SimplexEngine.graphics.mesh.VertexArray;


import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL30.glBindVertexArray;

public class Entity extends GameObject {

    private VertexArray va;

    private float[] vertex = {0.0f, 1.0f, 0.5f,
            1.0f, -1.0f, 0.5f, -1.0f, -1.0f, 0.5f};
    private float[] colors = {1f, 1f, 1f,
            1f, 1f, 1f,
            1f, 1f, 1f};

    private float rotX = 0;

    private float scale = 0.5f;

    public Entity(float x, float y, float z) {
        super(x, y, z);
        va = new VertexArray();

        va.allocate();
        va.setAttributeVariable(0, vertex, 3);
        va.setAttributeVariable(1, colors, 3);

    }

    @Override
    public void cleanUp(){
        va.cleanUp();
    }

    @Override
    public void onDraw(){

        va.bind();
        glEnableVertexAttribArray(0);
        glEnableVertexAttribArray(1);


        glDrawArrays(GL_TRIANGLES, 0, vertex.length);
        glDisableVertexAttribArray(0);
        glDisableVertexAttribArray(1);
        glBindVertexArray(0);

    }

    @Override
    public void onUpdate(long deltaTime){
        rotX++;
    }
}
