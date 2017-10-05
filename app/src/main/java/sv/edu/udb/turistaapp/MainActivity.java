package sv.edu.udb.turistaapp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {




    private List<Sitio> Sitios;
    private RecyclerView myReclyclerView;
    private RecyclerView.Adapter myAdapter;
    private RecyclerView.LayoutManager myLayoutManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try{
            Sitios= this.getAllSitios();
            myReclyclerView = (RecyclerView) findViewById(R.id.My_recycler_view);
            myAdapter = new MyAdapter(Sitios, R.layout.menu_item,new MyAdapter.onItemClickListener(){
                @Override
                public void onItemClick(Sitio sitio, int position) {

                    Main2Activity.sitio = sitio;
                    //Toast.makeText(MainActivity.this, sitio.getName(), Toast.LENGTH_LONG).show();
                    Intent i = new Intent(MainActivity.this, Main2Activity.class );
                    startActivity(i);
                }
            });
            //todos los tipos de layout manager con los que se puede jugar con el recycler view
            myLayoutManager = new LinearLayoutManager(this);
            //myLayoutManager = new GridLayoutManager(this,2);
            // myLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
            //solo en caso que sepamos que el tamaño del layout no va a cambiar ahrehgamos esto e incrementa el rendimiento, aunque de nada sirve con el StraggeredGridLayout porque cambia los tamaños
            myReclyclerView.setHasFixedSize(true);
            //animacion por defecto
            myReclyclerView.setItemAnimator(new DefaultItemAnimator());

            myReclyclerView.setLayoutManager(myLayoutManager);
            myReclyclerView.setAdapter(myAdapter);
        }catch(Exception e)
        {
            System.out.println("nose :" + e.getMessage());
        }

    }

    private List<Sitio> getAllSitios(){




        return new ArrayList<Sitio>(){{
            add(new Sitio("EL SALVADOR TRAVEL",R.drawable.fondo, "123"));
            add(new Sitio("Joya de ceren",R.drawable.joyaceren, Sitio.JOYACEREN));
            add(new Sitio("Cihuatan",R.drawable.piramidecihuatan, Sitio.CIHUATAN));
            add(new Sitio("Casa Blanca",R.drawable.casablanca, Sitio.CASABLANCA ));
            add(new Sitio("San Andres",R.drawable.sanandres, Sitio.SANANDRES));
            add(new Sitio("Tazumal",R.drawable.tazumal06, Sitio.TAZUMAL));


        }};
    }
}
