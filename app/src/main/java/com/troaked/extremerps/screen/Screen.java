package com.troaked.extremerps.screen;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.troaked.extremerps.GamePanel;

/**
 * Created by Andrew on 6/5/2016.
 */
public abstract class Screen {



    public abstract void draw(Canvas canvas, Paint paint);

    public abstract void tick();
}
