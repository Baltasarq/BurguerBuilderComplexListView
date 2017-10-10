package com.devbaltasarq.burguerbuildercomplexlistview.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.devbaltasarq.burguerbuildercomplexlistview.R;

/** Explains to the ListView how to show each entry. */
public class ListViewIngredientEntryArrayAdapter extends ArrayAdapter<ListViewIngredientEntry> {
    public ListViewIngredientEntryArrayAdapter(Context context, ListViewIngredientEntry[] entries)
    {
        super( context, 0, entries );

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        final LayoutInflater layoutInflater = LayoutInflater.from( this.getContext() );
        final ListViewIngredientEntry entry = getItem( position );

        if ( convertView == null ) {
            convertView = layoutInflater.inflate( R.layout.listview_ingredient_entry, null );
        }

        final CheckBox chkSelected = convertView.findViewById( R.id.chkEntryIngredientSelected );
        final TextView lblIngredient = convertView.findViewById( R.id.lblEntryIngredientName );
        final TextView lblCost = convertView.findViewById( R.id.lblEntryIngredientCost);

        chkSelected.setChecked( entry.isSelected() );
        lblIngredient.setText( entry.getIngredient() );
        lblCost.setText( String.format( "%4.2f€", entry.getCost() ) );

        return convertView;
    }
}
