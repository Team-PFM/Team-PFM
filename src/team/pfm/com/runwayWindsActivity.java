package team.pfm.com;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class runwayWindsActivity extends Activity {
	String windSpeedSelected;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState); // call the superclass version
		setContentView(R.layout.calc_runway_winds_activity); // set the layout

		//Spinner objects for True Airspeed and Wind Speed
		Spinner windSpeedSpinner =(Spinner)findViewById(R.id.wind_speed_unit_spinner);
		// array adaptor for speed units
		ArrayAdapter<CharSequence> speedAdapter = ArrayAdapter.createFromResource(this, R.array.speedValues, android.R.layout.simple_spinner_item);
		speedAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		//Displays the string array for the spinners
		windSpeedSpinner.setAdapter(speedAdapter);

		windSpeedSpinner.setOnItemSelectedListener(new windSpeedSelectedListener());
	}

	public void calculate(View view) {
		//edit text box objects
		EditText runwayDirectionTextBox = (EditText) findViewById(R.id.input_runway_direction);
		EditText windDirectionTextBox = (EditText) findViewById(R.id.input_wind_direction);
		EditText windSpeedTextBox = (EditText) findViewById(R.id.input_wind_speed);
		EditText crosswindTextBox = (EditText)findViewById(R.id.output_crosswind);
		EditText headwindTextBox = (EditText)findViewById(R.id.output_headwind);

		//variables for inputs
		double rdirection = 0;
		double wspeed = 0;
		double wdirection = 0;
		double crosswind = 0;
		double headwind = 0;
		double[] runwayWinds = new double[2];
		
		//get inputs
		try{
			rdirection = Double.parseDouble(runwayDirectionTextBox.getText().toString().trim());
		} catch (Exception e) {
			Toast.makeText(getApplicationContext(), "Please enter a valid number in the runway direction!", 5).show();
		}

		try{
			wspeed = Double.parseDouble(windSpeedTextBox.getText().toString().trim());
		} catch (Exception e) {
			Toast.makeText(getApplicationContext(), "Please enter a valid number in the wind speed!", 5).show();
		}

		try { 
			wdirection = Double.parseDouble(windDirectionTextBox.getText().toString().trim());
		} catch (Exception e) {
			Toast.makeText(getApplicationContext(), "Please enter a valid number in wind direction!", 5).show();
		}
		
		Checks checks = new Checks();
		Speed speed = new Speed();
		
		if(windSpeedSelected.equalsIgnoreCase("MPH")) {
			wspeed = speed.mphToKnots(wspeed);
		}
		else if(windSpeedSelected.equalsIgnoreCase("KPH")) {
			wspeed = speed.kmhToKnots(wspeed);
		}
		
		if(checks.isDegValid(rdirection) && checks.isDegValid(wdirection)) {
			runwayWinds = Calculation.calcRunWinds(wspeed, wdirection, rdirection);
			crosswind = runwayWinds[0];
			headwind = runwayWinds[1];
			
			crosswindTextBox.setText(String.format("%.2f", crosswind));
			headwindTextBox.setText(String.format("%.2f", headwind));
		}
		else {
			Toast.makeText(getApplicationContext(), "Please make sure the heading is between 0-360, and the course is between 0-360!", 5).show();
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
