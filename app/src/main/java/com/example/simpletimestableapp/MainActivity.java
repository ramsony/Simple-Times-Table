package com.example.simpletimestableapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView tbListView;
    public void generateTimesTable(int tbNumber){
        ArrayList<String> tbContent = new ArrayList<String>();

        for(int i = 1; i<= 100; i++) tbContent.add(Integer.toString(i * tbNumber));

        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,tbContent);
        tbListView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar tbSeekBar = findViewById(R.id.tbSeekBar);
        tbListView = findViewById(R.id.tbListView);
        int max = 20;
        int startingPosition = 10;
        tbSeekBar.setMax(max);
        tbSeekBar.setProgress(startingPosition);

        generateTimesTable(startingPosition);

        tbSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                int tbNumber;

                if(progress < min){
                    tbNumber = min;
                    tbSeekBar.setProgress(min);
                }else{
                    tbNumber = progress;
                }
                Log.i("SeekBar value: ", Integer.toString(tbNumber));
                generateTimesTable(tbNumber);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
