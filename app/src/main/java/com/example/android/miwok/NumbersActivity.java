package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create an array of words
        ArrayList<Words> words = new ArrayList<Words>();
        words.add(new Words("tutti", "one", R.drawable.number_one));
        words.add(new Words("otiiko", "two", R.drawable.number_two));
        words.add(new Words("tolookosu", "three", R.drawable.number_three));
        words.add(new Words("oyyisa", "four", R.drawable.number_four));
        words.add(new Words("massokka", "five", R.drawable.number_five));
        words.add(new Words("temmokka", "six", R.drawable.number_six));
        words.add(new Words("tenekaku", "seven", R.drawable.number_seven));
        words.add(new Words("kawinta", "eight", R.drawable.number_eight));
        words.add(new Words("wo'e", "nine", R.drawable.number_nine));
        words.add(new Words("na'aacha", "ten", R.drawable.number_ten));

        WordAdapter adapter = new WordAdapter(this,words,R.color.category_numbers);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

    }
}
