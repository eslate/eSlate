package eslate.colorintro;

import eslate.main.R;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
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

@TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
@SuppressLint("NewApi")
//this activity  to introduce blue color
public class BlueActivity extends Activity{
	Animation animation,animation1;
	MediaPlayer mediaplayer;
	
	//these images are taken to show student a real life blue objects
	ImageView bag,maruti,blshirt,cap,blue;
	
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@SuppressLint("NewApi")
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
		
	setContentView(R.layout.ci_blue_layout);
	setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
	
	// To enable home button 
	getActionBar().setDisplayHomeAsUpEnabled(true);
	getActionBar().setHomeButtonEnabled(true);
	
	bag=(ImageView)findViewById(R.id.bag);
	maruti=(ImageView)findViewById(R.id.maruti);
	blshirt=(ImageView)findViewById(R.id.blshirt);
	cap=(ImageView)findViewById(R.id.cap);
	blue=(ImageView)findViewById(R.id.blue);
		
	cap.setVisibility(View.VISIBLE);
	blue.setVisibility(View.GONE);
	blshirt.setVisibility(View.GONE);
	maruti.setVisibility(View.GONE);
	bag.setVisibility(View.GONE);
		
	animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.ci_blink);
	animation1=AnimationUtils.loadAnimation(getApplicationContext(), R.anim.ci_color2);
		
	cap.startAnimation(animation);
	
	Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.b1);
	mediaplayer=MediaPlayer.create(BlueActivity.this, path);
	mediaplayer.start();
		
	mediaplayer.setOnCompletionListener(new OnCompletionListener() {
			
	@Override
	public void onCompletion(MediaPlayer mp) {
	
	animation.cancel();
	animation.reset();
	
	mediaplayer.stop();
	mediaplayer.release();
	
	cap.setVisibility(View.GONE);
	maruti.setVisibility(View.GONE);
	bag.setVisibility(View.GONE);
	blue.setVisibility(View.GONE);
				
	blshirt.setVisibility(View.VISIBLE);
	blshirt.startAnimation(animation);
				
	Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.b2);
	mediaplayer=MediaPlayer.create(BlueActivity.this, path);
	mediaplayer.start();
				
	mediaplayer.setOnCompletionListener(new OnCompletionListener() {				
	@Override
	public void onCompletion(MediaPlayer mp) {
						
	animation.cancel();
	animation.reset();
	
	mediaplayer.stop();
	mediaplayer.release();
	
	blshirt.setVisibility(View.GONE);
	bag.setVisibility(View.GONE);
	blue.setVisibility(View.GONE);
	cap.setVisibility(View.GONE);
						
	maruti.setVisibility(View.VISIBLE);
	maruti.startAnimation(animation);

	Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.b3);
	mediaplayer=MediaPlayer.create(BlueActivity.this, path);
	mediaplayer.start();
		
	mediaplayer.setOnCompletionListener(new OnCompletionListener() {
	@Override
	public void onCompletion(MediaPlayer mp) {
	
	animation.cancel();
	animation.reset();
	
	mediaplayer.stop();
	mediaplayer.release();
	
	maruti.setVisibility(View.GONE);
	blue.setVisibility(View.GONE);
	cap.setVisibility(View.GONE);
	blshirt.setVisibility(View.GONE);
								
	bag.setVisibility(View.VISIBLE);
	bag.startAnimation(animation);
	
	Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.b4);
	mediaplayer=MediaPlayer.create(BlueActivity.this, path);
	mediaplayer.start();
	
	mediaplayer.setOnCompletionListener(new OnCompletionListener() {	
	@Override
	public void onCompletion(MediaPlayer mp) {
	animation.cancel();
	animation.reset();
	
	mediaplayer.stop();
	mediaplayer.release();
	
	bag.setVisibility(View.GONE);
	maruti.setVisibility(View.GONE);
	cap.setVisibility(View.GONE);
	blshirt.setVisibility(View.GONE);
	
	blue.setVisibility(View.VISIBLE);
	blue.startAnimation(animation1);
	
	Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.b5);
	mediaplayer=MediaPlayer.create(BlueActivity.this, path);
	mediaplayer.start();
	
	mediaplayer.setOnCompletionListener(new OnCompletionListener() {
		
@Override
public void onCompletion(MediaPlayer mp) {
	animation1.cancel();
	animation1.reset();
	
	mediaplayer.stop();
	mediaplayer.release();
	
	blue.setVisibility(View.VISIBLE);
	cap.setVisibility(View.VISIBLE);
	bag.setVisibility(View.VISIBLE);
	blshirt.setVisibility(View.VISIBLE);
	maruti.setVisibility(View.VISIBLE);
	
	Intent blueinten=new Intent(BlueActivity.this,BluePracticeSlate.class);
	blueinten.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	startActivity(blueinten);	
	finish();											
       }
	});	
	   }
	});
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
			Intent home=new Intent(BlueActivity.this,eslate.preparation.main.Eslate_preparatrion_MainActivity.class);
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
		 final Dialog dialog = new Dialog(BlueActivity.this,AlertDialog.THEME_HOLO_LIGHT);
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
