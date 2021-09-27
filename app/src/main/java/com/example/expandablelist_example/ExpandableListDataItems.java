package com.example.expandablelist_example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListDataItems {

    public static HashMap<String, List<String>> getData(){

        HashMap<String,List<String>> expandableDetailList = new HashMap<String,List<String>>();

        //List 1
        List<String> fruits = new ArrayList<String>();
        fruits.add("Apple");
        fruits.add("Orange");
        fruits.add("Guava");
        fruits.add("Papaya");
        fruits.add("Pineapple");

        //List 2
        List<String> vegetables = new ArrayList<String>();
        vegetables.add("Tomato");
        vegetables.add("Potato");
        vegetables.add("Carrot");
        vegetables.add("Cabbage");
        vegetables.add("Cauliflower");

        //List 3
        List<String> nuts = new ArrayList<String>();
        nuts.add("Cashews");
        nuts.add("Badam");
        nuts.add("Pista");
        nuts.add("Raisin");
        nuts.add("Walnut");

        expandableDetailList.put("Fruits Items",fruits);
        expandableDetailList.put("Vegetable Items",vegetables);
        expandableDetailList.put("Nuts Items",nuts);
        return expandableDetailList;
    }
}
