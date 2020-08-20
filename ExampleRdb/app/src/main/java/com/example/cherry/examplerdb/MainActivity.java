package com.example.cherry.examplerdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cherry.examplerdb.Database.RTable;
import com.example.cherry.examplerdb.Database.RViewModel;
import com.example.cherry.examplerdb.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {
   // EditText name,roll,number;
    RecyclerView rv;
    public static RViewModel viewModel;
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
      /*  name = findViewById(R.id.name);
        roll = findViewById(R.id.roll);
        number = findViewById(R.id.number);*/
        rv = findViewById(R.id.rv);
        viewModel = new ViewModelProvider(this).get(RViewModel.class);
        viewModel.readData().observe(this, new Observer<List<RTable>>() {
            @Override
            public void onChanged(List<RTable> rTables) {
                MyAdapter adapter = new MyAdapter(MainActivity.this,rTables);
                rv.setAdapter(adapter);
                rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            }
        });
    }
    public void save(View view) {
      /*  String n = name.getText().toString();
        String r=roll.getText().toString();
        String nu = number.getText().toString();*/
        RTable rTable=new RTable();
        rTable.setName(binding.name.getText().toString());
        rTable.setRoll(binding.roll.getText().toString());
        rTable.setNumber(binding.number.getText().toString());
        viewModel.insert(rTable);
        Toast.makeText(this, "Saved Successfully",
                Toast.LENGTH_SHORT).show();
    }
}