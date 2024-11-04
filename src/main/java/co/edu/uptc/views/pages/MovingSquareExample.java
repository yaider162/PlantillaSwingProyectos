package co.edu.uptc.views.pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MovingSquareExample extends JPanel implements ActionListener {

    private int x = 0; // Posición inicial en X
    private int y = 50; // Posición inicial en Y
    private int squareSize = 30; // Tamaño del cuadrado
    private int xSpeed = 5; // Velocidad en X

    private Timer timer;

    public MovingSquareExample() {
        timer = new Timer(50, this); // Actualiza cada 50 milisegundos (20 fps)
        timer.start(); // Iniciar el temporizador
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dibujar el cuadrado en la posición actual
        g.setColor(Color.BLUE);
        g.fillRect(x, y, squareSize, squareSize);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Actualizar la posición del cuadrado
        x += xSpeed;

        // Cambiar dirección si el cuadrado toca los bordes
        if (x + squareSize > getWidth() || x < 0) {
            xSpeed = -xSpeed;
        }

        // Redibujar el panel
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Animación de Cuadrado");
        MovingSquareExample movingSquareExamplePanel = new MovingSquareExample();

        frame.add(movingSquareExamplePanel);
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
