package com.example.a20211109_practice1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    DatePicker date_Pick;
    EditText edit;
    Button btn;
    String fileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("간단 일기장");

        date_Pick = (DatePicker) findViewById(R.id.Date_Pick);
        edit = (EditText) findViewById(R.id.Edit);
        btn = (Button) findViewById(R.id.Btn);

        Calendar cal = Calendar.getInstance();
        int cYear = cal.get(Calendar.YEAR);
        int cMonth = cal.get(Calendar.MONTH);
        int cDay = cal.get(Calendar.DAY_OF_MONTH);

        date_Pick.init(cYear, cMonth, cDay, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                fileName = Integer.toString(year) + "_"
                        + Integer.toString(monthOfYear + 1) + "_"
                        + Integer.toString(dayOfMonth) + ".txt";
                String str = readDiary(fileName);
                edit.setText(str);
                btn.setEnabled(true);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    FileOutputStream outFs = openFileOutput(fileName, Context.MODE_PRIVATE);
                    String str = edit.getText().toString();
                    outFs.write(str.getBytes());
                    outFs.close();
                    Toast.makeText(getApplicationContext(), fileName + " 이 저장됨", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                }
            }

        });
    }
    public String readDiary(String fName){
        String diaryStr = null;
        FileInputStream inFs;
        try {
            inFs = openFileInput(fName);
            byte[] txt = new byte[500];
            inFs.read(txt);
            inFs.close();
            diaryStr = (new String(txt)).trim();
            btn.setText("수정하기");
        } catch (IOException e){
            edit.setHint("일기 없음");
            btn.setText("새로 저장");
        }
        return  diaryStr;
    }
}


