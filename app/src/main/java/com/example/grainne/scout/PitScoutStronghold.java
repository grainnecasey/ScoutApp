package com.example.grainne.scout;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Switch;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

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

        chevalbool = chevalSw.isActivated();
        rockWallBool = rockWallSw.isActivated();
        roughTerrainBool = roughTerrainSw.isActivated();
        moatBool = moatSw.isActivated();
        rampartsBool = rampartsSw.isActivated();
        sallyPortBool = sallyPortSw.isActivated();
        drawBridgeBool = drawBridgeSw.isActivated();
        lowBarBool = lowBarSw.isActivated();
        highBoalBool = highGoalSw.isActivated();
        lowGoalBool = lowGoalSw.isActivated();
        portBool = portSw.isActivated();

        teamNumSt = teamNum.getText().toString();
        autoComSt = autoComments.getText().toString();
        scoutNameSt = scoutName.getText().toString();
        shotQualSt = shotQualNum.getText().toString();


        String output = chevalbool + "•" + rockWallBool + "•" + roughTerrainBool + "•" + moatBool + "•" +
                rampartsBool + "•" + sallyPortBool + "•" + drawBridgeBool + "•" + lowBarBool + "•" + portBool
                + "•" + highBoalBool + "•" + lowGoalBool + "•" + teamNumSt + "•" + autoComSt + "•" + scoutNameSt
                + "•" + shotQualSt;

        if (teamNumSt != null) {

            String filename = "pitscout" + ".txt";

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
                    /*
                    //PrintWriter pw = ;
                    pw.println();
                    pw.println(output);
                    pw.flush();
                    pw.close();
                    f.close();*/
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

            //launching confirmation page
            Intent i = new Intent(PitScoutStronghold.this, PitConfirmation.class);
            startActivity(i);

        } else {
            android.app.AlertDialog.Builder teamnumerror = new android.app.AlertDialog.Builder(this);
            teamnumerror.setMessage("You must enter a team number before submitting").setTitle("Error");
            teamnumerror.setPositiveButton("Start Game",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.dismiss();
                        }
                    });
            teamnumerror.show();
        }




    }
}
