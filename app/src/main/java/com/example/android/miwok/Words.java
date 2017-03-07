package com.example.android.miwok;

/**
 * Created by swati on 01/03/2017.
 */

public class Words {

    /**
     * Miwok Translation of the word
     */
    private String mMiwokTranslation;

    /**
     * Default Translation of the word
     */
    private String mDefaultTranslation;

    /**
     * Image resource id of the word
     */
    private int mImageResource = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Pronunciation of miwok word
     */
    private int mMusicResourceId;

    public Words(String miwok, String default_, int musicResource) {
        mMiwokTranslation = miwok;
        mDefaultTranslation = default_;
        mMusicResourceId = musicResource;
    }

    public Words(String miwok, String default_, int image_, int musicResource) {
        mMiwokTranslation = miwok;
        mDefaultTranslation = default_;
        mImageResource = image_;
        mMusicResourceId = musicResource;
    }

    /**
     * Get the miwok transation
     */
    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    /**
     * Get the miwok transation
     */
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    /**
     * Get the image of the object
     */
    public int getImageResourceId() {
        return mImageResource;
    }

    /**
     * Checks if there is a valid image resource
     *
     * @return true or false
     */
    public boolean hasImage() {
        return mImageResource != NO_IMAGE_PROVIDED;
    }

    /**
     * Get the prononciation of the miwok word
     */
    public int getMusicResourceId() {
        return mMusicResourceId;
    }

    @Override
    public String toString() {
        return "Words{" +
                "mMiwokTranslation='" + mMiwokTranslation + '\'' +
                ", mDefaultTranslation='" + mDefaultTranslation + '\'' +
                ", mImageResource=" + mImageResource +
                ", mMusicResourceId=" + mMusicResourceId +
                '}';
    }
}