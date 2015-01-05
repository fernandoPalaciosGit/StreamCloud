package es.cruzalosdedos.fernandopalacios.StreamSound.fragments;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import es.cruzalosdedos.fernandopalacios.StreamSound.R;
import es.cruzalosdedos.fernandopalacios.StreamSound.adapters.SongAdapter;
import es.cruzalosdedos.fernandopalacios.StreamSound.models.ModelSong;

public class FragmentSong extends Fragment {
    // DATASET SONGS : volley Api
    private ArrayList<ModelSong> mySongs;
    private View activityRoot;
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        
        // Inflate the layout for this fragment
        activityRoot = inflater.inflate(R.layout.fragment_destacados, container, false);
        recyclerView = (RecyclerView) activityRoot.findViewById( R.id.songs_recycleview);
        recyclerView.setLayoutManager(  new LinearLayoutManager( getActivity() ) );
        
        return activityRoot;
    }
    
    
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
           
        // API HTTP DATA (VOLLEY)
        String URL = "https://script.google.com/macros/s/AKfycbxYMVeK_mfrW0vZs7z6BsrHLSuFcB8H4L7bcYaoqo4AumyXOdw/exec";
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        final ProgressDialog progressWidget = ProgressDialog.show(getActivity(),"Espere por favor","estamos atendiendo su solocitud");
           
        // On success API request
        JsonArrayRequest req = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                // Log.i("Success Volley", response.toString());
                try {
                    mySongs = parserApiSongs( response );
                    loadApiSongs(mySongs);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                progressWidget.cancel();
            }
            
        // On Error API request
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error Volley", error.toString());
                progressWidget.cancel();
            }
        });
        
        queue.add(req);
    }

    private void loadApiSongs(ArrayList<ModelSong> mySongs) {
        recyclerView.setItemAnimator( new DefaultItemAnimator() );
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter( new SongAdapter( mySongs, R.layout.recycleview_songs) );
    }

    public ArrayList<ModelSong> parserApiSongs( JSONArray apiSongs ) throws JSONException{
        ArrayList<ModelSong> auxSongs = new ArrayList<ModelSong>();
        
        for (int i = 0, len = apiSongs.length(); i < len ; i++ ){
            ModelSong song = new ModelSong();
            JSONObject jsonObj = (JSONObject) apiSongs.get(i);

            song.setSongArtist( jsonObj.getString("cancion") );
            song.setSongName( jsonObj.getString("artista") );
            song.setStars( jsonObj.getInt("estrellas") );

            auxSongs.add(song);
        }
        
        return auxSongs;
    }
}
