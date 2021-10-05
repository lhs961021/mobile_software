package com.example.a20211005_practice2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView Text1, Text2;
    CheckBox yes;
    RadioGroup rGroup;
    RadioButton RdoDog,RdoCat,RdoRabbit;
    Button submit;
    ImageView ImgPet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("애완동물 사진보기");

        Text1 = (TextView) findViewById(R.id.Text1);
        Text2 = (TextView) findViewById(R.id.Text2);
        yes = (CheckBox) findViewById(R.id.yes);
        rGroup = (RadioGroup) findViewById(R.id.rGroup);
        RdoDog = (RadioButton) findViewById(R.id.RdoDog);
        RdoCat = (RadioButton) findViewById(R.id.RdoCat);
        RdoRabbit = (RadioButton) findViewById(R.id.RdoRabbit);
        submit = (Button) findViewById(R.id.submit);
        ImgPet = (ImageView) findViewById(R.id.ImgPet);

        yes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(yes.isChecked()==true) {
                    Text2.setVisibility(View.VISIBLE);
                    rGroup.setVisibility(View.VISIBLE);
                    yes.setVisibility(View.VISIBLE);
                    submit.setVisibility(View.VISIBLE);
                    ImgPet.setVisibility(View.VISIBLE);
                } else {
                    Text2.setVisibility(View.INVISIBLE);
                    rGroup.setVisibility(View.INVISIBLE);
                    yes.setVisibility(View.INVISIBLE);
                    submit.setVisibility(View.INVISIBLE);
                    ImgPet.setVisibility(View.INVISIBLE);
                }
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (rGroup.getCheckedRadioButtonId()){
                    case R.id.RdoDog:
                        ImgPet.setImageResource(R.drawable.dog);
                        break;
                    case R.id.RdoCat:
                        ImgPet.setImageResource(R.drawable.cat);
                        break;
                    case R.id.RdoRabbit:
                        ImgPet.setImageResource(R.drawable.rabbit);
                        break;
                    default:
                        System.out.println("동물을 선택하세요");
                }
            }
        });




    }
}