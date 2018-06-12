package com.devdwl.daggerdemo.di;

import android.app.Application;
import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.devdwl.daggerdemo.utills.Prefs;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    @Singleton
    Context bindContext(Application application) {
        return application;
    }

    @Provides
    @Singleton
    Prefs getPrefs(Context context) {
        return Prefs.with(context);
    }

    @Provides
    @Singleton
    RequestManager getGlideRequest(Context context) {
        return Glide.with(context);
    }

}