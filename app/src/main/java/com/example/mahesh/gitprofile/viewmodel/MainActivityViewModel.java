package com.example.mahesh.gitprofile.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.mahesh.gitprofile.model.Profile;
import com.example.mahesh.gitprofile.networking.GitApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityViewModel extends ViewModel {

    MutableLiveData<Profile> profileMutableLiveData = new MutableLiveData<>();

    public LiveData<Profile> getProfile() {
        return profileMutableLiveData;
    }


    public void fetchProfile(GitApiService gitApiService, String username){
        Call<Profile> callProfile = gitApiService.getProfile(username);
        callProfile.enqueue(new Callback<Profile>() {
            @Override
            public void onResponse(Call<Profile> call, Response<Profile> response) {
                profileMutableLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<Profile> call, Throwable t) {

            }
        });
    }
}
