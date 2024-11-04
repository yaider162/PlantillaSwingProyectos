package co.edu.uptc.views.wildCardClasses;

import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultCaret;
import javax.swing.text.JTextComponent;
import java.awt.*;

public class CustomCaret extends DefaultCaret {
    private final Color caretColor;

    public CustomCaret(Color caretColor) {
        this.caretColor = caretColor;
    }

    @Override
    protected synchronized void damage(Rectangle r) {
        if (r == null) return;
        x = r.x;
        y = r.y;
        width = r.width;
        height = r.height;
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        JTextComponent component = getComponent();
        if (component == null) return;

        int dot = getDot();
        Rectangle r = null;
        try {
            r = component.modelToView(dot);
        } catch (BadLocationException e) {
            return;
        }

        if (r == null) return;

        if (isVisible()) {
            g.setColor(caretColor);
            g.drawLine(r.x, r.y, r.x, r.y + r.height - 1);
        }
    }
}