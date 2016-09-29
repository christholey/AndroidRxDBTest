package fr.ctholey.rxykoderxjavaexample.source.DBApi;

import javax.inject.Inject;

import fr.ctholey.rxykoderxjavaexample.models.Joke;
import io.realm.Realm;

/**
 * Created by ctholey on 27/09/2016.
 */

public class DBRealmApi implements DBApi{

    private Realm mRealm;

    @Inject
    public DBRealmApi(Realm realm) {
        this.mRealm = realm;
    }

    @Override
    public void saveJokeAsync(String jokeToSave, Realm.Transaction.OnSuccess onSaveSuccess, Realm.Transaction.OnError onError) {
        mRealm.executeTransactionAsync(
            realm -> {
                Joke joke = new Joke();
                joke.setJoke(jokeToSave);
                realm.copyToRealmOrUpdate(joke);
            }
            ,() -> onSaveSuccess.onSuccess()
            ,error -> onError.onError(error)
        );
    }
}
