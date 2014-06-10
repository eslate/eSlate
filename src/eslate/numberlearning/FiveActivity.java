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

public class FiveActivity extends Activity{
	ImageView one,two,three,four,five,pearone,peartwo,pearthree,pearfour,pearfive;
	MediaPlayer mediaPlayer;
	Animation blink;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.nl_five_activity);
		
		//To keep screen orientation Landscape only so the screen will not rotate
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		
		one=(ImageView)findViewById(R.id.one);
		two=(ImageView)findViewById(R.id.two);
		three=(ImageView)findViewById(R.id.three);
		four=(ImageView)findViewById(R.id.four);
		five=(ImageView)findViewById(R.id.five);
		pearone=(ImageView)findViewById(R.id.pear1);
		peartwo=(ImageView)findViewById(R.id.pear2);
		pearthree=(ImageView)findViewById(R.id.pear3);
		pearfour=(ImageView)findViewById(R.id.pear4);
		pearfive=(ImageView)findViewById(R.id.pear5);
		//gone the visibility of all images and only five is visible.
		one.setVisibility(View.GONE);
		two.setVisibility(View.GONE);
		three.setVisibility(View.GONE);
		four.setVisibility(View.GONE);
		pearone.setVisibility(View.GONE);
		peartwo.setVisibility(View.GONE);
		pearthree.setVisibility(View.GONE);
		pearfour.setVisibility(View.GONE);
		pearfive.setVisibility(View.GONE);
		
		blink=AnimationUtils.loadAnimation(getApplicationContext(), R.anim.nl_blink);
		five.setAnimation(blink);
		mediaPlayer=MediaPlayer.create(FiveActivity.this,R.raw.five);
		mediaPlayer.start();
	    five.startAnimation(blink);
		mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
			
		@Override
		public void onCompletion(MediaPlayer mp) {
		blink.cancel();
		mediaPlayer.stop();
		mediaPlayer.release();
		
		//all five pears are visible
		pearone.setVisibility(View.VISIBLE);
		peartwo.setVisibility(View.VISIBLE);
		pearthree.setVisibility(View.VISIBLE);
		pearfour.setVisibility(View.VISIBLE);
		pearfive.setVisibility(View.VISIBLE);
		
		mediaPlayer=MediaPlayer.create(FiveActivity.this,R.raw.five_a);
		mediaPlayer.start();
	    five.startAnimation(blink);
		mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
			
		@Override
		public void onCompletion(MediaPlayer mp) {
		blink.cancel();
		mediaPlayer.stop();
		mediaPlayer.release();
		
		five.setVisibility(View.GONE);
		peartwo.setVisibility(View.GONE);
		pearthree.setVisibility(View.GONE);
		pearfour.setVisibility(View.GONE);
		pearfive.setVisibility(View.GONE);
		//one visible
		pearone.setVisibility(View.VISIBLE);
		one.setVisibility(View.VISIBLE);
		
		mediaPlayer=MediaPlayer.create(FiveActivity.this,R.raw.five_g);
		mediaPlayer.start();
	    one.startAnimation(blink);
		mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
			
		@Override
		public void onCompletion(MediaPlayer mp) {
		blink.cancel();
		mediaPlayer.stop();
		mediaPlayer.release();
		
		one.setVisibility(View.GONE);
		
		//two visible
		peartwo.setVisibility(View.VISIBLE);
		two.setVisibility(View.VISIBLE);
		
		mediaPlayer=MediaPlayer.create(FiveActivity.this,R.raw.five_b);
		mediaPlayer.start();
	    two.startAnimation(blink);
		mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
			
		@Override
		public void onCompletion(MediaPlayer mp) {
		blink.cancel();
		mediaPlayer.stop();
		mediaPlayer.release();
		
		two.setVisibility(View.GONE);
		
		//three visible
		pearthree.setVisibility(View.VISIBLE);
		three.setVisibility(View.VISIBLE);
		
		mediaPlayer=MediaPlayer.create(FiveActivity.this,R.raw.five_c);
		mediaPlayer.start();
	    three.startAnimation(blink);
		mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
			
		@Override
		public void onCompletion(MediaPlayer mp) {
		blink.cancel();
		mediaPlayer.stop();
		mediaPlayer.release();
		
		three.setVisibility(View.GONE);
		
		//four visible
		pearfour.setVisibility(View.VISIBLE);
		four.setVisibility(View.VISIBLE);
		

		mediaPlayer=MediaPlayer.create(FiveActivity.this,R.raw.five_d);
		mediaPlayer.start();
	    four.startAnimation(blink);
		mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
			
		@Override
		public void onCompletion(MediaPlayer mp) {
		blink.cancel();
		mediaPlayer.stop();
		mediaPlayer.release();
		
		four.setVisibility(View.GONE);
		
		//five visible
		pearfive.setVisibility(View.VISIBLE);
		five.setVisibility(View.VISIBLE);
		

		mediaPlayer=MediaPlayer.create(FiveActivity.this,R.raw.five_e);
		mediaPlayer.start();
	    five.startAnimation(blink);
		mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
			
		@Override
		public void onCompletion(MediaPlayer mp) {
		blink.cancel();
		mediaPlayer.stop();
		mediaPlayer.release();
		
		Intent intent=new Intent(FiveActivity.this,SixActivity.class);
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
	    	Intent intent1=new Intent(FiveActivity.this,eslate.main.Main_Menu_Activity.class);
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
		 final Dialog dialog = new Dialog(FiveActivity.this,AlertDialog.THEME_HOLO_LIGHT);
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

