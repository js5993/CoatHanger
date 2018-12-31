package com.example.junhosung.coathanger.models;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Junho Sung on 10/28/2018.
 */

public class Recommendation {

    public double temperature;
    public double rainVolumePastHour;
    public double windSpeed;
    public JSONObject recommendation = new JSONObject(); // the JSON object containing the recommendation


    public String hat;
    public String outerware;
    public String top;
    public String pant;
    public String shoe;
    public String accessory;

    private static Recommendation instance;
    public static Recommendation getInstance() {
        if (instance == null) {
            instance = new Recommendation();
        }
        return instance;
    }

    public Recommendation() {
        this.hat = hats[hats.length-1];
        this.outerware = outerwares[outerwares.length-1];
        this.top = tops[tops.length-1];
        this.pant = pants[pants.length-1];
        this.shoe = shoes[shoes.length-1];
        this.accessory = accessories[accessories.length-1];
    }

    public String[] outerwares = {"harrington jacket","sport coat", "jacket", "blazer","trench_coat","duffel coat","windbreaker","none"};
    public String[] pants = {"shorts","khakis","chinos","trousers","jeans", "sweatpants","cargo pants", "none"};
    public String[] shoes = {"sneakers","canvas shoes","boot"};
    public String[] tops = {"crop top","tube top","t-shirt","blouse","polo", "hoodie","sweater","turtleneck","none"};
    public String[] hats = {"baseball cap", "flat cap","knit cap","none"};
    public String[] accessories = {"umbrella","scarf","sunglasses","none"};

    // you put JSON Objects into a JSON Array

    public void set_outfit_from_weather() {
        // cold
        if (this.temperature <= 0.0) {
            Log.i("WOWWWW","1");
            // rain but little wind
            if (rainVolumePastHour > 0.0 && windSpeed < 6.0) {
                this.hat = hats[2];
                this.outerware = outerwares[4];
                this.top = tops[3];
                this.pant = pants[4];
                this.shoe = shoes[2];
                this.accessory = accessories[0];
            }
            // rain and moderate wind
            else if (rainVolumePastHour > 0.0 && windSpeed >= 6.0 && windSpeed < 12.0) {
                this.hat = hats[2];
                this.outerware = outerwares[4];
                this.top = tops[3];
                this.pant = pants[4];
                this.shoe = shoes[2];
                this.accessory = accessories[0];
            }
            // rain and high wind
            else if (rainVolumePastHour > 0.0 && windSpeed > 12.0) {
                this.hat = hats[2];
                this.outerware = outerwares[4];
                this.top = tops[3];
                this.pant = pants[4];
                this.shoe = shoes[2];
                this.accessory = accessories[0];
            }
            // no rain and low wind
            if (rainVolumePastHour == 0.0 && windSpeed < 6.0) {
                this.hat = hats[2];
                this.outerware = outerwares[4];
                this.top = tops[3];
                this.pant = pants[4];
                this.shoe = shoes[2];
                this.accessory = accessories[0];
            }
            // no rain and moderate wind
            else if (rainVolumePastHour == 0.0 && windSpeed >= 6.0 && windSpeed < 12.0) {
                this.hat = hats[2];
                this.outerware = outerwares[4];
                this.top = tops[3];
                this.pant = pants[4];
                this.shoe = shoes[2];
                this.accessory = accessories[0];
            }
            // no rain and heavy wind
            else if (rainVolumePastHour == 0.0 && windSpeed > 12) {
                this.hat = hats[2];
                this.outerware = outerwares[4];
                this.top = tops[3];
                this.pant = pants[4];
                this.shoe = shoes[2];
                this.accessory = accessories[0];
            }
        }
        // chilly
        else if (this.temperature > 0.0 && this.temperature <= 10.0) {
            Log.i("WOWWWW","2");
            if (rainVolumePastHour > 0.0 && windSpeed < 6.0) {
                Log.i("HMMMM","1");
                this.hat = hats[2];
                this.outerware = outerwares[4];
                this.top = tops[3];
                this.pant = pants[4];
                this.shoe = shoes[2];
                this.accessory = accessories[0];
            }
            // rain and moderate wind
            else if (rainVolumePastHour > 0.0 && windSpeed >= 6.0 && windSpeed < 12.0) {
                Log.i("HMMMM","2");
                this.hat = hats[2];
                this.outerware = outerwares[4];
                this.top = tops[3];
                this.pant = pants[4];
                this.shoe = shoes[2];
                this.accessory = accessories[0];
            }
            // rain and high wind
            else if (rainVolumePastHour > 0.0 && windSpeed > 12.0) {
                Log.i("HMMMM","3");
                this.hat = hats[2];
                this.outerware = outerwares[4];
                this.top = tops[3];
                this.pant = pants[4];
                this.shoe = shoes[2];
                this.accessory = accessories[0];
            }
            // no rain and low wind
            else if (rainVolumePastHour == 0.0 && windSpeed < 6.0) {
                Log.i("HMMMM","4");
                this.hat = hats[2];
                this.outerware = outerwares[4];
                this.top = tops[3];
                this.pant = pants[4];
                this.shoe = shoes[2];
                this.accessory = accessories[0];
            }
            // no rain and moderate wind
            else if (rainVolumePastHour == 0.0 && windSpeed >= 6.0 && windSpeed < 12.0) {
                Log.i("HMMMM","5");
                this.hat = hats[2];
                this.outerware = outerwares[4];
                this.top = tops[3];
                this.pant = pants[4];
                this.shoe = shoes[2];
                this.accessory = accessories[0];
            }
            // no rain and heavy wind
            else if (rainVolumePastHour == 0 && windSpeed > 12.0) {
                Log.i("HMMMM","6");
                this.hat = hats[2];
                this.outerware = outerwares[4];
                this.top = tops[3];
                this.pant = pants[4];
                this.shoe = shoes[2];
                this.accessory = accessories[0];
            }
        }
        // moderate temperature
        else if (this.temperature > 10.0 && this.temperature <= 20.0) {
            Log.i("WOWWWW","3");
            if (rainVolumePastHour > 0.0 && windSpeed < 6.0) {
                this.hat = hats[2];
                this.outerware = outerwares[4];
                this.top = tops[3];
                this.pant = pants[4];
                this.shoe = shoes[2];
                this.accessory = accessories[0];
            }
            // rain and moderate wind
            else if (rainVolumePastHour > 0.0 && windSpeed >= 6.0 && windSpeed < 12.0) {
                this.hat = hats[2];
                this.outerware = outerwares[4];
                this.top = tops[3];
                this.pant = pants[4];
                this.shoe = shoes[2];
                this.accessory = accessories[0];
            }
            // rain and high wind
            else if (rainVolumePastHour > 0.0 && windSpeed > 12.0) {
                this.hat = hats[2];
                this.outerware = outerwares[4];
                this.top = tops[3];
                this.pant = pants[4];
                this.shoe = shoes[2];
                this.accessory = accessories[0];
            }
            // no rain and low wind
            else if (rainVolumePastHour == 0.0 && windSpeed < 6.0) {
                this.hat = hats[2];
                this.outerware = outerwares[4];
                this.top = tops[3];
                this.pant = pants[4];
                this.shoe = shoes[2];
                this.accessory = accessories[0];
            }
            // no rain and moderate wind
            else if (rainVolumePastHour == 0.0 && windSpeed >= 6.0 && windSpeed < 12.0) {
                this.hat = hats[2];
                this.outerware = outerwares[4];
                this.top = tops[3];
                this.pant = pants[4];
                this.shoe = shoes[2];
                this.accessory = accessories[0];
            }
            // no rain and heavy wind
            else if (rainVolumePastHour < 0.0 && windSpeed > 12.0) {
                this.hat = hats[2];
                this.outerware = outerwares[4];
                this.top = tops[3];
                this.pant = pants[4];
                this.shoe = shoes[2];
                this.accessory = accessories[0];
            }
        }
        // warm
        else if (this.temperature > 20.0 && this.temperature <= 30.0) {
            Log.i("WOWWWW","4");
            if (rainVolumePastHour > 0.0 && windSpeed < 6.0) {
                this.hat = hats[2];
                this.outerware = outerwares[4];
                this.top = tops[3];
                this.pant = pants[4];
                this.shoe = shoes[2];
                this.accessory = accessories[0];
            }
            // rain and moderate wind
            else if (rainVolumePastHour > 0.0 && windSpeed >= 6.0 && windSpeed < 12.0) {
                this.hat = hats[2];
                this.outerware = outerwares[4];
                this.top = tops[3];
                this.pant = pants[4];
                this.shoe = shoes[2];
                this.accessory = accessories[0];
            }
            // rain and high wind
            else if (rainVolumePastHour > 0.0 && windSpeed > 12.0) {
                this.hat = hats[2];
                this.outerware = outerwares[4];
                this.top = tops[3];
                this.pant = pants[4];
                this.shoe = shoes[2];
                this.accessory = accessories[0];
            }
            // no rain and low wind
            if (rainVolumePastHour == 0.0 && windSpeed < 6.0) {
                this.hat = hats[2];
                this.outerware = outerwares[4];
                this.top = tops[3];
                this.pant = pants[4];
                this.shoe = shoes[2];
                this.accessory = accessories[0];
            }
            // no rain and moderate wind
            else if (rainVolumePastHour == 0.0 && windSpeed >= 6.0 && windSpeed < 12.0) {
                this.hat = hats[2];
                this.outerware = outerwares[4];
                this.top = tops[3];
                this.pant = pants[4];
                this.shoe = shoes[2];
                this.accessory = accessories[0];
            }
            // no rain and heavy wind
            else if (rainVolumePastHour == 0.0 && windSpeed > 12.0) {
                this.hat = hats[2];
                this.outerware = outerwares[4];
                this.top = tops[3];
                this.pant = pants[4];
                this.shoe = shoes[2];
                this.accessory = accessories[0];
            }
        }
        // hot
        else if (this.temperature > 30.0) {
            Log.i("WOWWWW","5");
            if (rainVolumePastHour > 0 && windSpeed < 6.0) {
                this.hat = hats[1];
                this.outerware = outerwares[outerwares.length-1];
                this.top = tops[2];
                this.pant = pants[2];
                this.shoe = shoes[0];
                this.accessory = accessories[0];
            }
            // rain and moderate wind
            else if (rainVolumePastHour > 0.0 && windSpeed >= 6.0 && windSpeed < 12.0) {
                this.hat = hats[1];
                this.outerware = outerwares[5];
                this.top = tops[2];
                this.pant = pants[4];
                this.shoe = shoes[1];
                this.accessory = accessories[0];
            }
            // rain and high wind
            else if (rainVolumePastHour > 0.0 && windSpeed > 12.0) {
                this.hat = hats[hats.length-1];
                this.outerware = outerwares[6];
                this.top = tops[2];
                this.pant = pants[5];
                this.shoe = shoes[1];
                this.accessory = accessories[accessories.length-1];
            }
            // no rain and low wind
            else if (rainVolumePastHour == 0.0 && windSpeed < 6.0) {
                this.hat = hats[0];
                this.outerware = outerwares[3];
                this.top = tops[2];
                this.pant = pants[3];
                this.shoe = shoes[1];
                this.accessory = accessories[2];
            }
            // no rain and moderate wind
            else if (rainVolumePastHour == 0.0 && windSpeed >= 6.0 && windSpeed < 12.0) {
                this.hat = hats[0];
                this.outerware = outerwares[4];
                this.top = tops[2];
                this.pant = pants[4];
                this.shoe = shoes[1];
                this.accessory = accessories[2];
            }
            // no rain and heavy wind
            else if (rainVolumePastHour == 0.0 && windSpeed > 12.0) {
                this.hat = hats[0];
                this.outerware = outerwares[6];
                this.top = tops[2];
                this.pant = pants[4];
                this.shoe = shoes[1];
                this.accessory = accessories[2];
            }
        }
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String[] getOuterwares() {
        return outerwares;
    }

    public void setOuterwares(String[] outerwares) {
        this.outerwares = outerwares;
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

    public double getRainVolumePastHour() {
        return rainVolumePastHour;
    }

    public void setRainVolumePastHour(double rainVolumePastHour) {
        this.rainVolumePastHour = rainVolumePastHour;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public JSONObject getRecommendation() {
        return recommendation;
    }

    public String[] getAccessories() {
        return accessories;
    }

    public void setAccessories(String[] accessories) {
        this.accessories = accessories;
    }
}
