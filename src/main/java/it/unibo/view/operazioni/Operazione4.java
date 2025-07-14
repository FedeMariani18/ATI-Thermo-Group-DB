package it.unibo.view.operazioni;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import it.unibo.common.Constants;
import it.unibo.controller.Controller;
import it.unibo.data.Magazzino;

public class Operazione4 extends JPanel{
    private DefaultTableModel model;
    private JTable table;
    private final Controller controller;

    public Operazione4(Controller controller) {
        this.controller = controller;
        setBackground(Color.CYAN);
        setLayout(new BorderLayout());

        JButton btnBack = Constants.backButton(() -> controller.goToOperazioniPanel());
        this.add(btnBack, BorderLayout.SOUTH);
        add(tablePanel(), BorderLayout.CENTER);
        refreshTable();
    }

    private JPanel tablePanel() {
        JPanel tPanel = new JPanel();
        tPanel.setLayout(new java.awt.GridLayout(1, 1));

        model = new DefaultTableModel(new String[]{"id magazzino", "nome", "via", "civico", "nome città", "capacità massima", "capacità residua"}, 0) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        };
        table = new JTable(model);

        tPanel.add(new JScrollPane(table));

        return tPanel;
    }

    private void refreshTable() {
        model.setRowCount(0);
        List<Magazzino> magazzini = controller.getModel().magazziniPieni();
        for (Magazzino p : magazzini) {
            model.addRow(new Object[]{
                p.id_magazzino,
                p.nome,
                p.via,
                p.civico,
                p.nome_citta,
                p.capacita_max,
                p.capacita_residua
            });
        }
    }
}
