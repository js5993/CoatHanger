package com.example.junhosung.coathanger.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Junho Sung on 10/28/2018.
 */

public class Recommendation {

    public double temperature; //score from 0 to 5 -> 0 for coldest and 5 for warmest
    //public int raininess; // binary 0 or 1 or 2 -> 0 if no prospect of rain, 1 if moderate, 2 if near certainty of rain
    //public int windiness; // ok for now, let's say 0 to 5

    public JSONObject recommendation = new JSONObject(); // the JSON object containing the recommendation

    public Recommendation() {
        //this.temperature = temperature;
        //this.raininess = raininess;
        //this.windiness = windiness;
    }

    String[] jackets = {"heavy jacket", "light jacket"};
    String[] pants = {"heavy pants", "light pants"};
    String[] shoes = {"heavy shoes", "light shoes"};
    String[] shirts = {"heavy shirts", "light shirts"};
    String[] hats = {"heavy hat", "light hat"};

    // you put JSON Objects into a JSON Array

    public JSONObject setRecommendation() throws JSONException {

        if (0 <= this.temperature && this.temperature <= 10) {
            recommendation.put("jacket",jackets[0]);
            recommendation.put("pant",pants[0]);
            recommendation.put("shoe",shoes[0]);
            recommendation.put("shirt",shirts[0]);
            recommendation.put("hat",hats[0]);
        }

        else if (this.temperature > 10) {
            recommendation.put("jacket",jackets[1]);
            recommendation.put("pant",pants[1]);
            recommendation.put("shoe",shoes[1]);
            recommendation.put("shirt",shirts[1]);
            recommendation.put("hat",hats[1]);
        }

        // other conditionals come here ...

        return recommendation;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String[] getJackets() {
        return jackets;
    }

    public void setJackets(String[] jackets) {
        this.jackets = jackets;
    }

    public String[] getPants() {
        return pants;
    }

    public void setPants(String[] pants) {
        this.pants = pants;
    }

    public String[] getShoes() {
        return shoes;
    }

    public void setShoes(String[] shoes) {
        this.shoes = shoes;
    }

    public String[] getShirts() {
        return shirts;
    }

    public void setShirts(String[] shirts) {
        this.shirts = shirts;
    }

    public String[] getHats() {
        return hats;
    }

    public void setHats(String[] hats) {
        this.hats = hats;
    }
}
