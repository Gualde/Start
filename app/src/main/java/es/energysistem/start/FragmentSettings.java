package es.energysistem.start;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.preference.PreferenceFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class FragmentSettings extends Activity {


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_settings,container, false);



    }
}

