package com.tgt.servicefeedback;

import com.tgt.Fservice.Fservice;
import com.tgt.Utils.DataBase;
import com.tgt.Entite.feedback;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class servicefeedback implements Fservice<feedback> {

    private Connection con;
    private Statement ste;

    public servicefeedback() {
        con = DataBase.getInstance().getConnection();
    }

    @Override
    public void ajouter(feedback t) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `tgt`.`feedback` (`id_feedback`, `note_feedback`, `date_feedback`, `commentaire_feedback`) VALUES (NULL, '" + t.getNote_feedback() + "', '" + t.getDate_feedback() + "', '" + t.getCommentaire_feedback() + "');";
        ste.executeUpdate(requeteInsert);
    }

    public void ajouter1(feedback f) throws SQLException {
        PreparedStatement pre = con.prepareStatement("INSERT INTO `tgt`.`feedback`  ( `note_feedback`, `date_feedback`, `date_feedback`) VALUES ( ?, ?, ?);");
        pre.setInt(1, f.getNote_feedback());
        pre.setString(2, f.getDate_feedback());
        pre.setString(3, f.getCommentaire_feedback());
        pre.setString(4, f.getDate_feedback());

        pre.executeUpdate();
    }

//    @Override
//    public boolean delete(feedback t) throws SQLException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    @Override
    public boolean update(feedback a) throws SQLException {
        PreparedStatement pt = con.prepareStatement("update feedback set note_feedback=?,date_feedback=?,commentaire_feedback=? where id=?");
        pt.setInt(1, a.getNote_feedback());
        pt.setString(2, a.getDate_feedback());
        pt.setString(3, a.getCommentaire_feedback());
        pt.setInt(4, a.getId_feedback());
        int res = pt.executeUpdate();

        return (res >= 0);
    }

    @Override
    public void deleteParID(int id_feedback) throws SQLException {
        ste = con.createStatement();
        String requeteDelete = "Delete from `tgt`.`feedback` WHERE id_feedback=" + id_feedback;
        ste.executeUpdate(requeteDelete);
        System.out.println("Bien supprimé");
    }

    @Override
    public void rechercherParID(int id) throws SQLException {
        ste = con.createStatement();
        String query = "Select * from `tgt`.`feedback` WHERE id=" + id;
        ste.executeQuery(query);
        ste.executeQuery(query).last();
        int nbrRow = ste.executeQuery(query).getRow();
        if (nbrRow != 0) {
            System.out.println("Trouvé");
        } else {
            System.out.println("Non Trouvé");
        }
    }

    @Override
    public List<feedback> readAllTri() throws SQLException {
        List<feedback> list = new ArrayList<>();
        String req = "select * from feedback order by nom";

        try {
            ste = con.createStatement();
            ResultSet rs = ste.executeQuery(req);
            while (rs.next()) {
                list.add(new feedback(rs.getInt(1), rs.getString(3), rs.getString(4)));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return list;
    }

    @Override
    public List readAll() throws SQLException {
        List<feedback> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from feedback");
        while (rs.next()) {
            int id_feedback = rs.getInt(1);
            int note_feedback = rs.getInt(2);
            String date_feedback = rs.getString("date_feedback");
            String commentaire_feedback = rs.getString("commentaire_feedback");
            feedback p = new feedback(id_feedback, note_feedback, date_feedback, commentaire_feedback);
            arr.add(p);
        }
        return arr;

    }

}

