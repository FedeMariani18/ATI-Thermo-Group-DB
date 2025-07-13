package it.unibo.view.risorseUmane;

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
import it.unibo.data.Dipendente;

public class DipendentiPanel extends JPanel {
    private DefaultTableModel model;
    private JTable table;
    private final Controller controller;

    public DipendentiPanel(Controller controller) {
        this.controller = controller;
        setBackground(Color.CYAN);
        setLayout(new BorderLayout());
        JLabel label = new JLabel("Produzione Panel");
        add(label, BorderLayout.NORTH);

        JButton btnBack = Constants.backButton(() -> controller.goToRisorseUmanePanel());
        this.add(btnBack, BorderLayout.SOUTH);
        add(tablePanel(), BorderLayout.CENTER);
        refreshTable();
    }

    private JPanel tablePanel() {
        JPanel tPanel = new JPanel();
        tPanel.setLayout(new java.awt.GridLayout(1, 1));

        model = new DefaultTableModel(new String[]{"codice fiscale", "nome", "cognome", "anno di nascita", "nome ruolo"}, 0) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        };
        table = new JTable(model);

        tPanel.add(new JScrollPane(table));

        return tPanel;
    }

    private void refreshTable() {
        model.setRowCount(0);
        List<Dipendente> dipendenti = controller.getModel().loadDipendenti();
        for (Dipendente p : dipendenti) {
            model.addRow(new Object[]{
                p.codice_fiscale,
                p.nome,
                p.cognome,
                p.anno_di_nascita,
                p.nome_ruolo
            });
        }
    }
}
