package com.example.suraksha.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.suraksha.R;
import com.example.suraksha.firebase1;
import com.example.suraksha.map;
import com.example.suraksha.ngo;
import com.example.suraksha.php;
import com.example.suraksha.voice2;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.maps.model.LatLng;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    public static String result,result1,result2,ngo1,ngo2,ngo3;
    String ServerURL="https://hab59-naari-ap.000webhostapp.com/androidapi.php";

    private HomeViewModel homeViewModel;
    ImageButton button1,button2,mapp;
    Button info,ngoo,background,firebasebut;
    String TempName;
    String TempEmail;
    String photostring;
    String TempImage;
    String TempLocation;
    String locationstring;
    String TempContact;
    String TempContact1;
    String TempContact2;
    String TempNgo1;
    String TempNgo2;
    String TempNgo3;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        /*homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);*/
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        //final TextView textView = root.findViewById(R.id.text_home);
        /*homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
          button1 = (ImageButton)root.findViewById(R.id.imageButton);
         button2 = (ImageButton)root.findViewById(R.id.imageButton2);
         info = (Button)root.findViewById(R.id.button3);
        firebasebut = (Button)root.findViewById(R.id.button2);
        ngoo = (Button)root.findViewById(R.id.button8);
        mapp = (ImageButton) root.findViewById(R.id.imageButton5);
        background = (Button)root.findViewById(R.id.button10);
        firebasebut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(getActivity(), firebase1.class);
                startActivity(intent);

            }

        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent1 = new Intent(Intent.ACTION_CALL);
                intent1.setData(Uri.parse("tel:100"));//change the number
                startActivity(intent1);

            }

        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:102"));//change the number
                startActivity(intent);

            }

        });
        info.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(getActivity(), php.class);
                startActivity(intent);

            }

        });
        ngoo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(getActivity(), ngo.class);
                startActivity(intent);

            }

        });
        mapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(getActivity(), map.class);
                startActivity(intent);

            }
        });
        background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), voice2.class);
                startActivity(intent);

            }
        });



        return root;
    }
    public void GetData() {
        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(getActivity());
        String personName = acct.getDisplayName();
        Uri personPhoto = acct.getPhotoUrl();
        String personEmail = acct.getEmail();
        photostring=personPhoto.toString();
        LatLng Latlng = new LatLng(27.2378,76.6241);
        locationstring=Latlng.toString();
        String s1= map.s1;
        String s2=map.s2;
        String s3=s1+","+s2;
        result=php.result;
        result1=php.result1;
        result2=php.result2;
        ngo1= ngo.ngo1;
        ngo2=ngo.ngo2;
        ngo3=ngo.ngo3;




        TempName = personName;
        TempEmail = personEmail;
        TempImage=photostring;
        TempLocation= s3;
        TempContact=result;
        TempContact1=result1;
        TempContact2=result2;
        TempNgo1=ngo1;
        TempNgo2=ngo2;
        TempNgo3=ngo3;



    }

    public void InsertData(final String tempName, final String tempEmail,final String tempImage, final String tempLocation, final String tempContact,final String tempContact1,final String tempContact2,final String tempNgo1,final String tempNgo2,final String tempNgo3) {

        class SendPostReqAsyncTask extends AsyncTask<String, Void, String> {
            @Override
            protected String doInBackground(String... params) {
                String name= tempName;
                String email=tempEmail;
                String image= tempImage;
                String location=tempLocation;
                String contact=tempContact;
                String contact1=tempContact1;
                String contact2=tempContact2;
                String contactngo1=tempNgo1;
                String contactngo2=tempNgo2;
                String contactngo3=tempNgo3;

                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();

                nameValuePairs.add(new BasicNameValuePair("name",name));
                nameValuePairs.add(new BasicNameValuePair("email",email));
                nameValuePairs.add(new BasicNameValuePair("image",image));
                nameValuePairs.add(new BasicNameValuePair("location",location));
                nameValuePairs.add(new BasicNameValuePair("contact",contact));
                nameValuePairs.add(new BasicNameValuePair("contact1",contact1));
                nameValuePairs.add(new BasicNameValuePair("contact2",contact2));
                nameValuePairs.add(new BasicNameValuePair("contactngo1",contactngo1));
                nameValuePairs.add(new BasicNameValuePair("contactngo2",contactngo2));
                nameValuePairs.add(new BasicNameValuePair("contactngo3",contactngo3));
                try {
                    HttpClient httpClient = new DefaultHttpClient();

                    HttpPost httpPost = new HttpPost(ServerURL);

                    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                    HttpResponse httpResponse = httpClient.execute(httpPost);

                    HttpEntity httpEntity = httpResponse.getEntity();


                } catch (ClientProtocolException e) {

                } catch (IOException e) {

                }
                return "Data Inserted Successfully";
            }

            @Override
            protected void onPostExecute(String result) {

                super.onPostExecute(result);

                Toast.makeText(getActivity(), "Data Submit Successfully", Toast.LENGTH_LONG).show();

            }
        }

        SendPostReqAsyncTask sendPostReqAsyncTask = new SendPostReqAsyncTask();

        sendPostReqAsyncTask.execute(tempName,tempEmail,tempImage,tempLocation,tempContact,tempContact1,tempContact2,tempNgo1,tempNgo2,tempNgo3);
    }

}