package com.example.quadram;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapter  extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private Context mContext;
    private ArrayList<aplicacion> mLista;

    public Adapter (Context context, ArrayList<aplicacion> lista){
        mContext = context;
        mLista = lista;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.card_view,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        aplicacion actual = mLista.get(position);

        String urlImg = actual.getImgpost();
        String app = actual.getAppname();
        String autor = actual.getAutor();
        String precio = actual.getPrice();

        holder.appname.setText(app);
        holder.autor.setText("Autor :"+autor);
        holder.price.setText(precio);
        Picasso.with(mContext).load(urlImg).fit().centerInside().into(holder.mImagen);


    }

    @Override
    public int getItemCount() {
        return mLista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView mImagen;
        public TextView appname;
        public TextView autor;
        public TextView price;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mImagen = itemView.findViewById(R.id.imgPost);
            appname = itemView.findViewById(R.id.title_app);
            autor = itemView.findViewById(R.id.id_autor);
            price = itemView.findViewById(R.id.id_price);
        }
    }
}
