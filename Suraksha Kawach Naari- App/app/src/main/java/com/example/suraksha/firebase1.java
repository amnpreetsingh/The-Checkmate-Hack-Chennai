package com.example.suraksha;


import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class firebase1 extends AppCompatActivity {
    EditText txtdest,txtstart,txtphone;
    TextView txtphoto;
    Button btnsave;
    DatabaseReference reff;
    Member member;
    String photo;
    public static int r;
     int i,s=0;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firebase);
        member=new Member();
        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        Uri personPhoto = acct.getPhotoUrl();
        final String personName = acct.getDisplayName();
        final String personEmail = acct.getEmail();


        txtphone=(EditText)findViewById(R.id.editTextPhone2);
        txtstart=(EditText)findViewById(R.id.editTextTextEmailAddress2);
        txtdest=(EditText)findViewById(R.id.editTextTextEmailAddress4);
        photo = personPhoto.toString();


        btnsave=(Button)findViewById(R.id.button2);
        reff= FirebaseDatabase.getInstance().getReference().child("Member");
        s=r;
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Long phn=Long.parseLong(txtphone.getText().toString().trim());
                member.setStart(txtstart.getText().toString().trim());
                member.setDestination(txtdest.getText().toString().trim());

                member.setName(personName);
                member.setPh(phn);
                member.setMail(personEmail);
                member.setPhoto(photo);

                for (i=0;i<1;i++)
                {
                    s=s+1;
                    r=s;
                }
                reff.child(String.valueOf(s)).setValue(member);
               // reff.push().setValue(member);
                Toast.makeText(firebase1.this,"data inserted succesfully",Toast.LENGTH_LONG).show();
            }
        });


    }

}
