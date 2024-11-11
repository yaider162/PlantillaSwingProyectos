package co.edu.uptc.views.wildCardClasses;

import javax.swing.*;
import java.awt.*;

public class CustomColorChooser extends JColorChooser {

    public CustomColorChooser() {
        super();
        initCustomStyle();
    }

    private void initCustomStyle() {
        this.setBackground(new Color(4, 13, 18));
        UIManager.put("Label.foreground", Color.WHITE);
        UIManager.put("ColorChooser.swatchesDefaultRecentColor", Color.WHITE);
        UIManager.put("ColorChooser.swatchesSwatchSize", new Dimension(20, 20));
        UIManager.put("ColorChooser.swatchesRecentSwatchSize", new Dimension(20, 20));
        SwingUtilities.updateComponentTreeUI(this);
    }
}