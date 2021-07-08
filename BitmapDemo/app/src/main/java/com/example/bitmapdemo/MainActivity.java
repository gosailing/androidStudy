package com.example.bitmapdemo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.imageview1);

        assetsLoad();

        manualLoad(imageView);

        glideLoad(imageView);

    }

    private void assetsLoad() {
        InputStream inputStream = null;
        try {
            inputStream = getAssets().open("image1.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
        int size = bitmap.getAllocationByteCount();
        Log.d("YH--", "assets load size = " + size);
    }

    private void manualLoad(ImageView imageView) {

        TypedValue typedValue = new TypedValue();
        getResources().getValue(R.drawable.image1,typedValue,true);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.image1);
        int size = bitmap.getAllocationByteCount();
        Log.d("YH--", "manual load size = " + size);
        imageView.setImageBitmap(bitmap);
    }

    private void glideLoad(ImageView imageView) {
        Glide.with(this).load(R.drawable.image1).into(new CustomTarget<Drawable>() {
            @Override
            public void onResourceReady(@NonNull Drawable resource, Transition<? super Drawable> transition) {
                Bitmap bitmap = drawableToBitmap(resource);
                int size = bitmap.getAllocationByteCount();
                Log.d("YH--", "glide load size = " + size + " " + size/1024/1024);
                imageView.setImageBitmap(bitmap);
            }

            @Override
            public void onLoadCleared(@Nullable Drawable placeholder) {
                Log.d("YH--", "onLoadCleared");

            }
        });
//        Glide.with(this).load("https://goo.gl/gEgYUd").into(imageView);
    }


    public static Bitmap drawableToBitmap (Drawable drawable) {
        Bitmap bitmap = null;

        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if(bitmapDrawable.getBitmap() != null) {
                return bitmapDrawable.getBitmap();
            }
        }

        if(drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
            bitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888); // Single color bitmap will be created of 1x1 pixel
        } else {
            bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        }

        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmap;
    }
}