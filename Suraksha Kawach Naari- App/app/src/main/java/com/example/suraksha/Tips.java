package com.example.suraksha;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.suraksha.R.id.messagewindow;
import static com.example.suraksha.R.id.titlewindow;

public class Tips extends Activity implements View.OnTouchListener {
    TextView textView;
    final static float move = 200;
    float ratio = 1.0f;
    int baseDist;
    float baseRatio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);
        TextView textView = findViewById(R.id.messagewindow);
        textView.setTextSize(ratio+15);

        Button onlinetips = (Button) findViewById(R.id.onlinetips);
        onlinetips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://youtu.be/R0z1v5MXNWc"));
                intent.setPackage("com.google.android.youtube");
                startActivity(intent);
            }
        });
        final Context context = this;
        Button videotips = (Button) findViewById(R.id.videotips);
        videotips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(context, Video.class);
                startActivity(intent);

            }
        });

        TextView mTitleWindow = (TextView) findViewById(titlewindow);
        TextView mMessageWindow = (TextView) findViewById(R.id.messagewindow);

        mTitleWindow.setText("TEXT SAFETY TIPS");
        StringBuilder stringBuilder = new StringBuilder();
        String someMessage = "  (1) Be aware of your surroundings. Don’t let your guard down\n" +
                "\n" +
                "(a) If things seem even a slight unsafe get out of that place immediately\n" +
                "\n" +
                "(2) Please trust and make good use of your ‘gut feel’ or ‘intuition’ or ‘sixth sense’ in each & every place and situation\n" +
                "\n" +
                "(a) There will invariably be signs, however small or seemingly insignificant, that tell or alarm you that all is just not OK. You may not understand it or be able to analyze it consciously, but please do NOT ignore it. It is your personal threat alarm beeping\n" +
                "\n" +
                "(b) Make it a habit to read and notice these warning signs and go with your intuition to quickly retract yourself, move out or immediately get away from potentially unsafe situations\n" +
                "\n" +
                "(3) Don’t take eve teasing lightly\n" +
                "\n" +
                "(a) Respond with a stern voice\n" +
                "\n" +
                "(b) Threaten to take a picture which might scare them away\n" +
                "\n" +
                "(c) If the eve teasing still persists then immediately raise your voice to gather a crowd\n" +
                "\n" +
                "(4) As much as possible avoid late night travel using public transport\n" +
                "\n" +
                "(a) If avoiding is not possible then be sure to travel only on crowded bus\n" +
                "\n" +
                "(b) Avoid taking road side cabs\n" +
                "\n" +
                "(c) Avoid using a bus which has no passenger or few passenger\n" +
                "\n" +
                "(5) While using 2 wheeler be sure to wear helmet at all times (especially at night). Don’t stop for any stranger\n" +
                "\n" +
                "(a) In case attacked, use your helmet to defend yourself\n" +
                "\n" +
                "(6) While driving a car:\n" +
                "\n" +
                "(a) Avoid parking at desolate area\n" +
                "\n" +
                "(b) Look inside the car especially the back seat before unlocking & entering\n" +
                "\n" +
                "(c) Lock the doors immediately after entering the car\n" +
                "\n" +
                "(d) Start the car & drive off rather then call someone. Calls can wait\n" +
                "\n" +
                "(e) Don’t give lift to strangers\n" +
                "\n" +
                "(f) Don’t stop your car for strangers, especially at night\n" +
                "\n" +
                "(g) Take known routes, avoid short cuts which you don’t know\n" +
                "\n" +
                "(7) While travelling at night don’t keep your phone in your hand\n" +
                "\n" +
                "(a) Remember phone is the first thing your attacker will throw away\n" +
                "\n" +
                "(b) Activate your speed dials which can be used to dial numbers in emergency\n" +
                "\n" +
                "(c) Keep it in your pocket or at a place from where you can easily take it out & dial a number & leave it on\n" +
                "\n" +
                "(d) Once the number has been dialled start shouting & try to speak out your location so that the other person can inform police about your location\n" +
                "\n" +
                "(e) If you have a smart phone then install emergency apps which can send sms to known people & can even dial police no. in case of emergency\n" +
                "\n" +
                "(8) After getting dropped don’t stay outside to take a call\n" +
                "\n" +
                "(a) Take calls on your phone only when you have entered your home & not outside\n" +
                "\n" +
                "(9) If you feel that someone is following you immediately rush to a crowded place & if need to be don’t be embarrassed to shout & gain attention\n" +
                "\n" +
                "(a) Don’t be embarrassed to share such things with your family & friends\n" +
                "\n" +
                "(10) In case you are in a sticky situation don’t be afraid to use anything in your hand to defend yourself\n" +
                "\n" +
                "(a) Use keys, bottle even your purse to inflict damage to your attacker\n" +
                "\n" +
                "(11) Following are the most vulnerable areas to attack:\n" +
                "\n" +
                "(a) Use your knees to hit hard between the legs of the attacker\n" +
                "\n" +
                "(b) Using your fingers to poke hard in the eyes\n" +
                "\n" +
                "(c) Hitting front part of the neck on the Adams apple will leave him in a shock\n" +
                "\n" +
                "(d) Punching in the stomach will leave the attacker breathless & unable to chase you\n" +
                "\n" +
                "(e) Hitting hard in the chest area\n" +
                "\n" +
                "(12) In case you feel you are being stalked or regularly followed, don’t keep it to yourself because what might be on lighter side now might become dangerous if not controlled\n" +
                "\n" +
                "(a) Seek help of friends & family\n" +
                "\n" +
                "(b) If need be approach police immediately";
        for(int i=1;i<2;i++){
            stringBuilder.append(someMessage);
        }
        mMessageWindow.setText(stringBuilder.toString());

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getPointerCount() == 2) {
            int action = event.getAction();
            int mainaction = action&MotionEvent.ACTION_MASK;
            if(mainaction == MotionEvent.ACTION_POINTER_DOWN) {
                baseDist = getDistence(event);
                baseRatio = ratio;
            }else {
                float scale = (getDistence(event)-baseDist)/move;
                float factor = (float) Math.pow(2,scale);
                ratio = Math.min(1024.0f,Math.max(0.1f,baseRatio*factor));
                textView.setTextSize(ratio+15);
            }
        }
        return true;
    }

    private int getDistence(MotionEvent event) {
        int dx = (int) (event.getX(0)-event.getX(1));
        int dy = (int) (event.getY(0)-event.getY(1));
        return (int) (Math.sqrt(dx*dx+dy*dy));
    }
}