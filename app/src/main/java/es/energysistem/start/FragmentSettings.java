package es.energysistem.start;


import android.os.Bundle;

import android.preference.PreferenceFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class FragmentSettings extends PreferenceFragment {


    @Override
    public void onCreate(Bundle saveInstanceState)
    {
        super.onCreate(saveInstanceState);
        addPreferencesFromResource(R.xml.settings);
    }

}
