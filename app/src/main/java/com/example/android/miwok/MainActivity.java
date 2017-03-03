/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        // Find a view that shows the number category
        TextView numbers = (TextView) findViewById(R.id.numbers);

        // Set a click listener on that view
        numbers.setOnClickListener(new View.OnClickListener() {

            // The code in this method will be executed when the numbers category is clicked
            @Override
            public void onClick(View view) {
                // Create a new intent
                Intent numberIntent = new Intent(MainActivity.this,NumbersActivity.class);
                // Start the new Activity
                startActivity(numberIntent);
            }
        });

        // Find a view that shows the family category
        TextView familty = (TextView) findViewById(R.id.family);

        // Set a click listener on that view
        familty.setOnClickListener(new View.OnClickListener() {

            // The code in this method will be executed when the numbers category is clicked
            @Override
            public void onClick(View view) {
                // Create a new intent
                Intent familyIntent = new Intent(MainActivity.this,FamilyMembersActivity.class);
                // Start the new Activity
                startActivity(familyIntent);
            }
        });

        // Find a view that shows the number category
        TextView colors = (TextView) findViewById(R.id.colors);

        // Set a click listener on that view
        colors.setOnClickListener(new View.OnClickListener() {

            // The code in this method will be executed when the numbers category is clicked
            @Override
            public void onClick(View view) {
                // Create a new intent
                Intent colorIntent = new Intent(MainActivity.this,ColorsActivity.class);
                // Start the new Activity
                startActivity(colorIntent);
            }
        });

        // Find a view that shows the number category
        TextView phrases = (TextView) findViewById(R.id.phrases);

        // Set a click listener on that view
        phrases.setOnClickListener(new View.OnClickListener() {

            // The code in this method will be executed when the numbers category is clicked
            @Override
            public void onClick(View view) {
                // Create a new intent
                Intent phrasesIntent = new Intent(MainActivity.this,PhrasesActivity.class);
                // Start the new Activity
                startActivity(phrasesIntent);
            }
        });
    }

    public void openNumbersList(View view){
        Intent i = new Intent(this,NumbersActivity.class);
        startActivity(i);
    }

    public void openFamilyList(View view){
        Intent i = new Intent(this,FamilyMembersActivity.class);
        startActivity(i);
    }

    public void openColorsList(View view){
        Intent i = new Intent(this,ColorsActivity.class);
        startActivity(i);
    }

    public void openPhrasessList(View view){
        Intent i = new Intent(this,PhrasesActivity.class);
        startActivity(i);
    }
}
