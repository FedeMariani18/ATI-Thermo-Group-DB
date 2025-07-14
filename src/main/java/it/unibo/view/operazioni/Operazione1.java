package it.unibo.view.operazioni;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.Box;
import javax.swing.table.DefaultTableModel;

import it.unibo.common.Constants;
import it.unibo.controller.Controller;

public class Operazione1 extends JPanel{
    private DefaultTableModel model;
    private JTable table;
    private final Controller controller;

    public Operazione1(Controller controller) {
        this.controller = controller;
        setBackground(Color.CYAN);
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Produzione Panel");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("SansSerif", Font.BOLD, 16));
        add(label, BorderLayout.NORTH);

        // Form in alto
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.X_AXIS));
        formPanel.setBackground(Color.CYAN);
        formPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 30, 10, 30));

        JLabel idArticoloLabel = new JLabel("ID Articolo:");
        idArticoloLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        JTextField idArticoloField = new JTextField();
        idArticoloField.setMaximumSize(new Dimension(120, 30));
        JButton cercaButton = new JButton("Cerca");
        cercaButton.setFont(new Font("SansSerif", Font.PLAIN, 14));
        cercaButton.setMaximumSize(new Dimension(100, 30));

        formPanel.add(idArticoloLabel);
        formPanel.add(Box.createHorizontalStrut(10));
        formPanel.add(idArticoloField);
        formPanel.add(Box.createHorizontalStrut(20));
        formPanel.add(cercaButton);

        add(formPanel, BorderLayout.PAGE_START);

        // Tabella sotto
        model = new DefaultTableModel(new Object[]{"TempoEffettivo", "TempoStimato"}, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 30, 10, 30));
        add(scrollPane, BorderLayout.CENTER);

        JButton btnBack = Constants.backButton(() -> controller.goToOperazioniPanel());
        this.add(btnBack, BorderLayout.SOUTH);

        cercaButton.addActionListener(e -> {
            int idArticolo = Integer.parseInt(idArticoloField.getText());
            model.setRowCount(0);
            List<Integer> list = controller.getModel().tempoPerArticolo(idArticolo);
            if (!list.isEmpty()) {
                int tempoEffettivo = list.get(0);
                int tempoStimato = list.get(1);
                model.addRow(new Object[]{
                    tempoEffettivo,
                    tempoStimato
                });
            } else {
                javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Nessun risultato trovato per l'ID inserito.",
                    "Errore",
                    javax.swing.JOptionPane.ERROR_MESSAGE
                );
            }
        });
    }
}
