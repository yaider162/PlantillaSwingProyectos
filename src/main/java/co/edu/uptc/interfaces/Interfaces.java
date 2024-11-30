package co.edu.uptc.interfaces;


import co.edu.uptc.models.OvnisManager;

public interface Interfaces {
    interface Model {
    }
    interface View {
        void start();
        void setPresenter(Presenter presenter);
    }
    interface Presenter {
        void setModel(Model model);
        Model getModel();
        void setView(View view);
        void ovnisParam(int ovnisCant, int ovnisTime, int ovnisSpeed, java.awt.Color ovnisColor);

        OvnisManager getOvnisManager();
    }
}