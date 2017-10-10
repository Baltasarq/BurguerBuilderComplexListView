package com.devbaltasarq.burguerbuildercomplexlistview.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.devbaltasarq.burguerbuildercomplexlistview.R;
import com.devbaltasarq.burguerbuildercomplexlistview.core.BurguerConfigurator;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create the burguer configuration
        this.cfgBurguer = new BurguerConfigurator();

        // Report relevant info
        Log.i( "MainActivity.OnCreate", "Number of ingredientAdapterList: "
                + BurguerConfigurator.INGREDIENTS.length );

        for(int i = 0; i < BurguerConfigurator.INGREDIENTS.length; ++i) {
            Log.i( "MainActivity.OnCreate", "Availabel ingredient: "
                    + BurguerConfigurator.INGREDIENTS[ i ] );
        }

        // Show components and initial totals
        this.showFixedIngredients();
        this.showIngredients();
        this.updateTotals();
    }

    private void showFixedIngredients()
    {
        ListView lvFixedIngredients = (ListView) this.findViewById( R.id.lvFixedIngredients );

        lvFixedIngredients.setAdapter(
                new ArrayAdapter<String>(
                        this,
                        android.R.layout.simple_list_item_1,
                        new String[] { "─  1.00€ Pan", "─  2.00€ Carne de vacuno" } ) );

    }

    private void showIngredients()
    {
        final int NUM_INGREDIENTS = this.cfgBurguer.getSelected().length;
        final ListView lvIngredients = (ListView) this.findViewById( R.id.lvIngredients );

        // Create list
        ListViewEntry[] ingredientEntryAdapterList = new ListViewEntry[ NUM_INGREDIENTS ];

        for(int i = 0; i < NUM_INGREDIENTS; ++i) {
            ingredientEntryAdapterList[ i ] = new ListViewEntry( this.cfgBurguer, i );
        }

        this.ingredientAdapterList = new ListViewEntryArrayAdapter(
                this,
                ingredientEntryAdapterList
        );

        lvIngredients.setAdapter( this.ingredientAdapterList );

        lvIngredients.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MainActivity.this.ingredientAdapterList.getItem( i ).invertSelection();
                MainActivity.this.ingredientAdapterList.notifyDataSetChanged();
                MainActivity.this.updateTotals();
            }
        });
    }

    private void updateTotals()
    {
        final TextView lblTotal = (TextView) this.findViewById( R.id.lblTotal );

        // Report
        Log.i( "MainActivity.updTotals", "Starting updating." );
        for(int i = 0; i < BurguerConfigurator.INGREDIENTS.length; ++i) {
            Log.i( "MainActivity.updTotals",
                    BurguerConfigurator.INGREDIENTS[ i ]
                            + " (" + BurguerConfigurator.COSTS[ i ] + ")"
                            + ": " + ( this.cfgBurguer.getSelected()[ i ] ? "Yes" : "No" )
            );
        }

        Log.i( "MainActivity.updTotals", "Total cost: "  + this.cfgBurguer.calculateCost() );

        // Update
        lblTotal.setText(
                String.format( "%4.2f", MainActivity.this.cfgBurguer.calculateCost() ) );
        Log.i( "MainActivity.updTotals", "End updating." );
    }

    private BurguerConfigurator cfgBurguer;
    private ListViewEntryArrayAdapter ingredientAdapterList;
}
