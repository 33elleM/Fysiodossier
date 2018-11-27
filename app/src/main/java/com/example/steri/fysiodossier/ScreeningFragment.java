package com.example.steri.fysiodossier;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class ScreeningFragment extends Fragment {

    public Switch t1;
    public TextView stateYesNo;


    public ScreeningFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_screening, container, false);

        t1 = (Switch) view.findViewById(R.id.switch1);
;
        t1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {

            }
        });

        return view;
    }

}
