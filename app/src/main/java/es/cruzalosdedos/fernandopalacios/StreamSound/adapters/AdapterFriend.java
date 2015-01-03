package es.cruzalosdedos.fernandopalacios.StreamSound.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import es.cruzalosdedos.fernandopalacios.StreamSound.R;
import es.cruzalosdedos.fernandopalacios.StreamSound.models.ModelFriend;

/**
 * Created by Fernando Palacios on 03/01/2015.
 */
public class AdapterFriend extends RecyclerView.Adapter<AdapterFriend.ViewHolder>{
    private ArrayList<ModelFriend> myFriend;
    private int itemLayout;
    
    public AdapterFriend( ArrayList<ModelFriend> myFriend, int itemLayout ){
        this.itemLayout = itemLayout;
        this.myFriend = myFriend;
    }
    
    @Override
    // como se carga la vista de cardViews de manera dinamica
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from( viewGroup.getContext() ).inflate( itemLayout, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    // configuracion de RecycleView
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        ModelFriend friendBinded = myFriend.get(i); // obtener la carta seleccionada
        viewHolder.nameFriend.setText( friendBinded.getName() );
        viewHolder.twitterFriend.setText( friendBinded.getTwitter() );
        viewHolder.lastSongFriend.setText( friendBinded.getLastSong() );
    }

    @Override
    // obtener el numero de cardViews de amigos
    public int getItemCount() {
        return myFriend.size();
    }

    // Crear una vista de caratas, esta clase la comparten todos los items de Recycleview
    public static class ViewHolder extends RecyclerView.ViewHolder{
        
        // declaramos los elementos de la vista de cartas
        public TextView nameFriend;
        public TextView twitterFriend;
        public TextView lastSongFriend;
        
        public ViewHolder(View itemView) {
            super(itemView);
            nameFriend = (TextView) itemView.findViewById(R.id.name_friend);
            twitterFriend = (TextView) itemView.findViewById(R.id.twitter_friend);
            lastSongFriend = (TextView) itemView.findViewById(R.id.last_song_friend);
            
        }
    }
}
