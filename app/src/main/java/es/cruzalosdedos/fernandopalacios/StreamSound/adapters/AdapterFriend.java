package es.cruzalosdedos.fernandopalacios.StreamSound.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

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
    // carga la vista de cardViews de manera dinamica
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from( viewGroup.getContext() ).inflate( itemLayout, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    // configuracion de RecycleView : pasar la información del Dataset a sus respectivos lugares en el ItemLayout.
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        ModelFriend friendBinded = myFriend.get(i); // obtener la carta seleccionada
        viewHolder.nameFriend.setText( friendBinded.getName() );
        viewHolder.twitterFriend.setText(friendBinded.getTwitter());
        viewHolder.lastSongFriend.setText(friendBinded.getLastSong());
        viewHolder.itemView.setTag(friendBinded);
    }

    @Override
    // cantidad de elemetos CardView inflados por onCreateViewHolder
    public int getItemCount() {
        return myFriend.size();
    }

    // Crear una vista de caratas, esta clase la comparten todos los items de Recycleview
    public static class ViewHolder extends RecyclerView.ViewHolder implements AdapterView.OnClickListener{
        
        // declaramos los elementos de la vista de cartas
        public TextView nameFriend;
        public TextView twitterFriend;
        public TextView lastSongFriend;
        
        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            nameFriend = (TextView) itemView.findViewById(R.id.name_friend);
            twitterFriend = (TextView) itemView.findViewById(R.id.twitter_friend);
            lastSongFriend = (TextView) itemView.findViewById(R.id.last_song_friend);
        }

        @Override
        public void onClick(View view) {
            String twitterFriend = ( (TextView) view.findViewById( R.id.twitter_friend)).getText().toString();
            String songFriend = ( (TextView) view.findViewById( R.id.last_song_friend)).getText().toString();
            String toastText = "From "+twitterFriend+" : "+songFriend;
            Toast.makeText( view.getContext(), toastText, Toast.LENGTH_SHORT).show();
        }
    }
}
