package com.devdwl.daggerdemo.utills;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

import java.util.Map;
import java.util.Set;

public class Prefs {

    private static final String TAG = "Prefs";
    private static Prefs singleton = null;

    private static SharedPreferences preferences;
    private static SharedPreferences.Editor editor;

    @SuppressLint("CommitPrefEdits")
    Prefs(Context context) {
        preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    public static Prefs with(Context context) {
        if (singleton == null) {
            singleton = new Builder(context).build();
        }
        return singleton;
    }

    
    public void save(String key, String value) {
        editor.putString(key, value).apply();
    }

    public String getString(String key, String defValue) {
        return preferences.getString(key, defValue);
    }

    private static class Builder {

        private final Context context;
        Builder(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null.");
            }
            this.context = context.getApplicationContext();
        }
        Prefs build() {
            return new Prefs(context);
        }
    }

}
