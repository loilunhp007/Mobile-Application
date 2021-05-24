package com.example.btqt12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {
    Button myButton;
    EditText textc,textf,textlichsu;
    float soc,sof;
    RadioGroup kieu;
    RadioButton rbcf,rbfc;
    ScrollView danhs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myButton = (Button) findViewById(R.id.btChuyen);
        textc = (EditText) findViewById(R.id.dot);
        textf = (EditText) findViewById(R.id.dof);
        kieu = (RadioGroup) findViewById(R.id.mode);
        rbcf = (RadioButton) findViewById(R.id.ctof);
        rbfc = (RadioButton) findViewById(R.id.ftoc);
        danhs = (ScrollView) findViewById(R.id.danhsach);
        textlichsu= (EditText) findViewById(R.id.them);
        rbcf.setChecked(true);
       myButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(rbcf.isChecked()) {
                   soc = Float.valueOf(textc.getText().toString());
                   textf.setText(String.valueOf(convertCtoF(soc)));
                    addToHistory(soc,convertCtoF(soc),"°C","°F");
               }
               if(rbfc.isChecked()) {
                   sof = Float.valueOf(textf.getText().toString());
                   textc.setText(String.valueOf(convertFtoC(sof)));
                   addToHistory(sof,convertFtoC(sof),"°F","°C");
               }
           }

       });
    }
    private float convertFtoC(float dof){
        return ((dof - 32)*5 / 9);
    }
    private float convertCtoF(float doc){
        return (((doc * 9 ) / 5) + 32); }
    private void addToHistory(Float text1, Float text2,String text11,String text12){
        textlichsu.append(text1+text11+ "->" +text2+text12+"\n");
    }

}