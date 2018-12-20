package com.example.junhosung.coathanger.views.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.junhosung.coathanger.R;
import com.example.junhosung.coathanger.views.activities.LobbyActivity;

/**
 * Created by Junho Sung on 12/20/2018.
 */

public class WelcomeScreenFragment extends Fragment {

    private static int displayTime = 4000; // 4 seconds
    private Handler handler = new Handler();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_welcome,container,false);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getActivity(),LobbyActivity.class);
                startActivity(intent);
            }
        },displayTime);

        return view;
    }
}
