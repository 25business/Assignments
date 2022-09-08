package com.example.gui;

public class Countdown {
    private int countdown;

    public void setCountdown(String value) {
        this.countdown = Integer.parseInt(value);
    }
    public int getCountdown() {
        return countdown;
    }
    public void decrement() {
        countdown--;
    }
    public boolean isZero() {
        return countdown == 0;
    }
}