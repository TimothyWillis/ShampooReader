package com.predatoryshrimp.shampooreader;

import android.content.Context;

import java.util.Random;

public class BrandBlurbPicker
{
    private Context context;

    private Random rng;

    private String[] brands;
    private String[] blurbs;

    private String brand;
    private String blurb;

    public BrandBlurbPicker(Context current)
    {
        this.context = current;

        this.rng = new Random();

        this.brands = current.getResources().getStringArray(R.array.brand_names);
        this.blurbs = current.getResources().getStringArray(R.array.blurbs);
    }

    public String getBrand()
    {
        return brand;
    }

    public void generateBrand()
    {
        brand = selectFromArray(brands);
    }

    public String getBlurb()
    {
        return blurb;
    }

    public void generateBlurb()
    {
        blurb = selectFromArray(blurbs).replace("[BRAND]", brand);
    }

    private String selectFromArray(String[] array)
    {
        int selectRandomNumber;
        selectRandomNumber = rng.nextInt(array.length);
        return array[selectRandomNumber];
    }
}
