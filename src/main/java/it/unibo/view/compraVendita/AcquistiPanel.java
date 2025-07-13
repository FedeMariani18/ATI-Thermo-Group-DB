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
import it.unibo.data.BollaAcquisto;

public class AcquistiPanel extends JPanel{
    private final DefaultTableModel model;
    private final JTable table;
    private final Controller controller;

    public AcquistiPanel(Controller controller) {
        this.controller = controller;
        setBackground(Color.CYAN);
        setLayout(new BorderLayout());
        JLabel label = new JLabel("Produzione Panel");
        add(label, BorderLayout.NORTH);

        JButton btnBack = Constants.backButton(() -> controller.goToCompraVenditaPanel());
        this.add(btnBack, BorderLayout.SOUTH);

        model = new DefaultTableModel(new String[]{"id bolla acqisto", "data", "p_iva"}, 0) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        };
        table = new JTable(model);

        refreshTable();

        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    private void refreshTable() {
        model.setRowCount(0);
        List<BollaAcquisto> acquisti = controller.getModel().loadBolleAcquisti();
        for (BollaAcquisto ba : acquisti) {
            model.addRow(new Object[]{
                ba.id_bolla_acquisto,
                ba.data,
                ba.p_iva
            });
        }
    }
}
