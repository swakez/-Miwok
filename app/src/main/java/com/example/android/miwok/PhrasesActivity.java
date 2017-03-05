package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Words> words = new ArrayList<Words>();

        words.add(new Words("minto wuksus", "Where are you going?",R.raw.phrase_where_are_you_going));
        words.add(new Words("tinnә oyaase'nә", "What is your name?",R.raw.phrase_what_is_your_name));
        words.add(new Words("oyaaset...", "My name is...",R.raw.phrase_my_name_is));
        words.add(new Words("michәksәs?", "How are you feeling?",R.raw.phrase_how_are_you_feeling));
        words.add(new Words("kuchi achit", "I’m feeling good.",R.raw.phrase_im_feeling_good));
        words.add(new Words("әәnәs'aa?", "Are you coming?",R.raw.phrase_are_you_coming));
        words.add(new Words("hәә’ әәnәm", "Yes, I’m coming.",R.raw.phrase_yes_im_coming));
        words.add(new Words("әәnәm", "I’m coming.",R.raw.phrase_im_coming));
        words.add(new Words("yoowutis", "Let’s go.",R.raw.phrase_lets_go));
        words.add(new Words("әnni'nem", "Come here",R.raw.phrase_come_here));

        WordAdapter adapter = new WordAdapter(this, words,R.color.category_phrases);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //  Toast.makeText(NumbersActivity.this, "List item clicked", Toast.LENGTH_SHORT).show();
                Words localword = (Words)adapterView.getItemAtPosition(i);
                int id = localword.getMusicResourceId();
                MediaPlayer mediaPlayer = MediaPlayer.create(PhrasesActivity.this,id);
                mediaPlayer.start();

            }
        });

    }
}
