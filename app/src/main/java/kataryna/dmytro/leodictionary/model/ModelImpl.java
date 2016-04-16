package kataryna.dmytro.leodictionary.model;

import android.content.Context;

import java.util.List;

import kataryna.dmytro.leodictionary.model.api.API;
import kataryna.dmytro.leodictionary.model.data.Dictionary;
import kataryna.dmytro.leodictionary.model.data.LastUpdateTime;
import kataryna.dmytro.leodictionary.model.data.LeoWord;
import kataryna.dmytro.leodictionary.utils.AssetsParser;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by dmytroKataryna on 13.03.16.
 */
public class ModelImpl implements Model {

    private static Model sInstance;

    private ModelImpl() {
        sInstance = this;
    }

    public static Model get() {
        if (sInstance == null) {
            return new ModelImpl();
        }
        return sInstance;
    }

    @Override
    public Observable<String> getDataVersion(API apiInterface) {
        return apiInterface.getDataVersion()
                .map(new Func1<LastUpdateTime, String>() {
                    @Override
                    public String call(LastUpdateTime lastUpdateTime) {
                        return lastUpdateTime.getTime().getLastUpdateTime();
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<List<LeoWord>> getDictionary(API apiInterface) {
        return apiInterface.getDictionary()
                .map(new Func1<Dictionary, List<LeoWord>>() {
                    @Override
                    public List<LeoWord> call(Dictionary dictionary) {
                        return dictionary.getData();
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<List<LeoWord>> getJsonDictionary(Context context) {
        return Observable.just(AssetsParser.convertJsonToObject(context))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
