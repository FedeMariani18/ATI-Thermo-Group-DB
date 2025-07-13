package it.unibo.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import it.unibo.common.Constants;

import it.unibo.controller.Controller;

public class MenuPanel extends JPanel {
    private Controller controller;
    private List<JButton> buttons;

    public MenuPanel(Controller controller) {
        this.controller = controller;
        this.buttons = new LinkedList<>();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(Color.BLUE);
        setButtons();
    }

    private void setButtons() {
        
        JButton btnProduzione = new JButton("Produzione");
        btnProduzione.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.goToProduzionePanel();
            }
        });
        
        JButton btnCompaVendita = new JButton("Compra Vendita");
        btnCompaVendita.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.goToCompraVenditaPanel();
            }
        });
        
        JButton btnRisorseUmane = new JButton("Risorse Umane");
        btnRisorseUmane.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.goToRisorseUmanePanel();
            }
        });
        
        JButton btnMagazzino = new JButton("Magazzino");
        btnMagazzino.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.goToMagazzinoPanel();
            }
        });

        JButton btnOperazioni = new JButton("Operazioni");
        btnOperazioni.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.goToOperazioniPanel();
            }
        });

        buttons.addAll(List.of(btnProduzione, btnCompaVendita, btnRisorseUmane, btnMagazzino, btnOperazioni));

        buttons.forEach(button -> {
            button.setAlignmentX(CENTER_ALIGNMENT);
            button.setAlignmentY(CENTER_ALIGNMENT);
            button.setFont(Constants.BUTTON_FONT);
        });

        this.add(Box.createVerticalGlue());
        buttons.forEach(button -> {
            this.add(button);
            this.add(Box.createVerticalStrut(20));
        });
        this.add(Box.createVerticalGlue());
    }

    
}
