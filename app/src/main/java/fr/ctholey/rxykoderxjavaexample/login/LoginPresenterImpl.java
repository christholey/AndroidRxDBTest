package fr.ctholey.rxykoderxjavaexample.login;

import android.util.Log;

import javax.inject.Inject;

import fr.ctholey.rxykoderxjavaexample.DBApi.DBApi;
import fr.ctholey.rxykoderxjavaexample.DBApi.DBRealmApi;
import fr.ctholey.rxykoderxjavaexample.MyApplication;
import fr.ctholey.rxykoderxjavaexample.models.Joke;
import fr.ctholey.rxykoderxjavaexample.ws.OkHttpCaller;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by ctholey on 23/09/2016.
 */

public class LoginPresenterImpl implements LoginPresenter<LoginView> {

    private static final String TAG = LoginPresenterImpl.class.getSimpleName();

    private LoginView mView;

    private CompositeSubscription compositeSubs = new CompositeSubscription();

    private OkHttpCaller httpCaller;
    private DBRealmApi mDBApi;

    @Inject
    public LoginPresenterImpl(OkHttpCaller httpCaller, DBRealmApi dbRealmApi) {
        this.httpCaller = httpCaller;
        this.mDBApi = dbRealmApi;
    }

    @Override
    public void setView(LoginView view) {
        this.mView = view;
        if (null == view){
            compositeSubs.unsubscribe();
        }
    }

    @Override
    public void callChuckNorrisJokeRandom() {

        compositeSubs.add(
                httpCaller.getChuckNorrisJokeRandom()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .retry(2)
                        .subscribe(
                                joke -> onJokeRetrieved(joke),
                                throwable -> Log.d(TAG, throwable.getMessage())
                        )
        );
    }

    @Override
    public void onJokeRetrieved(Joke joke) {
        mView.handleJokeContent(joke);
    }

    @Override
    public void saveJoke(String joke) {
        mDBApi.saveJokeAsync(joke,
                () -> mView.handleJokeSuccessfullySaved(),
                error -> mView.handleJokeSavedError(error));
    }

    @Override
    public void onDestroy() {
        mView = null;
        compositeSubs.unsubscribe();
    }

}
