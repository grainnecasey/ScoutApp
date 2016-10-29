package com.example.grainne.scout;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import static com.example.grainne.scout.R.styleable.FloatingActionButton;
import static com.example.grainne.scout.R.styleable.Toolbar;

public class MatchScoutStronghold extends AppCompatActivity {

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
    }

    public int[] valueArray = new int[] {0,0,0,0,0,0,0,0,0,0,0};
    public int statChoice = 0;

   /*
    0=low bar
    1=chival de friese
    2=ramparts
    3=moat
    4=rockwall
    5=rough terrain
    6=drawbridge
    7=sally port
    8=portcullus
    9=high shot
    10=low shot
     */

    // make 11 buttons, one for each stat that is tracked. then add a numeric val to each that corresponds with valueArray[]. set it so that
    // whenever you click on one of these buttons, the value of that stat is shown and when you change the textView that shows that stat
    //the value of it is changed as well


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