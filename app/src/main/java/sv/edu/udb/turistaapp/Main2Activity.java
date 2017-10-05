package sv.edu.udb.turistaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity implements Serializable {

    private int counter = 0;
    private List<Sitio> Sitios =  new ArrayList<>();;
    private RecyclerView myReclyclerView;
    private RecyclerView.Adapter MySecondAdapter;
    private RecyclerView.LayoutManager myLayoutManager;
    static Sitio sitio;


    public    void change()
    {
        TextView textViewCAMBIAR = (TextView) findViewById(R.id.textViewCAMBIAR);
        if(Sitio.LAN)
        {
            textViewCAMBIAR.setText("IDIOMA ACTUAL ESPAÑOL");

        }
        else
        {

            textViewCAMBIAR.setText("THE CURRENT LANGUAGE IS ENGLISH");
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if(sitio.getDescripcion().equals("123"))
        {

            setContentView(R.layout.activity_main3);
            change();
            Button boton = (Button) findViewById(R.id.buttonCAMBIAR);
            boton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Sitio.LAN = !Sitio.LAN;
                    Sitio.change();
                    TextView textViewCAMBIAR = (TextView) findViewById(R.id.textViewCAMBIAR);
                    if(Sitio.LAN)
                    {
                        textViewCAMBIAR.setText("IDIOMA ACTUAL ESPAÑOL");

                    }
                    else
                    {

                        textViewCAMBIAR.setText("THE CURRENT LANGUAGE IS ENGLISH");
                    }

                    Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <- Aquí :)
                    startActivity(intent);
                    finish();

                }
            });
            change();





        }
        else
        {
            setContentView(R.layout.activity_main2);
            try{


                //Toast.makeText(this, sitio.getName(), Toast.LENGTH_LONG).show();

                Sitios.add(sitio);
                myReclyclerView = (RecyclerView) findViewById(R.id.My_recycler_view_info);
                MySecondAdapter = new MySecondAdapter(Sitios, R.layout.info_item,new MySecondAdapter.onItemClickListener(){
                    @Override
                    public void onItemClick(Sitio Sitio, int position) {


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
                myReclyclerView.setAdapter(MySecondAdapter);
            }catch(Exception e)
            {
                System.out.println("nose :" + e.getMessage());
            }

        }




    }


}
