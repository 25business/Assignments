package com.example.gui;

import com.example.events.ColorChooser;
import com.example.events.CountdownAction;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class SettingsWindow extends JFrame {

    public SettingsWindow() {
        initComponents();
    }
    public static Timer timer2;
    public static int selected_speed = 2000;
    public static Timer on_time_timer;
    public static Timer timer4;
    public static OtherWindow otherWindow = new OtherWindow();
    public static OtherWindow newWindow = new OtherWindow();

    public void initComponents() {
        this.setLayout(null);
        this.setSize(500, 400);
        this.getContentPane().setBackground(new Color(0xED9E59));
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);

        JPanel firstPanel = new JPanel();
        firstPanel.setBackground(new Color(0xEDEDF2));
        firstPanel.setBounds(10, 15, 465, 80);
        firstPanel.setLayout(null);

        ButtonGroup choice = new ButtonGroup();
        JRadioButton time_button = new JRadioButton();
        time_button.setBounds(10, 10, 15, 20);
        choice.add(time_button);

        JRadioButton countdown_button = new JRadioButton();
        countdown_button.setBounds(10, 43, 15, 20);
        choice.add(countdown_button);

        JLabel on_time_label = new JLabel("on time:");
        on_time_label.setForeground(new Color(0xDE563D));
        on_time_label.setBounds(35, 10, 70, 20);
        on_time_label.setFont(new Font("Serif", Font.BOLD, 15));

        JLabel countdown_label = new JLabel("countdown (sec):");
        countdown_label.setForeground(new Color(0xDE563D));
        countdown_label.setBounds(35, 43, 125, 20);
        countdown_label.setFont(new Font("Serif", Font.BOLD, 15));

        JTextField time_text = new JTextField();
        time_text.setForeground(new Color(0xDE563D));
        time_text.setBounds(270, 10, 170, 25);
        time_text.setFont(new Font("Serif", Font.BOLD, 15));
        time_text.setEnabled(false);

        JTextField countdown_text = new JTextField();
        countdown_text.setForeground(new Color(0xDE563D));
        countdown_text.setBounds(270, 43, 170, 25);
        countdown_text.setFont(new Font("Serif", Font.BOLD, 15));
        countdown_text.setEnabled(false);

        JPanel secondPanel = new JPanel();
        secondPanel.setBackground(new Color(0xEDEDF2));
        secondPanel.setBounds(80, 120, 320, 50);
        secondPanel.setLayout(null);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        JLabel current_time = new JLabel(LocalTime.now().format(dtf));
        current_time.setBounds(255, 14, 70, 25);
        Timer timer = new Timer(1000, actionEvent -> {
            current_time.setText(LocalTime.now().format(dtf));
        });
        timer.start();

        JButton color_button = new JButton("Choose color");
        color_button.setBounds(5, 5, 240, 40);
        color_button.setForeground(new Color(0xDE563D));
        color_button.setFont(new Font("Serif", Font.BOLD, 15));
        color_button.setFocusable(false);
        JColorChooser jcc = new JColorChooser();
        ColorChooser.colorChooser(jcc, color_button, current_time);

        JPanel thirdPanel = new JPanel();
        thirdPanel.setBackground(new Color(0xEDEDF2));
        thirdPanel.setBounds(180, 200, 100, 40);
        thirdPanel.setLayout(null);

        JLabel speed_label = new JLabel("speed:");
        speed_label.setForeground(new Color(0xDE563D));
        speed_label.setFont(new Font("Serif", Font.BOLD, 15));
        speed_label.setBounds(5, 10, 50, 20);

        String[] speed = new String[]{
                "1",
                "2",
                "3",
                "4",
                "5"
        };
        JComboBox<String> speed_combo = new JComboBox<>(speed);
        speed_combo.setBounds(55, 8, 35, 25);
        speed_combo.setForeground(new Color(0xDE563D));
        speed_combo.setFont(new Font("Serif", Font.BOLD, 15));
        speed_combo.setFocusable(false);
        speed_combo.setSelectedIndex(1);
        speed_combo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    Object source = e.getSource();
                    if (source instanceof JComboBox) {
                        JComboBox cb = (JComboBox) source;
                        Object selectedItem = cb.getSelectedItem();
                        int i = Integer.valueOf((String) selectedItem);
                        speed_combo.setSelectedIndex(i - 1);
                        int a = i * 1000;
                        selected_speed = a;
                    }
                }
            }
        });
        JPanel fourthPanel = new JPanel();
        fourthPanel.setBackground(new Color(0xEDEDF2));
        fourthPanel.setBounds(75, 280, 330, 50);
        fourthPanel.setLayout(null);

        JButton start_button = new JButton("Start Countdown");
        start_button.setBounds(5, 5, 240, 40);
        start_button.setForeground(new Color(0xDE563D));
        start_button.setFont(new Font("Serif", Font.BOLD, 15));
        start_button.setFocusable(false);

        start_button.addActionListener(actionEvent -> {
            if (countdown_text.getText().length() > 0 && countdown_text.isEnabled()) {
                Countdown countdown = new Countdown();
                countdown.setCountdown(countdown_text.getText());
                CountdownAction action = new CountdownAction(timer2, countdown_text, countdown, jcc, selected_speed);
                newWindow = action.getNewWindow();
                timer2 = new Timer(1000, action);
                timer2.start();
            } else if (time_text.isEnabled() && time_text.getText().length() > 0) {
                DateTimeFormatter formater = DateTimeFormatter.ofPattern("HH:mm:ss");
                LocalTime on_time = LocalTime.parse(time_text.getText());
                on_time_timer = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        LocalTime now = LocalTime.now().withNano(0);
                        if (on_time.compareTo(now) == 0) {
                            otherWindow.setVisible(true);
                            otherWindow.getContentPane().setBackground(jcc.getColor());
                            on_time_timer.stop();
                            timer4 = new Timer(selected_speed, new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    Color default_color = new Color(238, 238, 238);
                                    if (otherWindow.getContentPane().getBackground().equals(default_color)) {
                                        otherWindow.getContentPane().setBackground(jcc.getColor());
                                    } else {
                                        otherWindow.getContentPane().setBackground(default_color);
                                    }
                                }
                            });
                            timer4.start();
                        }
                    }
                });
                on_time_timer.start();
            }
            time_button.setEnabled(false);
            countdown_button.setEnabled(false);
            color_button.setEnabled(false);
            speed_combo.setEnabled(false);
            start_button.setEnabled(false);
        });
        JButton stop_button = new JButton("Stop");
        stop_button.setBounds(253, 8, 70, 35);
        stop_button.setForeground(new Color(0xDE563D));
        stop_button.setFont(new Font("Serif", Font.BOLD, 15));
        stop_button.setFocusable(false);
        stop_button.addActionListener(ActionEvent -> {
            if (timer2 != null && timer2.isRunning()) {
                timer2.stop();
                otherWindow.setVisible(false);
                otherWindow.dispose();
                newWindow.setVisible(false);
                newWindow.dispose();
            }
            if (timer4 != null && timer4.isRunning()) {
                timer4.stop();
                otherWindow.dispose();
            }
            time_button.setEnabled(true);
            countdown_button.setEnabled(true);
            color_button.setEnabled(true);
            speed_combo.setEnabled(true);
            start_button.setEnabled(true);
            time_text.setText("");
            countdown_text.setText("");
        });
        time_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                time_text.setEnabled(true);
                countdown_text.setEnabled(false);
            }
        });
        countdown_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                time_text.setEnabled(false);
                countdown_text.setEnabled(true);
            }
        });
        this.add(firstPanel);
        this.add(secondPanel);
        this.add(thirdPanel);
        this.add(fourthPanel);
        firstPanel.add(time_button);
        firstPanel.add(countdown_button);
        firstPanel.add(on_time_label);
        firstPanel.add(countdown_label);
        firstPanel.add(time_text);
        firstPanel.add(countdown_text);
        secondPanel.add(color_button);
        secondPanel.add(current_time);
        thirdPanel.add(speed_label);
        thirdPanel.add(speed_combo);
        fourthPanel.add(start_button);
        fourthPanel.add(stop_button);
    }
}