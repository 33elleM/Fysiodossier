package com.example.steri.fysiodossier;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;



/**
 * Subclass for loading the exam conclusion
 *
 * A simple {@link Fragment} subclass.
 */
public class ConclusieFragment extends Fragment {


    public WebView mWebView;

    public ConclusieFragment() {
        // Required empty public constructor
    }






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v = inflater.inflate(R.layout.fragment_conclusie, container, false);
        final String [] URL = {
                            "https://www.fysionet-evidencebased.nl/index.php/richtlijnen/algemeen",
                            "https://www.fysionet-evidencebased.nl/index.php/richtlijnen/richtlijnen/artrose-heup-knie-2010/praktijkrichtlijn",
                            "https://www.fysionet-evidencebased.nl/index.php/richtlijnen/richtlijnen/beroerte-2014/praktijkrichtlijn",
                            "https://www.fysionet-evidencebased.nl/index.php/richtlijnen/richtlijnen/copd/praktijkrichtlijn-4",
                            "https://www.fysionet-evidencebased.nl/index.php/richtlijnen/richtlijnen/enkelletsel/praktijkrichtlijn-5",
                            "https://www.fysionet-evidencebased.nl/index.php/richtlijnen/richtlijnen/hartrevalidatie-2011/praktijkrichtlijn",
                            "https://www.fysionet-evidencebased.nl/index.php/richtlijnen/richtlijnen/klachten-aan-de-arm-nek-enof-schouder-kans/praktijkrichtlijn-9",
                            "https://www.fysionet-evidencebased.nl/index.php/richtlijnen/richtlijnen/lage-rugpijn-2013/praktijkrichtlijn",
                            "https://www.fysionet-evidencebased.nl/index.php/richtlijnen/richtlijnen/meniscectomie/praktijkrichtlijn-12",
                            "https://www.fysionet-evidencebased.nl/index.php/richtlijnen/richtlijnen/nekpijn/praktijkrichtlijn-nekpijn",
                            "https://www.fysionet-evidencebased.nl/index.php/richtlijnen/richtlijnen/osteoporose/praktijkrichtlijn-13",
                            "https://www.fysionet-evidencebased.nl/index.php/richtlijnen/richtlijnen/parkinson/praktijkrichtlijn-14",
                            "https://www.fysionet-evidencebased.nl/index.php/richtlijnen/richtlijnen/reumatoide-artritis/praktijkrichtlijn-15",
                            "https://www.fysionet-evidencebased.nl/index.php/richtlijnen/richtlijnen/stress-urine-incontinentie-2011/praktijkrichtlijn-16",
                            "https://www.fysionet-evidencebased.nl/index.php/richtlijnen/richtlijnen/symptomatisch-perifeer-arterieel-vaatlijden/praktijkrichtlijn",
                            "https://www.fysionet-evidencebased.nl/index.php/richtlijnen/richtlijnen/zwangerschapsgerelateerde-bekkenpijn/praktijkrichtlijn",


        };


        // spinner element
        Spinner richtlijnSpinner = (Spinner) v.findViewById(R.id.richtlijn_spinner);

        //spinner drop down elements
        List<String> richtlijnen = new ArrayList<String>();
        richtlijnen.add("SELECTEER");
        richtlijnen.add("Artrose heup-knie");
        richtlijnen.add("Beroerte 2014");
        richtlijnen.add("COPD");
        richtlijnen.add("Enkelletsel");
        richtlijnen.add("Hartrevalidatie");
        richtlijnen.add("Klachten aan de arm nek en of schouder KANS");
        richtlijnen.add("Lage rugpijn");
        richtlijnen.add("Meniscectomie");
        richtlijnen.add("Nekpijn");
        richtlijnen.add("Osteoporose");
        richtlijnen.add("Parkinson");
        richtlijnen.add("Reumatoide artritis");
        richtlijnen.add("Stress urine-incontinentie");
        richtlijnen.add("Symptomatisch perifeer arterieel vaatlijden");
        richtlijnen.add("Zwangerschapsgerelateerde bekkenpijn");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, richtlijnen);

        // Specify the layout to use when the list of choices appears
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        richtlijnSpinner.setAdapter(dataAdapter);

        //spinner click listener
        richtlijnSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();

                // Showing selected spinner item
                Toast.makeText(parent.getContext(), "Richtlijn " + item + " wordt opgezocht", Toast.LENGTH_LONG).show();
                // Showing url belonging to spinner object
                String webSite = URL[position];
                // Only load a website for guidelines on treatment when a diagnose in the list is selected

                try {
                    mWebView = (WebView) v.findViewById(R.id.webview);

                    // Enable Javascript in websites
                    WebSettings webSettings = mWebView.getSettings();
                    webSettings.setJavaScriptEnabled(true);

                    // Force links and redirects to open in the WebView instead of in a browser
                    mWebView.setWebViewClient(new WebViewClient());
                    mWebView.loadUrl(webSite);
                    Log.i("WebView", "WebView loaded succesfully");


                } catch (Exception e) {
                    e.printStackTrace();

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Inflate the layout for this fragment
        return v;
    }

}
