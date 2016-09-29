package fr.ctholey.rxykoderxjavaexample.source.RemoteApi;

import javax.inject.Singleton;

import dagger.Component;
import fr.ctholey.rxykoderxjavaexample.AppModule;
import fr.ctholey.rxykoderxjavaexample.ws.OkHttpCaller;

/**
 * Created by ctholey on 23/09/2016.
 */
@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {

    //Expose le moyen de get OkHttpCaller pour le module ActivityModule qui contient des provides qui ont besoin de OKHttpCaller
    OkHttpCaller getOkHttpCaller();

}
