package com.example.bmicalculator.chart;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.example.bmicalculator.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

public class CovidChartActivity extends AppCompatActivity {

    LineChart lineChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid_chart);

        lineChart= findViewById(R.id.line_chart);
        LineDataSet lineDataSet1 = new LineDataSet(dataValue1(), "Zachorowalność");
        LineDataSet lineDataSet2 = new LineDataSet(dataValue2(), "Śmiertelność");
        LineDataSet lineDataSet3 = new LineDataSet(dataValue3(), "Wyleczenia");

        setChartStyle(lineDataSet1, lineDataSet2, lineDataSet3);




        ArrayList<ILineDataSet> dataSets = new ArrayList<>();

        dataSets.add(lineDataSet1);
        dataSets.add(lineDataSet2);
        dataSets.add(lineDataSet3);

        LineData data = new LineData(dataSets);

        lineChart.setData(data);
        lineChart.invalidate();
    }

    private void setChartStyle(LineDataSet lineDataSet1, LineDataSet lineDataSet2, LineDataSet lineDataSet3) {
        lineChart.setBackgroundColor(Color.LTGRAY);
        lineDataSet1.setColor(Color.RED);
        lineDataSet2.setColor(Color.BLACK);
        lineDataSet3.setColor(Color.GREEN);
        lineChart.setDrawBorders(true);

        lineDataSet1.setDrawCircles(true);
        lineDataSet1.setLineWidth(2);
        lineDataSet1.setCircleColor(Color.RED);
        lineDataSet1.setCircleRadius(4);
        lineDataSet1.setValueTextSize(15);
        lineDataSet1.setValueTextColor(Color.RED);


        lineDataSet2.setCircleColor(Color.BLACK);
        lineDataSet2.setCircleRadius(4);
        lineDataSet2.setLineWidth(2);
        lineDataSet2.setValueTextSize(15);
        lineDataSet2.setValueTextColor(Color.BLACK);

        lineDataSet3.setCircleColor(Color.GREEN);
        lineDataSet3.setCircleRadius(4);
        lineDataSet3.setLineWidth(2);
        lineDataSet3.setValueTextSize(15);
        lineDataSet3.setValueTextColor(Color.GREEN);


        Description description = new Description();
        description.setText("Koronawirus w polsce");
        description.setTextColor(Color.RED);
        description.setTextSize(20);
        lineChart.setDescription(description);

        lineChart.animateXY(10000,2000);
    }

    private ArrayList<Entry> dataValue1(){
        ArrayList<Entry> dataVal=new ArrayList<>();
        dataVal.add(new Entry(0,0));
        dataVal.add(new Entry(1,1));
        dataVal.add(new Entry(2,2));
        dataVal.add(new Entry(3,5));
        dataVal.add(new Entry(4,15));
        dataVal.add(new Entry(5,30));
        dataVal.add(new Entry(6,50));
        dataVal.add(new Entry(7,90));
        dataVal.add(new Entry(9,250));
        dataVal.add(new Entry(10,1000));

        return dataVal;
    }

    private ArrayList<Entry> dataValue2(){
        ArrayList<Entry> dataVal=new ArrayList<>();
        dataVal.add(new Entry(0,0));
        dataVal.add(new Entry(1,0));
        dataVal.add(new Entry(2,0));
        dataVal.add(new Entry(3,0));
        dataVal.add(new Entry(4,1));
        dataVal.add(new Entry(5,3));
        dataVal.add(new Entry(6,6));
        dataVal.add(new Entry(7,9));
        dataVal.add(new Entry(9,25));
        dataVal.add(new Entry(10,103));

        return dataVal;
    }

    private ArrayList<Entry> dataValue3(){
        ArrayList<Entry> dataVal=new ArrayList<>();
        dataVal.add(new Entry(0,0));
        dataVal.add(new Entry(1,0));
        dataVal.add(new Entry(2,0));
        dataVal.add(new Entry(3,0));
        dataVal.add(new Entry(4,0));
        dataVal.add(new Entry(5,3));
        dataVal.add(new Entry(6,8));
        dataVal.add(new Entry(7,69));
        dataVal.add(new Entry(9,210));
        dataVal.add(new Entry(10,480));

        return dataVal;
    }

}
