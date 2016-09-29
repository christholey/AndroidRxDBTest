package fr.ctholey.rxykoderxjavaexample.injection;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import fr.ctholey.rxykoderxjavaexample.DBApi.DBRealmApi;
import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by ctholey on 28/09/2016.
 */
@Module
public class DBModule {

    private Context mContext;

    public DBModule(Context context) {
        this.mContext = context;
    }


    @Provides
    @Singleton
    Realm provideRealmInstance(){
        Realm.init(mContext);
        return Realm.getDefaultInstance();
    }

    @Provides
    @Singleton
    DBRealmApi provideDBRealmApi(Realm realm){
        return new DBRealmApi(realm);
    }
}
