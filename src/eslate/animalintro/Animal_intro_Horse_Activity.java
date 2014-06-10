package eslate.animalintro;

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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

//horse introduction activity
public class Animal_intro_Horse_Activity  extends Activity {
	ImageView horse,horsetext;
	MediaPlayer mediaPlayer;
	Toast toast;
	AnimationSet set;
	Animation rotation;
	TranslateAnimation moveLefttoRight;	

	@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.animal_intro_horse_layout);
	setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
	
	Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.horse);
	mediaPlayer=MediaPlayer.create(Animal_intro_Horse_Activity.this, path);
	mediaPlayer.start();
	horse=(ImageView)findViewById(R.id.horse);
	
	horsetext = (ImageView)findViewById(R.id.texthorse);
	
	//setting animation to horse image
	set = new AnimationSet(true);
	set.setFillAfter(true);
    
	rotation = AnimationUtils.loadAnimation(this, R.anim.animal_rotation);
    rotation.setStartOffset(2000);
    rotation.setDuration(2000);
    
    moveLefttoRight = new TranslateAnimation(0, 200, 0, 0);
    moveLefttoRight.setStartOffset(1000);
    moveLefttoRight.setDuration(1000);
    set.addAnimation(moveLefttoRight);
    set.addAnimation(rotation);
    horse.startAnimation(set);
    
    mediaPlayer.setOnCompletionListener(new OnCompletionListener() {	
    @Override
    public void onCompletion(MediaPlayer mp) {
	mediaPlayer.stop();
	set.cancel();
	rotation.cancel();
	moveLefttoRight.cancel();
	
	//after completion of this audio it will switch to cow intro activity
	Intent intent=new Intent(Animal_intro_Horse_Activity.this,Animal_intro_Cow_Activity.class);
	intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	startActivity(intent);
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
			if (rotation.hasStarted()) {
				rotation.cancel();
			}
			if(mediaPlayer.isPlaying())
			{
				mediaPlayer.stop();
				mediaPlayer.release();
			}
			
			Intent home=new Intent(Animal_intro_Horse_Activity.this,eslate.preparation.main.Eslate_preparatrion_MainActivity.class);
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
		 final Dialog dialog = new Dialog(Animal_intro_Horse_Activity.this,AlertDialog.THEME_HOLO_LIGHT);
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
				if (rotation.hasStarted()) {
					rotation.cancel();
				}
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