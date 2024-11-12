package co.edu.uptc.views.pages;

import co.edu.uptc.models.NumericDocumentFilter;
import co.edu.uptc.models.Ovni;
import co.edu.uptc.models.OvnisManager;
import co.edu.uptc.views.wildCardClasses.CustomCaret;
import co.edu.uptc.views.wildCardClasses.CustomTextField;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import java.awt.*;

public class InfoPanel extends JPanel {
    private JLabel title, color, speed, x1, y1, movingOvnisLabel, crashedOvnisLabel;
    private GridBagConstraints gbc;
    private CustomTextField txtVel;
    private JButton btnA;
    private JButton btnB;
    private Ovni ovniTouched;
    private OvnisManager ovnisManager;
    private Timer timer;
    private OvnisMovementPanel loopPanel;
    private JLabel ovnisHome;
    private JCheckBox showTrajectoriesCheckBox;

    public InfoPanel(OvnisManager ovnisManager, OvnisMovementPanel loopPanel) {
        this.ovnisManager = ovnisManager;
        this.loopPanel = loopPanel;
        this.ovniTouched = loopPanel.getOvniToucheded();
        init();
        startTimer();
    }

    private void init() {
        setupPanel();
        initializeComponents();
        addComponentsToPanel();
        addListeners();
    }

    private void setupPanel() {
        this.setPreferredSize(new Dimension(200, 600));
        this.setBackground(new Color(213, 213, 213));
        this.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 0, 5, 5);
    }

    private void initializeComponents() {
        title = createLabel("Ovni Tocado", Font.BOLD, 14);
        color = createLabel("Color:", Font.PLAIN, 12);
        speed = createLabel("Velocidad:", Font.PLAIN, 12);
        x1 = createLabel("X:", Font.PLAIN, 12);
        y1 = createLabel("Y:", Font.PLAIN, 12);
        movingOvnisLabel = createLabel("En movimiento:", Font.PLAIN, 12);
        crashedOvnisLabel = createLabel("Chocados:", Font.PLAIN, 12);
        ovnisHome = createLabel("En casa:", Font.PLAIN, 12);
        showTrajectoriesCheckBox = new JCheckBox("Ver trayectorias");

        txtVel = createCustomTextField();
        btnA = createButton("Aceptar", new Color(70, 130, 180));
        btnB = createButton("Cerrar", new Color(220, 20, 60));
    }

    private CustomTextField createCustomTextField() {
        CustomTextField textField = new CustomTextField(10);
        textField.setCaret(new CustomCaret(Color.BLACK));
        textField.setBackground(new Color(255, 255, 255));
        textField.setBorderColor(Color.BLACK);
        textField.setForeground(Color.BLACK);
        ((AbstractDocument) textField.getDocument()).setDocumentFilter(new NumericDocumentFilter());
        return textField;
    }

    private JButton createButton(String text, Color backgroundColor) {
        JButton button = new JButton(text);
        button.setBackground(backgroundColor);
        button.setForeground(Color.WHITE);
        return button;
    }

    private JLabel createLabel(String text, int style, int fontSize) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", style, fontSize));
        return label;
    }

    private void startTimer() {
        timer = new Timer(100, e -> update());
        timer.start();
    }

    private void update() {
        updateOvniTouched();
        updateLabels();
        updateOvniCounts();
    }

    private void updateOvniTouched() {
        this.ovniTouched = loopPanel.getOvniToucheded();
    }

    private void updateLabels() {
        if (ovniTouched != null) {
            title.setText("Ovni Tocado");
            color.setText("Color: " + ovniTouched.getColor().getRed() + " " + ovniTouched.getColor().getGreen() + " " + ovniTouched.getColor().getBlue());
            speed.setText("Velocidad: " + (int) ovniTouched.getSpeed());
            x1.setText("X: " + ovniTouched.getX());
            y1.setText("Y: " + ovniTouched.getY());
            ovnisHome.setText("En casa: " + ovnisManager.getOvnisOnHome().size());
        } else {
            resetLabels();
        }
    }

    private void resetLabels() {
        title.setText("No hay ovni");
        color.setText("Color: 00000");
        speed.setText("Velocidad: ");
        x1.setText("X: 0");
        y1.setText("Y: 0");
    }

    private void updateOvniCounts() {
        movingOvnisLabel.setText("En movimiento: " + ovnisManager.getMovingOvnisCount());
        crashedOvnisLabel.setText("Chocados: " + ovnisManager.getCrashedOvnisCount());
    }

    private void addComponent(Component component, int x, int y) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(component, gbc);
    }

    private void addListeners() {
        btnB.addActionListener(e -> closeWindow());
        btnA.addActionListener(e -> changeOvniSpeed());
        showTrajectoriesCheckBox.addActionListener(e -> ovnisManager.setShowTrajectories(showTrajectoriesCheckBox.isSelected()));
    }

    private void closeWindow() {
        Window window = SwingUtilities.getWindowAncestor(this);
        if (window != null) {
            window.dispose();
        }
    }

    private void changeOvniSpeed() {
        if (ovniTouched != null) {
            ovniTouched.setSpeed(Integer.parseInt(txtVel.getText()));
        }
    }

    private void addComponentsToPanel() {
        addComponent(title, 0, 0);
        addComponent(color, 0, 1);
        addComponent(speed, 0, 2);
        addComponent(x1, 0, 3);
        addComponent(y1, 0, 4);
        addComponent(movingOvnisLabel, 0, 5);
        addComponent(crashedOvnisLabel, 0, 6);
        addComponent(ovnisHome, 0, 7);
        addComponent(txtVel, 0, 8);
        addComponent(showTrajectoriesCheckBox, 0, 9);
        addComponent(btnA, 0, 10);
        addComponent(btnB, 0, 11);
    }
}