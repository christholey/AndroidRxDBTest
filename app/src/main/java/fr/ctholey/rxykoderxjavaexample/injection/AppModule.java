package fr.ctholey.rxykoderxjavaexample.injection;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ctholey on 23/09/2016.
 */
@Module
public class AppModule {

    private Application mApplication;


    public AppModule(Application application) {
        this.mApplication = application;
    }

    @Provides
    @Singleton
    Application provideApplication(){
        return mApplication;
    }
}
