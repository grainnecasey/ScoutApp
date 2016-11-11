package com.example.grainne.scout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Switch;

import java.io.File;
import java.io.FileOutputStream;

public class PitScoutStronghold extends AppCompatActivity {

    boolean chevalbool;
    boolean rockWallBool;
    boolean roughTerrainBool;
    boolean moatBool;
    boolean rampartsBool;
    boolean sallyPortBool;
    boolean drawBridgeBool;
    boolean lowBarBool;
    boolean highBoalBool;
    boolean lowGoalBool;
    boolean portBool;

    //rating bar result?

    String shotQualSt;
    String teamNumSt;
    String autoComSt;
    String scoutNameSt;

    Switch chevalSw;
    Switch rockWallSw;
    Switch roughTerrainSw;
    Switch moatSw;
    Switch rampartsSw;
    Switch sallyPortSw;
    Switch drawBridgeSw;
    Switch lowBarSw;
    Switch portSw;

    Switch highGoalSw;
    Switch lowGoalSw;

    EditText shotQualNum;
    EditText scoutName;
    EditText teamNum;
    EditText autoComments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pit_scout_stronghold);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        chevalSw = (Switch) findViewById(R.id.cheval);
        rockWallSw = (Switch) findViewById(R.id.rock);
        roughTerrainSw = (Switch) findViewById(R.id.rough);
        moatSw = (Switch) findViewById(R.id.moat);
        rampartsSw = (Switch) findViewById(R.id.ramparts);
        sallyPortSw = (Switch) findViewById(R.id.sally);
        drawBridgeSw = (Switch) findViewById(R.id.draw);
        lowBarSw = (Switch) findViewById(R.id.lowbar);
        portSw = (Switch) findViewById(R.id.port);

        highGoalSw = (Switch) findViewById(R.id.highg);
        lowGoalSw = (Switch) findViewById(R.id.lowg);

        shotQualNum = (EditText) findViewById(R.id.shotQual);
        scoutName = (EditText) findViewById(R.id.scouterName);
        teamNum = (EditText) findViewById(R.id.teamNum);
        autoComments = (EditText) findViewById(R.id.autocomments);

    }


    public void submitOnClick(View v) {

        chevalbool = chevalSw.isChecked();
        rockWallBool = rockWallSw.isChecked();
        roughTerrainBool = roughTerrainSw.isChecked();
        moatBool = moatSw.isChecked();
        rampartsBool = rampartsSw.isChecked();
        sallyPortBool = sallyPortSw.isChecked();
        drawBridgeBool = drawBridgeSw.isChecked();
        lowBarBool = lowBarSw.isChecked();
        highBoalBool = highGoalSw.isChecked();
        lowGoalBool = lowGoalSw.isChecked();
        portBool = portSw.isChecked();

        teamNumSt = teamNum.toString();
        autoComSt = autoComments.toString();
        scoutNameSt = scoutName.toString();
        shotQualSt = shotQualNum.toString();


        String output = chevalbool + "•" + rockWallBool + "•" + roughTerrainBool + "•" + moatBool + "•" +
                rampartsBool + "•" + sallyPortBool + "•" + drawBridgeBool + "•" + lowBarBool + "•" + portBool
                + "•" + highBoalBool + "•" + lowGoalBool + "•" + teamNumSt + "•" + autoComSt + "•" + scoutNameSt
                + "•" + shotQualSt;

        if (teamNumSt != null) {

            String filename = "pitscout" + teamNumSt;
            FileOutputStream outputStream;

            File file = new File(getFilesDir(), filename);

            try {
                outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
                outputStream.write(output.getBytes());
                outputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            Intent i = new Intent(PitScoutStronghold.this, PitConfirmation.class);
            startActivity(i);


        } else {
            AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
            dlgAlert.setMessage("You cannot submit without entering a team number!");
            dlgAlert.setTitle("Wait a diddly darn second!");
            dlgAlert.setPositiveButton("Sorry my bad", null);
            dlgAlert.setCancelable(true);
            dlgAlert.create().show();
        }




    }
}
