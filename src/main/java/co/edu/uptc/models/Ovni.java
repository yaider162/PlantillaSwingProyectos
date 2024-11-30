package co.edu.uptc.models;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.util.Random;

@Getter
@Setter
public class Ovni{
    private int x, y;
    private float initialSpeed;
    private float speed;
    private float speedY;
    private int size = 16;
    private OvnisManager manager;
    private Color color;
    private static final float SPEED_SCALE = 0.1f;
    private boolean followingMouse;
    private int targetX, targetY;


    public Ovni(int speed, OvnisManager manager) {
        Random rand = new Random();
        this.initialSpeed = speed;
        this.speed = (rand.nextBoolean() ? -1 : 1) * speed * SPEED_SCALE;
        this.speedY = (rand.nextBoolean() ? -1 : 1) * speed * SPEED_SCALE;
        this.manager = manager;
        this.x = rand.nextInt(700);
        this.y = rand.nextInt(500);
    }
    public void move() {
        if(followingMouse){
            speed=initialSpeed*SPEED_SCALE;
            speedY=initialSpeed*SPEED_SCALE;
            double angle = Math.atan2(targetY - y, targetX - x);
            x += (int) (speed * Math.cos(angle));
            y += (int) (speedY * Math.sin(angle));
        }else{
            x += (int) (speed);
            y += (int) (speedY);
        }
        if (x > 800 || y > 600 || x < 0 || y < 0) {
            manager.addCrashed(this);
        }
    }
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, size, size);
    }
    public boolean contains(int x, int y) {
        return this.x <= x && x <= this.x + size && this.y <= y && y <= this.y + size;
    }

    public boolean crashWith(Ovni ovniAlive) {
        return this.x <= ovniAlive.getX() + size && ovniAlive.getX() <= this.x + size && this.y <= ovniAlive.getY() + size && ovniAlive.getY() <= this.y + size;
    }
    public Rectangle getBounds() {
        return new Rectangle(x, y, size, size);
    }
    public void setTargetPosition(int x, int y) {
        this.targetX = x;
        this.targetY = y;
    }
}