package com.example.junhosung.coathanger.views.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
import com.example.junhosung.coathanger.views.activities.LobbyActivity;
import com.example.junhosung.coathanger.views.activities.RecommendationActivity;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Junho Sung on 12/20/2018.
 */

public class LobbyFragment extends Fragment {

    Recommendation recommendation;
    //String apiKey = "aaf609fc3d376d2a8b80e53754b890ac";
    JSONObject localRecommendation;

    TextView jacketRecommend;
    TextView shirtRecommend;
    TextView pantRecommend;
    TextView temperatureText;
    Button btnSeeOutfit;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_lobby,container,false);

        localRecommendation = new JSONObject();
        recommendation = new Recommendation();

        //jacketRecommend = (TextView) view.findViewById(R.id.jacketRecommend);
        //shirtRecommend = (TextView) view.findViewById(R.id.shirtRecommend);
        //pantRecommend = (TextView) view.findViewById(R.id.pantRecommend);
        temperatureText = (TextView) view.findViewById(R.id.temperatureText);

        //Intent intent = PollService.newIntent(LobbyActivity.this);
        //LobbyActivity.this.startService(intent);

        //PollService.setServiceAlarm(LobbyActivity.this,true);

        btnSeeOutfit = (Button) view.findViewById(R.id.btnSeeOutfit);
        btnSeeOutfit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),RecommendationActivity.class);
                startActivity(intent);
            }
        });

        find_weather();

        return view;
    }

    public void find_weather() {
        String url = "http://api.openweathermap.org/data/2.5/weather?id=6173331&appid=aaf609fc3d376d2a8b80e53754b890ac&units=metric";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONObject mainObject = response.getJSONObject("main");
                    //JSONArray jsonArray = response.getJSONArray("weather");
                    //JSONObject object = jsonArray.getJSONObject(0);
                    Double temperature = mainObject.getDouble("temp");
                    //String description = object.getString("description");
                    //String city = response.getString("name");
                    //Toast.makeText(LobbyActivity.this,"  " + temperature,Toast.LENGTH_LONG).show();
                    recommendation.setTemperature(temperature);
                    //Toast.makeText(LobbyActivity.this,"  " + recommendation.temperature,Toast.LENGTH_LONG).show();

                    //recommendation.setTemperature(20.0);

                    localRecommendation = recommendation.setRecommendation();

                    //jacketRecommend.setText(localRecommendation.getString("jacket"));
                    //shirtRecommend.setText(localRecommendation.getString("shirt"));
                    //pantRecommend.setText(localRecommendation.getString("pant"));
                    temperatureText.setText(String.valueOf(recommendation.temperature));

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        );
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        queue.add(jsonObjectRequest);
    }

    public static Intent newIntent(Context context) {
        return new Intent(context, LobbyActivity.class);
    }



}
