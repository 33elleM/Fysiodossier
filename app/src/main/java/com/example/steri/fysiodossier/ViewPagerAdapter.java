package com.example.steri.fysiodossier;

/**
 * Created by M. Steringa on 19-4-2017.
 * Helper class for the ViewPager of the tab toolbar
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;



public class ViewPagerAdapter extends FragmentPagerAdapter {

    // holds the fragments
    ArrayList<Fragment> fragments = new ArrayList<>();
    //holds the tab titles
    ArrayList<String> tabTitles = new ArrayList<>();

    /**
     * method to add the fragments and the titles to the arraylists
     * @param fragment fragment
     * @param titles title of the tab
     */
    public void addFragments(Fragment fragment, String titles){
        this.fragments.add(fragment);
        this.tabTitles.add(titles);
    }


    public ViewPagerAdapter (FragmentManager fm){
        super(fm);

    }

    /**
     * Return the Fragment associated with a specified position.
     *
     * @param position
     */
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position){
        return  tabTitles.get(position);
    }
}