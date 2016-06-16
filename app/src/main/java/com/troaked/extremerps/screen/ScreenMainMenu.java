package com.troaked.extremerps.screen;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.graphics.drawable.PictureDrawable;

import com.larvalabs.svgandroid.SVG;
import com.larvalabs.svgandroid.SVGParser;
import com.troaked.extremerps.GamePanel;
import com.troaked.extremerps.R;


/**
 * Created by Andrew on 6/5/2016.
 */
public class ScreenMainMenu extends Screen {

    private GamePanel panel;
    private Bitmap playButton;
    //test 

    public ScreenMainMenu(GamePanel p){
        this.panel = p;
        Matrix rot = new Matrix();
        rot.setRotate(-5);
        playButton = Bitmap.createBitmap(panel.images.playButton, 0, 0, panel.images.playButton.getWidth(), panel.images.playButton.getHeight(), rot, false);
        for(int x = 0; x<playButton.getWidth(); x++){
            for(int y = 0; y<playButton.getHeight(); y++){
                if(playButton.getPixel(x, y) == Color.BLACK){
                    playButton.setPixel(x, y, Color.TRANSPARENT);
                }
            }
        }
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        paint.setColor(Color.BLUE);
        //canvas.drawRect(new Rect(200, 200, 500, 500), paint);




        canvas.drawBitmap(playButton, new Rect(0,0,playButton.getWidth(),playButton.getHeight()), new Rect(50, 50, 50 + 500, 50 + 100), paint);



    }

    @Override
    public void tick() {

    }
}
