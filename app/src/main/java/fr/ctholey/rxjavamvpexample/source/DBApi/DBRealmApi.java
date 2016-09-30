package fr.ctholey.rxjavamvpexample.source.DBApi;

import javax.inject.Inject;

import fr.ctholey.rxjavamvpexample.models.Joke;
import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;

/**
 * Created by ctholey on 27/09/2016.
 */

public class DBRealmApi implements DBApi{

    private Realm mRealm;

    @Inject
    public DBRealmApi(Realm realm) {
        this.mRealm = realm;
    }

    private RealmResults<Joke> jokeResult;

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

    @Override
    public void retrieveJokes(GetJokesCallback getJokesCallback) {

        mRealm.executeTransactionAsync(
                realm -> {
                    jokeResult = realm.where(Joke.class)
                            .findAllSorted(Joke.ID, Sort.DESCENDING);

                },
                () -> getJokesCallback.onJokesRetrieved(jokeResult),
                error -> getJokesCallback.onJokesUnavailable()
        );
    }
}
