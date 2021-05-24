package com.example.bailan2_bai1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.nfc.Tag;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.*;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity {

    private Button btnSubmit;
    String responseText = null;
    StringBuffer response = null;
    URL url;
    Activity activity;
    ArrayList<Country> countries=new ArrayList<Country>();
    private ProgressDialog progressDialog;
    ListView listView;


    //Direct Web services URL
    private  static  final  String user_name = "thaiphison";
    private static final String path = "https://secure.geonames.org/countryInfoJSON?formatted=true&lang=it&style=full&username=" +user_name;
//    private String path = "http://api.geonames.org/countryInfoJSON?username=aporter";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activity = this;
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        listView = (ListView) findViewById(R.id.list);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countries.clear();
                //Call WebService
                new GetServerData().execute();
            }
        });
    }


    class GetServerData extends AsyncTask
    {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setMessage("Fetching conntry data");
            progressDialog.setCancelable(false);
            progressDialog.show();

        }

        @Override
        protected Object doInBackground(Object[] objects) {
            return getWebServiceResponseData();
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);

            // Dismiss the progress dialog
            if (progressDialog.isShowing())
                progressDialog.dismiss();
            // For populating list data
            CustomCountryList customCountryList = new CustomCountryList(activity, countries);
            listView.setAdapter(customCountryList);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                    Intent it1 = new Intent(MainActivity.this, CountryDetail.class);
                    it1.putExtra("countryName", countries.get(position).getCountryName());
                    it1.putExtra("countryCode", countries.get(position).getCountryCode());
                    it1.putExtra("population", countries.get(position).getPopulation());
                    it1.putExtra("areaInSqKm", countries.get(position).getAreaInSqKm());
                    startActivity(it1);
                    Toast.makeText(getApplicationContext(),"You Selected "+countries.get(position).getCountryName()+ " as Country",Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
    protected Void getWebServiceResponseData() {

        try {
            url = new URL(path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(15000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();


            if (responseCode == HttpsURLConnection.HTTP_OK) {

                BufferedReader in = new BufferedReader(
                        new InputStreamReader(conn.getInputStream()));
                String output;

                response = new StringBuffer();

                while ((output = in.readLine()) != null) {
                    response.append(output);
                }

                in.close();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

//        String data;
//        InputStream in= getResources().openRawResource(R.raw.country);
//        InputStreamReader inreader=new InputStreamReader(in);
//        BufferedReader bufreader=new BufferedReader(inreader);
//        StringBuilder builder=new StringBuilder();
//        if(in!=null)
//        {
//            try
//            {
//                while((data=bufreader.readLine())!=null)
//                {
//                    builder.append(data);
//                }
//                in.close();
//                responseText = builder.toString();
//            }
//            catch(IOException ex){
//                Log.e("ERROR", ex.getMessage());
//            }
//        }

        responseText = new String();
        responseText = response.toString();

        try {
            JSONObject jsonObject = new JSONObject(responseText);
            JSONArray jsonarray = jsonObject.getJSONArray("geonames");
            for (int i = 0; i < jsonarray.length(); i++) {
                JSONObject jsonobject = jsonarray.getJSONObject(i);
                long id = jsonobject.getLong("geonameId");
                String countryName = jsonobject.getString("countryName");
                String countryCode = jsonobject.getString("countryCode");
                String population = jsonobject.getString("population");
                String areaInSqKm = jsonobject.getString("areaInSqKm");

                Country countryObj=new Country(id,countryName,countryCode,population,areaInSqKm);
                countries.add(countryObj);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
}
