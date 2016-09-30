package fr.ctholey.rxjavamvpexample.jokes;

import java.util.List;

import javax.inject.Inject;

import fr.ctholey.rxjavamvpexample.models.Joke;
import fr.ctholey.rxjavamvpexample.source.DBApi.DBApi;
import fr.ctholey.rxjavamvpexample.source.DBApi.DBRealmApi;

/**
 * Created by ctholey on 30/09/2016.
 */

public class JokesPresenter implements JokesContract.Presenter {

    private DBRealmApi mDbApi;
    private JokesContract.View mJokesView;


    @Inject
    public JokesPresenter(DBRealmApi dbRealmApi, JokesContract.View jokesView) {
        this.mDbApi = dbRealmApi;
        this.mJokesView = jokesView;
    }


    @Override
    public void start() {
        getJokes();
    }

    @Inject
    void injectPresenterInView(){
        mJokesView.setPresenter(this);
    }


    private void getJokes(){
        DBApi.GetJokesCallback getJokesCallback = new DBApi.GetJokesCallback() {
            @Override
            public void onJokesRetrieved(List<Joke> jokeList) {
                if (null != jokeList){

                }
            }

            @Override
            public void onJokesUnavailable() {

            }
        };

        mDbApi.retrieveJokes(getJokesCallback);
    }


}
