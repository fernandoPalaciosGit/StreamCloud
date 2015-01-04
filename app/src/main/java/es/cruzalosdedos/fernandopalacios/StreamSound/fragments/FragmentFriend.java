package es.cruzalosdedos.fernandopalacios.StreamSound.fragments;

import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import es.cruzalosdedos.fernandopalacios.StreamSound.R;
import es.cruzalosdedos.fernandopalacios.StreamSound.adapters.AdapterFriend;
import es.cruzalosdedos.fernandopalacios.StreamSound.models.ModelFriend;

public class FragmentFriend extends Fragment {

    public FragmentFriend() {
        
    }

    @Override
    // asignar la vista del fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_friends, container, false);
    }
    
    // cargar componentes a la vista a traves del adapter
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        
        // DATASET QUE RECIBIRA EL ADAPTER
        ArrayList<ModelFriend> myFriends = new ArrayList<ModelFriend>();
        
        // create estatic data friends : DATASET
        ModelFriend nando = new ModelFriend();
        nando.setLastSong("Yeke Yeke");
        nando.setName("Fernando Palacios Landi");
        nando.setTwitter("@nandoPalandi");
        myFriends.add(nando);

        ModelFriend mario = new ModelFriend();
        mario.setLastSong("twiglight");
        mario.setName("Mario Palacios Landi");
        mario.setTwitter("@mariupa");
        myFriends.add(mario);

        ModelFriend mario2 = new ModelFriend();
        mario2.setLastSong("twiglight");
        mario2.setName("Mario Palacios Landi");
        mario2.setTwitter("@mariupa");
        myFriends.add(mario2);

        ModelFriend nando2 = new ModelFriend();
        nando2.setLastSong("Yeke Yeke");
        nando2.setName("Fernando Palacios Landi");
        nando2.setTwitter("@nandoPalandi");
        myFriends.add(nando2);

        ModelFriend mario3 = new ModelFriend();
        mario3.setLastSong("twiglight");
        mario3.setName("Mario Palacios Landi");
        mario3.setTwitter("@mariupa");
        myFriends.add(mario3);

        ModelFriend nando3 = new ModelFriend();
        nando3.setLastSong("Yeke Yeke");
        nando3.setName("Fernando Palacios Landi");
        nando3.setTwitter("@nandoPalandi");
        myFriends.add(nando3);

        RecyclerView recyclerView = (RecyclerView) getActivity().findViewById( R.id.friend_recycleview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter( new AdapterFriend( myFriends, R.layout.recycleview_friends) );
        recyclerView.setLayoutManager( new LinearLayoutManager( getActivity() ));
        recyclerView.setItemAnimator( new DefaultItemAnimator() );
    }
}