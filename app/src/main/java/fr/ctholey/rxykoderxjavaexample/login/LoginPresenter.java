package fr.ctholey.rxykoderxjavaexample.login;

import android.util.Log;

import javax.inject.Inject;

import fr.ctholey.rxykoderxjavaexample.source.DBApi.DBRealmApi;
import fr.ctholey.rxykoderxjavaexample.models.Joke;
import fr.ctholey.rxykoderxjavaexample.ws.OkHttpCaller;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by ctholey on 23/09/2016.
 */
/** Dagger generated code doesn't require public access to the constructor or class, and
        * therefore, to ensure the developer doesn't instantiate the class manually and bypasses Dagger,
        * it's good practice minimise the visibility of the class/constructor as much as possible.
**/
final class LoginPresenter implements LoginContract.Presenter {

    private static final String TAG = LoginPresenter.class.getSimpleName();

    private CompositeSubscription compositeSubs = new CompositeSubscription();

    private OkHttpCaller httpCaller;
    private DBRealmApi mDBApi;
    private LoginContract.View mLoginView;

    @Inject
    LoginPresenter(OkHttpCaller httpCaller, DBRealmApi dbRealmApi, LoginContract.View loginView) {
        this.httpCaller = httpCaller;
        this.mDBApi = dbRealmApi;
        this.mLoginView = loginView;
    }

    @Inject
    void injectPresenterInView(){
        mLoginView.setPresenter(this);
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
        mLoginView.handleJokeContent(joke);
    }

    @Override
    public void saveJoke(String joke) {
        mDBApi.saveJokeAsync(joke,
                () -> mLoginView.handleJokeSuccessfullySaved(),
                error -> mLoginView.handleJokeSavedError(error));
    }

    @Override
    public void onDestroy() {
        mLoginView = null;
        compositeSubs.unsubscribe();
    }

    @Override
    public void start() {

    }
}
