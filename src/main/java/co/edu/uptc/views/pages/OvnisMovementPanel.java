package co.edu.uptc.views.pages;

import co.edu.uptc.models.Ovni;
import co.edu.uptc.models.OvnisManager;
import lombok.SneakyThrows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OvnisMovementPanel extends JPanel {
    private OvnisManager ovnisManager;
    private boolean firstTime=true;

    public OvnisMovementPanel(OvnisManager ovnisManager) {
        this.ovnisManager = ovnisManager;
        this.setPreferredSize(new Dimension(800, 600));
        this.setBackground(new Color(4, 13, 18));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                handleClick(e.getX(), e.getY());
            }
        });
    }

    private void handleClick(int x, int y) {
        for (Ovni ovni : ovnisManager.getOvnisAlive()) {
            if (ovni.contains(x, y)) {
                System.out.println("Ovni +" +
                        "clicked at: " + x + ", " + y);
                break;
            }
        }
    }
    @SneakyThrows
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (firstTime) ovnisManager.continueOvnis(g);
        firstTime=false;
        ovnisManager.moves(g);
    }
}