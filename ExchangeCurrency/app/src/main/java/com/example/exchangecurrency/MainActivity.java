package com.example.exchangecurrency;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private  EditText editText ;
    private TextView value ;
    private Button btnCurrency;
    private Spinner spinner1,spinner2;
    private ArrayList<CurrencyRate> list ;
    private  String aCurrency,bCurrency;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new ArrayList<>();
        list.add(new CurrencyRate("Australian Dollar","AUD"));
        list.add(new CurrencyRate("Albanian Lek","ALL"));
        list.add(new CurrencyRate("Algerian Dinar","DZD"));
        list.add(new CurrencyRate("Argentine Peso","ARS"));
        list.add(new CurrencyRate("British Pound","GBP"));
        list.add(new CurrencyRate("Bahamian Dollar","BSD"));
        list.add(new CurrencyRate("Bahraini Dinar","BHD"));
        list.add(new CurrencyRate("Bangladesh Taka","BDT"));
        list.add(new CurrencyRate("Barbados Dollar","BBD"));
        list.add(new CurrencyRate("Belize Dollar","BZD"));
        list.add(new CurrencyRate("Bhutan Ngultrum","BTN"));
        list.add(new CurrencyRate("Bolivian Boliviano","BOB"));
        list.add(new CurrencyRate("Botswana Pula","BWP"));
        list.add(new CurrencyRate("Brazilian Real","BRL"));
        list.add(new CurrencyRate("Brunei Dollar","BND"));
        list.add(new CurrencyRate("Bulgarian Lev","BGN"));
        list.add(new CurrencyRate("Burundi Franc","BIF"));
        list.add(new CurrencyRate("Canadian Dollar","CAD"));
        list.add(new CurrencyRate("Chinese Yuan","CNY"));
        list.add(new CurrencyRate("Cambodia Riel","KHR"));
        list.add(new CurrencyRate("Cape Verde Escudo","CVE"));
        list.add(new CurrencyRate("CFA Franc (BCEAO)","XOF"));
        list.add(new CurrencyRate("CFA Franc (BEAC)","XAF"));
        list.add(new CurrencyRate("Chilean Peso","CLP"));
        list.add(new CurrencyRate("Colombian Peso","COP"));
        list.add(new CurrencyRate("Comoros Franc","KMF"));
        list.add(new CurrencyRate("Costa Rica Colon","CRC"));
        list.add(new CurrencyRate("Croatian Kuna","HRK"));
        list.add(new CurrencyRate("Cuban Peso","CUP"));
        list.add(new CurrencyRate("Czech Koruna","CZK"));
        list.add(new CurrencyRate("Euro","EUR"));
        list.add(new CurrencyRate("Danish Krone","DKK"));
        list.add(new CurrencyRate("Djibouti Franc","DJF"));
        list.add(new CurrencyRate("Dominican Peso","DOP"));
        list.add(new CurrencyRate("East Caribbean Dollar","XCD"));
        list.add(new CurrencyRate("Egyptian Pound","EGP"));
        list.add(new CurrencyRate("Ethiopian Birr","ETB"));
        list.add(new CurrencyRate("Fiji Dollar","FJD"));
        list.add(new CurrencyRate("Hong Kong Dollar","HKD"));
        list.add(new CurrencyRate("Indonesian Rupiah","IDR"));
        list.add(new CurrencyRate("Indian Rupee","INR"));
        list.add(new CurrencyRate("Gambian Dalasi","GMD"));
        list.add(new CurrencyRate("Guatemala Quetzal","GTQ"));
        list.add(new CurrencyRate("Guinea Franc","GNF"));
        list.add(new CurrencyRate("Guyana Dollar","GYD"));
        list.add(new CurrencyRate("Haiti Gourde","HTG"));
        list.add(new CurrencyRate("Honduras Lempira","HNL"));
        list.add(new CurrencyRate("Hungarian Forint","HUF"));
        list.add(new CurrencyRate("Iceland Krona","ISK"));
        list.add(new CurrencyRate("Iran Rial","IRR"));
        list.add(new CurrencyRate("Iraqi Dinar","IQD"));
        list.add(new CurrencyRate("Israeli Shekel","ILS"));
        list.add(new CurrencyRate("Japanese Yen","JPY"));
        list.add(new CurrencyRate("Jamaican Dollar","JMD"));
        list.add(new CurrencyRate("Jordanian Dinar","JOD"));
        list.add(new CurrencyRate("Kazakhstan Tenge","KZT"));
        list.add(new CurrencyRate("Kenyan Shilling","KES"));
        list.add(new CurrencyRate("Korean Won","KRW"));
        list.add(new CurrencyRate("Kuwaiti Dinar","KWD"));
        list.add(new CurrencyRate("Lao Kip","LAK"));
        list.add(new CurrencyRate("Lebanese Pound","LBP"));
        list.add(new CurrencyRate("Lesotho Loti","LSL"));
        list.add(new CurrencyRate("Liberian Dollar","LRD"));
        list.add(new CurrencyRate("Libyan Dinar","LYD"));
        list.add(new CurrencyRate("Macau Pataca","MOP"));
        list.add(new CurrencyRate("Macedonian Denar","MKD"));
        list.add(new CurrencyRate("Malawi Kwacha","MWK"));
        list.add(new CurrencyRate("Malaysian Ringgit","MYR"));
        list.add(new CurrencyRate("Maldives Rufiyaa","MVR"));
        list.add(new CurrencyRate("Mauritania Ougulya","MRO"));
        list.add(new CurrencyRate("Mauritius Rupee","MUR"));
        list.add(new CurrencyRate("Mexican Peso","MXN"));
        list.add(new CurrencyRate("Moldovan Leu","MDL"));
        list.add(new CurrencyRate("Mongolian Tugrik","MNT"));
        list.add(new CurrencyRate("Moroccan Dirham","MAD"));
        list.add(new CurrencyRate("Myanmar Kyat","NMK"));
        list.add(new CurrencyRate("Namibian Dollar","NAD"));
        list.add(new CurrencyRate("Nepalese Rupee","NPR"));
        list.add(new CurrencyRate("New Zealand Dollar","NZD"));
        list.add(new CurrencyRate("Nicaragua Cordoba","NIO"));
        list.add(new CurrencyRate("Nigerian Naira","NGN"));
        list.add(new CurrencyRate("North Korean Won","KPW"));
        list.add(new CurrencyRate("Norwegian Krone","NOK"));
        list.add(new CurrencyRate("Omani Rial","OMR"));
        list.add(new CurrencyRate("Pakistani Rupee","PKR"));
        list.add(new CurrencyRate("Papua New Guinea Kina","PGK"));
        list.add(new CurrencyRate("Paraguayan Guarani","PYG"));
        list.add(new CurrencyRate("Peruvian Nuevo Sol","PEN"));
        list.add(new CurrencyRate("Philippine Peso","PHP"));
        list.add(new CurrencyRate("Polish Zloty","PLN"));
        list.add(new CurrencyRate("Qatar Rial","QAR"));
        list.add(new CurrencyRate("Romanian New Leu","RON"));
        list.add(new CurrencyRate("Russian Rouble","RUB"));
        list.add(new CurrencyRate("Rwanda Franc","RWF"));
        list.add(new CurrencyRate("Swiss Franc","CHF"));
        list.add(new CurrencyRate("Samoa Tala","WST"));
        list.add(new CurrencyRate("Saudi Arabian Riyal","SAR"));
        list.add(new CurrencyRate("Seychelles Rupee","SCR"));
        list.add(new CurrencyRate("Sierra Leone Leone","SLL"));
        list.add(new CurrencyRate("Singapore Dollar","SGD"));
        list.add(new CurrencyRate("Solomon Islands Dollar","SBD"));
        list.add(new CurrencyRate("Somali Shilling","SOS"));
        list.add(new CurrencyRate("South African Rand","ZAR"));
        list.add(new CurrencyRate("Sri Lanka Rupee","LKR"));
        list.add(new CurrencyRate("Sudanese Pound","SDG"));
        list.add(new CurrencyRate("Swaziland Lilageni","SZL"));
        list.add(new CurrencyRate("Swedish Krona","SEK"));
        list.add(new CurrencyRate("Syrian Pound","SYP"));
        list.add(new CurrencyRate("United States Dollar","USD"));
        list.add(new CurrencyRate("Thai Baht","THB"));
        list.add(new CurrencyRate("Turkish Lira","TRY"));
        list.add(new CurrencyRate("Taiwan Dollar","TWD"));
        list.add(new CurrencyRate("Tanzanian Shilling","TZS"));
        list.add(new CurrencyRate("Tongan paʻanga","TOP"));
        list.add(new CurrencyRate("Trinidad Tobago Dollar","TTD"));
        list.add(new CurrencyRate("Tunisian Dinar","TND"));
        list.add(new CurrencyRate("UAE Dirham","AED"));
        list.add(new CurrencyRate("Ugandan Shilling","UGX"));
        list.add(new CurrencyRate("Ukraine Hryvnia","UAH"));
        list.add(new CurrencyRate("Uruguayan New Peso","UYU"));
        list.add(new CurrencyRate("Vanuatu Vatu","VUV"));
        list.add(new CurrencyRate("Vietnam Dong","VND"));
        list.add(new CurrencyRate("Yemen Riyal","YER"));
        list.add(new CurrencyRate("Uzbekistan Sum","UZS"));
        list.add(new CurrencyRate("Kyrgyzstan Som","KSG"));
        list.add(new CurrencyRate("Ghanaian Cedi","GHS"));
        list.add(new CurrencyRate("Belarusian ruble","BYN"));
        list.add(new CurrencyRate("Afghan afghani","AFN"));
        list.add(new CurrencyRate("Angolan kwanza","AOA"));
        list.add(new CurrencyRate("Armenian dram","AMD"));
        list.add(new CurrencyRate("Azerbaijani manat","AZN"));
        list.add(new CurrencyRate("Convertible mark","BAM"));
        list.add(new CurrencyRate("Congolese franc","CDF"));
        list.add(new CurrencyRate("Eritrean nakfa","ERN"));
        list.add(new CurrencyRate("Georgian lari","GEL"));
        list.add(new CurrencyRate("Malagasy ariary","MGA"));
        list.add(new CurrencyRate("Mozambican metical","MZN"));
        list.add(new CurrencyRate("Serbian dinar","RSD"));
        list.add(new CurrencyRate("Surinamese dollar","SRD"));
        list.add(new CurrencyRate("Tajikistani somoni","TJS"));
        list.add(new CurrencyRate("Turkmenistan manat","TMT"));
        list.add(new CurrencyRate("Zambian kwacha","ZMW"));
        spinnerSetup();
        btnCurrency = (Button)findViewById(R.id.btnCurrency);
        btnCurrency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinner1 = (Spinner)findViewById(R.id.spinner1);
                spinner2 = (Spinner)findViewById(R.id.spinner2);
                String id1 = list.get(spinner1.getSelectedItemPosition()).getId() ;
                String url = "https://"+ id1 +".fxexchangerate.com/rss.xml";
                System.out.println(url);
                new HttpAsync().execute(url);
            }
        });
    }
    private class HttpAsync extends AsyncTask<String,Void,String> {
        @Override
        protected String doInBackground(String... params) {
            StringBuilder content = new StringBuilder();
            try {
                URL url = new URL(params[0]);
                InputStreamReader inputStream = new InputStreamReader(url.openConnection().getInputStream());
                BufferedReader bf = new BufferedReader(inputStream);
                String line="";
                while ((line= bf.readLine()) !=null){
                    content.append(line);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return content.toString();
        }
        @Override
        protected void onPostExecute(String s){
            super.onPostExecute(s);
            // create new exchange object
            Exchange exchange = new Exchange();
            //get all doc
            Document document = exchange.getDocument(s);
            //find value currency
            NodeList nodes = document.getElementsByTagName("item");
            String l=null;
            spinner1 = (Spinner)findViewById(R.id.spinner1);
            spinner2 = (Spinner)findViewById(R.id.spinner2);
            String id1= list.get(spinner1.getSelectedItemPosition()).getId();
            String currency1= list.get(spinner1.getSelectedItemPosition()).getCurrency();
            String id2= list.get(spinner2.getSelectedItemPosition()).getId();
            String currency2= list.get(spinner2.getSelectedItemPosition()).getCurrency();
            String descrip= currency1+"("+id1+")/"+currency2+"("+id2+")";
            for(int i=0;i < nodes.getLength();i++) {
                Element e = (Element) nodes.item(i);
                String title = exchange.getValue(e, "title");
                if (title.equals(descrip)) {
                    currencyConvert(exchange.getValue(e, "description"));
                }
            }
        }
    }
    private void spinnerSetup(){
        spinner1 = (Spinner)findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        MyListAdaterView adapter = new MyListAdaterView(MainActivity.this,R.layout.list_item,list);
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView t1 = (TextView)findViewById(R.id.t1);
                t1.setText(list.get(position).getId());


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
            spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    TextView t2 = (TextView)findViewById(R.id.t2);
                    t2.setText(list.get(position).getId());
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });


    }
    public void currencyConvert(String s1) {
        editText = (EditText)findViewById(R.id.editText);
        value = (TextView)findViewById(R.id.textView1);

        String currency = String.valueOf(editText.getText());
        if(!currency.equals("")){
            String[] string1 =s1.split("=");
            String[] string2 =string1[1].split(" ");
            System.out.println(Double.valueOf(currency));
            System.out.println(Double.valueOf(string2[1]));
            double newCurrency = Double.valueOf(string2[1])*Double.valueOf(currency);
            System.out.println(newCurrency );
            value.setText(String.format("%,.2f",newCurrency));
        }
    }


    }