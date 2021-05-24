package com.example.exchangecurrency;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyListAdaterView extends BaseAdapter {
    Context context;
    int resources;
    LayoutInflater inflater;
    ArrayList<CurrencyRate> list;
    public  MyListAdaterView(Context context, int resources, ArrayList<CurrencyRate> list){
        this.context = context;
        this.list=list;
        this.resources=resources;
        inflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public Object getItem(int position) {

        return position;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public long getItemId(int position) {

        return position;
    }
    public View getView(int position, View convertView, ViewGroup parent){
        View dataView=convertView;
        if(dataView == null){
            dataView =  inflater.inflate(R.layout.list_item,parent,false);
        }

        ((TextView)dataView.findViewById(R.id.text1)).setText(list.get(position).getCurrency());
        ((TextView)dataView.findViewById(R.id.text2)).setText(list.get(position).getId());
        return  dataView;
    }
}
