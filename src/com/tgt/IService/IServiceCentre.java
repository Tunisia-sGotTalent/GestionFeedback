package com.tgt.IService;

import java.sql.SQLException;
import java.util.List;

public interface IServiceCentre<T> {

    void ajouter(T t) throws SQLException;

    void deleteSelonNomCentre(T t) throws SQLException;

    void updateSelonNom(T t) throws SQLException;

    List<T> readAll() throws SQLException;

    public List<T> searchSelonNom(T t) throws SQLException;

    public List<T> trierParNom() throws SQLException;

}
