package eslate.shapetestsecond;

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
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

//identify rectangle shape question
public class ShapeTestSecondTwoActivity extends Activity implements OnClickListener,OnPreparedListener{
	
	MediaPlayer mediaPlayer=new MediaPlayer();
	ImageButton imagebtn,redpillow,tree,wallclk;
	boolean hasOnce=false;
	public static int ques2=0;
@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.shapetest_second_two_layout);
		
	redpillow = (ImageButton)findViewById(R.id.redpillow);
	redpillow.setOnClickListener(this);
		
	wallclk = (ImageButton)findViewById(R.id.wallclk);
	wallclk.setOnClickListener(this);
		
	tree = (ImageButton)findViewById(R.id.tree);
	tree.setOnClickListener(this);	
	
	redpillow.setEnabled(false);
	wallclk.setEnabled(false);
	tree.setEnabled(false);
	
	Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.squarequestion);
	mediaPlayer=MediaPlayer.create(ShapeTestSecondTwoActivity.this, path);
	mediaPlayer.start();
	mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
		
	@Override
	public void onCompletion(MediaPlayer mp) {
	mediaPlayer.stop();
	mediaPlayer.release();
	
	redpillow.setEnabled(true);
	wallclk.setEnabled(true);
	tree.setEnabled(true);
		}
	});
	
		
	setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
	}

@Override
public void onClick(final View v) {
	if(hasOnce==false)
		{
		hasOnce=true;
	switch(v.getId()){
	case R.id.redpillow:
        	Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.congrats);
        	ques2++;
        	ShapeTestSecondOneActivity.score++;
        	mediaPlayer=MediaPlayer.create(ShapeTestSecondTwoActivity.this, path);
        	onPrepared(mediaPlayer);
        	mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
        		@Override
        		public void onCompletion(MediaPlayer mp) {
        			if(mediaPlayer.isPlaying())
        			{
        				mediaPlayer.release();
        			}
        			
        			Intent act2 = new Intent(ShapeTestSecondTwoActivity.this,ShapeTestSecondThreeActivity.class);
        			act2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        			startActivity(act2);
        			finish();
					}
        		});							
    break;
	case R.id.tree:
			Uri path2=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.sorry_2);
			mediaPlayer=MediaPlayer.create(ShapeTestSecondTwoActivity.this, path2);
			onPrepared(mediaPlayer);
			mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
				@Override
				public void onCompletion(MediaPlayer mp) {
					if(mediaPlayer.isPlaying())
					{
						mediaPlayer.release();
					}
					
					Intent act2 = new Intent(ShapeTestSecondTwoActivity.this,ShapeTestSecondThreeActivity.class);
					act2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					startActivity(act2);
					finish();
					}
				});
	break;
	case R.id.wallclk:
			Uri path3=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.sorry_2);
			mediaPlayer=MediaPlayer.create(ShapeTestSecondTwoActivity.this, path3);
			onPrepared(mediaPlayer);
			mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
				@Override
				public void onCompletion(MediaPlayer mp) {
					if(mediaPlayer.isPlaying())
					{
						mediaPlayer.release();
					}
					
					Intent act2 = new Intent(ShapeTestSecondTwoActivity.this,ShapeTestSecondThreeActivity.class);
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

@SuppressLint("InlinedApi")
@Override
public void onBackPressed() {
	 final Dialog dialog = new Dialog(ShapeTestSecondTwoActivity.this,AlertDialog.THEME_HOLO_LIGHT);
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
	