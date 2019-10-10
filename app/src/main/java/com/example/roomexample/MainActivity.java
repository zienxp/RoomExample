package com.example.roomexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.fragment_container)!= null){
            if(savedInstanceState!=null){
                return;
            }

            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,new HomeFragment()).commit();
        }

    }


}
