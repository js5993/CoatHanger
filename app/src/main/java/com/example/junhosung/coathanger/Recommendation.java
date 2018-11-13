package com.example.junhosung.coathanger;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Junho Sung on 10/28/2018.
 */

public class Recommendation {

    public int temperature; //score from 0 to 5 -> 0 for coldest and 5 for warmest
    public int raininess; // binary 0 or 1 or 2 -> 0 if no prospect of rain, 1 if moderate, 2 if near certainty of rain
    public int windiness; // ok for now, let's say 0 to 5
    public JSONArray recommendation; // the JSON array containing the recommendation


    Recommendation(int temperature, int raininess, int windiness) {
        this.temperature = temperature;
        this.raininess = raininess;
        this.windiness = windiness;
    }

    String[] jackets = {"heavy coat", "light coat"};
    String[] pants = {"heavy pants", "light pants"};
    String[] shoes = {"heavy shes", "heavy pants"};
    String[] shirts = {"heavy shirts", "light shirts"};
    String[] hats = {"heavy hat", "light hat"};

    // you put JSON Objects into a JSON Array

    public JSONObject getRecommendation() throws JSONException {

        JSONObject jsonObject = new JSONObject();

        if (this.temperature == 0 || this.raininess == 0 || this.windiness == 0) {
            jsonObject.put("jacket",jackets[0]);
            jsonObject.put("pants",pants[0]);
            jsonObject.put("shoes",shoes[0]);
            jsonObject.put("shirts",shirts[0]);
            jsonObject.put("hats",hats[0]);

        }

        // other conditionals come here ...

        return jsonObject;
    }



}
