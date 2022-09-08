package com.example.gui;

import com.example.events.SettingsClickAction;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.InputStream;

public class OptionWindow extends JFrame {

    public OptionWindow() {
        super();
        this.setTitle("Option dialog");
        this.setSize(new Dimension(350, 150));
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel OptionPanel = new JPanel();
        OptionPanel.setLayout(null);
        OptionPanel.setPreferredSize(new Dimension(100, 150));

        JLabel label_text = new JLabel("Choose option");
        label_text.setBounds(40, 10, 120, 30);

        JButton button_settings = new JButton("Settings");
        button_settings.setBounds(70, 60, 85, 25);
        button_settings.setFocusable(false);
        button_settings.addActionListener(new SettingsClickAction(this));

        JButton button_close = new JButton("Close");
        button_close.setBounds(163, 60, 85, 25);
        button_close.setFocusable(false);
        button_close.setMnemonic(KeyEvent.VK_X);
        button_close.addActionListener(ActionEvent -> {
            System.exit(0);
        });
        try {
            InputStream iconStream = OptionWindow.class.getResourceAsStream("icons/mark.png");
            BufferedImage iconBuffer = ImageIO.read(iconStream);
            label_text.setIcon(new ImageIcon(iconBuffer));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        OptionPanel.add(label_text);
        OptionPanel.add(button_settings);
        OptionPanel.add(button_close);

        this.add(Box.createVerticalGlue());
        this.add(OptionPanel);
        this.add(Box.createVerticalGlue());
    }
}