package fr.ctholey.rxykoderxjavaexample.source.DBApi;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ctholey on 29/09/2016.
 */
@Singleton
@Component (modules = {DBModule.class})
public interface DBComponent {

        DBRealmApi getDBRealmApi();
}
