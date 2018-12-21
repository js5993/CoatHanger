package com.example.junhosung.coathanger.models;

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

    public String[] outerware = {"windbreaker", "harrington jacket","trench coat", "sport coat", "jacket", "blazer","duffel coat"};
    public String[] pants = {"jeans", "sweatpants","shorts"};
    public String[] shoes = {"boot", "sneakers"};
    public String[] tops = {"blouse", "hoodie","polo","sweater","polo","turtleneck","t-shirt","tube top","crop top"};
    public String[] hats = {"baseball cap", "knit cap", "flat cap"};
    public String[] accessories = {"scarf","sunglasses","umbrella"};

    // you put JSON Objects into a JSON Array

    public JSONObject setRecommendation() throws JSONException {

        if (0 <= this.temperature && this.temperature <= 10) {
            recommendation.put("jacket", outerware[0]);
            recommendation.put("pant",pants[0]);
            recommendation.put("shoe",shoes[0]);
            recommendation.put("shirt", tops[0]);
            recommendation.put("hat",hats[0]);
        }

        else if (this.temperature > 10) {
            recommendation.put("jacket", outerware[1]);
            recommendation.put("pant",pants[1]);
            recommendation.put("shoe",shoes[1]);
            recommendation.put("shirt", tops[1]);
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

    public String[] getOuterware() {
        return outerware;
    }

    public void setOuterware(String[] outerware) {
        this.outerware = outerware;
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

    public String[] getTops() {
        return tops;
    }

    public void setTops(String[] tops) {
        this.tops = tops;
    }

    public String[] getHats() {
        return hats;
    }

    public void setHats(String[] hats) {
        this.hats = hats;
    }
}
