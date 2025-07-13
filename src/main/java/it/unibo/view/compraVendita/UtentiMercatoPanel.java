package it.unibo.view.compraVendita;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import it.unibo.common.Constants;
import it.unibo.controller.Controller;
import it.unibo.data.Prodotto;
import it.unibo.data.UtenteMercato;

public class UtentiMercatoPanel extends JPanel{
    private final DefaultTableModel model;
    private final JTable table;
    private final Controller controller;

    public UtentiMercatoPanel(Controller controller) {
        this.controller = controller;
        setBackground(Color.CYAN);
        setLayout(new BorderLayout());
        JLabel label = new JLabel("Produzione Panel");
        add(label, BorderLayout.NORTH);

        JButton btnBack = Constants.backButton(() -> controller.goToCompraVenditaPanel());
        this.add(btnBack, BorderLayout.SOUTH);

        model = new DefaultTableModel(new String[]{"partita iva", "nome", "nazione", "banca",
        "tipo pagamento", "tipologia utente mercato", "sconto prodotto", "sconto complessivo"}, 0) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        };
        table = new JTable(model);

        refreshTable();

        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    private void refreshTable() {
        model.setRowCount(0);
        List<UtenteMercato> utenti = controller.getModel().loadUtentiMercato();
        for (UtenteMercato u : utenti) {
            model.addRow(new Object[]{
                u.p_iva,
                u.nome,
                u.nazione,
                u.banca,
                u.id_pagamento,
                u.nome_tipologia_utente_mercato,
                u.id_sconto_prodotto,
                u.id_sconto_complessivo
            });
        }
    }
}
