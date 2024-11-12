package co.edu.uptc.models;

import lombok.Getter;
import lombok.Setter;

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
    private Color color;
    private static final float SPEED_SCALE = 0.5f;

    public Ovni(int speed, OvnisManager manager) {
        Random rand = new Random();
        this.speed = (rand.nextBoolean() ? -1 : 1) * speed * SPEED_SCALE;
        this.speedY = (rand.nextBoolean() ? -1 : 1) * speed * SPEED_SCALE;
        this.manager = manager;
        this.x = rand.nextInt(700);
        this.y = rand.nextInt(500);
    }
    public void move() {
        x += (int) (speed);
        y += (int) (speedY);
        if (x > 800 || y > 600 || x < 0 || y < 0) {
            manager.addCrashed(this);
        }
    }
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, SIZE, SIZE);
    }
    public boolean contains(int x, int y) {
        return this.x <= x && x <= this.x + SIZE && this.y <= y && y <= this.y + SIZE;
    }
}