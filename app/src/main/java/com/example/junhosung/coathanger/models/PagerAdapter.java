package com.example.junhosung.coathanger.models;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.junhosung.coathanger.views.fragments.FemaleRecommendationFragment;
import com.example.junhosung.coathanger.views.fragments.MaleRecommendationFragment;

/**
 * Created by Junho Sung on 12/20/2018.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {

    private int tabNumber;
    public PagerAdapter(FragmentManager fragmentManager,int tabNumber) {
        super(fragmentManager);
        this.tabNumber = tabNumber;
    }

    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                MaleRecommendationFragment maleRecommendationFragment = new MaleRecommendationFragment();
                return maleRecommendationFragment;
            case 1:
                FemaleRecommendationFragment femaleRecommendationFragment = new FemaleRecommendationFragment();
                return femaleRecommendationFragment;
            default:
                return null;

        }

    }

    @Override
    public int getCount() {
        return tabNumber;
    }

    public int getTabNumber() {
        return tabNumber;
    }

    public void setTabNumber(int tabNumber) {
        this.tabNumber = tabNumber;
    }
}
