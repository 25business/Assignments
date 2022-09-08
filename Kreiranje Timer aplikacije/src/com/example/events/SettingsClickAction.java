package com.example.events;

import com.example.gui.SettingsWindow;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsClickAction implements ActionListener {
    private JFrame optionFrame;

    public SettingsClickAction(JFrame optionFrame) {
        this.optionFrame = optionFrame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        SettingsWindow settingsWindow = new SettingsWindow();
        settingsWindow.setVisible(true);
    }
}