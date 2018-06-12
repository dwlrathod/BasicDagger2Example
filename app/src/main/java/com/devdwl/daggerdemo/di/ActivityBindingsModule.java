package com.devdwl.daggerdemo.di;

import com.devdwl.daggerdemo.ui.MainActivity;
import com.devdwl.daggerdemo.di.scopes.PerActivity;

import dagger.Module;
import dagger.android.AndroidInjectionModule;
import dagger.android.ContributesAndroidInjector;

@Module(includes = AndroidInjectionModule.class)
abstract class ActivityBindingsModule {

    @PerActivity
    @ContributesAndroidInjector()
    abstract MainActivity mainActivityInjector();
}
