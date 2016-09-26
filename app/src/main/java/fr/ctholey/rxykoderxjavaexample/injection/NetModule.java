package fr.ctholey.rxykoderxjavaexample.injection;

import com.google.gson.Gson;

import dagger.Module;
import dagger.Provides;
import fr.ctholey.rxykoderxjavaexample.ws.OkHttpCaller;
import okhttp3.OkHttpClient;

/**
 * Created by ctholey on 23/09/2016.
 */

@Module
public class NetModule {

    String mBaseUrl;

    public NetModule(String baseUrl) {
        this.mBaseUrl = baseUrl;
    }


    @Provides
    Gson provideGson(){
        return new Gson();

        //Voir pour GsonBuilder.create
    }


    @Provides
    OkHttpClient provideOkHttpClient(){
        return new OkHttpClient();
    }


    @Provides
    OkHttpCaller provideOkHttpCaller(OkHttpClient httpClient){
        return new OkHttpCaller(httpClient);
    }

}
