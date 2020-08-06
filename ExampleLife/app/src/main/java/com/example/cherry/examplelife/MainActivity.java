package com.example.cherry.examplelife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("Apssdc","Activity Created");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Apssdc","Activity Started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Apssdc","Activity Resumed");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Apssdc","Activity Paused");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Apssdc","Activity Stopped");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Apssdc","Activity Restarted");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Apssdc","Activity Destroyed");
    }

    public void next(View view) {
        Intent i = new Intent(this,MainActivity2.class);
        startActivity(i);
    }
}