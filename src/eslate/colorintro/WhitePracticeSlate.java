package eslate.colorintro;

import eslate.colortest.ColorTestOneActivity;
import eslate.main.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

//this activity represents a practiceslate for practicing a white color
public class WhitePracticeSlate extends Activity{
	public static int white=0;
	MediaPlayer mediaplayer;
	ImageView imageview;
	ImageButton next;
	Paint paint;
	public static int count=0;

@Override
public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(new SingleTouchEventView(this, null,4));
	setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

	LayoutInflater inflater = getLayoutInflater();
	getWindow().addContentView(inflater.inflate(R.layout.activity_single_touch, null),
	new ViewGroup.LayoutParams(
	ViewGroup.LayoutParams.MATCH_PARENT,
	ViewGroup.LayoutParams.MATCH_PARENT));

	next=(ImageButton)findViewById(R.id.singletouch_next);
	next.setVisibility(View.GONE);
	next.setOnClickListener(new OnClickListener() {
			
	@Override
	public void onClick(View v) {
		mediaplayer.stop();
		
	Intent intent=new Intent(WhitePracticeSlate.this,ColorTestOneActivity.class);
	intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	startActivity(intent);
	finish();
				
			}
		});
	
	Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.w_slate);
	mediaplayer=MediaPlayer.create(WhitePracticeSlate.this, path);
	if(count==0)
	{
	mediaplayer.start();
	}
	new CountDownTimer(3000, 1000) {
		public void onTick(long millisUntilFinished) { 
		}
		public void onFinish() {
		next.setVisibility(View.VISIBLE);
			}
		}.start();
	mediaplayer.setOnCompletionListener(new OnCompletionListener() {
	@Override
	public void onCompletion(MediaPlayer mp) {	
	new CountDownTimer(3000, 1000) {
		public void onTick(long millisUntilFinished) {    
		     }
	public void onFinish() {
	next.setVisibility(View.VISIBLE);
		   }
		  }.start();	
		}
	});
	}
@Override
public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.mulakshare_practice, menu);
		return true;
		}

@Override
public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case R.id.home:
		{
		
		if(mediaplayer.isPlaying())
		{
			mediaplayer.stop();
					}
		mediaplayer.release();

		Intent home=new Intent(WhitePracticeSlate.this,eslate.preparation.main.Eslate_preparatrion_MainActivity.class);
		home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(home);
		finish();
		return true;
								}
		 case R.id.action_refresh:
	        {
	          count++;
	          mediaplayer.release();
	          Intent intent=new Intent(WhitePracticeSlate.this, WhitePracticeSlate.class);
	          startActivity(intent);
	          finish();
	          return true;
	        }
		}
		return super.onOptionsItemSelected(item);
	}
@SuppressLint("InlinedApi")
@Override
public void onBackPressed() {
	 final Dialog dialog = new Dialog(WhitePracticeSlate.this,AlertDialog.THEME_HOLO_LIGHT);
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
			
			if(mediaplayer.isPlaying())
			{
				mediaplayer.stop();
				mediaplayer.release();
			}
			finish();
			System.exit(0);
			}
     	});
	} 
}