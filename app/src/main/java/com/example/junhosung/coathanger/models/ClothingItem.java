package com.example.junhosung.coathanger.models;

/**
 * Created by Junho Sung on 12/31/2018.
 */

public class ClothingItem {

    private String name;
    private String type;
    private String imgId;

    public ClothingItem(String name, String type, String imgId) {
        this.name = name;
        this.type = type;
        this.imgId = imgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImgId() {
        return imgId;
    }

    public void setImgId(String imgId) {
        this.imgId = imgId;
    }
}
