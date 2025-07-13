package it.unibo.common;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public final class Constants {
    public static final int FRAME_WIDTH = 800;
    public static final int FRAME_HEIGHT = 600;

    public static final Font BUTTON_FONT = new Font("Arial", Font.BOLD, 20);

    public static JButton backButton(Runnable action) {
        JButton backButton = new JButton("Back");
        backButton.setFont(BUTTON_FONT);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action.run();
            }
        });
        return backButton;
    }
}
