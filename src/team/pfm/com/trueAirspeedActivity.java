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

public class trueAirspeedActivity extends Activity {

	String indicatedAirspeedSelected;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState); // call the superclass version
		setContentView(R.layout.calc_true_airspeed); // set the layout

		//Spinner objects for True Airspeed and Wind Speed
		Spinner indicatedAirspeedSpinner =(Spinner)findViewById(R.id.indicated_airspeed_unit_spinner);

		// array adaptor for speed units
		ArrayAdapter<CharSequence> speedAdapter = ArrayAdapter.createFromResource(this, R.array.speedValues, android.R.layout.simple_spinner_item);
		speedAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		//Displays the string array for the spinners
		indicatedAirspeedSpinner.setAdapter(speedAdapter);

		indicatedAirspeedSpinner.setOnItemSelectedListener(new indicatedAirspeedSelectedListener());
	}

	public void calculate(View view) {
		//Edit Textbox Objects
		EditText indicatedAirspeedTextBox = (EditText) findViewById(R.id.input_indicated_airspeed);
		EditText mslAltTextBox = (EditText) findViewById(R.id.input_mean_sea_level_altitude);
		EditText trueAirspeedTextBox = (EditText)findViewById(R.id.output_true_airspeed);

		//variables
		double indicatedAirspeed = 0;
		double mslAlt = 0;
		double trueAirspeed = 0;

		//Get values from input boxes
		try{
			indicatedAirspeed = Double.parseDouble(indicatedAirspeedTextBox.getText().toString().trim());
		} catch (Exception e) {
			Toast.makeText(getApplicationContext(), "Please enter a valid number in the airspeed!", 5).show();
		}

		try{
			mslAlt = Double.parseDouble(mslAltTextBox.getText().toString().trim());
		} catch (Exception e) {
			Toast.makeText(getApplicationContext(), "Please enter a valid number in the Mean Sea Level Altitude!", 5).show();
		}
		
		Speed speed = new Speed();

		if(indicatedAirspeedSelected.equalsIgnoreCase("MPH")) {
			mslAlt = speed.mphToKnots(mslAlt);
		}
		else if(indicatedAirspeedSelected.equalsIgnoreCase("KPH")) {
			mslAlt = speed.kmhToKnots(mslAlt);
		}
		
		trueAirspeed = Calculation.calcTrueAsp(mslAlt, indicatedAirspeed);
		trueAirspeedTextBox.setText(String.format("%.2f",trueAirspeed));

	}

	public class indicatedAirspeedSelectedListener implements OnItemSelectedListener {

		public void onItemSelected(AdapterView<?> parent, View view, int pos,
				long id) {
			indicatedAirspeedSelected = parent.getItemAtPosition(pos).toString();
		}

		public void onNothingSelected(AdapterView<?> arg0) {

		}

	}
}
