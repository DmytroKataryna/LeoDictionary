package kataryna.dmytro.leodictionary.model.http;

import android.content.Context;

import java.util.List;

import kataryna.dmytro.leodictionary.model.http.api.API;
import kataryna.dmytro.leodictionary.model.data.LeoWord;
import rx.Observable;

/**
 * Created by dmytroKataryna on 13.03.16.
 */
public interface Model {


    Observable<String> getDataVersion(API apiInterface);

    Observable<List<LeoWord>> getDictionary(API apiInterface);

    Observable<List<LeoWord>> getJsonDictionary(Context context);
}
