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

public class SevenActivity extends Activity{
	ImageView one,two,three,four,five,six,seven,strawberryOne,strawberryTwo,strawberryThree,strawberryFour,
	          strawberryFive,strawberrySix,strawberrySeven;
	MediaPlayer mediaPlayer;
	Animation blink;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.nl_seven_activity);
		
		//To keep screen orientation Landscape only so the screen will not rotate
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		
		one=(ImageView)findViewById(R.id.one);
		two=(ImageView)findViewById(R.id.two);
		three=(ImageView)findViewById(R.id.three);
		four=(ImageView)findViewById(R.id.four);
		five=(ImageView)findViewById(R.id.five);
		six=(ImageView)findViewById(R.id.six);
		seven=(ImageView)findViewById(R.id.seven);
		strawberryOne=(ImageView)findViewById(R.id.stroberry1);
		strawberryTwo=(ImageView)findViewById(R.id.stroberry2);
		strawberryThree=(ImageView)findViewById(R.id.stroberry3);
		strawberryFour=(ImageView)findViewById(R.id.stroberry4);
		strawberryFive=(ImageView)findViewById(R.id.stroberry5);
		strawberrySix=(ImageView)findViewById(R.id.stroberry6);
		strawberrySeven=(ImageView)findViewById(R.id.stroberry7);
		
		//gone visibility of all images and only seven is get visible.
		one.setVisibility(View.GONE);
		two.setVisibility(View.GONE);
		three.setVisibility(View.GONE);
		four.setVisibility(View.GONE);
		five.setVisibility(View.GONE);
		six.setVisibility(View.GONE);
		strawberryOne.setVisibility(View.GONE);
		strawberryTwo.setVisibility(View.GONE);
		strawberryThree.setVisibility(View.GONE);
		strawberryFour.setVisibility(View.GONE);
		strawberryFive.setVisibility(View.GONE);
		strawberrySix.setVisibility(View.GONE);
		strawberrySeven.setVisibility(View.GONE);
		
		blink=AnimationUtils.loadAnimation(getApplicationContext(), R.anim.nl_blink);
		seven.setAnimation(blink);
		mediaPlayer=MediaPlayer.create(getApplicationContext(), R.raw.seven);
		mediaPlayer.start();
		seven.startAnimation(blink);
		mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
			
		@Override
		public void onCompletion(MediaPlayer mp) {
		mediaPlayer.stop();
		mediaPlayer.release();
		blink.cancel();
		
		//seven strawberry get visible
		strawberryOne.setVisibility(View.VISIBLE);
		strawberryTwo.setVisibility(View.VISIBLE);
		strawberryThree.setVisibility(View.VISIBLE);
		strawberryFour.setVisibility(View.VISIBLE);
		strawberryFive.setVisibility(View.VISIBLE);
		strawberrySix.setVisibility(View.VISIBLE);
		strawberrySeven.setVisibility(View.VISIBLE);
		
		mediaPlayer=MediaPlayer.create(getApplicationContext(), R.raw.seven_g);
		mediaPlayer.start();
		seven.startAnimation(blink);
		mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
			
		@Override
		public void onCompletion(MediaPlayer mp) {
		mediaPlayer.stop();
		mediaPlayer.release();
		blink.cancel();
		
		seven.setVisibility(View.GONE);
		strawberryTwo.setVisibility(View.GONE);
		strawberryThree.setVisibility(View.GONE);
		strawberryFour.setVisibility(View.GONE);
		strawberryFive.setVisibility(View.GONE);
		strawberrySix.setVisibility(View.GONE);
		strawberrySeven.setVisibility(View.GONE);
		//one visible
	    strawberryOne.setVisibility(View.VISIBLE);
	    one.setVisibility(View.VISIBLE);
	    

		mediaPlayer=MediaPlayer.create(getApplicationContext(), R.raw.seven_a);
		mediaPlayer.start();
		one.startAnimation(blink);
		mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
			
		@Override
		public void onCompletion(MediaPlayer mp) {
		mediaPlayer.stop();
		mediaPlayer.release();
		blink.cancel();
		
		one.setVisibility(View.GONE);
		//two visible
	    strawberryTwo.setVisibility(View.VISIBLE);
	    two.setVisibility(View.VISIBLE);
	    mediaPlayer=MediaPlayer.create(getApplicationContext(), R.raw.seven_b);
	 	mediaPlayer.start();
		two.startAnimation(blink);
		mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
	 			
	 	@Override
		public void onCompletion(MediaPlayer mp) {
	 	mediaPlayer.stop();
	 	mediaPlayer.release();
		blink.cancel();
		
	 	two.setVisibility(View.GONE);
	 	//three visible
	    strawberryThree.setVisibility(View.VISIBLE);
	 	three.setVisibility(View.VISIBLE);
	 	
	    mediaPlayer=MediaPlayer.create(getApplicationContext(), R.raw.seven_c);
	 	mediaPlayer.start();
		three.startAnimation(blink);
		mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
		 			
 		@Override
		public void onCompletion(MediaPlayer mp) {
	 	mediaPlayer.stop();
	 	mediaPlayer.release();
		blink.cancel();
		
	 	three.setVisibility(View.GONE);
		//four visible
	    strawberryFour.setVisibility(View.VISIBLE);
	 	four.setVisibility(View.VISIBLE);
	 	
	 	mediaPlayer=MediaPlayer.create(getApplicationContext(), R.raw.seven_d);
	 	mediaPlayer.start();
		four.startAnimation(blink);
		mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
		 			
 		@Override
		public void onCompletion(MediaPlayer mp) {
	 	mediaPlayer.stop();
	 	mediaPlayer.release();
		blink.cancel();
		
	 	four.setVisibility(View.GONE);
		//five visible
	    strawberryFive.setVisibility(View.VISIBLE);
	 	five.setVisibility(View.VISIBLE);
	 	
	 	mediaPlayer=MediaPlayer.create(getApplicationContext(), R.raw.seven_e);
	 	mediaPlayer.start();
		five.startAnimation(blink);
		mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
		 			
 		@Override
		public void onCompletion(MediaPlayer mp) {
	 	mediaPlayer.stop();
	 	mediaPlayer.release();
		blink.cancel();
		
	 	five.setVisibility(View.GONE);
		//six visible
	    strawberrySix.setVisibility(View.VISIBLE);
	 	six.setVisibility(View.VISIBLE);
	 	
	 	mediaPlayer=MediaPlayer.create(getApplicationContext(), R.raw.seven_f);
	 	mediaPlayer.start();
		six.startAnimation(blink);
		mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
		 			
 		@Override
		public void onCompletion(MediaPlayer mp) {
	 	mediaPlayer.stop();
	 	mediaPlayer.release();
		blink.cancel();
		
	 	six.setVisibility(View.GONE);
		//seven visible
	    strawberrySeven.setVisibility(View.VISIBLE);
	 	seven.setVisibility(View.VISIBLE);
	 	

	 	mediaPlayer=MediaPlayer.create(getApplicationContext(), R.raw.seven_g);
	 	mediaPlayer.start();
		seven.startAnimation(blink);
		
		mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
		 			
 		@Override
		public void onCompletion(MediaPlayer mp) {
	 	mediaPlayer.stop();
	 	mediaPlayer.release();
		blink.cancel();
	 
	   Intent intent=new Intent(SevenActivity.this, EightActivity.class);
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
	    	Intent intent1=new Intent(SevenActivity.this,eslate.main.Main_Menu_Activity.class);
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
		 final Dialog dialog = new Dialog(SevenActivity.this,AlertDialog.THEME_HOLO_LIGHT);
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

