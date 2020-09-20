package com.example.suraksha;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ngo extends Activity {
    public static String ngo1,ngo2,ngo3;
    EditText ph, ph1, ph2;
    TextView textView, textView1, textView2;
    Button nno;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ngo);
        addonn();
    }

    public void addonn() {
        final Context context = this;
        nno = (Button) findViewById(R.id.ngobutton);
        ph = (EditText) findViewById(R.id.ngotext1);
        ph1 = (EditText) findViewById(R.id.ngotext2);
        ph2 = (EditText) findViewById(R.id.ngotext3);

        textView = (TextView) findViewById(R.id.ngoview1);
        textView1 = (TextView) findViewById(R.id.ngoview2);
        textView2 = (TextView) findViewById(R.id.ngoview3);

        nno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ngo1 = ph.getText().toString();
                ngo2 = ph1.getText().toString();
                ngo3 = ph2.getText().toString();
                textView.setText("Ngo Phone No. 1:" + ngo1);
                textView1.setText("Ngo Phone No. 2:" + ngo2);
                textView2.setText("Ngo Phone No. 3:" + ngo3);
                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);

            }
        });
        textView.setText("Ngo Phone No. 1:" + ngo1);
        textView1.setText("Ngo Phone No. 2:" + ngo2);
        textView2.setText("Ngo Phone No. 3:" + ngo3);


    }

}
