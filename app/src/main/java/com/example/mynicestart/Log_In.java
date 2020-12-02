package com.example.mynicestart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Se crea una pantalla para entra en la aplicacion introducciendo el usuario y contrasena,
 * dando paso a que puedas registrarese pinchando en el texto o ir al main pulsando el boton.
 * @author Alvaro
 * @see Sign_up
 * @see MainActivity
 */
public class Log_In extends AppCompatActivity {
TextView btn_sign_up;
Button btn_log_in;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log__in);
        btn_sign_up = findViewById(R.id.txt_register);
        btn_log_in = findViewById(R.id.btn_log_in);
        btn_sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openApp(true);
            }
        });
        btn_log_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openApp2(true);
            }
        });
    }
    private void openApp(boolean locationPermission) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Log_In
                        .this, Sign_up.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        },0);
    }

    private void openApp2(boolean locationPermission) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Log_In
                        .this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        },0);
    }
}