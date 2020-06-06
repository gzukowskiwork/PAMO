package com.example.bmicalculator;

import java.util.List;

public class Recepie {

    public List<String>Ingredients;
    public String Title;
    public String HowTo;


    public Recepie(List<String> ingredients, String title, String howTo) {
        Ingredients = ingredients;
        Title = title;
        HowTo = howTo;
    }

    public List<String> getIngredients() {
        return Ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        Ingredients = ingredients;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getHowTo() {
        return HowTo;
    }

    public void setHowTo(String howTo) {
        HowTo = howTo;
    }
}
