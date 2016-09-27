package fr.ctholey.rxykoderxjavaexample.models;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;
import io.realm.RealmModel;
import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;
import io.realm.annotations.RealmModule;

/**
 * Created by ctholey on 20/09/2016.
 */
@RealmClass
public class Joke implements RealmModel{

    @PrimaryKey
    private int id;

    private String joke;

    @Ignore
    private List<Object> categories = new ArrayList<Object>();

    private RealmList<Note> notes;

    /**
     *
     * @return
     * The id
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The joke
     */
    public String getJoke() {
        return joke;
    }

    /**
     *
     * @param joke
     * The joke
     */
    public void setJoke(String joke) {
        this.joke = joke;
    }

    /**
     *
     * @return
     * The categories
     */
    public List<Object> getCategories() {
        return categories;
    }

    /**
     *
     * @param categories
     * The categories
     */
    public void setCategories(List<Object> categories) {
        this.categories = categories;
    }

    /**
     *
     * @return
     * The note
     */
    public RealmList<Note> getNotes() {
        return notes;
    }

    /**
     *
     * @param notes
     * The notes
     */
    public void setNotes(RealmList<Note> notes) {
        this.notes = notes;
    }
}
