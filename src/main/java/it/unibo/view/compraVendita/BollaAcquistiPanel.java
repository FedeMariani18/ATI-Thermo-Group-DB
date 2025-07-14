package it.unibo.view.compraVendita;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import java.sql.Date;

import it.unibo.common.Constants;
import it.unibo.controller.Controller;
import it.unibo.data.BollaAcquisto;

public class BollaAcquistiPanel extends JPanel {
    private final Controller controller;

    public BollaAcquistiPanel(Controller controller) {
        this.controller = controller;
        setBackground(Color.CYAN);
        setLayout(new BorderLayout());
        JLabel label = new JLabel("Produzione Panel");
        add(label, BorderLayout.NORTH);

        // Font personalizzati
        Font labelFont = new Font("SansSerif", Font.PLAIN, 14);
        Font fieldFont = new Font("SansSerif", Font.PLAIN, 14);

        // Pannello principale
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        formPanel.setBorder(new EmptyBorder(20, 30, 20, 30)); // padding interno
        formPanel.setBackground(Color.WHITE);

        JLabel idLabel = new JLabel("ID Bolla Acquisto:");
        idLabel.setFont(labelFont);
        JTextField idField = new JTextField();
        idField.setFont(fieldFont);

        JLabel dataLabel = new JLabel("Data:");
        dataLabel.setFont(labelFont);
        JTextField dataField = new JTextField();
        dataField.setFont(fieldFont);

        JLabel pivaLabel = new JLabel("Partita IVA:");
        pivaLabel.setFont(labelFont);
        JTextField pivaField = new JTextField();
        pivaField.setFont(fieldFont);

        JButton submitButton = new JButton("Inserisci");
        submitButton.setFont(labelFont);
        submitButton.setBackground(new Color(0x4CAF50)); // verde elegante
        submitButton.setForeground(Color.WHITE);
        submitButton.setFocusPainted(false);
        submitButton.setBorder(BorderFactory.createEmptyBorder(8, 20, 8, 20));

        // Aggiunta componenti
        formPanel.add(idLabel);
        formPanel.add(idField);
        formPanel.add(dataLabel);
        formPanel.add(dataField);
        formPanel.add(pivaLabel);
        formPanel.add(pivaField);
        formPanel.add(new JLabel()); // cella vuota
        formPanel.add(submitButton);

        add(formPanel, BorderLayout.CENTER);

        JButton btnBack = Constants.backButton(() -> controller.goToCompraVenditaPanel());
        this.add(btnBack, BorderLayout.SOUTH);

       
        submitButton.addActionListener(e -> {
            int id = Integer.parseInt(idField.getText());
            Date data = Date.valueOf(dataField.getText());
            String piva = pivaField.getText();
            BollaAcquisto a = new BollaAcquisto(id, data, piva);
            controller.getModel().insertBollaAcquisto(a);
        });
    }
}
