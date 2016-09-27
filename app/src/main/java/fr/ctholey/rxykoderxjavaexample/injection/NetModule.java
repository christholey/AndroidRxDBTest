package fr.ctholey.rxykoderxjavaexample.injection;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import fr.ctholey.rxykoderxjavaexample.ws.OkHttpCaller;
import okhttp3.OkHttpClient;

/**
 * Created by ctholey on 23/09/2016.
 */

@Module
public class NetModule {

    public NetModule() {
    }

    @Provides
    @Singleton
    // Application reference must come from AppModule.class
    SharedPreferences providesSharedPreferences(Application application) {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }

    @Provides
    @Singleton
    Gson provideGson(){
        return new Gson();

        //Voir pour GsonBuilder.create
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(){
        return new OkHttpClient();
    }

    @Provides
    @Singleton
    OkHttpCaller provideOkHttpCaller(OkHttpClient httpClient, Gson gson){
        return new OkHttpCaller(httpClient, gson);
    }



}
