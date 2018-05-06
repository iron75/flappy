package com.hn.flappy;

import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class Main extends PApplet {
    Bird bird;
    List<Pipe> pipes = new ArrayList();


    public static void main(String[] args) {
        PApplet.main("Main", args);
    }

    @Override
    public void settings() {
        size(400, 600);
    }

    @Override
    public void setup() {
        smooth();


        bird = new Bird(this);
//        for (int i = 0; i <pipes.size() ; i++) {
            pipes.add(new Pipe(this));
//        }
    }

    @Override
    public void draw() {


        //display
        background(0);


        //draw pipes
        for (int i = pipes.size() - 1; i >= 0; i--) {
            pipes.get(i).update();
            pipes.get(i).display();


            if(pipes.get(i).hit(bird)){
                System.out.println("COLLISION");
            }


            if (pipes.get(i).offscreen()) {
                pipes.remove(i);
            }
        }

        //draw bird
        bird.update();
        bird.display();


        //add new pipe
        if (frameCount % 100 == 0) {
            pipes.add(new Pipe(this));
        }

        //stats
        text("x " + (int)bird.x + ", y " + (int)bird.y + "   velocity " + (int)bird.velocity, 10, 10);
        text("Pipes " + pipes.size(), 10, 20);

//        System.out.println("pipes.size()"+pipes.size());
    }


    @Override
    public void mousePressed() {
        if (mouseButton == LEFT) {
            bird.up();


        }

        if (mouseButton == RIGHT) {
            for (int i = pipes.size() - 1; i >= 0; i--) {
                pipes.get(i).update();
            }
        }
    }

    @Override
    public void keyPressed() {

    }
}
