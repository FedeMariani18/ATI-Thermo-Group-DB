package it.unibo.view;

import javax.swing.JPanel;

import it.unibo.controller.Controller;
import it.unibo.view.compraVendita.*;
import it.unibo.view.menu.*;
import it.unibo.view.operazioni.Operazione1;
import it.unibo.view.operazioni.Operazione2;
import it.unibo.view.operazioni.Operazione3;
import it.unibo.view.operazioni.Operazione4;
import it.unibo.view.produzione.*;
import it.unibo.view.magazzino.*;
import it.unibo.view.risorseUmane.*;

import javax.swing.JFrame;
import java.awt.*;

public class MainFrame {
    private final Controller controller;
    private final int width = 800;
    private final int height = 600;
    private JFrame frame;
    private JPanel panel; 

    public MainFrame(final Controller controller) {
        this.controller = controller;
        frame = new JFrame("Main Frame");
        frame.setPreferredSize(new Dimension(width, height));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void setPanel(JPanel newPanel) {
        this.panel = newPanel;
        frame.setContentPane(panel);
        frame.revalidate();
        frame.repaint();
        panel.requestFocus();
        this.frame.pack();
        this.frame.setVisible(true);
    }

    public JPanel getMenuPanel() {
        return new MenuPanel(controller);
    }

    //PRODUZIONE
    public JPanel getProduzionePanel() {
        return new ProduzionePanel(controller);
    }

    public JPanel getProdottiPanel() {
        return new ProdottiPanel(controller);
    }

    public JPanel getSchedeDiLavorazionePanel() {
        return new SchedeDiLavorazionePanel(controller);
    }

    public JPanel getDistintaBasePanel() {
        return new DistintaBasePanel(controller);
    }

    public JPanel getDistintaBasePassaggiPanel() {
        return new DistintaBasePassaggiPanel(controller);
    }

    public JPanel getAggiuntaProdottoPanel() {
        return new AggiungiProdottoPanel(controller);
    }

    public JPanel getAggiungiSchedaPanel() {
        return new AggiungiSchedaPanel(controller);
    }

    //COMPRA VENDITA
    public JPanel getCompraVenditaPanel() {
        return new CompraVenditaPanel(controller);
    }

    public JPanel getVenditePanel() {
        return new VenditePanel(controller);
    }

    public JPanel getAcquistiPanel() {
        return new AcquistiPanel(controller);
    }

    public JPanel getOrdiniPanel() {
        return new OrdiniPanel(controller);
    }

    public JPanel getUtentiMercatoPanel() {
        return new UtentiMercatoPanel(controller);
    }

    public JPanel getBollaAcquistiPanel() {
        return new BollaAcquistiPanel(controller);
    }

    //RISORSE UMANE
    public JPanel getRisorseUmanePanel() {
        return new RisorseUmanePanel(controller);
    }

    public JPanel getDipendentiPanel() {
        return new DipendentiPanel(controller);
    }

    //MAGAZZINO
    public JPanel getMagazzinoPanel() {
        return new MagazzinoPanel(controller);    
    }

    public JPanel getMagazziniPanel() {
        return new MagazziniPanel(controller); 
    }

    //OPERAZIONI

    public JPanel getOperazioniPanel() {
        return new OperazioniPanel(controller);
    }

    public JPanel getOperazioni1Panel() {
        return new Operazione1(controller);
    }

    public JPanel getOperazioni2Panel() {
        return new Operazione2(controller);
    }

    public JPanel getOperazioni3Panel() {
        return new Operazione3(controller);
    }

    public JPanel getOperazioni4Panel() {
        return new Operazione4(controller);
    }
}
