package com.tgt.Entite;

public class feedback {

    private int id;
    private String nom;
    private String comment;
    private String type;
    private String date;

    public feedback(int id, String nom, String comment, String type, String date) {
        this.id = id;
        this.nom = nom;
        this.comment = comment;
        this.type = type;
        this.date = date;
    }

    public feedback(String nom, String comment, String type, String date) {
        this.nom = nom;
        this.comment = comment;
        this.type = type;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "feedback{" + "id=" + id + ", nom=" + nom + ", comment=" + comment + ", type=" + type + ", date=" + date + '}';
    }

}
