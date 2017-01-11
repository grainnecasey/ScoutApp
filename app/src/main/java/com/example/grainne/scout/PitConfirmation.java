package com.example.grainne.scout;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class PitConfirmation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pit_confirmation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    public void mainMenOnClick(View v) {
        Intent i = new Intent(PitConfirmation.this, StartScreen.class);
        startActivity(i);
    }

    public void strongMenOnClick(View v) {
        Intent i = new Intent(PitConfirmation.this, StrongholdMenu.class);
        startActivity(i);
    }

}
