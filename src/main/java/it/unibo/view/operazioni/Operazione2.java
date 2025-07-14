package it.unibo.view.operazioni;

import java.util.List;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import it.unibo.common.Constants;
import it.unibo.controller.Controller;
import it.unibo.data.Categoria;

public class Operazione2 extends JPanel{
    private DefaultTableModel model;
    private JTable table;
    private final Controller controller;
    
    public Operazione2(Controller controller) {
        this.controller = controller;
        setBackground(Color.CYAN);
        setLayout(new BorderLayout());
        JLabel label = new JLabel("Operazioni");
        add(label, BorderLayout.NORTH);

        JButton btnBack = Constants.backButton(() -> controller.goToOperazioniPanel());
        this.add(btnBack, BorderLayout.SOUTH);
        add(tablePanel(), BorderLayout.CENTER);
        refreshTable();
    }

    private JPanel tablePanel() {
        JPanel tPanel = new JPanel();
        tPanel.setLayout(new java.awt.GridLayout(1, 1));

        model = new DefaultTableModel(new String[]{"id_categoria", "descrizione", "numero prodotti venduti"}, 0) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        };
        table = new JTable(model);

        tPanel.add(new JScrollPane(table));

        return tPanel;
    }

    private void refreshTable() {
        model.setRowCount(0);
        List<Categoria> categorie = controller.getModel().categoriaVenduta();
        for (Categoria p : categorie) {
            model.addRow(new Object[]{
                p.id_categoria,
                p.descrizione,
                p.id_categoria_statistica
            });
        }
    }
}
