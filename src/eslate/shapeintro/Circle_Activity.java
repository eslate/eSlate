package eslate.shapeintro;

import eslate.main.R;
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
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.Typeface;

//circle shape introduction activity
public class Circle_Activity extends Activity {
	
	//these image views are taken to explain to a student circle with real life objects 
	
	ImageView cir_circle,cir_moon,cir_plate,cir_clock,cir_ball;
	Animation animation;
	MediaPlayer mediaplayer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.si_circle_layout);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		
		cir_clock = (ImageView)findViewById(R.id.cir_clock);
		cir_clock.setVisibility(View.GONE);
		
		cir_plate = (ImageView)findViewById(R.id.cir_plate);
		cir_plate.setVisibility(View.GONE);
		
		cir_moon = (ImageView)findViewById(R.id.cir_moon);
		cir_moon.setVisibility(View.GONE);
		
		cir_ball = (ImageView)findViewById(R.id.cir_ball);
		cir_ball.setVisibility(View.GONE);
		
		cir_circle = (ImageView)findViewById(R.id.circle);
		cir_circle.setVisibility(View.GONE);
		
		animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.si_blink);
		
		cir_circle.setVisibility(View.VISIBLE);
		cir_circle.startAnimation(animation);
		
		
		Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.circle);
		mediaplayer=MediaPlayer.create(Circle_Activity.this, path);
		mediaplayer.start();
		
		mediaplayer.setOnCompletionListener(new OnCompletionListener() {
		@Override
		public void onCompletion(MediaPlayer mp) {
			// TODO Auto-generated method stub
			mediaplayer.stop();
			mediaplayer.release();
			animation.cancel();
			
			cir_moon.setVisibility(View.VISIBLE);
			cir_moon.startAnimation(animation);
			
			Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.cearth);
			mediaplayer=MediaPlayer.create(Circle_Activity.this, path);
			mediaplayer.start();
		
		mediaplayer.setOnCompletionListener(new OnCompletionListener() {
		@Override
		public void onCompletion(MediaPlayer mp) {
			// TODO Auto-generated method stub
			mediaplayer.stop();
			mediaplayer.release();
			animation.cancel();	
			
			cir_plate.setVisibility(View.VISIBLE);
			cir_plate.startAnimation(animation);
			
			Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.cdish);
			mediaplayer=MediaPlayer.create(Circle_Activity.this, path);
			mediaplayer.start();
			
		mediaplayer.setOnCompletionListener(new OnCompletionListener() {
		@Override
		public void onCompletion(MediaPlayer mp) {
			// TODO Auto-generated method stub
			mediaplayer.stop();
			mediaplayer.release();
			animation.cancel();
			
			cir_ball.setVisibility(View.VISIBLE);
			cir_ball.startAnimation(animation);
			
			Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.cball);
			mediaplayer=MediaPlayer.create(Circle_Activity.this, path);
			mediaplayer.start();
			
		mediaplayer.setOnCompletionListener(new OnCompletionListener() {
		@Override
		public void onCompletion(MediaPlayer mp) {
			// TODO Auto-generated method stub
			mediaplayer.stop();
			mediaplayer.release();
			animation.cancel();
			
			cir_clock.setVisibility(View.VISIBLE);
			cir_clock.startAnimation(animation);
			
			Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.cwatch);
			mediaplayer=MediaPlayer.create(Circle_Activity.this, path);
			mediaplayer.start();
			
		mediaplayer.setOnCompletionListener(new OnCompletionListener() {
		@Override
		public void onCompletion(MediaPlayer mp) {
			// TODO Auto-generated method stub
			mediaplayer.stop();
			mediaplayer.release();
			animation.cancel();
			
			Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.circle);
			mediaplayer=MediaPlayer.create(Circle_Activity.this, path);
			mediaplayer.start();
			
		
		mediaplayer.setOnCompletionListener(new OnCompletionListener() {
			
		@Override
		public void onCompletion(MediaPlayer mp) {
	
		mediaplayer.start();
		mediaplayer.release();
		Intent next = new Intent(Circle_Activity.this, eslate.shapetest.ShapeTestOneActivity.class);
		next.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(next);
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
			
			if(animation.hasStarted())
			{
				animation.cancel();
			}
			
				mediaplayer.stop();
				mediaplayer.release();
			
			Intent home=new Intent(Circle_Activity.this,eslate.preparation.main.Eslate_preparatrion_MainActivity.class);
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
		 final Dialog dialog = new Dialog(Circle_Activity.this,AlertDialog.THEME_HOLO_LIGHT);
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
				if(animation.hasStarted())
				{
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
		