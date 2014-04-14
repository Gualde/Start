package es.energysistem.start;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebStorage;
import android.webkit.WebView;

/**
 * Created by age on 09/04/2014.
 */
public class FragmentForo extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        //WebView webView =(WebView)getView().findViewById(R.id.webView);

        View V = inflater.inflate(R.layout.fragment_foro, container, false);
        WebView webView = (WebView)V.findViewById(R.id.webView2);
        WebSettings webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl("http://forum.energysistem.com/");

        //return inflater.inflate(R.layout.fragment_foro,container, false);
        return V;




    }
}
