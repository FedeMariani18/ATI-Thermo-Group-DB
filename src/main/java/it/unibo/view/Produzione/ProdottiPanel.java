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

import it.unibo.common.ButtonFactory;
import it.unibo.common.Constants;
import it.unibo.controller.Controller;
import it.unibo.data.Articolo;
import it.unibo.data.Prodotto;

public class ProdottiPanel extends JPanel {
    private DefaultTableModel modelProdotti;
    private JTable tableProdotti;
    private DefaultTableModel modelArticoli;
    private JTable tableArticoli;
    private final Controller controller;

    public ProdottiPanel(Controller controller) {
        this.controller = controller;
        setBackground(Color.CYAN);
        setLayout(new BorderLayout());
        
        JButton btnAggiungiProdotto = ButtonFactory.createButton("AggiungiProdotto", () -> controller.goToAggiuntaProdottoPanel());
        add(btnAggiungiProdotto, BorderLayout.NORTH);

        JButton btnBack = Constants.backButton(() -> controller.goToProduzionePanel());
        this.add(btnBack, BorderLayout.SOUTH);
        add(tablePanel(), BorderLayout.CENTER);
        refreshTableProdotti();
        refreshTableArticoli();
    }

    private JPanel tablePanel() {
        JPanel tPanel = new JPanel();
        tPanel.setLayout(new java.awt.GridLayout(2, 1));  // 2 righe, 1 colonna

        modelProdotti = new DefaultTableModel(new String[]{"id prodotto", "prezzo listino", "descrizione", "peso", "superficie",
        "prezzo inventario", "codice a barre", "nome stato", "id gruppo"}, 0) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        };
        tableProdotti = new JTable(modelProdotti);

        modelArticoli = new DefaultTableModel(new String[]{"id prodotto", "id seriale", "id_magazzino",
         "numero scansia", "colonna", "piano", "id bolla vendita","id bolla acquisto"}, 0) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        };
        tableArticoli = new JTable(modelArticoli);

        tableProdotti.getSelectionModel().addListSelectionListener(event -> {
            if (!event.getValueIsAdjusting()) {
                refreshTableArticoli();
            }
        });
        tPanel.add(new JScrollPane(tableProdotti));
        tPanel.add(new JScrollPane(tableArticoli));
        return tPanel;
    }

    private void refreshTableProdotti() {
        modelProdotti.setRowCount(0);
        List<Prodotto> prodotti = controller.getModel().loadProdotti();
        for (Prodotto p : prodotti) {
            modelProdotti.addRow(new Object[]{
                p.id_prodotto,
                p.prezzo_listino,
                p.descrizione,
                p.peso,
                p.superficie,
                p.prezzo_inventario,
                p.codice_a_barre,
                p.nome_stato,
                p.id_gruppo
            });
        }
    }

    private void refreshTableArticoli() {
        modelArticoli.setRowCount(0);
        if(tableProdotti.getRowCount() == 0) {
            return; // No products to show articles for
        }
        int row = tableProdotti.getSelectedRow()>= 0? tableProdotti.getSelectedRow() : 0;
        int id_prodotto = (int)modelProdotti.getValueAt(row, 0);
        List<Articolo> articoli = controller.getModel().loadArticoliByProducts(id_prodotto);
        for (Articolo a : articoli) {
            modelArticoli.addRow(new Object[]{
                a.id_prodotto,
                a.id_seriale,
                a.id_magazzino,
                a.numero_scansia,
                a.colonna,
                a.piano,
                a.id_bolla_vendita,
                a.id_bolla_acquisto
            });
        }
    }
}
