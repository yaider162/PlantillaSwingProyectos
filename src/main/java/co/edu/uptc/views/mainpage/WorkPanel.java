package co.edu.uptc.views.mainpage;


import co.edu.uptc.interfaces.Interfaces;
import co.edu.uptc.views.wildCardClasses.Global;

import javax.swing.*;
import java.awt.*;

public class WorkPanel extends JPanel {
    private final MainPageFrame mainPageFrame;
    private final Interfaces.Presenter presenter;

    public WorkPanel(MainPageFrame mainPageFrame, Interfaces.Presenter presenterVet){
        this.mainPageFrame = mainPageFrame;
        this.presenter = presenterVet;
        initWorkPanel();
        createLabelAndButton();
    }

    private void initWorkPanel() {
        setBackground(Global.WORK_BACKGROUND_COLOR);
        setForeground(Global.WORK_TEXT_COLOR);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }
    private void createLabelAndButton(){
        add(Box.createVerticalGlue());
        JLabel label = new JLabel("Bienvenido");
        label.setFont(Global.FONT_TITLE_BIG);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(label);
        add(Box.createVerticalStrut(50));
        add(Box.createVerticalGlue());
    }
}
