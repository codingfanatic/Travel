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

//6. Override the onChildAdded method for the ChildEventListener for the DatabaseReference object
package com.codingfanatic.travelparttwo;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class List_Addresses extends AppCompatActivity {
    
    //1. Instantiated ListView and ArrayList objects
    ListView listview;
    ArrayList<String> mArrayList = new ArrayList<>();
    DatabaseReference myRef;
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        getSupportActionBar().setTitle("View List");

        //2. Instantiated ArrayAdapter using Activity, list_listview xml layout, and ArrayList object
        //3. Assigned reference to ListView object using List View layout from activity_main xml layout
        //   Set Adapter for the ListView object
        listview = (ListView) findViewById(R.id.address_list);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_listview, mArrayList);
        listview.setAdapter(adapter);
        
        //4. Assigned a reference to the DatabaseReference object
        myRef = FirebaseDatabase.getInstance().getReference();

        //5. Add a Child Event Listener to the DatabaseReference object
        myRef.addChildEventListener(new ChildEventListener() {

            //6. Override the onChildAdded method for the ChildEventListener for the DatabaseReference object
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                String value = snapshot.getValue(String.class);
                mArrayList.add(value);
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
    }
}
