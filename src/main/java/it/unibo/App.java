package it.unibo;

import it.unibo.controller.Controller;

public class App {
    
    private App() { }

    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.goToMenuPanel();
    }
}
