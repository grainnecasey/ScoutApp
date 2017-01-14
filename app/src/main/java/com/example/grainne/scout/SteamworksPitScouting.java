package com.example.grainne.scout;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class SteamworksPitScouting extends AppCompatActivity {

    String filename;
    String output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_steamworks_pit_scouting);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        filename = "steampitscout.txt";
    }

    public void submitOnClick(View v) {

        //save data as output

        File root = android.os.Environment.getExternalStorageDirectory();

        //creating file to save data to
        File dir = new File (root.getAbsolutePath() + "/download/" + filename);

        if (dir.exists()) {
            try {
                FileOutputStream f = new FileOutputStream(dir, true); //true = append mode
                OutputStreamWriter osw = new OutputStreamWriter(f);
                osw.write("\n" + output);
                osw.flush();
                osw.close();

                System.out.println(dir.getAbsolutePath());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Log.i("FILENOTFOUND", "******* File not found");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {


            //File file = new File(dir, filename);

            try {
                dir.createNewFile();
                FileOutputStream f = new FileOutputStream(dir);
                PrintWriter pw = new PrintWriter(f);
                pw.println(output);
                pw.flush();
                pw.close();
                f.close();
                System.out.println(dir.getAbsolutePath());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Log.i("FILENOTFOUND", "******* File not found");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
