package co.edu.uptc.views.pages;

import co.edu.uptc.interfaces.Interfaces;
import co.edu.uptc.models.OvnisManager;
import lombok.SneakyThrows;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.util.Timer;
import java.util.TimerTask;

public class InfoReal extends JFrame implements Interfaces.View {
    private Interfaces.Presenter presenter;
    private OvnisManager ovnisManager;
    private JLabel globalParamsLabel;
    private JLabel movingOvnisLabel;
    private JLabel crashedOvnisLabel;
    private JPanel loopPanel;

    public InfoReal() {
    }

    @Override
    public void start() {
        initComponents();
        setVisible(true);
        startUpdating();
    }

    public void startUpdating(){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                movingOvnisLabel.setText("Ovnis en movimiento: " + ovnisManager.getMovingOvnisCount());
                crashedOvnisLabel.setText("Ovnis chocados: " + ovnisManager.getCrashedOvnisCount());
                loopPanel.repaint();
            }
        }, 0, 100);
    }

    private void initComponents() {
        this.setTitle("Yaoi's game");
        this.setUndecorated(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 600);
        this.setLocationRelativeTo(null);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.X_AXIS));
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 15, 15));
        addInfoPanel();
        addLoopPanel();
    }
    private void addInfoPanel() {
        JPanel infoPanel = new JPanel();
        infoPanel.setPreferredSize(new Dimension(200, 600));
        infoPanel.setBackground(new Color(255, 255, 255));
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));

        globalParamsLabel = new JLabel();
        movingOvnisLabel = new JLabel();
        crashedOvnisLabel = new JLabel();

        infoPanel.add(globalParamsLabel);
        infoPanel.add(movingOvnisLabel);
        infoPanel.add(crashedOvnisLabel);

        this.add(infoPanel);
    }

    private void addLoopPanel() {
        loopPanel = new OvnisMovementPanel(ovnisManager);
        this.add(loopPanel);
    }

    @Override
    public void setPresenter(Interfaces.Presenter presenter) {
        this.presenter = presenter;
        this.ovnisManager = (OvnisManager) presenter.getModel();
    }
}