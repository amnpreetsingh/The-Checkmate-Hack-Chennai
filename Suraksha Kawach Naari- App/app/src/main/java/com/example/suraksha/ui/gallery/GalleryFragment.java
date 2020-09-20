package com.example.suraksha.ui.gallery;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.suraksha.R;

public class GalleryFragment extends Fragment {

    EditText setcode;
    Button sendcode;
    public static String code;
    TextView textView,textView1;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.secretcode, container, false);
        setcode = (EditText) v.findViewById(R.id.editTextTextPersonName3);
        sendcode = (Button) v.findViewById(R.id.button7);
        textView = (TextView) v.findViewById(R.id.textView2);
        sendcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                code = setcode.getText().toString();
                textView.setText(code);
            }
        });
        return v;

    }
}