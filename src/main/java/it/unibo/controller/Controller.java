package it.unibo.controller;

import it.unibo.data.DAOUtils;
import it.unibo.model.DBModel;
import it.unibo.view.MainFrame;

public class Controller {
    private MainFrame mainFrame;
    private DBModel model;

    public Controller() {
        var connection = DAOUtils.localMySQLConnection("ati-thermo-group", "root", "");
        model = new DBModel(connection, this);
        mainFrame = new MainFrame(this);
    }

    public DBModel getModel() {
        return model;
    }
    
    public void goToMenuPanel() {
        mainFrame.setPanel(mainFrame.getMenuPanel());
    }

    public void goToProduzionePanel() {
        mainFrame.setPanel(mainFrame.getProduzionePanel());    
    }

    public void goToCompraVenditaPanel() {
        mainFrame.setPanel(mainFrame.getCompraVenditaPanel());    
    }

    public void goToRisorseUmanePanel() {
        mainFrame.setPanel(mainFrame.getRisorseUmanePanel());    
    }

    public void goToMagazzinoPanel() {
        mainFrame.setPanel(mainFrame.getMagazzinoPanel());    
    }
    
    public void goToProdottiPanel() {
        mainFrame.setPanel(mainFrame.getProdottiPanel());    
    }
}
