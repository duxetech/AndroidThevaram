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

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Frag4 extends Fragment {

    TextView tv1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag4,container,false);
        tv1=view.findViewById(R.id.f4_tv1);
     //   tv1.setText("hello");
        return view;
    }


    private void parseXML() {
        XmlPullParserFactory parserFactory;
        try {
            parserFactory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = parserFactory.newPullParser();
            InputStream is = getActivity().getAssets().open("data.xml");
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(is, null);

            processParsing(parser);

        } catch (XmlPullParserException e) {

        } catch (IOException e) {
        }
    }

    private void processParsing(XmlPullParser parser) throws IOException, XmlPullParserException{
        ArrayList<String> names = new ArrayList<>();
        int eventType = parser.getEventType();


        while (eventType != XmlPullParser.END_DOCUMENT) {
            String eltName = null;

            switch (eventType) {
                case XmlPullParser.START_TAG:
                    eltName = parser.getName();

                    if ("player".equals(eltName)) {
                        currentPlayer = new Player();
                        names.add(currentPlayer);
                    } else if (currentPlayer != null) {
                        if ("name".equals(eltName)) {
                            currentPlayer.name = parser.nextText();
                        } else if ("age".equals(eltName)) {
                            currentPlayer.age = parser.nextText();
                        } else if ("position".equals(eltName)) {
                            currentPlayer.position = parser.nextText();
                        }
                    }
                    break;
            }

            eventType = parser.next();
        }

        printPlayers(names);
    }

    private void printPlayers(ArrayList<Player> players) {
        StringBuilder builder = new StringBuilder();

        for (Player player : players) {
            builder.append(player.name).append("\n").
                    append(player.age).append("\n").
                    append(player.position).append("\n\n");
        }

        txt.setText(builder.toString());
    }

}
