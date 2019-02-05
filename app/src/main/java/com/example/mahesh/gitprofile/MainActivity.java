package com.example.mahesh.gitprofile;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mahesh.gitprofile.model.Profile;
import com.example.mahesh.gitprofile.networking.GitApiService;
import com.example.mahesh.gitprofile.viewmodel.MainActivityViewModel;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Inject
    GitApiService gitApiService;

    MainActivityViewModel mainActivityViewModel;

    EditText profileName;

    Button fetchProfile;

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GitProfileApp.getGitProfileAppComponent(this ).inject(this);

        profileName = findViewById(R.id.profile_name_txt);
        profileName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        imageView = findViewById(R.id.profile_image);
        fetchProfile = findViewById(R.id.get_profile_btn);


        fetchProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivityViewModel.fetchProfile(gitApiService, profileName.getText().toString());
            }
        });
        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);

        mainActivityViewModel.getProfile().observe(this, new Observer<Profile>() {
            @Override
            public void onChanged(@Nullable Profile profile) {

                ((TextView)findViewById(R.id.title)).setText(profile.getName());

                ((TextView)findViewById(R.id.location)).setText(profile.getLocation());
                Picasso.get().load(profile.getAvatarUrl()).into(imageView);
            }
        });



    }
}
