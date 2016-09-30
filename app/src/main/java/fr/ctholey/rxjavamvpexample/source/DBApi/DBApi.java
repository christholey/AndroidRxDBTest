package fr.ctholey.rxjavamvpexample.source.DBApi;

import java.util.List;

import fr.ctholey.rxjavamvpexample.models.Joke;
import io.realm.Realm;

/**
 * Created by ctholey on 27/09/2016.
 */

public interface DBApi {

    interface GetJokesCallback{

        void onJokesRetrieved(List<Joke> jokeList);

        void onJokesUnavailable();

    }

    void saveJokeAsync(String jokeToSave, Realm.Transaction.OnSuccess onSaveSuccess, Realm.Transaction.OnError onError);

    void retrieveJokes(GetJokesCallback getJokesCallback);


}
