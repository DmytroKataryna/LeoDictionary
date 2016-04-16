package kataryna.dmytro.leodictionary.utils;

import android.content.Context;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import kataryna.dmytro.leodictionary.model.data.LeoWord;

/**
 * Created by dmytroKataryna on 19.03.16.
 */
public class AssetsParser {

    public static List<LeoWord> convertJsonToObject(Context context) {
        Type listType = new TypeToken<ArrayList<LeoWord>>() {}.getType();
        return new GsonBuilder().create().fromJson(loadJSONFromAsset(context), listType);
    }

    private static String loadJSONFromAsset(Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open("lingualeo.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
