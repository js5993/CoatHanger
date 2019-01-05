package com.example.junhosung.coathanger.views.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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

public class FemaleRecommendationFragment extends ListFragment {

    Recommendation mRecommendation = Recommendation.getInstance();
    private ArrayList<String> clothingList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        clothingList = new ArrayList<String>();
        clothingList.add(mRecommendation.getOutfit().get(0).getName());
        clothingList.add(mRecommendation.getOutfit().get(1).getName());
        clothingList.add(mRecommendation.getOutfit().get(2).getName());
        clothingList.add(mRecommendation.getOutfit().get(3).getName());
        clothingList.add(mRecommendation.getOutfit().get(4).getName());
        clothingList.add(mRecommendation.getOutfit().get(5).getName());

        ClothingAdapter clothingAdapter = new ClothingAdapter(clothingList);
        setListAdapter(clothingAdapter);
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

            return convertView;
        }
    }

}
