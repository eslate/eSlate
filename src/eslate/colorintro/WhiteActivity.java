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
//ths activity to introduce white color
public class WhiteActivity extends Activity{
	Animation animation,animation1;
	MediaPlayer mediaplayer;
	//these images are taken to show student a real life white objects
	ImageView rose,white,umbre,raddish,dog;
	
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
@SuppressLint("NewApi")
@Override
protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ci_white_layout);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		// To enable home button 
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);
		rose=(ImageView)findViewById(R.id.rose);
		white=(ImageView)findViewById(R.id.white);
		raddish=(ImageView)findViewById(R.id.raddish);
		umbre=(ImageView)findViewById(R.id.umbre);
		dog=(ImageView)findViewById(R.id.dog);
		
		rose.setVisibility(View.GONE);
		white.setVisibility(View.GONE);
		umbre.setVisibility(View.GONE);
		raddish.setVisibility(View.GONE);
		dog.setVisibility(View.GONE);
		
		animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.ci_blink);
		animation1=AnimationUtils.loadAnimation(getApplicationContext(), R.anim.ci_color2);
		
		raddish.setVisibility(View.VISIBLE);
		raddish.startAnimation(animation);
		
		Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.w1);
		mediaplayer=MediaPlayer.create(WhiteActivity.this, path);
		mediaplayer.start();
		
		mediaplayer.setOnCompletionListener(new OnCompletionListener() {
			
@Override
public void onCompletion(MediaPlayer mp) {
				mediaplayer.stop();
				mediaplayer.release();
				
				animation.cancel();
				animation.reset();
				
				raddish.setVisibility(View.GONE);
				umbre.setVisibility(View.GONE);
				white.setVisibility(View.GONE);
				dog.setVisibility(View.GONE);
				
				rose.setVisibility(View.VISIBLE);
				rose.startAnimation(animation);
				Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.w3);
				mediaplayer=MediaPlayer.create(WhiteActivity.this, path);
				mediaplayer.start();
				mediaplayer.setOnCompletionListener(new OnCompletionListener() {
					
@Override
public void onCompletion(MediaPlayer mp) {
						mediaplayer.stop();
						mediaplayer.release();
						
						animation.cancel();
						animation.reset();
						
						rose.setVisibility(View.GONE);
						raddish.setVisibility(View.GONE);
						white.setVisibility(View.GONE);
						dog.setVisibility(View.GONE);
						umbre.setVisibility(View.VISIBLE);
						umbre.startAnimation(animation);
						Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.w2);
						mediaplayer=MediaPlayer.create(WhiteActivity.this, path);
						mediaplayer.start();
						
						mediaplayer.setOnCompletionListener(new OnCompletionListener() {
							
@Override
public void onCompletion(MediaPlayer mp) {
	mediaplayer.stop();									
	mediaplayer.release();
	
	animation.cancel();
	animation.reset();
								rose.setVisibility(View.GONE);
								raddish.setVisibility(View.GONE);
								white.setVisibility(View.GONE);
								umbre.setVisibility(View.GONE);
								dog.setVisibility(View.VISIBLE);
								dog.startAnimation(animation);
								Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.w4);
								mediaplayer=MediaPlayer.create(WhiteActivity.this, path);
								mediaplayer.start();
								
								mediaplayer.setOnCompletionListener(new OnCompletionListener() {
									
@Override
public void onCompletion(MediaPlayer mp) {
										mediaplayer.stop();
										mediaplayer.release();
										
										animation.cancel();
										animation.reset();
										
										rose.setVisibility(View.GONE);
										raddish.setVisibility(View.GONE);
										white.setVisibility(View.VISIBLE);
										umbre.setVisibility(View.GONE);
										dog.setVisibility(View.GONE);
										
										white.startAnimation(animation1);
										Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.w5);
										mediaplayer=MediaPlayer.create(WhiteActivity.this, path);
										mediaplayer.start();
										
										mediaplayer.setOnCompletionListener(new OnCompletionListener() {
											
@Override
public void onCompletion(MediaPlayer mp) {
	 											mediaplayer.stop();
	 											mediaplayer.release();
	 											
												animation1.cancel();
												animation1.reset();
												
												white.setVisibility(View.VISIBLE);
												dog.setVisibility(View.VISIBLE);
												umbre.setVisibility(View.VISIBLE);
												rose.setVisibility(View.VISIBLE);
												raddish.setVisibility(View.VISIBLE);
												
												Intent blueinten=new Intent(WhiteActivity.this,WhitePracticeSlate.class);
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
		}
		Intent home=new Intent(WhiteActivity.this,eslate.preparation.main.Eslate_preparatrion_MainActivity.class);
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
	 final Dialog dialog = new Dialog(WhiteActivity.this,AlertDialog.THEME_HOLO_LIGHT);
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
