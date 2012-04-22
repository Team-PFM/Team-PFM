package team.pfm.com;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SettingsActivity extends Activity {
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // call the superclass version
        setContentView(R.layout.settingspage); // set the layout
	}
	
	public void about(View view) {
		Intent intent = new Intent(view.getContext(), aboutActivity.class);
    	startActivity(intent);
	}
}