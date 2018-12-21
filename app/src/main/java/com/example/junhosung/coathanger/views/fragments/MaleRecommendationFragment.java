package com.example.junhosung.coathanger.views.fragments;

import android.app.ListFragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.junhosung.coathanger.R;
import com.example.junhosung.coathanger.models.Recommendation;

import java.util.ArrayList;

/**
 * Created by Junho Sung on 12/20/2018.
 */

public class MaleRecommendationFragment extends android.support.v4.app.ListFragment {

    private Recommendation maleRecommendation;
    private ArrayList<String> clothingList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        clothingList = new ArrayList<String>();

        maleRecommendation = new Recommendation();
        clothingList.add(maleRecommendation.hats[1]);
        clothingList.add(maleRecommendation.outerware[1]);
        clothingList.add(maleRecommendation.tops[1]);
        clothingList.add(maleRecommendation.pants[1]);
        clothingList.add(maleRecommendation.shoes[1]);


/*
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1,
                clothingList);
*/

        ClothingAdapter clothingAdapter = new ClothingAdapter(clothingList);
        setListAdapter(clothingAdapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        String clothing = (String) (getListAdapter()).getItem(position);
        Toast.makeText(getActivity(),clothing,Toast.LENGTH_LONG).show();
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
