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

public class conversionActivity extends Activity {
	//varaibles for the spinners
	private String converstionselected;
	private String inpuspinner;
	private String outspinner;
	ArrayAdapter<CharSequence> conAdapter;
	ArrayAdapter<CharSequence> speedAdapter;
	ArrayAdapter<CharSequence> distAdapter;
	ArrayAdapter<CharSequence> angleAdapter;
	ArrayAdapter<CharSequence> presAdapter;
	ArrayAdapter<CharSequence> tempAdapter;
	Spinner conversionsel;
	Spinner inpuconvers;
	Spinner oupuconvers;
	//edits the textboxes for degree minutes seconds
	EditText minute;
	EditText second;


	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // call the superclass version
        setContentView(R.layout.conversionspage); // set the layout
        //sets up the spinners and the text boxes for dms
        conversionsel = (Spinner) findViewById(R.id.conversionspageTypeofConversionsSpinner);
        inpuconvers = (Spinner) findViewById(R.id.conversionsInputUnitSpinner);
        oupuconvers = (Spinner) findViewById(R.id.conversionsOutputUnitSpinner);
    	minute = (EditText) findViewById(R.id.conversions_input_minutes);
    	second = (EditText) findViewById(R.id.conversions_input_seconds);
        
        conAdapter = ArrayAdapter.createFromResource(this, R.array.conversionvalues, android.R.layout.simple_spinner_item);
        conAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        speedAdapter = ArrayAdapter.createFromResource(this, R.array.speedValues, android.R.layout.simple_spinner_item);
        speedAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        presAdapter = ArrayAdapter.createFromResource(this, R.array.pressurevalues, android.R.layout.simple_spinner_item);
    	presAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    	distAdapter = ArrayAdapter.createFromResource(this, R.array.distance_units, android.R.layout.simple_spinner_item);
    	distAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    	angleAdapter = ArrayAdapter.createFromResource(this, R.array.angelsvalues, android.R.layout.simple_spinner_item);
    	angleAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    	tempAdapter = ArrayAdapter.createFromResource(this, R.array.tempvalues, android.R.layout.simple_spinner_item);
    	tempAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        conversionsel.setAdapter(conAdapter);
        conversionsel.setOnItemSelectedListener(new conversionSelectedListener());

       
        inpuconvers.setAdapter(speedAdapter);
        oupuconvers.setAdapter(speedAdapter);
           
        inpuconvers.setOnItemSelectedListener(new inputSelectedListener());
        oupuconvers.setOnItemSelectedListener(new outputSelectedListener());
    }
	public void conversion(View view){
		//allows text boxes to be edited
		EditText inputconverstion = (EditText) findViewById(R.id.conversions_input_main);
		EditText outputconverstion = (EditText) findViewById(R.id.conversions_output);
     
		double inpcon = 0;
		double oupcon = 0;
		double inpm = 0;
		double inps = 0;
		int[] outdms = new int [3]; 
		//gets values from text boxes
		try{
			inpcon = Double.parseDouble(inputconverstion.getText().toString().trim());
		} catch (Exception e) {
			Toast.makeText(getApplicationContext(), "Please enter a valid number in the conversion box!", 5).show();
		}
		try{
			inpm = Double.parseDouble(minute.getText().toString().trim());
		} catch (Exception e) {
			Toast.makeText(getApplicationContext(), "Please enter a valid number in the conversion box!", 5).show();
		}
		try{
			inps = Double.parseDouble(second.getText().toString().trim());
		} catch (Exception e) {
			Toast.makeText(getApplicationContext(), "Please enter a valid number in the conversion box!", 5).show();
		}
		
		Checks check = new Checks();
		Speed speed = new Speed();
		Angles angle = new Angles();
		Distance dist = new Distance();
		Pressure pres = new Pressure();
		Temp temp = new Temp();
		
		//checks to see if the input is valid then calculates the conversion for temperature
		if (converstionselected.equalsIgnoreCase("Temperature")){
			if(inpuspinner.equalsIgnoreCase("Cel") && outspinner.equalsIgnoreCase("Cel")){
				if(check.isTempValid(inpcon)){
					oupcon = temp.celToCel(inpcon);
					outputconverstion.setText(String.format("%.2f", oupcon));
				}else {
		        	Toast.makeText(getApplicationContext(), "Please make sure the tempeature is -50 or higher", 5).show();
		        }
			}
			else if((inpuspinner.equalsIgnoreCase("Cel") && outspinner.equalsIgnoreCase("Rank"))){
				if(check.isTempValid(inpcon)){
					oupcon = temp.celToRan(inpcon);
					outputconverstion.setText(String.format("%.2f", oupcon));
				}else {
		        	Toast.makeText(getApplicationContext(), "Please make sure the tempeature is -50 or higher", 5).show();
		        }
			}
			else if((inpuspinner.equalsIgnoreCase("Cel") && outspinner.equalsIgnoreCase("Fah"))){
				if(check.isTempValid(inpcon)){
					oupcon = temp.celToFah(inpcon);
					outputconverstion.setText(String.format("%.2f", oupcon));
				}else {
		        	Toast.makeText(getApplicationContext(), "Please make sure the tempeature is -50 or higher", 5).show();
		        }
			}
			else if((inpuspinner.equalsIgnoreCase("Cel") && outspinner.equalsIgnoreCase("Kev"))){
				if(check.isTempValid(inpcon)){
					oupcon = temp.celToKev(inpcon);
					outputconverstion.setText(String.format("%.2f", oupcon));
				}else {
		        	Toast.makeText(getApplicationContext(), "Please make sure the tempeature is -50 or higher", 5).show();
		        }
			}
			else if((inpuspinner.equalsIgnoreCase("Rank") && outspinner.equalsIgnoreCase("Rank"))){
				if(check.isTempValid(inpcon)){
					oupcon = temp.ranToRan(inpcon);
					outputconverstion.setText(String.format("%.2f", oupcon));
				}else {
		        	Toast.makeText(getApplicationContext(), "Please make sure the tempeature is -50 or higher", 5).show();
		        }
			}
			else if((inpuspinner.equalsIgnoreCase("Rank") && outspinner.equalsIgnoreCase("Fah"))){
				if(check.isTempValid(inpcon)){
					oupcon = temp.ranToFah(inpcon);
					outputconverstion.setText(String.format("%.2f", oupcon));
				}else {
		        	Toast.makeText(getApplicationContext(), "Please make sure the tempeature is -50 or higher", 5).show();
		        }
			}
			else if((inpuspinner.equalsIgnoreCase("Rank") && outspinner.equalsIgnoreCase("Kev"))){
				if(check.isTempValid(inpcon)){
					oupcon = temp.ranToKev(inpcon);
					outputconverstion.setText(String.format("%.2f", oupcon));
				}else {
		        	Toast.makeText(getApplicationContext(), "Please make sure the tempeature is -50 or higher", 5).show();
		        }
			}
			else if((inpuspinner.equalsIgnoreCase("Rank") && outspinner.equalsIgnoreCase("Cel"))){
				if(check.isTempValid(inpcon)){
					oupcon = temp.ranToCel(inpcon);
					outputconverstion.setText(String.format("%.2f", oupcon));
				}else {
		        	Toast.makeText(getApplicationContext(), "Please make sure the tempeature is -50 or higher", 5).show();
		        }
			}
			else if((inpuspinner.equalsIgnoreCase("Fah") && outspinner.equalsIgnoreCase("Fah"))){
				if(check.isTempValid(inpcon)){
					oupcon = temp.fahToFah(inpcon);
					outputconverstion.setText(String.format("%.2f", oupcon));
				}else {
		        	Toast.makeText(getApplicationContext(), "Please make sure the tempeature is -50 or higher", 5).show();
		        }
			}
			else if((inpuspinner.equalsIgnoreCase("Fah") && outspinner.equalsIgnoreCase("Kev"))){
				if(check.isTempValid(inpcon)){
					oupcon = temp.fahToKev(inpcon);
					outputconverstion.setText(String.format("%.2f", oupcon));
				}else {
		        	Toast.makeText(getApplicationContext(), "Please make sure the tempeature is -50 or higher", 5).show();
		        }
			}
			else if((inpuspinner.equalsIgnoreCase("Fah") && outspinner.equalsIgnoreCase("Rank"))){
				if(check.isTempValid(inpcon)){
					oupcon = temp.fahToRan(inpcon);
					outputconverstion.setText(String.format("%.2f", oupcon));
				}else {
		        	Toast.makeText(getApplicationContext(), "Please make sure the tempeature is -50 or higher", 5).show();
		        }
			}
			else if((inpuspinner.equalsIgnoreCase("Fah") && outspinner.equalsIgnoreCase("Cel"))){
				if(check.isTempValid(inpcon)){
					oupcon = temp.fahToCel(inpcon);
					outputconverstion.setText(String.format("%.2f", oupcon));
				}else {
		        	Toast.makeText(getApplicationContext(), "Please make sure the tempeature is -50 or higher", 5).show();
		        }
			}
			else if((inpuspinner.equalsIgnoreCase("Kev") && outspinner.equalsIgnoreCase("Kev"))){
				if(check.isTempValid(inpcon)){
					oupcon = temp.kevToKev(inpcon);
					outputconverstion.setText(String.format("%.2f", oupcon));
				}else {
		        	Toast.makeText(getApplicationContext(), "Please make sure the tempeature is -50 or higher", 5).show();
		        }
			}
			else if((inpuspinner.equalsIgnoreCase("Kev") && outspinner.equalsIgnoreCase("Rank"))){
				if(check.isTempValid(inpcon)){
					oupcon = temp.kevToRan(inpcon);
					outputconverstion.setText(String.format("%.2f", oupcon));
				}else {
		        	Toast.makeText(getApplicationContext(), "Please make sure the tempeature is -50 or higher", 5).show();
		        }
			}
			else if((inpuspinner.equalsIgnoreCase("Kev") && outspinner.equalsIgnoreCase("Fah"))){
				if(check.isTempValid(inpcon)){
					oupcon = temp.kevToFah(inpcon);
					outputconverstion.setText(String.format("%.2f", oupcon));
				}else {
		        	Toast.makeText(getApplicationContext(), "Please make sure the tempeature is -50 or higher", 5).show();
		        }
			}
			else if((inpuspinner.equalsIgnoreCase("Kev") && outspinner.equalsIgnoreCase("Cel"))){
				if(check.isTempValid(inpcon)){
					oupcon = temp.kevToCel(inpcon);
					outputconverstion.setText(String.format("%.2f", oupcon));
				}else {
		        	Toast.makeText(getApplicationContext(), "Please make sure the tempeature is -50 or higher", 5).show();
		        }
			}else {
	        	Toast.makeText(getApplicationContext(), "Please make sure the tempeature is -50 or higher", 5).show();
	        }
			
		}
		//checks to see if the input is valid then calculates the conversion for angles
		if (converstionselected.equalsIgnoreCase("Angle")){
			if(inpuspinner.equalsIgnoreCase("DMS") && outspinner.equalsIgnoreCase("DMS")){
				if(check.isDegMinSecValid(inpcon, inpm, inps)){
					int deg = (int) inpcon;
					int min = (int) inpm;
					int sec = (int) inps;
					outdms = angle.dmsToDms(deg, min, sec);
					outputconverstion.setText(outdms[0] +"\u00b0 "+outdms[1]+"' "+outdms[2]+"''");
				}else{
					Toast.makeText(getApplicationContext(), "Please make sure the degree is between 0 and 360, minutes and seconds is between 0 and 60, or radians is between 0 and 6.28", 5).show();
				}
			}
			else if((inpuspinner.equalsIgnoreCase("DMS") && outspinner.equalsIgnoreCase("Rad"))){
				if(check.isDegMinSecValid(inpcon, inpm, inps)){
					oupcon = angle.dmsToRad(inpcon, inpm, inps);
					outputconverstion.setText(String.format("%.4f", oupcon));
				}else {
					Toast.makeText(getApplicationContext(), "Please make sure the degree is between 0 and 360, minutes and seconds is between 0 and 60, or radians is between 0 and 6.28", 5).show();
				}
			}
			else if((inpuspinner.equalsIgnoreCase("Rad") && outspinner.equalsIgnoreCase("Rad"))){
				if(check.isRadValid(inpcon)){
					oupcon = angle.radToRad(inpcon);
					outputconverstion.setText(String.format("%.2f", oupcon));
				}else {
					Toast.makeText(getApplicationContext(), "Please make sure the degree is between 0 and 360, minutes and seconds is between 0 and 60, or radians is between 0 and 6.28", 5).show();
				}
			}
			else if((inpuspinner.equalsIgnoreCase("Rad") && outspinner.equalsIgnoreCase("DMS"))){
				if(check.isRadValid(inpcon)){
					outdms = angle.radToDms(inpcon);
					outputconverstion.setText(outdms[0] +"\u00b0 "+outdms[1]+"' "+outdms[2]+"''");
				}else {
					Toast.makeText(getApplicationContext(), "Please make sure the degree is between 0 and 360, minutes and seconds is between 0 and 60, or radians is between 0 and 6.28", 5).show();
				}
			
			}else {
				Toast.makeText(getApplicationContext(), "Please make sure the degree is between 0 and 360, minutes and seconds is between 0 and 60, or radians is between 0 and 6.28", 5).show();
			}
		}
		//checks to see if the input is valid then calculates the conversion for speed
		if (converstionselected.equalsIgnoreCase("Speed")){
			if(inpuspinner.equalsIgnoreCase("MPH") && outspinner.equalsIgnoreCase("MPH")){
				if(check.isPosValid(inpcon)){
					oupcon = speed.mphToMph(inpcon);
					outputconverstion.setText(String.format("%.2f", oupcon));
				}else {
		        	Toast.makeText(getApplicationContext(), "Please make sure the speed input is above 0", 5).show();
		        }
			}
			else if((inpuspinner.equalsIgnoreCase("MPH") && outspinner.equalsIgnoreCase("KPH"))){
				if(check.isPosValid(inpcon)){
					oupcon = speed.mphToKmh(inpcon);
					outputconverstion.setText(String.format("%.2f", oupcon));
				}else {
		        	Toast.makeText(getApplicationContext(), "Please make sure the speed input is above 0", 5).show();
		        }
			}
			else if((inpuspinner.equalsIgnoreCase("MPH") && outspinner.equalsIgnoreCase("Knots"))){
				if(check.isPosValid(inpcon)){
					oupcon = speed.mphToKnots(inpcon);
					outputconverstion.setText(String.format("%.2f", oupcon));
				}else {
		        	Toast.makeText(getApplicationContext(), "Please make sure the speed input is above 0", 5).show();
		        }
			}
			else if((inpuspinner.equalsIgnoreCase("KPH") && outspinner.equalsIgnoreCase("KPH"))){
				if(check.isPosValid(inpcon)){
					oupcon = speed.kmhToKmh(inpcon);
					outputconverstion.setText(String.format("%.2f", oupcon));
				}else {
		        	Toast.makeText(getApplicationContext(), "Please make sure the speed input is above 0", 5).show();
		        }
			}
			else if(inpuspinner.equalsIgnoreCase("KPH") && outspinner.equalsIgnoreCase("Knots")){
				if(check.isPosValid(inpcon)){
					oupcon = speed.kmhToKnots(inpcon);
					outputconverstion.setText(String.format("%.2f", oupcon));
				}else {
		        	Toast.makeText(getApplicationContext(), "Please make sure the speed input is above 0", 5).show();
		        }
			}
			else if((inpuspinner.equalsIgnoreCase("KPH") && outspinner.equalsIgnoreCase("MPH"))){
				if(check.isPosValid(inpcon)){
					oupcon = speed.kmhToMph(inpcon);
					outputconverstion.setText(String.format("%.2f", oupcon));
				}else {
		        	Toast.makeText(getApplicationContext(), "Please make sure the speed input is above 0", 5).show();
		        }
			}
			else if((inpuspinner.equalsIgnoreCase("Knots") && outspinner.equalsIgnoreCase("Knots"))){
				if(check.isPosValid(inpcon)){
					oupcon = speed.knotsToKnots(inpcon);
					outputconverstion.setText(String.format("%.2f", oupcon));
				}else {
		        	Toast.makeText(getApplicationContext(), "Please make sure the speed input is above 0", 5).show();
		        }
			}
			else if((inpuspinner.equalsIgnoreCase("Knots") && outspinner.equalsIgnoreCase("KPH"))){
				if(check.isPosValid(inpcon)){
					oupcon = speed.knotsToKmh(inpcon);
					outputconverstion.setText(String.format("%.2f", oupcon));
				}else {
		        	Toast.makeText(getApplicationContext(), "Please make sure the speed input is above 0", 5).show();
		        }
			}
			else if((inpuspinner.equalsIgnoreCase("Knots") && outspinner.equalsIgnoreCase("MPH"))){
				if(check.isPosValid(inpcon)){
					oupcon = speed.knotsToMPH(inpcon);
					outputconverstion.setText(String.format("%.2f", oupcon));
				}else {
		        	Toast.makeText(getApplicationContext(), "Please make sure the speed input is above 0", 5).show();
		        }
			
			}else {
	        	Toast.makeText(getApplicationContext(), "Please make sure the speed input is above 0", 5).show();
	        }
		}
		//checks to see if the input is valid then calculates the conversion for distance
		if (converstionselected.equalsIgnoreCase("Distance")){
			if(inpuspinner.equalsIgnoreCase("SM") && outspinner.equalsIgnoreCase("SM")){
				if(check.isPosValid(inpcon)){
					oupcon = dist.statToStat(inpcon);
					outputconverstion.setText(String.format("%.2f", oupcon));
				}else {
		        	Toast.makeText(getApplicationContext(), "Please make sure the distance input is above 0", 5).show();
		        }
			}
			else if((inpuspinner.equalsIgnoreCase("SM") && outspinner.equalsIgnoreCase("NM"))){
				if(check.isPosValid(inpcon)){
					oupcon = dist.statToNaut(inpcon);
					outputconverstion.setText(String.format("%.2f", oupcon));
				}else {
		        	Toast.makeText(getApplicationContext(), "Please make sure the distance input is above 0", 5).show();
		        }
			}
			else if((inpuspinner.equalsIgnoreCase("SM") && outspinner.equalsIgnoreCase("KM"))){
				if(check.isPosValid(inpcon)){
					oupcon = dist.statToKilom(inpcon);
					outputconverstion.setText(String.format("%.2f", oupcon));
				}else {
		        	Toast.makeText(getApplicationContext(), "Please make sure the distance input is above 0", 5).show();
		        }
			}
			else if((inpuspinner.equalsIgnoreCase("NM") && outspinner.equalsIgnoreCase("NM"))){
				if(check.isPosValid(inpcon)){
					oupcon = dist.nautToNaut(inpcon);
					outputconverstion.setText(String.format("%.2f", oupcon));
				}else {
		        	Toast.makeText(getApplicationContext(), "Please make sure the distance input is above 0", 5).show();
		        }
			}
			else if(inpuspinner.equalsIgnoreCase("NM") && outspinner.equalsIgnoreCase("KM")){
				if(check.isPosValid(inpcon)){
					oupcon = dist.nautToKilom(inpcon);
					outputconverstion.setText(String.format("%.2f", oupcon));
				}else {
		        	Toast.makeText(getApplicationContext(), "Please make sure the distance input is above 0", 5).show();
		        }
			}
			else if((inpuspinner.equalsIgnoreCase("NM") && outspinner.equalsIgnoreCase("SM"))){
				if(check.isPosValid(inpcon)){
					oupcon = dist.nautToStat(inpcon);
					outputconverstion.setText(String.format("%.2f", oupcon));
				}else {
		        	Toast.makeText(getApplicationContext(), "Please make sure the distance input is above 0", 5).show();
		        }
			}
			else if((inpuspinner.equalsIgnoreCase("KM") && outspinner.equalsIgnoreCase("KM"))){
				if(check.isPosValid(inpcon)){
					oupcon = dist.kilomToKilom(inpcon);
					outputconverstion.setText(String.format("%.2f", oupcon));
				}else {
		        	Toast.makeText(getApplicationContext(), "Please make sure the distance input is above 0", 5).show();
		        }
			}
			else if((inpuspinner.equalsIgnoreCase("KM") && outspinner.equalsIgnoreCase("NM"))){
				if(check.isPosValid(inpcon)){
					oupcon = dist.kilomToNaut(inpcon);
					outputconverstion.setText(String.format("%.2f", oupcon));
				}else {
		        	Toast.makeText(getApplicationContext(), "Please make sure the distance input is above 0", 5).show();
		        }
			}
			else if((inpuspinner.equalsIgnoreCase("KM") && outspinner.equalsIgnoreCase("SM"))){
				if(check.isPosValid(inpcon)){
					oupcon = dist.kilomToStat(inpcon);
					outputconverstion.setText(String.format("%.2f", oupcon));
				}else {
		        	Toast.makeText(getApplicationContext(), "Please make sure the distance input is above 0", 5).show();
		        }
			}else {
	        	Toast.makeText(getApplicationContext(), "Please make sure the distance input is above 0", 5).show();
	        }
		}
			//checks to see if the input is valid then calculates the conversion for pressure
		if (converstionselected.equalsIgnoreCase("Pressure")){
			if(inpuspinner.equalsIgnoreCase("Mercury") && outspinner.equalsIgnoreCase("Mercury")){
				if(check.isPosValid(inpcon)){
					oupcon = pres.mercToMerc(inpcon);
					outputconverstion.setText(String.format("%.2f", oupcon));
				}else {
		        	Toast.makeText(getApplicationContext(), "Please make sure the pressure is above 0", 5).show();
		        }
			}
			else if((inpuspinner.equalsIgnoreCase("Mercury") && outspinner.equalsIgnoreCase("Millibars"))){
				if(check.isPosValid(inpcon)){
					oupcon = pres.mercToMili(inpcon);
					outputconverstion.setText(String.format("%.2f", oupcon));
				}else {
		        	Toast.makeText(getApplicationContext(), "Please make sure the pressure is above 0", 5).show();
		        }
			}
			else if((inpuspinner.equalsIgnoreCase("Millibars") && outspinner.equalsIgnoreCase("Millibars"))){
				if(check.isPosValid(inpcon)){
					oupcon = pres.miliToMili(inpcon);
					outputconverstion.setText(String.format("%.2f", oupcon));
				}else {
		        	Toast.makeText(getApplicationContext(), "Please make sure the pressure is above 0", 5).show();
		        }
			}
			else if((inpuspinner.equalsIgnoreCase("Millibars") && outspinner.equalsIgnoreCase("Mercury"))){
				if(check.isPosValid(inpcon)){
					oupcon = pres.miliToMerc(inpcon);
					outputconverstion.setText(String.format("%.2f", oupcon));
				}else {
		        	Toast.makeText(getApplicationContext(), "Please make sure the pressure is above 0", 5).show();
		        }
			
			}else {
	        	Toast.makeText(getApplicationContext(), "Please make sure the pressure is above 0", 5).show();
	        }
		}
		
		
	}
	public class conversionSelectedListener implements OnItemSelectedListener {

		public void onItemSelected(AdapterView<?> parent, View view, int pos,
				long id) {
			converstionselected = parent.getItemAtPosition(pos).toString();
	        if(converstionselected.equalsIgnoreCase("Temperature")){
	        	inpuconvers.setAdapter(tempAdapter);
	        	oupuconvers.setAdapter(tempAdapter);
	        }
	        else if(converstionselected.equalsIgnoreCase("Angle")){
	        	inpuconvers.setAdapter(angleAdapter);
	        	oupuconvers.setAdapter(angleAdapter);
	        }
	        else if(converstionselected.equalsIgnoreCase("Speed")){
	        	inpuconvers.setAdapter(speedAdapter);
	        	oupuconvers.setAdapter(speedAdapter);
	        }
	        else if(converstionselected.equalsIgnoreCase("Distance")){
	        	inpuconvers.setAdapter(distAdapter);
	        	oupuconvers.setAdapter(distAdapter);
	        }
	        else if(converstionselected.equalsIgnoreCase("Pressure")){
	        	inpuconvers.setAdapter(presAdapter);
	        	oupuconvers.setAdapter(presAdapter);
	        }
		}

		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	public class inputSelectedListener implements OnItemSelectedListener {

		public void onItemSelected(AdapterView<?> parent, View view, int pos,
				long id) {
			inpuspinner = parent.getItemAtPosition(pos).toString();
			if(inpuspinner.equalsIgnoreCase("DMS")){
				minute.setVisibility(View.VISIBLE);
				second.setVisibility(View.VISIBLE);
			}else{
				minute.setVisibility(View.INVISIBLE);
				second.setVisibility(View.INVISIBLE);
			}
		}
			

		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	public class outputSelectedListener implements OnItemSelectedListener {

		public void onItemSelected(AdapterView<?> parent, View view, int pos,
				long id) {
			outspinner = parent.getItemAtPosition(pos).toString();
		}

		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}


}
