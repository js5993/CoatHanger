package com.example.junhosung.coathanger.models;

import java.util.ArrayList;

/**
 * Created by Junho Sung on 12/31/2018.
 */

public class ClothingLibrary {

    // class to hold the clothing items by category

    private ArrayList<ClothingItem> outerwares = new ArrayList<>();
    private ArrayList<ClothingItem> pants = new ArrayList<>();
    private ArrayList<ClothingItem> shoes = new ArrayList<>();
    private ArrayList<ClothingItem> tops = new ArrayList<>();
    private ArrayList<ClothingItem> hats = new ArrayList<>();
    private ArrayList<ClothingItem> accessories = new ArrayList<>();

    public ClothingLibrary() {

        // outerwares

        ClothingItem harringtonJacket = new ClothingItem("harrington jacket", "outerware", "harrington_jacket");
        ClothingItem sportCoat = new ClothingItem("sport coat", "outerware", "sport_coat");
        ClothingItem jacket = new ClothingItem("jacket", "outerware", "jacket");
        ClothingItem blazer = new ClothingItem("blazer", "outerware", "blazer");
        ClothingItem trenchCoat = new ClothingItem("trench coat", "outerware", "trench_coat");
        ClothingItem duffelCoat = new ClothingItem("duffel coat", "outerware", "duffel_coat");
        ClothingItem windbreaker = new ClothingItem("windbreaker", "outerware", "windbreaker");
        ClothingItem none = new ClothingItem("","","");

        outerwares.add(harringtonJacket);
        outerwares.add(sportCoat);
        outerwares.add(jacket);
        outerwares.add(blazer);
        outerwares.add(trenchCoat);
        outerwares.add(duffelCoat);
        outerwares.add(windbreaker);
        outerwares.add(none);

        // pants

        ClothingItem shorts = new ClothingItem("shorts", "pant", "shorts");
        ClothingItem khakis = new ClothingItem("khakis", "pant", "khakis");
        ClothingItem chinos = new ClothingItem("chinos", "pant", "chinos");
        ClothingItem trousers = new ClothingItem("trousers", "pant", "trousers");
        ClothingItem jeans = new ClothingItem("jeans", "pant", "jeans");
        ClothingItem sweatpants = new ClothingItem("sweatpants", "pant", "sweatpants");
        ClothingItem cargoPants = new ClothingItem("cargo pants", "pant", "cargo_pants");

        pants.add(shorts);
        pants.add(khakis);
        pants.add(chinos);
        pants.add(trousers);
        pants.add(jeans);
        pants.add(sweatpants);
        pants.add(cargoPants);
        pants.add(none);

        // shoes

        ClothingItem sneakers = new ClothingItem("sneakers", "shoe", "sneakers");
        ClothingItem canvasShoes = new ClothingItem("canvas shoes", "shoe", "canvas_shoes");
        ClothingItem boot = new ClothingItem("boot", "shoe", "sneakers");

        shoes.add(sneakers);
        shoes.add(canvasShoes);
        shoes.add(boot);
        shoes.add(none);

        // tops

        ClothingItem tShirt = new ClothingItem("t shirt", "top", "tshirt");
        ClothingItem blouse = new ClothingItem("blouse", "top", "blouse");
        ClothingItem polo = new ClothingItem("polo", "top", "polo");
        ClothingItem hoodie = new ClothingItem("hoodie", "top", "hoodie");
        ClothingItem sweater = new ClothingItem("sweater", "top", "sweater");
        ClothingItem turtleneck = new ClothingItem("turtleneck", "top", "turtleneck");

        tops.add(tShirt);
        tops.add(blouse);
        tops.add(polo);
        tops.add(hoodie);
        tops.add(sweater);
        tops.add(turtleneck);
        tops.add(none);

        // hats

        ClothingItem baseballHat = new ClothingItem("baseball hat", "hat", "baseball_hat");
        ClothingItem flatCap = new ClothingItem("flat cap", "hat", "blouse");
        ClothingItem knitCap = new ClothingItem("knit cap", "hat", "knit_cap");

        hats.add(baseballHat);
        hats.add(flatCap);
        hats.add(knitCap);
        hats.add(none);

        // accessories/

        ClothingItem umbrella = new ClothingItem("umbrella", "accessory","umbrella");
        ClothingItem scarf = new ClothingItem("scarf", "accessory", "scarf");
        ClothingItem sunglasses = new ClothingItem("sunglasses","accessory","sunglasses");

        accessories.add(umbrella);
        accessories.add(scarf);
        accessories.add(sunglasses);
        accessories.add(none);

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
}
