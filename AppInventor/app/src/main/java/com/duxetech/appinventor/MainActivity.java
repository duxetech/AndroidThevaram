package com.duxetech.appinventor;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    Date time;
    EditText et1;
    String a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);
        et1 = findViewById(R.id.et1);
       // MediaPlayer mp =  MediaPlayer.create(this,R.)
        final Toast t = new Toast(MainActivity.this);
        final Calendar time = Calendar.getInstance();

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = et1.getText().toString().trim();
                a=a.replace(";","");
                if  (a.contains("'") ){
                    t.makeText(MainActivity.this, "New text : "+a.replace("'",""), Toast.LENGTH_SHORT).show();
                }
                else  {
                    t.makeText(MainActivity.this,"No",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
