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

public class wSpeedAndDirectionActivity extends Activity {
	private String trueAirspeedSelected;
	private String groundSpeedSelected;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState); // call the superclass version
		setContentView(R.layout.windspeeddirectionpage); // set the layout

		//Spinner objects for True Airspeed and Wind Speed
		Spinner trueAirspeedSpinner =(Spinner)findViewById(R.id.windspeeddirectionTrueSpeedSpinner);
		Spinner groundSpeedSpinner = (Spinner)findViewById(R.id.windspeeddirectionGroundSpeedSpinner);
		// array adaptor for speed units
		ArrayAdapter<CharSequence> speedAdapter = ArrayAdapter.createFromResource(this, R.array.speedValues, android.R.layout.simple_spinner_item);
		speedAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		//Displays the string array for the spinners
		trueAirspeedSpinner.setAdapter(speedAdapter);
		groundSpeedSpinner.setAdapter(speedAdapter);

		trueAirspeedSpinner.setOnItemSelectedListener(new trueAirspeedSelectedListener());
		groundSpeedSpinner.setOnItemSelectedListener(new groundSpeedSelectedListener());
	}

	public void calculate(View view) {
		//Edit Textbox Objects
		EditText trueAirspeedTextBox = (EditText) findViewById(R.id.windspeeddirectionTrueSpeedInput);
		EditText windSpeedTextBox = (EditText) findViewById(R.id.windspeeddirectionWindSpeedOutput);
		EditText windDirectionTextBox = (EditText) findViewById(R.id.windspeeddirectionWindDirectionOutput);
		EditText courseTextBox = (EditText)findViewById(R.id.windspeeddirectionCourseInput);
		EditText headingTextBox = (EditText)findViewById(R.id.windspeeddirectionHeadingInput);
		EditText groundSpeedTextBox = (EditText)findViewById(R.id.windspeeddirectionGroundSpeedInput);

		//variables for inputs
		double tairspeed = 0;
		double wspeed = 0;
		double wdirection = 0;
		double course = 0;
		double heading = 0;
		double gspeed = 0;
		//Get values from input boxes
		try{
			tairspeed = Double.parseDouble(trueAirspeedTextBox.getText().toString().trim());
		} catch (Exception e) {
			Toast.makeText(getApplicationContext(), "Please enter a valid number in the airspeed!", 5).show();
		}

		try{
			gspeed = Double.parseDouble(groundSpeedTextBox.getText().toString().trim());
		} catch (Exception e) {
			Toast.makeText(getApplicationContext(), "Please enter a valid number in the ground speed!", 5).show();
		}

		try { 
			course = Double.parseDouble(courseTextBox.getText().toString().trim());
		} catch (Exception e) {
			Toast.makeText(getApplicationContext(), "Please enter a valid number in course!", 5).show();
		}

		try {
			heading = Double.parseDouble(headingTextBox.getText().toString().trim());
		} catch (Exception e) {
			Toast.makeText(getApplicationContext(), "Please enter a valid number in heading!", 5).show();
		}

		Checks check = new Checks();
		Speed speed = new Speed();

		if(groundSpeedSelected.equalsIgnoreCase("MPH")) {
			gspeed = speed.mphToKnots(gspeed);
		}
		else if(groundSpeedSelected.equalsIgnoreCase("KPH")) {
			gspeed = speed.kmhToKnots(gspeed);
		}

		if(trueAirspeedSelected.equalsIgnoreCase("MPH")) {
			tairspeed = speed.mphToKnots(tairspeed);
		}
		else if(trueAirspeedSelected.equalsIgnoreCase("KPH")) {
			tairspeed = speed.kmhToKnots(tairspeed);
		}
		//Check for valid inputs and then get the heading, ground speed, and wind correction
		if(check.isDegValid(course) && check.isDegValid(heading)) {
			wdirection = Calculation.calcWindDir(gspeed, tairspeed, course, heading);
			windDirectionTextBox.setText(String.format("%.2f", wdirection));

			wspeed = Calculation.calcWindSpe(gspeed, tairspeed, course, heading);
			windSpeedTextBox.setText(String.format("%.2f", wspeed));
		}
		else {
			Toast.makeText(getApplicationContext(), "Please make sure the heading is between 0-360, and the course is between 0-360!", 5).show();
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

	public class groundSpeedSelectedListener implements OnItemSelectedListener {

		public void onItemSelected(AdapterView<?> parent, View view, int pos,
				long id) {
			groundSpeedSelected = parent.getItemAtPosition(pos).toString();
		}

		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub

		}
	}
}
