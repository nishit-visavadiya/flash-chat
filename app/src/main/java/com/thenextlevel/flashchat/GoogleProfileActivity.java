package com.thenextlevel.flashchat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

import de.hdodenhof.circleimageview.CircleImageView;

public class GoogleProfileActivity extends AppCompatActivity {

    CircleImageView google_profile;
    TextView googleName, googleEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_profile);

        Toolbar toolbar=findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Profile");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        google_profile = findViewById(R.id.google_profile_pic);
        googleName = findViewById(R.id.google_name);
        googleEmail = findViewById(R.id.google_email);

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if (acct != null) {
            String personName = acct.getDisplayName();
            String personEmail = acct.getEmail();
            Uri personPhoto = acct.getPhotoUrl();

            googleName.setText(personName);
            googleEmail.setText(personEmail);
            Glide.with(GoogleProfileActivity.this).load(String.valueOf(personPhoto)).into(google_profile);
        }
    }
}
