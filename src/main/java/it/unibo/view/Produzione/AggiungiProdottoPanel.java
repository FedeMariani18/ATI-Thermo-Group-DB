package it.unibo.view.produzione;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.math.BigDecimal;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import it.unibo.common.Constants;
import it.unibo.controller.Controller;
import it.unibo.data.*;

public class AggiungiProdottoPanel extends JPanel {
    private final Controller controller;

    private JTextField txtPrezzoListino;
    private JTextField txtDescrizione;
    private JTextField txtPeso;
    private JTextField txtSuperficie;
    private JTextField txtPrezzoInventario;
    private JTextField txtCodiceABarre;
    private JComboBox<String> comboNomeStato;
    private JComboBox<String> comboIdGruppo;

    List<String> nomiStati = importStati();
    List<Gruppo> gruppi = importGruppi();

    public AggiungiProdottoPanel(Controller controller) {
        this.controller = controller;
        setBackground(Color.CYAN);
        setLayout(new BorderLayout());
        
        JLabel label = new JLabel("Aggiungi Prodotto Panel");
        add(label, BorderLayout.NORTH);

        add(formPanel(), BorderLayout.CENTER);
        
        JButton btnBack = Constants.backButton(() -> controller.goToProduzionePanel());
        add(btnBack, BorderLayout.SOUTH);
    }

    private JPanel formPanel() {
        JPanel formPanel = new JPanel();
        
        formPanel.setLayout(new GridLayout(18, 1, 5, 5));

        // Inizializzazione componenti
        txtPrezzoListino = new JTextField();
        txtDescrizione = new JTextField();
        txtPeso = new JTextField();
        txtSuperficie = new JTextField();
        txtPrezzoInventario = new JTextField();
        txtCodiceABarre = new JTextField();
        
        comboNomeStato = new JComboBox<>(nomiStati.toArray(new String[0]));
        comboIdGruppo = new JComboBox<>(gruppi.stream().map(g -> g.descrizione).toArray(String[]::new));

        // Etichette e campi
        formPanel.add(new JLabel("Prezzo Listino:"));
        formPanel.add(txtPrezzoListino);

        formPanel.add(new JLabel("Descrizione:"));
        formPanel.add(txtDescrizione);

        formPanel.add(new JLabel("Peso:"));
        formPanel.add(txtPeso);

        formPanel.add(new JLabel("Superficie:"));
        formPanel.add(txtSuperficie);

        formPanel.add(new JLabel("Prezzo Inventario:"));
        formPanel.add(txtPrezzoInventario);

        formPanel.add(new JLabel("Codice a Barre:"));
        formPanel.add(txtCodiceABarre);

        formPanel.add(new JLabel("Nome Stato:"));
        formPanel.add(comboNomeStato);

        formPanel.add(new JLabel("ID Gruppo:"));
        formPanel.add(comboIdGruppo);

        // Pulsante per invio
        JButton btnSubmit = new JButton("Salva");
        btnSubmit.addActionListener(e -> {
            // Creazione del Prodotto
            Prodotto prodotto = new Prodotto(
                0, // ID sarà generato dal DB
                BigDecimal.valueOf(Double.parseDouble(txtPrezzoListino.getText())),
                txtDescrizione.getText(),
                BigDecimal.valueOf(Double.parseDouble(txtPeso.getText())),
                BigDecimal.valueOf(Double.parseDouble(txtSuperficie.getText())),
                BigDecimal.valueOf(Double.parseDouble(txtPrezzoInventario.getText())),
                txtCodiceABarre.getText(),
                comboNomeStato.getSelectedItem().toString(),
                gruppi.stream().filter(g -> g.descrizione.equals(comboIdGruppo.getSelectedItem().toString()))
                    .findFirst()
                    .map(g -> g.id_gruppo)
                    .orElse(null)
                
            );
            // Inserimento del Prodotto nel DB
            controller.getModel().insertProdotto(prodotto);
            // Ritorno al pannello precedente
            controller.goToProduzionePanel();
        });
        formPanel.add(btnSubmit);


        return formPanel;
    }

    private List<String> importStati() {
        return controller.getModel().loadNomiStatiDiLavorazione();
    }

    private List<Gruppo> importGruppi() {
        return controller.getModel().loadGruppi();
    }
}
