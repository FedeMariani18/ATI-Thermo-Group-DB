package it.unibo.controller;

import it.unibo.data.DAOUtils;
import it.unibo.model.DBModel;
import it.unibo.view.MainFrame;

public class Controller {
    private MainFrame mainFrame;
    private DBModel model;

    public Controller() {
        var connection = DAOUtils.localMySQLConnection("ati_thermo_group", "root", "");
        model = new DBModel(connection, this);
        mainFrame = new MainFrame(this);
    }

    public DBModel getModel() {
        return model;
    }
    
    public void goToMenuPanel() {
        mainFrame.setPanel(mainFrame.getMenuPanel());
    }

    //PRODUZIONE
    public void goToProduzionePanel() {
        mainFrame.setPanel(mainFrame.getProduzionePanel());    
    }

    public void goToProdottiPanel() {
        mainFrame.setPanel(mainFrame.getProdottiPanel());    
    }

    public void goToSchedeDiLavorazionePanel() {
        mainFrame.setPanel(mainFrame.getSchedeDiLavorazionePanel());    
    }

    public void goToDistintaBasePanel() {
        mainFrame.setPanel(mainFrame.getDistintaBasePanel());    
    }

    public void goToDistintaBasePassaggiPanel() {
        mainFrame.setPanel(mainFrame.getDistintaBasePassaggiPanel());    
    }

    public void goToAggiuntaProdottoPanel() {
        mainFrame.setPanel(mainFrame.getAggiuntaProdottoPanel());
    }

    public void goToAggiungiSchedaPanel() {
        mainFrame.setPanel(mainFrame.getAggiungiSchedaPanel());
    }

    //COMPRA VENDITA
    public void goToCompraVenditaPanel() {
        mainFrame.setPanel(mainFrame.getCompraVenditaPanel());    
    }

    public void goToVenditePanel() {
        mainFrame.setPanel(mainFrame.getVenditePanel());
    }

    public void goToAcquistiPanel() {
        mainFrame.setPanel(mainFrame.getAcquistiPanel());
    }

    public void goToOrdiniPanel() {
        mainFrame.setPanel(mainFrame.getOrdiniPanel());
    }

    public void goToUtentiMercatoPanel() {
        mainFrame.setPanel(mainFrame.getUtentiMercatoPanel());
    }

    public void goToBollaAcquistiPanel() {
        mainFrame.setPanel(mainFrame.getBollaAcquistiPanel());
    }

    //RISORSE UMANE
    public void goToRisorseUmanePanel() {
        mainFrame.setPanel(mainFrame.getRisorseUmanePanel());    
    }

    public void goToDipendentiPanel() {
        mainFrame.setPanel(mainFrame.getDipendentiPanel());
    }

    //MAGAZZINO
    public void goToMagazzinoPanel() {
        mainFrame.setPanel(mainFrame.getMagazzinoPanel());    
    }

    public void goToMagazziniPanel() {
        mainFrame.setPanel(mainFrame.getMagazziniPanel());
    }

    //OPERAZIONI

    public void goToOperazioniPanel() {
        mainFrame.setPanel(mainFrame.getOperazioniPanel());
    }

    public void goToOperazioni1Panel() {
        mainFrame.setPanel(mainFrame.getOperazioni1Panel());
    }

    public void goToOperazioni2Panel() {
        mainFrame.setPanel(mainFrame.getOperazioni2Panel());
    }

    public void goToOperazioni3Panel() {
        mainFrame.setPanel(mainFrame.getOperazioni3Panel());
    }
}
