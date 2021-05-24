package com.example.foodordersms;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.telephony.SmsManager;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg_choiceSelected;
    RadioGroup rg_sizeSelected;
    RadioGroup rg_sweetnessSelected;
    RadioGroup rg_iceSelected;
    Button btn_datHang;

    RadioButton rb_choiceSelected;
    RadioButton rb_sizeSelected;
    RadioButton rb_sweetnessSelected;
    RadioButton rb_iceSelected;

    public void clicked(String url){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        PlaceOrder();
        findViewById(R.id.address).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked("https://goo.gl/maps/EpX8xVsR9eYqbviT7");
            }
        });

    }
    public void PlaceOrder(){
        //ViewOrderInfoActivity confirmorder = new ViewOrderInfoActivity();
        btn_datHang = findViewById(R.id.submitbtn);
        rg_choiceSelected = findViewById(R.id.choice);
        rg_sizeSelected = findViewById(R.id.size);
        rg_sweetnessSelected = findViewById(R.id.sweetness);
        rg_iceSelected = findViewById(R.id.ice);

        btn_datHang.setOnClickListener( new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iGetOrderInfo = new Intent(getApplicationContext(), ViewOrderInfoActivity.class);
//
                int id_choiceSelected = rg_choiceSelected.getCheckedRadioButtonId();
                rb_choiceSelected = (RadioButton) findViewById(id_choiceSelected);
                String text_choiceSelected = rb_choiceSelected.getText().toString();
//
                int id_sizeSelected = rg_sizeSelected.getCheckedRadioButtonId();
                rb_sizeSelected = (RadioButton) findViewById(id_sizeSelected);
                String text_sizeSelected = rb_sizeSelected.getText().toString();
//
                int id_sweetnessSelected = rg_sweetnessSelected.getCheckedRadioButtonId();
                rb_sweetnessSelected = (RadioButton) findViewById(id_sweetnessSelected);
                String text_sweetnessSelected = rb_sweetnessSelected.getText().toString();
//
                int id_iceSelected = rg_iceSelected.getCheckedRadioButtonId();
                rb_iceSelected = (RadioButton) findViewById(id_iceSelected);
                String text_iceSelected = rb_iceSelected.getText().toString();



//                Bundle bundle = new Bundle();

                iGetOrderInfo.putExtra("choiceKey", text_choiceSelected);
                iGetOrderInfo.putExtra("sizeKey", text_sizeSelected);
                iGetOrderInfo.putExtra("sweetnessKey", text_sweetnessSelected);
                iGetOrderInfo.putExtra("iceKey", text_iceSelected);
                startActivity(iGetOrderInfo);
            }
        });



    }

}