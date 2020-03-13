package com.duxetech.thevaram.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.duxetech.thevaram.R;

public class Frag1 extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag1,container,false);
        TextView t1 =  view.findViewById(R.id.tv1);
        t1.setText("");
//        t1.setText("Hello");
        return view;
    }
}
