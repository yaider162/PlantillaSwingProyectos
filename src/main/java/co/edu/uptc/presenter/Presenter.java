package co.edu.uptc.presenter;

import co.edu.uptc.interfaces.Interfaces;
import co.edu.uptc.models.OvnisManager;
import co.edu.uptc.views.mainpage.MainPageFrame;

public class Presenter implements Interfaces.Presenter {
    private Interfaces.Model model;
    private Interfaces.View view;
    private OvnisManager ovnisManager;
    private MainPageFrame mainPageFrame;
    @Override
    public void setModel(Interfaces.Model model) {
        this.model=model;
    }
    @Override
    public void setView(Interfaces.View view) {
        this.view=view;
        if (view instanceof MainPageFrame) {
            mainPageFrame = (MainPageFrame) view;
        }
    }
    @Override
    public void start() {
    }
    @Override
    public void ovnisParam(int ovnisCant, int ovnisTime, int ovnisSpeed) {
        ovnisManager =  new OvnisManager(ovnisCant, ovnisTime, ovnisSpeed);
        mainPageFrame.initGame(ovnisManager);
        System.out.println(ovnisManager);
    }
}
