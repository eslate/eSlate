package eslate.ablrconcepttest;

import eslate.main.R;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer;
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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ABLRtest2_Activity extends Activity implements OnClickListener {
    ImageView line, bowl, lamp;
    MediaPlayer mediaPlayer;
    boolean hasOnce=false;
    
@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.ablrtest2_activity);
	setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
	
	line = (ImageView)findViewById(R.id.line);
	
	lamp = (ImageView)findViewById(R.id.lamp);
	lamp.setEnabled(false);
	lamp.setOnClickListener(this);
	
	bowl = (ImageView)findViewById(R.id.bowl);
	bowl.setEnabled(false);
	bowl.setOnClickListener(this);	
	
	Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.concept_q2);
	mediaPlayer=MediaPlayer.create(ABLRtest2_Activity.this, path);
	mediaPlayer.start();
		
	mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
	@Override
	public void onCompletion(MediaPlayer mp) {
		mediaPlayer.stop();
		mediaPlayer.release();
			
		lamp.setEnabled(true);
		bowl.setEnabled(true);
		}
	});
}

@Override
public void onClick(View v) {
	// TODO Auto-generated method stub
	if(hasOnce==false)
	{
		hasOnce=true;
	switch (v.getId()) {
	case R.id.lamp:
		Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.congrats);
		mediaPlayer=MediaPlayer.create(ABLRtest2_Activity.this, path);
		mediaPlayer.start();
		mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
		@Override
		public void onCompletion(MediaPlayer mp) {
    		Intent intent=new Intent(ABLRtest2_Activity.this,ABLRtest3_Activity.class);
    		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    		startActivity(intent);
    		finish();
			}
		});
		break;
		
	case R.id.bowl:
		Uri path1=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.sorry);
		mediaPlayer=MediaPlayer.create(ABLRtest2_Activity.this, path1);
		mediaPlayer.start();
		mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
		@Override
		public void onCompletion(MediaPlayer mp) {
    		hasOnce=false;
		       }
	     	});
			
	    break;
	default:
		break;
			}
		} 
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
		
		Intent home=new Intent(ABLRtest2_Activity.this,eslate.preparation.main.Eslate_preparatrion_MainActivity.class);
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
	 final Dialog dialog = new Dialog(ABLRtest2_Activity.this,AlertDialog.THEME_HOLO_LIGHT);
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
		
			finish();
			System.exit(0);
			}
     	});
	} 
}
