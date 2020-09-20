package com.example.suraksha;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class signin2 extends Activity {
    private FirebaseAuth mAuth;
    ImageView image;
    TextView name,email,id;
    Button signout,con,addphn;
    GoogleSignInClient mGoogleSignInClient;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin2);
        mAuth = FirebaseAuth.getInstance();
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        image =findViewById(R.id.signinpic);
        name =findViewById(R.id.textName);
        email =findViewById(R.id.textEmail);
        id =findViewById(R.id.textID);
        con=findViewById(R.id.button6);
        addphn=findViewById(R.id.button5);
        final Context context = this;

        con.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);

            }

        });
        addphn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(context, php.class);
                startActivity(intent);

            }

        });


        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if (acct != null) {
            String personName = acct.getDisplayName();
             String personEmail = acct.getEmail();
            String personId = acct.getId();
           Uri personPhoto = acct.getPhotoUrl();
            //String res=php.Call();

            name.setText(personName);
            email.setText(personEmail);
            id.setText("Phone No."+php.result);
           Glide.with(context).load(String.valueOf(personPhoto)).into(image);
           Glide.with(context).load(String.valueOf(personPhoto)).apply(RequestOptions.circleCropTransform()).into(image);
        }
    }

    private void signOut() {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(signin2.this,"Signed Out Successfully",Toast.LENGTH_LONG).show();
                        finish();
                    }
                });
    }


}
