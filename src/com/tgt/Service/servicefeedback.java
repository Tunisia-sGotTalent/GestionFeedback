package com.tgt.Service;

import com.tgt.Utils.DataBase;
import com.tgt.Entite.feedback;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.tgt.IService.IserviceFeedback;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class servicefeedback implements IserviceFeedback<feedback> {

    private Connection con;
    private Statement ste;

    public servicefeedback() {
        con = DataBase.getInstance().getConnection();
    }

    public ObservableList<feedback> afficher(feedback f) throws SQLException {

        ObservableList<feedback> arr = FXCollections.observableArrayList();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from feedback");
        while (rs.next()) {
            arr.add(new feedback(rs.getInt("id_feedback"), rs.getInt("note_feedback"), rs.getString("date_feedback"), rs.getString("commentaire_feedback")));

        }
        return arr;

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
    public void deleteParXID(feedback t) throws SQLException {
        ste = con.createStatement();
        String requeteDelete = "DELETE FROM feedback WHERE id_feedback = ? ;";
        PreparedStatement pst = con.prepareStatement(requeteDelete);
        pst.setInt(1, t.getId_feedback());
        pst.executeUpdate();
    }

    @Override
    public List<feedback> rechercherParID(feedback f) throws SQLException {
        /*  ste = con.createStatement();
        List<feedback> arr = new ArrayList<>();
        String requeteSearch = "Select * from `feedback` WHERE commentaire_feedback='" + f.getCommentaire_feedback() + "' ;";
        ResultSet rs = ste.executeQuery(requeteSearch);
        while (rs.next()) {
            int id = rs.getInt("id_feedback");
            int note = rs.getInt("note_feedback");
            String date = rs.getString("date_feedback");
            String commentaire = rs.getString("commentaire_feedback");
            feedback f1 = new feedback(id, note, date, commentaire);
            arr.add(f1);
    }
        return arr ;*/

        List<feedback> list = new ArrayList<>();
        String req = "select * from feedback where commentaire_feedback = '" + f.getCommentaire_feedback() + "';";
        try {
            ste = con.createStatement();
            ResultSet rs = ste.executeQuery(req);
            while (rs.next()) {
                list.add(new feedback(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4)));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return list;
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
