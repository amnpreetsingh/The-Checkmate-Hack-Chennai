package com.example.suraksha;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class php extends Activity {
    public static String result,result1,result2;
    EditText ph,ph1,ph2;
    TextView textView, textView1,textView2;
    Button phno;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.php1);
        addon();
    }

    public void addon() {
        final Context context = this;
        phno = (Button) findViewById(R.id.button);
        ph = (EditText) findViewById(R.id.editText3);
        ph1= (EditText) findViewById(R.id.editText);
        ph2= (EditText) findViewById(R.id.editText2);

        textView = (TextView) findViewById(R.id.textView6);
        textView1 = (TextView) findViewById(R.id.textView7);
        textView2 = (TextView) findViewById(R.id.textView5);

        phno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result = ph.getText().toString();
                result1 = ph1.getText().toString();
                result2 = ph2.getText().toString();
                textView.setText("Your Phone No.:"+result);
                textView1.setText("Emergency No. 1:"+result1);
                textView2.setText("Emergency No.2:"+result2);
                Intent intent = new Intent(context, signin2.class);
                startActivity(intent);

            }
        });
        textView.setText("Your Phone No.:"+result);
        textView1.setText("Emergency No. 1:"+result1);
        textView2.setText("Emergency No.2:"+result2);


    }
    public static String Call(){
        return result;

    }
}