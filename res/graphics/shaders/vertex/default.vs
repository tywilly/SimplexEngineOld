#version 430 core

layout(location = 0) in vec3 vertex_position;
layout(location = 1) in vec3 transform;

void main(void){

    vec3 vertexPos = vertex_position * transform;

    gl_Position = vec4(vertexPos, 1.0);
}