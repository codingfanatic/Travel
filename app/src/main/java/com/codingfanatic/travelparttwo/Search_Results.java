package com.codingfanatic.travelparttwo;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Search_Results extends AppCompatActivity {
    
    ListView results_list;
    ArrayList<String> mArrayList = new ArrayList<>();
    EditText editText;
    DatabaseReference myRef;

    ArrayAdapter original_adapter, display_adapter, no_results_adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
        getSupportActionBar().setTitle("Search Zipcode");

        results_list = findViewById(R.id.result_list);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_listview, mArrayList);
        results_list.setAdapter(adapter);

        myRef = FirebaseDatabase.getInstance().getReference();

        display_adapter = new ArrayAdapter<Home>(this, R.layout.list_listview);
        original_adapter = new ArrayAdapter<Home>(this, R.layout.list_listview);
        no_results_adapter = new ArrayAdapter<String>(this, R.layout.list_listview);

        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                String value = snapshot.getValue(String.class);
                Home homeObject = new Home(value);
                original_adapter.add(homeObject);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        /*
        Home first = new Home(Home.ADDRESS_ONE);
        Home second = new Home(Home.ADDRESS_TWO);
        Home third = new Home(Home.ADDRESS_THREE);
        
        original_adapter.add(first);
        original_adapter.add(second);
        original_adapter.add(third);
        */

        no_results_adapter.add("NO RESULTS FOUND");

            for(int i = 0; i < original_adapter.getCount(); i++){
                display_adapter.add(original_adapter.getItem(i));
            }

        results_list.setAdapter(original_adapter);

        //OnEditorActionListener for the keyboard. This logic defines how the list updates
        editText = findViewById(R.id.input);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                int adapterSize = original_adapter.getCount();
                boolean handled = false;
                String input = editText.getText().toString();
                String homeString;
                Home dummyHome;

                //If the user presses enter on the keyboard, search the list (only sets the No Results adapter for now)
                //If the editText is empty, display nothing
                //Update the display adapter with the proper addresses
                //If the display adapter is empty, set an ArrayAdapter with the String "NO RESULTS"
                //Create a dummy homes object. It will be instantiated using the string returned by the toString() method for each object  in the original_adapter.
                if(actionId == EditorInfo.IME_ACTION_DONE){
                    display_adapter.clear();

                    if(input.length() > 0){
                        for(int i = 0; i < adapterSize; i++){
                            int r = original_adapter.getCount();
                            homeString = original_adapter.getItem(i).toString();
                            dummyHome = new Home(homeString);

                                //Update the display_adapter with matching addresses and display
                                if(dummyHome.hasZipcode(input)){
                                    //Logic for adding the dummyHome to the display adapter
                                    display_adapter.add(dummyHome);
                                }

                        }

                        //If the display_adapter contains items, display the new list
                        if(!(display_adapter.getCount() == 0)){
                            results_list.setAdapter(display_adapter);
                        }
                        //If not, display the no results adapter
                        else
                            results_list.setAdapter(no_results_adapter);
                    }
                    else
                        results_list.setAdapter(original_adapter);
                }

                return handled;
            }
        });
    }

}
