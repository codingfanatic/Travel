/*
************************************************************************************************************************************************************
MainActivity 
1. Create Intent, String, and TextView objects in the class
2. Style the ActionBar using a custom layout
3. Instantiate TextView objects using the id in activity_main.xml
4. Set onClickListeners to start each new Activity when the TextViews are clicked
************************************************************************************************************************************************************
*/
package com.codingfanatic.travelparttwo;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    
    //1. Create Intent, String, and TextView objects in the class
    Intent intent;
    String text;
    TextView textViewViewList, textViewSearchList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2. Style the ActionBar using a custom layout
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.mainactivity_action_bar);

        //3. Instantiate TextView objects using the id in activity_main.xml
        textViewViewList = findViewById(R.id.viewList);
        textViewSearchList= findViewById(R.id.searchList);

        //4. Set onClickListeners to start each new Activity when the TextViews are clicked
        textViewViewList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, List_Addresses.class);
                startActivity(intent);
            }
        });
        
        textViewSearchList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, Search_Results.class);
                startActivity(intent);
            }
        });

    }
}
