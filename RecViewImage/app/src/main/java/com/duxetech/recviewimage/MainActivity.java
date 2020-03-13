package com.duxetech.recviewimage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    Adapter adapter;
    String names[]={"nature1","nature2","nature3","nature4","nature5"};
    int images[]={R.drawable.n1,R.drawable.n2,R.drawable.n3,R.drawable.n4,R.drawable.n5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv=findViewById(R.id.rv);
        adapter=new Adapter(this, names,images  );
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));
    }
}
