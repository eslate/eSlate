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

//this activity to introduce red color
public class RedActivity extends Activity
{
	Animation animation,animation1,animation3;
	//these images are taken to show student a real life red objects
	ImageView red,straw,balon,app,ab,bus;
	MediaPlayer mediaplayer;
	
	@Override
protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ci_red_layout);
		
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		
		red=(ImageView)findViewById(R.id.red);
		straw=(ImageView)findViewById(R.id.straw);
		balon=(ImageView)findViewById(R.id.balon);
		app=(ImageView)findViewById(R.id.app);
		ab=(ImageView)findViewById(R.id.ab);
		bus=(ImageView)findViewById(R.id.bus);
		
		app.setVisibility(View.VISIBLE);
		red.setVisibility(View.GONE);
		straw.setVisibility(View.GONE);
		balon.setVisibility(View.GONE);
		bus.setVisibility(View.GONE);
		ab.setVisibility(View.GONE);
		
		
		animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.ci_blink);
		animation1=AnimationUtils.loadAnimation(getApplicationContext(), R.anim.ci_color2);
		animation3 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.ci_blink);
		
		app.startAnimation(animation3);
		Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.r1);
		mediaplayer=MediaPlayer.create(RedActivity.this, path);
		mediaplayer.start();
		mediaplayer.setOnCompletionListener(new OnCompletionListener() {
@Override
public void onCompletion(MediaPlayer mp) {
			
		animation.cancel();
		animation.reset();
		
		mediaplayer.stop();
		mediaplayer.release();
		
		straw.setVisibility(View.VISIBLE);
		app.setVisibility(View.GONE);
		red.setVisibility(View.GONE);
		balon.setVisibility(View.GONE);
		bus.setVisibility(View.GONE);
		ab.setVisibility(View.GONE);
			
		straw.startAnimation(animation3);
		Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.r2);
		mediaplayer=MediaPlayer.create(RedActivity.this, path);
		mediaplayer.start();
		mediaplayer.setOnCompletionListener(new OnCompletionListener() {
@Override
public void onCompletion(MediaPlayer mp) {
		
		animation.cancel();
		animation.reset();
		
		mediaplayer.stop();
		mediaplayer.release();
		
		ab.setVisibility(View.VISIBLE);
		app.setVisibility(View.GONE);
		red.setVisibility(View.GONE);
		straw.setVisibility(View.GONE);
		balon.setVisibility(View.GONE);
		bus.setVisibility(View.GONE);
	
		ab.startAnimation(animation3);
		Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.r5);
		mediaplayer=MediaPlayer.create(RedActivity.this, path);
		mediaplayer.start();
		mediaplayer.setOnCompletionListener(new OnCompletionListener() {
@Override
public void onCompletion(MediaPlayer mp) {

		animation3.cancel();
		animation3.reset();
		
		mediaplayer.stop();
		mediaplayer.release();
							
		bus.setVisibility(View.VISIBLE);
		app.setVisibility(View.GONE);
		red.setVisibility(View.GONE);
		straw.setVisibility(View.GONE);
		balon.setVisibility(View.GONE);
		ab.setVisibility(View.GONE);
							
		bus.startAnimation(animation3);
		Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.r4);
		mediaplayer=MediaPlayer.create(RedActivity.this, path);
		mediaplayer.start();
		mediaplayer.setOnCompletionListener(new OnCompletionListener() {			
@Override
public void onCompletion(MediaPlayer mp) {

		animation3.cancel();
		animation3.reset();
		
		mediaplayer.stop();
		mediaplayer.release();
									
		balon.setVisibility(View.VISIBLE);
		app.setVisibility(View.GONE);
		red.setVisibility(View.GONE);
		straw.setVisibility(View.GONE);
		bus.setVisibility(View.GONE);
		ab.setVisibility(View.GONE);
									
		balon.startAnimation(animation3);
		Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.r3);
		mediaplayer=MediaPlayer.create(RedActivity.this, path);
		mediaplayer.start();
		mediaplayer.setOnCompletionListener(new OnCompletionListener() {	
@Override
public void onCompletion(MediaPlayer mp) {
										
		animation3.cancel();
		animation3.reset();
		
		mediaplayer.stop();
		mediaplayer.release();
											
		red.setVisibility(View.VISIBLE);
		app.setVisibility(View.GONE);
		straw.setVisibility(View.GONE);
		balon.setVisibility(View.GONE);
		bus.setVisibility(View.GONE);
		ab.setVisibility(View.GONE);
										
		red.startAnimation(animation1);
		Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.r6);
		mediaplayer=MediaPlayer.create(RedActivity.this, path);
		mediaplayer.start();
		mediaplayer.setOnCompletionListener(new OnCompletionListener() {
												
@Override
public void onCompletion(MediaPlayer mp) {
												 
		mediaplayer.stop();
		mediaplayer.release();
		
		animation1.cancel();
		animation1.reset();
		
		//animation1.cancel();
		//animation3.cancel();
		
		app.setVisibility(View.VISIBLE);
		red.setVisibility(View.VISIBLE);
		straw.setVisibility(View.VISIBLE);
		balon.setVisibility(View.VISIBLE);
		bus.setVisibility(View.VISIBLE);
		ab.setVisibility(View.VISIBLE);
		
		Intent intent=new Intent(RedActivity.this, RedPracticeSlate.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(intent);
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
			if (animation1.hasStarted()) {
				animation1.cancel();
			}
			if (animation3.hasStarted()) {
				animation3.cancel();
			}
			if(mediaplayer.isPlaying())
			{
				mediaplayer.stop();
				mediaplayer.release();
			}
			Intent home=new Intent(RedActivity.this,eslate.preparation.main.Eslate_preparatrion_MainActivity.class);
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
		 final Dialog dialog = new Dialog(RedActivity.this,AlertDialog.THEME_HOLO_LIGHT);
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
	