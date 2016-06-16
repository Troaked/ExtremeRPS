package com.troaked.extremerps.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.troaked.extremerps.GamePanel;
import com.troaked.extremerps.R;

/**
 * Created by Andrew on 6/12/2016.
 */
public class Images {

    public static Bitmap playButton;

    public Images(GamePanel p){
        playButton = loadImage(p, R.drawable.playbutton);
    }

    private Bitmap loadImage(GamePanel panel,int id){
        Bitmap img = BitmapFactory.decodeResource(panel.getResources(), id);
        return img;
    }
}
