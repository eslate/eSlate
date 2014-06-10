package eslate.shapeintro;

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
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

//point introduction activity
public class PointActivity extends Activity{
	ImageView point, hand;
	Animation animation, anim;
	MediaPlayer mediaplayer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.si_point_layout);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

		point = (ImageView)findViewById(R.id.point);
		point.setImageResource(R.drawable.point);
		point.setVisibility(View.GONE); 
		
		hand = (ImageView)findViewById(R.id.hand);
		//getting refrence to sequential animation
		anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.si_seq);
		//getting refrence to blink animation
		animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.si_blink);
		mediaplayer=MediaPlayer.create(getApplicationContext(), R.raw.point);
		
		hand.setVisibility(View.VISIBLE);
		hand.startAnimation(anim);
		

		point.setVisibility(View.VISIBLE);
		point.startAnimation(animation);
		
		anim.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationEnd(Animation animation) {
				
			
				new CountDownTimer(1000, 1000) {

				     public void onTick(long millisUntilFinished) {
				        
				     }

		  public void onFinish() {
			
	     mediaplayer.start();
	     mediaplayer.setOnCompletionListener(new OnCompletionListener() {
		 @Override				
		 public void onCompletion(MediaPlayer mp) {
			 
		
		Intent intent=new Intent(PointActivity.this,LineActivity.class);
		startActivity(intent);
		finish();

							
						}
					});
				    				     }
				  }.start();
	
				
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
			
			Intent home=new Intent(PointActivity.this,eslate.preparation.main.Eslate_preparatrion_MainActivity.class);
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
		 final Dialog dialog = new Dialog(PointActivity.this,AlertDialog.THEME_HOLO_LIGHT);
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