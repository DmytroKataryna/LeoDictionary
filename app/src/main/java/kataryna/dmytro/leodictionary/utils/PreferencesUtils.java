package kataryna.dmytro.leodictionary.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.SyncStateContract;

/**
 * Created by dmytroKataryna on 09.05.16.
 */
public class PreferencesUtils {

    private static PreferencesUtils sUtils;
    private static SharedPreferences sharedPref;

    // *****************  preferences data *****************
    private static final String KEY_SHARED_PREF = "ANDROID_MATCH";
    private static final int KEY_MODE_PRIVATE = SyncStateContract.Constants.ZERO;


    //************** page selected **************

    private static final String LOADED_PAGE = "loadedPageKey";

    //****************************  PREFERENCES ************************************

    public PreferencesUtils(Context context) {
        sharedPref = context.getSharedPreferences(KEY_SHARED_PREF, KEY_MODE_PRIVATE);
    }

    public static PreferencesUtils get(Context c) {
        if (sUtils == null) {
            sUtils = new PreferencesUtils(c.getApplicationContext());
        }
        return sUtils;
    }

    public void setLoadedPage(int page) {
        sharedPref.edit().putInt(LOADED_PAGE, page).apply();
    }

    public int getLoadedPage() {
        return sharedPref.getInt(LOADED_PAGE, SyncStateContract.Constants.ZERO);
    }

}
