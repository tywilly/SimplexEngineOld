package com.tywilly.SimplexEngine.graphics.shader;

import com.tywilly.SimplexEngine.SimplexEngine;
import com.tywilly.SimplexEngine.util.SELogger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class ShaderManager {

    private SELogger logger;

    private SimplexEngine engineContext;

    private HashMap<String, Shader> shaderList;

    public ShaderManager(SimplexEngine engineContext){
        this.engineContext = engineContext;
        shaderList = new HashMap<>();
        logger = new SELogger("ShaderManger");
    }

    public void loadShader(String shaderName, String vertexShaderLoc, String fragmentShaderLoc){

        logger.info("Loading shader");

        File vertShader = new File(vertexShaderLoc);
        File fragShader = new File(fragmentShaderLoc);

        String vertShaderSrc = "";
        String fragShaderSrc = "";

        Shader shader;

        try {
            Scanner scan = new Scanner(vertShader);
            while(scan.hasNextLine()){
                vertShaderSrc = vertShaderSrc + scan.nextLine();
            }
            scan.close();

            scan = new Scanner(fragShader);
            while(scan.hasNextLine()){
                fragShaderSrc = fragShaderSrc + scan.nextLine();
            }
            scan.close();

            shader = new Shader(vertShaderSrc, fragShaderSrc);

            shaderList.put(shaderName, shader);

            logger.info("Shader loaded");

        } catch (FileNotFoundException e) {
            logger.error("Failed to load shader! Reason: " + e.getMessage());
        }

    }

    public Shader getShader(String shaderName){
        return shaderList.get(shaderName);
    }

}
