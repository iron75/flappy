package com.hn;

import processing.core.PApplet;

public class Pipe {
    PApplet p;

    float top, bottom;
    float x;
    float w = 40;
    private float speed = 2;
    private boolean highlight;


    public Pipe(PApplet p) {
        this.p = p;
        top = p.random(p.height / 2);
        bottom = p.random(p.height / 2);
        x = p.width - 0;
    }

    public void update() {

//        if(x>0)
        x -= speed;

    }

    public boolean offscreen() {
        return (x < -w);
    }

    public void display() {
        p.fill(255);

        if (highlight)
            p.fill(255, 0, 0);

        p.rect(x, 0, w, top);
        p.rect(x, p.height - bottom, w, bottom);
    }

    //Collision
    public boolean hit(Bird bird) {
        if (bird.y > p.height - bottom || bird.y < top) {
            if (bird.x + bird.size/2> x-0 && bird.x - bird.size/2< x+w ){
                highlight = true;
            return true;
            }
        }
        highlight = false;
        return false;
    }
}
