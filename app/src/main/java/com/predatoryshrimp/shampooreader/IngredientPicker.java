package com.predatoryshrimp.shampooreader;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IngredientPicker
{
    //Class Context
    private Context context;
    //String Arrays
    private String[] ingredients;
    private String[] real_ingredients;
    private String[] modifiers;
    //Random Variable
    private Random rng;
    //List Trackers
    private List<Integer> ingredientTracker;
    private List<Integer> realIngredientTracker;
    //Odds
    private int ingredientOdds;
    private int modifierOdds;


    //Constructor
    public IngredientPicker(Context current)
    {
        this.context = current;
        this.ingredients = context.getResources().getStringArray(R.array.ingredients);
        this.real_ingredients = context.getResources().getStringArray(R.array.real_ingredients);
        this.modifiers = context.getResources().getStringArray(R.array.modifyers);
        this.rng = new Random();
        ingredientTracker = new ArrayList<Integer>();
        realIngredientTracker = new ArrayList<Integer>();
        this.ingredientOdds = 69;
        this.modifierOdds = 42;
    }

    public IngredientPicker(Context current, int ingredientOdds, int modifierOdds)
    {
        this(current);
        this.ingredientOdds = ingredientOdds;
        this.modifierOdds = modifierOdds;
    }


    public String generateIngredientList(int numberInList)
    {
        String finalIngredientList = "";

        for (int i = 1; i < numberInList; i++)
        {
            finalIngredientList += getOddsAndSelect();
            finalIngredientList += ", ";
        }

        finalIngredientList += "and ";
        finalIngredientList += getOddsAndSelect();
        finalIngredientList += ".";
        //Capitalize the first letter of the list.
        finalIngredientList = finalIngredientList.substring(0,1).toUpperCase() + finalIngredientList.substring(1);

        return finalIngredientList;
    }

    private String getOddsAndSelect()
    {
        int odds = rng.nextInt(100) + 1;

        String finalIngredient = "";

        if (odds < modifierOdds)
        {
            finalIngredient += selectFromArray(modifiers);
            finalIngredient += " ";
        }

        if (odds < ingredientOdds)
        {
            finalIngredient += selectFromArray(ingredients, ingredientTracker);
        }
        else
        {
            finalIngredient += selectFromArray(real_ingredients, realIngredientTracker);
        }
        return finalIngredient;
    }


    private String selectFromArray(String[] array)
    {
        int selectRandomNumber;
        selectRandomNumber = rng.nextInt(array.length);
        return array[selectRandomNumber];

    }

    private String selectFromArray(String[] array, List<Integer> list)
    {
        return array[getUniqueRandomNumber(array, list)];
    }

    private int getUniqueRandomNumber(String[] array, List<Integer> list)
    {
        int randNum = rng.nextInt(array.length);

        for(int i = 0; i < array.length; i++)
        {
            if (list.contains(randNum))
            {
                randNum = rng.nextInt(array.length);
            }
            else
            {
                list.add(randNum);
                break;
            }
        }
        return randNum;
    }


}
