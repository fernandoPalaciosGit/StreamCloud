package es.cruzalosdedos.fernandopalacios.StreamSound.fragments;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import es.cruzalosdedos.fernandopalacios.StreamSound.R;

public class Amigos extends Fragment {

    public Amigos() {
        
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        
        return inflater.inflate(R.layout.fragment_amigos, container, false);
    }

}