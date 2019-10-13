package com.example.roomexample;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReadUserFragment extends Fragment {
    private TextView textInfo;

    public ReadUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_read_user, container, false);
        textInfo = view.findViewById(R.id.text_display_users);

        List<User> users = MainActivity.myAppDatabase.myDao().getUsers();
        String info ="";
        for (User user : users){

            int id = user.getId();
            String name = user.getName();
            String email = user.getEmail();

            info = info +"\n ID: "+id+"\n Name: "+name+"\n E-mail: "+"\n--------------------------";
        }

        textInfo.setText(info);

        return view;
    }

}
