package eslate.colorintro;

import eslate.main.R;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

	//This activity is  to introduce student  a primary colors which are red,yellow,blue.
	public class BasicColor extends Activity {
	
	Animation animation;
	ImageView red,yello,blue;
	MediaPlayer mediaplayer;
	
	@Override
	
protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ci_basiccolor_layout);
		
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
	
		red=(ImageView)findViewById(R.id.red);
		red.setVisibility(View.VISIBLE);
		
		blue=(ImageView)findViewById(R.id.blue);
		blue.setVisibility(View.GONE);
		
		yello=(ImageView)findViewById(R.id.yello);		
		yello.setVisibility(View.GONE);
		
		//setting animation to a color images .which simply blinks the image
		animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.ci_blink);
		
		red.startAnimation(animation);
		
		Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.red);
		mediaplayer=MediaPlayer.create(BasicColor.this, path);
		mediaplayer.start();
		
		mediaplayer.setOnCompletionListener(new OnCompletionListener() {
		@Override
		public void onCompletion(MediaPlayer mp) {
		
		animation.cancel();
		animation.reset();
		
		mediaplayer.stop();
		mediaplayer.release(); 
		
		blue.setVisibility(View.GONE);
		red.setVisibility(View.GONE);
		
		yello.startAnimation(animation);
		yello.setVisibility(View.VISIBLE);
		
		Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.yellow);
		mediaplayer=MediaPlayer.create(BasicColor.this, path);
		mediaplayer.start();
		
		mediaplayer.setOnCompletionListener(new OnCompletionListener() {
		@Override
		public void onCompletion(MediaPlayer mp) {
		
		animation.reset();
		animation.reset();
		
		mediaplayer.stop();
		mediaplayer.release();
		
		yello.setVisibility(View.GONE);
		red.setVisibility(View.GONE);

		blue.setVisibility(View.VISIBLE);
		blue.startAnimation(animation);
		
		Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.blue);
		mediaplayer=MediaPlayer.create(BasicColor.this, path);
		mediaplayer.start();
		
		mediaplayer.setOnCompletionListener(new OnCompletionListener() {
		@Override
		public void onCompletion(MediaPlayer mp) {
		
		animation.cancel();
		animation.reset();
		
		mediaplayer.stop();
		mediaplayer.release();
		
		blue.setVisibility(View.VISIBLE);
		red.setVisibility(View.VISIBLE);
		yello.setVisibility(View.VISIBLE);
		
		red.startAnimation(animation);
		yello.startAnimation(animation);
		blue.startAnimation(animation);
		new CountDownTimer(2000, 2000) {
		public void onTick(long millisUntilFinished) 
		{
	    }
		public void onFinish() {
			Intent act2 = new Intent(BasicColor.this,RedActivity.class);
			act2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(act2);
			finish();
		}
		}.start();
			 }
		});
	         }
		});
			}
		});
			}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
			getMenuInflater().inflate(R.menu.main, menu);
			return true;
			}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

			switch (item.getItemId()) {
			case R.id.home:
			{
			if (animation.hasStarted()) {
				animation.cancel();
			}
			if(mediaplayer.isPlaying())
			{
				mediaplayer.stop();
				mediaplayer.release();
			}
			Intent home=new Intent(BasicColor.this,eslate.preparation.main.Eslate_preparatrion_MainActivity.class);
    		home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    		startActivity(home);
    		finish();
			return true;
			}
			}
			return super.onOptionsItemSelected(item);
		}
	@SuppressLint("InlinedApi")
	@Override
	public void onBackPressed() {
		 final Dialog dialog = new Dialog(BasicColor.this,AlertDialog.THEME_HOLO_LIGHT);
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
				if (animation.hasStarted()) {
					animation.cancel();
				}
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