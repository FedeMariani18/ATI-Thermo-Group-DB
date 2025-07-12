package it.unibo.common;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ButtonFactory {
    public final static JButton createButton(String text, Runnable action) {
        JButton button = new JButton(text);
        button.setFont(Constants.BUTTON_FONT);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action.run();
            }
        });
        return button;
    }
}
