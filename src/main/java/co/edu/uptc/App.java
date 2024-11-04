package co.edu.uptc;

import co.edu.uptc.presenter.Presenter;
import co.edu.uptc.views.mainpage.MainPageFrame;

public class App {
    public static void main(String[] args) {
        Presenter presenter = new Presenter();
        MainPageFrame mainPageFrame = new MainPageFrame(presenter);
        mainPageFrame.start();
    }
}