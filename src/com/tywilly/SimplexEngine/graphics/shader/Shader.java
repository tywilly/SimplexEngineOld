package com.tywilly.SimplexEngine.graphics.shader;

import static org.lwjgl.opengl.GL20.*;

public class Shader {

    private int programID, vertexShaderID, fragmentShaderID;;

    private String vertexShaderSource, fragmentShaderSource;

    public Shader(String vertexShaderSource, String fragmentShaderSource){

        this.vertexShaderSource = vertexShaderSource;
        this.fragmentShaderSource = fragmentShaderSource;

    }

    public void compileShaderSource(){

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

    }

    public String getVertexShaderError(){
        return glGetShaderInfoLog(vertexShaderID);
    }

    public String getFragmentShaderError(){
        return glGetShaderInfoLog(fragmentShaderID);
    }

    public void bindShader(){
        glUseProgram(programID);
    }

    public void deleteShader(){
        glDeleteShader(vertexShaderID);
        glDeleteShader(fragmentShaderID);
        glDeleteProgram(programID);
    }

}
