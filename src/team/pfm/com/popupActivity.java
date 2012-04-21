package team.pfm.com;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;

public class popupActivity extends Activity {
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // call the superclass version
        setContentView(R.layout.startingpopup); // set the layout
        
    }
	
	public void defaultList(View view) {
		FPCDatabase.initDefault();
		finish();
	}
	
	public void customList(View view) {
		Intent intent = getIntent();
		String filename = intent.getDataString();
		FPCDatabase.initAirCustom(filename);
		finish();
	}
}
