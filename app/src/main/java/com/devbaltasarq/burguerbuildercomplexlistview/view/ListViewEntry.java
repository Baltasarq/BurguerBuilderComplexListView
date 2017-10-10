package com.devbaltasarq.burguerbuildercomplexlistview.view;

import com.devbaltasarq.burguerbuildercomplexlistview.core.BurguerConfigurator;

/** Represents each entry in the ListView.
  * Adapts each entry in the ListView to the burguer configurator object: selected, name and cost.
  */
public class ListViewEntry {
    /** Connects this entry with an ingredient position in the burguer configurator list. */
    public ListViewEntry(BurguerConfigurator bc, int pos)
    {
        this.bc = bc;
        this.pos = pos;
    }

    /** @return The position of this ingredient in the burguer configurator list */
    public int getPos()
    {
        return this.pos;
    }

    /** @return Whether this ingredient has been selected or not */
    public boolean isSelected() {
        return this.bc.getSelected()[ this.pos ];
    }

    /** Changes the selection of the ingredient to the given value */
    public void setSelected(boolean selected) {
        this.bc.getSelected()[ this.pos ] = selected;
    }

    /** Inverts the current selection state */
    public void invertSelection()
    {
        this.setSelected( !this.isSelected() );
    }

    /** @returns the individual cost of this ingredient. */
    public double getCost() {
        return BurguerConfigurator.COSTS[ this.pos ];
    }


    /** @returns the name of this ingredient */
    public String getIngredient() {
        return BurguerConfigurator.INGREDIENTS[ this.pos ];
    }

    @Override
    public String toString() {
        return String.format( "%4.2f '%s': %b", this.getCost(), this.getIngredient(), this.isSelected() );
    }

    private BurguerConfigurator bc;
    private int pos;
}
