package co.edu.uptc.views.pages;

import co.edu.uptc.interfaces.Interfaces;
import co.edu.uptc.models.NumericDocumentFilter;
import co.edu.uptc.models.OvnisManager;
import co.edu.uptc.views.wildCardClasses.CustomButton2;
import co.edu.uptc.views.wildCardClasses.CustomTextField;
import co.edu.uptc.views.wildCardClasses.Global;
import javax.swing.*;
import javax.swing.text.AbstractDocument;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class AskFrame extends JFrame implements Interfaces.View {
    Interfaces.Presenter presenter;

    private void initWorkPanel() {
        this.setTitle("Yaoi's game");
        this.setBackground(new Color(4, 13, 18));
        this.setUndecorated(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setSize(300, 200);
        this.setLocationRelativeTo(null);
    }
    private void createPanel() {
        JPanel panel = createMainPanel();
        GridBagConstraints gbc = createGridBagConstraints();
        addComponentsToPanel(panel, gbc);
        this.add(panel, BorderLayout.CENTER);
    }
    private JPanel createMainPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Global.ASK_COLOR_BACKGROUND);
        return panel;
    }
    private GridBagConstraints createGridBagConstraints() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        return gbc;
    }
    private void addComponentsToPanel(JPanel panel, GridBagConstraints gbc) {
        JLabel lblNumOvnis = createLabel("N° Ovnis:");
        JTextField txtNumOvnis = createTextField();
        JLabel lblTNew = createLabel("T(ms) Aparicion:");
        JTextField txtTNew = createTextField();
        JLabel lblVel = createLabel("Velocidad:");
        JTextField txtVel = createTextField();
        JButton btnA = createAcceptButton(txtTNew, txtVel, txtNumOvnis);
        JButton btnB = createCancelButton();
        addComponent(panel, lblNumOvnis, gbc, 0, 0);
        addComponent(panel, txtNumOvnis, gbc, 1, 0);
        addComponent(panel, lblTNew, gbc, 0, 1);
        addComponent(panel, txtTNew, gbc, 1, 1);
        addComponent(panel, lblVel, gbc, 0, 2);
        addComponent(panel, txtVel, gbc, 1, 2);
        addComponent(panel, btnA, gbc, 0, 3);
        addComponent(panel, btnB, gbc, 1, 3);
    }
    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setForeground(Color.WHITE);
        return label;
    }
    private JTextField createTextField() {
        JTextField textField = new CustomTextField(10);
        ((AbstractDocument) textField.getDocument()).setDocumentFilter(new NumericDocumentFilter());
        return textField;
    }

    private JButton createAcceptButton(JTextField txtTNew, JTextField txtVel, JTextField txtNumOvnis) {
        JButton btnA = new CustomButton2("Aceptar");
        btnA.addActionListener(e -> {
            if (txtTNew.getText().trim().isEmpty() || txtVel.getText().trim().isEmpty() || txtNumOvnis.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ningun campo puede estar vacío", "Advertencia", JOptionPane.WARNING_MESSAGE);
                txtNumOvnis.requestFocus();}else {
                int ovnisCant = Integer.parseInt(txtNumOvnis.getText());
                int ovnisTime = Integer.parseInt(txtTNew.getText());
                int ovnisSpeed = Integer.parseInt(txtVel.getText());
                presenter.ovnisParam(ovnisCant, ovnisTime, ovnisSpeed);
                this.dispose();
            }
        });
        return btnA;
    }
    private JButton createCancelButton() {
        JButton btnB = new CustomButton2("Cancelar");
        btnB.addActionListener(e -> this.dispose());
        return btnB;
    }

    private void addComponent(JPanel panel, Component component, GridBagConstraints gbc, int x, int y) {
        gbc.gridx = x;
        gbc.gridy = y;
        panel.add(component, gbc);
    }
    @Override
    public void start() {
        initWorkPanel();
        createPanel();
        setVisible(true);
    }

    @Override
    public void setPresenter(Interfaces.Presenter presenter) {
        this.presenter = presenter;
    }
}
