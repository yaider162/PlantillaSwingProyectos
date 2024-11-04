package co.edu.uptc.views.mainpage;

import co.edu.uptc.interfaces.Interfaces;
import co.edu.uptc.models.OvnisManager;
import co.edu.uptc.views.pages.AskFrame;
import co.edu.uptc.views.pages.InfoReal;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class MainPageFrame extends JFrame implements Interfaces.View {
    private Interfaces.Presenter presenter;

    public MainPageFrame(Interfaces.Presenter presenter){
        this.presenter = presenter;
    }

    @Override
    public void start() {
        initComponents();
        createHeaderPanel();
        createMidPanel();
        setVisible(true);
    }

    private void initComponents(){
        this.setTitle("Yaoi's game");
        this.setUndecorated(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setSize(800,600);
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 10, 10));
        this.setLocationRelativeTo(null);
    }
    private void createMidPanel(){
        JPanel midPanel = new MidPanel(this, presenter);
        this.add(midPanel, BorderLayout.CENTER);
    }
    private void createHeaderPanel(){
        JPanel headerPanel = new HeaderPanel(this, presenter);
        this.add(headerPanel, BorderLayout.NORTH);
    }
    public void createAskFrame(){
        AskFrame askFrame = new AskFrame();
        askFrame.setPresenter(presenter);
        askFrame.start();
    }
    @Override
    public void setPresenter(Interfaces.Presenter presenter) {
        this.presenter = presenter;
    }

    public void initGame(OvnisManager ovnisManager) {
        InfoReal infoReal = new InfoReal(ovnisManager);
        infoReal.setPresenter(presenter);
        infoReal.start();
    }
}
