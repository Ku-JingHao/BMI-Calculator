package com.ebookfrenzy.bmicalculator;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.ebookfrenzy.bmicalculator.BMI.Bmidatatable;

public class BMIHistory extends Fragment {
Bmidatatable bmidatatable;
Cursor cursor;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_report,container,false);

     try {

         bmidatatable = new Bmidatatable(getActivity());
         bmidatatable.openDB();
         cursor = bmidatatable.getAllRecords();

         ListView listhistory = (ListView) v.findViewById(R.id.listview);
         CustomAdapter customAdapter = new CustomAdapter();

         listhistory.setAdapter(customAdapter);

         bmidatatable.closeDB();
     }

     catch (Exception e)
     {
         Toast.makeText(getActivity(),e.toString(),Toast.LENGTH_SHORT).show();

     }

     return v;
    }

public class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return cursor.getCount() ;
        }

        @Override
        public Object getItem(int position) {
            return cursor;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.custom_layout,null);
            TextView txt_rowid = (TextView)  convertView.findViewById(R.id.txtrowid);
            TextView txt_bmidate = (TextView) convertView.findViewById(R.id.txtbmidate);
            TextView txt_bmivalue = (TextView) convertView.findViewById(R.id.txtbmivalue);
            TextView txt_bmitype = (TextView) convertView.findViewById(R.id.txtbmitype);

            cursor.moveToPosition(position);
            txt_rowid.setText(cursor.getString(0));
            txt_bmidate.setText(cursor.getString(1));
            txt_bmivalue.setText(cursor.getString(2));
            txt_bmitype.setText(cursor.getString(3));

            return convertView;
        }
    }
}


