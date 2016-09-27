package fr.ctholey.rxykoderxjavaexample;

import android.app.Application;
import android.content.Context;

import fr.ctholey.rxykoderxjavaexample.injection.ActivityComponent;
import fr.ctholey.rxykoderxjavaexample.injection.ActivityModule;
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

    @Override
    public void onCreate() {
        super.onCreate();

        mNetComponent = DaggerNetComponent
                .builder()
                .netModule(getNetModule())
                .build();

    }

    protected NetModule getNetModule() {
        return new NetModule();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule();
    }


    public static NetComponent getNetComponent(Context context){
        MyApplication app = (MyApplication) context.getApplicationContext();
        if (app.mNetComponent == null) {
            app.mNetComponent = DaggerNetComponent.builder()
                    .netModule(app.getNetModule())
                    .build();
        }
        return app.mNetComponent;
    }


    public static ActivityComponent getActivityComponent(Context context) {
        MyApplication app = (MyApplication) context.getApplicationContext();
        if (app.mActivityComponent == null) {
            app.mActivityComponent = DaggerActivityComponent.builder()
                    .activityModule(app.getActivityModule())
                    .netComponent(app.mNetComponent)
                    .build();
        }
        return app.mActivityComponent;
    }
}
