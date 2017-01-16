package com.example.grainne.scout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class SteamworksAdditionalNotes extends AppCompatActivity {

    Button Submit;

    EditText AdditionalNotes;
    EditText TeamNumber;
    EditText ScouterName;
    EditText Strategy;
    EditText Quality;
    EditText Driveteam;

    String AdditionalNotesSt;
    String TeamNumSt;
    String ScouterNameSt;
    String StrategySt;
    String QualitySt;
    String DriveteamSt;

    CheckBox Survive;

    Boolean SurviveBool;

    String filename;
    String output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_steamworks_additional_notes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        AdditionalNotes = (EditText) findViewById(R.id.edtAdditionalNotes);
        TeamNumber = (EditText) findViewById(R.id.edtTeamNum);
        ScouterName = (EditText) findViewById(R.id.edtName);
        Strategy = (EditText) findViewById(R.id.edtStrategic);
        Quality = (EditText) findViewById(R.id.edtQuality);
        Driveteam = (EditText) findViewById(R.id.edtDriveteam);

        Survive = (CheckBox) findViewById(R.id.ckbSurvive);

        Submit = (Button) findViewById(R.id.btnSubmit);


        filename = "steammatchscout.txt";
    }

    public void submitAdditionalNotesOnClick(View v) {

        //save data as output

        File root = android.os.Environment.getExternalStorageDirectory();

        AdditionalNotesSt = AdditionalNotes.getText().toString();
        TeamNumSt = TeamNumber.getText().toString();
        ScouterNameSt = ScouterName.getText().toString();
        StrategySt = Strategy.getText().toString();
        QualitySt = Quality.getText().toString();
        DriveteamSt = Driveteam.getText().toString();

        SurviveBool = Survive.isChecked();

        output = SurviveBool + " }" + QualitySt + " }" + ScouterNameSt + " }" + StrategySt + " }" + DriveteamSt + " }" + AdditionalNotesSt + " }"+ "\n";

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
            Intent i = new Intent(SteamworksAdditionalNotes.this, SteamworksMenu.class);
            startActivity(i);

        }
    }


