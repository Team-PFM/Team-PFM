package team.pfm.com;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

public class addAndDeleteActivity extends Activity {
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // call the superclass version
        setContentView(R.layout.adddelete); // set the layout
	}
	
	  public void AddDB(View view) {
	    	Intent intent = new Intent(view.getContext(), AddDBActivity.class);
	    	startActivity(intent);
	    }
	  
	  public void DeleteDB(View view) {
	    	Intent intent = new Intent(view.getContext(), DeleteDBActivity.class);
	    	startActivity(intent);
	    }
}

