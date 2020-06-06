package com.example.bmikotlin

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet


class CovidChartActivit : AppCompatActivity() {

    lateinit var lineChart: LineChart
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_covid_chart)

        lineChart = findViewById(R.id.line_chart)
        val vl1 = LineDataSet(dataValue1(), "Zachorowalność");
        val vl2 = LineDataSet(dataValue2(), "Śmiertelność");
        val vl3 = LineDataSet(dataValue3(), "Wyleczenia");

        setChartStyle(vl1, vl2, vl3)

        val datasets =  ArrayList<ILineDataSet>()
        datasets.add(vl1)
        datasets.add(vl2)
        datasets.add(vl3)

        val data = LineData(datasets)
        lineChart.data=data
        lineChart.xAxis.labelRotationAngle = 0f
        lineChart.axisRight.isEnabled = false
        lineChart.setTouchEnabled(true)
        lineChart.setPinchZoom(true)
        lineChart.description.text = "Days"
        lineChart.setNoDataText("No forex yet!")
        lineChart.animateX(1800, Easing.EaseInExpo)
    }

    fun setChartStyle(vl1: LineDataSet, vl2: LineDataSet, vl3: LineDataSet){

        vl1.setColor(Color.RED)
        vl1.setDrawValues(false)
        vl1.setDrawFilled(true)
        vl1.lineWidth = 3f
        vl2.setColor(Color.GREEN)
        vl2.setDrawValues(false)
        vl2.setDrawFilled(true)
        vl2.lineWidth = 3f
        vl3.setColor(Color.BLACK)
        vl3.setDrawValues(false)
        vl3.setDrawFilled(true)
        vl3.lineWidth = 3f
    }

    fun dataValue1() : ArrayList<Entry>{
        val dataVal = ArrayList<Entry>()
        dataVal.add(Entry(0F,0F))
        dataVal.add(Entry(1F, 1F))
        dataVal.add(Entry(2F, 2F))
        dataVal.add(Entry(3F, 5F))
        dataVal.add(Entry(4F, 15F))
        dataVal.add(Entry(5F, 30F))
        dataVal.add(Entry(6F, 50F))
        dataVal.add(Entry(7F, 90F))
        dataVal.add(Entry(9F, 250F))
        dataVal.add(Entry(10F, 1000F))

        return dataVal
    }

    fun dataValue2(): ArrayList<Entry>? {
        val dataVal = ArrayList<Entry>()
        dataVal.add(Entry(0F, 0F))
        dataVal.add(Entry(1F, 0F))
        dataVal.add(Entry(2F, 0F))
        dataVal.add(Entry(3F, 0F))
        dataVal.add(Entry(4F, 1F))
        dataVal.add(Entry(5F, 3F))
        dataVal.add(Entry(6F, 6F))
        dataVal.add(Entry(7F, 9F))
        dataVal.add(Entry(9F, 25F))
        dataVal.add(Entry(10F, 103F))
        return dataVal
    }

     fun dataValue3():ArrayList<Entry>? {
        val dataVal = ArrayList<Entry>()
        dataVal.add(Entry(0F, 0F))
        dataVal.add(Entry(1F, 0F))
        dataVal.add(Entry(2F, 0F))
        dataVal.add(Entry(3F, 0F))
        dataVal.add(Entry(4F, 0F))
        dataVal.add(Entry(5F, 3F))
        dataVal.add(Entry(6F, 8F))
        dataVal.add(Entry(7F, 69F))
        dataVal.add(Entry(9F, 210F))
        dataVal.add(Entry(10F, 480F))
        return dataVal
    }
}
