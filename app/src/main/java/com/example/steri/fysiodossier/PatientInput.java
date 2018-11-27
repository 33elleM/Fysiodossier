package com.example.steri.fysiodossier;

/**
 * Created by steri on 19-4-2017.
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import java.util.Date;

public class PatientInput extends AppCompatActivity {
    private TextView showDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_input);

        Date date = new Date();
        //huidige datum invoeren bij het aanmeldscherm

        //DATUM MOET NOG JUIST WORDEN GEFORMATTEERD !!
        showDate = (TextView)findViewById(R.id.date_label_date);
        showDate.setText(date.toString());

    }
}
