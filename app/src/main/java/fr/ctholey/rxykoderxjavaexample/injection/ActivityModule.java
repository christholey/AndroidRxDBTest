package fr.ctholey.rxykoderxjavaexample.injection;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import fr.ctholey.rxykoderxjavaexample.DBApi.DBRealmApi;
import fr.ctholey.rxykoderxjavaexample.injection.scope.ActivityScope;
import fr.ctholey.rxykoderxjavaexample.login.LoginPresenter;
import fr.ctholey.rxykoderxjavaexample.login.LoginPresenterImpl;
import fr.ctholey.rxykoderxjavaexample.ws.OkHttpCaller;

/**
 * Created by ctholey on 27/09/2016.
 */
@Module
public class ActivityModule {

    public ActivityModule() {
    }

    @Provides
    @ActivityScope
    LoginPresenter provideLoginPresenter(OkHttpCaller httpCaller, DBRealmApi dbRealmApi){
        return new LoginPresenterImpl(httpCaller, dbRealmApi);
    }
}
