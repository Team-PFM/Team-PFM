package team.pfm.com;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainPageActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // call the superclass version
        setContentView(R.layout.mainpage); // set the layout
        
        // register listeners for the main page buttons
        Button titleButton = (Button)findViewById(R.id.mainPageTitle);
        Button conversionsButton = (Button)findViewById(R.id.mainPageConversions);
        conversionsButton.setOnClickListener(conversionsButtonListener);
        Button calculationsButton = (Button)findViewById(R.id.mainPageCalculations);
        calculationsButton.setOnClickListener(calculationsButtonListener);
        Button addAndDeleteButton = (Button)findViewById(R.id.mainPageAddDelete);
        addAndDeleteButton.setOnClickListener(addAndDeleteButtonListener);
        Button documentationButton = (Button)findViewById(R.id.mainPageDocuments);
        documentationButton.setOnClickListener(documentationButtonListener);
    }
    
    //Listener for the conversionsButton
    public OnClickListener conversionsButtonListener = new OnClickListener()
    {

		public void onClick(View v) {
			// TODO Auto-generated method stub
			
		}
    	
    };
    
    public OnClickListener calculationsButtonListener = new OnClickListener()
    {

		public void onClick(View v) {
			// TODO Auto-generated method stub
			
		}
    	
    };
    
    public OnClickListener addAndDeleteButtonListener = new OnClickListener()
    {

		public void onClick(View v) {
			// TODO Auto-generated method stub
			
		}
    	
    };
    
    public OnClickListener documentationButtonListener = new OnClickListener()
    {

		public void onClick(View v) {
			// TODO Auto-generated method stub
			
		}
    	
    };
}