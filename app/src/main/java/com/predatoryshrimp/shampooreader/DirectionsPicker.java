package com.predatoryshrimp.shampooreader;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DirectionsPicker
{
    private Context context;

    private Random rng;

    private String[] directions;
    private List<Integer> directionTracker;

    public DirectionsPicker(Context current)
    {
        this.context = current;
        rng = new Random();
        directions = current.getResources().getStringArray(R.array.directions);
        directionTracker = new ArrayList<Integer>();
    }


    public String generateDirections(int numberInList)
    {
        String directionsList = "";

        for (int i = 1; i < numberInList; i++)
        {

            directionsList += ("Step " + i + ": ");
            directionsList += directions[getUniqueRandomNumber(directions, directionTracker)];
            directionsList += "\n";
        }

        directionsList += "Finally: ";
        directionsList += directions[getUniqueRandomNumber(directions, directionTracker)];


        return directionsList;
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
