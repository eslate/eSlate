package eslate.ablrconcept;

import eslate.main.R;
import eslate.videotrack.database.VideoDatabaseHandler;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ABLR_Main_Activity extends Activity{
	Button skip;
	//MediaPlayer mediaplayer;
	CountDownTimer timer;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setting layout for first Activity
		setContentView(R.layout.pm_main_activity_layout);
		LinearLayout main = (LinearLayout)findViewById(R.id.main_layout);
		main.setBackgroundResource(R.drawable.ablr_background);
		//To keep screen orientation Landscape only so the screen will not rotate
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		
		timer= new CountDownTimer(5000, 5000) {
			public void onTick(long millisUntilFinished) { 
			}
			public void onFinish() {
				Intent next = new Intent(ABLR_Main_Activity.this, ABactivity1.class);
				next.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(next);
				finish();
				}
			}.start();
			
			
			skip = (Button)findViewById(R.id.pm_skip);
			skip.setVisibility(View.GONE);
			VideoDatabaseHandler handler=new VideoDatabaseHandler(this);
			int count=handler.getablrIDCOunt();
			if(count==1)
			{
				skip.setVisibility(View.VISIBLE);
			}
			handler.close();
			skip.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				/*if (mediaplayer.isPlaying()) {
					mediaplayer.stop();
					mediaplayer.release();
				}*/
				timer.cancel();
				
				Intent skip = new Intent(ABLR_Main_Activity.this, eslate.ablrconcepttest.ABLRtest1_Activity.class);
				skip.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(skip);
				finish();
				}
			});
		/*Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.fivesec);
		mediaplayer=MediaPlayer.create(ABLR_Main_Activity.this, path);
		mediaplayer.start();
		mediaplayer.setOnCompletionListener(new OnCompletionListener() {
		@Override
		public void onCompletion(MediaPlayer mp) {
				// TODO Auto-generated method stub
				mediaplayer.stop();
				mediaplayer.release();
				
				Intent next = new Intent(ABLR_Main_Activity.this, ABactivity1.class);
				next.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(next);
				finish();
			}
		});*/
	}
@Override
public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
	   }
    //after selecting the appropriate  menu item this method will invoked
@Override
public boolean onOptionsItemSelected(MenuItem item) {

    	switch (item.getItemId()) {
    	case R.id.home:
    	{timer.cancel();
    		/*if (mediaplayer.isPlaying()) {
				mediaplayer.stop();
				mediaplayer.release();
			}*/
    		
    	//if home button is clicked then it will swich to home screen that is in our case eslate_preparation_MainActivity
    	Intent intent1=new Intent(ABLR_Main_Activity.this,eslate.preparation.main.Eslate_preparatrion_MainActivity.class);
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
	 final Dialog dialog = new Dialog(ABLR_Main_Activity.this,AlertDialog.THEME_HOLO_LIGHT);
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
			/*if (mediaplayer.isPlaying()) {
				mediaplayer.stop();
				mediaplayer.release();
			}*/
			finish();
			System.exit(0);
			}
     	});
	} 
}
