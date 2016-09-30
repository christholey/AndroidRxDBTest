package fr.ctholey.rxjavamvpexample.jokes;

import java.util.List;

import fr.ctholey.rxjavamvpexample.BasePresenter;
import fr.ctholey.rxjavamvpexample.BaseView;
import fr.ctholey.rxjavamvpexample.models.Joke;

/**
 * Created by ctholey on 30/09/2016.
 */

public interface JokesContract {

    interface View extends BaseView<Presenter>{

        void showJokeList(List<Joke> jokeList);

        void handleErrorRetrievingList();

    }


    interface Presenter extends BasePresenter{


    }

}
