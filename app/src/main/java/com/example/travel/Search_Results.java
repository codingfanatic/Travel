package com.example.travel;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class Search_Results extends AppCompatActivity {
    ListView results_list;
    EditText editText;
    ArrayAdapter original_adapter, display_adapter, no_results_adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
        getSupportActionBar().setTitle("Search Zipcode");

        Homes first = new Homes(Homes.ADDRESS_ONE);
        Homes second = new Homes(Homes.ADDRESS_TWO);
        Homes third = new Homes(Homes.ADDRESS_THREE);

        editText = findViewById(R.id.input);

        results_list = findViewById(R.id.result_list);
        display_adapter = new ArrayAdapter<Homes>(this, R.layout.list_listview);
        no_results_adapter = new ArrayAdapter<String>(this, R.layout.list_listview);


        //OnEditorActionListener for the keyboard. This logic defines how the list updates
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                String input = editText.getText().toString();
                String s;
                int adapterSize = original_adapter.getCount();
                Homes dummyHome = new Homes(Homes.ADDRESS_ONE);
                //ArrayAdapter noMatches = new ArrayAdapter<String>();
                boolean handled = false;

                    //If the user presses enter on the keyboard, search the list (only sets the No Results adapter for now)
                    //If the editText is empty, display the original list
                    //PAUSE Update the display adapter with the proper addresses
                    //PAUSE If the display adapter is empty, set an ArrayAdapter with the String "NO RESULTS"
                    if (actionId == EditorInfo.IME_ACTION_DONE){
                        if(input.length() > 0){
                            results_list.setAdapter(no_results_adapter);
                        }
                        else
                            results_list.setAdapter(original_adapter);
                    }

                return handled;
            }
        });

        display_adapter.add(first);
        display_adapter.add(second);
        display_adapter.add(third);
        no_results_adapter.add("NO RESULTS FOUND");
        original_adapter = display_adapter;
        results_list.setAdapter(display_adapter);
    }

    protected boolean zipcodeMatches(Homes h, String input){

        return h.getZipCode().equals(input);
    }

    //for (int i = 0; i < adapterSize ; i++){
    //display_adapter.add(dummyHome);
    // s = original_adapter.getItem(0).toString();
    //dummyHome = new Homes(s);
                                   /*
                                    if (dummyHome.getZipCode().equals(input)) {
                                        display_adapter.add(dummyHome);
                                    }no_results_adapter
                                    */
    //display_adapter.add(dummyHome);
    //}
                            /*
                            if (display_adapter.getCount() == 0){
                                dummyHome = new Homes("THERE ARE NO MATCHING RESULTS");
                                display_adapter.add(dummyHome);
                            }

                             */
}
