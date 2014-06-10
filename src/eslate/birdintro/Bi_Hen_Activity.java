package eslate.birdintro;

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
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import eslate.main.R;

//hen introduction activity
public class Bi_Hen_Activity extends Activity {
	
	ImageView hen,hentext;
	MediaPlayer mediaPlayer;
	Animation slidedown;

	@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.bi_hen5_activity);
	
	setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
	
	Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.hen);
	mediaPlayer=MediaPlayer.create(Bi_Hen_Activity.this, path);
	mediaPlayer.start();
	
	hen=(ImageView)findViewById(R.id.hen);
	
	hentext = (ImageView)findViewById(R.id.hentext);
	
	slidedown = AnimationUtils.loadAnimation(this,R.anim.bi_slidedown);
	slidedown.setStartOffset(2000);
	slidedown.setDuration(2000);
	
	hen.startAnimation(slidedown);
	
	mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
	@Override
	public void onCompletion(MediaPlayer mp) {
	mediaPlayer.stop();
	mediaPlayer.release();
	slidedown.cancel();
	//after completion of this audio it will switch to eagle activity
	Intent intent=new Intent(Bi_Hen_Activity.this,Bi_Chil_Activity.class);
	intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
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
			if (slidedown.hasStarted()) {
				slidedown.cancel();
			}
			if(mediaPlayer.isPlaying())
			{
				mediaPlayer.stop();
			}
			Intent home=new Intent(Bi_Hen_Activity.this,eslate.preparation.main.Eslate_preparatrion_MainActivity.class);
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
		 final Dialog dialog = new Dialog(Bi_Hen_Activity.this,AlertDialog.THEME_HOLO_LIGHT);
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
				if (slidedown.hasStarted()) {
					slidedown.cancel();
				}
				if(mediaPlayer.isPlaying())
				{
					mediaPlayer.stop();
				}
				finish();
				System.exit(0);
				}
	     	});
		} 
	}