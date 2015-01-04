package es.cruzalosdedos.fernandopalacios.StreamSound.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import es.cruzalosdedos.fernandopalacios.StreamSound.R;

public class FragmentSong extends Fragment {

    public FragmentSong() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_destacados, container, false);
    }
}
