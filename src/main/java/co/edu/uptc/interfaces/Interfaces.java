package co.edu.uptc.interfaces;


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
        void start();
        void ovnisParam(int ovnisCant, int ovnisTime, int ovnisSpeed, java.awt.Color ovnisColor);
    }
}