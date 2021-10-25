package com.example.practice07;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    Button btnPrev,btnNext;
    ViewFlipper viewFli;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPrev = (Button)findViewById(R.id.BtnPrev);
        btnNext = (Button)findViewById(R.id.BtnNext);
        viewFli = (ViewFlipper)findViewById(R.id.ViewFli);

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewFli.showPrevious();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewFli.showNext();
            }
        });
        
    }
}