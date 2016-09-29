package fr.ctholey.rxykoderxjavaexample.login;

import dagger.Component;
import fr.ctholey.rxykoderxjavaexample.source.DBApi.DBComponent;
import fr.ctholey.rxykoderxjavaexample.source.RemoteApi.NetComponent;
import fr.ctholey.rxykoderxjavaexample.injection.scope.ActivityScope;

/**
 * Created by ctholey on 29/09/2016.
 */
@ActivityScope
@Component (dependencies = {NetComponent.class, DBComponent.class}, modules = {LoginPresenterModule.class})
public interface LoginComponent {

    void inject(LoginActivity loginActivity);

}
