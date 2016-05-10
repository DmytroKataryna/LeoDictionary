package kataryna.dmytro.leodictionary.model.http.api;


import com.squareup.okhttp.OkHttpClient;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by dmytroKataryna on 16.03.16.
 */
public class ApiModule {

    public static final String BASE_URL = "http://lingualeo.gear.host/api/Lingualeo/";

    public static Retrofit initRetrofit() {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(new OkHttpClient());

        return builder.build();
    }

}
