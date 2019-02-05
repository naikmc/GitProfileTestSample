package com.example.mahesh.gitprofile.di;

import com.example.mahesh.gitprofile.networking.GitApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;


@Module
public class GitProfileModule {

    private final static String GIT_URL = "https://api.github.com/";


    @Provides
    @Singleton
    public Retrofit providesRetrofit(){
        return new Retrofit.Builder()
                .baseUrl(GIT_URL)
                .addConverterFactory(MoshiConverterFactory.create()).build();
    }

    @Provides
    @Singleton
    public GitApiService providesGitApiService(Retrofit retrofit) {
        return retrofit.create(GitApiService.class);
    }

}
