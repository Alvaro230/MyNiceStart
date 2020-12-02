package com.example.mynicestart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

/**
 * Es el "main" pagina principal de la aplicacion y tiene un boton para ir al main2
 * @author Alvaro
 * @see MainActivity2
 */
public class MainActivity extends AppCompatActivity {
    Button btn;
    ImageView img_perfil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn_pasar);
        img_perfil = findViewById(R.id.img_perfil);
        Glide.with(this)
                .load(R.drawable.eus)
                .transition(DrawableTransitionOptions.withCrossFade(500))
                .circleCrop()
                .into(img_perfil);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity
                        .this, MainActivity2.class);
                startActivity(intent);
            }
        });
    }
}