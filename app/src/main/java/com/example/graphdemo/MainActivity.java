package com.example.graphdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.view.LineChartView;

public class MainActivity extends AppCompatActivity {

    LineChartView lineChartView;
    List yAxisValues;
    List axisValues;
    List lines;
    LineChartData data;
    Axis axis;
    Axis yAxis;
    Viewport viewport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lineChartView = findViewById(R.id.chart);

        // X Axis Data:
        String[] axisData = {"Jan", "Feb", "Mar", "Apr", "May", "June",
                "July", "Aug", "Sept", "Oct", "Nov", "Dec"};

        // Y Axis Data:
        int[] yAxisData = {50, 20, 15, 30, 20, 60, 15, 40, 45, 10, 90, 18};

        // These lists will be used to hold the data for Axis and Y-Axis.
        yAxisValues = new ArrayList();
        axisValues = new ArrayList();

        // This line will hold the values of Y-Axis.
        Line line = new Line(yAxisValues).setColor(Color.parseColor("#9C27B0"));

        // Set Line Thickness
        line.setStrokeWidth(3);

        // Set whether Line has labels
        line.setHasLabels(true);

        // Set whether line has points shown
        line.setHasPoints(true);

        // Set point radius
        line.setPointRadius(4);

        // Add Axis and Y-Axis data inside yAxisValues and axisValues lists
        for (int i = 0; i < axisData.length; i++)
        {
            axisValues.add(i, new AxisValue(i).setLabel(axisData[i]));
        }
        for (int i = 0; i < yAxisData.length; i++)
        {
            yAxisValues.add(new PointValue(i, yAxisData[i]));
        }

        // Declare a list of a type Line
        lines = new ArrayList();
        lines.add(line);
        // This list will hold the line of the graph chart

        // Add the graph line to the overall data chart
        data = new LineChartData();
        data.setLines(lines);

        // Add the following code to be able to see the Android line chart
        lineChartView.setLineChartData(data);

        // Build and run the app to see the output

        // The only thing missing is the Axis and Y-Axis values
        // Getting the Axis values to show up in the line chart graph
        axis = new Axis();
        axis.setValues(axisValues);
        data.setAxisXBottom(axis);
        // Declared Axis model, then you've initialize it with axisValues data and finally you set axis data to be positioned at the bottom

        // Build and run the app to see the result

        yAxis = new Axis();
        data.setAxisYLeft(yAxis);

        // Set the text size of the Axis data
        axis.setTextSize(16);
        yAxis.setTextSize(16);

        // Set the text colour of the Axis data
        axis.setTextColor(Color.parseColor("#03A9F4"));
        yAxis.setTextColor(Color.parseColor("#03A9F4"));

        // Add a label that describe the type of data this line chart
        yAxis.setName("Sales in millions");
        axis.setName("Months");

        // If you had noticed that Y-Axis data inside the line chart doesn't show it's full data based
        // on what you initialized in the beginning. You can fix it by adding the following code
        viewport = new Viewport(lineChartView.getMaximumViewport());
        viewport.top = 110;
        lineChartView.setMaximumViewport(viewport);
        lineChartView.setCurrentViewport(viewport);

    }
}