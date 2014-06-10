package eslate.shapetest;

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
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ShapeTestTwoActivity extends Activity implements OnClickListener{
	MediaPlayer mediaPlayer;
	Toast toast;
	ImageButton imagebtn,circlebtn, trianlebtn, squarebtn,rectaglebtn,ovalbtn,starbtn;
@Override
protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.shapetesttwo_layout);
		
		circlebtn = (ImageButton)findViewById(R.id.circlebtn);
		circlebtn.setOnClickListener(this);
		
		trianlebtn = (ImageButton)findViewById(R.id.trianglebtn);
		trianlebtn.setOnClickListener(this);
		
		ovalbtn = (ImageButton)findViewById(R.id.ovalbtn);
		ovalbtn.setOnClickListener(this);
		
		rectaglebtn = (ImageButton)findViewById(R.id.rectanglebtn);
		rectaglebtn.setOnClickListener(this);
		
		squarebtn = (ImageButton)findViewById(R.id.squarebtn);
		squarebtn.setOnClickListener(this);	
		
		circlebtn.setEnabled(false);
		trianlebtn.setEnabled(false);
		ovalbtn.setEnabled(false);
		rectaglebtn.setEnabled(false);
		squarebtn.setEnabled(false);
		
		Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.triangleques);
		mediaPlayer=MediaPlayer.create(getApplicationContext(), path);
		mediaPlayer.start();
		mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
			
		@Override
		public void onCompletion(MediaPlayer mp) {
		mediaPlayer.stop();
		mediaPlayer.release();
		
		circlebtn.setEnabled(true);
		trianlebtn.setEnabled(true);
		ovalbtn.setEnabled(true);
		rectaglebtn.setEnabled(true);
		squarebtn.setEnabled(true);
				
			}
		});
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
	}
public void m1()
	{
		LayoutInflater inflater = getLayoutInflater();
    	View layout = inflater.inflate(R.layout.st_toast_layout,(ViewGroup) findViewById(R.id.toast_layout_root));
    	ImageView image = (ImageView) layout.findViewById(R.id.toastimage);
    	image.setBackgroundColor(Color.TRANSPARENT);
    	toast = new Toast(getApplicationContext()); 
		toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0); 
		toast.setView(layout); 
		toast.setGravity(Gravity.LEFT, 0, 0);
		toast.show();
	}
@Override
public void onClick(final View v) {
		switch(v.getId()){
        case R.id.circlebtn:
				        	Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.wrong);
							mediaPlayer=MediaPlayer.create(ShapeTestTwoActivity.this, path);
							mediaPlayer.start();
							v.setEnabled(false);
							squarebtn.setEnabled(false);
							trianlebtn.setEnabled(false);
							ovalbtn.setEnabled(false);
							rectaglebtn.setEnabled(false);
							mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
							@Override
							public void onCompletion(MediaPlayer mp) {
							mediaPlayer.stop();
							mediaPlayer.release();
									
							Intent act2 = new Intent(ShapeTestTwoActivity.this,ShapeTestTwoActivity.class);
							act2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
							startActivity(act2);
							finish();
							}
							});							
							break;
		case R.id.ovalbtn:
							Uri path1=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.wrong);
							mediaPlayer=MediaPlayer.create(ShapeTestTwoActivity.this, path1);
							mediaPlayer.start();
							
							v.setEnabled(false);
							squarebtn.setEnabled(false);
							trianlebtn.setEnabled(false);
							circlebtn.setEnabled(false);
							rectaglebtn.setEnabled(false);
							mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
							@Override
							public void onCompletion(MediaPlayer mp) {
							mediaPlayer.stop();
							mediaPlayer.release();
							
							Intent act2 = new Intent(ShapeTestTwoActivity.this,ShapeTestTwoActivity.class);
							act2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
							startActivity(act2);
							finish();
							}
							});
				        break;
        case R.id.squarebtn:
        					Uri path2=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.wrong);
        					mediaPlayer=MediaPlayer.create(ShapeTestTwoActivity.this, path2);
        					mediaPlayer.start();
        					v.setEnabled(false);
        					circlebtn.setEnabled(false);
        					trianlebtn.setEnabled(false);
        					ovalbtn.setEnabled(false);
        					rectaglebtn.setEnabled(false);
        					mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
        					@Override
        					public void onCompletion(MediaPlayer mp) {
        						mediaPlayer.stop();
    							mediaPlayer.release();
    									
        						Intent act2 = new Intent(ShapeTestTwoActivity.this,ShapeTestTwoActivity.class);
        						act2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        						startActivity(act2);
        						finish();
        						}
        						});
        					break;
        case R.id.rectanglebtn:
        					Uri path3=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.wrong);
        					mediaPlayer=MediaPlayer.create(ShapeTestTwoActivity.this, path3);
        					mediaPlayer.start();
        					v.setEnabled(false);
        					squarebtn.setEnabled(false);
        					trianlebtn.setEnabled(false);
        					ovalbtn.setEnabled(false);
        					circlebtn.setEnabled(false);
        					mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
        					@Override
        					public void onCompletion(MediaPlayer mp) {
        						mediaPlayer.stop();
    							mediaPlayer.release();
    										
        						Intent act2 = new Intent(ShapeTestTwoActivity.this,ShapeTestTwoActivity.class);
        						act2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        						startActivity(act2);
        						finish();
								}
        						});
        					break;
        case R.id.trianglebtn: 
        					Uri path4=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.congrats);
        					mediaPlayer=MediaPlayer.create(ShapeTestTwoActivity.this, path4);
        					this.m1();
        					mediaPlayer.start();
        					
                            v.setEnabled(false);
        					squarebtn.setEnabled(false);
        					squarebtn.setVisibility(View.GONE);
        					circlebtn.setEnabled(false);
        					circlebtn.setVisibility(View.GONE);
        					ovalbtn.setEnabled(false);
        					ovalbtn.setVisibility(View.GONE);
        					rectaglebtn.setEnabled(false);
        					rectaglebtn.setVisibility(View.GONE);
        					mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
        					@Override
        					public void onCompletion(MediaPlayer mp) {
        						mediaPlayer.stop();
    							mediaPlayer.release();
    							toast.cancel();
        						Intent act2 = new Intent(ShapeTestTwoActivity.this,ShapeTestThreeActivity.class);
        						act2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        						startActivity(act2);
        						finish();
        						}
        						});
        					break;
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
		if(mediaPlayer.isPlaying())
		{
			mediaPlayer.stop();
			mediaPlayer.release();
		}
		Intent home=new Intent(ShapeTestTwoActivity.this,eslate.preparation.main.Eslate_preparatrion_MainActivity.class);
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
	 final Dialog dialog = new Dialog(ShapeTestTwoActivity.this,AlertDialog.THEME_HOLO_LIGHT);
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
