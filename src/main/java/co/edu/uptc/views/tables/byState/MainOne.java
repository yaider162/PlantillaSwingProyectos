package co.edu.uptc.views.tables.byState;

import co.edu.uptc.interfaces.Interfaces;
import co.edu.uptc.views.mainpage.MainPageFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainOne extends JDialog {
    private final MainPageFrame mainPageFrame;
    private final Interfaces.Presenter presenter;

    public MainOne(MainPageFrame mainPageFrame, Interfaces.Presenter presenter){
        super(mainPageFrame, true);
        this.mainPageFrame = mainPageFrame;
        this.presenter = presenter;
        initComponents();
        createHeader();
        createWork();
    }
    private void initComponents() {
        this.setSize(obtainSize());
        this.setUndecorated(true);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        fadeIn();
    }
    private Dimension obtainSize(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        return new Dimension((int)width, (int)height);
    }
    private void createWork() {
        MidOne workAllApointments = new MidOne(presenter);
        add(workAllApointments, BorderLayout.CENTER);
    }
    private void createHeader() {
        HeaderOne headerAll = new HeaderOne(this, mainPageFrame, presenter);
        add(headerAll, BorderLayout.NORTH);
    }
    private void fadeIn() {
        Timer timer = new Timer(10, new ActionListener() {
            private float opacity = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                opacity += 0.15f;
                setOpacity(Math.min(opacity, 1)); // Set the new opacity
                if (opacity >= 1) {
                    ((Timer)e.getSource()).stop(); // Stop the timer when the window is fully opaque
                }
            }
        });
        timer.start();
    }

}
