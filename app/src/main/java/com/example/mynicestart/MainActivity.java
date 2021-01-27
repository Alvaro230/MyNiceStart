package com.example.mynicestart;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.alespero.expandablecardview.ExpandableCardView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.google.android.material.snackbar.Snackbar;

/**
 * Es el "main" pagina principal de la aplicacion y tiene un boton para ir al main2
 *
 * @author Alvaro
 * @see MainActivity2
 */
public class MainActivity extends AppCompatActivity {
    private Button btn;
    private ImageView img_perfil;
    private SwipeRefreshLayout swipeLayout;
    private ExpandableCardView card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn_pasar);
        img_perfil = findViewById(R.id.img_perfil);
        card = findViewById(R.id.profile);

        //Para sacar el menu contextual
        registerForContextMenu(img_perfil);

        swipeLayout = (SwipeRefreshLayout) findViewById(R.id.myswipe);
        swipeLayout.setOnRefreshListener(mOnRefreshListener);


        card.setOnExpandedListener(new ExpandableCardView.OnExpandedListener() {
            @Override
            public void onExpandChanged(View v, boolean isExpanded) {
                Toast.makeText(MainActivity.this, isExpanded ? "Expanded!" :
                        "Collapsed!", Toast.LENGTH_SHORT).show();
            }
        });

        /*
        Aqui pongo la imagen del muñecote en el main1 diciendole donde va
        y que tenga forma de circulo con el circleCrop()
         */
        Glide.with(this)
                .load(R.drawable.eus)
                .transition(DrawableTransitionOptions.withCrossFade(500))
                .circleCrop()
                .into(img_perfil);
        btn.setOnClickListener(new View.OnClickListener() {
            /*
            Este es el metodo que al pulsar el boton del main vaya del main1 al main2
             */
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity
                        .this, MainActivity2.class);
                startActivity(intent);
            }
        });

    }
    // *** MENU CONTEXTUAL ***

    //    inflamos el menu contextual con los items del menu xml correspondiente
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_context, menu);

    }

    //    creamos una lista de eventos para los items del menus contextual
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.camera:
                Toast toast = Toast.makeText(this, "EDITANDO....", Toast.LENGTH_LONG);
                toast.show();
                //Intent intent = new Intent(MainActivity.this, ScrollingActivity.class);
                //startActivity(intent);
                break;
            case R.id.action_settings:
                Toast toast2 = Toast.makeText(this, "BORRANDO....", Toast.LENGTH_LONG);
                toast2.show();
                // Intent intent2 = new Intent(MainActivity.this, AnyChartActivity.class);
                //startActivity(intent2);
                break;
        }
        return super.onContextItemSelected(item);
    }


    public void openScrolling(View view) {
        //Intent buttonintent = new Intent(this, ScrollingActivity.class);
        //startActivity(buttonintent);
    }

    // *** MENU APPBAR ***

    //    inflamos el menu del AppBar con los items del recurso xml
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_appbar, menu);
        return true;
    }

    //    creamos una lista de eventos para los items del menu del AppBar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Toast toast = Toast.makeText(this, "DELETING", Toast.LENGTH_LONG);
            toast.show();
            showAlertDialogButtonClicked(MainActivity.this);

        } else if (id == R.id.camera) {
            Toast toast = Toast.makeText(this, "EDITING", Toast.LENGTH_LONG);
            toast.show();
            // Intent intent = new Intent(MainActivity.this, ScrollingActivity.class);

            //showAlertDialogButtonClicked(MainActivity.this);

        }

        return super.onOptionsItemSelected(item);
    }
//****Desliza para abajo***
    protected SwipeRefreshLayout.OnRefreshListener
            mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            //Toast toast0 = Toast.makeText(MainActivity.this, "going swipeREFRESH", Toast.LENGTH_LONG);
            //toast0.show();
            //swipeLayout.setRefreshing(false);
            //   opción SNACKBAR

//           SUSTITUIR POR CONSTRAINT EN SU CASO
            final ConstraintLayout mLayout = (ConstraintLayout) findViewById(R.id.activity_main);
//            final RelativeLayout mLayout = (RelativeLayout) findViewById(R.id.activity_main_context);

            Snackbar snackbar = Snackbar
                    .make(mLayout, "fancy a Snack while you refresh?", Snackbar.LENGTH_LONG)
                    .setAction("UNDO", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Snackbar snackbar1 = Snackbar.make(mLayout, "Action is restored!", Snackbar.LENGTH_SHORT);
                            snackbar1.show();
                        }
                    });

            snackbar.show();
            swipeLayout.setRefreshing(false);

        }
    };

    //***** tarjeta que sale en el appbar settings ******
    public void showAlertDialogButtonClicked(MainActivity view) {
        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //el dialogo estandar tiene título/icono pero podemos sustituirlo por un XML a medida
        // builder.setTitle("Achtung!");
        // builder.setMessage("Where do you go?");
        // builder.setIcon(R.drawable.ic_action_name_dark);
        // un XML a medida para el diálogo

        builder.setView(getLayoutInflater().inflate(R.layout.alertdialog_view,
                null));
        // add the buttons
        builder.setPositiveButton("Glide", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // do something like...
                        dialog.dismiss();
                    }
                });
        builder.setNegativeButton("ChatBot", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // do something like...
                        dialog.dismiss();
                    }
                });

        builder.setNeutralButton("MotionLayout", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // do something like...
                        dialog.dismiss();
                    }
                });
        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

}