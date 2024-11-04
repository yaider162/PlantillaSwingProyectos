package co.edu.uptc.models;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

@Getter
@Setter
public class Ovni extends JPanel implements Runnable {
    private int x, y, speed;
    private boolean running;
    private static final int SIZE = 20;

    public Ovni(int speed) {
        this.speed = speed;
        Random rand = new Random();
        this.x = rand.nextInt(800);
        this.y = rand.nextInt(600);
        this.running = true;
        setPreferredSize(new Dimension(SIZE, SIZE));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        g.fillOval(0, 0, SIZE, SIZE);
    }

    @Override
    public void run() {
        while (running) {
            move();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void move() {
        x += speed;
        y += speed;
        if (x > 800 || y > 600) {
            running = false;
        }
        repaint();
    }
}