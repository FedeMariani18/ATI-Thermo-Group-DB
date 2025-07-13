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

public class OrdiniPanel extends JPanel{
    private final DefaultTableModel model;
    private final JTable table;
    private final Controller controller;

    public OrdiniPanel(Controller controller) {
        this.controller = controller;
        setBackground(Color.CYAN);
        setLayout(new BorderLayout());
        JLabel label = new JLabel("Produzione Panel");
        add(label, BorderLayout.NORTH);

        JButton btnBack = Constants.backButton(() -> controller.goToMenuPanel());
        this.add(btnBack, BorderLayout.SOUTH);

        model = new DefaultTableModel(new String[]{"Codice Ordine", "Totale", "Cliente", "Stato"}, 0) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        };
        table = new JTable(model);

        refreshTable();

        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    private void refreshTable() {
        model.setRowCount(0);
        List<Prodotto> prodotti = controller.getModel().loadProdotti();
        for (Prodotto p : prodotti) {
            model.addRow(new Object[]{
                p.id_prodotto,
                p.prezzo_listino,
                p.descrizione,
                p.peso,
                p.superficie,
                p.prezzo_inventario,
                p.codice_a_barre,
                p.nome_stato,
                p.id_categoria_statistica,
                p.id_categoria,
                p.id_gruppo
            });
        }
    }
}
