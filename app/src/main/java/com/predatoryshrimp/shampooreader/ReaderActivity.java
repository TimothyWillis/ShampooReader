package com.predatoryshrimp.shampooreader;

import android.content.Intent;
import android.content.pm.ActivityInfo;
//import android.graphics.Bitmap;
//import android.graphics.drawable.BitmapDrawable;
//import android.graphics.drawable.Drawable;
//import android.support.constraint.ConstraintLayout;
//import android.support.design.widget.FloatingActionButton;
//import android.support.v4.content.ContextCompat;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Random;

public class ReaderActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reader);

        // Disable orientation
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);

        getNewBottle();

        FloatingActionButton reloadFloatingButton = findViewById(R.id.reloadFloatingButton);
        reloadFloatingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getNewBottle();
            }
        });

        FloatingActionButton backFloatingButton = findViewById(R.id.backFloatingButton);
        backFloatingButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent mainAct = new Intent(ReaderActivity.this, MainActivity.class);
                startActivity(mainAct);
            }
        });
    }

    private void getNewBottle()
    {
        Random rng = new Random();
        Integer[] bottlePicturesArray =
                {
                        R.drawable.shampoobottlegreen,
                        R.drawable.shampoobottlered,
                        R.drawable.shampoobottlepink,
                        R.drawable.shampoobottleteal,
                        R.drawable.shampoobottleyellow,
                        R.drawable.shampoobottleblue
                };

        ImageView imageViewBottle = findViewById(R.id.imageViewBottle);
        imageViewBottle.setImageResource(bottlePicturesArray[rng.nextInt(bottlePicturesArray.length)]);


        TextView brandTextView = findViewById(R.id.brandNameTextView);
        TextView blurbTextView = findViewById(R.id.blurbTextView);
        TextView directionsTextView = findViewById(R.id.directionsTextView);
        TextView ingredientsTextView = findViewById(R.id.ingredientsTextView);

        BrandBlurbPicker brandBlurbPicker = new BrandBlurbPicker(this);
        brandBlurbPicker.generateBrand();
        brandBlurbPicker.generateBlurb();

        brandTextView.setText(brandBlurbPicker.getBrand());
        blurbTextView.setText(brandBlurbPicker.getBlurb());

        DirectionsPicker directionsPicker = new DirectionsPicker(this);
        directionsTextView.setText(directionsPicker.generateDirections(4));


        int numberOfIngredients = 0;
        int rngMin = 9, rngMax = 12;
        numberOfIngredients = rng.nextInt(rngMax - rngMin) + 1 + rngMin;
        IngredientPicker ingredientPicker = new IngredientPicker(this);
        ingredientsTextView.setText(ingredientPicker.generateIngredientList(numberOfIngredients));

    }

}
