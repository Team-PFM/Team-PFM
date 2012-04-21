package team.pfm.com;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class DeleteDBActivity extends Activity implements OnItemSelectedListener {
	String[] ids ;
	Spinner delete;
	int position;
	Button deleteButton;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // call the superclass version
        setContentView(R.layout.deletepage); // set the layout
        
        //get list of ids from database class
        ArrayList idArray = FPCDatabase.getAirID();  //returning the array list from database class to then get values
        for(int i = 0;i<idArray.size();i++){
        ids[i] = (String) idArray.get(i);  //taking every id from the arraylist in the database and adding it to the string array ids
        }
	
        //Creating adapter with the string array ids and adding it to spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,ids);
        delete =(Spinner)findViewById(R.id.deletepageSpinner);
        delete.setAdapter(adapter);
        delete.setOnItemSelectedListener(this);
        
        // button for pressing delete
        //TODO: add a button id to the "deletepage.xml" so this reference below works
        deleteButton = (Button)findViewById(R.id.delete_button);
        deleteButton.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				FPCDatabase.delAir(ids[position]);  //calling delete method passing string in the ids array at position selected
				
			}
		});
        
        
	}

	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		 position = delete.getSelectedItemPosition();
		
		
	}

	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
}
