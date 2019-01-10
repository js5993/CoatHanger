package com.example.junhosung.coathanger.views.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.example.junhosung.coathanger.R;
import com.example.junhosung.coathanger.models.Recommendation;

import java.util.ArrayList;

/**
 * Created by Junho Sung on 12/20/2018.
 */

public class MaleRecommendationFragment extends android.support.v4.app.ListFragment {

    Recommendation mRecommendation = Recommendation.getInstance();
    private ArrayList<String> clothingList;
    private ArrayList<String> clothingImgIdList;
    String TAG = "TAG";

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

        clothingImgIdList = new ArrayList<>();
        clothingImgIdList.add(mRecommendation.getOutfit().get(0).getImgId());
        clothingImgIdList.add(mRecommendation.getOutfit().get(1).getImgId());
        clothingImgIdList.add(mRecommendation.getOutfit().get(2).getImgId());
        clothingImgIdList.add(mRecommendation.getOutfit().get(3).getImgId());
        clothingImgIdList.add(mRecommendation.getOutfit().get(4).getImgId());
        clothingImgIdList.add(mRecommendation.getOutfit().get(5).getImgId());

        ClothingAdapter clothingAdapter = new ClothingAdapter(clothingList);
        setListAdapter(clothingAdapter);

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
            String path = "https://www.amazon.com/s/ref=nb_sb_noss_2?url=search-alias%3Daps&field-keywords=";
            final Uri clothingUri = Uri.parse(path+clothing);

            TextView clothingName = (TextView) convertView.findViewById(R.id.clothingName);
            clothingName.setText(clothing);

            int imageResource = getResources().getIdentifier(clothingImgIdList.get(position),"drawable",getActivity().getPackageName());
            ImageView imgClothing = (ImageView) convertView.findViewById(R.id.imgClothing);
            imgClothing.setImageResource(imageResource);

            Button btnBuyClothing = (Button) convertView.findViewById(R.id.btnBuyClothing);
            btnBuyClothing.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Uri clothingUri = Uri.parse("https://www.amazon.com/s/ref=nb_sb_noss_2?url=search-alias%3Daps&field-keywords=trench+coat&rh=i%3Aaps%2Ck%3Atrench+coat");
                    Intent intent = new Intent(Intent.ACTION_VIEW,clothingUri);
                    startActivity(intent);
                }
            });

            return convertView;
        }
    }

}
