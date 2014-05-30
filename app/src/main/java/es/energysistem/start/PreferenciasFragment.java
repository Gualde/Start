package es.energysistem.start;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceFragment;




/**
 * Created by administrador on 02/05/2014.
 */
public class PreferenciasFragment extends PreferenceFragment {

    private SharedPreferences prefs;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        this.getPreferenceManager().setSharedPreferencesName("PreferenciasStart");

        addPreferencesFromResource(R.xml.settings);



    }

}
