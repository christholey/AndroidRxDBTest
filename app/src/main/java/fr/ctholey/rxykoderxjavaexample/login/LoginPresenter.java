package fr.ctholey.rxykoderxjavaexample.login;

import fr.ctholey.rxykoderxjavaexample.Presenter;
import fr.ctholey.rxykoderxjavaexample.models.Joke;

/**
 * Created by ctholey on 23/09/2016.
 */
public interface LoginPresenter<T> extends Presenter<T> {

    void onDestroy();

    void callChuckNorrisJokeRandom();

    void onJokeRetrieved(Joke joke);

}
