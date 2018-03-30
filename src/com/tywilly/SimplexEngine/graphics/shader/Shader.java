package com.tywilly.SimplexEngine.graphics.shader;

import static org.lwjgl.opengl.GL20.*;

public class Shader {

    private int programID;

    private String vertexShaderSource, fragmentShaderSource;

    public Shader(){
    }

    public void loadShader(){

        int vertexShaderID, fragmentShaderID;

        vertexShaderID = glCreateShader(GL_VERTEX_SHADER);
        glShaderSource(vertexShaderID, vertexShaderSource, null);
        glCompileShader(vertexShaderID);

        fragmentShaderID = glCreateShader(GL_FRAGMENT_SHADER);
        glShaderSource(fragmentShaderID, fragmentShaderSource, null);
        glCompileShader(fragmentShaderID);

        programID = glCreateProgram();
        glAttachShader(programID, vertexShaderID);
        glAttachShader(programID, fragmentShaderID);
        glLinkProgram(programID);

        glDeleteShader(vertexShaderID);
        glDeleteShader(fragmentShaderID);

    }

    public void deleteShader(){
        glDeleteProgram(programID);
    }

}
