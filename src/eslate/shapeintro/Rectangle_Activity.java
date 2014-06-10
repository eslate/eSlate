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

//rectangle introduction activity
public class Rectangle_Activity extends Activity {
	//these imageviews are taken to explain  to a student rectangle with real life objects 
	ImageView rect_board,rect_door,rectangle,rect_phone,rect_fridge;
	Animation animation0;
	MediaPlayer mediaplayer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.si_rectangle_layout);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

		//get refrence to all imageviews and make their visibility gone.
		rect_board= (ImageView)findViewById(R.id.rect_board);
		rect_board.setVisibility(View.GONE); 
		
		rect_door = (ImageView)findViewById(R.id.rect_door);
		rect_door.setVisibility(View.GONE); 
		
		rectangle = (ImageView)findViewById(R.id.rectangle);
		rectangle.setVisibility(View.GONE); 

		rect_phone = (ImageView)findViewById(R.id.rect_phone);
		rect_phone.setVisibility(View.GONE); 
		
		rect_fridge = (ImageView)findViewById(R.id.rect_fridge);
		rect_fridge.setVisibility(View.GONE); 
		
		animation0 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.si_blink);
		
		//make rectangle visible and animate it
		rectangle.setVisibility(View.VISIBLE);
		rectangle.startAnimation(animation0);
		Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.rectangle);
		mediaplayer=MediaPlayer.create(Rectangle_Activity.this, path);
		mediaplayer.start();
		
		mediaplayer.setOnCompletionListener(new OnCompletionListener() {
		@Override
		public void onCompletion(MediaPlayer mp) {
		//make blackboard visible
			mediaplayer.stop();
			mediaplayer.release();
			animation0.cancel();
			
			rect_board.setVisibility(View.VISIBLE);
			rect_board.startAnimation(animation0);
		
		Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.rboard);
		mediaplayer=MediaPlayer.create(Rectangle_Activity.this, path);
		mediaplayer.start();
		
		mediaplayer.setOnCompletionListener(new OnCompletionListener() {	
		@Override
		public void onCompletion(MediaPlayer mp) {
			// make door visible
			mediaplayer.stop();
			mediaplayer.release();
			animation0.cancel();
			
			rect_door.setVisibility(View.VISIBLE);
			rect_door.startAnimation(animation0);
			
		Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.rdoor);
		mediaplayer=MediaPlayer.create(Rectangle_Activity.this, path);
		mediaplayer.start();
		
		mediaplayer.setOnCompletionListener(new OnCompletionListener() {
		@Override
		public void onCompletion(MediaPlayer mp) {
			// make fridge visible
			mediaplayer.stop();
			mediaplayer.release();
			animation0.cancel();
			
			rect_fridge.setVisibility(View.VISIBLE);
			rect_fridge.startAnimation(animation0);
			
		Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.rrefrigerator);
		mediaplayer=MediaPlayer.create(Rectangle_Activity.this, path);
		mediaplayer.start();
			
		mediaplayer.setOnCompletionListener(new OnCompletionListener() {
			@Override
			public void onCompletion(MediaPlayer mp) {
			// make phone visible
			mediaplayer.stop();
			mediaplayer.release();
			animation0.cancel();
				
			rect_phone.setVisibility(View.VISIBLE);
			rect_phone.startAnimation(animation0);
				
		Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.rphone);
		mediaplayer=MediaPlayer.create(Rectangle_Activity.this, path);
		mediaplayer.start();
		
		mediaplayer.setOnCompletionListener(new OnCompletionListener() {	
		@Override
		public void onCompletion(MediaPlayer mp) {
			mediaplayer.stop();
			mediaplayer.release();
			animation0.cancel();
			
			Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.rectangle);
			mediaplayer=MediaPlayer.create(Rectangle_Activity.this, path);
			mediaplayer.start();
			mediaplayer.setOnCompletionListener(new OnCompletionListener() {
			
			@Override
			public void onCompletion(MediaPlayer mp) {
				// call next activity
				mediaplayer.stop();
				mediaplayer.release();
				
				Intent next=new Intent(Rectangle_Activity.this, eslate.shapeintro.Circle_Activity.class);
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
			
			if(animation0.hasStarted())
			{
				animation0.cancel();
			}
			mediaplayer.stop();
			mediaplayer.release();
			
			Intent home=new Intent(Rectangle_Activity.this,eslate.preparation.main.Eslate_preparatrion_MainActivity.class);
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
		 final Dialog dialog = new Dialog(Rectangle_Activity.this,AlertDialog.THEME_HOLO_LIGHT);
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
				if(animation0.hasStarted())
				{
					animation0.cancel();
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
