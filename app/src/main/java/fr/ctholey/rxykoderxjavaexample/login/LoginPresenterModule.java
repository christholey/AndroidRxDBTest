package fr.ctholey.rxykoderxjavaexample.login;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ctholey on 29/09/2016.
 */

@Module
public class LoginPresenterModule {

    private LoginContract.View mView;


    public LoginPresenterModule(LoginContract.View mView) {
        this.mView = mView;
    }


    @Provides
    LoginContract.View provideLoginContractView() {
        return mView;
    }
}
