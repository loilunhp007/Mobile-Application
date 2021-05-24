package com.example.foodordersms;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Size;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

public class ViewOrderInfoActivity extends Activity implements Serializable {
    TextView tv_choiceValue;
    String choice;
    String size;
    String sweetness;
    String ice;
    Button confirm;
    String msgtext;

    //Called when the activity is first created
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.orderinfo);

        Intent intent = getIntent();

        choice = intent.getStringExtra("choiceKey");
        size = intent.getStringExtra("sizeKey");
        sweetness = intent.getStringExtra("sweetnessKey");
        ice = intent.getStringExtra("iceKey");

        TextView txtChoiceValue = (TextView) findViewById(R.id.choiceinfo);
        TextView txtSizeValue = (TextView) findViewById(R.id.sizeinfo);
        TextView txtSweetnessValue = (TextView) findViewById(R.id.sweetnessinfo);
        TextView txtIceValue = (TextView) findViewById(R.id.iceinfo);
        txtChoiceValue.setText(choice);
        txtSizeValue.setText(size);
        txtSweetnessValue.setText(sweetness);
        txtIceValue.setText(ice);
        ConfirmOrder(choice,size,sweetness,ice);
    }
    public void ConfirmOrder(String choice,String size,String sweetness,String ice){
        confirm = findViewById(R.id.confirmbtn);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmsManager smsManager= SmsManager.getDefault();
                msgtext="";
                msgtext=choice+ ","+size+","+sweetness+","+ice;
                System.out.println(msgtext);
                String phoneNum = "1900";
                Intent sendmsg = new Intent(Intent.ACTION_SENDTO);
                sendmsg.setData(Uri.parse("sms:"+phoneNum));
                sendmsg.putExtra("sms_body", msgtext);
                try {
                    startActivity(sendmsg);
                    finish();
                }catch (ActivityNotFoundException ex) {
                    Toast.makeText(ViewOrderInfoActivity.this, "SMS faild, please try again later.", Toast.LENGTH_SHORT).show();
                }
            }



        });
    }



}

