package com.example.events;

import com.example.gui.Countdown;
import com.example.gui.OtherWindow;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CountdownAction implements ActionListener {
    private Timer timer;
    private JTextField label_countdown;
    private Countdown countdown;
    private JColorChooser chosen_color;
    private int speed;
    OtherWindow newWindow = new OtherWindow();

    public OtherWindow getNewWindow() {
        return newWindow;
    }
    public CountdownAction(Timer t, JTextField lc, Countdown c, JColorChooser chosen, int selected_speed ) {
        timer = t;
        label_countdown = lc;
        countdown = c;
        chosen_color = chosen;
        speed = selected_speed;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(countdown.isZero()) {
            newWindow.setVisible(true);
            newWindow.getContentPane().setBackground(chosen_color.getColor());
            Timer timer3 = new Timer(speed, new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    Color default_color = new Color(238, 238, 238);
                    if(newWindow.getContentPane().getBackground().equals(default_color)){
                        newWindow.getContentPane().setBackground(chosen_color.getColor());
                    }
                    else {
                        newWindow.getContentPane().setBackground(default_color);;
                    }
                }
            });
            timer3.start();
        }
        if(countdown.getCountdown() >= 1){
            countdown.decrement();
            label_countdown.setText(String.valueOf(countdown.getCountdown()));
        }
    }
}