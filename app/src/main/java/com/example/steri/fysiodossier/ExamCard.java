package com.example.steri.fysiodossier;

/**
 * Class to show the patient exam in tablayout
 * Created by M. Steringa on 19-4-2017.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ExamCard extends AppCompatActivity {
    Toolbar mToolbar;
    TabLayout mTabLayout;
    ViewPager mViewPager;
    ViewPagerAdapter mViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_card);

        mToolbar = (Toolbar)findViewById(R.id.toolBar);
        setSupportActionBar(mToolbar);
        mTabLayout = (TabLayout)findViewById(R.id.tab_layout);
        mViewPager =(ViewPager) findViewById(R.id.viewPager);
        mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mViewPagerAdapter.addFragments(new PatientGegevensFragment(), "Gegevens");
        mViewPagerAdapter.addFragments(new ScreeningFragment(), "Screening");
        mViewPagerAdapter.addFragments(new AnamneseFragment(), "Anamnese");
        mViewPagerAdapter.addFragments(new OnderzoekFragment(), "Onderzoek");
        mViewPagerAdapter.addFragments(new ConclusieFragment(), "Conclusie");
        mViewPagerAdapter.addFragments(new JournaalFragment(), "Dagjournaal");
        mViewPager.setAdapter(mViewPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
