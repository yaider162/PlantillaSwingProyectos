package co.edu.uptc.views.pages;

import co.edu.uptc.interfaces.Interfaces;
import co.edu.uptc.models.Ovni;
import co.edu.uptc.models.OvnisManager;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.util.Timer;
import java.util.TimerTask;

@Getter
@Setter
public class InfoReal extends JFrame implements Interfaces.View {
    private Interfaces.Presenter presenter;
    private OvnisManager ovnisManager;
    private OvnisMovementPanel loopPanel;
    private Ovni ovniTouched;
    private InfoPanel infoPanel;

    public InfoReal(OvnisManager ovnisManager) {
        this.ovnisManager = ovnisManager;
        loopPanel = new OvnisMovementPanel(ovnisManager);
        infoPanel = new InfoPanel(ovnisManager,loopPanel);
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
        this.add(infoPanel);
    }
    private void addLoopPanel() {
        this.add(loopPanel);
    }

    @Override
    public void setPresenter(Interfaces.Presenter presenter) {
        this.presenter = presenter;
        this.ovnisManager = (OvnisManager) presenter.getModel();
    }
}