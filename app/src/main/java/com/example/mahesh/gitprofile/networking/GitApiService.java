package com.example.mahesh.gitprofile.networking;

import com.example.mahesh.gitprofile.model.Profile;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitApiService {

    @GET("users/{username}")
    Call<Profile> getProfile(@Path("username") String username);

}
