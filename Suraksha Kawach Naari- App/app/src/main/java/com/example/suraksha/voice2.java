package com.example.suraksha;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.widget.Toast;


import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.example.suraksha.ui.gallery.GalleryFragment;

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

public class voice2 extends Activity {
    public static String result,result1,result2,ngo1,ngo2,ngo3;
    String ServerURL="https://hab59-naari-ap.000webhostapp.com/androidapi.php";
    //String ServerURL="http://infocp27.epizy.com/androidapi.php";

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

    private static final int SPEECH_REQUEST_CODE = 0;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.submit);
        displaySpeechRecognizer();
    }



    // Create an intent that can start the Speech Recognizer activity
    private void displaySpeechRecognizer() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
// Start the activity, the intent will be populated with the speech text
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                "Say Code");

        startActivityForResult(intent, SPEECH_REQUEST_CODE);
    }

    // This callback is invoked when the Speech Recognizer returns.
// This is where you process the intent and extract the speech text from the intent.
    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        final Context context=this;
        if (requestCode == SPEECH_REQUEST_CODE && resultCode == RESULT_OK) {
            List<String> results = data.getStringArrayListExtra(
                    RecognizerIntent.EXTRA_RESULTS);
            String spokenText = results.get(0);
            // Do something with spokenText
            if  (results.get(0).toString().equals(GalleryFragment.code)) {
                GetData();
                InsertData(TempName, TempEmail,TempImage,TempLocation,TempContact,TempContact1,TempContact2,TempNgo1,TempNgo2,TempNgo3);

            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    public void GetData() {
        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        String personName = acct.getDisplayName();
        Uri personPhoto = acct.getPhotoUrl();
        String personEmail = acct.getEmail();
        photostring=personPhoto.toString();
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

                Toast.makeText(voice2.this, "Data Submit Successfully", Toast.LENGTH_LONG).show();

            }
        }

        SendPostReqAsyncTask sendPostReqAsyncTask = new SendPostReqAsyncTask();

        sendPostReqAsyncTask.execute(tempName,tempEmail,tempImage,tempLocation,tempContact,tempContact1,tempContact2,tempNgo1,tempNgo2,tempNgo3);
    }
}
