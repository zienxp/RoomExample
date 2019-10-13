package com.example.roomexample;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class DeleteUserFragment extends Fragment {
    private EditText textUserId;
    private Button deleteButton;


    public DeleteUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete_user, container, false);
        textUserId = view.findViewById(R.id.Text_id_delete);
        deleteButton = view.findViewById(R.id.button_delete);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int id = Integer.parseInt(textUserId.getText().toString());

                User user = new User();

                user.setId(id);

                MainActivity.myAppDatabase.myDao().deleteUser(user);

                Toast.makeText(getActivity(), "User Deleted", Toast.LENGTH_SHORT).show();

                textUserId.setText("");

            }
        });
        return view;
    }

}
