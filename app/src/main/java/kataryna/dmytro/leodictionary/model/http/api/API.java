package kataryna.dmytro.leodictionary.model.http.api;

import kataryna.dmytro.leodictionary.model.data.Dictionary;
import kataryna.dmytro.leodictionary.model.data.LastUpdateTime;
import retrofit.http.GET;
import retrofit.http.POST;
import rx.Observable;

/**
 * Created by dmytroKataryna on 13.03.16.
 */
public interface API {

    @GET("GetLastUpdateDate")
    Observable<LastUpdateTime> getDataVersion();

    @GET("GetJson")
    Observable<Dictionary> getDictionary();

    @GET("GetValuseWithTranslation")
    Observable<Dictionary> getDictionaryWithTranslation();

    @POST("")
    void sendJsonData(Object jsonDATA);
}
