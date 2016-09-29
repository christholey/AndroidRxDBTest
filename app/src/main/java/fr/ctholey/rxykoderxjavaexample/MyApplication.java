package fr.ctholey.rxykoderxjavaexample;

import android.app.Application;
import android.content.Context;

import fr.ctholey.rxykoderxjavaexample.injection.ActivityComponent;
import fr.ctholey.rxykoderxjavaexample.injection.ActivityModule;
import fr.ctholey.rxykoderxjavaexample.injection.DBModule;
import fr.ctholey.rxykoderxjavaexample.injection.DaggerActivityComponent;
import fr.ctholey.rxykoderxjavaexample.injection.DaggerNetComponent;
import fr.ctholey.rxykoderxjavaexample.injection.NetComponent;
import fr.ctholey.rxykoderxjavaexample.injection.NetModule;

/**
 * Created by ctholey on 23/09/2016.
 */

public class MyApplication extends Application {

    private ActivityComponent mActivityComponent;
    private NetComponent mNetComponent;

    private static MyApplication sInstance;

    @Override
    public void onCreate() {
        super.onCreate();

        mNetComponent = getNetComponent(this);

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

    protected ActivityModule getActivityModule() {
        return new ActivityModule();
    }

    protected DBModule getDBModule(){
        return new DBModule(this);
    }


    /*COMPONENTS CREATION*/

    public static NetComponent getNetComponent(Context context){
        MyApplication app = (MyApplication) context.getApplicationContext();
        if (null == app.mNetComponent) {
            app.mNetComponent = DaggerNetComponent.builder()
                    .netModule(app.getNetModule())
                    .dBModule(app.getDBModule())
                    .build();
        }
        return app.mNetComponent;
    }


    public static ActivityComponent getActivityComponent(Context context) {
        MyApplication app = (MyApplication) context.getApplicationContext();
        if (null == app.mActivityComponent) {
            app.mActivityComponent = DaggerActivityComponent.builder()
                    .activityModule(app.getActivityModule())
                    .netComponent(app.mNetComponent)
                    .build();
        }
        return app.mActivityComponent;
    }

}
