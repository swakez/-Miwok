package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    /** Handles audio focus when playing a sound file */
    private AudioManager audioManager;

    /**
     * This listener gets triggered whenever the audio focus changes
     * (i.e., we gain or lose audio focus because of another app or device).
     */
    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener(){
        @Override
        public void onAudioFocusChange(int focusChange) {
            if(focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK
                    || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT){
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
            }
            else if(focusChange == AudioManager.AUDIOFOCUS_GAIN){
                mediaPlayer.start();
            }
            else if (focusChange == AudioManager.AUDIOFOCUS_LOSS){
                releaseMediaPlayer();
            }
        }
    };

    /**
     * This listener gets triggered when the MediaPlayer has completed
     * playing the audio file.
     */
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

        audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);

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

                releaseMediaPlayer();

                //  Toast.makeText(NumbersActivity.this, "List item clicked", Toast.LENGTH_SHORT).show();
                Words localword = (Words)adapterView.getItemAtPosition(i);
                int id = localword.getMusicResourceId();

                // Request audio focus for playback
                int result = audioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        // Use the music stream.
                        AudioManager.STREAM_MUSIC,
                        // Request permanent focus.
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // We have the audio focus now
                    mediaPlayer = MediaPlayer.create(PhrasesActivity.this,id);
                    // Start the audio file
                    mediaPlayer.start();
                    // Set the media player listener so that we can stop
                    // and release the media player once the sound has finished playing
                    mediaPlayer.setOnCompletionListener(mCompletionListener);
                }

            }
        });

    }

    private void releaseMediaPlayer(){
        // If mediaplayer is not null it must be playing an audio file
        if(mediaPlayer != null){

            // Release the resource, we no longer need it
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;

            audioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
        Log.v("PhrasesActivity","inonstop");
    }


}
