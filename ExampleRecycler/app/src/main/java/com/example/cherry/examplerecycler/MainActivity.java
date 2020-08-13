package com.example.cherry.examplerecycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    String names[] = {"Alpha","Beta","Cupcake","Donut","Eclairs","Froyo"
    ,"Gingerbread","HoneyComb","Icecream","Jellybean"};
    int images[] = {R.drawable.alpha,R.drawable.beta,R.drawable.cupcake
    ,R.drawable.donut,R.drawable.eclairs,R.drawable.froyo,R.drawable.gingerbread,
    R.drawable.honeycomb,R.drawable.icecream,R.drawable.jellybean};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.rv);
        MyAdapter myAdapter = new MyAdapter(this,names,images);
        rv.setAdapter(myAdapter);
        rv.setLayoutManager(new LinearLayoutManager(this));

    }
}