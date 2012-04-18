package team.pfm.com;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class calculationsActivity extends Activity {
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // call the superclass version
        setContentView(R.layout.calculations_activity); // set the layout
	}
	
	public void headingGsWca(View view) {
    	Intent intent = new Intent(view.getContext(), headingGsWcaActivity.class);
    	startActivity(intent);
    }
}
