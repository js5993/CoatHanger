package com.example.junhosung.coathanger.views.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.junhosung.coathanger.R;

/**
 * Created by Junho Sung on 12/20/2018.
 */

public class RecommendationFragment extends Fragment {

    TabLayout tabLayout;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recommendation,container,false);

        tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);

        TabLayout.Tab maleTab = tabLayout.newTab();
        maleTab.setText(R.string.male);
        tabLayout.addTab(maleTab,true);

        TabLayout.Tab femaleTab = tabLayout.newTab();
        femaleTab.setText(R.string.female);
        tabLayout.addTab(femaleTab);

        return view;
    }
}
