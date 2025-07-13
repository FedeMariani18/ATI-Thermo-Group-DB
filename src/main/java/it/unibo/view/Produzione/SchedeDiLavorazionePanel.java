package it.unibo.view.produzione;

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

public class SchedeDiLavorazionePanel extends JPanel{
    private DefaultTableModel model;
    private JTable table;
    private final Controller controller;

    public SchedeDiLavorazionePanel(Controller controller) {
        this.controller = controller;
        setBackground(Color.CYAN);
        setLayout(new BorderLayout());
        JLabel label = new JLabel("Produzione Panel");
        add(label, BorderLayout.NORTH);

        JButton btnBack = Constants.backButton(() -> controller.goToProduzionePanel());
        this.add(btnBack, BorderLayout.SOUTH);
        add(tablePanel(), BorderLayout.CENTER);
        refreshTable();
    }

    private JPanel tablePanel() {
        JPanel tPanel = new JPanel();
        tPanel.setLayout(new java.awt.GridLayout(1, 1));  // 2 righe, 1 colonna

        model = new DefaultTableModel(new String[]{"codice fiscale", "id prodotto", "id seriale", "data", "ora inizio",
        "ora fine"}, 0) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        };
        table = new JTable(model);

        tPanel.add(new JScrollPane(table));

        return tPanel;
    }

    private void refreshTable() {
        // model.setRowCount(0);
        // List<Prodotto> prodotti = controller.getModel().loadProdotti();
        // for (Prodotto p : prodotti) {
        //     model.addRow(new Object[]{
        //         p.id_prodotto,
        //         p.prezzo_listino,
        //         p.descrizione,
        //         p.peso,
        //         p.superficie,
        //         p.prezzo_inventario,
        //         p.codice_a_barre,
        //         p.nome_stato,
        //         p.id_categoria_statistica,
        //         p.id_categoria,
        //         p.id_gruppo
        //     });
        // }
    }
}
