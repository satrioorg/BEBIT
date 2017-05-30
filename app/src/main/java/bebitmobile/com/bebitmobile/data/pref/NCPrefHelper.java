package bebitmobile.com.bebitmobile.data.pref;

import android.content.SharedPreferences;

import bebitmobile.com.bebitmobile.BEBITApplication;

/**
 * Created by tunggul.jati on 23/11/2016.
 */

public class NCPrefHelper {
    private static SharedPreferences appPreferences;

    private static void initPref() {
        appPreferences = BEBITApplication.getInstance().getAppSharedPreferences();
    }

    public static void setString(PrefKey key, String value) {
        initPref();
        SharedPreferences.Editor editor = appPreferences.edit();
        editor.putString(key.toString(), value);
        editor.apply();
    }

    public static String getString(PrefKey key) {
        initPref();
        return appPreferences.getString(key.toString(), "");
    }

    public static void setInt(PrefKey key, int value) {
        initPref();
        SharedPreferences.Editor editor = appPreferences.edit();
        editor.putInt(key.toString(), value);
        editor.apply();
    }

    public static int getInt(PrefKey key) {
        initPref();
        return appPreferences.getInt(key.toString(), -1);
    }

    public static void setBoolean(PrefKey key, boolean value) {
        initPref();
        SharedPreferences.Editor editor = appPreferences.edit();
        editor.putBoolean(key.toString(), value);
        editor.apply();
    }

    public static boolean getBoolean(PrefKey key) {
        initPref();
        return appPreferences.getBoolean(key.toString(), false);
    }

    public static void clearPreference(PrefKey key) {
        initPref();
        SharedPreferences.Editor editor = appPreferences.edit();
        editor.remove(key.toString());
        editor.apply();
    }

    public static void clearAllPreferences() {
        initPref();
        SharedPreferences.Editor editor = appPreferences.edit();
        editor.clear();
        editor.apply();
    }
}