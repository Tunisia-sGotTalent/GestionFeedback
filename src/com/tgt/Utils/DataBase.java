package com.tgt.Utils;

import com.tgt.Entite.feedback;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataBase {

    String url = "jdbc:mysql://localhost:3306/tgt";
    String login = "root";
    String pwd = "";
    public static DataBase db;
    public Connection con;

    private DataBase() {
        try {
            con = DriverManager.getConnection(url, login, pwd);
            System.out.println("connexion etablie");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public Connection getConnection() {
        return con;
    }

    public static DataBase getInstance() {
        if (db == null) {
            db = new DataBase();
        }
        return db;
    }

    public static int update(feedback fdbck) {
        int st = 0;
        try {
            String sql = "UPDATE feedback SET note_feedback=?, commentaire_feedback=?, date_feedback=? WHERE id_feedback=?";
            Connection con = DataBase.getInstance().getConnection();
            PreparedStatement stat;
            stat = con.prepareStatement(sql);
            stat.setInt(1, fdbck.getNote_feedback());
            stat.setString(2, fdbck.getCommentaire_feedback());
            stat.setString(3, fdbck.getDate_feedback());
            stat.setInt(4, fdbck.getId_feedback());
            st = stat.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return st;
    }

    public static int delete(int id_feedback) {
        int st = 0;
        try {
            String sql = "DELETE FROM feedback WHERE id_feedback=?";
            Connection con = DataBase.getInstance().getConnection();
            PreparedStatement stat;
            stat = con.prepareStatement(sql);
            stat.setInt(1, id_feedback);
            st = stat.executeUpdate();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return st;
    }
}
