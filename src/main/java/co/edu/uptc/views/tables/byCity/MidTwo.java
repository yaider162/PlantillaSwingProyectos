package co.edu.uptc.views.tables.byCity;

import co.edu.uptc.interfaces.Interfaces;
import co.edu.uptc.views.tables.Table;
import co.edu.uptc.views.wildCardClasses.Global;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;

@Getter
public class MidTwo extends JPanel {
    private final Interfaces.Presenter presenter;
    private Table tableByCity;

    public MidTwo(Interfaces.Presenter presenter){
        this.presenter = presenter;
        initWorkPanel();
    }
    private void initWorkPanel() {
        tableByCity = new Table();
        tableByCity.createTable(new String[]{"Departamento"});
        setBackground(Global.WORK_BACKGROUND_COLOR);
        setForeground(Global.WORK_TEXT_COLOR);
        createTitle();
        createTable();
    }
    private void createTable() {
        JScrollPane scrollPane = new JScrollPane(tableByCity.getTable());
        scrollPane.setPreferredSize(obtainSizeForTable());
        setTableData();
        add(scrollPane, BorderLayout.CENTER);
    }
    private void createTitle(){
        JPanel subHeaderPanel = new JPanel();
        subHeaderPanel.setBackground(Global.WORK_BACKGROUND_COLOR);
        subHeaderPanel.setLayout(new BoxLayout(subHeaderPanel, BoxLayout.X_AXIS));
        subHeaderPanel.setPreferredSize(obtainSizeForSubHeader());
        createTitle(subHeaderPanel);
        add(subHeaderPanel, BorderLayout.NORTH);
    }

    private void createTitle(JPanel panel){
        JLabel title = new JLabel("Registros Alfabeto-Departamento: ");
        title.setFont(Global.FONT_TITLE_BIG);
        title.setForeground(Global.WORK_TEXT_COLOR);
        title.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel.add(title);
    }
    private Dimension obtainSizeForTable(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth() * 0.95;
        double height = screenSize.getHeight() * 0.5;
        return new Dimension((int)width, (int)height);
    }
    private Dimension obtainSizeForSubHeader(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth() * 0.95;
        double height = screenSize.getHeight() * 0.1;
        return new Dimension((int)width, (int)height);
    }

    private void setTableData(){
//        Object[] vehiclesList = co.edu.uptc.presenter.obtainRootsByDepartment();
//        for (Object datum : vehiclesList) {
//            tableByCity.putData(new Object[]{datum});
//        }
     }
}
