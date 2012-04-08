package team.pfm.com;

import android.app.Activity;
import android.content.Intent;
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
        
    }
    
    public void next(View view) {
    	Intent intent = new Intent(view.getContext(), addAndDeleteActivity.class);
    	startActivity(intent);
    }
}