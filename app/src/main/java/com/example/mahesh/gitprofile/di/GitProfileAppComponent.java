package com.example.mahesh.gitprofile.di;

import com.example.mahesh.gitprofile.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {GitProfileModule.class})
public interface GitProfileAppComponent {

     void inject(MainActivity mainActivity);
}
