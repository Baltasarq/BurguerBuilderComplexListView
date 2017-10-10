package com.devbaltasarq.burguerbuildercomplexlistview.view;

/** Represents a fixed ingredient (not selectable) entry in a list view. */
public class ListViewFixedIngredientEntry extends ListViewIngredientEntry{
    public ListViewFixedIngredientEntry(String ingredient, double cost)
    {
        this.ingredient = ingredient;
        this.cost = cost;
    }

    /** @return Whether this ingredient has been selected or not */
    public boolean isSelected() {
        return true;
    }

    /** Changes the selection of the ingredient to the given value */
    public void setSelected(boolean selected) {
    }

    /** @returns the individual cost of this ingredient. */
    public double getCost() {
        return this.cost;
    }


    /** @returns the name of this ingredient */
    public String getIngredient() {
        return this.ingredient;
    }

    private String ingredient;
    private double cost;
}
