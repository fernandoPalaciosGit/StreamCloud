package es.cruzalosdedos.fernandopalacios.StreamSound.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import es.cruzalosdedos.fernandopalacios.StreamSound.R;
import es.cruzalosdedos.fernandopalacios.StreamSound.adapters.AdapterFriend;
import es.cruzalosdedos.fernandopalacios.StreamSound.adapters.SongAdapter;
import es.cruzalosdedos.fernandopalacios.StreamSound.models.ModelFriend;
import es.cruzalosdedos.fernandopalacios.StreamSound.models.ModelSong;

public class FragmentSong extends Fragment {

    public FragmentSong() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_destacados, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayList<ModelSong> mySongs = new ArrayList<ModelSong>();
        
        // STATIC DATA
        ModelSong song1 = new ModelSong();
        song1.setSongArtist("Richie Hawtin");
        song1.setSongName("Loosing Control");
        song1.setStars( 3 );
        mySongs.add( song1 );
        
        RecyclerView recyclerView = (RecyclerView) getActivity().findViewById( R.id.songs_recycleview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter( new SongAdapter( mySongs, R.layout.recycleview_songs) );
        recyclerView.setLayoutManager( new LinearLayoutManager( getActivity() ));
        recyclerView.setItemAnimator( new DefaultItemAnimator() );
    }
}
