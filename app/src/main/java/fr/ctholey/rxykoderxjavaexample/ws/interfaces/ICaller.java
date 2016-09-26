package fr.ctholey.rxykoderxjavaexample.ws.interfaces;

import java.io.IOException;

import fr.ctholey.rxykoderxjavaexample.models.Joke;
import rx.Observable;

/**
 * Created by ctholey on 07/09/2016.
 */
public interface ICaller {

    Observable<Joke> getChuckNorrisJokeRandom() throws IOException;
}
