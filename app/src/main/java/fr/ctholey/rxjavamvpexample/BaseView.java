package fr.ctholey.rxjavamvpexample;

/**
 * Created by ctholey on 29/09/2016.
 */

public interface BaseView<T> {

    void setPresenter(T presenter);
}
