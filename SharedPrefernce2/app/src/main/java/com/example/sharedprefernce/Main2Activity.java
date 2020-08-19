package com.example.sharedprefernce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
   TextView tv;
   SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv=findViewById(R.id.name);
        preferences=getSharedPreferences("Data",MODE_PRIVATE);
        tv.setText("welcome "+preferences.getString("name",null));
    }
}
