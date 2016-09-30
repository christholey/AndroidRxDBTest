package fr.ctholey.rxjavamvpexample.jokes;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ctholey on 30/09/2016.
 */
@Module
public class JokePresenterModule {

    private final JokesContract.View mView;

    public JokePresenterModule(JokesContract.View mView) {
        this.mView = mView;
    }

    @Provides
    JokesContract.View provideJokeContractView(){
        return mView;
    }
}
