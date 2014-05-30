package es.energysistem.start;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

import java.util.Locale;

/**
 * Created by age on 09/04/2014.
 */
public class FragmentManual extends Fragment {

    private enum Idioma {
        es, fr, pt, en;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        //return inflater.inflate(R.layout.fragment_manual,container, false);
        View v=  inflater.inflate(R.layout.fragment_manual,container, false);

        WebView webView = (WebView)v.findViewById(R.id.webView);
        // Enable JavaScript
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());
        //Toast.makeText(this, Locale.getDefault().getLanguage().toString(), Toast.LENGTH_SHORT).show();

        try {
            Idioma idioma = Idioma.valueOf(Locale.getDefault().getLanguage());
            //Toast.makeText(this, idioma.toString(), Toast.LENGTH_SHORT).show();
            //Toast.makeText(this,Locale.getDefault().getCountry(), Toast.LENGTH_SHORT).show();

            switch (idioma) {
                case es:
                    webView.loadUrl("http://www.energysistem.com/guide/39594");
                    break;
                case en:
                    webView.loadUrl("http://www.energysistem.com/en/guide/39594");
                    break;
                case pt:
                    webView.loadUrl("http://www.energysistem.com/pt/guide/39594");
                    break;
                case fr:
                    webView.loadUrl("http://www.energysistem.com/fr/guide/39594");
                    break;

                default:
                    webView.loadUrl("http://www.energysistem.com/en/guide/39594");
                    break;
            }
        } catch (Exception error) {
            webView.clearCache(true);
            webView.loadUrl("http://www.energysistem.com/en/guide/39594");
        }


        return v;
    }





}
