package it.unibo.view;

import javax.swing.JPanel;

import it.unibo.controller.Controller;
import it.unibo.view.Menu.*;

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

    public JPanel getProdottiPanel() {
        return new ProduzionePanel(controller);
    }

    public JPanel getMenuPanel() {
        return new MenuPanel(controller);
    }

    public JPanel getProduzionePanel() {
        return new ProduzionePanel(controller);
    }

    public JPanel getCompraVenditaPanel() {
        return new CompraVenditaPanel(controller);
    }

    public JPanel getRisorseUmanePanel() {
        return new RisorseUmanePanel(controller);
    }

    public JPanel getMagazzinoPanel() {
        return new MagazzinoPanel(controller);    
    }
}
