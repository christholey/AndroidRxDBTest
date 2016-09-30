package fr.ctholey.rxjavamvpexample.jokes;

import fr.ctholey.rxjavamvpexample.BasePresenter;
import fr.ctholey.rxjavamvpexample.BaseView;

/**
 * Created by ctholey on 30/09/2016.
 */

public interface JokesContract {

    interface View extends BaseView<Presenter>{


    }


    interface Presenter extends BasePresenter{

    }

}
