package es.cruzalosdedos.fernandopalacios.StreamSound.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
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
    private ArrayList<ModelFriend> myFriends;
    private int itemLayout;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    // lase que comparten todos los items de Recycleview
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
