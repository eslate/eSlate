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

public class FourActivity extends Activity {
	ImageView one,two,three,four,grapesone,grapestwo,grapesthree,grapesfour;
	MediaPlayer mediaPlayer;
	Animation blink;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.nl_four_activity);
		
		//To keep screen orientation Landscape only so the screen will not rotate
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		
		one=(ImageView)findViewById(R.id.one);
		two=(ImageView)findViewById(R.id.two);
		three=(ImageView)findViewById(R.id.three);
		four=(ImageView)findViewById(R.id.four);
		grapesone=(ImageView)findViewById(R.id.grapes1);
		grapestwo=(ImageView)findViewById(R.id.grapes2);
		grapesthree=(ImageView)findViewById(R.id.grapes3);
		grapesfour=(ImageView)findViewById(R.id.grapes4);
		
		
		blink=AnimationUtils.loadAnimation(getApplicationContext(), R.anim.nl_blink);
		four.setAnimation(blink);
		
		
		//gone the visibility of all the imageviews and only four is visible
		
		one.setVisibility(View.GONE);
		two.setVisibility(View.GONE);
		three.setVisibility(View.GONE);
		grapesone.setVisibility(View.GONE);
		grapestwo.setVisibility(View.GONE);
		grapesthree.setVisibility(View.GONE);
		grapesfour.setVisibility(View.GONE);
		
		mediaPlayer=MediaPlayer.create(FourActivity.this, R.raw.four);
		mediaPlayer.start();
		four.startAnimation(blink);
		mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
			
		@Override
		public void onCompletion(MediaPlayer mp) {
		mediaPlayer.stop();
		mediaPlayer.release();
		blink.cancel();
		
		//four with four grapes visible	
		grapesone.setVisibility(View.VISIBLE);
		grapestwo.setVisibility(View.VISIBLE);
		grapesthree.setVisibility(View.VISIBLE);
		grapesfour.setVisibility(View.VISIBLE);
		

		mediaPlayer=MediaPlayer.create(FourActivity.this, R.raw.four_a);
		mediaPlayer.start();
		four.startAnimation(blink);
		mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
			
		@Override
		public void onCompletion(MediaPlayer mp) {
		mediaPlayer.stop();
		mediaPlayer.release();
		blink.cancel();
		
		grapestwo.setVisibility(View.GONE);
		grapesthree.setVisibility(View.GONE);
		grapesfour.setVisibility(View.GONE);
		four.setVisibility(View.GONE);
		
		//one visibility
		one.setVisibility(View.VISIBLE);
		grapesone.setVisibility(View.VISIBLE);
			
		mediaPlayer=MediaPlayer.create(FourActivity.this, R.raw.four_b);
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
		two.setVisibility(View.VISIBLE);
		grapestwo.setVisibility(View.VISIBLE);
		mediaPlayer=MediaPlayer.create(FourActivity.this, R.raw.four_c);
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
		three.setVisibility(View.VISIBLE);
		grapesthree.setVisibility(View.VISIBLE);
		mediaPlayer=MediaPlayer.create(FourActivity.this, R.raw.four_d);
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
		four.setVisibility(View.VISIBLE);
		grapesfour.setVisibility(View.VISIBLE);
		mediaPlayer=MediaPlayer.create(FourActivity.this, R.raw.four_e);
		mediaPlayer.start();
		four.startAnimation(blink);
		mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
			
		@Override
		public void onCompletion(MediaPlayer mp) {
		mediaPlayer.stop();
		mediaPlayer.release();
		blink.cancel();
	
		Intent intent=new Intent(FourActivity.this,FiveActivity.class);
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
	    //after selecting the appropriate  menu item this method will invoked
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

	    	switch (item.getItemId()) {
	    	case R.id.home:
	    	{
					mediaPlayer.stop();
					mediaPlayer.release();
					
	    		if (blink.hasStarted()) {
					blink.cancel();
				}
	    	//if home button is clicked then it will switch to home screen that is in our case eslate_preparation_MainActivity
	    	Intent intent1=new Intent(FourActivity.this,eslate.main.Main_Menu_Activity.class);
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
		 final Dialog dialog = new Dialog(FourActivity.this,AlertDialog.THEME_HOLO_LIGHT);
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
