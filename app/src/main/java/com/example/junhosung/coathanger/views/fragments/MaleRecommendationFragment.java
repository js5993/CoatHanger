package com.example.junhosung.coathanger.views.fragments;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.junhosung.coathanger.R;
import com.example.junhosung.coathanger.models.Recommendation;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Junho Sung on 12/20/2018.
 */

public class MaleRecommendationFragment extends android.support.v4.app.ListFragment {
    Recommendation mRecommendation = Recommendation.getInstance();
    private ArrayList<String> clothingList;
    String TAG = "TAG";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        find_weather_and_set_outfit();
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
    }

    private class ClothingAdapter extends ArrayAdapter<String> {
        public ClothingAdapter(ArrayList<String> strings) {
            super(getActivity(),0,strings);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            if (convertView == null) {
                convertView = getActivity().getLayoutInflater()
                        .inflate(R.layout.list_item_clothing,null);
            }
            String clothing = getItem(position);

            TextView clothingName = (TextView) convertView.findViewById(R.id.clothingName);
            clothingName.setText(clothing);

            ImageView imgClothing = (ImageView) convertView.findViewById(R.id.imgClothing);
            imgClothing.setImageResource(R.drawable.trench_coat);

            Button btnBuyClothing = (Button) convertView.findViewById(R.id.btnBuyClothing);
            btnBuyClothing.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Uri clothingUri = Uri.parse("https://www.amazon.com/s/ref=nb_sb_noss_2?url=search-alias%3Daps&field-keywords=trench+coat&rh=i%3Aaps%2Ck%3Atrench+coat");
                    Intent intent = new Intent(Intent.ACTION_VIEW,clothingUri);
                    startActivity(intent);
                }
            });

            return convertView;
        }
    }

    public void find_weather_and_set_outfit() {
        String url = "http://api.openweathermap.org/data/2.5/weather?id=6173331&appid=aaf609fc3d376d2a8b80e53754b890ac&units=metric";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONObject mainObject = response.getJSONObject("main");
                    JSONObject windObject = response.getJSONObject("wind");

                    Double temperature = mainObject.getDouble("temp");
                    Double windSpeed = windObject.getDouble("speed");
                    Double rainVolumePastHour;

                    // if there is no rain, then the "rain" field key not be in the JSONObject response, so should check

                    if (response.has("rain")) {
                        JSONObject rainObject = response.getJSONObject("rain");
                        if (rainObject.has("1h")) {
                            rainVolumePastHour = rainObject.getDouble("1h");
                        } else {
                            rainVolumePastHour = 0.0;
                        }
                    } else {
                        rainVolumePastHour = 0.0;
                    }

                    mRecommendation.setWindSpeed(windSpeed);
                    mRecommendation.setTemperature(temperature);
                    mRecommendation.setRainVolumePastHour(rainVolumePastHour);

                    Log.i("checking values","windSpeed:"+mRecommendation.windSpeed
                            +"temperature: "+mRecommendation.temperature+"rain: "+mRecommendation.rainVolumePastHour);
                    Log.i("checking values"," "+mRecommendation.hat+" "+mRecommendation.pant);

                    mRecommendation.set_outfit_from_weather();

                    Log.i("checking values"," "+mRecommendation.hat+" "+mRecommendation.pant);

                    clothingList = new ArrayList<String>();
                    clothingList.add(mRecommendation.hat);
                    clothingList.add(mRecommendation.outerware);
                    clothingList.add(mRecommendation.top);
                    clothingList.add(mRecommendation.pant);
                    clothingList.add(mRecommendation.shoe);
                    clothingList.add(mRecommendation.accessory);

                    ClothingAdapter clothingAdapter = new ClothingAdapter(clothingList);
                    setListAdapter(clothingAdapter);

                    Toast.makeText(getActivity(),""+temperature+windSpeed+rainVolumePastHour,Toast.LENGTH_LONG).show();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(),"something is wrong with request...",Toast.LENGTH_LONG).show();
            }
        }
        );
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        queue.add(jsonObjectRequest);
    }

}
