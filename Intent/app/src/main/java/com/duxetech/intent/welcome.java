package com.duxetech.intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        int a = getIntent().getExtras().getInt("a");
        Toast.makeText(this, ""+a, Toast.LENGTH_SHORT).show();
    }
}
