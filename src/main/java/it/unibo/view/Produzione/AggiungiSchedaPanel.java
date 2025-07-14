package it.unibo.view.produzione;

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
import java.sql.Time;

import it.unibo.common.Constants;
import it.unibo.controller.Controller;
import it.unibo.data.SchedaDiLavorazione;

public class AggiungiSchedaPanel extends JPanel {
    private final Controller controller;

    public AggiungiSchedaPanel(Controller controller) {
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

        JLabel cfL = new JLabel("Codice fiscale");
        cfL.setFont(labelFont);
        JTextField cf = new JTextField();
        cf.setFont(fieldFont);

        JLabel dataLabel = new JLabel("Data:");
        dataLabel.setFont(labelFont);
        JTextField dataField = new JTextField();
        dataField.setFont(fieldFont);

        JLabel prodL = new JLabel("ID prodotto");
        prodL.setFont(labelFont);
        JTextField prod = new JTextField();
        prod.setFont(fieldFont);

        JLabel artL = new JLabel("ID articolo");
        artL.setFont(labelFont);
        JTextField art = new JTextField();
        art.setFont(fieldFont);

        JLabel inizioL = new JLabel("Orario d'inizio");
        inizioL.setFont(labelFont);
        JTextField inizio = new JTextField();
        inizio.setFont(fieldFont);

        JLabel fineL = new JLabel("Orario di fine");
        fineL.setFont(labelFont);
        JTextField fine = new JTextField();
        fine.setFont(fieldFont);

        JButton submitButton = new JButton("Inserisci");
        submitButton.setFont(labelFont);
        submitButton.setBackground(new Color(0x4CAF50)); // verde elegante
        submitButton.setForeground(Color.WHITE);
        submitButton.setFocusPainted(false);
        submitButton.setBorder(BorderFactory.createEmptyBorder(8, 20, 8, 20));

        // Aggiunta componenti
        formPanel.add(cfL);
        formPanel.add(cf);
        formPanel.add(dataLabel);
        formPanel.add(dataField);
        formPanel.add(prodL);
        formPanel.add(prod);
        formPanel.add(artL);
        formPanel.add(art);
        formPanel.add(inizioL);
        formPanel.add(inizio);
        formPanel.add(fineL);
        formPanel.add(fine);
        formPanel.add(new JLabel()); // cella vuota
        formPanel.add(submitButton);

        add(formPanel, BorderLayout.CENTER);

        JButton btnBack = Constants.backButton(() -> controller.goToSchedeDiLavorazionePanel());
        this.add(btnBack, BorderLayout.SOUTH);

       
        submitButton.addActionListener(e -> {
            int id_prodotto = Integer.parseInt(prod.getText());
            Date data = Date.valueOf(dataField.getText());
            Time ora_inizio = Time.valueOf(inizio.getText());
            Time ora_fine = Time.valueOf(fine.getText());
            int id_articolo = Integer.parseInt(art.getText());
            String codice = cf.getText();
            SchedaDiLavorazione a = new SchedaDiLavorazione(codice, id_prodotto, id_articolo, data, ora_inizio, ora_fine);
            controller.getModel().insertScheda(a);
        });
    }
}
