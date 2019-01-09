package com.example.junhosung.coathanger.views.fragments;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.junhosung.coathanger.R;
import com.example.junhosung.coathanger.models.PollService;
import com.example.junhosung.coathanger.models.Recommendation;
import com.example.junhosung.coathanger.views.activities.RecommendationActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * Created by Junho Sung on 12/20/2018.
 */

public class LobbyFragment extends Fragment {

    private static final String API_KEY = "aaf609fc3d376d2a8b80e53754b890ac";

    Recommendation mRecommendation = Recommendation.getInstance();
    TextView mTxtCity;
    TextView mTxtTempMin;
    TextView mTxtTempMax;
    Button mBtnSeeOutfit;
    String city;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PollService.setServiceAlarm(getActivity(),true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && getActivity().checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[] {Manifest.permission.ACCESS_COARSE_LOCATION},1000);
        } else {
            LocationManager locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
            Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            city = findCity(location.getLatitude(),location.getLongitude());
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lobby,container,false);

        mTxtTempMin = (TextView) view.findViewById(R.id.temperatureMinText);
        mTxtTempMax = (TextView) view.findViewById(R.id.txtTempMax);
        mTxtCity = (TextView) view.findViewById(R.id.cityText);

        find_weather(city);

        mBtnSeeOutfit = (Button) view.findViewById(R.id.btnSeeOutfit);
        mBtnSeeOutfit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),RecommendationActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    public void find_weather(String city) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("http")
                .authority("api.openweathermap.org")
                .appendPath("data")
                .appendPath("2.5")
                .appendPath("weather")
                .appendQueryParameter("q",city)
                .appendQueryParameter("appid",API_KEY)
                .appendQueryParameter("units","metric");
        String url = builder.build().toString();

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONObject mainObject = response.getJSONObject("main");
                    JSONObject windObject = response.getJSONObject("wind");

                    Double temperature = mainObject.getDouble("temp");
                    Double temperature_min = mainObject.getDouble("temp_min");
                    Double temperature_max = mainObject.getDouble("temp_max");
                    Double windSpeed = windObject.getDouble("speed");
                    Double rainVolumePastHour;
                    String cityName = response.getString("name");

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

                    mTxtCity.setText(cityName);
                    mTxtTempMax.setText(String.valueOf(temperature_max)+"°");
                    mTxtTempMin.setText(String.valueOf(temperature_min)+"°");

                    mRecommendation.setWindSpeed(windSpeed);
                    mRecommendation.setTemperature(temperature);
                    mRecommendation.setRainVolumePastHour(rainVolumePastHour);

                    mRecommendation.set_outfit_from_weather();

                    Log.d("test",mRecommendation.getOutfit().get(0).getName());
                    Log.d("test",mRecommendation.getOutfit().get(1).getName());
                    Log.d("test",mRecommendation.getOutfit().get(2).getName());
                    Log.d("test",mRecommendation.getOutfit().get(3).getName());
                    Log.d("test",mRecommendation.getOutfit().get(4).getName());
                    Log.d("test",mRecommendation.getOutfit().get(5).getName());

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

    private String findCity(double latitude, double longitude) {
        String city = "";

        Geocoder geocoder = new Geocoder(getActivity(), Locale.getDefault());
        List<Address> addresses;
        try {
            addresses = geocoder.getFromLocation(latitude,longitude,10);
            if (addresses.size() > 0) {
                for (Address address: addresses) {
                    if (address.getLocality() != null && address.getLocality().length() >0) {
                        city = address.getLocality();
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return city;

    }

}
