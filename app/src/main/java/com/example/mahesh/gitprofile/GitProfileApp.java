package com.example.mahesh.gitprofile;

import android.app.Application;
import android.content.Context;

import com.example.mahesh.gitprofile.di.DaggerGitProfileAppComponent;
import com.example.mahesh.gitprofile.di.GitProfileAppComponent;

public class GitProfileApp extends Application {

    private GitProfileAppComponent gitProfileAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        gitProfileAppComponent = DaggerGitProfileAppComponent.create();
    }

    public static  GitProfileAppComponent getGitProfileAppComponent(Context context){
        return ((GitProfileApp)context.getApplicationContext()).gitProfileAppComponent;
    }
}
