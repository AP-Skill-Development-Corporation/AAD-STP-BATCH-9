package com.example.cherry.exampleregister;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name,email,number;
    Spinner sp;
    RadioGroup rg;
    RadioButton rb;
    CheckBox t,h,e;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        number = findViewById(R.id.number);
        sp = findViewById(R.id.spinner);
        rg = findViewById(R.id.rg);
        t = findViewById(R.id.tel);
        h = findViewById(R.id.hin);
        e = findViewById(R.id.eng);
    }

    public void register(View view) {
        String n = name.getText().toString();
        String mail = email.getText().toString();
        String num = number.getText().toString();
        String branch = sp.getSelectedItem().toString();
        int id = rg.getCheckedRadioButtonId();
        rb = findViewById(id);
        StringBuilder builder = new StringBuilder();
        if (t.isChecked()){
            builder.append("Telugu"+"\n");
        }
        if (h.isChecked()){
            builder.append("Hindi"+"\n");
        }
        if (e.isChecked()){
            builder.append("English"+"\n");
        }
        Toast.makeText(this, n+"\n"+mail+"\n"+num+"\n"+
                branch+"\n"+rb.getText()+"\n"+builder.toString()
                , Toast.LENGTH_SHORT).show();

    }
}