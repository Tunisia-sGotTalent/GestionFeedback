package com.tgt.IService;

import com.tgt.Entite.feedback;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.ObservableList;

public interface IserviceFeedback<T> {

    void ajouter(T t) throws SQLException;

    //boolean delete(T t) throws SQLException;
    boolean update(T t) throws SQLException;

    void deleteParID(int id) throws SQLException;

    void deleteParXID(T t) throws SQLException;

    void rechercherParID(int id) throws SQLException;

    List<T> readAllTri() throws SQLException;

    List<T> readAll() throws SQLException;

    List<T> afficher(T t) throws SQLException;
}
