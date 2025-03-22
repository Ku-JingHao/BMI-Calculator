package com.ebookfrenzy.bmicalculator.BMI;

public class CalculateBMI {

    private double inputfeet;
    private double inputkg;

    public CalculateBMI(double inputfeet, double inputkg)
    {
        this.inputfeet = inputfeet;
        this.inputkg = inputkg;
    }

    public double getInputfeet() {
        return inputfeet;
    }

    public double getInputkg() {
        return inputkg;
    }

    public double camlculatebmi(double inputkg, double inputfeet)
    {
        double result = 0;

        double txtheightm = ( inputfeet /100 );

        result = inputkg/(txtheightm*txtheightm);

        result = (double) Math.round(result * 100) / 100;

        return result;
    }

    public String getbmitype(double bmi)
    {
        String type = "null";

        if (bmi<=18.5)
        {
            type = "Underweight";
        }
        else if (bmi<=24.9)
        {
            type = "Normal Weight";
        }
        else if (bmi<=29.9)
        {
            type = "Over Weight";
        }
        else if (bmi<=34.9)
        {
            type = "Obesity";
        }
        else if (bmi>35)
        {
            type = "Extremely Obesity";
        }

        return type;

    }
}
