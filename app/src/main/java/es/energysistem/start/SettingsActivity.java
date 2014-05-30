package es.energysistem.start;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;



public class SettingsActivity extends FragmentActivity {

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction().replace(android.R.id.content, new PreferenciasFragment(){
        }).commit();
    }

}

