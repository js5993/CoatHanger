package com.example.junhosung.coathanger.models;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Junho Sung on 10/28/2018.
 */

public class Recommendation {

    private double temperature;
    private double rainVolumePastHour;
    private double windSpeed;

    private ArrayList<ClothingItem> outerwares = new ArrayList<>();
    private ArrayList<ClothingItem> pants = new ArrayList<>();
    private ArrayList<ClothingItem> shoes = new ArrayList<>();
    private ArrayList<ClothingItem> tops = new ArrayList<>();
    private ArrayList<ClothingItem> hats = new ArrayList<>();
    private ArrayList<ClothingItem> accessories = new ArrayList<>();

    public ClothingLibrary mClothingLibrary = new ClothingLibrary();
    public ArrayList<ClothingItem> outfit = new ArrayList<>();

    private static Recommendation instance;
    public static Recommendation getInstance() {
        if (instance == null) {
            instance = new Recommendation();
        }
        return instance;
    }

    public Recommendation() {

        this.hats = mClothingLibrary.getHats();
        this.outerwares = mClothingLibrary.getOuterwares();
        this.pants = mClothingLibrary.getPants();
        this.shoes = mClothingLibrary.getShoes();
        this.tops = mClothingLibrary.getTops();
        this.accessories = mClothingLibrary.getAccessories();
    }

    public void set_outfit_from_weather() {
        // cold
        if (this.temperature <= 0.0) {
            // rain but little wind
            if (rainVolumePastHour > 0.0 && windSpeed < 6.0) {
                outfit.add(hats.get(2));
                outfit.add(outerwares.get(4));
                outfit.add(tops.get(3));
                outfit.add(pants.get(4));
                outfit.add(shoes.get(2));
                outfit.add(accessories.get(0));
            }
            // rain and moderate wind
            else if (rainVolumePastHour > 0.0 && windSpeed >= 6.0 && windSpeed < 12.0) {
                outfit.add(hats.get(2));
                outfit.add(outerwares.get(4));
                outfit.add(tops.get(3));
                outfit.add(pants.get(4));
                outfit.add(shoes.get(2));
                outfit.add(accessories.get(0));
            }
            // rain and high wind
            else if (rainVolumePastHour > 0.0 && windSpeed > 12.0) {
                outfit.add(hats.get(2));
                outfit.add(outerwares.get(4));
                outfit.add(tops.get(3));
                outfit.add(pants.get(4));
                outfit.add(shoes.get(2));
                outfit.add(accessories.get(0));
            }
            // no rain and low wind
            if (rainVolumePastHour == 0.0 && windSpeed < 6.0) {
                outfit.add(hats.get(2));
                outfit.add(outerwares.get(4));
                outfit.add(tops.get(3));
                outfit.add(pants.get(4));
                outfit.add(shoes.get(2));
                outfit.add(accessories.get(0));
            }
            // no rain and moderate wind
            else if (rainVolumePastHour == 0.0 && windSpeed >= 6.0 && windSpeed < 12.0) {
                outfit.add(hats.get(2));
                outfit.add(outerwares.get(4));
                outfit.add(tops.get(3));
                outfit.add(pants.get(4));
                outfit.add(shoes.get(2));
                outfit.add(accessories.get(0));
            }
            // no rain and heavy wind
            else if (rainVolumePastHour == 0.0 && windSpeed > 12) {
                outfit.add(hats.get(2));
                outfit.add(outerwares.get(4));
                outfit.add(tops.get(3));
                outfit.add(pants.get(4));
                outfit.add(shoes.get(2));
                outfit.add(accessories.get(0));
            }
        }
        // chilly
        else if (this.temperature > 0.0 && this.temperature <= 10.0) {
            if (rainVolumePastHour > 0.0 && windSpeed < 6.0) {
                outfit.add(hats.get(2));
                outfit.add(outerwares.get(4));
                outfit.add(tops.get(3));
                outfit.add(pants.get(4));
                outfit.add(shoes.get(2));
                outfit.add(accessories.get(0));
            }
            // rain and moderate wind
            else if (rainVolumePastHour > 0.0 && windSpeed >= 6.0 && windSpeed < 12.0) {
                outfit.add(hats.get(2));
                outfit.add(outerwares.get(4));
                outfit.add(tops.get(3));
                outfit.add(pants.get(4));
                outfit.add(shoes.get(2));
                outfit.add(accessories.get(0));
            }
            // rain and high wind
            else if (rainVolumePastHour > 0.0 && windSpeed > 12.0) {
                outfit.add(hats.get(2));
                outfit.add(outerwares.get(4));
                outfit.add(tops.get(3));
                outfit.add(pants.get(4));
                outfit.add(shoes.get(2));
                outfit.add(accessories.get(0));
            }
            // no rain and low wind
            else if (rainVolumePastHour == 0.0 && windSpeed < 6.0) {
                outfit.add(hats.get(2));
                outfit.add(outerwares.get(4));
                outfit.add(tops.get(3));
                outfit.add(pants.get(4));
                outfit.add(shoes.get(2));
                outfit.add(accessories.get(0));
            }
            // no rain and moderate wind
            else if (rainVolumePastHour == 0.0 && windSpeed >= 6.0 && windSpeed < 12.0) {
                outfit.add(hats.get(2));
                outfit.add(outerwares.get(4));
                outfit.add(tops.get(3));
                outfit.add(pants.get(4));
                outfit.add(shoes.get(2));
                outfit.add(accessories.get(0));
            }
            // no rain and heavy wind
            else if (rainVolumePastHour == 0 && windSpeed > 12.0) {
                outfit.add(hats.get(2));
                outfit.add(outerwares.get(4));
                outfit.add(tops.get(3));
                outfit.add(pants.get(4));
                outfit.add(shoes.get(2));
                outfit.add(accessories.get(0));
            }
        }
        // moderate temperature
        else if (this.temperature > 10.0 && this.temperature <= 20.0) {
            if (rainVolumePastHour > 0.0 && windSpeed < 6.0) {
                outfit.add(hats.get(2));
                outfit.add(outerwares.get(4));
                outfit.add(tops.get(3));
                outfit.add(pants.get(4));
                outfit.add(shoes.get(2));
                outfit.add(accessories.get(0));
            }
            // rain and moderate wind
            else if (rainVolumePastHour > 0.0 && windSpeed >= 6.0 && windSpeed < 12.0) {
                outfit.add(hats.get(2));
                outfit.add(outerwares.get(4));
                outfit.add(tops.get(3));
                outfit.add(pants.get(4));
                outfit.add(shoes.get(2));
                outfit.add(accessories.get(0));
            }
            // rain and high wind
            else if (rainVolumePastHour > 0.0 && windSpeed > 12.0) {
                outfit.add(hats.get(2));
                outfit.add(outerwares.get(4));
                outfit.add(tops.get(3));
                outfit.add(pants.get(4));
                outfit.add(shoes.get(2));
                outfit.add(accessories.get(0));
            }
            // no rain and low wind
            else if (rainVolumePastHour == 0.0 && windSpeed < 6.0) {
                outfit.add(hats.get(2));
                outfit.add(outerwares.get(4));
                outfit.add(tops.get(3));
                outfit.add(pants.get(4));
                outfit.add(shoes.get(2));
                outfit.add(accessories.get(0));
            }
            // no rain and moderate wind
            else if (rainVolumePastHour == 0.0 && windSpeed >= 6.0 && windSpeed < 12.0) {
                outfit.add(hats.get(2));
                outfit.add(outerwares.get(4));
                outfit.add(tops.get(3));
                outfit.add(pants.get(4));
                outfit.add(shoes.get(2));
                outfit.add(accessories.get(0));
            }
            // no rain and heavy wind
            else if (rainVolumePastHour < 0.0 && windSpeed > 12.0) {
                outfit.add(hats.get(2));
                outfit.add(outerwares.get(4));
                outfit.add(tops.get(3));
                outfit.add(pants.get(4));
                outfit.add(shoes.get(2));
                outfit.add(accessories.get(0));
            }
        }
        // warm
        else if (this.temperature > 20.0 && this.temperature <= 30.0) {
            if (rainVolumePastHour > 0.0 && windSpeed < 6.0) {
                outfit.add(hats.get(2));
                outfit.add(outerwares.get(4));
                outfit.add(tops.get(3));
                outfit.add(pants.get(4));
                outfit.add(shoes.get(2));
                outfit.add(accessories.get(0));
            }
            // rain and moderate wind
            else if (rainVolumePastHour > 0.0 && windSpeed >= 6.0 && windSpeed < 12.0) {
                outfit.add(hats.get(2));
                outfit.add(outerwares.get(4));
                outfit.add(tops.get(3));
                outfit.add(pants.get(4));
                outfit.add(shoes.get(2));
                outfit.add(accessories.get(0));
            }
            // rain and high wind
            else if (rainVolumePastHour > 0.0 && windSpeed > 12.0) {
                outfit.add(hats.get(2));
                outfit.add(outerwares.get(4));
                outfit.add(tops.get(3));
                outfit.add(pants.get(4));
                outfit.add(shoes.get(2));
                outfit.add(accessories.get(0));
            }
            // no rain and low wind
            if (rainVolumePastHour == 0.0 && windSpeed < 6.0) {
                outfit.add(hats.get(2));
                outfit.add(outerwares.get(4));
                outfit.add(tops.get(3));
                outfit.add(pants.get(4));
                outfit.add(shoes.get(2));
                outfit.add(accessories.get(0));
            }
            // no rain and moderate wind
            else if (rainVolumePastHour == 0.0 && windSpeed >= 6.0 && windSpeed < 12.0) {
                outfit.add(hats.get(2));
                outfit.add(outerwares.get(4));
                outfit.add(tops.get(3));
                outfit.add(pants.get(4));
                outfit.add(shoes.get(2));
                outfit.add(accessories.get(0));
            }
            // no rain and heavy wind
            else if (rainVolumePastHour == 0.0 && windSpeed > 12.0) {
                outfit.add(hats.get(2));
                outfit.add(outerwares.get(4));
                outfit.add(tops.get(3));
                outfit.add(pants.get(4));
                outfit.add(shoes.get(2));
                outfit.add(accessories.get(0));
            }
        }
        // hot
        else if (this.temperature > 30.0) {
            if (rainVolumePastHour > 0 && windSpeed < 6.0) {
                outfit.add(hats.get(2));
                outfit.add(outerwares.get(4));
                outfit.add(tops.get(3));
                outfit.add(pants.get(4));
                outfit.add(shoes.get(2));
                outfit.add(accessories.get(0));
            }
            // rain and moderate wind
            else if (rainVolumePastHour > 0.0 && windSpeed >= 6.0 && windSpeed < 12.0) {
                outfit.add(hats.get(2));
                outfit.add(outerwares.get(4));
                outfit.add(tops.get(3));
                outfit.add(pants.get(4));
                outfit.add(shoes.get(2));
                outfit.add(accessories.get(0));
            }
            // rain and high wind
            else if (rainVolumePastHour > 0.0 && windSpeed > 12.0) {
                outfit.add(hats.get(hats.size()-1));
                outfit.add(outerwares.get(4));
                outfit.add(tops.get(3));
                outfit.add(pants.get(4));
                outfit.add(shoes.get(2));
                outfit.add(accessories.get(accessories.size()-1));
            }
            // no rain and low wind
            else if (rainVolumePastHour == 0.0 && windSpeed < 6.0) {
                outfit.add(hats.get(2));
                outfit.add(outerwares.get(4));
                outfit.add(tops.get(3));
                outfit.add(pants.get(3));
                outfit.add(shoes.get(1));
                outfit.add(accessories.get(2));
            }
            // no rain and moderate wind
            else if (rainVolumePastHour == 0.0 && windSpeed >= 6.0 && windSpeed < 12.0) {
                outfit.add(hats.get(0));
                outfit.add(outerwares.get(4));
                outfit.add(tops.get(2));
                outfit.add(pants.get(4));
                outfit.add(shoes.get(1));
                outfit.add(accessories.get(2));
            }
            // no rain and heavy wind
            else if (rainVolumePastHour == 0.0 && windSpeed > 12.0) {
                outfit.add(hats.get(0));
                outfit.add(outerwares.get(6));
                outfit.add(tops.get(3));
                outfit.add(pants.get(4));
                outfit.add(shoes.get(1));
                outfit.add(accessories.get(2));
            }
        }
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
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

    public ArrayList<ClothingItem> getOuterwares() {
        return outerwares;
    }

    public void setOuterwares(ArrayList<ClothingItem> outerwares) {
        this.outerwares = outerwares;
    }

    public ArrayList<ClothingItem> getPants() {
        return pants;
    }

    public void setPants(ArrayList<ClothingItem> pants) {
        this.pants = pants;
    }

    public ArrayList<ClothingItem> getShoes() {
        return shoes;
    }

    public void setShoes(ArrayList<ClothingItem> shoes) {
        this.shoes = shoes;
    }

    public ArrayList<ClothingItem> getTops() {
        return tops;
    }

    public void setTops(ArrayList<ClothingItem> tops) {
        this.tops = tops;
    }

    public ArrayList<ClothingItem> getHats() {
        return hats;
    }

    public void setHats(ArrayList<ClothingItem> hats) {
        this.hats = hats;
    }

    public ArrayList<ClothingItem> getAccessories() {
        return accessories;
    }

    public void setAccessories(ArrayList<ClothingItem> accessories) {
        this.accessories = accessories;
    }

    public ClothingLibrary getClothingLibrary() {
        return mClothingLibrary;
    }

    public void setClothingLibrary(ClothingLibrary clothingLibrary) {
        mClothingLibrary = clothingLibrary;
    }

    public ArrayList<ClothingItem> getOutfit() {
        return outfit;
    }

    public void setOutfit(ArrayList<ClothingItem> outfit) {
        this.outfit = outfit;
    }

    public static void setInstance(Recommendation instance) {
        Recommendation.instance = instance;
    }
}
