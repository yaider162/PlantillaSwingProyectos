package co.edu.uptc.views.wildCardClasses;

import java.awt.*;

public class CustomButton2 extends javax.swing.JButton {
    public Color pressedColor = new Color(227, 227, 227);
    public Color rolloverColor = new Color(255, 255, 255);
    public Color normalColor = new Color(4, 13, 18);

    public CustomButton2(String text) {
        super(text);
        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setOpaque(false);
        setForeground(Global.BUTTON_TEXT_COLOR);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setMargin(new Insets(10, 25, 10, 25));
        setFont(Global.FONT_TEXTS_NORMAL);
    }

    @Override
    protected void paintComponent(Graphics g) {
        setForeground(Color.WHITE);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (getModel().isPressed()) {
            g2.setColor(pressedColor);
        } else if (getModel().isRollover()) {
            g2.setColor(rolloverColor);
            setForeground(Color.BLACK);
        } else {
            g2.setColor(normalColor);
        }
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.dispose();
        super.paintComponent(g);
        drawText(g);
    }
    private void drawText(Graphics g) {
        FontMetrics metrics = g.getFontMetrics(getFont());
        int x = (getWidth() - metrics.stringWidth(getText())) / 2;
        int y = ((getHeight() - metrics.getHeight()) / 2) + metrics.getAscent();
        g.setColor(getForeground());
        g.drawString(getText(), x, y);
    }
}
