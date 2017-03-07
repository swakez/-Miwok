package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyMembersActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Words> words = new ArrayList<Words>();
        words.add(new Words("әpә", "father", R.drawable.family_father,R.raw.family_father));
        words.add(new Words("әṭa", "mother", R.drawable.family_mother,R.raw.family_mother));
        words.add(new Words("angsi", "son", R.drawable.family_son,R.raw.family_son));
        words.add(new Words("tune", "daughter", R.drawable.family_daughter,R.raw.family_daughter));
        words.add(new Words("taachi", "older brother", R.drawable.family_older_brother,R.raw.family_older_brother));
        words.add(new Words("chalitti", "younger brother", R.drawable.family_younger_brother,R.raw.family_younger_brother));
        words.add(new Words("teṭe", "older sister", R.drawable.family_older_sister,R.raw.family_older_sister));
        words.add(new Words("kolliti", "younger sister", R.drawable.family_younger_sister,R.raw.family_younger_sister));
        words.add(new Words("ama", "grandmother", R.drawable.family_grandmother,R.raw.family_grandmother));
        words.add(new Words("paapa", "grandfather", R.drawable.family_grandfather,R.raw.family_grandfather));

        WordAdapter adapter = new WordAdapter(this, words,R.color.category_family);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                releaseMediaPlayer();
                //  Toast.makeText(NumbersActivity.this, "List item clicked", Toast.LENGTH_SHORT).show();
                Words localword = (Words)adapterView.getItemAtPosition(i);
                int id = localword.getMusicResourceId();
                mediaPlayer = MediaPlayer.create(FamilyMembersActivity.this,id);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(mCompletionListener);

            }
        });

    }

    private void releaseMediaPlayer(){

        // If mediaplayer is not null it must be playing an audio file

        if(mediaPlayer != null){

            // Release the resource, we no longer need it

            mediaPlayer.release();

        }

        // Set the media player back to null. For our code, we've decided that
        // setting the media player to null is an easy way to tell that the media player
        // is not configured to play an audio file at the moment.

        mediaPlayer = null;

    }

}
