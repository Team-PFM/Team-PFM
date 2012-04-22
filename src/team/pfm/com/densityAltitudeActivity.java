package team.pfm.com;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class densityAltitudeActivity extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState); // call the superclass version
		setContentView(R.layout.densityaltitudepage); // set the layout
	}

	public void calculate(View view) {

		//Edit Text objects
		EditText pressureAltTextBox = (EditText) findViewById(R.id.densityaltitudePressureAltitudeInput);
		EditText outsideAirTempTextBox = (EditText) findViewById(R.id.densityaltitudeOutsideAirTempInput);
		EditText densityAltTextBox = (EditText) findViewById(R.id.densityaltitudeDensityAltitudeOutput);

		//variables
		double pAlt=0;
		double outAir=0;
		double densAlt = 0;

		//Get values from input boxes
		try{
			pAlt = Double.parseDouble(pressureAltTextBox.getText().toString().trim());
		} catch (Exception e) {
			Toast.makeText(getApplicationContext(), "Please enter a valid number in the pressure Altitude!", 5).show();
		}

		try{
			outAir = Double.parseDouble(outsideAirTempTextBox.getText().toString().trim());
		} catch (Exception e) {
			Toast.makeText(getApplicationContext(), "Please enter a valid number in the outside air temperature!", 5).show();
		}
		
		//Calculate densityAlt
		densAlt = Calculation.calcDensAlt(outAir, pAlt);
		
		//display answer
		densityAltTextBox.setText(String.format("%.2f", densAlt));
	}
}
