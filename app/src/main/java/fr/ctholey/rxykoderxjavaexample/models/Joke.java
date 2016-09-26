package fr.ctholey.rxykoderxjavaexample.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ctholey on 20/09/2016.
 */

public class Joke {

    private int id;

    private String joke;

    private List<Object> categories = new ArrayList<Object>();

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



}
