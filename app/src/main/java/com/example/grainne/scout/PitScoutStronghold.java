package com.example.grainne.scout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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

    //rating bar result?

    String teamNumSt;
    String autoComSt;

    Switch chevalSw;
    Switch rockWallSw;
    Switch roughTerrainSw;
    Switch moatSw;
    Switch rampartsSw;
    Switch sallyPortSw;
    Switch drawBridgeSw;
    Switch lowBarSw;

    Switch highGoalSw;
    Switch lowGoalSw;

    RatingBar shotQualBar;

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
        rockWallSw = (Switch) findViewById(R.id.RockWall);
        roughTerrainSw = (Switch) findViewById(R.id.roughterrain);
        moatSw = (Switch) findViewById(R.id.Moat);
        rampartsSw = (Switch) findViewById(R.id.ramparts);
        sallyPortSw = (Switch) findViewById(R.id.sallyport);
        drawBridgeSw = (Switch) findViewById(R.id.drawbridge);
        lowBarSw = (Switch) findViewById(R.id.lowbar);

        highGoalSw = (Switch) findViewById(R.id.highgoal);
        lowGoalSw = (Switch) findViewById(R.id.lowgoal);

        shotQualBar = (RatingBar) findViewById(R.id.ratingBar2);

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

        teamNumSt = teamNum.toString();
        autoComSt = autoComments.toString();

        //rating bar?

        String output = chevalbool + "•" + rockWallBool + "•" + roughTerrainBool + "•" + moatBool + "•" +
                rampartsBool + "•" + sallyPortBool + "•" + drawBridgeBool + "•" + lowBarBool + "•" + highBoalBool + "•" +
                lowGoalBool + "•" + teamNumSt + "•" + autoComSt;

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


        } else {
            //display error message
        }




    }
}
