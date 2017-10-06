package com.devbaltasarq.burguerbuildercomplexlistview.view;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.devbaltasarq.burguerbuildercomplexlistview.R;

/**
  * Explains to Android how to visualize each entry in the ListView.
  */
public class ListViewEntryArrayAdapter extends ArrayAdapter<ListViewEntry> {
    public ListViewEntryArrayAdapter(Context context, ListViewEntry[] entries)
    {
        super( context, 0, entries );

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        final LayoutInflater layoutInflater = LayoutInflater.from( this.getContext() );
        final ListViewEntry entry = getItem( position );

        if ( convertView == null ) {
            convertView = layoutInflater.inflate( R.layout.listview_ingredient_entry, null );
        }

        final CheckBox chkSelected = convertView.findViewById( R.id.chkEntryIngredientSelected );
        final TextView lblIngredient = convertView.findViewById( R.id.lblEntryIngredientName );
        final TextView lblPrice = convertView.findViewById( R.id.lblEntryIngredientPrice );

        chkSelected.setChecked( entry.isSelected() );
        lblIngredient.setText( entry.getIngredient() );
        lblPrice.setText( String.format( "%4.2f€", entry.getPrice() ) );

        return convertView;
    }
}