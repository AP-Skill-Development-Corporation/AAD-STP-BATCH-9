package com.example.cherry.exampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Declare all the views here
    Button toast,count;
    TextView tv;
    int c=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Instantiate all the views after the declaration
        toast = findViewById(R.id.toast);
        count = findViewById(R.id.count);
        tv = findViewById(R.id.tv);
        count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c++;
                tv.setText(""+c);
                //tv.setText(String.valueOf(c));
            }
        });
        toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Welcome to Android "+c,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}