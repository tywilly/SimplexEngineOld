package com.tywilly.SimplexEngine.graphics.mesh;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;

import java.nio.FloatBuffer;

import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL30.*;

public class VertexArray {

    private int bufferID;

    public VertexArray(){
    }

    public void allocate(){

        bufferID = glGenVertexArrays();
        glBindVertexArray(bufferID);

    }

    public void putData(int attribIndex, float[] data){

        int vbo = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        FloatBuffer fb = BufferUtils.createFloatBuffer(data.length);

        fb.put(data);
        fb.flip();
        glBufferData(GL_ARRAY_BUFFER, fb, GL_STATIC_DRAW);
        GL20.glVertexAttribPointer(attribIndex, 3, GL11.GL_FLOAT, false, 0,0);
        glBindBuffer(GL_ARRAY_BUFFER, 0);

    }

    public void bind(){
        glBindVertexArray(bufferID);
    }

    public void cleanUp(){
        glDeleteBuffers(bufferID);
    }

}
