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
    ArrayAdapter original_adapter, display_adapter;

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
        original_adapter = new ArrayAdapter<Homes>(this, R.layout.list_listview);

        //OnEditorActionListener for the keyboard. This logic defines how the list updates
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                String input = editText.getText().toString();
                boolean handled = false;

                    //If the user presses enter on the keyboard
                    //Update the display adapter with the proper addresses
                    if (actionId == EditorInfo.IME_ACTION_DONE){
                        display_adapter.clear();
                        for(int i = 0; i < original_adapter.getCount(); i++){
                            Object obj = original_adapter.getItem(i);
                            Homes trueObject = (Homes) obj;

                            if (trueObject.getZipCode()){
                                display_adapter.add(obj);
                            }
                        }
                        results_list.setAdapter(display_adapter);
                    }

                return handled;
            }
        });

        display_adapter.add(first);
        display_adapter.add(second);
        display_adapter.add(third);
        original_adapter = display_adapter;
        results_list.setAdapter(display_adapter);
    }

    protected boolean zipcodeMatches(Homes h, String input){

        return h.getZipcode().equals(input);
    }
}
