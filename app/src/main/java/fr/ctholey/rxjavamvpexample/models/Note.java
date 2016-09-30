package fr.ctholey.rxjavamvpexample.models;

import io.realm.RealmModel;
import io.realm.annotations.RealmClass;

/**
 * Created by ctholey on 27/09/2016.
 */
@RealmClass
public class Note implements RealmModel {

    private int note;

    private String comment;

    public Note() {
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
