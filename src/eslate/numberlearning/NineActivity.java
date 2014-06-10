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

public class NineActivity extends Activity {
	ImageView one,two,three,four,five,six,seven,eight,nine,blueberryOne,blueberryTwo,blueberryThree,blueberryFour,blueberryFive,blueberrySix,
	blueberrySeven,blueberryEight,blueberryNine;
	MediaPlayer mediaPlayer;
	Animation blink;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.nl_nine_activity);
		
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
		nine=(ImageView)findViewById(R.id.nine);
		blueberryOne=(ImageView)findViewById(R.id.blueberry1);
		blueberryTwo=(ImageView)findViewById(R.id.blueberry2);
		blueberryThree=(ImageView)findViewById(R.id.blueberry3);
		blueberryFour=(ImageView)findViewById(R.id.blueberry4);
		blueberryFive=(ImageView)findViewById(R.id.blueberry5);
		blueberrySix=(ImageView)findViewById(R.id.blueberry6);
		blueberrySeven=(ImageView)findViewById(R.id.blueberry7);
		blueberryEight=(ImageView)findViewById(R.id.blueberry8);
		blueberryNine=(ImageView)findViewById(R.id.blueberry9);
		//six is visible
		one.setVisibility(View.GONE);
		two.setVisibility(View.GONE);
		three.setVisibility(View.GONE);
		four.setVisibility(View.GONE);
		five.setVisibility(View.GONE);
		six.setVisibility(View.GONE);
		seven.setVisibility(View.GONE);
		eight.setVisibility(View.GONE);
	
		blueberryOne.setVisibility(View.GONE);
		blueberryTwo.setVisibility(View.GONE);
		blueberryThree.setVisibility(View.GONE);
		blueberryFour.setVisibility(View.GONE);
		blueberryFive.setVisibility(View.GONE);
		blueberrySix.setVisibility(View.GONE);
		blueberrySeven.setVisibility(View.GONE);
		blueberryEight.setVisibility(View.GONE);
		blueberryNine.setVisibility(View.GONE);

		
		blink=AnimationUtils.loadAnimation(getApplicationContext(), R.anim.nl_blink);
		nine.setAnimation(blink);
		
		mediaPlayer=MediaPlayer.create(getApplicationContext(), R.raw.nine);
		mediaPlayer.start();
		nine.startAnimation(blink);
		mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
			
		@Override
		public void onCompletion(MediaPlayer mp) {
		blink.cancel();
		mediaPlayer.stop();
		mediaPlayer.release();
		
		//six blueberry get visible
		blueberryOne.setVisibility(View.VISIBLE);
		blueberryTwo.setVisibility(View.VISIBLE);
		blueberryThree.setVisibility(View.VISIBLE);
		blueberryFour.setVisibility(View.VISIBLE);
		blueberryFive.setVisibility(View.VISIBLE);
		blueberrySix.setVisibility(View.VISIBLE);
		blueberrySeven.setVisibility(View.VISIBLE);
		blueberryEight.setVisibility(View.VISIBLE);
		blueberryNine.setVisibility(View.VISIBLE);
		
		
		mediaPlayer=MediaPlayer.create(getApplicationContext(), R.raw.nine_i);
		mediaPlayer.start();
		nine.startAnimation(blink);
		mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
			
		@Override
		public void onCompletion(MediaPlayer mp) {
		blink.cancel();
		mediaPlayer.stop();
		mediaPlayer.release();
		
		nine.setVisibility(View.GONE);
	    blueberryTwo.setVisibility(View.GONE);
		blueberryThree.setVisibility(View.GONE);
		blueberryFour.setVisibility(View.GONE);
		blueberryFive.setVisibility(View.GONE);
		blueberrySix.setVisibility(View.GONE);
		blueberrySeven.setVisibility(View.GONE);
		blueberryEight.setVisibility(View.GONE);
		blueberryNine.setVisibility(View.GONE);
		//one visible
		one.setVisibility(View.VISIBLE);
		mediaPlayer=MediaPlayer.create(getApplicationContext(), R.raw.nine_a);
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
		two.setVisibility(View.VISIBLE);
		blueberryTwo.setVisibility(View.VISIBLE);
		mediaPlayer=MediaPlayer.create(getApplicationContext(), R.raw.nine_b);
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
		three.setVisibility(View.VISIBLE);
		blueberryThree.setVisibility(View.VISIBLE);
		mediaPlayer=MediaPlayer.create(getApplicationContext(), R.raw.nine_c);
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
		four.setVisibility(View.VISIBLE);
		blueberryFour.setVisibility(View.VISIBLE);
		mediaPlayer=MediaPlayer.create(getApplicationContext(), R.raw.nine_d);
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
		five.setVisibility(View.VISIBLE);
		blueberryFive.setVisibility(View.VISIBLE);
		mediaPlayer=MediaPlayer.create(getApplicationContext(), R.raw.nine_e);
		mediaPlayer.start();
		five.startAnimation(blink);
		mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
			
		@Override
		public void onCompletion(MediaPlayer mp) {
		blink.cancel();
		mediaPlayer.stop();
		mediaPlayer.release();
		
	    five.setVisibility(View.GONE);
		//six visible
		six.setVisibility(View.VISIBLE);
		blueberrySix.setVisibility(View.VISIBLE);
		mediaPlayer=MediaPlayer.create(getApplicationContext(), R.raw.nine_f);
		mediaPlayer.start();
		six.startAnimation(blink);
		mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
			
		@Override
		public void onCompletion(MediaPlayer mp) {
		blink.cancel();
		mediaPlayer.stop();
		mediaPlayer.release();
		
	    six.setVisibility(View.GONE);
			//seven visible
			seven.setVisibility(View.VISIBLE);
			blueberrySeven.setVisibility(View.VISIBLE);
			mediaPlayer=MediaPlayer.create(getApplicationContext(), R.raw.nine_g);
			mediaPlayer.start();
			seven.startAnimation(blink);
			mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
				
			@Override
			public void onCompletion(MediaPlayer mp) {
			blink.cancel();
			mediaPlayer.stop();
			mediaPlayer.release();
			
		    seven.setVisibility(View.GONE);
			//eight visible
			eight.setVisibility(View.VISIBLE);
			blueberryEight.setVisibility(View.VISIBLE);
			mediaPlayer=MediaPlayer.create(getApplicationContext(), R.raw.nine_h);
			mediaPlayer.start();
			eight.startAnimation(blink);
			mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
					
			@Override
			public void onCompletion(MediaPlayer mp) {
			blink.cancel();
			mediaPlayer.stop();
			mediaPlayer.release();
			
			eight.setVisibility(View.GONE);
			//nine visible
			nine.setVisibility(View.VISIBLE);
			blueberryNine.setVisibility(View.VISIBLE);
			mediaPlayer=MediaPlayer.create(getApplicationContext(), R.raw.nine_i);
			mediaPlayer.start();
			nine.startAnimation(blink);
			mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
					
			@Override
			public void onCompletion(MediaPlayer mp) {
			blink.cancel();
			mediaPlayer.stop();
			mediaPlayer.release();
			
			Intent one = new Intent(NineActivity.this, eslate.writenumber.Number_Main_Activity.class);
			one.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(one);
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
				}
	    		
	    		if (blink.hasStarted()) {
					blink.cancel();
				}
	    	//if home button is clicked then it will swich to home screen that is in our case eslate_preparation_MainActivity
	    	Intent intent1=new Intent(NineActivity.this,eslate.main.Main_Menu_Activity.class);
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
		 final Dialog dialog = new Dialog(NineActivity.this,AlertDialog.THEME_HOLO_LIGHT);
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

