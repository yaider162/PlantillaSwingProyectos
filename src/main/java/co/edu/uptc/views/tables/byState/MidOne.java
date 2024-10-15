package co.edu.uptc.views.tables.byState;

import co.edu.uptc.interfaces.Interfaces;
import co.edu.uptc.views.tables.Table;
import co.edu.uptc.views.wildCardClasses.Global;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;

@Getter
public class MidOne extends JPanel {
    private Table tableByDateAppointments;
    private final Interfaces.Presenter presenter;

    public MidOne(Interfaces.Presenter presenter) {
        this.presenter = presenter;
        initWorkPanel();
    }

    private void initWorkPanel() {
        tableByDateAppointments = new Table();
        tableByDateAppointments.createTable(new String[]{"Departamento", "Ciudad"});
        setBackground(Global.WORK_BACKGROUND_COLOR);
        setForeground(Global.WORK_TEXT_COLOR);
        createTitle();
        createTable();
    }
    private void createTable() {
        JScrollPane scrollPane = new JScrollPane(tableByDateAppointments.getTable());
        scrollPane.setPreferredSize(obtainSizeForTable());
        setTableData();
        add(scrollPane, BorderLayout.CENTER);
    }
    private void createTitle() {
        JPanel subHeaderPanel = new JPanel();
        subHeaderPanel.setBackground(Global.WORK_BACKGROUND_COLOR);
        subHeaderPanel.setLayout(new BoxLayout(subHeaderPanel, BoxLayout.X_AXIS));
        subHeaderPanel.setPreferredSize(obtainSizeForSubHeader());
        createTitle(subHeaderPanel);
        add(subHeaderPanel, BorderLayout.NORTH);
    }
    private void createTitle(JPanel panel) {
        JLabel title = new JLabel("Registros ordenados por departamento-ciudad");
        title.setFont(Global.FONT_TITLE_BIG);
        title.setForeground(Global.WORK_TEXT_COLOR);
        title.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel.add(title);
    }
    private Dimension obtainSizeForTable() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth() * 0.95;
        double height = screenSize.getHeight() * 0.5;
        return new Dimension((int) width, (int) height);
    }
    private Dimension obtainSizeForSubHeader() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth() * 0.95;
        double height = screenSize.getHeight() * 0.1;
        return new Dimension((int) width, (int) height);
    }

    private void setTableData() {
//        Object[][] vehiclesList = co.edu.uptc.presenter.obtainRootsByDepartmentAndCity();
//        for (Object[] datum : vehiclesList) {
//            tableByDateAppointments.putData(datum);
//        }
    }
}
