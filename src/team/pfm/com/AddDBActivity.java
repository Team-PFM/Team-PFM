package team.pfm.com;

import android.app.Activity;


import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddDBActivity extends Activity {
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // call the superclass version
        setContentView(R.layout.add_airport_activity); // set the layout
	
	
	Button calc= (Button)findViewById(R.id.add_airport_button);
	calc.setOnClickListener(new OnClickListener(){
		
		public void onClick(View V){
			
			//edit text box objects
			EditText airIDTextBox = (EditText) findViewById(R.id.input_airport_ID);
			EditText airLatTextBox = (EditText) findViewById(R.id.input_latitude);
			EditText airLongTextBox = (EditText) findViewById(R.id.input_longitude);
	
			//variables for inputs
			String id = null;
			double lat = 0;
			double lon = 0;
	
			//get values from input boxes       
		 id = airIDTextBox.getText().toString().trim();    
	 
		 try{
		 lat = Double.parseDouble(airLatTextBox.getText().toString().trim());
		 } catch (Exception e) {
		      	Toast.makeText(getApplicationContext(), "Please enter a valid double for latitude!", 5).show();
		 	}
	 
		 try{
			 lon = Double.parseDouble(airLongTextBox.getText().toString().trim());
		 } catch (Exception e) {
			 	Toast.makeText(getApplicationContext(), "Please enter a valid double for longitude!", 5).show();
		 	}
	 
		 //checks if the id is of right length, then adds 
		 if(id.length()==3){
			 FPCDatabase.addAir(id, lat, lon);
			 finish();
		 }
		 else{
			 Toast.makeText(getApplicationContext(), "Please enter a valid id of length 3!", 5).show();
		 }
			}
		
		});

	}
}

