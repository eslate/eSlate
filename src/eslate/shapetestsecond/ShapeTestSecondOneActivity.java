package eslate.shapetestsecond;

import eslate.main.R;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

//in this shapeTestSecondOneActivity it is second shape test in which the score get recorded in database
//identification  of circle shape
public class ShapeTestSecondOneActivity extends Activity implements OnClickListener,OnPreparedListener{
	
	public static  int score=0;
	//this boolean variable is to avoid multiple click at time on button.
	boolean hasOnce=false;
	public static int ques1=0;
	MediaPlayer mediaPlayer;
	//here these imagebuttons are taken as imageviews for circle shape with refrence to a real life object
	ImageButton imagebtn,yellowpillow,tree,wallclk;
@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.shapetest_second_one_layout);
	yellowpillow = (ImageButton)findViewById(R.id.yellowpillow);
	yellowpillow.setBackgroundColor(Color.TRANSPARENT);
	yellowpillow.setOnClickListener(this);
		
	wallclk = (ImageButton)findViewById(R.id.wallclk);
	wallclk.setOnClickListener(this);
		
	tree = (ImageButton)findViewById(R.id.tree);
	tree.setOnClickListener(this);	
	
	yellowpillow.setEnabled(false);
	wallclk.setEnabled(false);
	tree.setEnabled(false);
	Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.circlequestion);
	mediaPlayer=MediaPlayer.create(ShapeTestSecondOneActivity.this, path);
	
	mediaPlayer.start();
	mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
		
	@Override
	public void onCompletion(MediaPlayer mp) {
	mediaPlayer.stop();
	mediaPlayer.release();
	yellowpillow.setEnabled(true);
	wallclk.setEnabled(true);
	tree.setEnabled(true);
	
		}
	});
	setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
	}

@Override
public void onClick(final View v) {
	//since value of hasonce is false it gets true and the below code will get execute.and again we make hasonce value
	//true so next click on the same screen it will check the condition and it becomes false and hence so forth further
	//code will not get execute
		if(hasOnce==false)
		{
			hasOnce=true;
	switch(v.getId()){
    case R.id.yellowpillow:
			Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.sorry_2);
			mediaPlayer=MediaPlayer.create(ShapeTestSecondOneActivity.this, path);
			onPrepared(mediaPlayer);
			mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
			@Override
			public void onCompletion(MediaPlayer mp) {
				if(mediaPlayer.isPlaying())
				{
					mediaPlayer.release();
				}
				Intent act2 = new Intent(ShapeTestSecondOneActivity.this,ShapeTestSecondTwoActivity.class);
				act2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(act2);
				finish();
			}
			});							
	break;
		
    case R.id.tree:
    		Uri path2=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.sorry_2);
        	mediaPlayer=MediaPlayer.create(ShapeTestSecondOneActivity.this, path2);
        	onPrepared(mediaPlayer);
        	mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
        	@Override
        	public void onCompletion(MediaPlayer mp) {
        	if(mediaPlayer.isPlaying())
			{
			mediaPlayer.release();
			}
        	
        	//it will switch to next screen that is next question
        	Intent act2 = new Intent(ShapeTestSecondOneActivity.this,ShapeTestSecondTwoActivity.class);
        	act2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        	startActivity(act2);
        	finish();
        	}
        	});
    break;
     
    case R.id.wallclk:
        	Uri path3=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.congrats);
        	ques1++;
        	score++;
        	mediaPlayer=MediaPlayer.create(ShapeTestSecondOneActivity.this, path3);
        	onPrepared(mediaPlayer);
        	mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
        	@Override
        	public void onCompletion(MediaPlayer mp) {
        	if(mediaPlayer.isPlaying())
        	{
        		mediaPlayer.release();
        	}
        	Intent act2 = new Intent(ShapeTestSecondOneActivity.this,ShapeTestSecondTwoActivity.class);
        	act2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        	startActivity(act2);
        	finish();
        	}
        	});
     break;
     		}
		}
	}
@Override
public void onPrepared(MediaPlayer mp) {
			mediaPlayer.start();
		}
/*@Override
public boolean onCreateOptionsMenu(Menu menu) {
	getMenuInflater().inflate(R.menu.main, menu);
	return true;
	}

@Override
public boolean onOptionsItemSelected(MenuItem item) {
	switch (item.getItemId()) {
	case R.id.home:
	{
		if (mediaPlayer.isPlaying()) {
			mediaPlayer.stop();
		}
	
	Intent intent1=new Intent(ShapeTestSecondOneActivity.this,eslate.preparation.main.Eslate_preparatrion_MainActivity.class);
	intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	startActivity(intent1);
	finish();
	return true;
	}
	}
	return super.onOptionsItemSelected(item);
}*/

@SuppressLint("InlinedApi")
@Override
public void onBackPressed() {
	 final Dialog dialog = new Dialog(ShapeTestSecondOneActivity.this,AlertDialog.THEME_HOLO_LIGHT);
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
		
			if(mediaPlayer.isPlaying())
			{
				mediaPlayer.stop();
				mediaPlayer.release();
			}
			finish();
			System.exit(0);
			}
     	});
	} 
}
		