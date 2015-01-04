package es.cruzalosdedos.fernandopalacios.StreamSound.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import es.cruzalosdedos.fernandopalacios.StreamSound.models.Song;

/**
 * Created by Fernando Palacios on 04/01/2015.
 */
public class SongAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    
    // DATASET MODEL TO SONGS
    ArrayList<Song> songs;
    int itemLayout;

    public SongAdapter(ArrayList<Song> songs, int itemLayout) {
        this.songs = songs;
        this.itemLayout = itemLayout;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
    
    public class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
