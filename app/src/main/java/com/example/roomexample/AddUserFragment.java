package com.example.roomexample;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddUserFragment extends Fragment {
    private EditText userID, userName, userEmail;
    private Button buttonSave;


    public AddUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_user, container, false);
        userID = view.findViewById(R.id.text_user_id);
        userName = view.findViewById(R.id.text_name);
        userEmail = view.findViewById(R.id.text_email);
        buttonSave = view.findViewById(R.id.button_save_user);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.parseInt(userID.getText().toString());
                String name = userName.getText().toString();
                String email = userEmail.getText().toString();

                User user = new User();

                user.setId(id);
                user.setName(name);
                user.setEmail(email);

                MainActivity.myAppDatabase.myDao().addUser(user);

                Toast.makeText(getActivity(), "The User Added successfully", Toast.LENGTH_SHORT).show();

                userID.setText("");
                userName.setText("");
                userEmail.setText("");

            }
        });


        return view;
    }

}
