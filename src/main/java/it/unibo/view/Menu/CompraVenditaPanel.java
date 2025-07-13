package it.unibo.view.menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import it.unibo.common.ButtonFactory;
import it.unibo.common.Constants;
import it.unibo.controller.Controller;

public class CompraVenditaPanel extends JPanel {
    private final Controller controller;
    
    public CompraVenditaPanel(Controller controller) {
        this.controller = controller;
        // Initialize the panel with components related to production
        setLayout(new BorderLayout());
        setBackground(Color.CYAN);
        JLabel label = new JLabel("Compra Vendita");
        add(label, BorderLayout.NORTH);

        JButton btnBack = Constants.backButton(() -> controller.goToMenuPanel());
        this.add(btnBack, BorderLayout.SOUTH);
        this.add(buttonsPanel(), BorderLayout.CENTER);
    }

    private JPanel buttonsPanel() {
        JPanel buttonPanel = new JPanel();
        List<JButton> buttons = List.of(
            ButtonFactory.createButton("Vendite", () -> controller.goToVenditePanel()),
            ButtonFactory.createButton("Acquisti", () -> controller.goToAcquistiPanel()),
            ButtonFactory.createButton("Ordini", () -> controller.goToOrdiniPanel()),
            ButtonFactory.createButton("Clienti", () -> controller.goToClientiPanel()),
            ButtonFactory.createButton("Venditori", () -> controller.goToVenditoriPanel())    
        );
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        
        buttonPanel.add(Box.createVerticalGlue());
        buttons.forEach(btn -> {
            btn.setAlignmentX(Component.CENTER_ALIGNMENT);
            buttonPanel.add(btn);
            buttonPanel.add(Box.createVerticalStrut(20)); // Spazio verticale tra i pulsanti
        });
        buttonPanel.add(Box.createVerticalGlue());
        buttonPanel.setBackground(Color.CYAN);
        return buttonPanel;
    }
}
