package fr.ctholey.rxjavamvpexample.source.DBApi;

import io.realm.Realm;

/**
 * Created by ctholey on 27/09/2016.
 */

public interface DBApi {

    void saveJokeAsync(String jokeToSave, Realm.Transaction.OnSuccess onSaveSuccess, Realm.Transaction.OnError onError);

}
