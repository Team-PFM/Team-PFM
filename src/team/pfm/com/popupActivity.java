package team.pfm.com;

import java.util.Scanner;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class popupActivity extends Activity {
	final int ACTIVITY_CHOOSE_FILE=1;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState); // call the superclass version
		setContentView(R.layout.startingpopup); // set the layout

	}

	public void defaultList(View view) {
		Scanner s = new Scanner(getResources().openRawResource(R.raw.defaultairports41));
		FPCDatabase.initDefault(s);
		finish();
	}

	public void customList(View view) {
		Intent chooseFile;
		Intent intent;
		chooseFile = new Intent(Intent.ACTION_GET_CONTENT);
		chooseFile.setType("file/*");
		intent = Intent.createChooser(chooseFile, "Choose a file");
		startActivityForResult(intent,ACTIVITY_CHOOSE_FILE);
	}

	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch(requestCode) {
		case ACTIVITY_CHOOSE_FILE: {
			if (resultCode == RESULT_OK) {
				Uri uri = data.getData();
				String filePath = uri.getPath();
				if(FPCDatabase.checkFileExistAndSyntax(filePath)) {
					FPCDatabase.initAirCustom(filePath);
					finish();
				}
				else {
					Toast.makeText(getApplicationContext(), "Please choose a valid file", 10);
				}

			}

		}
		}
	}
}
