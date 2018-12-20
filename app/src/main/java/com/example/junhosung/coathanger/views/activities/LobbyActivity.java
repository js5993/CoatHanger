package com.example.junhosung.coathanger.views.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.junhosung.coathanger.R;
import com.example.junhosung.coathanger.models.PollService;
import com.example.junhosung.coathanger.models.Recommendation;
import com.example.junhosung.coathanger.views.fragment_template.SingleFragmentActivity;
import com.example.junhosung.coathanger.views.fragments.LobbyFragment;

import org.json.JSONException;
import org.json.JSONObject;

public class LobbyActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new LobbyFragment();
    }
}
