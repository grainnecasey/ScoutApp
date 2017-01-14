package com.example.grainne.scout;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class SteamworksConfirmationPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_steamworks_confirmation_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




    }

    public void mainMenOnClick(View v) {
        Intent i = new Intent(SteamworksConfirmationPage.this, StartScreen.class);
        startActivity(i);
    }

    public void steamMenOnClick(View v) {
        Intent i = new Intent(SteamworksConfirmationPage.this, SteamworksMenu.class);
        startActivity(i);
    }

}
