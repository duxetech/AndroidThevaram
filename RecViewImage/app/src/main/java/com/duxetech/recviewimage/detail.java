package com.duxetech.recviewimage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class detail extends AppCompatActivity {
    ImageView iv;
    int image;
    TextView tv2;
    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        iv=findViewById(R.id.iv2);
        tv2=findViewById(R.id.tv2);
        text=getIntent().getStringExtra("text");
        image =getIntent().getIntExtra("image",0);
        iv.setImageResource(image);
        tv2.setText(text);



    }
}
