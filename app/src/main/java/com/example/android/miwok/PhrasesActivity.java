package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Words> words = new ArrayList<Words>();

        words.add(new Words("minto wuksus", "Where are you going?"));
        words.add(new Words("tinnә oyaase'nә", "What is your name?"));
        words.add(new Words("oyaaset...", "My name is..."));
        words.add(new Words("michәksәs?", "How are you feeling?"));
        words.add(new Words("kuchi achit", "I’m feeling good."));
        words.add(new Words("әәnәs'aa?", "Are you coming?"));
        words.add(new Words("hәә’ әәnәm", "Yes, I’m coming."));
        words.add(new Words("әәnәm", "I’m coming."));
        words.add(new Words("yoowutis", "Let’s go."));
        words.add(new Words("әnni'nem", "Come here"));

        WordAdapter adapter = new WordAdapter(this, words,R.color.category_phrases);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);
    }
}
