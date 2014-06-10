package eslate.colorintro;

import eslate.colortest.ColorTestOneActivity;
import eslate.main.R;
import eslate.videotrack.database.VideoDatabaseHandler;
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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ColorIntro_BegineActivity extends Activity{
		ImageButton begine;
		ImageView dorago;
		Animation animation; 
		Button skip;
		MediaPlayer mediaplayer;
		


@Override
protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ci_colorintro_begine_layout);
		
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);		
		
		begine = (ImageButton)findViewById(R.id.begine);
		begine.setVisibility(View.GONE); 
		dorago = (ImageView)findViewById(R.id.dorago);
		skip=(Button)findViewById(R.id.skip);
		skip.setVisibility(View.GONE);
		
		VideoDatabaseHandler handler=new VideoDatabaseHandler(this);
		int count =handler.getColorIDCOunt();
		if(count==1)
		{
			skip.setVisibility(View.VISIBLE);
		}
		handler.close();
		
		animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.ci_blink);
		
		skip = (Button)findViewById(R.id.skip);
		skip.setOnClickListener(new OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			mediaplayer.stop();
			mediaplayer.release();
			animation.cancel();
			
			Intent skip = new Intent(ColorIntro_BegineActivity.this, ColorTestOneActivity.class);
			skip.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(skip);
			finish();
				}
			});
		Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.colour_intro);
		mediaplayer=MediaPlayer.create(ColorIntro_BegineActivity.this, path);
		mediaplayer.start();
		mediaplayer.setOnCompletionListener(new OnCompletionListener() {
			
			@Override
			public void onCompletion(MediaPlayer mp) {
			begine.setVisibility(View.VISIBLE);
			begine.startAnimation(animation);
			}
		});
		begine.setOnClickListener(new OnClickListener() {
		@Override
		public void onClick(View v) {
			mediaplayer.stop();
			mediaplayer.release();
			
			Intent next = new Intent(ColorIntro_BegineActivity.this, BasicColor.class);
			next.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
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
		if (animation.hasStarted()) {
			animation.cancel();
		}
		if(mediaplayer.isPlaying())
		{
			mediaplayer.stop();
			mediaplayer.release();
		}
		Intent home=new Intent(ColorIntro_BegineActivity.this,eslate.preparation.main.Eslate_preparatrion_MainActivity.class);
		home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(home);
		finish();
		//return true;
								}
		}
		return super.onOptionsItemSelected(item);
	}
@SuppressLint("InlinedApi")
@Override
public void onBackPressed() {
	 final Dialog dialog = new Dialog(ColorIntro_BegineActivity.this,AlertDialog.THEME_HOLO_LIGHT);
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
			if (animation.hasStarted()) {
				animation.cancel();
			}
			/*if(mediaplayer.isPlaying())
			{
				mediaplayer.stop();
			}*/
			finish();
			System.exit(0);
			}
     	});
	} 
}
