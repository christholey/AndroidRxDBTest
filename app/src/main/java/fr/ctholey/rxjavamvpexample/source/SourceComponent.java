package fr.ctholey.rxjavamvpexample.source;

import javax.inject.Singleton;

import dagger.Component;
import fr.ctholey.rxjavamvpexample.source.DBApi.DBModule;
import fr.ctholey.rxjavamvpexample.source.DBApi.DBRealmApi;
import fr.ctholey.rxjavamvpexample.source.RemoteApi.NetModule;
import fr.ctholey.rxjavamvpexample.ws.OkHttpCaller;

/**
 * Created by ctholey on 29/09/2016.
 */
@Singleton
@Component (modules = {DBModule.class, NetModule.class})
public interface SourceComponent {

    //Expose le moyen de get OkHttpCaller pour le module ActivityModule qui contient des provides qui ont besoin de OKHttpCaller
    OkHttpCaller getOkHttpCaller();

    DBRealmApi getDBRealmApi();

}
