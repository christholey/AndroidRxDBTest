package fr.ctholey.rxykoderxjavaexample;

import android.app.Application;

import fr.ctholey.rxykoderxjavaexample.injection.NetComponent;

/**
 * Created by ctholey on 23/09/2016.
 */

public class MyApplication extends Application {

    private NetComponent mNetComponent;

    @Override
    public void onCreate() {
        super.onCreate();



    }
}
