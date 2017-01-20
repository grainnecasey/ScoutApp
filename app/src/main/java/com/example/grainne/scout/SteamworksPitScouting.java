package com.example.grainne.scout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class SteamworksPitScouting extends AppCompatActivity {

    String filename;
    String output;

    boolean autoGear;
    boolean autoShootHigh;
    boolean autoShootLow;
    boolean autoHop;
    boolean specStart;
    boolean teleGear;
    boolean teleShootHigh;
    boolean teleShootLow;
    String roboSpeed;
    String shootSpeed;
    String shootAcc;
    boolean canClimb;
    String climbSpeed;
    String endStrat;
    String strat;
    String idealAlli;
    String ballCap;
    String fieldUsage;
    String scoutName;
    String teamNum;
    String addNotes;
    String intake;

    CheckBox autoGearCh;
    CheckBox autoShootHighCh;
    CheckBox autoShootLowCh;
    CheckBox autoHopCh;
    CheckBox specStartCh;
    CheckBox teleGearCh;
    CheckBox teleShootHighCh;
    CheckBox teleShootLowCh;
    EditText roboSpeedNum;
    EditText shootSpeedNum;
    EditText shootAccNum;
    CheckBox canClimbCh;
    EditText climbSpeedNum;
    EditText endStratTxt;
    EditText stratTxt;
    EditText idealAlliTxt;
    EditText ballCapNum;
    EditText fieldUsageTxt;
    EditText scoutNameTxt;
    EditText teamNumNum;
    EditText addNotesTxt;
    EditText intakeTxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_steamworks_pit_scouting);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        autoGearCh = (CheckBox) findViewById(R.id.gearCheck);
        autoShootHighCh = (CheckBox) findViewById(R.id.autoHighShootCheck);
        autoShootLowCh = (CheckBox) findViewById(R.id.autoLowShootCheck);
        autoHopCh = (CheckBox) findViewById(R.id.autoHopperCheck);
        specStartCh = (CheckBox) findViewById(R.id.startplaceCheck);
        teleGearCh  = (CheckBox) findViewById(R.id.teleGearCheck);
        teleShootHighCh = (CheckBox) findViewById(R.id.highshootCheck);
        teleShootLowCh = (CheckBox) findViewById(R.id.teleShootLowCheck);
        roboSpeedNum = (EditText) findViewById(R.id.robotSpeedNum);
        shootSpeedNum = (EditText) findViewById(R.id.shooterSpeedNum);
        shootAccNum = (EditText) findViewById(R.id.shootaccuracyNum);
        canClimbCh = (CheckBox) findViewById(R.id.climbCheck);
        climbSpeedNum = (EditText) findViewById(R.id.climbSpeedNum);
        endStratTxt = (EditText) findViewById(R.id.endgameStrat);
        stratTxt = (EditText) findViewById(R.id.basicStrat);
        idealAlliTxt = (EditText) findViewById(R.id.idealAlliance);
        ballCapNum = (EditText) findViewById(R.id.ballCapacNum);
        fieldUsageTxt = (EditText) findViewById(R.id.whereInField);
        scoutNameTxt = (EditText) findViewById(R.id.scoutName);
        teamNumNum = (EditText) findViewById(R.id.teamNum);
        addNotesTxt = (EditText) findViewById(R.id.exNotes);
        intakeTxt = (EditText) findViewById(R.id.intakeTypeBox);



        filename = "steampitscout.txt";
    }

    public void submitOnClick(View v) {

        autoGear = autoGearCh.isChecked();
        autoShootHigh = autoShootHighCh.isChecked();
        autoShootLow = autoShootLowCh.isChecked();
        autoHop = autoHopCh.isChecked();
        specStart = specStartCh.isChecked();
        teleGear = teleGearCh.isChecked();
        teleShootHigh = teleShootHighCh.isChecked();
        teleShootLow = teleShootLowCh.isChecked();
        roboSpeed = roboSpeedNum.getText().toString();
        shootSpeed = shootSpeedNum.getText().toString();
        shootAcc = shootAccNum.getText().toString();
        canClimb = canClimbCh.isChecked();
        climbSpeed = climbSpeedNum.getText().toString();
        endStrat = endStratTxt.getText().toString();
        strat = stratTxt.getText().toString();
        idealAlli = idealAlliTxt.getText().toString();
        ballCap = ballCapNum.getText().toString();
        fieldUsage = fieldUsageTxt.getText().toString();
        scoutName = scoutNameTxt.getText().toString();
        teamNum = teamNumNum.getText().toString();
        addNotes = addNotesTxt.getText().toString();
        intake = intakeTxt.getText().toString();

        output = teamNum + "}" + autoGear + "}" + autoShootHigh + "}" + autoShootLow + "}" + autoHop + "}" +
                specStart + "}" + teleGear + "}" + teleShootHigh + "}" + teleShootLow + "}" + roboSpeed + "}" +
                shootSpeed + "}" + shootAcc + "}" + canClimb + "}" + climbSpeed + "}" + endStrat + "}" +
                strat + "}" + idealAlli + "}" + ballCap + "}" + fieldUsage + "}" + scoutName + "}" + addNotes
                + "}" + intake;


        //save data as output

        File root = android.os.Environment.getExternalStorageDirectory();

        //creating file to save data to
        File dir = new File(root.getAbsolutePath() + "/download/" + filename);

        if (teamNum.trim().isEmpty() || scoutName.trim().isEmpty()) {
            Toast.makeText(this, "plz enter your name or/and team #", Toast.LENGTH_SHORT).show();
            return;
        } else {
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

            Intent i = new Intent(SteamworksPitScouting.this, SteamworksConfirmationPage.class);
            startActivity(i);
        }
    }

}
