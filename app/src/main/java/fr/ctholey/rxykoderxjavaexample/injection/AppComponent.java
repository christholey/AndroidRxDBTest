package fr.ctholey.rxykoderxjavaexample.injection;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ctholey on 27/09/2016.
 */
@Singleton
@Component (modules = {AppModule.class})
public interface AppComponent {


}
