package Controller.State;

import Controller.MainController;

import java.io.IOException;

public abstract class State {
    protected MainController mainController;

    public State(MainController mainController) {
        this.mainController = mainController;
    }

    public abstract void run() throws IOException;
}