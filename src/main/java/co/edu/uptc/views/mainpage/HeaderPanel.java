package co.edu.uptc.views.mainpage;

import co.edu.uptc.interfaces.Interfaces;
import co.edu.uptc.views.tables.byCity.MainTwo;
import co.edu.uptc.views.wildCardClasses.CustomButton;
import co.edu.uptc.views.wildCardClasses.Global;
import co.edu.uptc.views.wildCardClasses.LabelHeader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HeaderPanel extends JPanel{
    private JPanel headerLabelsPanel;
    private JPanel titlePanel;
    private final MainPageFrame mainPageFrame;
    private final Interfaces.Presenter presenter;

    public HeaderPanel(MainPageFrame mainPageFrame, Interfaces.Presenter presenter) {
        this.mainPageFrame = mainPageFrame;
        this.presenter = presenter;
        initComponents();
        createPanelHeaderLabels();
        createLabel();
        createTitlePanel();
        createLblTitle();
        createButtonExit();
    }
    private void initComponents(){
        this.setVisible(true);
        this.setBackground(Global.HEADER_BACKGROUND_COLOR);
        this.setLayout(new BorderLayout());
        setPreferredSize(new Dimension(0, getHeaderSize()));
    }
    private int getHeaderSize(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double height = screenSize.getHeight();
        return (int)(height * 0.18);
    }
    private void createPanelHeaderLabels(){
        headerLabelsPanel = new JPanel();
        FlowLayout layout = new FlowLayout(FlowLayout.RIGHT, 90, 45);
        headerLabelsPanel.setLayout(layout);
        headerLabelsPanel.setBackground(Global.HEADER_BACKGROUND_COLOR);
        this.add(headerLabelsPanel, BorderLayout.CENTER);
    }
    private void createLabel(){
        JLabel label =  new LabelHeader("Tablas de datos");
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                addByCity();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                label.setForeground(Global.WORK_BACKGROUND_COLOR);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                label.setForeground(Global.HEADER_TEXT_COLOR);
            }
        });
        headerLabelsPanel.add(label);
    }

    private void createTitlePanel(){
        titlePanel = new JPanel();
        titlePanel.setBackground(Global.HEADER_BACKGROUND_COLOR);
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.X_AXIS));
        this.add(titlePanel, BorderLayout.WEST);
    }
    private void createLblTitle(){
        JLabel label = new JLabel("Vizualizacion de datos de departamentos");
        titlePanel.add(Box.createHorizontalStrut(50));
        label.setFont(Global.FONT_TITLE_NORMAL);
        label.setForeground(Global.HEADER_TEXT_COLOR);
        titlePanel.add(label);
    }
    private void createButtonExit(){
        CustomButton button = new CustomButton("Salir");
        button.addActionListener(e -> System.exit(0));
        headerLabelsPanel.add(button);
    }
    private void addByCity(){
        MainTwo mainTwo = new MainTwo(mainPageFrame, presenter);
        mainTwo.setVisible(true);
    }
}
