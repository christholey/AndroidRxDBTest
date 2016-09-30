package fr.ctholey.rxykoderxjavaexample.login;

import dagger.Component;
import fr.ctholey.rxykoderxjavaexample.injection.scope.ActivityScope;
import fr.ctholey.rxykoderxjavaexample.source.SourceComponent;

/**
 * Created by ctholey on 29/09/2016.
 */
@ActivityScope
@Component (dependencies = SourceComponent.class, modules = LoginPresenterModule.class)
public interface LoginComponent {

    void inject(LoginActivity loginActivity);

}
