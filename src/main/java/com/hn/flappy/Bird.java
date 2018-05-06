package com.hn.flappy;

import processing.core.PApplet;

public class Bird {
    PApplet p;

   public float x, y;
    int size = 30;

    float gravity = 0.6f;
    public float velocity = 0;
    float lift = 15;


    public Bird(PApplet p) {
        this.p = p;

        this.x = p.width-50;
        this.x = 200;

        this.y = p.height / 2;

    }


    public void update() {
        velocity += gravity;
        velocity *=0.95f;
        this.y += velocity;



        //borders
        if (y > p.height) {
            y = p.height;
            velocity = 0;
        }
        if (y < 0) {
            y =0;
            velocity = 0;
        }


        if(velocity<-15)
            velocity=-15;
    }


    public void up(){
        velocity += -lift;

//        System.out.println(velocity);
    }


    public void display() {
        p.fill(255);
        p.ellipse(x, y, size, size);

    }
}
