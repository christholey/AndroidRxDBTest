package fr.ctholey.rxykoderxjavaexample;

import android.app.Application;

import fr.ctholey.rxykoderxjavaexample.source.DBApi.DBComponent;
import fr.ctholey.rxykoderxjavaexample.source.DBApi.DBModule;
import fr.ctholey.rxykoderxjavaexample.injection.DaggerNetComponent;
import fr.ctholey.rxykoderxjavaexample.source.RemoteApi.NetComponent;
import fr.ctholey.rxykoderxjavaexample.source.RemoteApi.NetModule;

/**
 * Created by ctholey on 23/09/2016.
 */

public class MyApplication extends Application {

    private DBComponent mDBComponent;
    private NetComponent mNetComponent;

    private static MyApplication sInstance;

    @Override
    public void onCreate() {
        super.onCreate();

        mNetComponent = DaggerNetComponent.builder()
                .netModule(getNetModule())
                .dBModule(getDBModule())
                .build();

//        mDBComponent =


        setInstance(this);
    }

    public MyApplication getInstance(){
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

}
