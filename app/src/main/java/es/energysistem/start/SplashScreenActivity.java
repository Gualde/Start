package es.energysistem.start;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;

import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by Adrián. on 19/11/13.
 */
public class SplashScreenActivity extends Activity {

    // Set the duration of the splash screen
    private static final long SPLASH_SCREEN_DELAY = 6000;
    private SharedPreferences prefs;
    boolean primera_vez;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            //Me espero unos segundos a que acabe de encenderse el tablet
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.splash_screen);

        //Comprueba si es la primera vez que se abre la apliación
        prefs= getSharedPreferences("PreferenciasStart", Context.MODE_PRIVATE);
        primera_vez = prefs.getBoolean("primera_vez", true);


        TimerTask task = new TimerTask() {
            @Override
            public void run() {


                //primera_vez=false;
                // Start the next activity
                //si es la primera vez, se habre el login
                if(primera_vez==true)
                {
                    Intent mainIntent = new Intent().setClass(SplashScreenActivity.this, MainActivity.class);
                    startActivity(mainIntent);
                }//si no es la primera vez abro directamente la pagina principal de start.
                else

                {
                    Intent mainIntent = new Intent().setClass(SplashScreenActivity.this, Start.class);
                    startActivity(mainIntent);
                }

                // Close the activity so the user won't able to go back this
                // activity pressing Back button
                finish();
            }
        };

        // Simulate a long loading process on application startup.
        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);
    }


}
