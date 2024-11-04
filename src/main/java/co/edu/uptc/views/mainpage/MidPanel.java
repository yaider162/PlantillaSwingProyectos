package co.edu.uptc.views.mainpage;


import co.edu.uptc.interfaces.Interfaces;
import co.edu.uptc.views.wildCardClasses.CustomButton;
import co.edu.uptc.views.wildCardClasses.Global;

import javax.swing.*;
import java.awt.*;

public class MidPanel extends JPanel {
    private final MainPageFrame mainPageFrame;
    private final Interfaces.Presenter presenter;

    public MidPanel(MainPageFrame mainPageFrame, Interfaces.Presenter presenter){
        this.mainPageFrame = mainPageFrame;
        this.presenter = presenter;
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
        CustomButton label = new CustomButton("Param Ovnis");
        label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                label.rolloverColor = Global.BUTTON_BACKGROUND_COLOR.brighter();
                label.repaint();
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                label.rolloverColor = Global.BUTTON_BACKGROUND_COLOR;
                label.repaint();
            }
        });
        label.addActionListener(e -> {
            mainPageFrame.createAskFrame();
        });
        label.setFont(Global.FONT_TITLE_NORMAL);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(label);
        add(Box.createVerticalStrut(50));
        add(Box.createVerticalGlue());
    }
}
