package it.unibo.controller;

import it.unibo.view.MainFrame;

public class Controller {
    private MainFrame mainFrame;

    public Controller() {
        mainFrame = new MainFrame(this);
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
