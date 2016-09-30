package fr.ctholey.rxjavamvpexample.login;

import fr.ctholey.rxjavamvpexample.BasePresenter;
import fr.ctholey.rxjavamvpexample.BaseView;
import fr.ctholey.rxjavamvpexample.models.Joke;

/**
 * Created by ctholey on 29/09/2016.
 */

public interface LoginContract {

    interface View extends BaseView<Presenter>{

        void handleJokeContent(Joke joke);

        void handleJokeSuccessfullySaved();

        void handleJokeSavedError(Throwable error);

    }


    interface Presenter extends BasePresenter{

        void onDestroy();

        void callChuckNorrisJokeRandom();

        void onJokeRetrieved(Joke joke);

        void saveJoke(String joke);

    }

}
