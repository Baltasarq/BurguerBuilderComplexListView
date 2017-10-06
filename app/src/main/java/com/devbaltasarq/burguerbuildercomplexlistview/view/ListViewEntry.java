package com.devbaltasarq.burguerbuildercomplexlistview.view;

/** Represents each row in the ListView.
  * The ListView will have entries displaying selection, ingredient and price
  */
public class ListViewEntry {
    /** Creates an unselected entry with a given ingredient and price */
    public ListViewEntry(String ingredient, double price)
    {
        this( ingredient, price, false );
    }

    /** Creates an entry with a given ingredient, price, and selection status */
    public ListViewEntry(String ingredient, double price, boolean selected)
    {
        this.setIngredient( ingredient );
        this.setPrice( price );
        this.setSelected( selected );
    }

    public final boolean isSelected() {
        return selected;
    }

    public final void setSelected(boolean selected) {
        this.selected = selected;
    }

    public double getPrice() {
        return price;
    }

    public final void setPrice(double price) {
        this.price = price;
    }

    public String getIngredient() {
        return ingredient;
    }

    public final void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    @Override
    public String toString() {
        return String.format( "%4.2f '%s': %b", this.getPrice(), this.getIngredient(), this.isSelected() );
    }

    private boolean selected;
    private double price;
    private String ingredient;
}
