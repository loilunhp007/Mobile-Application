package com.example.bailan2_bai1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CountryDetail extends AppCompatActivity {
    TextView tvCountryName, tvCountryCode, tvPopulation, tvAreaInSqKm;
    ImageView ivFlag;
    URL url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_detail);
        initial();

        Intent intent = getIntent();
        String countryName = intent.getStringExtra("countryName");
        String countryCode = intent.getStringExtra("countryCode");
        String population = intent.getStringExtra("population");
        String areaInSqKm = intent.getStringExtra("areaInSqKm");

        tvCountryName.setText("Country Name:" + countryName);
        tvCountryCode.setText("Country Code:" + countryCode);
        tvPopulation.setText("Population:" + population);
        tvAreaInSqKm.setText("Area In SqKm:" + areaInSqKm);

        String path = "https://img.geonames.org/flags/x/" + countryCode.toLowerCase() + ".gif";

        new GetImage().execute(path);

    }
    private void initial() {
        tvCountryName = findViewById(R.id.tvCountryName);
        tvCountryCode = findViewById(R.id.tvCountryCode);
        tvPopulation = findViewById(R.id.tvPopulation);
        tvAreaInSqKm = findViewById(R.id.tvAreaInSqKm);
        ivFlag = findViewById(R.id.ivFlag);
    }

    class GetImage extends AsyncTask<String, Void,byte[]>{

        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        @Override
        protected byte[] doInBackground(String... strings) {
            Request.Builder builder = new Request.Builder();
            builder.url(strings[0]);

            Request request = builder.build();
            try {
                Response response = okHttpClient.newCall(request).execute();
                return response.body().bytes();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(byte[] bytes) {
            if(bytes.length >0){
                Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                ivFlag.setImageBitmap(bitmap);
            }
            super.onPostExecute(bytes);
        }
    }

}