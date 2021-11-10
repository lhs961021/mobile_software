package com.example.a20211109_practice3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    MyGraphicView graphicView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout pictureLayout = (LinearLayout)findViewById(R.id.pictureLayout);
        graphicView = (MyGraphicView) new MyGraphicView(this);
        pictureLayout.addView(graphicView);

    }

    private static class MyGraphicView extends View {
        public MyGraphicView(Context context){
            super(context);
        }
        @Override
        protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

        Bitmap picture = BitmapFactory.decodeResource(getResources(), R.drawable.jisu);

        int picX = (this.getWidth() - picture.getWidth()) / 2;
        int picY = (this.getHeight() - picture.getHeight()) / 2;

        Paint paint = new Paint();
        float[] array = { 2, 0, 0, 0, -25,
                            0, 2, 0, 0, -25,
                            0, 0, 2, 0, -25,
                            0, 0, 0, 1 ,0 };
        ColorMatrix cm = new ColorMatrix(array);
        paint.setColorFilter(new ColorMatrixColorFilter(cm));
        canvas.drawBitmap(picture, picX, picY, paint);
        picture.recycle();

        }
    }
}