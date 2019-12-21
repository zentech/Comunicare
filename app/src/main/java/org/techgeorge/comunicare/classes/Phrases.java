package org.techgeorge.comunicare.classes;

import android.content.Context;
import android.content.res.Resources;

import org.techgeorge.comunicare.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Phrases {
    public static String[] categories =
            {"feeling", "home", "work", "medical", "food", "activity", "common", "emergency"};
    public static Map<String, ArrayList<String>> allPhrases = new HashMap<>();
    private static boolean execute = false;
    private Phrases() {
    }


    /**
     * reference all string-arrays in string.xml file and add into hashmap
     * using categories array as key
     * @param context
     */
    public static void fetchAllPhrases(Context context) {
        if(execute == true) { return; } //flag to run this method only once
        execute = true;
        Resources res = context.getResources();
        allPhrases.put(categories[0], new ArrayList<>(Arrays.asList(res.getStringArray(R.array.feeling))));
        allPhrases.put(categories[1],  new ArrayList<>(Arrays.asList(res.getStringArray(R.array.home))));
        allPhrases.put(categories[2], new ArrayList<>(Arrays.asList(res.getStringArray(R.array.work))));
        allPhrases.put(categories[3], new ArrayList<>(Arrays.asList(res.getStringArray(R.array.medical))));
        allPhrases.put(categories[4], new ArrayList<>(Arrays.asList(res.getStringArray(R.array.food))));
        allPhrases.put(categories[5], new ArrayList<>(Arrays.asList(res.getStringArray(R.array.activity))));
        allPhrases.put(categories[6], new ArrayList<>(Arrays.asList(res.getStringArray(R.array.common))));
        allPhrases.put(categories[7], new ArrayList<>(Arrays.asList(res.getStringArray(R.array.emergency))));
//        Log.v("PHRASES", Arrays.toString(allPhrases.toString()));
    }

    /**
     * returs allPhrases Hashmap
     * @return allPhrases
     */
    public static Map<String, ArrayList<String>> getAllPhrases() {
        return allPhrases;
    }

}
