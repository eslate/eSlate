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

public class EightActivity extends Activity{
	ImageView one,two,three,four,five,six,seven,eight,appleOne,appletwo,appleThree,appleFour,appleFive,appleSix,appleSeven,appleEight;
	MediaPlayer mediaPlayer;
	Animation  blink;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.nl_eight_activity);
		
		//To keep screen orientation Landscape only so the screen will not rotate
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		
		one=(ImageView)findViewById(R.id.one);
		two=(ImageView)findViewById(R.id.two);
		three=(ImageView)findViewById(R.id.three);
		four=(ImageView)findViewById(R.id.four);
		five=(ImageView)findViewById(R.id.five);
		six=(ImageView)findViewById(R.id.six);
		seven=(ImageView)findViewById(R.id.seven);
		eight=(ImageView)findViewById(R.id.eight);
		
		appleOne=(ImageView)findViewById(R.id.apple1);
		appletwo=(ImageView)findViewById(R.id.apple2);
		appleThree=(ImageView)findViewById(R.id.apple3);
		appleFour=(ImageView)findViewById(R.id.apple4);
		appleFive=(ImageView)findViewById(R.id.apple5);
		appleSix=(ImageView)findViewById(R.id.apple6);
		appleSeven=(ImageView)findViewById(R.id.apple7);
		appleEight=(ImageView)findViewById(R.id.apple8);
		
		//gone the visibility of all images
		one.setVisibility(View.GONE);
		two.setVisibility(View.GONE);
		three.setVisibility(View.GONE);
		four.setVisibility(View.GONE);
		five.setVisibility(View.GONE);
		six.setVisibility(View.GONE);
		seven.setVisibility(View.GONE);
		
		appleOne.setVisibility(View.GONE);
		appletwo.setVisibility(View.GONE);
		appleThree.setVisibility(View.GONE);
		appleFour.setVisibility(View.GONE);
		appleFive.setVisibility(View.GONE);
		appleSix.setVisibility(View.GONE);
		appleSeven.setVisibility(View.GONE);
		appleEight.setVisibility(View.GONE);
		
		blink=AnimationUtils.loadAnimation(getApplicationContext(), R.anim.nl_blink);	
		eight.setAnimation(blink);
		
		mediaPlayer=MediaPlayer.create(getApplicationContext(), R.raw.eight);
		mediaPlayer.start();
		
		eight.startAnimation(blink);
		mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
			
		@Override
		public void onCompletion(MediaPlayer mp) {
		//visible all eight apple	
			mediaPlayer.stop();
			mediaPlayer.release();
			blink.cancel();
			
		appleOne.setVisibility(View.VISIBLE);
		appletwo.setVisibility(View.VISIBLE);
		appleThree.setVisibility(View.VISIBLE);
		appleFour.setVisibility(View.VISIBLE);
		appleFive.setVisibility(View.VISIBLE);
		appleSix.setVisibility(View.VISIBLE);
		appleSeven.setVisibility(View.VISIBLE);
		appleEight.setVisibility(View.VISIBLE);	
		mediaPlayer=MediaPlayer.create(getApplicationContext(), R.raw.eight_a);
		mediaPlayer.start();
		eight.startAnimation(blink);
		mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
			
		@Override
		public void onCompletion(MediaPlayer mp) {
			mediaPlayer.stop();
			mediaPlayer.release();
			blink.cancel();
			
		eight.setVisibility(View.GONE);
		appletwo.setVisibility(View.GONE);
		appleThree.setVisibility(View.GONE);
		appleFour.setVisibility(View.GONE);
		appleFive.setVisibility(View.GONE);
		appleSix.setVisibility(View.GONE);
		appleSeven.setVisibility(View.GONE);
		appleEight.setVisibility(View.GONE);	
		//one visibility
		appleOne.setVisibility(View.VISIBLE);
		one.setVisibility(View.VISIBLE);
		mediaPlayer=MediaPlayer.create(getApplicationContext(), R.raw.eight_b);
		mediaPlayer.start();
		one.startAnimation(blink);
		mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
			
		@Override
		public void onCompletion(MediaPlayer mp) {
			mediaPlayer.stop();
			mediaPlayer.release();
			blink.cancel();
			
		one.setVisibility(View.GONE);
		//two visibility
		appletwo.setVisibility(View.VISIBLE);
		two.setVisibility(View.VISIBLE);
		mediaPlayer=MediaPlayer.create(getApplicationContext(), R.raw.eight_c);
		mediaPlayer.start();
		two.startAnimation(blink);
		mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
		@Override
		public void onCompletion(MediaPlayer mp) {
			mediaPlayer.stop();
			mediaPlayer.release();
			blink.cancel();
			
		two.setVisibility(View.GONE);
		//three visibility
		appleThree.setVisibility(View.VISIBLE);
		three.setVisibility(View.VISIBLE);
		
		mediaPlayer=MediaPlayer.create(getApplicationContext(), R.raw.eight_d);
		mediaPlayer.start();
		three.startAnimation(blink);
		mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
		@Override
		public void onCompletion(MediaPlayer mp) {
			mediaPlayer.stop();
			mediaPlayer.release();
			blink.cancel();
			
		three.setVisibility(View.GONE);
		//four visibility
		appleFour.setVisibility(View.VISIBLE);
		four.setVisibility(View.VISIBLE);
		mediaPlayer=MediaPlayer.create(getApplicationContext(), R.raw.eight_e);
		mediaPlayer.start();
		four.startAnimation(blink);
		mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
		@Override
		public void onCompletion(MediaPlayer mp) {
			mediaPlayer.stop();
			mediaPlayer.release();
			blink.cancel();
			
		four.setVisibility(View.GONE);
		//five visibility
		appleFive.setVisibility(View.VISIBLE);
		five.setVisibility(View.VISIBLE);
		mediaPlayer=MediaPlayer.create(getApplicationContext(), R.raw.eight_f);
		mediaPlayer.start();
		five.startAnimation(blink);
		mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
		@Override
		public void onCompletion(MediaPlayer mp) {
			mediaPlayer.stop();
			mediaPlayer.release();
			blink.cancel();
			
		five.setVisibility(View.GONE);
		//six visibility
		appleSix.setVisibility(View.VISIBLE);
		six.setVisibility(View.VISIBLE);
		mediaPlayer=MediaPlayer.create(getApplicationContext(), R.raw.eight_g);
		mediaPlayer.start();
		six.startAnimation(blink);
		mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
		@Override
		public void onCompletion(MediaPlayer mp) {
			mediaPlayer.stop();
			mediaPlayer.release();
			blink.cancel();
			
		six.setVisibility(View.GONE);
		//seven visibility
		appleSeven.setVisibility(View.VISIBLE);
		seven.setVisibility(View.VISIBLE);
		mediaPlayer=MediaPlayer.create(getApplicationContext(), R.raw.eight_h);
		mediaPlayer.start();
		seven.startAnimation(blink);
		mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
		@Override
		public void onCompletion(MediaPlayer mp) {
			mediaPlayer.stop();
			mediaPlayer.release();
			blink.cancel();
			
		seven.setVisibility(View.GONE);
		//eight visibility
		appleEight.setVisibility(View.VISIBLE);
		eight.setVisibility(View.VISIBLE);
		mediaPlayer=MediaPlayer.create(getApplicationContext(), R.raw.eight_i);
		mediaPlayer.start();
		eight.startAnimation(blink);
		mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
		@Override
		public void onCompletion(MediaPlayer mp) {
			mediaPlayer.stop();
			mediaPlayer.release();
			blink.cancel();
			
		Intent intent=new Intent(EightActivity.this, NineActivity.class);
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
	    	//if home button is clicked then it will switch to home screen that is in our case eslate_preparation_MainActivity
	    	Intent intent1=new Intent(EightActivity.this,eslate.main.Main_Menu_Activity.class);
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
		 final Dialog dialog = new Dialog(EightActivity.this,AlertDialog.THEME_HOLO_LIGHT);
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

