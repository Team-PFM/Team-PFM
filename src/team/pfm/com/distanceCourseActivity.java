package team.pfm.com;

import java.util.ArrayList;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

public class distanceCourseActivity extends Activity {
	String[] ids ;
	Spinner airportOne;
	Spinner airportTwo;
	Spinner distanceUnits;
	String airportOneChoice;
	String airportTwoChoice;
	String distanceUnitChoice;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState); // call the superclass version
		setContentView(R.layout.flyingdistancecoursepage); // set the layout

		//get list of ids from database class
		ArrayList<?> idArray = FPCDatabase.getAirID();  //returning the array list from database class to then get values
		ids = new String[idArray.size()];
		for(int i = 0;i<idArray.size();i++){
			ids[i] = (String) idArray.get(i);  //taking every id from the arraylist in the database and adding it to the string array ids
		}

		//Creating adapter with the string array ids and adding it to spinner
		ArrayAdapter<String> adapterAirports = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,ids);
		ArrayAdapter<CharSequence> adapterUnits = ArrayAdapter.createFromResource(this,R.array.distance_units,android.R.layout.simple_spinner_item);
		airportOne = (Spinner)findViewById(R.id.flyingdistancecourseDepartingAirportSpinner);
		airportTwo = (Spinner)findViewById(R.id.flyingdistanceDestinationAirportSpinner);
		distanceUnits = (Spinner)findViewById(R.id.flyingdistancecourseDistanceUnitSpinner);

		//Displays the string array for the spinners
		airportOne.setAdapter(adapterAirports);
		airportTwo.setAdapter(adapterAirports);
		distanceUnits.setAdapter(adapterUnits);

		airportOne.setOnItemSelectedListener(new airportOneSelectedListener());
		airportTwo.setOnItemSelectedListener(new airportTwoSelectedListener());
		distanceUnits.setOnItemSelectedListener(new distanceUnitSelectedListener());
	}

	public void calculate(View view) {
		EditText flyingDistanceTextBox = (EditText) findViewById(R.id.flyingdistancecourseFlyingDistanceOutput);
		EditText courseTextBox = (EditText) findViewById(R.id.flyingdistancecourseCourse_2);
		
		double flyingDistance = 0;
		double course = 0;
		Distance d = new Distance();
		flyingDistance = Calculation.calcFlyDis(airportOneChoice, airportTwoChoice);
		course = Calculation.calcCourBwAir(airportOneChoice, airportTwoChoice);
		
		if(distanceUnitChoice.equalsIgnoreCase("SM")) {
			flyingDistance = d.kilomToStat(flyingDistance);
			flyingDistanceTextBox.setText((String.format("%.2f", flyingDistance)));
		}
		else if(distanceUnitChoice.equalsIgnoreCase("NM")) {
			flyingDistance = d.kilomToNaut(flyingDistance);
			flyingDistanceTextBox.setText((String.format("%.2f", flyingDistance)));
		}
		else {
			flyingDistanceTextBox.setText((String.format("%.2f", flyingDistance)));
		}
		
		courseTextBox.setText(String.format("%.2f", course));
	}
	
	public class airportOneSelectedListener implements OnItemSelectedListener {

		public void onItemSelected(AdapterView<?> parent, View view, int pos,
				long id) {
			airportOneChoice = parent.getItemAtPosition(pos).toString();
		}

		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub

		}

	}
	
	public class distanceUnitSelectedListener implements OnItemSelectedListener {

		public void onItemSelected(AdapterView<?> parent, View view, int pos,
				long id) {
			distanceUnitChoice = parent.getItemAtPosition(pos).toString();
		}

		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub

		}

	}
	
	public class airportTwoSelectedListener implements OnItemSelectedListener {

		public void onItemSelected(AdapterView<?> parent, View view, int pos,
				long id) {
			airportTwoChoice = parent.getItemAtPosition(pos).toString();
		}

		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub

		}

	}
}
