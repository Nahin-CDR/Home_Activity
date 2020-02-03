package com.example.home_activity;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
public class MainMenu extends AppCompatActivity {


    Button logout;
    FirebaseAuth mAuth;
    Button update;
    Button search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        getSupportActionBar().hide();
        updateProfile();
        searchData();


        logout = findViewById(R.id.logout_button_id);
        mAuth = FirebaseAuth.getInstance();

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                Intent intent = new Intent(MainMenu.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });
    }

    private void searchData() {

        search = (Button)findViewById(R.id.search_button_id);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SearchData.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slider_1,R.anim.slider_2);

            }
        });

    }

    private void updateProfile() {


        update = (Button)findViewById(R.id.update_profile);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),UpdateProfile.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slider_1,R.anim.slider_2);

            }
        });
    }


}
