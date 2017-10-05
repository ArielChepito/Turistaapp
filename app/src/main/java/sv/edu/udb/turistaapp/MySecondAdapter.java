package sv.edu.udb.turistaapp;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by chepito on 10-05-17.
 */

public class MySecondAdapter  extends RecyclerView.Adapter<MySecondAdapter.ViewHolder>{

    private List<Sitio> Sitios;
    private int layout;
    private MySecondAdapter.onItemClickListener listener;

    public MySecondAdapter(List<Sitio> Sitios, int layout, MySecondAdapter.onItemClickListener listener) {
        this.Sitios = Sitios;
        this.layout = layout;
        this.listener = listener;
    }

    @Override
    public MySecondAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //inlfamos el layout y le pasamos lso datos al constructor del view holder
        View v = LayoutInflater.from(parent.getContext()).inflate(layout,parent,false);
        MySecondAdapter.ViewHolder vh = new MySecondAdapter.ViewHolder(v,parent);
        return vh;
    }

    @Override
    public void onBindViewHolder(MySecondAdapter.ViewHolder holder, int position) {

        //llamamos al metodo bind del viewholder pasandole el objdeto y un listener
        holder.bind(Sitios.get(position), listener);

    }

    @Override
    public int getItemCount() {
        return Sitios.size();
    }

    public static class ViewHolder extends  RecyclerView.ViewHolder{
        //Elementos UI a rellenar
        public TextView textViewSitio;
        public TextView textViewSitioDes;
        public ImageView imageViewSitio;
        LinearLayout myLinearLayout;
        ViewGroup Parent;

        public ViewHolder(View v,ViewGroup parent){

            //recibe la vista completa para que la rendericemos, pasamos parametros a constructor padre
            // aqui tambien manejamos los datos de logioca para extraer datos y hacer referencias con los elementoss
            super(v);
            Parent = parent;

            this.textViewSitio =(TextView) v.findViewById(R.id.txtTituloInfo);
            this.imageViewSitio = (ImageView) v.findViewById(R.id.imageViewInfo);
            myLinearLayout = (LinearLayout) v.findViewById(R.id.panelLoginInfo);
            textViewSitioDes = (TextView) v.findViewById(R.id.txtDescripcionInfo);
        }

        public void bind(final Sitio Sitio, final MySecondAdapter.onItemClickListener listener){
            //procesamos los datos para renderizar
            textViewSitio.setText(Sitio.getName());
            textViewSitioDes.setText(Sitio.getDescripcion());

            int[] colors = new int[2];
            colors[1] = 0xf9E9E9E;
            colors[0] = getMatColor("400", Parent.getContext());
            GradientDrawable gd = new GradientDrawable(
                    GradientDrawable.Orientation.RIGHT_LEFT, colors);
            gd.setGradientType(GradientDrawable.LINEAR_GRADIENT);
            myLinearLayout.setBackground(gd);


            Picasso.with(Parent.getContext()).load(Sitio.getimagen()).resize(240*8, 120*8).into(imageViewSitio);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(Sitio, getAdapterPosition());
                }
            });

        }

    }
    ///declaramos las interfaces con los metodos a implementar
    public interface onItemClickListener{
        void onItemClick(Sitio Sitio, int position);
    }


    private static int getMatColor(String typeColor, Context contexto)
    {
        int returnColor = Color.BLACK;
        int arrayId = contexto.getResources().getIdentifier("mdcolor_" + typeColor, "array", contexto.getApplicationContext().getPackageName());

        if (arrayId != 0)
        {
            TypedArray colors = contexto.getResources().obtainTypedArray(arrayId);
            int index = (int) (Math.random() * colors.length());
            returnColor = colors.getColor(index, Color.BLACK);
            colors.recycle();
        }
        return returnColor;
    }


}
