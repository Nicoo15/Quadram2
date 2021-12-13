package com.example.quadram.recyclerfree;

import android.content.Context;
import android.util.Log;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.quadram.R;
import com.example.quadram.ui.topfree.TopfreeFragment;

import org.w3c.dom.Text;

import java.util.List;
import java.util.zip.Inflater;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private  Context mContext;
    private List<aplicacion> lista;

    public Adapter(Context mContext, List<aplicacion> lista) {
        this.mContext = mContext;
        this.lista = lista;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View v ;
        LayoutInflater layoutInflater= LayoutInflater.from(mContext);
        v = layoutInflater.inflate(R.layout.card_view, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


        holder.artist.setText(lista.get(position).getArtist());
        holder.price.setText(lista.get(position).getPrice());
        holder.name.setText(lista.get(position).getName());
        Glide.with(mContext)
                .load(lista.get(position).getImage())
                .into(holder.imagen);
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        TextView artist;
        TextView price;
        ImageView imagen;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.title_app);
            artist = itemView.findViewById(R.id.autor);
            price = itemView.findViewById(R.id.price);
            imagen= itemView.findViewById(R.id.image);



        }
    }

}


