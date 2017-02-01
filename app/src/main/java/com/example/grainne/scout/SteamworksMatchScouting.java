package com.example.grainne.scout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class SteamworksMatchScouting extends AppCompatActivity {

    boolean GearPlacedBool;
    boolean BaselineBool;
    boolean HighGoalBool;
    boolean LowGoalBool;
    boolean LowIntakeBool;
    boolean HighIntakeBool;
    boolean ClimbBool;


    String TeamNumSt;
    String HighGoalMadeSt;
    String LowGoalMadeSt;
    String WhichGearStationSt;
    String CycleTimeSt;
    String TimeToClearSt;
    String GearsPlacedSt;
    String NameSt;
    String AutoHopperSt;
    String TeleopHopperSt;

    Button Submit;

    EditText TeamNum;
    EditText ScoutName;
    EditText HighGoalEdt;
    EditText LowGoalEdt;
    EditText GearStation;
    EditText CycleTime;
    EditText TimeToClear;
    EditText GearsPlacedEdt;
    EditText AutoHopper;
    EditText TeleopHopper;

    CheckBox GearPlacedCkb;
    CheckBox BaseLine;
    CheckBox HighGoalCkb;
    CheckBox LowGoalCkb;
    CheckBox LowIntake;
    CheckBox HighIntake;
    CheckBox Climb;





    String filename;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_steamworks_match_scouting);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Submit = (Button) findViewById(R.id.btnSubmit);

        TeamNum = (EditText) findViewById(R.id.edtTeamNum);
        ScoutName = (EditText) findViewById(R.id.edtName);
        HighGoalEdt = (EditText) findViewById(R.id.edtHighGoal);
        LowGoalEdt = (EditText) findViewById(R.id.edtLowGoal);
        GearStation = (EditText) findViewById(R.id.edtStation);
        CycleTime = (EditText) findViewById(R.id.edtTeleopHopper);
        TimeToClear = (EditText) findViewById(R.id.edtTimeToClear);
        GearsPlacedEdt = (EditText) findViewById(R.id.edtGearsPlaced);
        AutoHopper = (EditText) findViewById(R.id.edtAutoHopper);
        TeleopHopper = (EditText) findViewById(R.id.edtTeleopHopper);

        GearPlacedCkb = (CheckBox) findViewById(R.id.ckbGearPlaced);
        BaseLine = (CheckBox) findViewById(R.id.ckbBaseline);
        HighGoalCkb = (CheckBox) findViewById(R.id.ckbHighGoal);
        LowGoalCkb = (CheckBox) findViewById(R.id.ckbLowGoal);
        HighIntake = (CheckBox) findViewById(R.id.ckbHighIntake);
        LowIntake = (CheckBox) findViewById(R.id.ckbLowIntake);
        Climb = (CheckBox) findViewById(R.id.ckbClimb);


        filename = "steammatchscout.txt";
    }





    public void submitMatchSteamworksOnClick(View v) {

        TeamNumSt = TeamNum.getText().toString();
        NameSt = ScoutName.getText().toString();
        HighGoalMadeSt = HighGoalEdt.getText().toString();
        LowGoalMadeSt = LowGoalEdt.getText().toString();
        WhichGearStationSt = GearStation.getText().toString();
        CycleTimeSt = CycleTime.getText().toString();
        TimeToClearSt = TimeToClear.getText().toString();
        GearsPlacedSt = GearsPlacedEdt.getText().toString();
        AutoHopperSt = AutoHopper.getText().toString();
        TeleopHopperSt = TeleopHopper.getText().toString();

        GearPlacedBool = GearPlacedCkb.isChecked();
        BaselineBool = BaseLine.isChecked();
        HighGoalBool = HighGoalCkb.isChecked();
        LowGoalBool = LowGoalCkb.isChecked();
        LowIntakeBool = LowIntake.isChecked();
        HighIntakeBool = HighIntake.isChecked();
        ClimbBool = Climb.isChecked();

        String output = TeamNumSt + "}" + "match" + "}" + GearPlacedBool + "}" + WhichGearStationSt + "}" + BaselineBool + "}" +
                LowGoalMadeSt + "}" + HighGoalMadeSt + "}" + AutoHopperSt + "}" + LowGoalBool + "}" + HighGoalBool
                + "}" + GearsPlacedSt + "}" + CycleTimeSt + "}" + TimeToClearSt + "}" + ClimbBool + "}";


        //save data as output

        File root = android.os.Environment.getExternalStorageDirectory();

        //creating file to save data to
        File dir = new File (root.getAbsolutePath() + "/download/" + filename);
        if (TeamNumSt.trim().isEmpty()|| NameSt.trim().isEmpty()){
            Toast.makeText(this, "plz enter your name or/and team #", Toast.LENGTH_SHORT).show();
            return;
        }else{

           /* if (dir.exists()) {
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
            }*/
            Intent i = new Intent(SteamworksMatchScouting.this, SteamworksAdditionalNotes.class);
            Bundle b = new Bundle();
            b.putString("matchOutput", output); //Your id
            i.putExtras(b);
            startActivity(i);
        }
    }

}
