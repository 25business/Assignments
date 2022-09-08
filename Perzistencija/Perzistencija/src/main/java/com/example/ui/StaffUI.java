package com.example.ui;

import com.example.dao.StaffDao;
import com.example.models.Staff;
import de.vandermeer.asciitable.AsciiTable;
import org.beryx.textio.TextIO;

import java.util.List;

public class StaffUI {

    public static String view_all() {
        List<Staff> staff = StaffDao.all();
        AsciiTable table = new AsciiTable();
        table.addRule();
        if(staff.size() == 0) {
            table.addRow("There are not staff available.");
            table.addRule();
        } else {
            table.addRow("ID", "Ime", "Broj godina", "Adresa", "Visina dohotka");
            table.addRule();
            for(var staffs : staff) {
                table.addRow(
                        staffs.getStaff_id(),
                        staffs.getIme(),
                        staffs.getBroj_godina(),
                        staffs.getAdresa(),
                        staffs.getVisina_dohotka()
                );
                table.addRule();
            }
        }
        return table.render();
    }
    public static String new_staff(TextIO input) {
        Staff new_staff = new Staff();
        new_staff.setIme(input.newStringInputReader().withMinLength(1).read("Ime: "));
        new_staff.setBroj_godina(input.newIntInputReader().read("Broj godina: "));
        new_staff.setAdresa(input.newStringInputReader().withMinLength(1).read("Adresa: "));
        new_staff.setVisina_dohotka(input.newDoubleInputReader().read("Visina dohotka: "));
        int new_id = StaffDao.insert(new_staff);
        return new_id > 0 ? "Staff has been saved." : "Error adding new staff.";
    }
    public static String update(TextIO input) {
        int staff_id = input.newIntInputReader().read("Enter staff ID: ");
        Staff staff = StaffDao.one(staff_id);
        input.getTextTerminal().println("To ignore field, enter - .");
        String ime = input.newStringInputReader().read("Ime (" + staff.getIme() + "):");
        String broj_godina = input.newStringInputReader().read("Broj godina (" + staff.getBroj_godina() + "):");
        String adresa = input.newStringInputReader().read("Adresa (" + staff.getAdresa() + "):");
        String visina_dohotka = input.newStringInputReader().read("Visina dohotka (" + staff.getVisina_dohotka() + "):");

        if(!ime.equals("-")) staff.setIme(ime);
        if(!broj_godina.equals("-")) staff.setBroj_godina(Integer.parseInt(broj_godina));
        if(!adresa.equals("-")) staff.setAdresa(adresa);
        if(!visina_dohotka.equals("-")) staff.setVisina_dohotka(Double.parseDouble(visina_dohotka));

        int result = StaffDao.update(staff);
        return result > 0 ? "Staff has been updated." : "Error updating staff!";
    }
    public static String delete(TextIO input) {
        int staff_id = input.newIntInputReader().read("Enter staff ID: ");
        Staff staff = StaffDao.one(staff_id);
        int result = StaffDao.delete(staff.getStaff_id());
        return result > 0 ? "Staff has been deleted." : "Error updating staff!";

    }
    public static String viewbyname(TextIO input) {
        String staff_ime = input.newStringInputReader().read("Enter staff name: ");
        List<Staff> staff = StaffDao.view_by_name(staff_ime);
        AsciiTable table = new AsciiTable();
        table.addRule();
        if(staff.size() == 0) {
            table.addRow("There are not staff available.");
            table.addRule();
        } else {
            table.addRow("ID", "Ime", "Broj godina", "Adresa", "Visina dohotka");
            table.addRule();
            for(var staffs : staff) {
                table.addRow(
                        staffs.getStaff_id(),
                        staffs.getIme(),
                        staffs.getBroj_godina(),
                        staffs.getAdresa(),
                        staffs.getVisina_dohotka()
                );
                table.addRule();
            }
        }
        return table.render();
    }
}