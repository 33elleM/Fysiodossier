package com.example.steri.fysiodossier;

import android.database.Cursor;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.google.common.collect.Range;

import com.example.steri.fysiodossier.databinding.FragmentPatientGegevensBinding;

import java.util.ArrayList;
import java.util.List;


/**
 * Extension of the {@link Fragment} subclass.
 * Fragment to hold the personal data of the patient
 */
public class PatientGegevensFragment extends Fragment {

    public Patient patient;
    public PatientGegevensFragment() {
        // Required empty public constructor
         }

    /**
     * Called immediately after {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}
     * has returned, but before any saved state has been restored in to the view.
     * This gives subclasses a chance to initialize themselves once
     * they know their view hierarchy has been completely created.  The fragment's
     * view hierarchy is not however attached to its parent at this point.
     *

     * @param savedInstanceState If non-null, this fragment is being re-constructed
     */
//    @Override
//    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
//        FragmentPatientGegevensBinding binding  = DataBindingUtil.inflate(
//                inflater, R.layout.fragment_patient_gegevens, container, false);
//        final View view = binding.getRoot();
//        binding.setPatient(patient);
        final View view = inflater.inflate(R.layout.fragment_patient_gegevens, container, false);

        Button newPtButton, saveButton, checkButton;
        Spinner patientSpinner;
        final EditText mFirstNameEditText, mLastNameEditText, mStreetEditText,mHouseNumberEditText, mZipCodeEditText, mCityEditText;
        final EditText mPhoneEditText, mEmailEditText, mBirthDayEditText, mBSNEditText, mInsCompEditText, mInsNumbEditText ;
        final TextView counterView;
        final DatabaseHandler dbHandler = new DatabaseHandler(getActivity());

        newPtButton = (Button)view.findViewById(R.id.new_Pt_Button);
        saveButton = (Button) view.findViewById(R.id.saveNewPatient);
        checkButton = (Button) view.findViewById(R.id.checkData);
        mFirstNameEditText = (EditText)view.findViewById(R.id.firstName);
        mLastNameEditText = (EditText)view.findViewById(R.id.lastName);
        mStreetEditText = (EditText)view.findViewById(R.id.street) ;
        mHouseNumberEditText = (EditText)view.findViewById(R.id.houseNumber);
        mZipCodeEditText = (EditText)view.findViewById(R.id.zipCode);
        mCityEditText = (EditText)view.findViewById(R.id.city);
        mPhoneEditText = (EditText)view.findViewById(R.id.phoneNumber);
        mEmailEditText = (EditText)view.findViewById(R.id.email);
        mBirthDayEditText = (EditText)view.findViewById(R.id.birthDate);
        mBSNEditText = (EditText)view.findViewById(R.id.bsn);
        mInsCompEditText = (EditText)view.findViewById(R.id.insCompany);
        mInsNumbEditText = (EditText)view.findViewById((R.id.insNumber));

        //used temporarily to show input results of the database
        counterView = (TextView) view.findViewById(R.id.counter);
//        counterView.setText("");

        newPtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mFirstNameEditText.setEnabled(true);
                mLastNameEditText.setEnabled((true));
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                final String firstname = mFirstNameEditText.getText().toString().trim();
                final String lastname = mLastNameEditText.getText().toString().trim();
                final String street = mStreetEditText.getText().toString().trim();
                final String houseNumber = mHouseNumberEditText.getText().toString().trim();
                final String zipCode = mZipCodeEditText.getText().toString().trim();
                final String city = mCityEditText.getText().toString().trim();
                final String phoneNumber = mPhoneEditText.getText().toString().trim();
                final String email = mEmailEditText.getText().toString().trim();
                final String birthDay = mBirthDayEditText.getText().toString().trim();
                final String bsn = mBSNEditText.getText().toString().trim();
                final String insComp = mInsCompEditText.getText().toString().trim();
                final String insNumber = mInsNumbEditText.getText().toString().trim();

                //prevent invalid input snd form validation
//                switch  {
//                    case firstname.isEmpty() :
//                        mFirstNameEditText.setText("Voornaam verplicht");
//
//                    default: dbHandler.addPatient(firstname, lastname, street, houseNumber, zipCode, city, phoneNumber, email, birthDay, bsn, insComp, insNumber);
//                }


//                mRoepnaamEditText.setText("");
//                mLastNameEditText.setText("");
                dbHandler.addPatient(firstname, lastname, street, houseNumber, zipCode, city, phoneNumber, email, birthDay, bsn, insComp, insNumber);
            }
        });

        checkButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Cursor cursor = dbHandler.getAllData();
                if(cursor.getCount() == 0) {
                    // show message
                    counterView.setText("Error, Nothing found");
                    return;
                }

                StringBuffer buffer = new StringBuffer();
                while (cursor.moveToNext()) {
                    buffer.append("Id :"+ cursor.getString(0)+"\n");
                    buffer.append("Voornaam :"+ cursor.getString(1)+"\n");
                    buffer.append("Achternaam :"+ cursor.getString(2)+"\n");
                    if(!cursor.isNull(3) && !cursor.isNull(4)){
                        buffer.append("adres :"+ cursor.getString(3)+ cursor.getString(4) + "\n");}
                    if(!cursor.isNull(5) && !cursor.isNull(6)){
                    buffer.append(cursor.getString(5)+ "" + cursor.getString(6) + "\n");}
                    if (!cursor.isNull(7)) {buffer.append("Telefoon :"+ cursor.getString(7)+"\n");}
                    if (!cursor.isNull(8)) {buffer.append("E-mail: "+ cursor.getString(8)+"\n");}
                    if (!cursor.isNull(9)) {buffer.append("Geboren :"+ cursor.getString(9)+"\n");}
                    if (!cursor.isNull(10)) {buffer.append("BSN :"+ cursor.getString(10)+"\n");}
                    if (!cursor.isNull(11)) {buffer.append("Verzekering :"+ cursor.getString(11)+"\n");}
                    if (!cursor.isNull(12)) {buffer.append("Nummer :"+ cursor.getString(12)+"\n\n");}

                }

                // Show all data
                counterView.setText(buffer.toString());

            }
        });




        // spinner element
        patientSpinner = (Spinner) view.findViewById(R.id.search_box);

        //spinner drop down elements
        List<String> pt = new ArrayList<>();
        pt.add("Melle Steringa");
        pt.add("Willeke van de Vorst");
        pt.add("Loran Steringa");
        pt.add("Hilde Oomes");
        pt.add("Paula Beune");
        pt.add("Isa Steringa");

        final List<String> patientGegevens = new ArrayList<>();
//        patientGegevens = dbHandler.getAllPatients();

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, pt);

        // Specify the layout to use when the list of choices appears
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Set adapter to searchbox
        patientSpinner.setAdapter(dataAdapter);

        //spinner click listener
        patientSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                Cursor res = dbHandler.getAllData();
//                if(res.getCount() == 0) {
//                    // show message
//                    counterView.setText("Error, Nothing found");
//                    return;
//                }
//
//                String patientString = new String();
//                while (res.moveToNext()) {
//                    patientString.concat( res.getString(1)+ res.getString(2) );
//                     }
//                patientGegevens.add(patientString);

                String item = parent.getItemAtPosition(position).toString();
                // Showing selected spinner item
                Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




        // Inflate the layout for this fragment
        return view;
    }



}

