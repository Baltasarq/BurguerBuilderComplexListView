package com.devbaltasarq.burguerbuildercomplexlistview.view;

/** An entry in a ListView for an ingredient */
public abstract class ListViewIngredientEntry {
    /** @return Whether this ingredient has been selected or not */
    public abstract boolean isSelected();

    /** Changes the selection of the ingredient to the given value */
    public abstract void setSelected(boolean selected);

    /** Inverts the current selection state */
    public void invertSelection()
    {
        this.setSelected( !this.isSelected() );
    }

    /** @returns the individual cost of this ingredient. */
    public abstract double getCost();


    /** @returns the name of this ingredient */
    public abstract String getIngredient();

    @Override
    public String toString() {
        return String.format( "%4.2f '%s': %b", this.getCost(), this.getIngredient(), this.isSelected() );
    }
}
