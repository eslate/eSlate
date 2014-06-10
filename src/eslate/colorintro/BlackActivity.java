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

//this activity is to introduce black color
public class BlackActivity extends Activity{
	Animation animation,animation1;
	MediaPlayer mediaplayer;
	//these images are taken to show student a real life black objects
	ImageView black,hair,horse,wallet,telephone;
	
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
@SuppressLint("NewApi")

@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.ci_black_layout);
	setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
	// To enable home button 
	getActionBar().setDisplayHomeAsUpEnabled(true);
	getActionBar().setHomeButtonEnabled(true);
		
	black=(ImageView)findViewById(R.id.black);
	hair=(ImageView)findViewById(R.id.hair);
	horse=(ImageView)findViewById(R.id.horse);
	wallet=(ImageView)findViewById(R.id.wallet);
	telephone=(ImageView)findViewById(R.id.telephone);
		
	wallet.setVisibility(View.VISIBLE);
	hair.setVisibility(View.GONE);
	horse.setVisibility(View.GONE);
	black.setVisibility(View.GONE);
	telephone.setVisibility(View.GONE);
		
	animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.ci_blink);
	animation1=AnimationUtils.loadAnimation(getApplicationContext(), R.anim.ci_color2);
	wallet.startAnimation(animation);
	
	Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.bl1);
	mediaplayer=MediaPlayer.create(BlackActivity.this, path);
	mediaplayer.start();
		
	mediaplayer.setOnCompletionListener(new OnCompletionListener() {		
	@Override
	public void onCompletion(MediaPlayer mp) {
	mediaplayer.stop();
	mediaplayer.release();
	
	animation.cancel();
	animation.reset();
			
	wallet.setVisibility(View.GONE);
	horse.setVisibility(View.GONE);
	black.setVisibility(View.GONE);
	telephone.setVisibility(View.GONE);
			
	hair.setVisibility(View.VISIBLE);
	hair.startAnimation(animation);
	Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.bl2);
	mediaplayer=MediaPlayer.create(BlackActivity.this, path);
	mediaplayer.start();
			
	mediaplayer.setOnCompletionListener(new OnCompletionListener() {			
	@Override
	public void onCompletion(MediaPlayer mp) {
	mediaplayer.stop();
	mediaplayer.release();
	
	animation.cancel();
	animation.reset();
					
	hair.setVisibility(View.GONE);
	black.setVisibility(View.GONE);
	wallet.setVisibility(View.GONE);
	telephone.setVisibility(View.GONE);
	
	horse.setVisibility(View.VISIBLE);
	horse.startAnimation(animation);
	
	Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.bl3);
	mediaplayer=MediaPlayer.create(BlackActivity.this, path);
	mediaplayer.start();
	
	mediaplayer.setOnCompletionListener(new OnCompletionListener() {					
	@Override
	public void onCompletion(MediaPlayer mp) {
							
	mediaplayer.stop();
	mediaplayer.release();
	
	animation.cancel();
	animation.reset();
							
	hair.setVisibility(View.GONE);
	horse.setVisibility(View.GONE);
	wallet.setVisibility(View.GONE);
	black.setVisibility(View.GONE);
	telephone.setVisibility(View.VISIBLE);
	telephone.startAnimation(animation);
	
	Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.bl4);
	mediaplayer=MediaPlayer.create(BlackActivity.this, path);
	mediaplayer.start();
							
	mediaplayer.setOnCompletionListener(new OnCompletionListener() {							
	@Override
	public void onCompletion(MediaPlayer mp) {
	mediaplayer.stop();
	mediaplayer.release();
	
	animation.cancel();
	animation.reset();
									
	
	hair.setVisibility(View.GONE);
	horse.setVisibility(View.GONE);
	wallet.setVisibility(View.GONE);
	telephone.setVisibility(View.GONE);
	
	black.setVisibility(View.VISIBLE);
	black.startAnimation(animation1);
	
	Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.bl5);
	mediaplayer=MediaPlayer.create(BlackActivity.this, path);
	mediaplayer.start();
	
	mediaplayer.setOnCompletionListener(new OnCompletionListener() {	
	@Override
	public void onCompletion(MediaPlayer mp) {
			
	mediaplayer.stop();
	mediaplayer.release();
	
	animation1.cancel();
	animation1.reset();
	
	telephone.setVisibility(View.VISIBLE);
	hair.setVisibility(View.VISIBLE);
	horse.setVisibility(View.VISIBLE);
	wallet.setVisibility(View.VISIBLE);
	black.setVisibility(View.VISIBLE);
			

	Intent blueinten=new Intent(BlackActivity.this,BlackPracticeSlate.class);
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
		Intent home=new Intent(BlackActivity.this,eslate.preparation.main.Eslate_preparatrion_MainActivity.class);
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
	 final Dialog dialog = new Dialog(BlackActivity.this,AlertDialog.THEME_HOLO_LIGHT);
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
