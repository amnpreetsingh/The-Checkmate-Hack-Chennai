package com.example.suraksha;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class fetch extends Activity {
    DatabaseReference rootRef, demoRef,defphoto,defstart,defdest;
    TextView fetchedText,fetchstart,fetchdest;
    Button fetchButton;
    String value,value1,value2;
    Uri extp;
    String r;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fetch);
        fetchButton = findViewById(R.id.btnFetch);
        fetchedText = findViewById(R.id.tvValue);
        fetchstart = findViewById(R.id.textView9);
        fetchdest = findViewById(R.id.textView10);
        imageView =findViewById(R.id.imageView5);
        r = String.valueOf(firebase1.r);

        fetchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootRef = FirebaseDatabase.getInstance().getReference("Member/" + r);

                // Database reference pointing to demo node
                demoRef = rootRef.child("name");
                defphoto = rootRef.child("photo");
                defstart=rootRef.child("start");
                defdest=rootRef.child("destination");



                demoRef.orderByKey().addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                         value = dataSnapshot.getValue(String.class);
                        fetchedText.setText(value);
                    }


                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast.makeText(fetch.this, "Error fetching data", Toast.LENGTH_LONG).show();
                    }
                });
                defphoto.orderByKey().addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        value = dataSnapshot.getValue(String.class);
                        extp = Uri.parse(value);
                        Glide.with(fetch.this).load(String.valueOf(extp)).into(imageView);

                        Glide.with(fetch.this).load(extp).apply(RequestOptions.circleCropTransform()).into(imageView);
                    }


                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast.makeText(fetch.this, "Error fetching data", Toast.LENGTH_LONG).show();
                    }
                });
                defstart.orderByKey().addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        value1 = dataSnapshot.getValue(String.class);
                        fetchstart.setText(value1);
                    }


                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast.makeText(fetch.this, "Error fetching data", Toast.LENGTH_LONG).show();
                    }
                });
                defdest.orderByKey().addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        value2 = dataSnapshot.getValue(String.class);
                        fetchdest.setText(value2);
                    }


                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast.makeText(fetch.this, "Error fetching data", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

    }
}
