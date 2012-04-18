package team.pfm.com;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class headingGsWcaActivity extends Activity {
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // call the superclass version
        setContentView(R.layout.calc_heading_gspeed_wcangle_activity); // set the layout
        
        //Spinner objects for True Airspeed and Wind Speed
        Spinner trueAirspeedSpinner =(Spinner)findViewById(R.id.true_airspeed_unit_spinner);
        Spinner windSpeedSpinner = (Spinner)findViewById(R.id.wind_speed_unit_spinner);
        // array adaptor for speed units
        ArrayAdapter<CharSequence> speedAdapter = ArrayAdapter.createFromResource(this, R.array.speedValues, android.R.layout.simple_spinner_item);
        speedAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Displays the string array for the spinners
        trueAirspeedSpinner.setAdapter(speedAdapter);
        windSpeedSpinner.setAdapter(speedAdapter);
        
        
        
	}
	
	public void calculate(View view) {
        //Edit Textbox Objects
        EditText trueAirspeedTextBox = (EditText) findViewById(R.id.input_true_airspeed);
        EditText windSpeedTextBox = (EditText) findViewById(R.id.input_wind_speed);
        EditText windDirectionTextBox = (EditText) findViewById(R.id.input_wind_direction);
        EditText courseTextBox = (EditText)findViewById(R.id.input_course);
        EditText headingTextBox = (EditText)findViewById(R.id.output_heading);
        EditText groundSpeedTextBox = (EditText)findViewById(R.id.output_gspeed);
        EditText windCorrectionTextBox = (EditText)findViewById(R.id.output_wcangle);
        
        //variables for inputs
        double tairspeed = 0;
        double wspeed = 0;
        int wdirection = 0;
        int course = 0;
        double heading = 0;
        double gspeed = 0;
        double wcorrection = 0;
        //Get values from input boxes
        tairspeed = Double.parseDouble(trueAirspeedTextBox.getText().toString().trim());
        wspeed = Double.parseDouble(windSpeedTextBox.getText().toString().trim());
        wdirection = Integer.parseInt(windDirectionTextBox.getText().toString().trim());
        course = Integer.parseInt(courseTextBox.getText().toString().trim());
        
        Checks check = new Checks();
        //Check for valid inputs and then get the heading, ground speed, and wind correction
        if(check.isDegValid(wdirection) && check.isDegValid(course)) {
        		heading = Calculation.calcHead(wspeed, wdirection, course, tairspeed);
        		headingTextBox.setText(String.valueOf(heading));
        		
        		gspeed = Calculation.calcGroSpeed(wspeed, wdirection, course, tairspeed);
        		groundSpeedTextBox.setText(String.valueOf(gspeed));
        		
        		wcorrection = Calculation.calcCorAng(wspeed, wdirection, tairspeed, course);
        		windCorrectionTextBox.setText(String.valueOf(wcorrection));
        }
        else {
        	
        }
	}
}
