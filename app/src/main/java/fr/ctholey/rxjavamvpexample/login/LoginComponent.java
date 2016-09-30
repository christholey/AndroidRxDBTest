package fr.ctholey.rxjavamvpexample.login;

import dagger.Component;
import fr.ctholey.rxjavamvpexample.injection.scope.ActivityScope;
import fr.ctholey.rxjavamvpexample.source.SourceComponent;

/**
 * Created by ctholey on 29/09/2016.
 */
@ActivityScope
@Component (dependencies = SourceComponent.class, modules = LoginPresenterModule.class)
public interface LoginComponent {

    void inject(LoginActivity loginActivity);

}
