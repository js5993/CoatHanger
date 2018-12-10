package com.example.junhosung.coathanger;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Recommendation recommendation;
    //String apiKey = "aaf609fc3d376d2a8b80e53754b890ac";
    JSONObject localRecommendation;

    TextView jacketRecommend;
    TextView shirtRecommend;
    TextView pantRecommend;
    TextView temperatureText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        localRecommendation = new JSONObject();
        recommendation = new Recommendation();

        jacketRecommend = (TextView) findViewById(R.id.jacketRecommend);
        shirtRecommend = (TextView) findViewById(R.id.shirtRecommend);
        pantRecommend = (TextView) findViewById(R.id.pantRecommend);
        temperatureText = (TextView) findViewById(R.id.temperatureText);

        //Intent i = PollService.newIntent(MainActivity.this);
        //MainActivity.this.startService(i);

        PollService.setServiceAlarm(MainActivity.this,true);

        find_weather();

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
                    //Toast.makeText(MainActivity.this,"  " + temperature,Toast.LENGTH_LONG).show();
                    recommendation.setTemperature(temperature);
                    //Toast.makeText(MainActivity.this,"  " + recommendation.temperature,Toast.LENGTH_LONG).show();

                    //recommendation.setTemperature(20.0);

                    localRecommendation = recommendation.setRecommendation();

                    jacketRecommend.setText(localRecommendation.getString("jacket"));
                    shirtRecommend.setText(localRecommendation.getString("shirt"));
                    pantRecommend.setText(localRecommendation.getString("pant"));
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
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(jsonObjectRequest);
    }

    public static Intent newIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }
}
