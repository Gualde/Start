package es.energysistem.start;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by age on 09/04/2014.
 */
public class FragmentClub extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        return inflater.inflate(R.layout.fragment_club,container, false);

    }
}
