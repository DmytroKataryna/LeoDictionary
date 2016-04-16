package kataryna.dmytro.leodictionary;

import android.app.Application;

import java.util.List;

import kataryna.dmytro.leodictionary.model.ModelImpl;
import kataryna.dmytro.leodictionary.model.api.API;
import kataryna.dmytro.leodictionary.model.api.ApiModule;
import kataryna.dmytro.leodictionary.model.data.LeoWord;
import rx.Observable;

/**
 * Created by dmytroKataryna on 14.03.16.
 */
public class LeoDictionaryApplication extends Application {

    private static API sApi;
    private static Observable<List<LeoWord>> sData;
    private static LeoDictionaryApplication sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sApi = ApiModule.initRetrofit().create(API.class);
        //TODO get data from DB and in another thread try to make request and update data
//        sData = ModelImpl.get().getJsonDictionary(getApplicationContext());
        sData = ModelImpl.get().getDictionary(sApi);
    }

    public LeoDictionaryApplication() {
        sInstance = this;
    }

    public static LeoDictionaryApplication get() {
        return sInstance;
    }

    public Observable<List<LeoWord>> getData() {
        return sData;
    }

    public API getAPI() {
        return sApi;
    }
}
