package co.edu.uptc.views.pages;

import co.edu.uptc.interfaces.Interfaces;
import co.edu.uptc.models.OvnisManager;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class InfoReal extends JFrame implements Interfaces.View{
    private Interfaces.Presenter presenter;
    private OvnisManager ovnisManager;
    public InfoReal(OvnisManager initState){
        this.ovnisManager = initState;
    }
    @Override
    public void start() {
        initComponents();
        setVisible(true);
    }

    private void initComponents(){
        this.setTitle("Yaoi's game");
        this.setUndecorated(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000,600);
        this.setLocationRelativeTo(null);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.X_AXIS));
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 15, 15));
        addInfoPanel();
        addLoopPanel();
    }

    private void addLoopPanel(){
        JPanel loopPanel = new JPanel();
        loopPanel.setPreferredSize(new Dimension(800, 600));
        loopPanel.setBackground(new Color(4, 13, 18));
        this.add(loopPanel);
    }

    private void addInfoPanel(){
        JPanel infoPanel = new JPanel();
        infoPanel.setPreferredSize(new Dimension(200, 600));
        infoPanel.setBackground(new Color(255, 255, 255));
        this.add(infoPanel);
    }
    @Override
    public void setPresenter(Interfaces.Presenter presenter) {
        this.presenter = presenter;
    }
}
