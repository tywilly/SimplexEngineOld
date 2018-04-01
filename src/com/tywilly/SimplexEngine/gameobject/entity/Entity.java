package com.tywilly.SimplexEngine.gameobject.entity;

import com.tywilly.SimplexEngine.gameobject.GameObject;
import com.tywilly.SimplexEngine.graphics.VertexArray;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL20.glDisableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL30.glBindVertexArray;
import static org.lwjgl.system.MemoryUtil.NULL;

public class Entity extends GameObject {

    private VertexArray va;
    private float[] vertex = {0.0f, 1.0f, 0.5f,
            1.0f, -1.0f, 0.5f, -1.0f, -1.0f, 0.5f};
    private float[] index = {};

    private float rotX = 0;

    private float scale = 0.5f;

    public Entity(float x, float y, float z) {
        super(x, y, z);
        va = new VertexArray();

        va.allocate();
        va.putData(0, vertex);
        va.putData(1, index);

    }

    @Override
    public void cleanUp(){
        va.cleanUp();
    }

    @Override
    public void onDraw(){

        va.bind();
        glEnableVertexAttribArray(0);

        glDrawArrays(GL_TRIANGLES, 0, vertex.length);
        glDisableVertexAttribArray(0);
        glBindVertexArray(0);

    }

    @Override
    public void onUpdate(long deltaTime){
        rotX++;
    }
}
