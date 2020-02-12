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
        String requeteInsert = "INSERT INTO `tgt`.`feedback` (`id`, `nom`, `comment`, `type`,`date`) VALUES (NULL, '" + t.getNom() + "', '" + t.getComment() + "', '" + t.getType() + "', '" + t.getDate() + "');";
        ste.executeUpdate(requeteInsert);
    }

    public void ajouter1(feedback f) throws SQLException {
        PreparedStatement pre = con.prepareStatement("INSERT INTO `tgt`.`feedback`  ( `nom`, `comment`, `type`,`date`) VALUES ( ?, ?, ?, ?);");
        pre.setString(1, f.getNom());
        pre.setString(2, f.getComment());
        pre.setString(3, f.getComment());
        pre.setString(4, f.getDate());

        pre.executeUpdate();
    }

//    @Override
//    public boolean delete(feedback t) throws SQLException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    @Override
    public boolean update(feedback a) throws SQLException {
        PreparedStatement pt = con.prepareStatement("update feedback set nom=?,comment=?,type=?,date=? where id=?");
        pt.setString(1, a.getNom());
        pt.setString(2, a.getComment());
        pt.setString(3, a.getType());
        pt.setString(4, a.getDate());
        pt.setInt(5, a.getId());
        int res = pt.executeUpdate();

        return (res >= 0);
    }

    @Override
    public void deleteParID(int id) throws SQLException {
        ste = con.createStatement();
        String requeteDelete = "Delete from `tgt`.`feedback` WHERE id=" + id;
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
                list.add(new feedback(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
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
            int id = rs.getInt(1);
            String nom = rs.getString("nom");
            String comment = rs.getString(3);
            String type = rs.getString("comment");
            String date = rs.getString("date");
            feedback p = new feedback(id, nom, comment, type, date);
            arr.add(p);
        }
        return arr;

    }

}
