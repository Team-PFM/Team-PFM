package team.pfm.com;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class headingGsWcaActivity extends Activity {
	
	private String trueAirspeedSelected;
	private String windSpeedSelected;
	
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
        
        trueAirspeedSpinner.setOnItemSelectedListener(new trueAirspeedSelectedListener());
        windSpeedSpinner.setOnItemSelectedListener(new windSpeedSelectedListener());
        
        
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
        double wdirection = 0;
        double course = 0;
        double heading = 0;
        double gspeed = 0;
        double wcorrection = 0;
        //Get values from input boxes
        try{
        tairspeed = Double.parseDouble(trueAirspeedTextBox.getText().toString().trim());
        } catch (Exception e) {
        	Toast.makeText(getApplicationContext(), "Please enter a valid number in the airspeed!", 5).show();
        }
        
        try{
        wspeed = Double.parseDouble(windSpeedTextBox.getText().toString().trim());
        } catch (Exception e) {
        	Toast.makeText(getApplicationContext(), "Please enter a valid number in the wind speed!", 5).show();
        }
        
        try { 
        wdirection = Double.parseDouble(windDirectionTextBox.getText().toString().trim());
        } catch (Exception e) {
        	Toast.makeText(getApplicationContext(), "Please enter a valid number in the wind direction!", 5).show();
        }
        
        try {
        course = Double.parseDouble(courseTextBox.getText().toString().trim());
        } catch (Exception e) {
        	Toast.makeText(getApplicationContext(), "Please enter a valid number in the course!", 5).show();
        }
        
        Checks check = new Checks();
        Speed speed = new Speed();
        
        if(windSpeedSelected.equalsIgnoreCase("MPH")) {
        	wspeed = speed.mphToKnots(wspeed);
        }
        else if(windSpeedSelected.equalsIgnoreCase("KPH")) {
        	wspeed = speed.kmhToKnots(wspeed);
        }
        
        if(trueAirspeedSelected.equalsIgnoreCase("MPH")) {
        	tairspeed = speed.mphToKnots(tairspeed);
        }
        else if(trueAirspeedSelected.equalsIgnoreCase("KPH")) {
        	tairspeed = speed.kmhToKnots(tairspeed);
        }
        //Check for valid inputs and then get the heading, ground speed, and wind correction
        if(check.isDegValid(wdirection) && check.isDegValid(course)) {
        		heading = Calculation.calcHead(wspeed, wdirection, course, tairspeed);
        		headingTextBox.setText(String.format("%.2f", heading));
        		
        		gspeed = Calculation.calcGroSpeed(wspeed, wdirection, course, tairspeed);
        		groundSpeedTextBox.setText(String.format("%.2f", gspeed));
        		
        		wcorrection = Calculation.calcCorAng(wspeed, wdirection, tairspeed, course);
        		windCorrectionTextBox.setText(String.format("%.2f", wcorrection));
        }
        else {
        	Toast.makeText(getApplicationContext(), "Please make sure the wind direction is between 0-360, and the course is between 0-360!", 5).show();
        }
	}
	public class trueAirspeedSelectedListener implements OnItemSelectedListener {

		public void onItemSelected(AdapterView<?> parent, View view, int pos,
				long id) {
			trueAirspeedSelected = parent.getItemAtPosition(pos).toString();
		}

		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public class windSpeedSelectedListener implements OnItemSelectedListener {

		public void onItemSelected(AdapterView<?> parent, View view, int pos,
				long id) {
			windSpeedSelected = parent.getItemAtPosition(pos).toString();
		}

		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
}


