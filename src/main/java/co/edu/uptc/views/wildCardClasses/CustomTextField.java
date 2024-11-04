package co.edu.uptc.views.wildCardClasses;

import javax.swing.*;
import java.awt.*;

public class CustomTextField extends JTextField {
    public CustomTextField(int i) {
        super(i);
        this.setOpaque(false);
        this.setForeground(Color.WHITE);
        this.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(240, 240, 240)));
        this.setCaret(new CustomCaret(Color.WHITE));

    }
}
