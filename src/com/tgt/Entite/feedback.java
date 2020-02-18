package com.tgt.Entite;

public class feedback {

    private int id_feedback;
    private int note_feedback;
    private String date_feedback;
    private String commentaire_feedback;

    public feedback() {
    }

    public feedback(int id_feedback, int note_feedback, String date_feedback, String commentaire_feedback) {
        this.id_feedback = id_feedback;
        this.note_feedback = note_feedback;
        this.date_feedback = date_feedback;
        this.commentaire_feedback = commentaire_feedback;
    }

    public feedback(int note_feedback, String date_feedback, String commentaire_feedback) {
        this.note_feedback = note_feedback;
        this.date_feedback = date_feedback;
        this.commentaire_feedback = commentaire_feedback;
    }

    public int getId_feedback() {
        return id_feedback;
    }

    public void setId_feedback(int id_feedback) {
        this.id_feedback = id_feedback;
    }

    public int getNote_feedback() {
        return note_feedback;
    }

    public void setNote_feedback(int note_feedback) {
        this.note_feedback = note_feedback;
    }

    public String getDate_feedback() {
        return date_feedback;
    }

    public void setDate_feedback(String date_feedback) {
        this.date_feedback = date_feedback;
    }

    public String getCommentaire_feedback() {
        return commentaire_feedback;
    }

    public void setCommentaire_feedback(String commentaire_feedback) {
        this.commentaire_feedback = commentaire_feedback;
    }

    @Override
    public String toString() {
        return "feedback{" + "id_feedback=" + id_feedback + ", note_feedback=" + note_feedback + ", date_feedback=" + date_feedback + ", commentaire_feedback=" + commentaire_feedback + '}';
    }

}
