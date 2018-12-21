package com.example.junhosung.coathanger.views.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.junhosung.coathanger.R;
import com.example.junhosung.coathanger.models.Recommendation;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Junho Sung on 12/20/2018.
 */

public class FemaleRecommendationFragment extends ListFragment {

    private Recommendation femaleRecommendation;
    private ArrayList<String> clothingList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        clothingList = new ArrayList<String>();

        femaleRecommendation = new Recommendation();
        clothingList.add(femaleRecommendation.hats[0]);
        clothingList.add(femaleRecommendation.outerware[0]);
        clothingList.add(femaleRecommendation.tops[0]);
        clothingList.add(femaleRecommendation.pants[0]);
        clothingList.add(femaleRecommendation.shoes[0]);

/*        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1,
                clothingList);*/

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
