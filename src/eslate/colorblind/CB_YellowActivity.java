package eslate.colorblind;

import eslate.colorintro.BlueActivity;
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

//question for yellow color 
public class CB_YellowActivity extends Activity implements OnClickListener {
/*** This variable is initially 0.if student clicked on original yellow image t
 * hen it means he/she is not color blind.so its value becomes  1 and it get stored in the database.
 * ***/
	public static int yellowScore=0;
	Button tyellow,tyellow_gs;
	MediaPlayer mediaPlayer;
	boolean hasOnce=false;
	
	@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.cg_yellow_layout);
	setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

	tyellow=(Button)findViewById(R.id.yellow);
	tyellow.setEnabled(false);
	tyellow.setOnClickListener(this);
	
	tyellow_gs=(Button)findViewById(R.id.yellow_gs);
	tyellow_gs.setEnabled(false);
	tyellow_gs.setOnClickListener(this);
	
	Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.ycb);
	mediaPlayer=MediaPlayer.create(CB_YellowActivity.this, path);
	mediaPlayer.start();
	mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
	@Override
	public void onCompletion(MediaPlayer mp) {
		tyellow.setEnabled(true);
		tyellow_gs.setEnabled(true);
		}
	});
	}
	@Override
	public void onClick(View v) {
		if(hasOnce==false)
		{		
		hasOnce=true;
		switch (v.getId()) {
		case R.id.yellow:
			yellowScore++;
			mediaPlayer.stop();
			mediaPlayer.release();
			
			
			
			Intent intent=new Intent(CB_YellowActivity.this, BlueActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
			finish();

			break;
		case R.id.yellow_gs:
			mediaPlayer.stop();
			mediaPlayer.release();
			
			Intent intent1=new Intent(CB_YellowActivity.this, BlueActivity.class);
			intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent1);
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
/**** If home button is clicked then it will swich to home screen that is in our 
 * case eslate_preparation_MainActivity
 ***/
		Intent intent1=new Intent(CB_YellowActivity.this,eslate.preparation.main.Eslate_preparatrion_MainActivity.class);
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
		 final Dialog dialog = new Dialog(CB_YellowActivity.this,AlertDialog.THEME_HOLO_LIGHT);
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
				if (mediaPlayer.isPlaying()) {
					mediaPlayer.stop();
					mediaPlayer.release();
				}
				finish();
				System.exit(0);
				}
	     	});
		} 
	}