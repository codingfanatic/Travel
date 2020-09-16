/*
************************************************************************************************************************************************************
List Addresses
1. Add a ListView to the list_addresses layout 
2. Include an id for the layout
3. Import Bundle, AppCompatActivity, Menu, ArrayAdapter, ListView
4. Create a String array containing each of the the addresses
5. Create ListView and ArrayAdapter objects
6. Instantiate the ListView and ArrayAdapter objects
7. Set the ArrayAdapter for the ListView
************************************************************************************************************************************************************
*/
package com.codingfanatic.travelparttwo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class List_Addresses extends AppCompatActivity {
    
    //4. Create a String array containing each of the the addresses
    String[] addresses = {"123\nMain Street St. Louisville\nOH 4307",
                            "432\nMain Long Road St. Louisville\nOH 43071",
                            "786\nHigh Street Pollocksville\nOH 43071"};
    
    //5. Create ListView and ArrayAdapter objects
    ListView listview;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        getSupportActionBar().setTitle("View List");

        //6. Instantiate the ListView and ArrayAdapter objects
        listview = findViewById(R.id.address_list);
        adapter = new ArrayAdapter<String>(this, R.layout.list_listview, addresses);

        //7. Set the ArrayAdapter for the ListView    
        listview.setAdapter(adapter);
    }
}
