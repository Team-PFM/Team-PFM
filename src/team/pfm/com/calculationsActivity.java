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
	
	public void windspeeddirection(View view) {
		Intent intent = new Intent(view.getContext(), wSpeedAndDirectionActivity.class);
		startActivity(intent);
	}
	
	public void trueAirspeed(View view) {
		Intent intent = new Intent(view.getContext(), trueAirspeedActivity.class);
		startActivity(intent);
	}
	
	public void densityAltitude(View view) {
		Intent intent = new Intent(view.getContext(), densityAltitudeActivity.class);
		startActivity(intent);
	}
	
	public void runwayWinds(View view) {
		Intent intent = new Intent(view.getContext(), runwayWindsActivity.class);
		startActivity(intent);
	}
	
	public void distanceCourse(View view) {
		Intent intent = new Intent(view.getContext(), distanceCourseActivity.class);
		startActivity(intent);
	}
}
