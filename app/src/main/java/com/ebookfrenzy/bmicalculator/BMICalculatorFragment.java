package com.ebookfrenzy.bmicalculator;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ebookfrenzy.bmicalculator.BMI.CalculateBMI;
import com.ebookfrenzy.bmicalculator.BMI.Bmidatatable;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BMICalculatorFragment extends Fragment {

    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    Date date = new Date();

        TextView lblBMI;
        Button btnCalculate;
        TextView txtHeightFeet;
        TextView txtWeight;
        ImageView imgbmi;

        CalculateBMI calculateBMI;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_bmicalculator,container,false);
            btnCalculate = (Button) v.findViewById(R.id.btnCalculate);
            lblBMI = (TextView) v.findViewById(R.id.lblBMI);
            txtHeightFeet = (TextView) v.findViewById(R.id.txtFeet);
            txtWeight = (TextView) v.findViewById(R.id.txtWeight);
            imgbmi = (ImageView) v.findViewById(R.id.imgbmi);

            btnCalculate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    try {
                        Double txthfeet = Double.parseDouble(txtHeightFeet.getText().toString());
                        Double txtweight = Double.parseDouble(txtWeight.getText().toString());

                        calculateBMI = new CalculateBMI(txthfeet, txtweight);
                        double bmi = calculateBMI.camlculatebmi(calculateBMI.getInputkg(),calculateBMI.getInputfeet());

                        String bmitype = calculateBMI.getbmitype(bmi);
                        String dat2e = formatter.format(date);

                        Bmidatatable bmidatatable = new Bmidatatable(getActivity());
                        bmidatatable.openDB();
                        bmidatatable.insertRecord(dat2e,Double.toString(bmi),bmitype);
                        bmidatatable.closeDB();

                        Toast.makeText(getActivity(),"Your BMI" + bmi +" " + bmitype,Toast.LENGTH_SHORT).show();

                        lblBMI.setText("Your BMI is "+bmi);
                        switch (bmitype)
                        {
                            case  "Underweight" :
                                imgbmi.setImageResource(R.drawable.underweight);
                                break;

                            case  "Normal Weight" :
                                imgbmi.setImageResource(R.drawable.normal);
                                break;

                            case "Over Weight"   :
                                imgbmi.setImageResource(R.drawable.overweight);
                                break;

                            case  "Obesity" :
                                imgbmi.setImageResource(R.drawable.obese);
                                break;

                            case "Extremely Obesity":
                                imgbmi.setImageResource(R.drawable.extremelyobese);
                                break;

                             default:
                                 imgbmi.setImageResource(R.drawable.maxresdefault);
                                 break;
                        }

                    }
                    catch (Exception x)
                    {
                        Toast.makeText(getActivity(),"Enter Valid Input" + x,Toast.LENGTH_SHORT).show();

                    }

                }
            });
            return v;
    }}