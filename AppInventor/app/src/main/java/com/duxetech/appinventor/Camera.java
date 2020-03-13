package com.duxetech.appinventor;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Camera extends AppCompatActivity {
    Button btPic;
    ListView lv;
    private static final int REQUEST_IMAGE_CAPTURE = 101;
    List<Bitmap> images = new ArrayList<>();
    RvAdapter adapter;
    RecyclerView rv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        btPic = findViewById(R.id.btPic);
        rv = findViewById(R.id.rv);

         adapter = new RvAdapter(this,images);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true));
        SnapHelper snap = new PagerSnapHelper();
        snap.attachToRecyclerView(rv);

       btPic.setOnClickListener(new View.OnClickListener() {
           @RequiresApi(api = Build.VERSION_CODES.M)
           @Override
           public void onClick(View v) {

               Intent in = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
               if (in.resolveActivity(getPackageManager())!=null){
                   startActivityForResult(in,REQUEST_IMAGE_CAPTURE);

               } }
       });
       }

    @Override
    protected  void onActivityResult(int req, int res, Intent data){
        super.onActivityResult(req,res,data);
        if (req==REQUEST_IMAGE_CAPTURE && res == RESULT_OK) {
            Bundle bun = data.getExtras();
            Bitmap img = (Bitmap) bun.get("data");
            images.add(img);
            adapter.notifyDataSetChanged();

        }
    }

}
