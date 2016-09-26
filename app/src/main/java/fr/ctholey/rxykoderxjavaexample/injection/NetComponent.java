package fr.ctholey.rxykoderxjavaexample.injection;

import dagger.Component;
import fr.ctholey.rxykoderxjavaexample.login.LoginActivity;
import fr.ctholey.rxykoderxjavaexample.ws.OkHttpCaller;

/**
 * Created by ctholey on 23/09/2016.
 */

@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {

    void inject(OkHttpCaller okHttpCaller);
    void inject(LoginActivity loginActivity);

}
