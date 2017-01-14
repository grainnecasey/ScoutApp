package com.example.grainne.scout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.io.File;

public class StartScreen extends AppCompatActivity {

    public static File strong_match_root;
    public static File strong_match_dir;
    public static File strong_match_file;

    boolean filesCreated = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_start_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void strongButtonOnClick(View v) {
        Intent i = new Intent(StartScreen.this, StrongholdMenu.class);
        startActivity(i);



    }

    public void steamButtonOnClick(View v) {
        Intent i = new Intent(StartScreen.this, SteamworksMenu.class);
        startActivity(i);
    }



}
