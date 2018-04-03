package com.tywilly.SimplexEngine.graphics.shader;

import org.lwjgl.system.MemoryUtil;

import static org.lwjgl.opengl.GL20.*;

public class Shader {

    private int programID;

    private String vertexShaderSource, fragmentShaderSource;

    public Shader(String vertexShaderSource, String fragmentShaderSource){

        this.vertexShaderSource = vertexShaderSource;
        this.fragmentShaderSource = fragmentShaderSource;

    }

    public void loadShader(){

        int vertexShaderID, fragmentShaderID;

        vertexShaderID = glCreateShader(GL_VERTEX_SHADER);
        glShaderSource(vertexShaderID, vertexShaderSource);
        glCompileShader(vertexShaderID);

        fragmentShaderID = glCreateShader(GL_FRAGMENT_SHADER);
        glShaderSource(fragmentShaderID, fragmentShaderSource);
        glCompileShader(fragmentShaderID);

        programID = glCreateProgram();
        glAttachShader(programID, vertexShaderID);
        glAttachShader(programID, fragmentShaderID);
        glLinkProgram(programID);

        glDeleteShader(vertexShaderID);
        glDeleteShader(fragmentShaderID);

    }

    public void bindShader(){
        glUseProgram(programID);
    }

    public void deleteShader(){
        glDeleteProgram(programID);
    }

}
