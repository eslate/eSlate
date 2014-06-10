package eslate.colorblind;

import eslate.colorintro.BlackActivity;
import eslate.main.R;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

/** This activity is used check whether student is colorblind or not.
 * Here we are mixed a 50% gray color in that original color and asking 
 * a student to identify that original color.this is question  test for blue color ***/
public class CB_BlueActivity extends Activity implements OnClickListener {
	
/** This variable is initially 0.if student clicked on original blue image then it 
 * means he/she is not color blind.so its value becomes  1 and it get stored in the database****/
   
	public static int blueColor=0;
	MediaPlayer mediaPlayer;
    //These Buttons are taking as color buttons
	Button tblue,tblue_gs;
	boolean hasOnce=false;
	
	@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.cg_blue_layout);
	setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

	tblue=(Button)findViewById(R.id.blue);
	tblue.setEnabled(false);
	tblue.setOnClickListener(this);
	
	tblue_gs=(Button)findViewById(R.id.blue_gs);
	tblue_gs.setEnabled(false);
	tblue_gs.setOnClickListener(this);
	
	Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.bcb);
	mediaPlayer=MediaPlayer.create(CB_BlueActivity.this, path);
	mediaPlayer.start();
	mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
	@Override
	public void onCompletion(MediaPlayer mp) {
	tblue.setEnabled(true);
	tblue_gs.setEnabled(true);
		}
	});
	}
	
	@Override
	public void onClick(View v) {
		if(hasOnce==false)
		{		
		hasOnce=true;
		switch (v.getId()) {
		case R.id.blue:
			blueColor++;
			
			mediaPlayer.stop();
			mediaPlayer.release();
			
			Intent next=new Intent(CB_BlueActivity.this, BlackActivity.class);
			next.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(next);
			finish();

			break;
		case R.id.blue_gs:
			mediaPlayer.stop();
			mediaPlayer.release();
			
			//after answered this question it will switch to next queation that in blackcolor activity
			Intent next1=new Intent(CB_BlueActivity.this, BlackActivity.class);
			next1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(next1);
			finish();
			break;
		default:
			break;
			}
		}
	}
@Override
public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
		}

@Override
public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case android.R.id.home:
		{
			if (mediaPlayer.isPlaying()) {
				mediaPlayer.stop();
				mediaPlayer.release();
			}
	    //if home button is clicked then it will switch to home screen that is in our case eslate_preparation_MainActivity
		Intent intent1=new Intent(CB_BlueActivity.this,eslate.preparation.main.Eslate_preparatrion_MainActivity.class);
		intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(intent1);
		finish();
		return true;
								}
		}
		return super.onOptionsItemSelected(item);
}
@SuppressLint("InlinedApi")
@Override
public void onBackPressed() {
	 final Dialog dialog = new Dialog(CB_BlueActivity.this,AlertDialog.THEME_HOLO_LIGHT);
     dialog.requestWindowFeature(Window.FEATURE_LEFT_ICON);
  //   dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
     // Include dialog.xml file
     dialog.setContentView(R.layout.dialog);
     int width = getResources().getDimensionPixelSize(R.dimen.popup_width);
     int height = getResources().getDimensionPixelSize(R.dimen.popup_height);        
     dialog.getWindow().setLayout(width, height);
     /***http://stackoverflow.com/questions/15173855/android-alertdialog-with-custom-view-and-rounded-corners***/
     dialog.setFeatureDrawableResource(Window.FEATURE_LEFT_ICON,R.drawable.logo);
     // Set dialog title
     dialog.setTitle("Quit");
     // set values for custom dialog components - text, image and button
     TextView text = (TextView) dialog.findViewById(R.id.textDialog);
     text.setText("Do You Want to Quit???");
     text.setTypeface(null, Typeface.BOLD);
     text.setTextColor(Color.WHITE);
   //  ImageView image = (ImageView) dialog.findViewById(R.id.imageDialog);
  //   image.setImageResource(R.drawable.quit);
     dialog.show();
     Button declineButton = (Button) dialog.findViewById(R.id.declineButton);
     // if decline button is clicked, close the custom dialog
     declineButton.setOnClickListener(new OnClickListener() {
         @Override
         public void onClick(View v) {
             // Close dialog
             dialog.dismiss();
         }
     });
     Button acceptButton = (Button)dialog.findViewById(R.id.acceptButton);
     acceptButton.setOnClickListener(new OnClickListener() {	
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			finish();
			System.exit(0);
			}
     	});
	} 
}