package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by swati on 01/03/2017.
 */

public class WordAdapter extends ArrayAdapter<Words>{

    /** Resource ID for the background color for this list of words */
    private int mColorResourceId;

    /**
     * Create a new {@link WordAdapter} object.
     *
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param words is the list of {@link Words}s to be displayed.
     * @param words is the list of {@link Words}s to be displayed.
         * @param colorResourceId is the resource ID for the background color for this list of words
     */
    public  WordAdapter(Activity context, ArrayList<Words> words, int colorResourceId){
        super(context, 0, words);
        mColorResourceId = colorResourceId;
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;

        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }
        Words localWord = getItem(position);

        TextView miwokTextView = (TextView)listItemView.findViewById(R.id.miwok_text_view);
        miwokTextView.setText(localWord.getMiwokTranslation());

        TextView defaultTextView = (TextView)listItemView.findViewById(R.id.default_text_view);
        defaultTextView.setText(localWord.getDefaultTranslation());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);

        if(localWord.hasImage()== true) {
            imageView.setImageResource(localWord.getImageResourceId());
            imageView.setVisibility(View.VISIBLE);
        }
        else
            imageView.setVisibility(View.GONE);

        View textContainer = listItemView.findViewById(R.id.text_container);

        int color = ContextCompat.getColor(getContext(),mColorResourceId);

        textContainer.setBackgroundColor(color);


        return listItemView;

        //return super.getView(position, convertView, parent);
    }



}
