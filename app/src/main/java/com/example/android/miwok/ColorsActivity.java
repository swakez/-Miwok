package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    MediaPlayer mediaplayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Words> words = new ArrayList<Words>();
        words.add(new Words("weṭeṭṭi", "red", R.drawable.color_red,R.raw.color_red));
        words.add(new Words("chokokki", "green", R.drawable.color_green,R.raw.color_green));
        words.add(new Words("ṭakaakki", "brown", R.drawable.color_brown,R.raw.color_brown));
        words.add(new Words("ṭopoppi", "gray", R.drawable.color_gray,R.raw.color_gray));
        words.add(new Words("ṭopoppi", "black", R.drawable.color_black,R.raw.color_black));
        words.add(new Words("kelelli", "white", R.drawable.color_white,R.raw.color_white));
        words.add(new Words("ṭopiisә", "dusty yellow", R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow));
        words.add(new Words("chiwiiṭә", "mustard yellow", R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow));

        WordAdapter adapter = new WordAdapter(this, words,R.color.category_colors);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //  Toast.makeText(NumbersActivity.this, "List item clicked", Toast.LENGTH_SHORT).show();
                Words localword = (Words)adapterView.getItemAtPosition(i);
                int id = localword.getMusicResourceId();
                MediaPlayer mediaPlayer = MediaPlayer.create(ColorsActivity.this,id);
                mediaPlayer.start();

            }
        });



    }
}
