package co.edu.uptc.views.pages;

import co.edu.uptc.models.Ovni;
import co.edu.uptc.models.OvnisManager;
import lombok.Getter;
import lombok.SneakyThrows;

import javax.swing.*;
import java.awt.*;
@Getter
public class OvnisMovementPanel extends JPanel {
    private OvnisManager ovnisManager;
    private boolean firstTime=true;
    private Ovni ovniToucheded;

    public OvnisMovementPanel(OvnisManager ovnisManager) {
        this.ovnisManager = ovnisManager;
        this.setPreferredSize(new Dimension(800, 600));
        this.setBackground(new Color(4, 13, 18));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ovniToucheded = getOvniTouched(evt.getX(), evt.getY());
            }
        });
    }

    public Ovni getOvniTouched(int x, int y) {
        for (Ovni ovni : ovnisManager.getOvnisAlive()) {
            if (ovni.contains(x, y)) {
                return ovni;
            }
        }
        return null;
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