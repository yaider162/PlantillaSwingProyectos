package co.edu.uptc.presenter;

import co.edu.uptc.interfaces.Interfaces;
import co.edu.uptc.models.OvnisManager;

public class Presenter implements Interfaces.Presenter {
    private Interfaces.Model model;
    private Interfaces.View view;
    private OvnisManager ovnisManager;
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

    @Override
    public void ovnisParam(int ovnisCant, int ovnisTime, int ovnisSpeed) {
        ovnisManager =  new OvnisManager(ovnisCant, ovnisTime, ovnisSpeed);
        System.out.println(ovnisManager);
    }
}
