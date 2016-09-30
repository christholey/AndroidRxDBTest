package fr.ctholey.rxykoderxjavaexample;

import android.app.Application;

import fr.ctholey.rxykoderxjavaexample.source.DBApi.DBModule;
import fr.ctholey.rxykoderxjavaexample.source.DaggerSourceComponent;
import fr.ctholey.rxykoderxjavaexample.source.RemoteApi.NetModule;
import fr.ctholey.rxykoderxjavaexample.source.SourceComponent;

/**
 * Created by ctholey on 23/09/2016.
 */

public class MyApplication extends Application {

    private SourceComponent mSourceComponent;

    private static MyApplication sInstance;

    @Override
    public void onCreate() {
        super.onCreate();

        mSourceComponent = DaggerSourceComponent.builder()
                .netModule(getNetModule())
                .dBModule(getDBModule())
                .build();

        setInstance(this);
    }

    public static MyApplication getInstance(){
        return sInstance;
    }

    public static void setInstance(MyApplication application){
        sInstance = application;
    }

    /*MODULES GETTERS*/

    protected NetModule getNetModule() {
        return new NetModule();
    }

    protected DBModule getDBModule(){
        return new DBModule(getApplicationContext());
    }

    public SourceComponent getSourceComponent(){
        return mSourceComponent;
    }

}
