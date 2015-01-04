package es.cruzalosdedos.fernandopalacios.StreamSound.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

import es.cruzalosdedos.fernandopalacios.StreamSound.R;
import es.cruzalosdedos.fernandopalacios.StreamSound.models.ModelSong;

/**
 * Created by Fernando Palacios on 04/01/2015.
 */
public class SongAdapter extends RecyclerView.Adapter<SongAdapter.ViewHolder>{
    
    // DATASET MODEL TO SONGS
    ArrayList<ModelSong> modelSongs;
    int itemLayout;

    public SongAdapter(ArrayList<ModelSong> modelSongs, int itemLayout) {
        this.modelSongs = modelSongs;
        this.itemLayout = itemLayout;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from( parent.getContext() ).inflate( itemLayout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ModelSong modelSongBinded = modelSongs.get(position);
        holder.nameSong.setText(modelSongBinded.getSongName());
        holder.nameArtist.setText(modelSongBinded.getSongArtist());
        holder.stars.setNumStars( modelSongBinded.getStars() );
    }

    @Override
    public int getItemCount() {
        return modelSongs.size();
    }
    
    public static class ViewHolder extends RecyclerView.ViewHolder{
        
        TextView nameSong;
        TextView nameArtist;
        RatingBar stars;
        
        public ViewHolder(View itemView) {
            super(itemView);
            nameSong = (TextView) itemView.findViewById( R.id.name_song );
            nameArtist = (TextView) itemView.findViewById( R.id.name_artist );
            stars = (RatingBar) itemView.findViewById( R.id.ratingBar );
        }
    }
}
