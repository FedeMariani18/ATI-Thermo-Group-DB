package it.unibo.view.Menu;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import it.unibo.common.Constants;
import it.unibo.controller.Controller;

public class RisorseUmanePanel extends JPanel {
    private final Controller controller;
    
    public RisorseUmanePanel(Controller controller) {
        this.controller = controller;
        // Initialize the panel with components related to production
        setLayout(new BorderLayout());
        setBackground(Color.CYAN);
        JLabel label = new JLabel("Risorse Umane");
        add(label, BorderLayout.NORTH);

        JButton btnBack = Constants.backButton(() -> controller.goToMenuPanel());
        this.add(btnBack, BorderLayout.SOUTH);
    }
}
