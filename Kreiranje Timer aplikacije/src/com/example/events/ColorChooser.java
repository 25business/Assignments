package com.example.events;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorChooser {

    public static void colorChooser(JColorChooser jcc, JButton color_button, JLabel current_time) {
        color_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog dialog = JColorChooser.createDialog(null, "Choose color", true, jcc, new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        current_time.setForeground(jcc.getColor());
                    }}, null);
                dialog.setVisible(true);
            }
        });
    }
}