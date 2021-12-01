package com.example.num1;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBar1;
    MediaPlayer mPlayer;
    ImageButton btnPlay, btnStop;

    int pos;
    boolean Playing = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar1 = (SeekBar)findViewById(R.id.SeekBar1);
        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if(seekBar.getMax()==i){
                    btnStop.setVisibility(View.INVISIBLE);
                    btnPlay.setVisibility(View.VISIBLE);
                    Playing = false;
                    mPlayer.stop();
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Playing = false;
                mPlayer.pause();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Playing = true;
                int move = seekBar.getProgress();
                mPlayer.seekTo(move);
                mPlayer.start();
                new Thread1().start();
            }
        });


        mPlayer = new MediaPlayer();
        mPlayer = MediaPlayer.create(this,R.raw.sample0);

        btnPlay = (ImageButton)findViewById(R.id.Play);
        btnStop = (ImageButton)findViewById(R.id.Stop);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mPlayer = MediaPlayer.create(
                        getApplicationContext(),
                        R.raw.sample0);
                mPlayer.setLooping(false);
                mPlayer.start();

                int a = mPlayer.getDuration();
                seekBar1.setMax(a);
                new Thread1().start();
                Playing = true;

                btnPlay.setVisibility(View.INVISIBLE);
                btnStop.setVisibility(View.VISIBLE);
            }
        });


        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pos = mPlayer.getCurrentPosition();
                mPlayer.pause();
                btnStop.setVisibility(View.INVISIBLE);
                btnPlay.setVisibility(View.VISIBLE);
                Playing = false;
            }
        });


    }

    class Thread1 extends Thread {
        @Override
        public void run(){

            while (Playing){
                seekBar1.setProgress(mPlayer.getCurrentPosition());
            }
        }
    }




}