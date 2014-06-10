package eslate.numberlearning;

import eslate.main.R;
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

public class TwoActivity extends Activity {
	ImageView banana, two, bananaone, one;
	MediaPlayer mediaPlayer;
	Animation blink;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.nl_two_activity);

		//To keep screen orientation Landscape only so the screen will not rotate
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		
		blink = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.nl_blink);

		mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.two);

		two = (ImageView) findViewById(R.id.two);
		one = (ImageView) findViewById(R.id.one);
		banana = (ImageView) findViewById(R.id.banana);
		bananaone = (ImageView) findViewById(R.id.bananaone);
		bananaone.setVisibility(View.GONE);
		banana.setVisibility(View.GONE);
		one.setVisibility(View.GONE);
		two.setAnimation(blink);
		two.startAnimation(blink);
		// two visibility only
		mediaPlayer.start();
		mediaPlayer.setOnCompletionListener(new OnCompletionListener() {

		@Override
		public void onCompletion(MediaPlayer mp) {
			blink.cancel();
			mediaPlayer.stop();
			mediaPlayer.release();
			// banan visibility with two
			banana.setVisibility(View.VISIBLE);
			bananaone.setVisibility(View.VISIBLE);
			two.setVisibility(View.VISIBLE);
			two.startAnimation(blink);
			mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.two_a);
			mediaPlayer.start();
			mediaPlayer.setOnCompletionListener(new OnCompletionListener() {

			@Override
			public void onCompletion(MediaPlayer mp) {
				// TODO Auto-generated method stub
				// one visiblility
				mediaPlayer.stop();
				mediaPlayer.release();
				blink.cancel();
				
				two.setVisibility(View.GONE);
				one.setVisibility(View.VISIBLE);
				bananaone.setVisibility(View.GONE);
				one.startAnimation(blink);
				
				mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.two_b);
				mediaPlayer.start();
				mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
					
			@Override
			public void onCompletion(MediaPlayer mp) {
				// TODO Auto-generated method stub
				// two visibility
				one.setVisibility(View.GONE);
				blink.cancel();
				mediaPlayer.stop();
				mediaPlayer.release();
				
				
				two.setVisibility(View.VISIBLE);
				
				bananaone.setVisibility(View.VISIBLE);
				two.startAnimation(blink);
				
				mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.two_c);
				mediaPlayer.start();
				mediaPlayer.setOnCompletionListener(new OnCompletionListener() {

			@Override
			public void onCompletion(MediaPlayer mp) {
				mediaPlayer.stop();
				mediaPlayer.release();
				blink.cancel();
				
				Intent intent=new Intent(getApplicationContext(), ThreeActivity.class);
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
	    	{
	    		if (mediaPlayer.isPlaying()) {
					mediaPlayer.stop();
					mediaPlayer.release();
				}
	    		if (blink.hasStarted()) {
					blink.cancel();
				}
	    	//if home button is clicked then it will swich to home screen that is in our case eslate_preparation_MainActivity
	    	Intent intent1=new Intent(TwoActivity.this,eslate.main.Main_Menu_Activity.class);
	    	intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	    	startActivity(intent1);
	    	finish();
	    	return true;
	    	}
	    	}
	    	return super.onOptionsItemSelected(item);
	    }
	@Override
	public void onBackPressed() {
		 final Dialog dialog = new Dialog(TwoActivity.this,AlertDialog.THEME_HOLO_LIGHT);
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
				if (mediaPlayer.isPlaying()) {
					mediaPlayer.stop();
					mediaPlayer.release();
				}
				if (blink.hasStarted()) {
					blink.cancel();
				}
				System.exit(0);
				finish();
				}
	     	});
		} 
	}
