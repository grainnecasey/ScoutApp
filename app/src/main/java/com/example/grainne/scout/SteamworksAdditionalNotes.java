package com.example.grainne.scout;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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

    String AdditionalNotesSt;
    String TeamNumSt;
    String ScouterNameSt;

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

        Submit = (Button) findViewById(R.id.btnSubmit);


        filename = "steamnotes.txt";
    }

    public void submitAdditionalNotesOnClick(View v) {

        //save data as output

        File root = android.os.Environment.getExternalStorageDirectory();

        AdditionalNotesSt = AdditionalNotes.getText().toString();
        TeamNumSt = TeamNumber.getText().toString();
        ScouterNameSt = ScouterName.getText().toString();

        String output = AdditionalNotesSt + "}" + TeamNumSt + "}" + ScouterNameSt + "}";

        //creating file to save data to
        File dir = new File (root.getAbsolutePath() + "/download/" + filename);
        if (TeamNumSt != null || ScouterNameSt != null) {
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
        }else{
            android.app.AlertDialog.Builder teamnumerror = new android.app.AlertDialog.Builder(this);
            teamnumerror.setMessage("You must enter a team number and your name before submitting").setTitle("Error");
            teamnumerror.setPositiveButton("Edit Input",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.dismiss();
                        }
                    });
            teamnumerror.show();
        }
    }

}
