package com.example.practice08;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edit1;
    Button btn1,btn2;
    WebView webv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit1 = (EditText)findViewById(R.id.Edit1);
        btn1 = (Button)findViewById(R.id.Btn1);
        btn2 = (Button)findViewById(R.id.Btn2);
        webv = (WebView)findViewById(R.id.Webv);

        WebSettings webset = webv.getSettings();
        webset.setBuiltInZoomControls(true);
        webset.setJavaScriptEnabled(true);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webv.loadUrl(edit1.getText().toString());
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webv.goBack();
            }
        });

    }

    class CookWebViewClient extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return super.shouldOverrideUrlLoading(view, url);
        }
    }
}