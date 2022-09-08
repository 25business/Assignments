package com.example.ui;

import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;
import org.beryx.textio.TextTerminal;

public class Application {
    private static TextIO input = null;
    private static TextTerminal output = null;

    public static TextIO input() {
        if(input == null) input = TextIoFactory.getTextIO();
        return input;
    }
    public static TextTerminal terminal() {
        if(output == null) {
            output = input().getTextTerminal();
            output.getProperties().put("input.font.size", 20);
            output.getProperties().put("prompt.font.size", 20);
        }
        return output;
    }
    public static void main_menu() {
        terminal().println("""
                ---- Staff Application ----
                [1] Show staff
                [2] Add new staff
                [3] Update staff
                [4] Delete staff by ID
                [5] Show staff by name
                [Q] Quit application""");
    }
    public static void main_menu_actions() {
        String action = input().newStringInputReader().read("Your Choice: ");
        if(action.toUpperCase().equals("Q")) System.exit(0);
        else if(action.equals("1")) terminal().println(StaffUI.view_all());
        else if(action.equals("2")) terminal().println(StaffUI.new_staff(input()));
        else if(action.equals("3")) terminal().println(StaffUI.update(input()));
        else if(action.equals("4")) terminal().println(StaffUI.delete(input()));
        else if(action.equals("5")) terminal().println(StaffUI.viewbyname(input()));
    }
    public static void main_loop() {
        while(true) {
            main_menu();
            main_menu_actions();
        }
    }
}