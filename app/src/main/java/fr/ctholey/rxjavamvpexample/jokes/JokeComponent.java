package fr.ctholey.rxjavamvpexample.jokes;

import dagger.Component;
import fr.ctholey.rxjavamvpexample.injection.scope.ActivityScope;
import fr.ctholey.rxjavamvpexample.source.SourceComponent;

/**
 * Created by ctholey on 30/09/2016.
 */
@ActivityScope
@Component (dependencies = SourceComponent.class, modules = JokePresenterModule.class)
public interface JokeComponent {

    void inject(JokesActivity jokesActivity);

}
