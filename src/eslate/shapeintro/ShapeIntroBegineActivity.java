package eslate.shapeintro;

import eslate.main.R;
import eslate.shapetest.ShapeTestOneActivity;
import eslate.videotrack.database.VideoDatabaseHandler;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


//home screen of shape intro
public class ShapeIntroBegineActivity extends Activity {
	/*** this beging image button will appear on screen when student click on that 
	 * button he/she will  switch to a next screen ***/
	ImageButton begine;
	Button skip;
	Animation animation; 
	MediaPlayer mediaPlayer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.si_shape_intro_begine_layout);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
				
		begine = (ImageButton)findViewById(R.id.begine);
		begine.setVisibility(View.GONE); 
		
		skip=(Button)findViewById(R.id.skip);
		skip.setVisibility(View.GONE);
		
		mediaPlayer=MediaPlayer.create(getApplicationContext(), R.raw.shapeintro);
		mediaPlayer.start();
		
		VideoDatabaseHandler handler=new VideoDatabaseHandler(this);
		int count=handler.getShapeIDCOunt();
		if(count==1)
		{
			skip.setVisibility(View.VISIBLE);
		}
		skip.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub	
				mediaPlayer.stop();
				mediaPlayer.release();
				Intent skip = new Intent(ShapeIntroBegineActivity.this, ShapeTestOneActivity.class);
				skip.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(skip);
				finish();
			 }
		 });
		
		animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.si_blink);
		
/*****  
This CountDownTimer inner class is used to when shape introbegin screen comes the begin button is invisible and after one second
as 1st parameter passed in CountDownTimer constructor is 1000 millisecond which is one second it get visible to student  
******/
		mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
			
			@Override
			public void onCompletion(MediaPlayer mp) {
				mediaPlayer.stop();
				mediaPlayer.release();
				begine.setVisibility(View.VISIBLE);
				begine.startAnimation(animation);
				
			}
		});
			
				
       	
		begine.setOnClickListener(new OnClickListener() {
		@Override
		public void onClick(View v) {
			// after clicked on begin button student will switch to pointactivity 
			Intent next = new Intent(ShapeIntroBegineActivity.this, PointActivity.class);
			next.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(next);
			finish();
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
			
				mediaPlayer.stop();
			
			if(animation.hasStarted())
			{
				animation.cancel();
			}
			mediaPlayer.release();
			Intent home=new Intent(ShapeIntroBegineActivity.this,eslate.preparation.main.Eslate_preparatrion_MainActivity.class);
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
		 final Dialog dialog = new Dialog(ShapeIntroBegineActivity.this,AlertDialog.THEME_HOLO_LIGHT);
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
				
				finish();
				System.exit(0);
				}
	     	});
		} 
	}