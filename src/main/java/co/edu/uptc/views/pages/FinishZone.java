package co.edu.uptc.views.pages;

import co.edu.uptc.interfaces.Interfaces;
import co.edu.uptc.models.Ovni;

import javax.swing.*;
import java.awt.*;

public class FinishZone extends JPanel implements Interfaces.View {
    private Interfaces.Presenter presenter;

    public FinishZone() {
        initComponents();
    }

    private void initComponents() {
        this.setPreferredSize(new Dimension(70, 70));
        this.setLayout(null);
        this.setBackground(new java.awt.Color(255, 0, 0));
    }

    @Override
    public void start() {
        setVisible(true);
    }

    public boolean contains(Ovni ovni) {
        return this.getBounds().intersects(ovni.getBounds());
    }

    @Override
    public void setPresenter(Interfaces.Presenter presenter) {
        this.presenter = presenter;
    }
}
