package com.troaked.extremerps;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import com.troaked.extremerps.screen.Screen;
import com.troaked.extremerps.screen.ScreenMainMenu;
import com.troaked.extremerps.util.Images;

/**
 * Created by Andrew on 5/24/2016.
 */
public class GamePanel extends SurfaceView implements SurfaceHolder.Callback{

    private MainThread thread;
    private Paint paint = new Paint();
    private Screen currentScreen;


    public Images images;

    public GamePanel(Context context){
        super(context);

        getHolder().addCallback(this);

        images = new Images(this);
        currentScreen = new ScreenMainMenu(this);

        thread = new MainThread(getHolder(), this);
        setFocusable(true);
    }

    public void draw(Canvas canvas) {
        paint.setColor(Color.WHITE);
        canvas.drawRect(new Rect(0, 0, getWidth(), getHeight()), paint);

        currentScreen.draw(canvas, this.paint);

        paint.setColor(Color.BLACK);
        paint.setTextSize(48);
        canvas.drawText(thread.averageFPS+"", 10, 50, paint);
    }

    public void update(){

    }

    public void changeScreen(Screen s){
        this.currentScreen = s;
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        //starting game loop
        thread.setRunning(true);
        thread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        while(retry){
            try{
                thread.setRunning(false);
                thread.join();
            }catch(InterruptedException e){e.printStackTrace();}
            retry = false;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
