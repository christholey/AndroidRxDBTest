package fr.ctholey.rxykoderxjavaexample.injection;

import dagger.Component;
import fr.ctholey.rxykoderxjavaexample.injection.scope.ActivityScope;
import fr.ctholey.rxykoderxjavaexample.login.LoginActivity;

/**
 * Created by ctholey on 27/09/2016.
 */
@Component (dependencies = NetComponent.class, modules = ActivityModule.class)
@ActivityScope
public interface ActivityComponent {

    void inject(LoginActivity loginActivity);

}
