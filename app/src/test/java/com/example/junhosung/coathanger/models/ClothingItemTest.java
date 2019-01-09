package com.example.junhosung.coathanger.models;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Junho Sung on 1/6/2019.
 */
public class ClothingItemTest {
    @Test
    public void getName() throws Exception {
        ClothingItem mClothingItem = new ClothingItem("clothing","clothingType","clothingImgId");
        assertEquals("clothing",mClothingItem.getName());
    }

    @Test
    public void setName() throws Exception {
        ClothingItem mClothingItem = new ClothingItem("clothing","clothingType","clothingImgId");
        mClothingItem.setName("clothingTest");
        assertEquals("clothingTest",mClothingItem.getName());
    }

    @Test
    public void getType() throws Exception {
        ClothingItem mClothingItem = new ClothingItem("clothing","clothingType","clothingImgId");
        assertEquals("clothingType",mClothingItem.getType());
    }

    @Test
    public void setType() throws Exception {
        ClothingItem mClothingItem = new ClothingItem("clothing","clothingType","clothingImgId");
        mClothingItem.setType("clothingTypeTest");
        assertEquals("clothingTypeTest",mClothingItem.getType());
    }

    @Test
    public void getImgId() throws Exception {
        ClothingItem mClothingItem = new ClothingItem("clothing","clothingType","clothingImgId");
        assertEquals("clothingImgId",mClothingItem.getImgId());
    }

    @Test
    public void setImgId() throws Exception {
        ClothingItem mClothingItem = new ClothingItem("clothing","clothingType","clothingImgId");
        mClothingItem.setImgId("clothingImgIdTest");
        assertEquals("clothingImgIdTest",mClothingItem.getImgId());
    }

}