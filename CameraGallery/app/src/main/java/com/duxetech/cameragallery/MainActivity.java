package com.duxetech.cameragallery;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    Button bTakePic;
    String mCameraFileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bTakePic = findViewById(R.id.bTakePic);


        bTakePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                Date date = new Date();
                DateFormat df = new SimpleDateFormat("-mm-ss");

                String newPicFile = "Bild"+ df.format(date) + ".jpg";
                String outPath = "/sdcard/" + newPicFile;
                File outFile = new File(outPath);

                 mCameraFileName = outFile.toString();
                Uri outuri = Uri.fromFile(outFile);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, outuri);
                startActivityForResult(intent,101);

            }
        });
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (requestCode == 101)
        {
            // return from file upload
            if (resultCode == Activity.RESULT_OK)
            {
                Uri uri = null;
                if (data != null)
                {
                    uri = data.getData();
                }
                if (uri == null && mCameraFileName != null)
                {
                    uri = Uri.fromFile(new File(mCameraFileName));
                }
                File file = new File(mCameraFileName);
                if (!file.exists()) {
                    file.mkdir();
                }
            }
        }}
}


