package it.unibo.view.Menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.function.Supplier;

import javax.swing.JPanel;

import it.unibo.common.ButtonFactory;
import it.unibo.common.Constants;

import it.unibo.controller.Controller;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

public class ProduzionePanel extends JPanel{
    private final Controller controller;

    public ProduzionePanel(Controller controller) {
        this.controller = controller;
        // Initialize the panel with components related to production
        setLayout(new BorderLayout());
        setBackground(Color.CYAN);
        JLabel label = new JLabel("Produzione Panel");
        add(label, BorderLayout.NORTH);

        JButton btnBack = Constants.backButton(() -> controller.goToMenuPanel());
        this.add(btnBack, BorderLayout.SOUTH);

        this.add(buttonsPanel(), BorderLayout.CENTER);
    }

    private JPanel buttonsPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        JButton btnProdotti = ButtonFactory.createButton("Prodotti", () -> controller.goToProdottiPanel());
        JButton btnSchedeDiLavorazione = ButtonFactory.createButton("Schede Di Lavorazione", () -> controller.goToProdottiPanel());
        
        buttonPanel.add(Box.createVerticalGlue());
        buttonPanel.add(btnProdotti, CENTER_ALIGNMENT);
        buttonPanel.add(Box.createVerticalStrut(20)); // Spazio verticale
        buttonPanel.add(btnSchedeDiLavorazione, CENTER_ALIGNMENT);
        buttonPanel.add(Box.createVerticalGlue());
        return buttonPanel;
    }
    
}
