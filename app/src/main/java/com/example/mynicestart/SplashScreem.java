package com.example.mynicestart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

/**
 * Se crea una animacion y arran el LogIn
 * @author Alvaro
 * @see Log_In
 */
public class SplashScreem extends AppCompatActivity {
ImageView img;
ImageView img_fondo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screem);
        img = findViewById(R.id.img_inicio);
        img_fondo = findViewById(R.id.img_fondo);
        Animation myAnimation = AnimationUtils.loadAnimation(this,R.anim.rotate);
        img.startAnimation(myAnimation);
        openApp(true);
        Glide.with(this)
                .load(R.drawable.fondo)
                .transition(DrawableTransitionOptions.withCrossFade(500))
                .placeholder(new ColorDrawable(this.getResources().getColor(R.color.design_default_color_background)))
                .into(img_fondo);
    }

    private void openApp(boolean locationPermission) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreem
                        .this, Log_In.class);
                startActivity(intent);
                finish();
            }
        }, 2000);
    }
}