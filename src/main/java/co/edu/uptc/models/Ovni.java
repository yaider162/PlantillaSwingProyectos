package co.edu.uptc.models;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

@Getter
@Setter
public class Ovni{
    private int x, y;
    private float speed;
    private float speedY;
    private static final int SIZE = 10;
    private OvnisManager manager;

    public Ovni(int speed, OvnisManager manager) {
        Random rand = new Random();
        if(rand.nextBoolean()) this.speed = -speed;else{this.speed = speed;}
        if(rand.nextBoolean()) this.speedY = -speed;else{this.speedY = speed;}
        this.manager = manager;
        this.x = rand.nextInt(800);
        this.y = rand.nextInt(600);
    }
    public void move() {
        x += (int) (speed);
        y += (int) (speedY);
        if (x > 800 || y > 600 || x < 0 || y < 0) {
            manager.addCrashed(this);
        }
    }
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, SIZE, SIZE);
    }
    public boolean contains(int x, int y) {
        return this.x <= x && x <= this.x + SIZE && this.y <= y && y <= this.y + SIZE;
    }
}