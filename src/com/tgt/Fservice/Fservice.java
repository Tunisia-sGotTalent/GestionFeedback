package com.tgt.Fservice;

import java.sql.SQLException;
import java.util.List;

public interface Fservice<T> {
    
  void ajouter(T t) throws SQLException;

    //boolean delete(T t) throws SQLException;

    boolean update(T t) throws SQLException;

    void deleteParID(int id) throws SQLException;

    void rechercherParID(int id) throws SQLException;
    
    List<T> readAllTri() throws SQLException;

    List<T> readAll() throws SQLException;
}    

