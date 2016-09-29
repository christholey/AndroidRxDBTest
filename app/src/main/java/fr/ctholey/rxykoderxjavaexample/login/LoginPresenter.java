package fr.ctholey.rxykoderxjavaexample.login;

import fr.ctholey.rxykoderxjavaexample.BasePresenter;
import fr.ctholey.rxykoderxjavaexample.models.Joke;

/**
 * Created by ctholey on 23/09/2016.
 */
public interface LoginPresenter<T> extends BasePresenter<T> {

    void onDestroy();

    void callChuckNorrisJokeRandom();

    void onJokeRetrieved(Joke joke);

    void saveJoke(String joke);

}
