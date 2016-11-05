package com.example.grainne.scout;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import java.io.File;
import java.io.FileOutputStream;

import static com.example.grainne.scout.R.styleable.FloatingActionButton;
import static com.example.grainne.scout.R.styleable.Toolbar;

public class MatchScoutStronghold extends AppCompatActivity {

    public int SallyPortValue = 0;
    public int RockWallValue = 0;
    public int RoughTerrainValue = 0;
    public int CDFValue = 0;
    public int LowBarValue = 0;
    public int PortcullisValue = 0;
    public int RampartsValue = 0;
    public int MoatValue = 0;
    public int DrawbridgeValue = 0;
    public int LowGoalValue = 0;
    public int HighGoalValue = 0;
    public int ValueSelector = 1;

    //ValueSelector identifies which Value is being changed
    /*
        sally = 1
        rock = 2
        rough = 3
        CDF = 4
        low bar = 5
        portcullis = 6
        ramparts = 7
        moat = 8
        drawbridge = 9
        low goal = 10
        high goal = 11
    */

    String TeamNumSt;

    Button SallyPort;
    Button RockWall;
    Button RoughTerrain;
    Button CDF;
    Button LowBar;
    Button Portcullis;
    Button Ramparts;
    Button Moat;
    Button Drawbridge;
    Button LowGoal;
    Button HighGoal;
    Button ValueGain;
    Button ValueLose;

    TextView SallyPortVal;
    TextView RockWallVal;
    TextView RoughTerrainVal;
    TextView CDFVal;
    TextView LowBarVal;
    TextView PortcullisVal;
    TextView RampartsVal;
    TextView MoatVal;
    TextView DrawbridgeVal;
    TextView LowGoalVal;
    TextView HighGoalVal;
    TextView MainVal;


    EditText TeamNum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_scout_stronghold);
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
        SallyPort = (Button) findViewById(R.id.btnSallyPort);
        RockWall = (Button) findViewById(R.id.btnRockWall);
        RoughTerrain = (Button) findViewById(R.id.btnRoughTerrain);
        Moat = (Button) findViewById(R.id.btnMoat);
        Ramparts = (Button) findViewById(R.id.btnRamparts);
        CDF = (Button) findViewById(R.id.btnCDF);
        LowBar = (Button) findViewById(R.id.btnLowBar);
        Portcullis = (Button) findViewById(R.id.btnPortcullis);
        Drawbridge = (Button) findViewById(R.id.btnDrawbridge);

        HighGoal = (Button) findViewById(R.id.btnHighGoal);
        LowGoal = (Button) findViewById(R.id.btnLowGoal);

        ValueGain = (Button) findViewById(R.id.btnGain1);
        ValueLose = (Button) findViewById(R.id.btnLose1);

        SallyPortVal = (TextView) findViewById(R.id.txtSallyPortVal);
        RockWallVal = (TextView) findViewById(R.id.txtRockWallVal);
        RoughTerrainVal = (TextView) findViewById(R.id.txtRoughTerrainVal);
        CDFVal = (TextView) findViewById(R.id.txtCDFVal);
        LowBarVal = (TextView) findViewById(R.id.txtLowBarVal);
        PortcullisVal = (TextView) findViewById(R.id.txtPortcullisVal);
        RampartsVal = (TextView) findViewById(R.id.txtRampartsVal);
        MoatVal = (TextView) findViewById(R.id.txtMoatVal);
        DrawbridgeVal = (TextView) findViewById(R.id.txtDrawbridgeVal);
        LowGoalVal = (TextView) findViewById(R.id.txtLowGoalVal);
        HighGoalVal = (TextView) findViewById(R.id.txtHighGoalVal);
        MainVal = (TextView) findViewById(R.id.txtValue);


        TeamNum = (EditText) findViewById(R.id.edtTeam);
    }


    //When shooting and defence buttons are click, it identifies which value to change
    public void sallyOnClick(View v) {
        ValueSelector = 1;
        MainVal = SallyPortVal;
    }

    public void rockOnCLick(View v) {
        ValueSelector = 2;
        MainVal = RockWallVal;
    }

    public void roughOnCLick(View v) {
        ValueSelector = 3;
        MainVal = RoughTerrainVal;
    }

    public void CDFOnCLick(View v) {
        ValueSelector = 4;
        MainVal = CDFVal;
    }

    public void lowBarOnCLick(View v) {
        ValueSelector = 5;
        MainVal = LowBarVal;
    }

    public void portOnCLick(View v) {
        ValueSelector = 6;
        MainVal = PortcullisVal;
    }

    public void rampOnCLick(View v) {
        ValueSelector = 7;
        MainVal = RampartsVal;
    }

    public void moatOnCLick(View v) {
        ValueSelector = 8;
        MainVal = MoatVal;
    }

    public void drawOnCLick(View v) {
        ValueSelector = 9;
        MainVal = DrawbridgeVal;
    }

    public void lowGoalOnCLick(View v) {
        ValueSelector = 10;
        MainVal = LowGoalVal;
    }

    public void highGoalOnCLick(View v) {
        ValueSelector = 10;
        MainVal = HighGoalVal;
    }


    public void gainOnClick(View v) {
        if (ValueSelector == 1) {
            SallyPortValue += 1;
            MainVal.setText(SallyPortValue + "");
            SallyPortVal.setText(SallyPortValue + "");
        } else if (ValueSelector == 2) {
            RockWallValue += 1;
            MainVal.setText(RockWallValue + "");
            RockWallVal.setText(RockWallValue + "");
        } else if (ValueSelector == 3) {
            RoughTerrainValue += 1;
            MainVal.setText(RoughTerrainValue + "");
            RoughTerrainVal.setText(RoughTerrainValue + "");
        } else if (ValueSelector == 4) {
            CDFValue += 1;
            MainVal.setText(CDFValue + "");
            CDFVal.setText(CDFValue + "");
        } else if (ValueSelector == 5) {
            LowBarValue += 1;
            MainVal.setText(LowBarValue + "");
            LowBarVal.setText(LowBarValue + "");
        } else if (ValueSelector == 6) {
            PortcullisValue += 1;
            MainVal.setText(PortcullisValue + "");
            PortcullisVal.setText(PortcullisValue + "");
        } else if (ValueSelector == 7) {
            RampartsValue += 1;
            MainVal.setText(RampartsValue + "");
            PortcullisVal.setText(RampartsValue + "");
        } else if (ValueSelector == 8) {
            MoatValue += 1;
            MainVal.setText(MoatValue + "");
            PortcullisVal.setText(MoatValue + "");
        } else if (ValueSelector == 9) {
            DrawbridgeValue += 1;
            MainVal.setText(DrawbridgeValue + "");
            DrawbridgeVal.setText(DrawbridgeValue + "");
        } else if (ValueSelector == 10) {
            LowGoalValue += 1;
            MainVal.setText(LowGoalValue + "");
            LowGoalVal.setText(LowGoalValue + "");
        } else if (ValueSelector == 11) {
            HighGoalValue += 1;
            MainVal.setText(HighGoalValue + "");
            HighGoalVal.setText(HighGoalValue + "");
        } else {
            //set error display for no defence/shot selected
        }
    }

    public void loseOnClick(View v) {
        if (ValueSelector == 1) {
            SallyPortValue -= 1;
            MainVal.setText(SallyPortValue + "");
            SallyPortVal.setText(SallyPortValue + "");
        } else if (ValueSelector == 2) {
            RockWallValue -= 1;
            MainVal.setText(RockWallValue + "");
            RockWallVal.setText(RockWallValue + "");
        } else if (ValueSelector == 3) {
            RoughTerrainValue -= 1;
            MainVal.setText(RoughTerrainValue + "");
            RoughTerrainVal.setText(RoughTerrainValue + "");
        } else if (ValueSelector == 4) {
            CDFValue -= 1;
            MainVal.setText(CDFValue + "");
            CDFVal.setText(CDFValue + "");
        } else if (ValueSelector == 5) {
            LowBarValue -= 1;
            MainVal.setText(LowBarValue + "");
            LowBarVal.setText(LowBarValue + "");
        } else if (ValueSelector == 6) {
            PortcullisValue -= 1;
            MainVal.setText(PortcullisValue + "");
            PortcullisVal.setText(PortcullisValue + "");
        } else if (ValueSelector == 7) {
            RampartsValue -= 1;
            MainVal.setText(RampartsValue + "");
            PortcullisVal.setText(RampartsValue + "");
        } else if (ValueSelector == 8) {
            MoatValue -= 1;
            MainVal.setText(MoatValue + "");
            PortcullisVal.setText(MoatValue + "");
        } else if (ValueSelector == 9) {
            DrawbridgeValue -= 1;
            MainVal.setText(DrawbridgeValue + "");
            DrawbridgeVal.setText(DrawbridgeValue + "");
        } else if (ValueSelector == 10) {
            LowGoalValue -= 1;
            MainVal.setText(LowGoalValue + "");
            LowGoalVal.setText(LowGoalValue + "");
        } else if (ValueSelector == 11) {
            HighGoalValue -= 1;
            MainVal.setText(HighGoalValue + "");
            HighGoalVal.setText(HighGoalValue + "");
        } else {
            //set error display for no defence/shot selected
        }
    }


    public void submitMatchOnClick(View v) {


        TeamNumSt = TeamNum.toString();


        String output = SallyPortValue + "•" + RockWallValue + "•" + RoughTerrainValue + "•" + CDFValue + "•" +
                LowBarValue + "•" + PortcullisValue + "•" + RampartsValue + "•" + MoatValue + "•" + DrawbridgeValue + "•" +
                LowGoalValue + "•" + HighGoalValue + "•" + TeamNumSt;

        if (TeamNumSt != null) {

            String filename = "pitscout" + TeamNumSt;
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
            //display error message for empty team number
        }

    }
/*
    public void changeNum(int val) { //changes the number in the text box on scouting screen for the selected defense
        TextView valueBox = (TextView) findViewById(R.id.textViewVal);
        String tempS = valueBox.getText().toString();
        valueArray[statChoice] = Integer.parseInt(tempS);
        valueArray[statChoice] += val;
        valueBox.setText(Integer.toString(valueArray[statChoice]));
    }

    public void changeDisplayVal() {//changes the value of the number in text view val based on the button selected
        TextView valueBox = (TextView) findViewById(R.id.textViewVal);
        valueBox.setText(Integer.toString(valueArray[statChoice]));
    }

*/


}
//floating action button
/*
<android.support.design.widget.FloatingActionButton
        android:id="@+id/fab"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="bottom|end"
        android:layout_margin="@dimen/fab_margin"
        app:srcCompat="@android:drawable/ic_dialog_email" />
 */