package co.edu.uptc.presenter;

import co.edu.uptc.interfaces.Interfaces;

public class Presenter implements Interfaces.Presenter {
    private Interfaces.Model model;
    private Interfaces.View view;
    private Object[][] dataForQuantity;
    public Presenter() {
    }

    @Override
    public Object[] obtainRootsByDepartment() {
        return new Object[0];
    }

    @Override
    public void setModel(Interfaces.Model model) {
        this.model=model;
    }

    @Override
    public void setView(Interfaces.View view) {
        this.view=view;
    }

    @Override
    public void start() {

    }
}
