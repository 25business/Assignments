package com.example.dao;

import com.example.models.Staff;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.statement.Query;
import org.jdbi.v3.core.statement.Update;

import java.util.List;

public class StaffDao {
    private static Jdbi jdbi = null;

    private static Jdbi get_connection() {
        if(jdbi == null)
            jdbi = Jdbi.create("jdbc:mysql://localhost:3306/perzistencija_baza", "jadmin", "1234");
        return jdbi;
    }
    public static List<Staff> all() {
        Jdbi jdbi = get_connection();
        return jdbi.withHandle(handle -> {
            Query select_staff_query = handle.createQuery("SELECT * FROM data;");
            return select_staff_query.mapToBean(Staff.class).list();
        });
    }
    public static int insert(Staff new_staff) {
        Jdbi jdbi = get_connection();
        return jdbi.withHandle(handle -> {
            Update insert_new_staff = handle.createUpdate("""
                    INSERT INTO data VALUES (NULL,:ime,:broj_godina,:adresa,:visina_dohotka)""");
            return insert_new_staff.bindBean(new_staff).execute();
        });
    }
    public static Staff one(int staff_id) {
        Jdbi jdbi = get_connection();
        return jdbi.withHandle(handle -> {
             return handle.createQuery("SELECT * FROM data WHERE staff_id = :staff_id")
                     .bind("staff_id", staff_id)
                     .mapToBean(Staff.class)
                     .first();
        });
    }
    public static int update(Staff staff) {
        Jdbi jdbi = get_connection();
        return jdbi.withHandle(handle -> {
            return handle.createUpdate("""
                            UPDATE data SET
                            ime = :ime,
                            broj_godina = :broj_godina,
                            adresa = :adresa,
                            visina_dohotka = :visina_dohotka
                            WHERE staff_id = :staff_id;""")
                    .bindBean(staff).execute();
        });
    }
    public static int delete(int staff_id) {
        Jdbi jdbi = get_connection();
        return jdbi.withHandle(handle -> {
            return handle.createUpdate("""
                            DELETE FROM data
                            WHERE staff_id = :staff_id;""")
                    .bind("staff_id", staff_id).execute();
        });
    }
    public static List<Staff> view_by_name(String ime) {
        System.out.println(ime);
        Jdbi jdbi = get_connection();
        return jdbi.withHandle(handle -> {
            Query select_staff_query = handle.createQuery("SELECT * FROM data WHERE ime = :ime");
            return select_staff_query.bind("ime", ime).mapToBean(Staff.class).list();
        });
    }
}