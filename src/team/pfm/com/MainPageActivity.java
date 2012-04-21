package team.pfm.com;
//awesome
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class MainPageActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // call the superclass version
        setContentView(R.layout.mainpage); // set the layout
        
    }
    
    public void onResume()
    {
    	startActivity(new Intent(this, popupActivity.class));
    	super.onResume();
    }
    
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.app_menu, menu);
        return true;
    }
    
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.settings:
            	Intent intent = new Intent(MainPageActivity.this, SettingsActivity.class);
            	startActivity(intent);
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    
    public void adddelete(View view) {
    	Intent intent = new Intent(view.getContext(), addAndDeleteActivity.class);
    	startActivity(intent);
    }
    
    public void calculations(View view) {
    	Intent intent = new Intent(view.getContext(), calculationsActivity.class);
    	startActivity(intent);
    }
    
    public void documents(View view) {
    	Intent intent = new Intent(view.getContext(), documentsActivity.class);
    	startActivity(intent);
    }
}