package es.energysistem.start;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;


public class Start extends ActionBarActivity {

    private String[] opcionesMenu;
    private DrawerLayout drawerLayout;
    private ListView drawerList;
    private ActionBarDrawerToggle drawerToggle;
    private CharSequence tituloSeccion;
    private CharSequence tituloApp;
    private SharedPreferences prefs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        opcionesMenu = new String[]{};
        opcionesMenu =  getResources().getStringArray(R.array.menus);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerList = (ListView) findViewById(R.id.left_drawer);

        drawerList.setAdapter(new ArrayAdapter<String>(
                getSupportActionBar().getThemedContext(),
                android.R.layout.simple_list_item_1, opcionesMenu));
        prefs= getSharedPreferences("PreferenciasStart", Context.MODE_PRIVATE);



        drawerList.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Fragment fragment = null;
                Log.e("LogDebug", String.valueOf(position));
                switch (position) {
                    case 0:
                        fragment = new FragmentClub();
                        break;
                    case 1:
                        fragment = new FragmentForo();
                        break;
                    case 2:
                        fragment = new FragmentManual();
                        break;
                    case 5:
                        Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
                        startActivity(intent);
                        break;
                }
                if (position==5)
                    return;
                FragmentManager fragmentManager =
                        getSupportFragmentManager();

                fragmentManager.beginTransaction()
                        .replace(R.id.content_frame, fragment)
                        .commit();

                drawerList.setItemChecked(position, true);
                tituloSeccion = opcionesMenu[position];
                getSupportActionBar().setTitle(tituloSeccion);
                drawerLayout.closeDrawer(drawerList);

                //arranca servicio de ubicación
                //Log.e("LogDebug", "Llamo a arrancar el servicio");

                if(prefs.getBoolean("permitir_ubicacion", false))
                {
                    Log.e("LogDebug", "Llamo a arrancar el servicio");
                    arrancarServicio();
                }
                else
                {
                    Log.e("LogDebug", "No arranco el servicio");

                }
                //
                // arrancarServicio();
            }
        });


        tituloSeccion = getTitle();
        tituloApp = getTitle();

        drawerToggle = new ActionBarDrawerToggle(this,
                drawerLayout,
                R.drawable.ic_navigation_drawer,
                R.string.drawer_open,
                R.string.drawer_close) {

            public void onDrawerClosed(View view) {
                getSupportActionBar().setTitle(tituloSeccion);
                ActivityCompat.invalidateOptionsMenu(Start.this);

            }

            public void onDrawerOpened(View drawerView) {
                getSupportActionBar().setTitle(tituloApp);
                ActivityCompat.invalidateOptionsMenu(Start.this);
            }
        };

        drawerLayout.setDrawerListener(drawerToggle);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }


        return true;
    }


    private void arrancarServicio()
    {
        //Comprueba si el usuario quiere compartir la ubic
        Intent i = new Intent(this, UbicationService.class);
        startService(i);
    }



    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        boolean menuAbierto = drawerLayout.isDrawerOpen(drawerList);

        if(menuAbierto)
            menu.findItem(R.id.action_search).setVisible(false);
        else
            menu.findItem(R.id.action_search).setVisible(true);

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

}