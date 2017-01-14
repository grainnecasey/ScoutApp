package com.example.grainne.scout;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class SteamworksMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_steamworks_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    public void steamPitScoutOnClick(View v) {
        Intent i = new Intent(SteamworksMenu.this, SteamworksPitScouting.class);
        startActivity(i);
    }

    public void steamMatchScoutOnClick(View v) {
        Intent i = new Intent(SteamworksMenu.this, SteamworksMatchScouting.class);
        startActivity(i);
    }

}
