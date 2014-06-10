package eslate.colorintro;

import eslate.main.R;
import android.annotation.SuppressLint;
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

//this activity to introduce yellow color
public class YellowActivity extends Activity

{
	Animation animation,animation1;
	//these images are taken to show student a real life yellow objects
	ImageView sun,yellow,lemon,mango,sunflow;
	MediaPlayer mediaplayer;

@Override
protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ci_yellow_layout);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

		sun=(ImageView)findViewById(R.id.sun);
		yellow=(ImageView)findViewById(R.id.yellow);
		lemon=(ImageView)findViewById(R.id.lemon);
		mango=(ImageView)findViewById(R.id.mango);
		sunflow=(ImageView)findViewById(R.id.sunflow);
		
		sun.setVisibility(View.VISIBLE);
		yellow.setVisibility(View.GONE);
		lemon.setVisibility(View.GONE);
		mango.setVisibility(View.GONE);
		sunflow.setVisibility(View.GONE);
		
		animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.ci_blink);
		animation1=AnimationUtils.loadAnimation(getApplicationContext(), R.anim.ci_color2);
		
		sun.startAnimation(animation);
		Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.y1);
		mediaplayer=MediaPlayer.create(YellowActivity.this, path);
		mediaplayer.start();
		
		mediaplayer.setOnCompletionListener(new OnCompletionListener() {
			
@Override
public void onCompletion(MediaPlayer mp) {
				animation.cancel();
				animation.reset();
				
				mediaplayer.stop();
				mediaplayer.release();
				
				sun.setVisibility(View.GONE);
				sunflow.setVisibility(View.GONE);
				mango.setVisibility(View.GONE);
				yellow.setVisibility(View.GONE);
				lemon.setVisibility(View.VISIBLE);
				
				lemon.startAnimation(animation);
				
				lemon.startAnimation(animation);
				Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.y2);
				mediaplayer=MediaPlayer.create(YellowActivity.this, path);
				mediaplayer.start();
				
				mediaplayer.setOnCompletionListener(new OnCompletionListener() {
					
@Override
public void onCompletion(MediaPlayer mp) {
				animation.cancel();
				animation.reset();
				
				mediaplayer.stop();
				mediaplayer.release();
						
				sun.setVisibility(View.GONE);
				lemon.setVisibility(View.GONE);
				sunflow.setVisibility(View.GONE);
				yellow.setVisibility(View.GONE);
				mango.setVisibility(View.VISIBLE);
						
				mango.startAnimation(animation);
				Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.y3);
				mediaplayer=MediaPlayer.create(YellowActivity.this, path);
				mediaplayer.start();
						
				mediaplayer.setOnCompletionListener(new OnCompletionListener() {
							
@Override
public void onCompletion(MediaPlayer mp) {
								
				animation.cancel();
				animation.reset();
								
				mediaplayer.stop();
				mediaplayer.release();
				
				mango.setVisibility(View.GONE);
				sun.setVisibility(View.GONE);
				yellow.setVisibility(View.GONE);
				lemon.setVisibility(View.GONE);
				sunflow.setVisibility(View.VISIBLE);
								
				sunflow.startAnimation(animation);
				Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.y4);
				mediaplayer=MediaPlayer.create(YellowActivity.this, path);
				mediaplayer.start();
								
				mediaplayer.setOnCompletionListener(new OnCompletionListener() {
									
@Override
public void onCompletion(MediaPlayer mp) {
										
				animation.cancel();
				animation.reset();
				
				mediaplayer.stop();
				mediaplayer.release();
				
				sunflow.setVisibility(View.GONE);
				sun.setVisibility(View.GONE);
				lemon.setVisibility(View.GONE);
				mango.setVisibility(View.GONE);
				yellow.setVisibility(View.VISIBLE);
										
				yellow.startAnimation(animation1);
				Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.y5);
				mediaplayer=MediaPlayer.create(YellowActivity.this, path);
				mediaplayer.start();
										
				mediaplayer.setOnCompletionListener(new OnCompletionListener() {
									
@Override
public void onCompletion(MediaPlayer mp) {
								
								animation1.cancel();
								animation1.reset();
								
								mediaplayer.stop();
								mediaplayer.release();
								
								mango.setVisibility(View.VISIBLE);
								sun.setVisibility(View.VISIBLE);
								sunflow.setVisibility(View.VISIBLE);
								lemon.setVisibility(View.VISIBLE);
								yellow.setVisibility(View.VISIBLE);
												
								Intent blueinten=new Intent(YellowActivity.this,YellowPracticeSlate.class);
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
		Intent home=new Intent(YellowActivity.this,eslate.preparation.main.Eslate_preparatrion_MainActivity.class);
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
	 final Dialog dialog = new Dialog(YellowActivity.this,AlertDialog.THEME_HOLO_LIGHT);
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
			}
			finish();
			System.exit(0);
			}
     	});
	} 
}
