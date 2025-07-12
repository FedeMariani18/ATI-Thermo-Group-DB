package it.unibo;

import it.unibo.controller.Controller;
import it.unibo.data.DAOUtils;
import it.unibo.model.DBModel;

public class App {
    
    private App() { }

    public static void main(String[] args) {
        
        Controller controller = new Controller();
        controller.goToMenuPanel();
    } 
}
