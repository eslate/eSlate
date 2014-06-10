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
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

//identify circle shape question
public class ShapeTestSecondFourActivity extends Activity implements OnClickListener{
	
	MediaPlayer mediaPlayer=new MediaPlayer();
	ImageButton imagebtn,redpillow, tire, tree;
	public static int ques4=0;
	boolean hasOnce=false;
@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.shapetest_second_four_layout);
	
	redpillow = (ImageButton)findViewById(R.id.redpillow);
	redpillow.setOnClickListener(this);
		
	tire = (ImageButton)findViewById(R.id.tire);
	tire.setOnClickListener(this);
		
	tree = (ImageButton)findViewById(R.id.tree);
	tree.setOnClickListener(this);	
		
	redpillow.setEnabled(false);
	tree.setEnabled(false);
	tire.setEnabled(false);

	Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.circlequestion);
	mediaPlayer=MediaPlayer.create(ShapeTestSecondFourActivity.this, path);
	mediaPlayer.start();
	mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
		
	@Override
	public void onCompletion(MediaPlayer mp) {
	mediaPlayer.stop();
	mediaPlayer.release();
	
	redpillow.setEnabled(true);
	tree.setEnabled(true);
	tire.setEnabled(true);
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
    	Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.sorry_2);		
    	mediaPlayer=MediaPlayer.create(ShapeTestSecondFourActivity.this, path);
		mediaPlayer.start();
		mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
			@Override
			public void onCompletion(MediaPlayer mp) {
				mediaPlayer.stop();
				
				Intent act2 = new Intent(ShapeTestSecondFourActivity.this,ShapeScoreActivity.class);
				act2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(act2);
				finish();
				}
			});							
	break;
		
    case R.id.tree:
    	Uri path2=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.sorry_2);
    	mediaPlayer=MediaPlayer.create(ShapeTestSecondFourActivity.this, path2);
    	mediaPlayer.start();
    	mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
    		@Override
    		public void onCompletion(MediaPlayer mp) {
    			mediaPlayer.stop();
    			
    			Intent act2 = new Intent(ShapeTestSecondFourActivity.this,ShapeScoreActivity.class);
    			act2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    			startActivity(act2);
    			finish();
				}
    		});
    break;
        
    case R.id.tire:
    	Uri path4=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.congrats);
    	ques4++;
    	ShapeTestSecondOneActivity.score++;
    	mediaPlayer=MediaPlayer.create(ShapeTestSecondFourActivity.this, path4);
    	mediaPlayer.start();
    	mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
    		@Override
    		public void onCompletion(MediaPlayer mp) {
    			mediaPlayer.stop();
    			
    			Intent act2 = new Intent(ShapeTestSecondFourActivity.this,ShapeScoreActivity.class);
    			act2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    			startActivity(act2);
    			finish();
				}
    		});
    break;
			}
		}
	}
@SuppressLint("InlinedApi")
@Override
public void onBackPressed() {
	 final Dialog dialog = new Dialog(ShapeTestSecondFourActivity.this,AlertDialog.THEME_HOLO_LIGHT);
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
	