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
import it.unibo.data.DistintaBasePassaggi;

public class DistintaBasePassaggiPanel extends JPanel {
    private static final long serialVersionUID = 1L; // Added for serialization
    private DefaultTableModel model;
    private JTable table;
    private final Controller controller;

    public DistintaBasePassaggiPanel(Controller controller) {
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
        tPanel.setLayout(new java.awt.GridLayout(1, 1));

        model = new DefaultTableModel(new String[]{"nome passaggio", "id prodotto", "stima durata"}, 0) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        };
        table = new JTable(model);

        tPanel.add(new JScrollPane(table));

        return tPanel;
    }

    private void refreshTable() {
        model.setRowCount(0);
        List<DistintaBasePassaggi> distinte = controller.getModel().loadDistintePassaggi();
        for (DistintaBasePassaggi p : distinte) {
            model.addRow(new Object[]{
                p.nome_passaggio,
                p.id_prodotto,
                p.stima_durata,
            });
        }
    }
}
