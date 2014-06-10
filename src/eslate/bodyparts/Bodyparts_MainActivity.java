package eslate.bodyparts;

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

public class Bodyparts_MainActivity extends Activity implements OnClickListener {
	Button lowerbody_btn,middlebody_btn,upperbody_btn;
	ImageView body;
	MediaPlayer mediaplayer;
	boolean hasonce =false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bp_main_layout);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);					 
		
		body = (ImageView)findViewById(R.id.body);
		body.setEnabled(false);
		body.setOnClickListener(this);
		
		upperbody_btn = (Button)findViewById(R.id.upperbody_btn);
		upperbody_btn.setVisibility(View.GONE);
		upperbody_btn.setOnClickListener(this);
		
		middlebody_btn = (Button)findViewById(R.id.middlebody_btn);
		middlebody_btn.setVisibility(View.GONE);
		middlebody_btn.setOnClickListener(this);
		
		lowerbody_btn = (Button)findViewById(R.id.lowerbody_btn);
		lowerbody_btn.setVisibility(View.GONE);
		lowerbody_btn.setOnClickListener(this);
		
		Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.body_intro1);
		mediaplayer=MediaPlayer.create(Bodyparts_MainActivity.this, path);
		mediaplayer.start();
		mediaplayer.setOnCompletionListener(new OnCompletionListener() {
		@Override
		public void onCompletion(MediaPlayer mp) {
			// TODO Auto-generated method stub
			mediaplayer.stop();
			mediaplayer.release();
			
			Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.body_intro2);
			mediaplayer=MediaPlayer.create(Bodyparts_MainActivity.this, path);
			mediaplayer.start();
			mediaplayer.setOnCompletionListener(new OnCompletionListener() {
			@Override
			public void onCompletion(MediaPlayer mp) {
			
				body.setEnabled(true);
				upperbody_btn.setVisibility(View.VISIBLE);
				middlebody_btn.setVisibility(View.VISIBLE);
				lowerbody_btn.setVisibility(View.VISIBLE);
					
				}
			});

			}
		});
	}
	@Override
	public void onClick(final View v) {
		// TODO Auto-generated method stub	
	if(hasonce==false){
		hasonce=true;
		switch (v.getId()) {
		case R.id.body:
			mediaplayer.stop();
			mediaplayer.release();
			
				Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.body_intro1);
				mediaplayer=MediaPlayer.create(Bodyparts_MainActivity.this, path);
				mediaplayer.start();
				mediaplayer.setOnCompletionListener(new OnCompletionListener() {
				@Override
				public void onCompletion(MediaPlayer mp) {
					hasonce=false;
					}
				});
			break;
		
		case R.id.upperbody_btn:
				mediaplayer.stop();
				mediaplayer.release();
				
				Intent upperbody = new Intent(Bodyparts_MainActivity.this, Bodyparts_Upper_Activity.class);
				upperbody.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(upperbody);
				finish();
			break;
			
		case R.id.middlebody_btn:
				mediaplayer.stop();
				mediaplayer.release();
				
				Intent middlebody = new Intent(Bodyparts_MainActivity.this, Bodyparts_Middle_Activity.class);
				middlebody.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(middlebody);
				finish();
			break;
			
		case R.id.lowerbody_btn:
				mediaplayer.stop();
				mediaplayer.release();
				
				Intent lowerbody = new Intent(Bodyparts_MainActivity.this, Bodyparts_Lower_Activity.class);
				lowerbody.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(lowerbody);
				finish();
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
			if (mediaplayer.isPlaying()) {
				mediaplayer.stop();
				mediaplayer.release();
			}
			
			Intent home=new Intent(Bodyparts_MainActivity.this,eslate.preparation.main.Eslate_preparatrion_MainActivity.class);
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
		 final Dialog dialog = new Dialog(Bodyparts_MainActivity.this,AlertDialog.THEME_HOLO_LIGHT);
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
				if (mediaplayer.isPlaying()) {
					mediaplayer.stop();
					mediaplayer.release();
				}
				finish();
				System.exit(0);
				}
	     	});
		} 
	}
