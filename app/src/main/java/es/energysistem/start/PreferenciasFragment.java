package es.energysistem.start;

import android.os.Bundle;
import android.preference.PreferenceFragment;




/**
 * Created by administrador on 02/05/2014.
 */
public class PreferenciasFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings);

    }

}
