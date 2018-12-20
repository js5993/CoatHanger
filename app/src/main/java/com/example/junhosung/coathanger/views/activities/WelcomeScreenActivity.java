package com.example.junhosung.coathanger.views.activities;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.junhosung.coathanger.R;
import com.example.junhosung.coathanger.views.fragment_template.SingleFragmentActivity;
import com.example.junhosung.coathanger.views.fragments.WelcomeScreenFragment;

public class WelcomeScreenActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new WelcomeScreenFragment();
    }
}
